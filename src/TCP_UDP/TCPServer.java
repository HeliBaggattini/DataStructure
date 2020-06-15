/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TCP_UDP;

import java.io.*;
import java.net.*;

/**
 *
 * @author 1511 FOX
 */
public class TCPServer {

    private Socket socket = null;

    public static void main(String[] args) throws IOException {
        ServidorTCP();
    }
    
    public static void ServidorTCP() {
        try {
            ServerSocket serverSocket = new ServerSocket(5000);

            System.out.println("waiting connection...");
            Socket socketClient = serverSocket.accept();
            System.out.println("connection accepted!");

            PrintWriter out = new PrintWriter(socketClient.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socketClient.getInputStream()));

            
            out.println("Bem vindo carinha, digita algo ai");

            String dados = in.readLine();
            do{
            System.out.println("Cliente enviou " + dados);

            if (dados.equals("help") || dados.equals("help\r\n")) {
                out.println("aqui nao tem help");
            } else {
                out.println("Vai a m... , voce disse " + dados);
            }

            dados = in.readLine();
            System.out.println("Cliente enviou " + dados);
            }while (!dados.equals("exit"));
            
            out.println("tchaU");
            
            
            socketClient.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

