import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.zip.CheckedOutputStream;


public class Server {




    public static void main(String[] args) {
        final int MAX = 3;
        int count = 0;
        ExecutorService executor = Executors.newCachedThreadPool();


        try(ServerSocket server = new ServerSocket(7463)) {

            while(count < MAX) {
                System.out.println("Main: looking for a client...");
                executor.execute(new Handler(server.accept(), "handler" + count));
                System.out.println("Main: Client accepted.");
                count++;
            }
            executor.awaitTermination(1, TimeUnit.MINUTES);
        }
        catch(IOException | InterruptedException e) {
            System.err.println(e);
        }

    }
}
