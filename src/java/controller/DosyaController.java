/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entity.Dosya;
import java.io.File;
import java.io.InputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.http.Part;

/**
 *
 * @author techn
 */
@Named
@SessionScoped
public class DosyaController implements Serializable {

    private Dosya document;
    private DataAccess.DosyaDAO documentDao;
    private List<Dosya> telefonDocumentList;
    private List<Dosya> televizyonDocumentList;
    private List<Dosya> laptopDocumentList;

    private Part doc;
    private final String uploadTo = "/Users/techn/OneDrive/Masaüstü/New Folder (11)/New Folder/Teknolojik-Urunleri-Karsilastirma/web/resources/img/resim/";

    public void telefonUpload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());

            this.getDocumentDao().telefonInsert(document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void televizyonUpload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());

            this.getDocumentDao().televizyonInsert(document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void laptopUpload() {
        try {
            InputStream input = doc.getInputStream();
            File f = new File(uploadTo + doc.getSubmittedFileName());
            Files.copy(input, f.toPath());

            document = this.getDocument();
            document.setFilePath(f.getParent());
            document.setFileName(f.getName());
            document.setFileType(doc.getContentType());

            this.getDocumentDao().laptopInsert(document);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void telefonDelete(Dosya document) {
        try {
            this.getDocumentDao().telefonDelete(document);
            File f = new File(uploadTo + document.getFileName());
            f.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void laptopDelete(Dosya document) {
        try {
            this.getDocumentDao().laptopDelete(document);
            File f = new File(uploadTo + document.getFileName());
            f.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void televizyonDelete(Dosya document) {
        try {
            this.getDocumentDao().televizyonDelete(document);
            File f = new File(uploadTo + document.getFileName());
            f.delete();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public String getUploadTo() {
        return uploadTo;
    }

    public Dosya getDocument() {
        if (this.document == null) {
            this.document = new Dosya();
        }
        return document;
    }

    public void setDocument(Dosya document) {
        this.document = document;
    }

    public DataAccess.DosyaDAO getDocumentDao() {
        if (this.documentDao == null) {
            this.documentDao = new DataAccess.DosyaDAO();
        }
        return documentDao;
    }

    public void setDocumentDao(DataAccess.DosyaDAO documentDao) {
        this.documentDao = documentDao;
    }

    public List<Dosya> getTelefonDocumentList() {
        this.telefonDocumentList = this.getDocumentDao().telefonFindAll();
        return telefonDocumentList;
    }

    public void setTelefonDocumentList(List<Dosya> telefonDocumentList) {
        this.telefonDocumentList = telefonDocumentList;
    }

    public List<Dosya> getTelevizyonDocumentList() {
        this.televizyonDocumentList = this.getDocumentDao().televizyonFindAll();
        return televizyonDocumentList;
    }

    public void setTelevizyonDocumentList(List<Dosya> televizyonDocumentList) {
        this.televizyonDocumentList = televizyonDocumentList;
    }

    public List<Dosya> getLaptopDocumentList() {
        this.laptopDocumentList = this.getDocumentDao().laptopFindAll();
        return laptopDocumentList;
    }

    public void setLaptopDocumentList(List<Dosya> laptopDocumentList) {
        this.laptopDocumentList = laptopDocumentList;
    }

    public Part getDoc() {
        return doc;
    }

    public void setDoc(Part doc) {
        this.doc = doc;
    }

}
