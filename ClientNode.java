// ClientNode class representing peripheral client nodes
class ClientNode {
    private String clientName;
    private ServerNode server;

    // Constructor to initialize client name and connect to the server
    public ClientNode(String clientName, ServerNode server) {
        this.clientName = clientName;
        if (server != null) {
            this.server = server;
            server.addClient(this);
        } else {
            throw new IllegalArgumentException("Server cannot be null.");
        }
    }

    // Method for sending a message to another client
    public void send(String message, ClientNode receiver) {
        if (!this.equals(receiver)) {
            server.brokerMessage(message, this, receiver);
        } else {
            throw new IllegalArgumentException("Cannot send message to itself.");
        }
    }

    // Method for receiving a message from another client
    public void receive(String message, String senderName) {
        System.out.println(clientName + " received message: \"" + message + "\" from " + senderName);
    }

    // Getter method to retrieve the client name
    public String getClientName() {
        return clientName;
    }
}
