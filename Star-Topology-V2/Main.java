import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Node {
    int nodeValue;
    Set<Node> neighbors;

    public Node(int nodeValue) {
        this.nodeValue = nodeValue;
        this.neighbors = new HashSet<>();
    }
}

class StarNetwork {
    Node hub;
    ArrayList<Node> peripheralNodes;

    public StarNetwork() {
        hub = null;
        peripheralNodes = new ArrayList<>();
    }

    public void addHub(int nodeValue) {
        hub = new Node(nodeValue);
    }

    public void addPeripheralNode(int nodeValue) {
        Node newNode = new Node(nodeValue);
        peripheralNodes.add(newNode);

        hub.neighbors.add(newNode);
        newNode.neighbors.add(hub);
    }

    public void BFS() {
        if (hub == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();

        queue.add(hub);
        visited.add(hub);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.nodeValue + " ");

            for (Node neighbor : current.neighbors) {
                if (!visited.contains(neighbor)) {
                    queue.add(neighbor);
                    visited.add(neighbor);
                }
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {
        StarNetwork network = new StarNetwork();

        network.addHub(1);
        network.addPeripheralNode(2);
        network.addPeripheralNode(3);
        network.addPeripheralNode(4);
        network.addPeripheralNode(5);


        network.BFS();
    }
}