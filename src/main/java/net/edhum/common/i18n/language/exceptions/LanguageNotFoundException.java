package net.edhum.common.i18n.language.exceptions;

public class LanguageNotFoundException extends RuntimeException {

    public LanguageNotFoundException(String languageName) {
        super(String.format("Language with name %s was not found in the language map", languageName));
    }
}
