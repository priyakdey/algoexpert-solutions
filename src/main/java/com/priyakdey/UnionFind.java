package com.priyakdey;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author Priyak Dey
 */
public class UnionFind {

    private final Map<Integer, Integer> parentMapping = new HashMap<>();

    public void createSet(int value) {
        parentMapping.put(value, value);
    }

    public Integer find(int value) {
        if (!parentMapping.containsKey(value)) {
            return null;
        }

        int root = value;
        while (root != parentMapping.get(root)) {
            root = parentMapping.get(root);
        }

        return root;
    }

    public void union(int valueOne, int valueTwo) {
        Integer parentOne = find(valueOne);
        Integer parentTwo = find(valueTwo);

        if (parentOne != null && parentTwo != null
                && Objects.equals(parentOne, parentTwo)) {
            parentMapping.put(parentTwo, parentOne);
        }
    }

}
