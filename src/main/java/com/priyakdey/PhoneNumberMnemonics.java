package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class PhoneNumberMnemonics {

    private final char[][] phoneNumberMappings = {
        {'a', 'b', 'c', '\0'},
        {'d', 'e', 'f', '\0'},
        {'g', 'h', 'i', '\0'},
        {'j', 'k', 'l', '\0'},
        {'m', 'n', 'o', '\0'},
        {'p', 'q', 'r', 's' },
        {'t', 'u', 'v', '\0'},
        {'w', 'x', 'y', 'z' },
    };

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> combinations = new ArrayList<>(3 * phoneNumber.length());
        phoneNumberMnemonics(phoneNumber, 0, new StringBuilder(), combinations);
        return combinations;
    }

    private void phoneNumberMnemonics(String phoneNumber, int index, StringBuilder buffer,
                                      ArrayList<String> combinations) {
        if (index == phoneNumber.length()) {
            combinations.add(buffer.toString());
            return;
        }

        char digit = phoneNumber.charAt(index);
        int i = digit - 50;

        if (i < 0) {
            buffer.append(digit);
            phoneNumberMnemonics(phoneNumber, index + 1, buffer, combinations);
            buffer.setLength(buffer.length() - 1);
        } else {
            for (char ch : phoneNumberMappings[i]) {
                if (ch == '\0') continue;

                buffer.append(ch);
                phoneNumberMnemonics(phoneNumber, index + 1, buffer, combinations);
                buffer.setLength(buffer.length() - 1);
            }
        }
    }

}
