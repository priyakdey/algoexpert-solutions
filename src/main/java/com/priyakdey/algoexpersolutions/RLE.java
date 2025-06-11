package com.priyakdey.algoexpersolutions;

/**
 * @author Priyak Dey
 */
public class RLE {

    // Classic Run-Length Encoding — compress same consecutive chars as count + char,
    // splitting counts if they exceed 9.

    public String runLengthEncoding(String string) {
        StringBuilder encodedString = new StringBuilder();

        int freq = 1;
        char lastSeen = string.charAt(0);

        for (int i = 1; i < string.length(); i++) {
            char ch = string.charAt(i);
            if (lastSeen != ch) {
                generate(encodedString, lastSeen, freq);
                lastSeen = ch;
                freq = 1;
            } else {
                freq++;
            }
        }

        generate(encodedString, lastSeen, freq);
        return encodedString.toString();
    }

    private void generate(StringBuilder encodedString, char ch, int freq) {
        while (freq > 9) {
            encodedString.append(9).append(ch);
            freq -= 9;
        }

        if (freq > 0) encodedString.append(freq).append(ch);
    }

}
