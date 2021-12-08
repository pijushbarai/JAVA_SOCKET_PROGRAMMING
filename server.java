import java.io.*;
import java.net.*;

import javax.sound.sampled.SourceDataLine;

public class server {
    public static void main(String[] args) {
       

        //server started
        try {
            System.out.println("server started");
            ServerSocket ss = new ServerSocket(6666);
           while(true){
                Socket socket = ss.accept();

                 ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

                //input read which is reached from client 
                Object cmsg = ois.readObject();
                 System.out.println("Message from input is :"+ (String)cmsg);

                 String ack = (String)cmsg;
                 ack = ack.toUpperCase();

                 oos.writeObject(ack);
           }
            

            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
    }
        
}      
