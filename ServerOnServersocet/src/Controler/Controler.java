package Controler;

import ProdanoGame.ProdanoControler;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Controler {
    static ProdanoControler prodanoControler=new ProdanoControler();

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("addclient");
                {
                    Scanner in = new Scanner(socket.getInputStream());
                    if (in.hasNext()) {
                        switch (in.nextInt()){
                            case -1111:
                                System.out.println("metod");
                                prodanoControler.metod(socket);
                                break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
