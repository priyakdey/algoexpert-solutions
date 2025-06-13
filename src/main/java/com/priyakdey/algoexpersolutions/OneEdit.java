package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class OneEdit {

    // Check if two strings are at most one edit away (insert, remove, or replace a character)
    // using length difference and targeted checks.
    //
    //  Use switch on length difference:
    //      -1 => possible insert into stringOne
    //      0 => possible replacement
    //      1 => possible removal from stringOne
    //
    // Each helper method simulates that specific edit using pointer comparison.

    public boolean oneEdit(String stringOne, String stringTwo) {
        int diff = stringOne.length() - stringTwo.length();

        return switch (diff) {
            case -1 -> add(stringOne, stringTwo);
            case 0 -> replace(stringOne, stringTwo);
            case 1 -> remove(stringOne, stringTwo);
            default -> false;
        };
    }

    private boolean remove(String stringOne, String stringTwo) {
        int length1 = stringOne.length(), length2 = stringTwo.length();
        int i = 0, j = 0;

        while (i < length1 && j < length2) {
            if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                j++;
            }
            i++;
        }

        return i - j <= 1;
    }

    private boolean add(String stringOne, String stringTwo) {
        int length1 = stringOne.length(), length2 = stringTwo.length();
        int i = 0, j = 0;

        while (i < length1 && j < length2) {
            if (stringOne.charAt(i) == stringTwo.charAt(j)) {
                i++;
            }
            j++;
        }

        return j - i <= 1;
    }

    private boolean replace(String stringOne, String stringTwo) {
        int length = stringOne.length();
        int mismatch = 0;
        for (int i = 0; i < length; i++) {
            if (stringOne.charAt(i) != stringTwo.charAt(i)) {
                mismatch++;
            }
        }

        return mismatch < 2;
    }
}
