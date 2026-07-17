
package za.tut.bl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class MyThread extends Thread{
    private Socket socket;
    private PrintWriter out;
    private BufferedReader in;

    public MyThread(Socket socket) throws IOException {
        this.socket = socket;
        out=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
        in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        start();
    }
    
    @Override
    public void run(){
      String data;
      SumServerManager sm;
      DBManager db;
      int answer, num1, num2;
      
        try {
            data=in.readLine();
            
            while(!data.equalsIgnoreCase("STOP")){
                String[] token=data.split("#");
                num1=Integer.parseInt(token[0]);
                num2=Integer.parseInt(token[1]);
                char op=token[2].charAt(0);
                
                sm=new SumServerManager();
                if(op=='+'){
                    answer=sm.add(num1, num2);
                }
                else if(op=='-'){
                  answer=sm.substract(num1, num2);
                }
                else if(op=='*'){
                   answer=sm.Multiply(num1, num2);
                }
                else
                    break;
                
                db=new DBManager();
                db.storedata(num1, num2, op, answer);
                
                data=in.readLine();
                out.println(Integer.toString(answer));
            }
            System.out.println("CLIENT IS LEAVING");
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (SQLException ex) {
            Logger.getLogger(MyThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
