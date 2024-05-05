package com.socket;

import com.thread.Hilo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {
    public static void main(String args[]) throws Exception {


        Integer seed = new Random().nextInt();
        Hilo hilo = new Hilo(1,seed);;
        int count = 0;

        // Create server Socket
        ServerSocket ss = new ServerSocket(888);

        // connect it to client socket
        Socket s = ss.accept();
        System.out.println("Connection established");

        // to send data to the client
        PrintStream ps = new PrintStream(s.getOutputStream());

        // to read data coming from the client
        BufferedReader br = new BufferedReader( new InputStreamReader( s.getInputStream()));

        // to read data from the keyboard
        //BufferedReader kb = new BufferedReader( new InputStreamReader(System.in));

        // server executes continuously
        while (true) {

            String str, str1;

            // repeat as long as the client
            // does not send a null string

            // read from client
            while (!(str = br.readLine()).equalsIgnoreCase("Terminar")) {
                if(hilo.getState().equals(Thread.State.NEW)){
                    hilo.start();
                }

                System.out.println(str);
               if(hilo.getPom().toString().equalsIgnoreCase(str)){
                    hilo = new Hilo(1,seed);
                    count +=1;
               }
                // send to client
                ps.println(count );
            }

            // close connection
            ps.close();
            br.close();
            ss.close();
            s.close();

            // terminate application
            System.exit(0);

        } // end of while
    }
}
