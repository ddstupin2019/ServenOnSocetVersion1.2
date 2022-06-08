package ProdanoGame;

import HelpClass.ParseString;
import HelpClass.Randomaizer;
import netscape.javascript.JSObject;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class ProdanoGame {
    private Integer playId=0,igraId;
    private boolean stadia;
    private ArrayList<Integer> nedcol;
    private ArrayList<Integer> moncol;
    private Integer muxPlayer;
    private ArrayList<ProdanoPlayer> players;

    private Integer winAuck=0;
    private Integer backStavka;



    public ProdanoGame(Integer muxPlayer, ProdanoPlayer player, Integer id) {
        System.out.println("New game "+muxPlayer);
        igraId=id;
        stadia=false;
        this.muxPlayer = muxPlayer;
        nedcol= Randomaizer.random(0,29);
        moncol= Randomaizer.random(0,29);
        players=new ArrayList<>();
        player.setId(0);
        players.add(player);
    }

    public void addPlayer(ProdanoPlayer player){
        player.setId(players.get(players.size()-1).getId()+1);
        players.add(player);
        if(players.size()==muxPlayer){
            stadia=true;
            ThreadPlay();
        }
    }

    private void ThreadPlay(){
        new Thread() {
            @Override
            public void run() {
                super.run();
                Boolean st1;
                Boolean st2;
                Integer playInGame;
                for (int i = 0; i < muxPlayer; i++) {
                    players.get(i).setZapros(setOne());
                }
                Boolean oneShod = true;
                for (int i = 0; i < 30 / muxPlayer; i++) {
                    backStavka = 0;
                    st1 = true;
                    playInGame = muxPlayer;
                    while (st1) {
                        for (int j = winAuck; j < winAuck + muxPlayer; j++) {
                            String message = setShod(players, zapBol(j));
                            rasslac(message);
                            System.out.println(j%muxPlayer);
                            System.out.println(players.size());
                            rasslac(String.valueOf(backStavka));
                            ProdanoPlayer shodPlayer = players.get(j % muxPlayer);
                            if (playInGame == 1) {
                                winAuck = (j) % muxPlayer;
                                shodPlayer.addNed();
                                st1 = false;
                                break;
                            } else if (shodPlayer.getStavka() == 0 || oneShod) {
                                if (shodPlayer.getStavkaIzSocet() != 0) {
                                    backStavka = shodPlayer.getStavka();
                                } else {
                                    playInGame -= 1;
                                    shodPlayer.addNed();
                                }
                            }
                        }
                    }
                    oneShod = false;
                }
                rasslac("-100");
                for (int i = 0; i < 30 / muxPlayer; i++) {
                    ArrayList<DimaSpas> razdacha = setMoncol();
                    ArrayList<Integer> razdachaMonCol = new ArrayList<>();
                    for (int m = 0; m < muxPlayer; m++) {
                        razdachaMonCol.get(i * muxPlayer + m);
                    }
                    Collections.sort(razdachaMonCol);
                    sort(razdacha);
                    for (int k = 0; k < muxPlayer; k++) {
                        razdacha.get(k).setMonCol(razdachaMonCol.get(k));
                    }
                    rasslac(rezMonCol(razdacha));
                }
            }
        }.run();
    }
    private String rezMonCol(ArrayList<DimaSpas> inp){
        String rez="";
        ArrayList<String> a=ParseString.parserArrayDimaSpas(inp);
        rez+="-115\n";
        rez+=a.get(0);
        rez+="\n-120\n";
        rez+= a.get(1);
        return rez;
    }
    private ArrayList<DimaSpas> sort(ArrayList<DimaSpas> inp){
        for (int m = 0; m < muxPlayer; m++) {
            for (int m1 = 0; m1 < muxPlayer-1; m1++) {
                if(inp.get(m1).getNedCol()>inp.get(m1+1).getNedCol()){
                    Integer a=inp.get(m1).getNedCol();
                    inp.get(m1).setNedCol(inp.get(m1+1).getNedCol());
                    inp.get(m1+1).setNedCol(a);
                }
            }

        }
        return inp;
    }
    private ArrayList<DimaSpas> setMoncol(){
        ArrayList<DimaSpas> moncol=new ArrayList<>();
        for (int i = 0; i < muxPlayer; i++) {
            moncol.add(new DimaSpas(i,players.get(i).getStavkaIzSocetMon()));
        }
        return moncol;
    }
    private void in(ProdanoPlayer player){
        Scanner scanner=new Scanner(player.getIn());
        Integer zn=scanner.nextInt();
        switch (zn){
            //-5 mon
            case -5:

                break;
            case -10:

                break;
        }

    }


    private ArrayList<Boolean> zapBol(Integer inp){
        ArrayList<Boolean> rez=new ArrayList<>();
        for (int i = 0; i < muxPlayer; i++) {
            if(i==inp){
                rez.add(true);
            }else{
                rez.add(false);
            }
        }
        return rez;
    }
    private String setOne(){
        //-1 nedcol
        //-2 moncol
        String rez="-1\n"+ParseString.parserArray(nedcol)+"\n-2\n"+ParseString.parserArray(moncol);
        return rez;
    }
    private String setShod(ArrayList<ProdanoPlayer> players, ArrayList<Boolean> inp){
        //-15 имена
        //-30 stavka
        //-45 bool
        String rez;
        rez="-15\n";
        for (int i = 0; i < muxPlayer; i++) {
            rez+=players.get(i).getName();
            rez+=' ';
        }
        rez+="\n-30\n";
        for (int i = 0; i < muxPlayer; i++) {
            rez+=players.get(i).getStavka();
            rez+=' ';
        }
        rez+="\n-45\n";
        for (int i = 0; i < muxPlayer; i++) {
            rez+=inp.get(i);
            rez+=' ';
        }
        return rez;
    }
    private void rasslac(String mes){
        for (int i = 0; i < muxPlayer; i++) {
            players.get(i).setZapros(mes);
        }
    }




    public ArrayList<Integer> getNedcol() {
        return nedcol;
    }

    public ArrayList<Integer> getMoncol() {
        return moncol;
    }

    public boolean getStadia() {
        return stadia;
    }

    public Integer getMuxPlayer() {
        return muxPlayer;
    }
}
