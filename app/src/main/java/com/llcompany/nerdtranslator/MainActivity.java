package com.llcompany.nerdtranslator;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.StrictMode;

import androidx.annotation.IntRange;
import androidx.appcompat.app.AppCompatActivity;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;
import com.llcompany.nerdtranslator.databinding.ActivityMainBinding;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Communicator {

    private static Translate translate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        com.llcompany.nerdtranslator.databinding.ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }

    @Override
    public String getTranslatedText(String originalText, Language sourceLanguageCode, Language targetLanguageCode) {
        Translation translation = translate.translate(originalText, Translate.TranslateOption.sourceLanguage(sourceLanguageCode.getCode()), Translate.TranslateOption.targetLanguage(targetLanguageCode.getCode()), Translate.TranslateOption.model("base"));
        return "" + translation.getTranslatedText();
    }

    @Override
    public void getTranslateService() {

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        try (InputStream is = getResources().openRawResource(R.raw.credentials)) {
            //Get credentials:
            final GoogleCredentials myCredentials = GoogleCredentials.fromStream(is);
            //Set credentials and get translate service:
            TranslateOptions translateOptions = TranslateOptions.newBuilder().setCredentials(myCredentials).build();
            translate = translateOptions.getService();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    @Override
    public boolean checkInternetConnection() {
        int type = getConnectionType(getApplicationContext());
        //Means that we are connected to a network (mobile or wi-fi)
        return type == 1 || type == 2;
    }

    @IntRange(from = 0, to = 3)
    public static int getConnectionType(Context context) {
        int result = 0; // Returns connection type. 0: none; 1: mobile data; 2: wifi; 3: vpn
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (cm != null) {
                NetworkCapabilities capabilities = cm.getNetworkCapabilities(cm.getActiveNetwork());
                if (capabilities != null) {
                    if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI)) {
                        result = 2;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR)) {
                        result = 1;
                    } else if (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_VPN)) {
                        result = 3;
                    }
                }
            }
        } else {
            if (cm != null) {
                NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
                if (activeNetwork != null) {
                    // connected to the internet
                    if (activeNetwork.getType() == ConnectivityManager.TYPE_WIFI) {
                        result = 2;
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_MOBILE) {
                        result = 1;
                    } else if (activeNetwork.getType() == ConnectivityManager.TYPE_VPN) {
                        result = 3;
                    }
                }
            }
        }
        return result;
    }

    @Override
    public List<Language> getSupportedLanguages(Translate.LanguageListOption... targetLanguage) {
        //targetLanguage, for example, Translate.LanguageListOption.targetLanguage("es");
        if (targetLanguage == null)
            return translate.listSupportedLanguages();
        else
            return translate.listSupportedLanguages(targetLanguage);
    }

    @Override
    public List<String> getSupportedLanguagesNames(List<Language> languages) {
        List<String> names = new ArrayList<>();
//        List<Language> languages = getSupportedLanguages(targetLanguage);
        for (Language language : languages) {
            names.add(language.getName());
        }
        return names;
    }
}

