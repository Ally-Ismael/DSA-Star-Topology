/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.topology;

import java.util.Scanner;

public class ClientNode {

    //Global member variables for the client node.
    String IPAddress;
    String MACAddress;
    ServerNode serverNode;

    //default construtor 
    public ClientNode() {
        IPAddress = "";
        MACAddress = "";
        serverNode = null;
    }

    public void send(ServerNode server, String SenderIP) {
        Scanner input = new Scanner(System.in);
        System.out.println("\nEnter The IP Of The client Node where You want to send the Message");
        String IP = input.nextLine();
        System.out.println("Enter The Message Which you want to sent");
        String msg = input.nextLine();
        System.out.println("");
        if (server.Interface1 != null) {
            if (server.Interface1.IPAddress.equalsIgnoreCase(IP)) {
                System.out.println("message Successfully Sent");

                receive(IP, msg);
            }
        }
        if (server.Interface2 != null) {
            if (server.Interface2.IPAddress.equalsIgnoreCase(IP)) {
                System.out.println("message Successfully Sent");

                receive(IP, msg);
            }
        }
        if (server.Interface3 != null) {
            if (server.Interface3.IPAddress.equalsIgnoreCase(IP)) {
                System.out.println("message Successfully Sent");


                receive(IP, msg);
            }
        }
        if (server.Interface4 != null) {
            if (server.Interface4.IPAddress.equalsIgnoreCase(IP)) {
                System.out.println("message Successfully Sent");

                receive(IP, msg);
            }
        }
        if (server.Interface5 != null) {
            if (server.Interface5.IPAddress.equalsIgnoreCase(IP)) {
                System.out.println("message Successfully Sent");

                receive(IP, msg);
            }
        }
        if (server.Interface6 != null) {
            if (server.Interface6.IPAddress.equalsIgnoreCase(IP)) {
                System.out.println("message Successfully Sent");

                receive(IP, msg);
            }
        }

    }

    public void receive(String sender, String Message) {
        System.out.println("");
        System.out.println("");
        System.out.println((char) 27 + "[34m New Message " + (char) 27 + "[0m");

        System.out.println("\nSender     : " + sender);
        System.out.println("Message     : " + Message);
        System.out.println("");
        System.out.println("");
    }

    //Parameterised constructor.
    public ClientNode(String IPAddress, String MacAddress, ServerNode s) {
        this.IPAddress = IPAddress;
        this.MACAddress = MacAddress;
        this.serverNode = s;
    }
}
