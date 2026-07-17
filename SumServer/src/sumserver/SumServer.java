
package sumserver;
import java.net.*;
import java.io.*;
import za.tut.bl.MyThread;


public class SumServer {

    
    public static void main(String[] args) throws IOException {
        ServerSocket s=null;
        Socket socket=null;
        
        s=new ServerSocket(9191);
        System.out.println("Waiting for client.."+s);
        
        while(true){
            socket=s.accept();
            System.out.println("Connection established ");
            new MyThread(socket);
        }
    }
    
}
