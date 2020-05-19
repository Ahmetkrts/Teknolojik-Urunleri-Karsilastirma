/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Casper
 */
public class laptopPil {
    private Long pil_id;
    private int pil_gucu;
    private int pil_hucre_sayisi;
    private String pil_ozellikleri;

    public Long getPil_id() {
        return pil_id;
    }

    public void setPil_id(Long pil_id) {
        this.pil_id = pil_id;
    }

    public int getPil_gucu() {
        return pil_gucu;
    }

    public void setPil_gucu(int pil_gucu) {
        this.pil_gucu = pil_gucu;
    }

    public int getPil_hucre_sayisi() {
        return pil_hucre_sayisi;
    }

    public void setPil_hucre_sayisi(int pil_hucre_sayisi) {
        this.pil_hucre_sayisi = pil_hucre_sayisi;
    }

    public String getPil_ozellikleri() {
        return pil_ozellikleri;
    }

    public void setPil_ozellikleri(String pil_ozellikleri) {
        this.pil_ozellikleri = pil_ozellikleri;
    }
}
