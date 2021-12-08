import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class server{
    public static void main(String[] args) throws IOException {
        ServerSocket serversocket = new ServerSocket(22222);
        System.out.println("Server started");

        while(true){
            Socket socket = serversocket.accept();
            System.out.println("Server accept socket");

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

            try {
                //input read from client
                Object cmsg = ois.readObject();
                System.out.println("msg from client to server : "+ (String)cmsg);

                //replay to client
                String serverReply = (String)cmsg;
                serverReply = serverReply.toUpperCase();
                oos.writeObject(serverReply);

            } catch (ClassNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}