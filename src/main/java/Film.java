public class Film {
    private String titel;
    private String genre;
    private int erscheinungsjahr;
    private boolean ist3D;
    private int bewertung;
    private double preis;


    public Film(String titel, String genre, int erscheinungsjahr, boolean ist3D, int bewertung, double preis) {
        this.titel = titel;
        this.genre = genre;
        this.erscheinungsjahr = erscheinungsjahr;
        this.ist3D = ist3D;
        this.bewertung = bewertung;
        this.preis = preis;
    }

    public String getTitel() {
        return titel;
    }

    public String getGenre() {
        return genre;
    }

    public int getErscheinungsjahr() {
        return erscheinungsjahr;
    }

    public boolean isIst3D() {
        return ist3D;
    }

    public int getBewertung() {
        return bewertung;
    }

    public double getPreis() {
        return preis;
    }

    public double berechnePreis() {
        int basisPreis = 5;

        if (bewertung == 1) {
            preis = basisPreis + 4.99;

        } else if (bewertung == 2) {
            preis = basisPreis + 6.99;

        } else if (bewertung == 3) {
            preis = basisPreis + 8.99;

        } else if (bewertung == 4) {
            preis = basisPreis + 9.99;

        } else if (bewertung == 5) {
            preis = basisPreis + 10.99;

        } else if (ist3D) {
            preis = basisPreis + 2.0;

        }else{
            preis = basisPreis;
        }
        return preis;
    }
}
