import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public class Server implements Runnable {
    private String string;

    public Server() {
        string = "";
    }


    @Override
    public void run() {
        try(ServerSocket server = new ServerSocket(7657)) {
            System.out.println("Server started, waiting for a client...");
            try(Socket connection = server.accept()) {
                DataInputStream inFromClient = new DataInputStream(new BufferedInputStream(connection.getInputStream()));
                DataOutputStream outToClient = new DataOutputStream(connection.getOutputStream());

                String string = "";
                String line = "";
                while(!line.equals("over")) {
                    if(!line.isEmpty())
                        string += "- " + line+ "\n";
                    System.out.println("Recieved: " + line);
                    line = inFromClient.readLine();
                }
                outToClient.write(("Got the words. here:\n" + string).getBytes());

            }
            catch(IOException e) {
                System.err.println(e);
            }
            System.out.println("\nClosing server.");
        }
        catch(IOException e) {
            System.err.println(e);
        }
    }
}
