// Star class representing the network model

import java.util.ArrayList;
import java.util.List;

class Star {
    private List<ClientNode> clients;
    private ServerNode server;

    // Constructor to initialize the list of clients and the server node
    public Star() {
        this.server = new ServerNode();
        this.clients = new ArrayList<>();
    }

    // Method to retrieve the server node
    public ServerNode getServer() {
        return server;
    }

    // Method to insert a client node into the network
    public void insertNode(ClientNode client) {
        if (!clients.contains(client)) {
            clients.add(client);
            server.addClient(client);
            System.out.println("Client " + client.getClientName() + " inserted into the network.");
        } else {
            System.out.println("Client " + client.getClientName() + " already exists in the network.");
        }
    }

    // Method to delete a client node from the network
    public void deleteNode(ClientNode client) {
        if (clients.contains(client)) {
            clients.remove(client);
            server.removeClient(client);
            System.out.println("Client " + client.getClientName() + " removed from the network.");
        } else {
            System.out.println("Client " + client.getClientName() + " does not exist in the network.");
        }
    }

    // Method to retrieve the list of clients in the network
    public List<ClientNode> getClients() {
        return clients;
    }
}