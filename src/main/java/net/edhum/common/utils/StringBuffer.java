package net.edhum.common.utils;

public class StringBuffer {

    private String value;

    public StringBuffer() {
        this.clear();
    }

    public void clear() {
        if (this.value != null) {
            this.value = null;
        }
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
