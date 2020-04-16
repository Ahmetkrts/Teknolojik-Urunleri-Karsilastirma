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

-- Dumping structure for table compare-tech.telefon
CREATE TABLE IF NOT EXISTS `telefon` (
  `telefon_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `telefon_ad` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `telefon_marka` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `telefon_model` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `telefon_ekran_id` int(11) unsigned NOT NULL,
  `telefon_batarya_id` int(11) unsigned NOT NULL DEFAULT 0,
  `telefon_islemci_id` int(11) unsigned NOT NULL DEFAULT 0,
  `telefon_ram` int(11) NOT NULL DEFAULT 0,
  `telefon_ram_frekansi` int(11) NOT NULL DEFAULT 0,
  `telefon_dahili_depolama` int(11) NOT NULL DEFAULT 0,
  `telefon_boy` double NOT NULL DEFAULT 0,
  `telefon_en` double NOT NULL DEFAULT 0,
  `telefon_agirlik` double NOT NULL DEFAULT 0,
  `telefon_renk` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `isletim_sistemi_id` int(11) unsigned NOT NULL DEFAULT 0,
  PRIMARY KEY (`telefon_id`),
  KEY `Ekran_id` (`telefon_ekran_id`),
  KEY `Batarya_id` (`telefon_batarya_id`),
  KEY `Islemci_id` (`telefon_islemci_id`),
  KEY `Isletim-Sistemi_id` (`isletim_sistemi_id`),
  CONSTRAINT `BataryaFK` FOREIGN KEY (`telefon_batarya_id`) REFERENCES `telefon_batarya` (`batarya_id`),
  CONSTRAINT `EkranFk` FOREIGN KEY (`telefon_ekran_id`) REFERENCES `telefon_ekran` (`ekran_id`),
  CONSTRAINT `IslemciFK` FOREIGN KEY (`telefon_islemci_id`) REFERENCES `telefon_islemcileri` (`islemci_id`) ON DELETE CASCADE,
  CONSTRAINT `Isletim-SistemiFk` FOREIGN KEY (`isletim_sistemi_id`) REFERENCES `telefon_isletimsistemi` (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon` DISABLE KEYS */;
INSERT INTO `telefon` (`telefon_id`, `telefon_ad`, `telefon_marka`, `telefon_model`, `telefon_ekran_id`, `telefon_batarya_id`, `telefon_islemci_id`, `telefon_ram`, `telefon_ram_frekansi`, `telefon_dahili_depolama`, `telefon_boy`, `telefon_en`, `telefon_agirlik`, `telefon_renk`, `isletim_sistemi_id`) VALUES
	(1, 'Xiaomi Redmi Note 8 Pro', 'Xiaomi', 'Redmi Note 8', 1, 1, 1, 6, 2133, 64, 161, 76.4, 199, 'Beyaz-Siyah-Mavi-Yesil', 1);
/*!40000 ALTER TABLE `telefon` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_batarya
CREATE TABLE IF NOT EXISTS `telefon_batarya` (
  `batarya_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `batarya_kapasitesi` int(7) NOT NULL DEFAULT 0,
  `batarya_teknolojisi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `hizli_sarj_ozelligi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`batarya_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_batarya: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon_batarya` DISABLE KEYS */;
INSERT INTO `telefon_batarya` (`batarya_id`, `batarya_kapasitesi`, `batarya_teknolojisi`, `hizli_sarj_ozelligi`) VALUES
	(1, 4500, 'Lithium Polymer (Li-Po)', 'var');
/*!40000 ALTER TABLE `telefon_batarya` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_ekran
CREATE TABLE IF NOT EXISTS `telefon_ekran` (
  `ekran_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `ekran_boyutu` double unsigned NOT NULL DEFAULT 0,
  `ekran_teknolojisi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `ekran_cozunurlugu` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `piksel_yogunlugu` int(5) NOT NULL DEFAULT 0,
  `ekran_dayanikliligi` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`ekran_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_ekran: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon_ekran` DISABLE KEYS */;
INSERT INTO `telefon_ekran` (`ekran_id`, `ekran_boyutu`, `ekran_teknolojisi`, `ekran_cozunurlugu`, `piksel_yogunlugu`, `ekran_dayanikliligi`) VALUES
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
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_islemcileri: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon_islemcileri` DISABLE KEYS */;
INSERT INTO `telefon_islemcileri` (`islemci_id`, `yonga_seti`, `ana_islemci`, `cpu_frekansi`, `cpu_cekirdegi`, `islemci_mimarisi`, `birinci_yardimci_islemci`, `grafik_islemcisi_gpu`, `gpu_frekansi`, `cpu_uretim_teknolojisi`) VALUES
	(1, 'MediaTek Helio G90T', '	\r\nDual-core 2.05 GHz ARM Cortex-A76', 2.05, 8, 64, 'Hexa-core 2.0 GHz ARM Cortex-A55', '	\r\nMali-G76 MC4', 800, 12);
/*!40000 ALTER TABLE `telefon_islemcileri` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_isletimsistemi
CREATE TABLE IF NOT EXISTS `telefon_isletimsistemi` (
  `isletim_sistemi_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `isletim_sistemi_versiyon` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `isletim_sistemi` varchar(50) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  PRIMARY KEY (`isletim_sistemi_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_isletimsistemi: ~0 rows (approximately)
/*!40000 ALTER TABLE `telefon_isletimsistemi` DISABLE KEYS */;
INSERT INTO `telefon_isletimsistemi` (`isletim_sistemi_id`, `isletim_sistemi_versiyon`, `isletim_sistemi`) VALUES
	(1, 'Android 9.0 (Pie)', 'Android');
/*!40000 ALTER TABLE `telefon_isletimsistemi` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_kamera
CREATE TABLE IF NOT EXISTS `telefon_kamera` (
  `telefon_id` int(11) unsigned NOT NULL,
  `kamera_id` int(11) unsigned NOT NULL,
  PRIMARY KEY (`telefon_id`,`kamera_id`),
  KEY `kamera-kamera_id-FK` (`kamera_id`),
  CONSTRAINT `fk_kamera_telefon` FOREIGN KEY (`kamera_id`) REFERENCES `telefon_kameralari` (`Kamera_id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_telefon_kamera` FOREIGN KEY (`telefon_id`) REFERENCES `telefon` (`telefon_id`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_kamera: ~5 rows (approximately)
/*!40000 ALTER TABLE `telefon_kamera` DISABLE KEYS */;
INSERT INTO `telefon_kamera` (`telefon_id`, `kamera_id`) VALUES
	(1, 1),
	(1, 2),
	(1, 3),
	(1, 4),
	(1, 5);
/*!40000 ALTER TABLE `telefon_kamera` ENABLE KEYS */;

-- Dumping structure for table compare-tech.telefon_kameralari
CREATE TABLE IF NOT EXISTS `telefon_kameralari` (
  `kamera_id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `kamera_on_arka` varchar(25) COLLATE utf8_unicode_ci NOT NULL DEFAULT '0',
  `kamera_cozunurlugu` int(5) NOT NULL DEFAULT 0,
  `optik_goruntu_sabitleyici` varchar(5) COLLATE utf8_unicode_ci DEFAULT '0',
  `flas` varchar(25) COLLATE utf8_unicode_ci DEFAULT '0',
  `diafram_acikligi` double NOT NULL DEFAULT 0,
  `video_kayit_cozunurlugu` varchar(25) COLLATE utf8_unicode_ci DEFAULT '0',
  `video_fps_degeri` int(11) DEFAULT 0,
  PRIMARY KEY (`kamera_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- Dumping data for table compare-tech.telefon_kameralari: ~5 rows (approximately)
/*!40000 ALTER TABLE `telefon_kameralari` DISABLE KEYS */;
INSERT INTO `telefon_kameralari` (`kamera_id`, `kamera_on_arka`, `kamera_cozunurlugu`, `optik_goruntu_sabitleyici`, `flas`, `diafram_acikligi`, `video_kayit_cozunurlugu`, `video_fps_degeri`) VALUES
	(1, 'Arka', 64, 'Yok', 'Dual-LED-Tek Tonlu Flaş', 1.89, '2160p (Ultra HD) 4K', 30),
	(2, 'Arka', 8, '0', '0', 2.2, '0', 0),
	(3, 'Arka', 2, '0', '0', 2.4, '0', 0),
	(4, 'Arka', 2, '0', '0', 2.4, '0', 0),
	(5, 'Ön', 20, 'Yok', '0', 2, '1080p', 30);
/*!40000 ALTER TABLE `telefon_kameralari` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
