package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class RunLengthEncoding {

    public String runLengthEncoding(String string) {
        if (string == null || string.isEmpty()) {
            throw new IllegalArgumentException("invalid input");
        }

        StringBuilder buffer = new StringBuilder();
        int run = 1;
        char lastSeen = string.charAt(0);

        for (int i = 1, length = string.length(); i < length; i++) {
            char ch = string.charAt(i);
            if (lastSeen != ch || run == 9) {
                buffer.append(run);
                buffer.append(lastSeen);
                run = 0;
                lastSeen = ch;
            }
            run++;
        }

        buffer.append(run);
        buffer.append(lastSeen);

        return buffer.toString();
    }

}
