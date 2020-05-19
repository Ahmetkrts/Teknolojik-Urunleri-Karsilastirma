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
public class laptopBaglanti {
    private Long baglanti_id;
    private int usb3x_adeti;
    private int usbtypec_adeti;
    private String hdmi_ozellikleri;
    private String bluetooth_ozellikleri;
    private String Ethernet_ozellikleri;
    private String wifi_ozellikleri;

    public Long getBaglanti_id() {
        return baglanti_id;
    }

    public void setBaglanti_id(Long baglanti_id) {
        this.baglanti_id = baglanti_id;
    }

    public int getUsb3x_adeti() {
        return usb3x_adeti;
    }

    public void setUsb3x_adeti(int usb3x_adeti) {
        this.usb3x_adeti = usb3x_adeti;
    }

    public int getUsbtypec_adeti() {
        return usbtypec_adeti;
    }

    public void setUsbtypec_adeti(int usbtypec_adeti) {
        this.usbtypec_adeti = usbtypec_adeti;
    }

    public String getHdmi_ozellikleri() {
        return hdmi_ozellikleri;
    }

    public void setHdmi_ozellikleri(String hdmi_ozellikleri) {
        this.hdmi_ozellikleri = hdmi_ozellikleri;
    }

    public String getBluetooth_ozellikleri() {
        return bluetooth_ozellikleri;
    }

    public void setBluetooth_ozellikleri(String bluetooth_ozellikleri) {
        this.bluetooth_ozellikleri = bluetooth_ozellikleri;
    }

    public String getEthernet_ozellikleri() {
        return Ethernet_ozellikleri;
    }

    public void setEthernet_ozellikleri(String Ethernet_ozellikleri) {
        this.Ethernet_ozellikleri = Ethernet_ozellikleri;
    }

    public String getWifi_ozellikleri() {
        return wifi_ozellikleri;
    }

    public void setWifi_ozellikleri(String wifi_ozellikleri) {
        this.wifi_ozellikleri = wifi_ozellikleri;
    }
}
