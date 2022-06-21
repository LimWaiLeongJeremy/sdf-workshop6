package extreme.lucky.client;

/*import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp 
{public static void main(String[] args){
    System.out.println("Cookie Client");
    String[] arr = args[0].split(":");
    boolean stop = false;
    InputStream is = null;
    DataInputStream dis = null;
    Socket sock = null;
    OutputStream os = null;

    try {
        Console cons = System.console();
        while(!stop){
            String response = null;
            String input = cons.readLine("Send command to server > ");
            // String input = ("get-cookie");

            sock = new Socket(arr[0], Integer.parseInt(arr[1]));
            is = sock.getInputStream();
            dis = new DataInputStream(is);
            os = sock.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            
            if(input.equals("exit"))
                stop = true;
            dos.writeUTF(input);
            dos.flush();
            
            if(!stop){
                try{
                    response = dis.readUTF();
                }catch(EOFException e){
                    // suppress if the reading is called twice.
                }
                
                if(response != null){
                    if(response.contains("cookie-text") || response.contains("error,")){
                        System.out.println(response);
                        String[] cookieValue = response.split(",");
                        if(response.contains("error,")){
                            System.out.printf("Error from server >> %s\n", cookieValue[1]);
                        }
                        if(response.contains("cookie-text,")){
                            System.out.printf("Cookie from server >> %s\n", cookieValue[1]);
                        }
                    }
                } 
            }
        }
        System.out.println("closing ..");
        is.close();
        os.close();
        sock.close();

    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (UnknownHostException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}   
}*/

import java.io.Console;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientApp 
{
    public static void main( String[] args )
    {
        System.out.println( "Client up!" );
        String[] arr = args[0].split(":");
        boolean stop = false;
        InputStream is = null;
        DataInputStream dis = null;
        OutputStream os = null;
        DataOutputStream dos = null;
        Socket sock = null;
System.out.println(arr[0] +" "+ arr[1]);
        try {
            Console con = System.console();
            while(!stop) { 
                String respond = null;
                String input = con.readLine("Send command to server > ");

                

                sock = new Socket (arr[0], Integer.parseInt(arr[1]));
                is = sock.getInputStream();
                dis = new DataInputStream(is);
                os = sock.getOutputStream();
                dos = new DataOutputStream(os);

                if(input.equals("exit"))
                    stop = true;
                dos.writeUTF(input);
                dos.flush();

                if (!stop) {
                    try {
                        respond = dis.readUTF();
                    } catch (EOFException e) {
                        //TODO: handle exception
                    }
                    if (respond != null) {
                        if (respond.contains("cookie-text") || respond.contains("error")) {
                            System.out.println(respond);
                            String[] cookieValue = respond.split(",");
                            if (respond.contains("error,")) {
                                System.out.printf("error from server >> %s", cookieValue[1]);
                            }
                            if (respond.contains("cookie-text,")) {
                                System.out.printf("cookie from server >> %S\n", cookieValue[1]);
                            }
                        }
                    }
                }
            }
            System.out.println("closing..");
            is.close();
            os.close();
            sock.close();

        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
// hi