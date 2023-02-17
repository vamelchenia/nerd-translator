package com.llcompany.nerdtranslator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.view.animation.AlphaAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.llcompany.nerdtranslator.databinding.FragmentTranslateBinding;

import java.util.ArrayList;
import java.util.List;

public class TranslateFragment extends Fragment {

    private FragmentTranslateBinding binding;
    private Communicator fragmentCommunicator;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentTranslateBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentCommunicator = (Communicator) getActivity();

        final String[] defaultSourceLanguageCode = {"en"};
        final String[] defaultTargetLanguageCode = {"fr"};

        final Language[] selectedSourceLanguage = {null};
        final Language[] selectedTargetLanguage = {null};

        final List<Language>[] targetLanguages = new List[]{new ArrayList<Language>()};

        //  Slow animation
        AlphaAnimation animationImageView = new AlphaAnimation(0f, 1.0f);
        animationImageView.setDuration(500);
        // If need offset
        //animationImageView.setStartOffset(1000);
        animationImageView.setFillAfter(true);
        binding.translateLayout.startAnimation(animationImageView);

        // Fill all languages for source language
        if (fragmentCommunicator.checkInternetConnection()) {
            fragmentCommunicator.getTranslateService();

            // Example to get string from strings.xml
            // String[] catNames = getResources().getStringArray(R.array.cat_names);

            List<Language> sourceLanguages = fragmentCommunicator.getSupportedLanguages();

            ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(binding.sourceLanguageSpinner.getContext(), android.R.layout.simple_spinner_dropdown_item, fragmentCommunicator.getSupportedLanguagesNames(sourceLanguages));
            dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            binding.sourceLanguageSpinner.setAdapter(dataAdapter);

            int selectedLanguageIndex = 0;
            if (selectedSourceLanguage[0] == null) {
                Language defaultSourceLanguage = sourceLanguages.stream().filter(language -> defaultSourceLanguageCode[0].equals(language.getCode())).findAny().orElse(null);
                selectedLanguageIndex = sourceLanguages.indexOf(defaultSourceLanguage);
            } else {
                selectedLanguageIndex = sourceLanguages.indexOf(selectedSourceLanguage[0]);
            }
            binding.sourceLanguageSpinner.setSelection(selectedLanguageIndex);

            binding.sourceLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                                           View itemSelected, int selectedItemPosition, long selectedId) {

                    selectedSourceLanguage[0] = sourceLanguages.get(selectedItemPosition);
                    targetLanguages[0] = fragmentCommunicator.getSupportedLanguages(Translate.LanguageListOption.targetLanguage(selectedSourceLanguage[0].getCode()));

                    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(binding.targetLanguageSpinner.getContext(), android.R.layout.simple_spinner_dropdown_item, fragmentCommunicator.getSupportedLanguagesNames(targetLanguages[0]));
                    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    binding.targetLanguageSpinner.setAdapter(dataAdapter);

                    int selectedLanguageIndex = 0;
                    if (selectedTargetLanguage[0] == null) {
                        Language defaultTargetLanguage = targetLanguages[0].stream().filter(language -> defaultTargetLanguageCode[0].equals(language.getCode())).findAny().orElse(null);
                        selectedLanguageIndex = targetLanguages[0].indexOf(defaultTargetLanguage);
                        selectedTargetLanguage[0] = defaultTargetLanguage;
                    } else {
                        Language selectedFindTargetLanguage = targetLanguages[0].stream().filter(language -> selectedTargetLanguage[0].getCode().equals(language.getCode())).findAny().orElse(null);
                        selectedLanguageIndex = targetLanguages[0].indexOf(selectedFindTargetLanguage);
                    }
                    binding.targetLanguageSpinner.setSelection(selectedLanguageIndex);

                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            binding.targetLanguageSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                public void onItemSelected(AdapterView<?> parent,
                                           View itemSelected, int selectedItemPosition, long selectedId) {
                    selectedTargetLanguage[0] = targetLanguages[0].get(selectedItemPosition);
                }

                public void onNothingSelected(AdapterView<?> parent) {
                }
            });

            binding.lostConnectionLayout.setVisibility(View.GONE);
            binding.translateOutputLayout.setVisibility(View.VISIBLE);
        } else {
            binding.lostConnectionLayout.setVisibility(View.VISIBLE);
            binding.translateOutputLayout.setVisibility(View.GONE);
        }

        binding.translateButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (binding.translateOutputLayout.getVisibility() != View.VISIBLE) {
                    binding.translateOutputLayout.setVisibility(View.VISIBLE);
                }

                ViewGroup.LayoutParams translateTextLayoutParams = (ViewGroup.LayoutParams) binding.translateTextLayout.getLayoutParams();
                ViewGroup.LayoutParams translateInputLayoutParams = (ViewGroup.LayoutParams) binding.translateInputLayout.getLayoutParams();
                translateTextLayoutParams.height = LinearLayout.LayoutParams.WRAP_CONTENT;
                translateInputLayoutParams.height = RelativeLayout.LayoutParams.WRAP_CONTENT;
                binding.translateTextLayout.setLayoutParams(translateTextLayoutParams);
                binding.translateInputLayout.setLayoutParams(translateInputLayoutParams);

                binding.translateEditText.setMaxHeight((int) getResources().getDimension(R.dimen.translateEditText_max_height));

                //  Close keyboard and clear focus
                InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);

                binding.translateEditText.clearFocus();

                //  Translate text
                if (fragmentCommunicator.checkInternetConnection()) {
                    fragmentCommunicator.getTranslateService();
                    binding.translateOutputTextView.setText(fragmentCommunicator.getTranslatedText(binding.translateEditText.getText().toString(), selectedSourceLanguage[0], selectedTargetLanguage[0]));

                    binding.lostConnectionLayout.setVisibility(View.GONE);
                    binding.translateOutputLayout.setVisibility(View.VISIBLE);
                } else {
                    binding.lostConnectionLayout.setVisibility(View.VISIBLE);
                    binding.translateOutputLayout.setVisibility(View.GONE);
                }

//  //  For margin
//                ViewGroup.MarginLayoutParams translateTextMarginLayoutParams = (ViewGroup.MarginLayoutParams) binding.translateTextLayout.getLayoutParams();
//                translateTextMarginLayoutParams.setMargins(translateTextMarginLayoutParams.leftMargin,
//                        translateTextMarginLayoutParams.topMargin,
//                        translateTextMarginLayoutParams.rightMargin,
//                        (int) getResources().getDimension(R.dimen.translateTextLayout_margin_bottom));
//
//                view.requestLayout();
//
//  //  For padding
//                binding.translateEditText.setPadding((int) getResources().getDimension(R.dimen.translateEditText_padding_left_right),
//                        (int) getResources().getDimension(R.dimen.translateEditText_padding_top),
//                        (int) getResources().getDimension(R.dimen.translateEditText_padding_left_right),
//                        (int) getResources().getDimension(R.dimen.translateEditText_padding_bottom_short));

            }
        });

//        binding.translateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(final View v, final boolean hasFocus) {
//                if (hasFocus) {
//                    translateEditText = fragmentCommunicator.getTranslateText();
//                    if (translateEditText.isEmpty()) {
//                        translateTextView.setText(translateEditText);
//                    }
//                    translateTextView.setTextColor(translateTextColor);
//                } else {
//                    String translateTextViewString = translateTextView.getText().toString();
//                    fragmentCommunicator.setTranslateText(translateTextViewString);
//                    if (translateTextViewString.isEmpty()) {
//                        translateTextView.setText(translatePlaceHolderText);
//                        translateTextView.setTextColor(translatePlaceHolderColor);
//                    }
//                }
//            }
//        });

        binding.exitButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(TranslateFragment.this)
                        .navigate(R.id.action_TranslateFragment_to_WelcomeFragment);
            }
        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

//  //  Fill ListView
//        String[] catNames = getResources().getStringArray(R.array.cat_names);
//        ListView translateOutputListView = binding.TranslateLayout.findViewById(R.id.translateOutputListView);
//        ArrayAdapter<String> adapter = new ArrayAdapter(binding.translateOutputListView.getContext(), android.R.layout.simple_list_item_1, catNames);
//        translateOutputListView.setAdapter(adapter);
//        // For choice ListView
//        countriesList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
//          String selectedItem = countries[position];
//          selection.setText(selectedItem);
//          }
//        });

//  //  Saving data through fragments
//        fragmentCommunicator = (Communicator) getActivity();
//        resources = view.getResources();
//
//        int translateTextColor = resources.getColor(R.color.translateText, null);
//        int translatePlaceHolderColor = resources.getColor(R.color.placeHolder, null);
//        String translatePlaceHolderText = resources.getString(R.string.translatePlaceHolder);
//
//        TextView translateTextView = binding.preTranslateLayout.findViewById(R.id.translateEditText);
//
//        translateEditText = fragmentCommunicator.getTranslateText();
//        if (translateEditText.isEmpty()) {
//            translateTextView.setText(translatePlaceHolderText);
//            translateTextView.setTextColor(translatePlaceHolderColor);
//        } else {
//            translateTextView.setText(translateEditText);
//            translateTextView.setTextColor(translateTextColor);
//        }
//
//        binding.translateEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
//            @Override
//            public void onFocusChange(final View v, final boolean hasFocus) {
//                if (hasFocus) {
//                    translateEditText = fragmentCommunicator.getTranslateText();
//                    if (translateEditText.isEmpty()) {
//                        translateTextView.setText(translateEditText);
//                    }
//                    translateTextView.setTextColor(translateTextColor);
//                } else {
//                    String translateTextViewString = translateTextView.getText().toString();
//                    fragmentCommunicator.setTranslateText(translateTextViewString);
//                    if (translateTextViewString.isEmpty()) {
//                        translateTextView.setText(translatePlaceHolderText);
//                        translateTextView.setTextColor(translatePlaceHolderColor);
//                    }
//                }
//            }
//        });
//
//        binding.translateButtonImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
////                TextView translateTextView = binding.TranslateLayout.findViewById(R.id.translateEditText);
////                String translateTextViewString = translateTextView.getText().toString();
////                fragmentCommunicator.setTranslateText(translateTextViewString);
//
//                NavHostFragment.findNavController(TranslateFragment.this)
//                        .navigate(R.id.action_TranslateFragment_to_WelcomeFragment);
//            }
//        });
//
//        binding.exitButtonImageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                translateTextView.clearFocus();
//            }
//        });
//
//  //  Getting saved data from other fragment
//        TextView translateTextView = binding.translateTextLayout.findViewById(R.id.translateEditText);
//
//        translateEditText = fragmentCommunicator.getTranslateText();
//        if (!translateEditText.isEmpty()) {
//            translateTextView.setText(translateEditText);
//        }

}