package com.priyakdey;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author Priyak Dey
 */
public class BreathFirstSearch {

    // Classic BFS using Queue.

    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Deque<Node> queue = new ArrayDeque<>();
            queue.offer(this);


            while (!queue.isEmpty()) {
                Node node = queue.poll();
                array.add(node.name);

                for (Node child : node.children) {
                    queue.offer(child);
                }
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

}
