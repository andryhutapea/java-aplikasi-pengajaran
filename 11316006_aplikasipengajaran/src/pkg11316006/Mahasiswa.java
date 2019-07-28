/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg11316006;

/**
 *
 * @author Andry F. Hutapea
 */
public class Mahasiswa extends Person implements InstrukturPraktikum {

    private String nim;
    private Prodi prodi;

    public Mahasiswa() {
    }

    public Mahasiswa(String nim, Prodi prodi, String nama, String tempatLahir, String tanggalLahir) {
        super(nama, tempatLahir, tanggalLahir);
        this.nim = nim;
        this.prodi = prodi;
    }

    Mahasiswa(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public Prodi getProdi() {
        return prodi;
    }

    public void setProdi(Prodi prodi) {
        this.prodi = prodi;
    }

    @Override
    public String toString() {
        return "Mahasiswa -----"
                + "\nNIM\t: " + nim
                + "\nNama\t: " + getNama()
                + "\nProdi\t: " + prodi + "\n";
    }

    @Override
    public void mengajar(String topik) {
        
    }

    @Override
    public void menilai(String topik, int nilai) {

    }

    void setVisible(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
