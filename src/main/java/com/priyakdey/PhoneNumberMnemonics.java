package com.priyakdey;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Priyak Dey
 */
public class PhoneNumberMnemonics {

    // Get a mapping from number to list of characters. Iterate over them
    // to get the word, and then backtrack.

    public ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        Map<Character, List<Character>> mappings = Map.of(
                '0', List.of('0'),
                '1', List.of('1'),
                '2', List.of('a', 'b', 'c'),
                '3', List.of('d', 'e', 'f'),
                '4', List.of('g', 'h', 'i'),
                '5', List.of('j', 'k', 'l'),
                '6', List.of('m', 'n', 'o'),
                '7', List.of('p', 'q', 'r', 's'),
                '8', List.of('t', 'u', 'v'),
                '9', List.of('w', 'x', 'y', 'z')
        );

        ArrayList<String> acc = new ArrayList<>();
        phoneNumberMnemonics(phoneNumber, 0, new StringBuilder(), acc, mappings);
        return acc;
    }

    private void phoneNumberMnemonics(String phoneNumber, int index,
                                      StringBuilder sb, ArrayList<String> acc,
                                      Map<Character, List<Character>> mappings) {
        if (index == phoneNumber.length()) {
            acc.add(sb.toString());
            return;
        }

        for (char ch : mappings.get(phoneNumber.charAt(index))) {
            sb.append(ch);
            phoneNumberMnemonics(phoneNumber, index + 1, sb, acc, mappings);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
