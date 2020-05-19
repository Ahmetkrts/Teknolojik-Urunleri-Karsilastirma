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
public class telefonOnKamera {
    
    private Long kamera_id;
    private String telefon_model;
    private int kamera_cozunurlugu;
    private String video_cozunurlugu;
    private int video_fps_degeri;
    private double diafram_acikligi;

    public Long getKamera_id() {
        return kamera_id;
    }

    public void setKamera_id(Long kamera_id) {
        this.kamera_id = kamera_id;
    }

    public String getTelefon_model() {
        return telefon_model;
    }

    public void setTelefon_model(String telefon_model) {
        this.telefon_model = telefon_model;
    }

    public int getKamera_cozunurlugu() {
        return kamera_cozunurlugu;
    }

    public void setKamera_cozunurlugu(int kamera_cozunurlugu) {
        this.kamera_cozunurlugu = kamera_cozunurlugu;
    }

    public String getVideo_cozunurlugu() {
        return video_cozunurlugu;
    }

    public void setVideo_cozunurlugu(String video_cozunurlugu) {
        this.video_cozunurlugu = video_cozunurlugu;
    }

    public int getVideo_fps_degeri() {
        return video_fps_degeri;
    }

    public void setVideo_fps_degeri(int video_fps_degeri) {
        this.video_fps_degeri = video_fps_degeri;
    }

    public double getDiafram_acikligi() {
        return diafram_acikligi;
    }

    public void setDiafram_acikligi(double diafram_acikligi) {
        this.diafram_acikligi = diafram_acikligi;
    }
}
