/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author techn
 */
public class telefonKamera {
    private Long kamera_id;
    private String  kamera_on_arka;
    private int kamera_cozunurlugu;
    private String  optik_goruntu_sabitleyici;
    private String flas;
    private Double  diafram_acikligi;
    private String  video_kayit_cozunurlugu;
    private int video_fps_degeri;

    public Long getKamera_id() {
        return kamera_id;
    }

    public void setKamera_id(Long kamera_id) {
        this.kamera_id = kamera_id;
    }

    public String getKamera_on_arka() {
        return kamera_on_arka;
    }

    public void setKamera_on_arka(String kamera_on_arka) {
        this.kamera_on_arka = kamera_on_arka;
    }

    public int getKamera_cozunurlugu() {
        return kamera_cozunurlugu;
    }

    public void setKamera_cozunurlugu(int kamera_cozunurlugu) {
        this.kamera_cozunurlugu = kamera_cozunurlugu;
    }

    public String getOptik_goruntu_sabitleyici() {
        return optik_goruntu_sabitleyici;
    }

    public void setOptik_goruntu_sabitleyici(String optik_goruntu_sabitleyici) {
        this.optik_goruntu_sabitleyici = optik_goruntu_sabitleyici;
    }

    public String getFlas() {
        return flas;
    }

    public void setFlas(String flas) {
        this.flas = flas;
    }

    public Double getDiafram_acikligi() {
        return diafram_acikligi;
    }

    public void setDiafram_acikligi(Double diafram_acikligi) {
        this.diafram_acikligi = diafram_acikligi;
    }

    public String getVideo_kayit_cozunurlugu() {
        return video_kayit_cozunurlugu;
    }

    public void setVideo_kayit_cozunurlugu(String video_kayit_cozunurlugu) {
        this.video_kayit_cozunurlugu = video_kayit_cozunurlugu;
    }

    public int getVideo_fps_degeri() {
        return video_fps_degeri;
    }

    public void setVideo_fps_degeri(int video_fps_degeri) {
        this.video_fps_degeri = video_fps_degeri;
    }
    
    
}
