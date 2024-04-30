import java.util.ArrayList;
import java.util.List;

// ServerNode class representing the central server node
class ServerNode {
    private List<ClientNode> connectedClients;

    // Constructor to initialize the list of connected clients
    public ServerNode() {
        this.connectedClients = new ArrayList<>();
    }

    // Method to broker messages between client nodes
    public void brokerMessage(String message, ClientNode sender, ClientNode receiver) {
        // Check if sender, receiver, and both are connected to the server
        if (!sender.equals(receiver) && connectedClients.contains(sender) && connectedClients.contains(receiver)) {
            receiver.receive(message, sender.getClientName());
        } else {
            throw new IllegalArgumentException(
                    "Sender or receiver not connected to the server, or attempting to send message to itself.");
        }
    }

    // Method to add a client to the list of connected clients
    public void addClient(ClientNode client) {
        connectedClients.add(client);
    }

    // Method to remove a client from the list of connected clients
    public void removeClient(ClientNode client) {
        connectedClients.remove(client);
    }
}