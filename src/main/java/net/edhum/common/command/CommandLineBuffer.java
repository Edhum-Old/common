package net.edhum.common.command;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class CommandLineBuffer {

    private final String[] input;
    private int cursor;

    public CommandLineBuffer(String[] input) {
        this.input = input;
        this.cursor = 0;
    }

    public CommandLineBuffer(String input) {
        this(input.split(" "));
    }

    public void consume() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("No element remaining in the buffer");
        }

        this.cursor++;
    }

    public boolean isEmpty() {
        return this.cursor >= this.input.length;
    }

    public String next() {
        if (this.isEmpty()) {
            throw new NoSuchElementException("No element remaining in the buffer");
        }

        return this.input[this.cursor];
    }

    public String[] remains() {
        if (this.isEmpty()) {
            return new String[] {};
        }

        String[] remains = Arrays.copyOfRange(this.input, this.cursor, this.input.length);
        this.cursor = this.input.length;

        return remains;
    }
}
