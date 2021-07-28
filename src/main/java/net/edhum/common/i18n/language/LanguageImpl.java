package net.edhum.common.i18n.language;

public class LanguageImpl implements Language {

    private final int id;
    private final String tag;
    private final String name;

    public LanguageImpl(int id, String tag, String name) {
        this.id = id;
        this.tag = tag;
        this.name = name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getTag() {
        return this.tag;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
