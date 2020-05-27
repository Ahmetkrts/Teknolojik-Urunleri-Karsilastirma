-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.4.12-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for compare-tech
CREATE DATABASE IF NOT EXISTS `compare-tech` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;
USE `compare-tech`;

-- Dumping structure for table compare-tech.laptop
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
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop: ~0 rows (approximately)
/*!40000 ALTER TABLE `laptop` DISABLE KEYS */;
/*!40000 ALTER TABLE `laptop` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_baglanti
CREATE TABLE IF NOT EXISTS `laptop_baglanti` (
  `baglanti_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `usb3x_adeti` int(2) unsigned NOT NULL DEFAULT 0,
  `usbtypec_adeti` int(2) unsigned NOT NULL DEFAULT 0,
  `hdmi_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `bluetooth_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ethernet_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `wifi_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`baglanti_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_baglanti: ~4 rows (approximately)
/*!40000 ALTER TABLE `laptop_baglanti` DISABLE KEYS */;
INSERT INTO `laptop_baglanti` (`baglanti_id`, `usb3x_adeti`, `usbtypec_adeti`, `hdmi_ozellikleri`, `bluetooth_ozellikleri`, `ethernet_ozellikleri`, `wifi_ozellikleri`) VALUES
	(1, 2, 5, ' vars', 'vars', 'vars', 'vars'),
	(8, 123, 123, ' bestami', 'asdf', 'Bestamp', '234'),
	(9, 1234, 1234, ' 1234213', '1234211', 'vxcvbxcv', 'fghjfghj'),
	(14, 1, 11, ' 1', '1', '1', '1');
/*!40000 ALTER TABLE `laptop_baglanti` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_depolama_bellek
CREATE TABLE IF NOT EXISTS `laptop_depolama_bellek` (
  `depolama_bellek_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `bellek_boyutu` int(5) unsigned NOT NULL DEFAULT 0,
  `bellek_frekansi` int(5) unsigned NOT NULL DEFAULT 0,
  `sabit_disk_boyutu` int(5) unsigned NOT NULL DEFAULT 0,
  `sabit_disk_yazma_hizi` int(5) unsigned NOT NULL DEFAULT 0,
  `ssd_boyutu` int(5) unsigned NOT NULL DEFAULT 0,
  `ssd_tipi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`depolama_bellek_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_depolama_bellek: ~2 rows (approximately)
/*!40000 ALTER TABLE `laptop_depolama_bellek` DISABLE KEYS */;
INSERT INTO `laptop_depolama_bellek` (`depolama_bellek_id`, `bellek_boyutu`, `bellek_frekansi`, `sabit_disk_boyutu`, `sabit_disk_yazma_hizi`, `ssd_boyutu`, `ssd_tipi`) VALUES
	(1, 64, 2666, 10, 7200, 128, 'HDD'),
	(8, 1, 1, 1, 1, 1, '1');
/*!40000 ALTER TABLE `laptop_depolama_bellek` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_ekran
CREATE TABLE IF NOT EXISTS `laptop_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_boyutu` double unsigned NOT NULL DEFAULT 0,
  `ekran_cozunurlugu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_yenileme` int(11) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_ekran: ~3 rows (approximately)
/*!40000 ALTER TABLE `laptop_ekran` DISABLE KEYS */;
INSERT INTO `laptop_ekran` (`ekran_id`, `ekran_boyutu`, `ekran_cozunurlugu`, `ekran_yenileme`) VALUES
	(1, 17.3, '3840x2160 Piksel', 144),
	(5, 123123, '123123', 123123),
	(6, 1, '', 0);
/*!40000 ALTER TABLE `laptop_ekran` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_ekran_karti
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
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_ekran_karti: ~3 rows (approximately)
/*!40000 ALTER TABLE `laptop_ekran_karti` DISABLE KEYS */;
INSERT INTO `laptop_ekran_karti` (`ekran_karti_id`, `ekran_karti_marka`, `ekran_karti_serisi`, `ekran_karti_modeli`, `ekran_karti_cekirdek_hizi`, `ekran_karti_bellek_boyutu`, `ekran_karti_bellek_turu`, `ekran_karti_bellek_arayuzu`) VALUES
	(1, 'NVIDIA ', 'NVIDIA GeForce RTX', 'NVIDIA GeForce RTX 2080', 1515, 8, 'GDDR6', 256),
	(5, '3', '3', '3', 3, 3, '3', 3),
	(6, '1', '1', '1', 0, 0, '1', 0);
/*!40000 ALTER TABLE `laptop_ekran_karti` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_islemci
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
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_islemci: ~3 rows (approximately)
/*!40000 ALTER TABLE `laptop_islemci` DISABLE KEYS */;
INSERT INTO `laptop_islemci` (`islemci_id`, `islemci_marka`, `islemci_serisi`, `islemci_modeli`, `islemci_temel_frekansi`, `cekirdek_sayisi`, `sanal_cekirdek_sayisi`, `on_bellek`, `uretim_teknolojisi`, `tdp_degeri`) VALUES
	(5, '123', '123', '123', 123, 1, 0, 0, 1, 1),
	(6, '4', '4', '4', 4, 4, 4, 4, 4, 4),
	(7, '1', '1', '1', 1, 0, 0, 0, 0, 0);
/*!40000 ALTER TABLE `laptop_islemci` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_pil
CREATE TABLE IF NOT EXISTS `laptop_pil` (
  `pil_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `pil_gucu` int(3) unsigned NOT NULL DEFAULT 0,
  `pil_hucre_sayisi` int(3) unsigned NOT NULL DEFAULT 0,
  `pil_ozellikleri` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`pil_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_pil: ~3 rows (approximately)
/*!40000 ALTER TABLE `laptop_pil` DISABLE KEYS */;
INSERT INTO `laptop_pil` (`pil_id`, `pil_gucu`, `pil_hucre_sayisi`, `pil_ozellikleri`) VALUES
	(1, 1, 1, '1'),
	(6, 5, 5, '6'),
	(7, 1, 1, '1');
/*!40000 ALTER TABLE `laptop_pil` ENABLE KEYS */;

-- Dumping structure for table compare-tech.laptop_resim
CREATE TABLE IF NOT EXISTS `laptop_resim` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileName` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileType` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.laptop_resim: ~0 rows (approximately)
/*!40000 ALTER TABLE `laptop_resim` DISABLE KEYS */;
/*!40000 ALTER TABLE `laptop_resim` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon
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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefon` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_arka_kamera
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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_arka_kamera: ~2 rows (approximately)
/*!40000 ALTER TABLE `telefon_arka_kamera` DISABLE KEYS */;
INSERT INTO `telefon_arka_kamera` (`kamera_id`, `telefon_model`, `kamera_cozunurlugu`, `optik_goruntu_sabitleyici`, `flas`, `diafram_acikligi`, `video_kayit_cozunurlugu`, `video_fps_degeri`, `iki_kamera_cozunurlugu`, `iki_diafram_acikligi`, `uc_kamera_cozunurlugu`, `uc_diafram_acikligi`, `dort_kamera_cozunurlugu`, `dort_diafram_acikligi`, `bes_kamera_cozunurlugu`, `bes_diafram_acikligi`) VALUES
	(1, 'Redmi Note 8', 64, 'Yok', 'Dual-LED-Tek Tonlu Flaş', 1.89, '2160p (Ultra HD) 4K', 30, 8, 2.2, 2, 2.4, 2, 2.4, 0, NULL);
/*!40000 ALTER TABLE `telefon_arka_kamera` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_batarya
CREATE TABLE IF NOT EXISTS `telefon_batarya` (
  `batarya_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `batarya_kapasitesi` int(7) NOT NULL DEFAULT 0,
  `batarya_teknolojisi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `hizli_sarj_ozelligi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`batarya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_batarya: ~4 rows (approximately)
/*!40000 ALTER TABLE `telefon_batarya` DISABLE KEYS */;
INSERT INTO `telefon_batarya` (`batarya_id`, `batarya_kapasitesi`, `batarya_teknolojisi`, `hizli_sarj_ozelligi`) VALUES
	(1, 4500, 'Lithium Polymer (Li-Po)', 'Var'),
	(2, 2716, 'Lithium Ion (Li-Ion)', 'Var'),
	(4, 5000, 'li', 'var');
/*!40000 ALTER TABLE `telefon_batarya` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_ekran
CREATE TABLE IF NOT EXISTS `telefon_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_boyutu` double unsigned NOT NULL DEFAULT 0,
  `ekran_teknolojisi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_cozunurlugu` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `piksel_yogunlugu` int(5) NOT NULL DEFAULT 0,
  `ekran_dayanikligi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_ekran: ~1 rows (approximately)
/*!40000 ALTER TABLE `telefon_ekran` DISABLE KEYS */;
INSERT INTO `telefon_ekran` (`ekran_id`, `ekran_boyutu`, `ekran_teknolojisi`, `ekran_cozunurlugu`, `piksel_yogunlugu`, `ekran_dayanikligi`) VALUES
	(1, 6.3, 'IPS LCD', '1080x2340 (FHD+) Piksel', 395, 'Corning Gorilla Glass 5');
/*!40000 ALTER TABLE `telefon_ekran` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_islemcileri
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_islemcileri: ~3 rows (approximately)
/*!40000 ALTER TABLE `telefon_islemcileri` DISABLE KEYS */;
INSERT INTO `telefon_islemcileri` (`islemci_id`, `yonga_seti`, `ana_islemci`, `cpu_frekansi`, `cpu_cekirdegi`, `islemci_mimarisi`, `birinci_yardimci_islemci`, `grafik_islemcisi_gpu`, `gpu_frekansi`, `cpu_uretim_teknolojisi`) VALUES
	(1, 'MediaTek Helio G90T', '	\r\nDual-core 2.05 GHz ARM Cortex-A76', 2.05, 8, 64, 'Hexa-core 2.0 GHz ARM Cortex-A55', '	\r\nMali-G76 MC4', 800, 12),
	(2, 'Apple A11 Bionic ', 'Dual-core', 2.1, 6, 64, 'Quad-core', 'Three-Core', 0, 10),
	(3, '', '', 2.5, 0, 0, '', '', 0, 0);
/*!40000 ALTER TABLE `telefon_islemcileri` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_isletimsistemi
CREATE TABLE IF NOT EXISTS `telefon_isletimsistemi` (
  `isletim_sistemi_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isletim_sistemi_versiyon` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `isletim_sistemi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_isletimsistemi: ~2 rows (approximately)
/*!40000 ALTER TABLE `telefon_isletimsistemi` DISABLE KEYS */;
INSERT INTO `telefon_isletimsistemi` (`isletim_sistemi_id`, `isletim_sistemi_versiyon`, `isletim_sistemi`) VALUES
	(1, 'Android 9.0 (Pie)', 'Android'),
	(2, 'iOS 11', 'iOS');
/*!40000 ALTER TABLE `telefon_isletimsistemi` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_on_kamera
CREATE TABLE IF NOT EXISTS `telefon_on_kamera` (
  `kamera_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `telefon_model` varchar(50) COLLATE utf8_unicode_ci DEFAULT '0',
  `kamera_cozunurlugu` int(5) NOT NULL DEFAULT 0,
  `video_cozunurlugu` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `video_fps_degeri` int(5) NOT NULL DEFAULT 0,
  `diafram_acikligi` double NOT NULL DEFAULT 0,
  PRIMARY KEY (`kamera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_on_kamera: ~2 rows (approximately)
/*!40000 ALTER TABLE `telefon_on_kamera` DISABLE KEYS */;
INSERT INTO `telefon_on_kamera` (`kamera_id`, `telefon_model`, `kamera_cozunurlugu`, `video_cozunurlugu`, `video_fps_degeri`, `diafram_acikligi`) VALUES
	(1, 'Redmi Note 8', 20, '1080p', 30, 2),
	(2, 'iPhone X', 7, '1080p', 30, 2.2);
/*!40000 ALTER TABLE `telefon_on_kamera` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_renk
CREATE TABLE IF NOT EXISTS `telefon_renk` (
  `telefon_id` int(11) unsigned NOT NULL,
  `renk_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`telefon_id`,`renk_id`),
  KEY `renk_id` (`renk_id`),
  CONSTRAINT `Renk_TelefonFK` FOREIGN KEY (`renk_id`) REFERENCES `telefon_renkleri` (`renk_id`),
  CONSTRAINT `Telefon_RenkFK` FOREIGN KEY (`telefon_id`) REFERENCES `telefon` (`telefon_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_renk: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon_renk` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefon_renk` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_renkleri
CREATE TABLE IF NOT EXISTS `telefon_renkleri` (
  `renk_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `renk_adi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`renk_id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_renkleri: ~7 rows (approximately)
/*!40000 ALTER TABLE `telefon_renkleri` DISABLE KEYS */;
INSERT INTO `telefon_renkleri` (`renk_id`, `renk_adi`) VALUES
	(1, 'Siyah'),
	(2, 'Beyaz'),
	(3, 'Mavi'),
	(4, 'Yeşil'),
	(5, 'Gümüş'),
	(6, 'Kırmızı'),
	(23, '123');
/*!40000 ALTER TABLE `telefon_renkleri` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_resim
CREATE TABLE IF NOT EXISTS `telefon_resim` (
  `dosya_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileName` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileType` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_resim: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon_resim` DISABLE KEYS */;
/*!40000 ALTER TABLE `telefon_resim` ENABLE KEYS */;

-- Dumping structure for table compare-tech.televizyon
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
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.televizyon: ~0 rows (approximately)
/*!40000 ALTER TABLE `televizyon` DISABLE KEYS */;
/*!40000 ALTER TABLE `televizyon` ENABLE KEYS */;

-- Dumping structure for table compare-tech.televizyon_ekran
CREATE TABLE IF NOT EXISTS `televizyon_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_turu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_tipi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_boyutu` int(11) NOT NULL DEFAULT 0,
  `ekran_cozunurlugu` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `HDR` varchar(10) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.televizyon_ekran: ~3 rows (approximately)
/*!40000 ALTER TABLE `televizyon_ekran` DISABLE KEYS */;
INSERT INTO `televizyon_ekran` (`ekran_id`, `ekran_turu`, `ekran_tipi`, `ekran_boyutu`, `ekran_cozunurlugu`, `HDR`) VALUES
	(3, '0', '0', 185, '0', '0'),
	(4, 'ips', 'ips', 130, '1080', 'asdfasd');
/*!40000 ALTER TABLE `televizyon_ekran` ENABLE KEYS */;

-- Dumping structure for table compare-tech.televizyon_isletim_sistemi
CREATE TABLE IF NOT EXISTS `televizyon_isletim_sistemi` (
  `isletim_sistemi_id` int(11) NOT NULL AUTO_INCREMENT,
  `isletim_sistemi` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.televizyon_isletim_sistemi: ~3 rows (approximately)
/*!40000 ALTER TABLE `televizyon_isletim_sistemi` DISABLE KEYS */;
INSERT INTO `televizyon_isletim_sistemi` (`isletim_sistemi_id`, `isletim_sistemi`) VALUES
	(1, 'and'),
	(2, 'ios'),
	(4, 'macosss');
/*!40000 ALTER TABLE `televizyon_isletim_sistemi` ENABLE KEYS */;

-- Dumping structure for table compare-tech.televizyon_resim
CREATE TABLE IF NOT EXISTS `televizyon_resim` (
  `dosya_id` int(11) NOT NULL AUTO_INCREMENT,
  `filePath` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileName` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `fileType` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`dosya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.televizyon_resim: ~0 rows (approximately)
/*!40000 ALTER TABLE `televizyon_resim` DISABLE KEYS */;
/*!40000 ALTER TABLE `televizyon_resim` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
