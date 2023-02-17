package com.llcompany.nerdtranslator;

import com.google.cloud.translate.Language;
import com.google.cloud.translate.Translate;

import java.util.List;

public interface Communicator {
    public void getTranslateService();
    public boolean checkInternetConnection();
    public String getTranslatedText(String originalText, Language sourceLanguageCode, Language targetLanguageCode);
    public List<Language> getSupportedLanguages(Translate.LanguageListOption... targetLanguage);
    public List<String> getSupportedLanguagesNames(List<Language> languages);
}
