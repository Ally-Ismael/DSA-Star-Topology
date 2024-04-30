import java.util.*;

public class HuffmanCoding {
    private static Map<Character, String> codes = new HashMap<>();
    private static StringBuilder compressedData = new StringBuilder();

    // Method to build the Huffman tree and generate Huffman codes
    private static void buildCodeTree(String input) {
        // Build the frequency map
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : input.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Build the Huffman tree using a priority queue
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            pq.offer(new Node(entry.getKey(), entry.getValue(), null, null));
        }

        // Construct the Huffman tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node parent = new Node(null, left.freq + right.freq, left, right);
            pq.offer(parent);
        }

        // Build the code map
        Node root = pq.poll();
        buildCodeMap(root, "");
    }

    // Recursive method to build the code map
    private static void buildCodeMap(Node node, String code) {
        if (node.left == null && node.right == null) {
            codes.put(node.ch, code);
        } else {
            buildCodeMap(node.left, code + "0");
            buildCodeMap(node.right, code + "1");
        }
    }

    // Method to compress input string using Huffman codes
    public static String compress(String input) {
        // Clear previous compressed data
        compressedData.setLength(0);

        // Build the Huffman tree and generate Huffman codes
        buildCodeTree(input);

        // Compress the input string
        for (char c : input.toCharArray()) {
            compressedData.append(codes.get(c));
        }

        return compressedData.toString();
    }

    // Method to decompress compressed data back to original string
    public static String decompress(String compressedData) {
        StringBuilder decompressedData = new StringBuilder();
        Node root = getRootFromCodes();
        Node curr = root;

        // Decompress the compressed data
        for (char bit : compressedData.toCharArray()) {
            if (bit == '0') {
                curr = curr.left;
            } else {
                curr = curr.right;
            }

            if (curr.left == null && curr.right == null) {
                decompressedData.append(curr.ch);
                curr = root;
            }
        }

        return decompressedData.toString();
    }

    // Method to retrieve root node from codes map
    private static Node getRootFromCodes() {
        if (codes.isEmpty()) {
            return null; // Return null if codes map is empty
        }

        Node root = null;
        for (Map.Entry<Character, String> entry : codes.entrySet()) {
            root = getNode(root, entry.getValue(), entry.getKey());
        }
        return root;
    }

    // Recursive method to construct nodes of Huffman tree
    private static Node getNode(Node root, String code, char ch) {
        if (root == null) {
            root = new Node(null, 0, null, null);
        }

        if (code.length() == 0) {
            root.ch = ch; // Set character for the root node
            return root;
        }

        int idx = code.charAt(0) == '0' ? 0 : 1;

        if (idx == 0) {
            if (root.left == null) {
                root.left = new Node(null, 0, null, null);
            }
            root.left = getNode(root.left, code.substring(1), ch);
        } else {
            if (root.right == null) {
                root.right = new Node(null, 0, null, null);
            }
            root.right = getNode(root.right, code.substring(1), ch);
        }

        return root;
    }

    // Node class representing a node in Huffman tree
    private static class Node {
        Character ch; // Character stored in the node
        int freq; // Frequency of the character
        Node left, right; // Left and right children of the node

        Node(Character ch, int freq, Node left, Node right) {
            this.ch = ch;
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            String compressed = compress(input);
            System.out.println("Compressed data: " + compressed);

            String decompressed = decompress(compressed);
            System.out.println("Decompressed data: " + decompressed);
        }
    }
}