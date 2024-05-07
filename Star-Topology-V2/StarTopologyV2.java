/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.topology;

import java.util.Scanner;
public class StarTopologyV2 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //instantiating the serverNode class.
        ServerNodeV2 server = new ServerNodeV2("192.168.3.12", "74-DE-2B-39-3D-53", null, null, null, null, null, null);
        ClientNodeV2 nodeobj = new ClientNodeV2();
        //the loop to control the flow of the program, 
        //by navigating to different menu option and call different functions
        while (true) {
            System.out.println("________________________________\n");
            System.out.println((char) 27 + "[34m    WELCOME TO NETWORK STAR TOPOLOGY " + (char) 27 + "[0m");
            System.out.println("________________________________\n");

            //menu
            System.out.println("1. Add Node\n2. Delete Node\n3. Display the model\n4. Send SMS\n5. Exit" + (char) 27 + "[0m");
            System.out.print("\nEnter your choice:  ");
            String choice = input.nextLine();//reading the user input from the keyboard

            //switch statement which pass in the use input
            switch (choice) {
                case "1":
                    System.out.println("Enter the IP Address of the client device: ");
                    String IPAdress = input.nextLine();//reading the ip address
                    System.out.println("Enter the MAC Address of the client device: ");
                    String MACAdress = input.nextLine();//reading the ip address
                    StarV2.insertNode(server, IPAdress, MACAdress);//calling the insertnode function and passing in its two required parameters
                    break;
                case "2":
                    System.out.println("Enter the interface of client device,e.g interface1: ");

                    String interfac = input.nextLine();//reading the interface value from the keyboard
                    StarV2.deleteNode(interfac, server);//callling the deletenode function
                    break;
                case "3":
                    StarV2.display(server);//calling the display function to display the topology to the user
                    break;
                case "4":
                    System.out.println("Please Enter the IP Of The Device which is Sending the Message");
                    String IP = input.nextLine();
                    if (server.Interface1 != null || server.Interface2 != null || server.Interface3 != null || server.Interface4 != null || server.Interface5 != null || server.Interface6 != null) {
                        if (server.Interface1 != null) {
                            if (server.Interface1.IPAddress.equalsIgnoreCase(IP)) {
                                nodeobj.send(server, IP);
                            }
                        }
                        if (server.Interface2 != null) {
                            if (server.Interface2.IPAddress.equalsIgnoreCase(IP)) {
                                nodeobj.send(server, IP);
                            }
                        }
                        if (server.Interface3 != null) {
                            if (server.Interface3.IPAddress.equalsIgnoreCase(IP)) {
                                nodeobj.send(server, IP);
                            }
                        }
                        if (server.Interface4 != null) {
                            if (server.Interface4.IPAddress.equalsIgnoreCase(IP)) {
                                nodeobj.send(server, IP);
                            }
                        }
                        if (server.Interface5 != null) {
                            if (server.Interface5.IPAddress.equalsIgnoreCase(IP)) {
                                nodeobj.send(server, IP);
                            }
                        }
                        if (server.Interface6 != null) {
                            if (server.Interface6.IPAddress.equalsIgnoreCase(IP)) {
                                nodeobj.send(server, IP);
                            }
                        }
                    } else {
                        System.out.println("No Device is connected to the Server to send SMS");
                    }

                    break;
                case "5":
                    System.exit(0);//exit the application if the user enter 4
                    break;
                default:
                    System.out.println("\nINVALID OPTION!!");//if a user enters  a wrong input this will be printed out showing
                    //the user that the input is wrong...
                    break;

            }
        }
    }

}
