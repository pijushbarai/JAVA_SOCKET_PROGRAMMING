import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class pserver {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(22222);
        Socket socket = ss.accept();
        System.out.println("Server Accepted");
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

        if(dis.readUTF().equalsIgnoreCase("filedey")){
            File f = new File("../Server");
            File[] files = f.listFiles();
            for(int i =0;i<files.length;i++){
                dos.writeUTF(files[i].getName());
            }
            dos.writeUTF("rnai");
        }
    }
}
