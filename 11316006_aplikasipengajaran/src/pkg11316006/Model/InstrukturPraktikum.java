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
public interface InstrukturPraktikum {

    int JUMLAH_MENIT_PER_SESI = 50;
    
    int JUMLAH_MENIT_ISTIRAHAT = 15;

    public void mengajar(String topik);

    public void menilai(String topik, int nilai);
    
}
