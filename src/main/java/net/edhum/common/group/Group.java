package net.edhum.common.group;

public enum Group {

    PLAYER(1, "player"),
    BUILDER(2, "builder"),
    DEVELOPER(3, "developer"),
    ADMINISTRATOR(4, "administrator");

    private final int id;
    private final String tag;

    Group(int id, String tag) {
        this.id = id;
        this.tag = tag;
    }

    public int getId() {
        return id;
    }

    public String getTag() {
        return tag;
    }
}
