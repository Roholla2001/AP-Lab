import java.io.*;
import java.net.Socket;

public class Handler implements Runnable {

    private Socket connSocket;
    private String name;

    public Handler(Socket connSocket, String name) {
        this.connSocket = connSocket;
        this.name = name;
    }


    @Override
    public void run() {
        try {
            DataInputStream inFromClient = new DataInputStream(new BufferedInputStream(connSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connSocket.getOutputStream());

            String string = "";
            String line = "";
            while(!line.equals("over")) {
                if(!line.isEmpty()) {
                    string += "- " + line + "\n";
                    System.out.println("Received " + line + " from " + name);
                }
                line = inFromClient.readLine();
            }
            outToClient.write(("\nWords received by " + name + " :\n" + string).getBytes());
            connSocket.close();
        }
        catch(IOException e) {
            System.err.println(e);
        }
        System.out.println("\nClosing " + name);

    }
}
