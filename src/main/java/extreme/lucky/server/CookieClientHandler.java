package extreme.lucky.server;

import java.io.IOException;
import java.net.Socket;

public class CookieClientHandler implements Runnable{

    private Socket socket;
    private String filePath;

    public CookieClientHandler(Socket s, String filePath) {
        this.socket = s;
        this.filePath = filePath;
    }

    @Override
    public void run() {
        System.out.println("Starting a client thread");
        NetworkIO netIO = null;
        try {
            netIO = new NetworkIO(socket);
            String req = "";
            String randomCookieResp = "";
            while(true) {
                req = netIO.read();
                System.out.printf("Client's Responds: %s\n", randomCookieResp);
                if (req.trim().equals("exit"))
                    break;
                if (req.trim().equals("get-cookie")) {
                    System.out.printf("file => %s\n", this.filePath);

                    randomCookieResp= Cookie.getRandomCookie(this.filePath);
                    netIO.write("cookie-text<" +randomCookieResp);
                    break;
                } else {
                    netIO.write("error, invalid command");
                    break;
                }
            }
            netIO.close();
            socket.close();

            System.out.println("Exiting the thread!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
