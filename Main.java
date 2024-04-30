// Main class to demonstrate the network functionality

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            // Create a new Star network
            Star network = new Star();
            Scanner scanner = new Scanner(System.in);

            // Create initial client nodes
            ClientNode client1 = new ClientNode("Client1", network.getServer());
            ClientNode client2 = new ClientNode("Client2", network.getServer());
            ClientNode client3 = new ClientNode("Client3", network.getServer());

            // Insert the initial client nodes into the network
            network.insertNode(client1);
            network.insertNode(client2);
            network.insertNode(client3);

            // Send messages between client nodes
            client1.send("Hello, Client2!", client2);
            client2.send("Hi, Client3!", client3);

            // Delete a client node from the network
            network.deleteNode(client3);

            // Attempt to send a message to a deleted client node
            client1.send("Hey, Client3!", client3); // This should throw an error

            // Interactive addition of a new client node to the network
            System.out.print("Enter the name of the new client node: ");
            String newNodeName = scanner.nextLine();
            // Create a new client node with the provided name and insert it into the
            // network
            ClientNode newClient = new ClientNode(newNodeName, network.getServer());
            network.insertNode(newClient);

            // Prompt the user to delete a client node
            System.out.print("Enter the name of the client node to delete: ");
            String nodeToDelete = scanner.nextLine();
            // Find the client node with the specified name and delete it from the network
            for (ClientNode client : network.getClients()) {
                if (client.getClientName().equals(nodeToDelete)) {
                    network.deleteNode(client);
                    break;
                }
            }

            scanner.close(); // Close the scanner
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}