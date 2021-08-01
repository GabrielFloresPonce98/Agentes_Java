/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoagente;

public class Caminos {

    private int Indi;
    private String CaminosSel;
    private String Ruta;
    private String Costo;
    private String Selecc;
    private String Mutaci;
private  String Cruce;
private int menor;
    Caminos() {
        menor=Indi = 0;
        Cruce=Mutaci = Selecc = Ruta = Costo = "";

    }

    public int getMenor() {
        return menor;
    }

    public void setMenor(int menor) {
        this.menor = menor;
    }

    public String getCruce() {
        return Cruce;
    }

    public void setCruce(String Cruce) {
        this.Cruce = Cruce;
    }
    

    public void setMutaci(String Mutaci) {
        this.Mutaci = Mutaci;
    }

    public String getMutaci() {
        return Mutaci;
    }

    public void setSelecc(String Selecc) {
        this.Selecc = Selecc;
    }

    public String getSelecc() {
        return Selecc;
    }

    public void setCaminosSel(String CaminosSel) {
        this.CaminosSel = CaminosSel;
    }

    public String getCaminosSel() {
        return CaminosSel;
    }

    public void setIndi(int Indi) {
        this.Indi = Indi;
    }

    public void setRuta(String Ruta) {
        this.Ruta = Ruta;
    }

    public void setCosto(String Costo) {
        this.Costo = Costo;
    }

    public int getIndi() {
        return Indi;
    }

    public String getRuta() {
        return Ruta;
    }

    public String getCosto() {
        return Costo;
    }

}
