package com.priyakdey.algoexpersolutions;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class GenerateDivTags {

    // Generate all valid <div>/</div> combinations using backtracking with open and closed tag
    // counters, ensuring well-formed nesting at each step.
    // Think of it like balanced parentheses generation — place <div> only if open < n, and </div>
    // only if closed < open. Track the in-progress string with a mutable list to backtrack
    // efficiently after each recursive call.

    public ArrayList<String> generateDivTags(int numberOfTags) {
        List<String> document = new ArrayList<>();
        ArrayList<String> acc = new ArrayList<>();
        generateDivTags(0, 0, numberOfTags, document, acc);
        return acc;
    }

    private void generateDivTags(int open, int closed, int numberOfTags,
                                 List<String> document, ArrayList<String> acc) {
        if (open == numberOfTags) {
            if (closed == numberOfTags) {
                acc.add(String.join("", document));
            } else {
                document.add("</div>");
                generateDivTags(open, closed + 1, numberOfTags, document, acc);
                document.removeLast();
            }
        } else {
            if (open == closed) {
                document.add("<div>");
                generateDivTags(open + 1, closed, numberOfTags, document, acc);
                document.removeLast();
            } else {
                document.add("<div>");
                generateDivTags(open + 1, closed, numberOfTags, document, acc);
                document.removeLast();

                document.add("</div>");
                generateDivTags(open, closed + 1, numberOfTags, document, acc);
                document.removeLast();
            }
        }
    }
}
