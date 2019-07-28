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
public class Staf extends Person implements InstrukturPraktikum {

    private String nip, unitKerja;

    public Staf() {
    }

    public Staf(String nip, String unitKerja, String nama, String tempatLahir, String tanggalLahir) {
        super(nama, tempatLahir, tanggalLahir);
        this.nip = nip;
        this.unitKerja = unitKerja;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    public String getUnitKerja() {
        return unitKerja;
    }

    public void setUnitKerja(String unitKerja) {
        this.unitKerja = unitKerja;
    }

    public String toString() {
        return "Staf ------"
                + "\nNIP\t: " + nip
                + "\nUnit Kerja\t: " + unitKerja;
    }

    public void mengajar(String topik) {

    }

    public void menilai(String topik, int nilai) {

    }

}
