package extreme.lucky.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerApp 
{
    public static void main( String[] args ) throws IOException
    {
        int port = 33214;
        if (args.length > 0 )
            port = Integer.parseInt(args[0]);

        String filePath = args[1];

        System.out.printf( "server up and listening on %s!\n", port );

        ExecutorService threadPool = Executors.newFixedThreadPool(2);

        ServerSocket server = new ServerSocket(port);

        while (true) {
            System.out.println("Waiting for client to connect");
            Socket sock = server.accept();
            System.out.println("Connected");
            CookieClientHandler thr = new CookieClientHandler(sock, filePath);
            threadPool.submit(thr);
            System.out.println("Summitted to threadpool");
        }
    }
}
