-- --------------------------------------------------------
-- Sunucu:                       127.0.0.1
-- Sunucu sürümü:                10.4.12-MariaDB - mariadb.org binary distribution
-- Sunucu İşletim Sistemi:       Win64
-- HeidiSQL Sürüm:               10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- compare-tech için veritabanı yapısı dökülüyor
CREATE DATABASE IF NOT EXISTS `compare-tech` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `compare-tech`;

-- tablo yapısı dökülüyor compare-tech.kullanici
CREATE TABLE IF NOT EXISTS `kullanici` (
  `kullanici_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kullanici_adSoyad` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `kullanici_adi` varchar(15) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `kullanici_sifre` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`kullanici_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.kullanici: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `kullanici`;
/*!40000 ALTER TABLE `kullanici` DISABLE KEYS */;
INSERT INTO `kullanici` (`kullanici_id`, `kullanici_adSoyad`, `kullanici_adi`, `kullanici_sifre`) VALUES
	(1, 'Ahmet Karataş', 'admin', '1234'),
	(2, 'Enes Çopoglu', 'enes', '12345'),
	(4, 'Beyazit Besatmi Sarikaya', 'bestami', '12345678');
/*!40000 ALTER TABLE `kullanici` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop
CREATE TABLE IF NOT EXISTS `laptop` (
  `laptop_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `urun_adi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `urun_tipi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `urun_amaci` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `urun_ailesi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `urun_serisi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `isletim_sistemi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_id` int(11) unsigned NOT NULL DEFAULT 0,
  `genislik` double unsigned NOT NULL DEFAULT 0,
  `derinlik` double unsigned NOT NULL DEFAULT 0,
  `kalinlik` double unsigned NOT NULL DEFAULT 0,
  `agirlik` double unsigned NOT NULL DEFAULT 0,
  `depolama_bellek_id` int(11) unsigned NOT NULL DEFAULT 0,
  `islemci_id` int(11) unsigned NOT NULL DEFAULT 0,
  `ekran_karti_id` int(11) unsigned NOT NULL DEFAULT 0,
  `pil_id` int(11) unsigned NOT NULL DEFAULT 0,
  `baglanti_id` int(11) unsigned NOT NULL DEFAULT 0,
  `dosya` int(11) DEFAULT NULL,
  PRIMARY KEY (`laptop_id`),
  KEY `ekran_id` (`ekran_id`),
  KEY `depolamabellek_id` (`depolama_bellek_id`),
  KEY `islemci_id` (`islemci_id`),
  KEY `ekrankarti_id` (`ekran_karti_id`),
  KEY `pil_id` (`pil_id`),
  KEY `baglanti_id` (`baglanti_id`),
  KEY `dosya` (`dosya`),
  CONSTRAINT `FK_dosya` FOREIGN KEY (`dosya`) REFERENCES `laptop_resim` (`dosya_id`),
  CONSTRAINT `FK_laptop_laptop_baglanti` FOREIGN KEY (`baglanti_id`) REFERENCES `laptop_baglanti` (`baglanti_id`),
  CONSTRAINT `FK_laptop_laptop_depolama_bellek` FOREIGN KEY (`depolama_bellek_id`) REFERENCES `laptop_depolama_bellek` (`depolama_bellek_id`),
  CONSTRAINT `FK_laptop_laptop_ekran` FOREIGN KEY (`ekran_id`) REFERENCES `laptop_ekran` (`ekran_id`),
  CONSTRAINT `FK_laptop_laptop_ekran_karti` FOREIGN KEY (`ekran_karti_id`) REFERENCES `laptop_ekran_karti` (`ekran_karti_id`),
  CONSTRAINT `FK_laptop_laptop_islemci` FOREIGN KEY (`islemci_id`) REFERENCES `laptop_islemci` (`islemci_id`),
  CONSTRAINT `FK_laptop_laptop_pil` FOREIGN KEY (`pil_id`) REFERENCES `laptop_pil` (`pil_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop`;
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
INSERT INTO `laptop` (`laptop_id`, `urun_adi`, `urun_tipi`, `urun_amaci`, `urun_ailesi`, `urun_serisi`, `isletim_sistemi`, `ekran_id`, `genislik`, `derinlik`, `kalinlik`, `agirlik`, `depolama_bellek_id`, `islemci_id`, `ekran_karti_id`, `pil_id`, `baglanti_id`, `dosya`) VALUES
	(25, 'Monster Tulpar T7 V18.3.2 Notebook ', 'Notebook', 'Oyun', 'Monster Tulpar', 'Tulpar T7', 'Windows 10 Pro', 8, 418, 282, 39, 4, 10, 8, 7, 8, 15, 27),
	(26, 'Lenovo ThinkPad P53 20QN003KTX Notebook ', 'Notebook', 'Is/Mobil', 'Lenovo ThinkPad', 'ThinkPad P53', 'Windows 10 Pro', 9, 377, 252, 29, 2.5, 11, 9, 8, 9, 15, 20),
	(27, 'HP OMEN 17-cb0004nt (6ZL10EA) Notebook ', 'Notebook', 'Oyun', 'HP OMEN', '17-cb000', 'Windows 10 Pro', 10, 405, 295, 27, 3, 12, 8, 7, 8, 15, 21),
	(28, 'MSI GE75 10SGS-043XTR Notebook ', 'Notebook', 'Oyun', 'MSI Gaming', 'GE75', 'FreeDOS', 11, 397, 268, 27, 2.66, 13, 10, 10, 10, 15, 22),
	(29, 'HP ZBook 17 G6 (6TW72ES) Notebook ', 'Notebook', 'Is/Mobil', 'HP ZBook', 'ZBook 17 G5', 'Windows 10 Pro', 11, 420, 280, 33, 3.14, 14, 11, 8, 8, 15, 26),
	(30, 'Lenovo ThinkPad P53 20QN0033TX Notebook', 'Notebook', 'Is/Mobil', 'Lenovo ThinkPad', 'ThinkPad P53', 'Windows 10 Pro', 12, 377, 252, 29, 2.5, 14, 12, 8, 9, 15, 23),
	(31, 'MSI GE75 10SFS-029XTR Notebook ', 'Notebook', 'Oyun', 'MSI Gaming', 'GE75', 'Windows 10 Pro', 11, 397, 268, 27, 2.6, 14, 10, 11, 8, 15, 24),
	(32, 'MSI GT83VR 7RF-201TR (SLI) Notebook', 'Notebook', 'Oyun', 'MSI Gaming', 'GT83VR', 'Windows 10 Pro', 11, 458, 339, 69, 5.5, 13, 10, 8, 10, 15, 25),
	(33, 'MSI GL75 10SDR-086TR Notebook ', 'Notebook', 'Oyun', 'MSI Gaming', 'GL75', 'Windows 10 Pro', 11, 398, 272, 28, 2.6, 14, 10, 11, 10, 15, 28);
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_baglanti
CREATE TABLE IF NOT EXISTS `laptop_baglanti` (
  `baglanti_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `usb3x_adeti` int(2) unsigned NOT NULL DEFAULT 0,
  `usbtypec_adeti` int(2) unsigned NOT NULL DEFAULT 0,
  `hdmi_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `bluetooth_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ethernet_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `wifi_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`baglanti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_baglanti: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_baglanti`;
/*!40000 ALTER TABLE `laptop_baglanti` DISABLE KEYS */;
INSERT INTO `laptop_baglanti` (`baglanti_id`, `usb3x_adeti`, `usbtypec_adeti`, `hdmi_ozellikleri`, `bluetooth_ozellikleri`, `ethernet_ozellikleri`, `wifi_ozellikleri`) VALUES
	(15, 4, 2, ' Var', 'Var', 'Var', 'Var');
/*!40000 ALTER TABLE `laptop_baglanti` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_depolama_bellek
CREATE TABLE IF NOT EXISTS `laptop_depolama_bellek` (
  `depolama_bellek_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `bellek_boyutu` int(5) unsigned NOT NULL DEFAULT 0,
  `bellek_frekansi` int(5) unsigned NOT NULL DEFAULT 0,
  `sabit_disk_boyutu` int(5) unsigned NOT NULL DEFAULT 0,
  `sabit_disk_yazma_hizi` int(5) unsigned NOT NULL DEFAULT 0,
  `ssd_boyutu` int(5) unsigned NOT NULL DEFAULT 0,
  `ssd_tipi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`depolama_bellek_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_depolama_bellek: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_depolama_bellek`;
/*!40000 ALTER TABLE `laptop_depolama_bellek` DISABLE KEYS */;
INSERT INTO `laptop_depolama_bellek` (`depolama_bellek_id`, `bellek_boyutu`, `bellek_frekansi`, `sabit_disk_boyutu`, `sabit_disk_yazma_hizi`, `ssd_boyutu`, `ssd_tipi`) VALUES
	(10, 64, 2666, 1000, 0, 0, ''),
	(11, 32, 2666, 0, 0, 1000, 'NVMe M.2 (PCIe)'),
	(12, 32, 2666, 2000, 5400, 512, 'NVMe M.2 (PCIe)'),
	(13, 32, 2666, 1000, 0, 512, 'NVMe M.2 (PCIe)'),
	(14, 32, 2666, 1000, 7200, 256, 'NVMe M.2 (PCIe)');
/*!40000 ALTER TABLE `laptop_depolama_bellek` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_ekran
CREATE TABLE IF NOT EXISTS `laptop_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_boyutu` double unsigned NOT NULL DEFAULT 0,
  `ekran_cozunurlugu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_yenileme` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_ekran: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_ekran`;
/*!40000 ALTER TABLE `laptop_ekran` DISABLE KEYS */;
INSERT INTO `laptop_ekran` (`ekran_id`, `ekran_boyutu`, `ekran_cozunurlugu`, `ekran_yenileme`) VALUES
	(8, 17, '3840x2160 Piksel', 140),
	(9, 15.6, '3840x2160 Piksel', 140),
	(10, 17, '1920x1080 Piksel', 144),
	(11, 17.3, '1920x1080 Piksel', 240),
	(12, 15.6, '1920x1080 Piksel', 144);
/*!40000 ALTER TABLE `laptop_ekran` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_ekran_karti
CREATE TABLE IF NOT EXISTS `laptop_ekran_karti` (
  `ekran_karti_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_karti_marka` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_karti_serisi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_karti_modeli` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_karti_cekirdek_hizi` double NOT NULL DEFAULT 0,
  `ekran_karti_bellek_boyutu` int(2) NOT NULL DEFAULT 0,
  `ekran_karti_bellek_turu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_karti_bellek_arayuzu` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ekran_karti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_ekran_karti: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_ekran_karti`;
/*!40000 ALTER TABLE `laptop_ekran_karti` DISABLE KEYS */;
INSERT INTO `laptop_ekran_karti` (`ekran_karti_id`, `ekran_karti_marka`, `ekran_karti_serisi`, `ekran_karti_modeli`, `ekran_karti_cekirdek_hizi`, `ekran_karti_bellek_boyutu`, `ekran_karti_bellek_turu`, `ekran_karti_bellek_arayuzu`) VALUES
	(7, 'NVIDIA', 'NVIDIA GeForce RTX', 'NVIDIA GeForce RTX 2080', 1515, 8, 'GDDR6', 256),
	(8, 'NVIDIA', 'NVIDIA Quadro RTX', 'NVIDIA Quadro RTX 4000', 1005, 8, 'GDDR6', 256),
	(10, 'NVIDIA', 'NVIDIA GeForce RTX', 'NVIDIA GeForce RTX 2080 Super', 1650, 8, 'GDDR6', 256),
	(11, 'NVIDIA', 'NVIDIA GeForce RTX', 'NVIDIA GeForce RTX 2070', 1410, 8, 'GDDR6', 256);
/*!40000 ALTER TABLE `laptop_ekran_karti` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_islemci
CREATE TABLE IF NOT EXISTS `laptop_islemci` (
  `islemci_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `islemci_marka` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `islemci_serisi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `islemci_modeli` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `islemci_temel_frekansi` double NOT NULL DEFAULT 0,
  `cekirdek_sayisi` int(2) NOT NULL DEFAULT 0,
  `sanal_cekirdek_sayisi` int(2) NOT NULL DEFAULT 0,
  `on_bellek` int(2) NOT NULL DEFAULT 0,
  `uretim_teknolojisi` int(2) NOT NULL DEFAULT 0,
  `tdp_degeri` int(2) NOT NULL DEFAULT 0,
  PRIMARY KEY (`islemci_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_islemci: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_islemci`;
/*!40000 ALTER TABLE `laptop_islemci` DISABLE KEYS */;
INSERT INTO `laptop_islemci` (`islemci_id`, `islemci_marka`, `islemci_serisi`, `islemci_modeli`, `islemci_temel_frekansi`, `cekirdek_sayisi`, `sanal_cekirdek_sayisi`, `on_bellek`, `uretim_teknolojisi`, `tdp_degeri`) VALUES
	(8, 'Intel', 'Intel Core i9', 'Intel Core i9-9900K', 3.6, 8, 16, 16, 14, 95),
	(9, 'Intel', 'Intel Core i9', 'Intel Core i9-9880H', 2.3, 8, 16, 16, 14, 45),
	(10, 'Intel', 'Intel Core i7', 'Intel Core i7-10750H', 2.6, 6, 12, 12, 14, 45),
	(11, 'Intel Xeon E-2286M', '0', '0', 0, 0, 0, 0, 0, 0),
	(12, 'Intel', 'Intel Core i7', 'Intel Core i7-9850H', 2.6, 6, 12, 12, 14, 45);
/*!40000 ALTER TABLE `laptop_islemci` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_pil
CREATE TABLE IF NOT EXISTS `laptop_pil` (
  `pil_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pil_gucu` int(3) unsigned NOT NULL DEFAULT 0,
  `pil_hucre_sayisi` int(3) unsigned NOT NULL DEFAULT 0,
  `pil_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`pil_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_pil: ~3 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_pil`;
/*!40000 ALTER TABLE `laptop_pil` DISABLE KEYS */;
INSERT INTO `laptop_pil` (`pil_id`, `pil_gucu`, `pil_hucre_sayisi`, `pil_ozellikleri`) VALUES
	(8, 82, 8, 'Li-Ion (Lityum-?yon)'),
	(9, 90, 0, 'Li-Ion (Lityum-?yon)'),
	(10, 65, 6, 'Li-Ion (Lityum-?yon)');
/*!40000 ALTER TABLE `laptop_pil` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_resim
CREATE TABLE IF NOT EXISTS `laptop_resim` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileName` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileType` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_resim: ~9 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_resim`;
/*!40000 ALTER TABLE `laptop_resim` DISABLE KEYS */;
INSERT INTO `laptop_resim` (`dosya_id`, `filePath`, `fileName`, `fileType`) VALUES
	(20, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3359~photo.png', 'image/png'),
	(21, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3360~photo.png', 'image/png'),
	(22, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3361~photo.png', 'image/png'),
	(23, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3362~photo.png', 'image/png'),
	(24, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3363~photo.png', 'image/png'),
	(25, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3364~photo.png', 'image/png'),
	(26, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3365~photo.png', 'image/png'),
	(27, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3366~photo.png', 'image/png'),
	(28, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3367~photo.png', 'image/png');
/*!40000 ALTER TABLE `laptop_resim` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.laptop_yorum
CREATE TABLE IF NOT EXISTS `laptop_yorum` (
  `laptop_id` int(11) unsigned NOT NULL,
  `yorum_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`laptop_id`,`yorum_id`),
  KEY `yorum_id` (`yorum_id`),
  CONSTRAINT `laptop_yorum` FOREIGN KEY (`laptop_id`) REFERENCES `laptop` (`laptop_id`),
  CONSTRAINT `yorum_laptop` FOREIGN KEY (`yorum_id`) REFERENCES `yorumlar` (`yorum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.laptop_yorum: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `laptop_yorum`;
/*!40000 ALTER TABLE `laptop_yorum` DISABLE KEYS */;
INSERT INTO `laptop_yorum` (`laptop_id`, `yorum_id`) VALUES
	(27, 69),
	(31, 49),
	(31, 50),
	(31, 63),
	(32, 48),
	(33, 46),
	(33, 47);
/*!40000 ALTER TABLE `laptop_yorum` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon
CREATE TABLE IF NOT EXISTS `telefon` (
  `telefon_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `telefon_ad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefon_marka` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `telefon_model` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `telefon_ekran_id` int(11) unsigned NOT NULL,
  `telefon_batarya_id` int(11) unsigned NOT NULL DEFAULT 0,
  `telefon_islemci_id` int(11) unsigned NOT NULL DEFAULT 0,
  `arka_kamera_id` int(11) unsigned NOT NULL DEFAULT 0,
  `on_kamera_id` int(11) unsigned NOT NULL DEFAULT 0,
  `telefon_ram` int(11) NOT NULL DEFAULT 0,
  `telefon_ram_frekansi` int(11) NOT NULL DEFAULT 0,
  `telefon_dahili_depolama` int(11) NOT NULL DEFAULT 0,
  `telefon_boy` double NOT NULL DEFAULT 0,
  `telefon_en` double NOT NULL DEFAULT 0,
  `telefon_agirlik` double NOT NULL DEFAULT 0,
  `isletim_sistemi_id` int(11) unsigned NOT NULL DEFAULT 0,
  `dosya` int(11) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`telefon_id`),
  KEY `Ekran_id` (`telefon_ekran_id`),
  KEY `Batarya_id` (`telefon_batarya_id`),
  KEY `Islemci_id` (`telefon_islemci_id`),
  KEY `Isletim-Sistemi_id` (`isletim_sistemi_id`),
  KEY `arka_kamera_id` (`arka_kamera_id`),
  KEY `on_kamera_id` (`on_kamera_id`),
  KEY `dosya` (`dosya`),
  CONSTRAINT `Arka_KameraFK` FOREIGN KEY (`arka_kamera_id`) REFERENCES `telefon_arka_kamera` (`kamera_id`),
  CONSTRAINT `BataryaFK` FOREIGN KEY (`telefon_batarya_id`) REFERENCES `telefon_batarya` (`batarya_id`),
  CONSTRAINT `EkranFK` FOREIGN KEY (`telefon_ekran_id`) REFERENCES `telefon_ekran` (`ekran_id`),
  CONSTRAINT `FK_telefon_telefon_resim` FOREIGN KEY (`dosya`) REFERENCES `telefon_resim` (`dosya_id`),
  CONSTRAINT `IslemciFK` FOREIGN KEY (`telefon_islemci_id`) REFERENCES `telefon_islemcileri` (`islemci_id`),
  CONSTRAINT `Isletim_SistemiFK` FOREIGN KEY (`isletim_sistemi_id`) REFERENCES `telefon_isletimsistemi` (`isletim_sistemi_id`),
  CONSTRAINT `On_KameaFK` FOREIGN KEY (`on_kamera_id`) REFERENCES `telefon_on_kamera` (`kamera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=81 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon`;
/*!40000 ALTER TABLE `telefon` DISABLE KEYS */;
INSERT INTO `telefon` (`telefon_id`, `telefon_ad`, `telefon_marka`, `telefon_model`, `telefon_ekran_id`, `telefon_batarya_id`, `telefon_islemci_id`, `arka_kamera_id`, `on_kamera_id`, `telefon_ram`, `telefon_ram_frekansi`, `telefon_dahili_depolama`, `telefon_boy`, `telefon_en`, `telefon_agirlik`, `isletim_sistemi_id`, `dosya`) VALUES
	(70, 'Samsung Galaxy S20 Ultra', 'Samsung ', 'Galaxy S20 Ultra', 7, 4, 6, 15, 6, 12, 1, 128, 167, 76, 220, 6, 62),
	(71, 'iPhone 8 Plus', 'iPhone ', '8 Plus', 6, 5, 5, 14, 5, 3, 1, 256, 158, 78, 202, 2, 59),
	(72, 'Samsung Galaxy Note 10', 'Samsung ', 'Galaxy Note 10', 5, 1, 4, 13, 4, 8, 1, 256, 150, 1, 168, 1, 61),
	(73, 'Xiaomi Redmi Note 8 Pro', 'Xiaomi ', 'Redmi Note 8 Pro', 1, 4, 1, 1, 1, 6, 1, 64, 161, 76, 199, 1, 67),
	(75, 'Xiaomi Mi 10', 'Xiaomi', ' Mi 10', 8, 7, 11, 16, 7, 8, 1, 128, 162, 74, 208, 6, 66),
	(76, 'Xiaomi Redmi Note 7', 'Xiaomi', 'Redmi Note 7', 1, 8, 12, 17, 8, 4, 1, 64, 159, 75, 8, 1, 65),
	(77, 'Samsung Galaxy J7 Prime 2 ', 'Samsung ', 'Galaxy J7 Prime 2 ', 6, 9, 13, 18, 9, 3, 1, 32, 151, 75, 170, 1, 68),
	(78, 'Xiaomi Mi 6', 'Xiaomi', 'Mi 6', 11, 10, 14, 1, 1, 6, 1, 128, 145, 70, 168, 1, 69),
	(79, 'Lenovo K6 Note', 'Lenovo', 'K6 Note', 6, 11, 15, 20, 11, 3, 0, 32, 151, 76, 169, 7, 70),
	(80, 'iPhone XR', 'iPhone', 'XR', 13, 12, 16, 21, 12, 3, 0, 256, 151, 76, 194, 8, 71);
/*!40000 ALTER TABLE `telefon` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_arka_kamera
CREATE TABLE IF NOT EXISTS `telefon_arka_kamera` (
  `kamera_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `telefon_model` varchar(100) COLLATE utf8_unicode_ci DEFAULT '0',
  `kamera_cozunurlugu` int(5) NOT NULL DEFAULT 0,
  `optik_goruntu_sabitleyici` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `flas` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `diafram_acikligi` double NOT NULL DEFAULT 0,
  `video_kayit_cozunurlugu` varchar(100) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `video_fps_degeri` int(11) NOT NULL DEFAULT 0,
  `iki_kamera_cozunurlugu` int(5) DEFAULT 0,
  `iki_diafram_acikligi` double DEFAULT NULL,
  `uc_kamera_cozunurlugu` int(5) DEFAULT 0,
  `uc_diafram_acikligi` double DEFAULT NULL,
  `dort_kamera_cozunurlugu` int(5) DEFAULT 0,
  `dort_diafram_acikligi` double DEFAULT NULL,
  `bes_kamera_cozunurlugu` int(5) DEFAULT 0,
  `bes_diafram_acikligi` double DEFAULT NULL,
  PRIMARY KEY (`kamera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_arka_kamera: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_arka_kamera`;
/*!40000 ALTER TABLE `telefon_arka_kamera` DISABLE KEYS */;
INSERT INTO `telefon_arka_kamera` (`kamera_id`, `telefon_model`, `kamera_cozunurlugu`, `optik_goruntu_sabitleyici`, `flas`, `diafram_acikligi`, `video_kayit_cozunurlugu`, `video_fps_degeri`, `iki_kamera_cozunurlugu`, `iki_diafram_acikligi`, `uc_kamera_cozunurlugu`, `uc_diafram_acikligi`, `dort_kamera_cozunurlugu`, `dort_diafram_acikligi`, `bes_kamera_cozunurlugu`, `bes_diafram_acikligi`) VALUES
	(1, 'Redmi Note 8', 64, 'Yok', 'Dual-LED-Tek Tonlu Fla?', 1.89, '2160p (Ultra HD) 4K', 30, 8, 2.2, 2, 2.4, 2, 1.89, 0, 0),
	(13, 'Samsung Galaxy Note 10', 12, 'Var', 'LED', 1.5, '2160p (Ultra HD) 4K', 60, 16, 2.2, 12, 2.1, 0, 0, 0, 0),
	(14, 'iPhone 8 Plus', 12, 'Var', 'Quad-LED Çift Tonlu', 1.8, '2160p (Ultra HD) 4K', 60, 12, 2.8, 0, 0, 0, 0, 0, 0),
	(15, 'Samsung Galaxy S20 Ultra', 108, 'Var', 'LED', 1.8, '4320p (Ultra HD) 8K', 24, 12, 2.2, 48, 3.5, 0, 0, 0, 0),
	(16, 'Xiaomi Mi 10', 108, 'Var', 'Dual-LED Çift Tonlu', 1.69, '4320p (Ultra HD) 8K', 30, 13, 2.4, 2, 2.4, 2, 2.4, 0, 0),
	(17, 'Xiaomi Redmi Note 7', 48, 'Yok', 'LED', 1.8, '1080p (Full HD)', 60, 5, 1.1, 0, 0, 0, 0, 0, 0),
	(18, 'Samsung Galaxy J7 Prime 2 ', 13, 'Yok', 'LED', 1.9, '1080p (Full HD)', 30, 0, 0, 0, 0, 0, 0, 0, 0),
	(19, 'Xiaomi Mi 6', 12, 'Var', 'Dual-LED Çift Tonlu', 1.8, '2160p (Ultra HD) 4K', 30, 12, 2.6, 0, 0, 0, 0, 0, 0),
	(20, 'Lenovo K6 Note', 16, 'Yok', 'Dual-LED Çift Tonlu', 0, '1080p (Full HD)', 30, 0, 0, 0, 0, 0, 0, 0, 0),
	(21, 'iPhone XR', 12, 'Var', 'Quad-LED Çift Tonlu', 1.8, '2160p (Ultra HD) 4K', 60, 0, 0, 0, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `telefon_arka_kamera` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_batarya
CREATE TABLE IF NOT EXISTS `telefon_batarya` (
  `batarya_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `batarya_kapasitesi` int(7) NOT NULL DEFAULT 0,
  `batarya_teknolojisi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `hizli_sarj_ozelligi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`batarya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_batarya: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_batarya`;
/*!40000 ALTER TABLE `telefon_batarya` DISABLE KEYS */;
INSERT INTO `telefon_batarya` (`batarya_id`, `batarya_kapasitesi`, `batarya_teknolojisi`, `hizli_sarj_ozelligi`) VALUES
	(1, 3500, 'Lithium Ion (Li-Ion)', 'Var'),
	(2, 2716, 'Lithium Ion (Li-Ion)', 'Var'),
	(4, 5000, 'Lithium Polymer (Li-Po)', 'Var'),
	(5, 2675, 'Lithium Ion (Li-Ion)', 'var'),
	(6, 5000, 'Lithium Ion (Li-Ion)', 'var'),
	(7, 4780, 'Lithium Polymer (Li-Po)', 'var'),
	(8, 4000, 'Lithium Polymer (Li-Po)', 'var'),
	(9, 3300, 'Lithium Ion (Li-Ion)', 'Yok'),
	(10, 3350, 'Lithium Polymer (Li-Po)', 'var'),
	(11, 4000, 'Lithium Polymer (Li-Po)', 'Yok'),
	(12, 2942, 'Lithium Ion (Li-Ion)', 'var');
/*!40000 ALTER TABLE `telefon_batarya` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_ekran
CREATE TABLE IF NOT EXISTS `telefon_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_boyutu` double unsigned NOT NULL DEFAULT 0,
  `ekran_teknolojisi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_cozunurlugu` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `piksel_yogunlugu` int(5) NOT NULL DEFAULT 0,
  `ekran_dayanikligi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_ekran: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_ekran`;
/*!40000 ALTER TABLE `telefon_ekran` DISABLE KEYS */;
INSERT INTO `telefon_ekran` (`ekran_id`, `ekran_boyutu`, `ekran_teknolojisi`, `ekran_cozunurlugu`, `piksel_yogunlugu`, `ekran_dayanikligi`) VALUES
	(1, 6.3, 'IPS LCD', '1080x2340 (FHD+) ', 395, 'Corning Gorilla Glass 5'),
	(5, 6.3, 'Dynamic AMOLED', '1080x2280 (FHD+)', 401, 'Corning Gorilla Glass 6'),
	(6, 5.5, 'IPS LCD', '1080x1920 (FHD) ', 401, 'Corning Gorilla Glass 5'),
	(7, 6.9, 'Dynamic AMOLED', '1440x3200 (QHD+)', 511, 'Corning Gorilla Glass 6'),
	(8, 6.67, 'AMOLED', '1080x2340 (FHD+) ', 386, 'Corning Gorilla Glass 5'),
	(9, 6.3, 'IPS LCD', '1080x2340 (FHD+) ', 409, 'Corning Gorilla Glass 5'),
	(10, 5.5, 'PLS', '1080x1920 (FHD) ', 401, 'Corning Gorilla Glass 4'),
	(11, 5.15, 'IPS LCD', '1080x1920 (FHD) ', 428, 'Corning Gorilla Glass 4'),
	(12, 5.5, 'IPS LCD', '1080x1920 (FHD) ', 401, ''),
	(13, 6.1, 'IPS LCD', '828x1792 (HD+) Piksel', 324, '');
/*!40000 ALTER TABLE `telefon_ekran` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_islemcileri
CREATE TABLE IF NOT EXISTS `telefon_islemcileri` (
  `islemci_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `yonga_seti` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `ana_islemci` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '',
  `cpu_frekansi` double NOT NULL DEFAULT 0,
  `cpu_cekirdegi` int(11) NOT NULL DEFAULT 0,
  `islemci_mimarisi` int(11) NOT NULL DEFAULT 0,
  `birinci_yardimci_islemci` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `grafik_islemcisi_gpu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `gpu_frekansi` int(11) NOT NULL DEFAULT 0,
  `cpu_uretim_teknolojisi` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`islemci_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_islemcileri: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_islemcileri`;
/*!40000 ALTER TABLE `telefon_islemcileri` DISABLE KEYS */;
INSERT INTO `telefon_islemcileri` (`islemci_id`, `yonga_seti`, `ana_islemci`, `cpu_frekansi`, `cpu_cekirdegi`, `islemci_mimarisi`, `birinci_yardimci_islemci`, `grafik_islemcisi_gpu`, `gpu_frekansi`, `cpu_uretim_teknolojisi`) VALUES
	(1, 'MediaTek Helio G90T', '	\r\nDual-core 2.05 GHz ARM Cortex-A76', 2.05, 8, 64, 'Hexa-core 2.0 GHz ARM Cortex-A55', '	\r\nMali-G76 MC4', 800, 12),
	(4, 'Samsung Exynos 9825', 'Dual-core 2.73 GHz Exynos M4', 2.73, 8, 64, 'Dual-core 2.4 GHz ARM Cortex-A75', 'Mali-G76 MP12', 0, 7),
	(5, ' Apple A11 Bionic', 'Dual-core 2.1 GHz Monsoon', 2.1, 6, 64, 'Quad-core Mistral', 'M11 Haraket ??lemcisi', 2, 10),
	(6, 'Samsung Exynos 990', 'Dual-core 2.73 GHz Mongoose M5', 2.73, 8, 64, 'Dual-core 2.6 GHz ARM Cortex-A76', 'Quad-core 2.00 GHz ARM Cortex-A55', 0, 7),
	(11, 'Qualcomm Snapdragon 865 (SM8250)', 'Single-core 2.84 GHz Kryo 585 (ARM Cortex-A77)', 2.84, 8, 64, 'Triple-core 2.4 GHz Kryo 585 (ARM Cortex-A77)', 'Quad-core 1.8 GHz (ARM Cortex-A55)', 587, 7),
	(12, 'Qualcomm Snapdragon 660 (SDM660)', 'Quad-core 2.2 GHz Kryo 260', 2.2, 8, 64, 'Quad-core 1.8 GHz Kryo 260', 'Adreno 512', 650, 14),
	(13, 'Samsung Exynos 7 Octa 7870', 'Octa-Core 1.6 GHz ARM Cortex-A53', 1.6, 8, 64, '', 'Mali-T830 MP1', 700, 14),
	(14, 'Qualcomm Snapdragon 835 MSM8998', 'Quad-core 2.45 GHz Kryo 280', 2.45, 8, 64, 'Quad-core 1.9 GHz Kryo 280', 'Adreno 540', 653, 10),
	(15, 'Qualcomm Snapdragon 430 MSM8937', 'Quad-core 1.4 GHz ARM Cortex-A53', 1.4, 8, 64, 'Quad-core 1.1 GHz ARM Cortex-A53', 'Adreno 505', 450, 28),
	(16, 'Apple A12 Bionic', 'Dual-Core 2.5 GHz Vortex', 2.5, 6, 64, 'Quad-Core 1.59 GHz Tempest', 'M12 Haraket ??lemcisi', 0, 7);
/*!40000 ALTER TABLE `telefon_islemcileri` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_isletimsistemi
CREATE TABLE IF NOT EXISTS `telefon_isletimsistemi` (
  `isletim_sistemi_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isletim_sistemi_versiyon` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `isletim_sistemi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_isletimsistemi: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_isletimsistemi`;
/*!40000 ALTER TABLE `telefon_isletimsistemi` DISABLE KEYS */;
INSERT INTO `telefon_isletimsistemi` (`isletim_sistemi_id`, `isletim_sistemi_versiyon`, `isletim_sistemi`) VALUES
	(1, 'Android 9.0 (Pie)', 'Android'),
	(2, 'iOS 11', 'iOS'),
	(6, 'Android 10 (Q)', 'Android '),
	(7, 'Android 7.0 (Nougat)', 'Android '),
	(8, 'iOS 12', 'iOS');
/*!40000 ALTER TABLE `telefon_isletimsistemi` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_on_kamera
CREATE TABLE IF NOT EXISTS `telefon_on_kamera` (
  `kamera_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `telefon_model` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `kamera_cozunurlugu` int(5) NOT NULL DEFAULT 0,
  `video_cozunurlugu` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `video_fps_degeri` int(5) NOT NULL DEFAULT 0,
  `diafram_acikligi` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`kamera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_on_kamera: ~11 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_on_kamera`;
/*!40000 ALTER TABLE `telefon_on_kamera` DISABLE KEYS */;
INSERT INTO `telefon_on_kamera` (`kamera_id`, `telefon_model`, `kamera_cozunurlugu`, `video_cozunurlugu`, `video_fps_degeri`, `diafram_acikligi`) VALUES
	(1, 'Redmi Note 8', 20, '1080p', 30, 2),
	(2, 'iPhone X', 7, '1080p', 30, 2.2),
	(4, 'Samsung Galaxy Note 10', 10, '2160p', 30, 2.2),
	(5, 'iPhone 8 Plus', 7, '1080p', 30, 2.2),
	(6, 'Samsung Galaxy S20 Ultra', 40, '2160p', 60, 2.2),
	(7, 'Xiaomi Mi 10 ', 20, '1080p', 30, 2),
	(8, 'Xiaomi Redmi Note 7', 13, '1080p', 30, 2),
	(9, 'Samsung Galaxy J7 Prime 2 ', 13, '1080p', 30, 1.9),
	(10, 'Xiaomi Mi 6', 8, '1080p', 30, 2),
	(11, 'Lenovo K6 Note', 8, '1080p', 30, 0),
	(12, 'iPhone XR', 7, '1080p', 60, 2.2);
/*!40000 ALTER TABLE `telefon_on_kamera` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_renk
CREATE TABLE IF NOT EXISTS `telefon_renk` (
  `telefon_id` int(11) unsigned NOT NULL,
  `renk_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`telefon_id`,`renk_id`),
  KEY `renk_id` (`renk_id`),
  CONSTRAINT `Renk_TelefonFK` FOREIGN KEY (`renk_id`) REFERENCES `telefon_renkleri` (`renk_id`),
  CONSTRAINT `Telefon_RenkFK` FOREIGN KEY (`telefon_id`) REFERENCES `telefon` (`telefon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_renk: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_renk`;
/*!40000 ALTER TABLE `telefon_renk` DISABLE KEYS */;
INSERT INTO `telefon_renk` (`telefon_id`, `renk_id`) VALUES
	(70, 1),
	(71, 1),
	(72, 2),
	(73, 1),
	(75, 1),
	(76, 1),
	(77, 1),
	(78, 1),
	(79, 2),
	(80, 1);
/*!40000 ALTER TABLE `telefon_renk` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_renkleri
CREATE TABLE IF NOT EXISTS `telefon_renkleri` (
  `renk_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `renk_adi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`renk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_renkleri: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_renkleri`;
/*!40000 ALTER TABLE `telefon_renkleri` DISABLE KEYS */;
INSERT INTO `telefon_renkleri` (`renk_id`, `renk_adi`) VALUES
	(1, 'Siyah'),
	(2, 'Beyaz'),
	(3, 'Mavi'),
	(4, 'Yeşil'),
	(5, 'Gümüş'),
	(6, 'Kırmızı'),
	(23, 'Beyaz');
/*!40000 ALTER TABLE `telefon_renkleri` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_resim
CREATE TABLE IF NOT EXISTS `telefon_resim` (
  `dosya_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileName` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileType` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=72 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_resim: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_resim`;
/*!40000 ALTER TABLE `telefon_resim` DISABLE KEYS */;
INSERT INTO `telefon_resim` (`dosya_id`, `filePath`, `fileName`, `fileType`) VALUES
	(59, '\\Users\\Enes\\Desktop\\Teknolojik-Urunleri-Karsilastirma-master\\web\\resources\\img\\resim', 'Untitled_Artwork(73).PNG', 'image/png'),
	(61, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'Untitled_Artwork.PNG', 'image/png'),
	(62, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'Untitled_Artwork(13).PNG', 'image/png'),
	(65, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3352~photo.png', 'image/png'),
	(66, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3356~photo.png', 'image/png'),
	(67, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3354~photo.png', 'image/png'),
	(68, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3353~photo.png', 'image/png'),
	(69, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3351~photo.png', 'image/png'),
	(70, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3358~photo.png', 'image/png'),
	(71, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3355~photo.png', 'image/png');
/*!40000 ALTER TABLE `telefon_resim` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.telefon_yorum
CREATE TABLE IF NOT EXISTS `telefon_yorum` (
  `telefon_id` int(11) unsigned NOT NULL,
  `yorum_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`telefon_id`,`yorum_id`),
  KEY `yorum_id` (`yorum_id`),
  CONSTRAINT `telefon_yorum` FOREIGN KEY (`telefon_id`) REFERENCES `telefon` (`telefon_id`),
  CONSTRAINT `yorum_telefon` FOREIGN KEY (`yorum_id`) REFERENCES `yorumlar` (`yorum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.telefon_yorum: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `telefon_yorum`;
/*!40000 ALTER TABLE `telefon_yorum` DISABLE KEYS */;
INSERT INTO `telefon_yorum` (`telefon_id`, `yorum_id`) VALUES
	(78, 55),
	(79, 61),
	(80, 54),
	(80, 59);
/*!40000 ALTER TABLE `telefon_yorum` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.televizyon
CREATE TABLE IF NOT EXISTS `televizyon` (
  `televizyon_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `televizyon_ad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `televizyon_marka` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `televizyon_model` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `televizyon_ekran_id` int(11) unsigned NOT NULL DEFAULT 0,
  `televizyon_enerji` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `televizyon_ses_cikis_gucu` int(11) NOT NULL DEFAULT 0,
  `televizyon_hoparlor_sistemi` int(11) NOT NULL DEFAULT 0,
  `televizyon_dahili_wifi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `televizyon_usb_20` int(11) NOT NULL DEFAULT 0,
  `televizyon_usb_30` int(11) NOT NULL DEFAULT 0,
  `televizyon_genisligi` int(11) NOT NULL DEFAULT 0,
  `televizyon_yuksekligi` int(11) NOT NULL DEFAULT 0,
  `televizyon_isletim_sistemi` int(11) NOT NULL DEFAULT 0,
  `televizyon_yenileme_hizi` int(11) NOT NULL DEFAULT 0,
  `televizyon_hd_uydu_alici` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `dosya` int(11) DEFAULT NULL,
  PRIMARY KEY (`televizyon_id`),
  KEY `televizyon_ekran_id` (`televizyon_ekran_id`),
  KEY `televizyon_isletim_sistemi` (`televizyon_isletim_sistemi`),
  KEY `dosya` (`dosya`),
  CONSTRAINT `DosyaFK` FOREIGN KEY (`dosya`) REFERENCES `televizyon_resim` (`dosya_id`),
  CONSTRAINT `TelevizyonEkranFK` FOREIGN KEY (`televizyon_ekran_id`) REFERENCES `televizyon_ekran` (`ekran_id`),
  CONSTRAINT `TelevizyonIsletimSistemiFK` FOREIGN KEY (`televizyon_isletim_sistemi`) REFERENCES `televizyon_isletim_sistemi` (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.televizyon: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `televizyon`;
/*!40000 ALTER TABLE `televizyon` DISABLE KEYS */;
INSERT INTO `televizyon` (`televizyon_id`, `televizyon_ad`, `televizyon_marka`, `televizyon_model`, `televizyon_ekran_id`, `televizyon_enerji`, `televizyon_ses_cikis_gucu`, `televizyon_hoparlor_sistemi`, `televizyon_dahili_wifi`, `televizyon_usb_20`, `televizyon_usb_30`, `televizyon_genisligi`, `televizyon_yuksekligi`, `televizyon_isletim_sistemi`, `televizyon_yenileme_hizi`, `televizyon_hd_uydu_alici`, `dosya`) VALUES
	(24, 'Samsung 82Q900R Ultra HD (8K) ', 'Samsung', '82Q900R Ultra HD (8K) ', 5, 'D', 60, 4, 'Var', 3, 0, 1835, 1117, 7, 100, 'Var', 23),
	(25, 'LG OLED65W9PLA Ultra HD (4K) ', 'LG', 'OLED65W9PLA Ultra HD (4K) ', 6, 'A', 60, 4, 'Var', 3, 2, 1446, 823, 8, 90, 'Var', 24),
	(26, 'Samsung 75Q900R Ultra HD (8K) ', 'Samsung', '75Q900R Ultra HD (8K)', 5, 'C', 60, 4, 'Var', 3, 2, 0, 1024, 7, 100, 'Var', 25),
	(27, 'LG OLED65B9PLA Ultra HD (4K)', 'LG', 'OLED65B9PLA Ultra HD (4K)', 6, 'A', 40, 2, 'Var', 3, 1, 1449, 869, 8, 100, 'Var', 26),
	(28, 'LG OLED65C9PLA Ultra HD (4K) ', 'LG', 'OLED65C9PLA Ultra HD (4K) ', 6, 'A', 40, 2, 'Var', 4, 2, 1449, 862, 8, 100, 'Var', 27),
	(29, 'Philips 55OLED804 Ultra HD (4K) ', 'Philips', '55OLED804 Ultra HD (4K) ', 6, 'B', 50, 2, 'Var', 3, 2, 1227, 720, 9, 100, 'Var', 28),
	(30, 'Sony KD-65AG9 Ultra HD (4K) ', 'Sony', 'KD-65AG9 Ultra HD (4K) ', 6, 'B', 60, 2, 'Var', 3, 1, 1447, 838, 9, 100, 'Var', 29),
	(31, 'Sony KD-55AG9 Ultra HD (4K) ', 'Sony', 'KD-55AG9 Ultra HD (4K) ', 8, 'B', 60, 2, 'Var', 3, 2, 1226, 714, 9, 100, 'Var', 30),
	(32, 'Sony KD-85XG8596 Ultra HD (4K) ', 'Sony', 'KD-85XG8596 Ultra HD (4K) ', 9, 'A', 20, 2, 'Var', 3, 1, 1909, 1175, 9, 100, 'Var', 31),
	(33, 'Sony KD-55AG8 Ultra HD (4K) ', 'Sony', 'KD-55AG8 Ultra HD (4K) ', 9, 'A', 60, 2, 'Var', 3, 1, 1229, 730, 9, 90, 'Var', 32);
/*!40000 ALTER TABLE `televizyon` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.televizyon_ekran
CREATE TABLE IF NOT EXISTS `televizyon_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_turu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_tipi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_boyutu` int(11) NOT NULL DEFAULT 0,
  `ekran_cozunurlugu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `HDR` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.televizyon_ekran: ~5 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `televizyon_ekran`;
/*!40000 ALTER TABLE `televizyon_ekran` DISABLE KEYS */;
INSERT INTO `televizyon_ekran` (`ekran_id`, `ekran_turu`, `ekran_tipi`, `ekran_boyutu`, `ekran_cozunurlugu`, `HDR`) VALUES
	(5, 'LED', 'Düz', 82, '7680x4320', 'Var'),
	(6, 'OLED', 'Düz', 65, '3840x2160', 'Var'),
	(7, 'LED', 'Düz', 75, '7680x4320', 'Var'),
	(8, 'OLED', 'Düz', 55, '3840x2160', 'Var'),
	(9, 'LED', 'Düz', 85, '3840x2160', 'Var');
/*!40000 ALTER TABLE `televizyon_ekran` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.televizyon_isletim_sistemi
CREATE TABLE IF NOT EXISTS `televizyon_isletim_sistemi` (
  `isletim_sistemi_id` int(11) NOT NULL AUTO_INCREMENT,
  `isletim_sistemi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.televizyon_isletim_sistemi: ~4 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `televizyon_isletim_sistemi`;
/*!40000 ALTER TABLE `televizyon_isletim_sistemi` DISABLE KEYS */;
INSERT INTO `televizyon_isletim_sistemi` (`isletim_sistemi_id`, `isletim_sistemi`) VALUES
	(2, 'ios'),
	(7, 'Tizen'),
	(8, 'webOS'),
	(9, 'Android TV');
/*!40000 ALTER TABLE `televizyon_isletim_sistemi` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.televizyon_resim
CREATE TABLE IF NOT EXISTS `televizyon_resim` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileName` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileType` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=33 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.televizyon_resim: ~10 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `televizyon_resim`;
/*!40000 ALTER TABLE `televizyon_resim` DISABLE KEYS */;
INSERT INTO `televizyon_resim` (`dosya_id`, `filePath`, `fileName`, `fileType`) VALUES
	(23, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3339~photo.png', 'image/png'),
	(24, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3340~photo.png', 'image/png'),
	(25, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3341~photo.png', 'image/png'),
	(26, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3344~photo.png', 'image/png'),
	(27, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3345~photo.png', 'image/png'),
	(28, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3346~photo.png', 'image/png'),
	(29, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3347~photo.png', 'image/png'),
	(30, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3348~photo.png', 'image/png'),
	(31, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3349~photo.png', 'image/png'),
	(32, '\\Users\\Enes\\Desktop\\000yeni\\Teknolojik-Urunleri-Karsilastirma\\web\\resources\\img\\resim', 'IMG_3350~photo.png', 'image/png');
/*!40000 ALTER TABLE `televizyon_resim` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.televizyon_yorum
CREATE TABLE IF NOT EXISTS `televizyon_yorum` (
  `televizyon_id` int(11) unsigned NOT NULL,
  `yorum_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`televizyon_id`,`yorum_id`),
  KEY `yorum_id` (`yorum_id`),
  CONSTRAINT `televizyon_yorum` FOREIGN KEY (`televizyon_id`) REFERENCES `televizyon` (`televizyon_id`),
  CONSTRAINT `yorum_televizyon` FOREIGN KEY (`yorum_id`) REFERENCES `yorumlar` (`yorum_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.televizyon_yorum: ~0 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `televizyon_yorum`;
/*!40000 ALTER TABLE `televizyon_yorum` DISABLE KEYS */;
INSERT INTO `televizyon_yorum` (`televizyon_id`, `yorum_id`) VALUES
	(25, 62),
	(25, 64);
/*!40000 ALTER TABLE `televizyon_yorum` ENABLE KEYS */;

-- tablo yapısı dökülüyor compare-tech.yorumlar
CREATE TABLE IF NOT EXISTS `yorumlar` (
  `yorum_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `yorum_icerik` varchar(500) COLLATE utf8_unicode_ci NOT NULL,
  `yorum_adSoyad` varchar(25) COLLATE utf8_unicode_ci NOT NULL,
  `yorum_tarih` timestamp NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  PRIMARY KEY (`yorum_id`)
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- compare-tech.yorumlar: ~7 rows (yaklaşık) tablosu için veriler indiriliyor
DELETE FROM `yorumlar`;
/*!40000 ALTER TABLE `yorumlar` DISABLE KEYS */;
INSERT INTO `yorumlar` (`yorum_id`, `yorum_icerik`, `yorum_adSoyad`, `yorum_tarih`) VALUES
	(46, '1234', 'deneme', '2020-05-30 20:26:39'),
	(47, 'ddd', 'aaa', '2020-05-30 20:28:09'),
	(48, 'hhcgdasda', 'deneme', '2020-05-30 20:28:57'),
	(49, '12', '12', '2020-05-30 20:30:23'),
	(50, 'bu laptop çok mükemmel dostum\n', 'ahmet karata?', '2020-05-30 20:31:48'),
	(51, '', '', '2020-05-30 20:31:52'),
	(52, '', '', '2020-05-30 20:31:52'),
	(53, 'aaa', 'assa', '2020-05-30 20:49:38'),
	(54, 'qq', 'qq', '2020-05-30 20:51:48'),
	(55, '11111', '121212', '2020-05-30 21:04:23'),
	(56, '', '', '2020-05-30 21:04:25'),
	(57, '', '', '2020-05-30 21:04:25'),
	(58, '', '', '2020-05-30 21:04:25'),
	(59, 'sadasd', 'ramazan', '2020-05-30 21:11:06'),
	(60, '1221', 'asas', '2020-05-30 21:12:43'),
	(61, '12345', 'deneme', '2020-05-30 21:18:27'),
	(62, 'bu deneme yorum', 'ahmet karatas', '2020-05-30 22:14:00'),
	(63, 'deneme', 'bestami', '2020-05-30 22:15:59'),
	(64, 'KLXZCKJBZXJCBZ', 'cbzjnbzjnxb', '2020-05-30 22:18:34'),
	(65, '', '', '2020-05-30 22:18:35'),
	(66, '', '', '2020-05-30 22:18:38'),
	(67, '', '', '2020-05-30 22:18:38'),
	(68, '', '', '2020-05-30 22:18:38'),
	(69, 'ASDASD', 'SDDSA', '2020-05-30 22:28:11');
/*!40000 ALTER TABLE `yorumlar` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
