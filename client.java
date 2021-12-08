import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class client {
    public static void main(String[] args)  {
        try {
            System.out.println("client started");
            Socket socket = new Socket("127.0.0.1", 6666 );
            System.out.println("client connected");


            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            //take input from client
            Scanner sc = new Scanner(System.in);
            String message = sc.nextLine();

            oos.writeObject(message);

            Object fromServer = ois.readObject();
            String ack = (String)fromServer;
            System.out.println("ack back from server"+ack);

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
