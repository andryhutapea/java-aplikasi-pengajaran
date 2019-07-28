/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11316006.Model;

/**
 *
 * @author Andry F. Hutapea
 */
public class Dosen extends Person implements InstrukturPraktikum{

    private String nidn;

    public Dosen() {
    }

    public Dosen(String nidn, String nama, String tempatLahir, String tanggalLahir) {
        super(nama, tempatLahir, tanggalLahir);
        this.nidn = nidn;
    }

    public String getNidn() {
        return nidn;
    }

    public void setNidn(String nidn) {
        this.nidn = nidn;
    }

    @Override
    public String toString() {
        return "Dosen----"
                + "\nNIDN\t: " + nidn
                + "\nNama\t: " + getNama()
                + "\nTempat Lahir\t: " + getTempatLahir()
                + "\nTanggal Lahir\t: " + getTanggalLahir();
    }

    @Override
    public void mengajar(String topik) {
        
    }

    @Override
    public void menilai(String topik, int nilai) {
        
    }

}
