package ProdanoGame;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdanoPlayer {
    private Socket socket;
    private InputStream in;
    private OutputStream out;
    private PrintWriter printWriter;
    private long id;
    private Integer maxPlay;
    private String name;
    private Integer balance;
    private Integer stavka;

    private ArrayList<Integer> moncol, nedcol;

    public ProdanoPlayer( Integer maxPlay, String name, Socket socket) {
        this.socket=socket;
        this.maxPlay = maxPlay;
        this.name = name;
        moncol=new ArrayList<>();
        nedcol=new ArrayList<>();
        stavka=0;
        try {
            in=socket.getInputStream();
            out=socket.getOutputStream();
            printWriter=new PrintWriter(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public InputStream getIn() {
        return in;
    }

    public void setIn(InputStream in) {
        this.in = in;
    }

    public Integer getStavkaIzSocet(){
        Scanner scanner=new Scanner(in);
        Integer a=scanner.nextInt();
        if(a==-5){
            stavka=a;
            return scanner.nextInt();
        }
        return 0;
    }
    public Integer getStavkaIzSocetMon(){
        Scanner scanner=new Scanner(in);
        Integer a=scanner.nextInt();
        if(a==-10){
            Integer s=scanner.nextInt();
            moncol.add(s);
            return s;
        }
        return 0;
    }
    public void setZapros(String inp){
        printWriter.println(inp);
        printWriter.flush();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getMaxPlay() {
        return maxPlay;
    }

    public void setMaxPlay(Integer maxPlay) {
        this.maxPlay = maxPlay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }

    public Integer getStavka() {
        return stavka;
    }

    public void setStavka(Integer stavka) {
        this.stavka = stavka;
    }

    public void addNed() {
        Scanner scanner = new Scanner(in);
        Integer a= scanner.nextInt();
        nedcol.add(a);
    }
}