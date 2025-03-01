package com.priyakdey;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class DepthFirstSearch {

    // Classic DFS, since this is Acyclic graph

    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> depthFirstSearch(List<String> array) {
            this.dfs(array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }

        private void dfs(List<String> array) {
            array.add(name);

            for (Node child : children) {
                child.dfs(array);
            }
        }
    }

}
