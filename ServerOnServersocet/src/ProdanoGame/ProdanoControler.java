package ProdanoGame;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdanoControler {
    private Socket socket;
    private ProdanoPlayer player;
    ArrayList<ProdanoGame> igra;

    public ProdanoControler() {
        igra=new ArrayList<>();
    }
    public void metod(Socket socket){
        try {
            Scanner scanner=new Scanner(socket.getInputStream());
            Integer mp=scanner.nextInt();
            String name=scanner.nextLine();
            System.out.println("shit");
            if(igra.size()>=1){
                for (ProdanoGame pr: igra) {
                    if(pr.getMuxPlayer()==mp && !pr.getStadia()){
                        pr.addPlayer(new ProdanoPlayer(mp,name,socket));
                        return;
                    }
                }
                igra.add(new ProdanoGame(mp ,new ProdanoPlayer(mp,name,socket),igra.size()));
            }else{
                igra.add(new ProdanoGame(mp ,new ProdanoPlayer(mp,name,socket),0));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
       
        
        }
}
