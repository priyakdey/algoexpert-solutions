package com.priyakdey;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Priyak Dey
 */
public class CommonCharacters {

    public String[] commonCharacters(String[] strings) {
        if (strings == null || strings.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }

        int length = strings.length;

        Set<String> common =
            strings[0].chars().mapToObj(codePoint -> Character.toString((char) codePoint))
                .collect(Collectors.toSet());

        for (int i = 1; i < length; i++) {
            common.retainAll(
                strings[i].chars().mapToObj(codePoint -> Character.toString((char) codePoint))
                    .collect(Collectors.toSet()));
        }

        String[] commonChars = new String[common.size()];
        int cursor = 0;
        for (String s : common) {
            commonChars[cursor++] = s;
        }

        return commonChars;
    }

}
