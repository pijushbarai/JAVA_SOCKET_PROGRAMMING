import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class client{
    public static void main(String[] args) throws  IOException {
        
        Socket socket = new Socket("127.0.0.1",22222);
        System.out.println("client started");
        
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

        ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());


        Scanner sc = new Scanner(System.in);
        String message = sc.nextLine();

        oos.writeObject(message);
        try {
            Object smsg = ois.readObject();
            System.out.println("Message return from server : "+(String)smsg);
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        
    }
}