import java.io.DataInputStream;
import java.io.DataOutputStream;

import java.io.IOException;

import java.net.Socket;
public class pclient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",22222);
        DataInputStream dis = new DataInputStream(socket.getInputStream());
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
    
        try {
            dos.writeUTF("filedey");
        while(true){
            String s = dis.readUTF();
            System.out.println(s);
            if(s.equals("rnai"))break;

        }
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}
