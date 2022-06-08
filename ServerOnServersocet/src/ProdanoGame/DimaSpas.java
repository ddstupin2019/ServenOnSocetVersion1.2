package ProdanoGame;

public class DimaSpas {
    private Integer numPlayer;
    private Integer monCol;
    private Integer nedCol;

    public DimaSpas(Integer numPlayer, Integer nedCol) {
        this.numPlayer = numPlayer;
        this.nedCol = nedCol;
    }

    public Integer getNedCol() {
        return nedCol;
    }

    public void setNedCol(Integer nedCol) {
        this.nedCol = nedCol;
    }

    public Integer getNumPlayer() {
        return numPlayer;
    }

    public void setNumPlayer(Integer numPlayer) {
        this.numPlayer = numPlayer;
    }

    public Integer getMonCol() {
        return monCol;
    }

    public void setMonCol(Integer monCol) {
        this.monCol = monCol;
    }
}
