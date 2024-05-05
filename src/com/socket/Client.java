package com.socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws Exception {
        int count = 0;
        // Create client socket
        Socket s = new Socket("localhost", 888);

        // to send data to the server
        DataOutputStream dos = new DataOutputStream( s.getOutputStream());

        // to read data coming from the server
        BufferedReader br = new BufferedReader( new InputStreamReader( s.getInputStream()));

        // to read data from the keyboard
        BufferedReader kb = new BufferedReader( new InputStreamReader(System.in));
        String str, str1;

        // repeat as long as exit
        // is not typed at client
        System.out.println("Adivine el numero generado");
        while (!(str = kb.readLine()).equalsIgnoreCase("Terminar")) {

            if(isNumeric(str)) {
                // send to the server
                dos.writeBytes(str + "\n");

                // receive from the server
                str1 = br.readLine();
                System.out.println("Aciertos: "+str1);

                if(count != Integer.parseInt(str)){
                    count = Integer.parseInt(str);
                    System.out.println("Adivine el numero generado");
                }

            }else{
                System.out.println("Digite un numero");
            }
        }

        // close connection.
        dos.close();
        br.close();
        kb.close();
        s.close();
    }
    public static boolean isNumeric(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
