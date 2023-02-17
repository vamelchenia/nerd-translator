package com.llcompany.nerdtranslator;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.llcompany.nerdtranslator.databinding.FragmentWelcomeBinding;

public class WelcomeFragment extends Fragment {

    private FragmentWelcomeBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        binding = FragmentWelcomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        // Slow animation
//        AlphaAnimation animationImageView = new AlphaAnimation(0f, 1f);
//        animationImageView.setDuration(1000);
//        //animationImageView.setStartOffset(1000);
//        //animationImageView.setFillAfter(true);
//        binding.welcomeLayout.startAnimation(animationImageView);

        //Next fragment
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                NavHostFragment.findNavController(WelcomeFragment.this)
                        .navigate(R.id.action_WelcomeFragment_to_TranslateFragment);

            }
        }, getResources().getInteger(R.integer.delaySplashScreen));

//        binding.welcomeLayout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                NavHostFragment.findNavController(WelcomeFragment.this)
//                        .navigate(R.id.action_WelcomeFragment_to_TranslateFragment);
//            }
//        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}