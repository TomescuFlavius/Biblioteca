package app.utile;

public class Frecventa {
    private int idCurs=0;
    private int frecventa=0;


    public Frecventa(int idCurs, int frecventa) {
        this.idCurs=idCurs;
        this.frecventa=frecventa;
    }

    public int getIdCurs() {
        return idCurs;
    }

    public void setIdCurs(int idCurs) {
        this.idCurs = idCurs;
    }

    public int getFrecventa() {
        return frecventa;
    }

    public void setFrecventa(int frecventa) {
        this.frecventa = frecventa;
    }


}
