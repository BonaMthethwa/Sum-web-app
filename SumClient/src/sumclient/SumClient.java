
package sumclient;
import java.net.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class SumClient {

    
    public static void main(String[] args) throws UnknownHostException, IOException  {
        
            InetAddress addr=null;
            Socket socket=null;
            PrintWriter out;
            BufferedReader in;
            String data, serverResponse, op="";
            int num1 = 0, num2 = 0, option;
            Scanner sc=new Scanner(System.in);
           
                
            addr=InetAddress.getByName("127.0.0.1");
            System.out.println("IP Adress :" + addr);
            
            socket=new Socket(addr, 9191);
            System.out.println("Socket : "+socket);
            
            in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            
            option=displayOptions();
            while(option !=4){
                switch(option){
                    case 1:
                        op="+";
                        break;
                        
                    case 2:
                        op="-";
                        break;
                    
                    case 3:
                        op="*";
                        break;
                        
                    case 4:
                        System.exit(0);
                                
                        break;
                        
                    default:
                        System.out.println("Invalid option, choose(1-4");
                        
                        
                }
                option=displayOptions();
                data=num1+"#"+num2+"#"+op;
                out.println(data);
                serverResponse=in.readLine();
                System.err.println(num1+" "+op +" "+num2+" = "+serverResponse);
            }
            out.println("Stop");
            out.close();
            socket.close();
            in.close();
            
        } 
      
    
    public static int displayOptions(){
        Scanner sc=new Scanner(System.in);
        int choice;
        System.out.println("Enter option to execute: \n"
                + "1-Add numbers \n"
                + "2-Subtrsct numbers \n"
                + "3-Multiply numbers \n"
                + "4-Exit");
        choice=sc.nextInt();
        return choice;
        
    }
}
