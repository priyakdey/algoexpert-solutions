package com.priyakdey;

import java.util.ArrayList;

/**
 * @author Priyak Dey
 */
public class ValidIpAddress {

    // Take segments of length [0..3] and check for valid ip,
    // append to buffer and backtrack.

    public ArrayList<String> validIPAddresses(String string) {
        ArrayList<String> validIpAddrs = new ArrayList<>();
        generateIPAddresses(string, 0, new ArrayList<>(), validIpAddrs);
        return validIpAddrs;
    }

    public void generateIPAddresses(String string, int index,
                                    ArrayList<String> buffer,
                                    ArrayList<String> list) {
        if (buffer.size() == 4) {
            if (index == string.length()) {
                list.add(String.join(".", buffer));
            }
            return;
        }

        if (index == string.length()) {
            return;
        }

        if (string.charAt(index) == '0') {
            buffer.add("0");
            generateIPAddresses(string, index + 1, buffer, list);
            buffer.removeLast();
            return;
        }

        for (int i = index; i < Math.min(string.length(), index + 3); i++) {
            String seg = string.substring(index, i + 1);
            int segValue = Integer.parseInt(seg);
            if (segValue >= 0 && segValue <= 255) {
                buffer.add(seg);
                generateIPAddresses(string, i + 1, buffer, list);
                buffer.removeLast();
            }
        }
    }
}
