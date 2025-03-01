package com.priyakdey;

/**
 * @author Priyak Dey
 */
public class BestDigits {

    // Use a stack to look back at smaller digits and removed if numDigits > 0.
    // At the end, remove remaining numDigits from the end of the string.

    public String bestDigits(String number, int numDigits) {
        if (numDigits == 0) {
            return number;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : number.toCharArray()) {
            while (numDigits > 0 && !sb.isEmpty() && ch > sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1);
                numDigits--;
            }

            sb.append(ch);
        }

        return sb.substring(0, sb.length() - numDigits);
    }

}
