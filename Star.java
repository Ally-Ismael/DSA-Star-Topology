/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package star.topology;
public class Star {
     public static void insertNode(ServerNode server, String IPAddress,  String MACAddress){
         //local variables to get the IPs and the MAC Address
         String ip1="x",ip2="x",ip3="x",ip4="x",ip5="x",ip6="x";
         String mac1="xx",mac2="xx",mac3="xx",mac4="xx",mac5="xx",mac6="xx";
           if (server.Interface1 != null) {
               ip1=server.Interface1.IPAddress;
               mac1=server.Interface1.MACAddress;
           }
           if (server.Interface2 != null) {
               ip2=server.Interface2.IPAddress;
               mac2=server.Interface2.MACAddress;
           }
            if (server.Interface3 != null) {
                ip3=server.Interface3.IPAddress;
                mac3=server.Interface3.MACAddress;
           }
            if (server.Interface4 != null) {
                ip4=server.Interface4.IPAddress;
                mac4=server.Interface4.MACAddress;
           }
            if (server.Interface5 != null) {
                ip5=server.Interface5.IPAddress;
                mac5=server.Interface5.MACAddress;
           }
            if (server.Interface6 != null) {
                ip6=server.Interface6.IPAddress;
                mac6=server.Interface6.MACAddress;
           }
           
            //to make sure all IP and MAC are unique
          if(server.Interface1!=null||server.Interface2!=null ||server.Interface3!=null ||server.Interface4 !=null||server.Interface5!=null||server.Interface6!=null ){
              if(ip1.equals(IPAddress)||ip2.equals(IPAddress) ||ip3.equals(IPAddress) ||ip4.equals(IPAddress) ||ip5.equals(IPAddress) ||ip6.equals(IPAddress)||mac1.equals(MACAddress)||mac2.equals(MACAddress) ||mac3.equals(MACAddress) ||mac4.equals(MACAddress) ||mac5.equals(MACAddress) ||mac6.equals(MACAddress)){
                  System.out.println("");
                  System.out.println((char)27 + "[31m The IP Address or MAC Address You Have Entered is already assigned to another Client Devices \n"+ (char)27 + "[0m");
              }else{
                     //Adding client nodes to the model at the defined sever interface(s).
                    if (server.Interface1 == null) {
                     server.Interface1 = new ClientNode(IPAddress,MACAddress, server);
                      System.out.println("Client Node Added Successfully");  

                    }else if (server.Interface2 == null) {
                        server.Interface2 = new ClientNode(IPAddress,MACAddress, server);
                        System.out.println("Client Node Added Successfully");
                    }else if (server.Interface3 == null) {
                        server.Interface3 = new ClientNode(IPAddress,MACAddress, server);
                        System.out.println("Client Node Added Successfully");
                    }else if (server.Interface4 == null) {
                        server.Interface4 = new ClientNode(IPAddress,MACAddress, server);
                        System.out.println("Client Node Added Successfully");
                    }
                    else if (server.Interface5 == null) {
                        server.Interface5 = new ClientNode(IPAddress,MACAddress, server);
                        System.out.println("Client Node Added Successfully");
                    }
                    else if (server.Interface6 == null) {
                        server.Interface6 = new ClientNode(IPAddress,MACAddress, server);
                        System.out.println("Client Node Added Successfully");
                    }else{
                        System.err.println("There is no space to connect any node");
                    }
                          }
          }else{ 
              
        //Adding client nodes to the model at the defined sever interface(s).
        if (server.Interface1 == null) {
         server.Interface1 = new ClientNode(IPAddress,MACAddress, server);
          System.out.println("Client Node Added Successfully");  
            
        }else if (server.Interface2 == null) {
            server.Interface2 = new ClientNode(IPAddress,MACAddress, server);
            System.out.println("Client Node Added Successfully");
        }else if (server.Interface3 == null) {
            server.Interface3 = new ClientNode(IPAddress,MACAddress, server);
            System.out.println("Client Node Added Successfully");
        }else if (server.Interface4 == null) {
            server.Interface4 = new ClientNode(IPAddress,MACAddress, server);
            System.out.println("Client Node Added Successfully");
        }
        else if (server.Interface5 == null) {
            server.Interface5 = new ClientNode(IPAddress,MACAddress, server);
            System.out.println("Client Node Added Successfully");
        }
        else if (server.Interface6 == null) {
            server.Interface6 = new ClientNode(IPAddress,MACAddress, server);
            System.out.println("Client Node Added Successfully");
        }else{
            System.err.println("There is no space to connect any node");
        }
        }
    }
    public static void deleteNode(String interfaces, ServerNode server){
        //Deleting the clinet node connected to the specified sever interface.
        if (interfaces.equalsIgnoreCase("Interface1")) {
            if (server.Interface1 != null) {
                server.Interface1 = null;
                System.out.println("node deleted : ");
            }else{
                System.out.println("No node is connected to this interface.");
            }
        }else if (interfaces.equalsIgnoreCase("Interface2")) {
            if (server.Interface2 != null) {
                server.Interface2 = null;
                System.out.println("node deleted successfully ");
            }else{
                System.out.println("No device is connected to this interface.");
            }
        }else if (interfaces.equalsIgnoreCase("Interface3")) {
            if (server.Interface3 != null) {
                server.Interface3 = null;
                System.out.println("node deleted successfully ");
            }else{
                System.out.println("No node is connected to this interface.");
            }
        }else if (interfaces.equalsIgnoreCase("Interface4")) {
            if (server.Interface4 != null) {
                server.Interface4 = null;
                System.out.println("node deleted successfully ");
            }else{
                System.out.println("No node is connected to this interface.");
            }
        }
        else if (interfaces.equalsIgnoreCase("Interface5")) {
            if (server.Interface5 != null) {
                server.Interface5 = null;
                System.out.println("node deleted successfully ");
            }else{
                System.out.println("No node is connected to this interface.");
            }
        }
        else if (interfaces.equalsIgnoreCase("Interface6")) {
            if (server.Interface6 != null) {
                server.Interface6 = null;
                System.out.println("node deleted successfully ");
            }else{
                System.out.println("No node is connected to this interface.");
            }
        }else{
            System.out.println("Invalid Node.");
        }
    }
    public static void display(ServerNode server){
        //Displaying the server details.
        System.out.println("\n");
        System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>");
        System.out.println("           SERVER ");
        System.out.println("<<<<<<<<<<<<<<>>>>>>>>>>>>>>\n");

        System.out.println("IP Address = "+ server.IPAddress);
        System.out.println("MAC Address = "+ server.MACAddress);
       if (server.Interface1 != null || server.Interface2 != null || server.Interface3 != null || server.Interface4 != null || server.Interface5 != null || server.Interface6 != null){
           System.out.println("");
        System.out.println((char)27 + "[34m CURRENT CONNECTED DEVICES"+ (char)27 + "[0m");

        //Displaying the model.
        if (server.Interface1 != null) {
            System.out.println("\n");
            System.out.println("IP Address = "+ server.Interface1.IPAddress);
            System.out.println("MAC Address = "+ server.Interface1.MACAddress);
            System.out.println("Interface = "+ server.Interface1.serverNode.Interface("Interface1"));
        }
        if (server.Interface2 != null) {
            System.out.println("\n");
            System.out.println("IP Address = "+ server.Interface2.IPAddress);
            System.out.println("MAC Address = "+ server.Interface2.MACAddress);
            System.out.println("Interface = "+ server.Interface2.serverNode.Interface("Interface2"));
        }
        if (server.Interface3 != null) {
            System.out.println("IP Address = "+ server.Interface3.IPAddress);
            System.out.println("MAC Address = "+ server.Interface3.MACAddress);
            System.out.println("Interface = "+ server.Interface3.serverNode.Interface("Interface3"));
        }
        if (server.Interface4 != null) {
            System.out.println("\n");
            System.out.println("IP Address = "+ server.Interface4.IPAddress);
            System.out.println("MAC Address = "+ server.Interface4.MACAddress);
            System.out.println("Interface = "+ server.Interface4.serverNode.Interface("Interface4"));
            
        }if (server.Interface5 != null) {
            System.out.println("\n");
            System.out.println("IP Address = "+ server.Interface5.IPAddress);
            System.out.println("MAC Address = "+ server.Interface5.MACAddress);
            System.out.println("Interface = "+ server.Interface5.serverNode.Interface("Interface5"));
        }
        if (server.Interface6 != null) {
            System.out.println("\n");
            System.out.println("IP Address = "+ server.Interface6.IPAddress);
            System.out.println("MAC Address = "+ server.Interface6.MACAddress);
            System.out.println("Interface = "+ server.Interface6.serverNode.Interface("Interface6"));
        }
       }else 
            System.out.println("\nNo client device is connected to the server!\n");
        
    }
}
