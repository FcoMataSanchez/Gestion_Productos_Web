package model.negoci;


public class Producte {
    private String codi;
    private String nom;
    private String descripcio;
    private double preu;

    public Producte() {
    }

    public Producte(String codi, String nom, String descripcio, double preu) {
        this.codi = codi;
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
    }

    public String getCodi() {
        return codi;
    }

    public void setCodi(String codi) {
        this.codi = codi;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    @Override
    public String toString() {
        return "Producte " + "codi= " + codi + ", nom= " + nom + ", decripcio= " + descripcio + ", preu= " + preu;
    }

    
    

}
