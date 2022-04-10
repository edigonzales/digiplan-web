package ch.so.arp.digiplanweb.model;

import java.util.Date;

public class Dokument {
    private int tid;
    private String tilitid;
    private String titel;
    private String offiziellerTitel;
    private String offizielleNummer;
    private String rrbNr;
    private String typ;
    private String typTxt;
    private String textImWeb;
    private String abkuerzung;
    private int bfsnr;
    private String gemeindename;
    private Date publiziertAb;
    private Date publiziertBis;
    private String rechtsstatus;
    private int minX;
    private int minY;
    private int maxX;
    private int maxY;
    private int avgX;
    private int avgY;
    private int scale;
    
    public int getTid() {
        return tid;
    }
    public void setTid(int tid) {
        this.tid = tid;
    }
    public String getTilitid() {
        return tilitid;
    }
    public void setTilitid(String tilitid) {
        this.tilitid = tilitid;
    }
    public String getTitel() {
        return titel;
    }
    public void setTitel(String titel) {
        this.titel = titel;
    }
    public String getOffiziellerTitel() {
        return offiziellerTitel;
    }
    public void setOffiziellerTitel(String offiziellerTitel) {
        this.offiziellerTitel = offiziellerTitel;
    }
    public String getOffizielleNummer() {
        return offizielleNummer;
    }
    public void setOffizielleNummer(String offizielleNummer) {
        this.offizielleNummer = offizielleNummer;
    }
    public String getRrbNr() {
        return rrbNr;
    }
    public void setRrbNr(String rrbNr) {
        this.rrbNr = rrbNr;
    }
    public String getTyp() {
        return typ;
    }
    public void setTyp(String typ) {
        this.typ = typ;
    }
    public String getTypTxt() {
        return typTxt;
    }
    public void setTypTxt(String typTxt) {
        this.typTxt = typTxt;
    }
    public String getTextImWeb() {
        return textImWeb;
    }
    public void setTextImWeb(String textImWeb) {
        this.textImWeb = textImWeb;
    }
    public String getAbkuerzung() {
        return abkuerzung;
    }
    public void setAbkuerzung(String abkuerzung) {
        this.abkuerzung = abkuerzung;
    }
    public int getBfsnr() {
        return bfsnr;
    }
    public void setBfsnr(int bfsnr) {
        this.bfsnr = bfsnr;
    }
    public String getGemeindename() {
        return gemeindename;
    }
    public void setGemeindename(String gemeindename) {
        this.gemeindename = gemeindename;
    }
    public Date getPubliziertAb() {
        return publiziertAb;
    }
    public void setPubliziertAb(Date publiziertAb) {
        this.publiziertAb = publiziertAb;
    }
    public Date getPubliziertBis() {
        return publiziertBis;
    }
    public void setPubliziertBis(Date publiziertBis) {
        this.publiziertBis = publiziertBis;
    }
    public String getRechtsstatus() {
        return rechtsstatus;
    }
    public void setRechtsstatus(String rechtsstatus) {
        this.rechtsstatus = rechtsstatus;
    }
    public int getMinX() {
        return minX;
    }
    public void setMinX(int minX) {
        this.minX = minX;
    }
    public int getMinY() {
        return minY;
    }
    public void setMinY(int minY) {
        this.minY = minY;
    }
    public int getMaxX() {
        return maxX;
    }
    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }
    public int getMaxY() {
        return maxY;
    }
    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }
    public int getAvgX() {
        return avgX;
    }
    public void setAvgX(int avgX) {
        this.avgX = avgX;
    }
    public int getAvgY() {
        return avgY;
    }
    public void setAvgY(int avgY) {
        this.avgY = avgY;
    }
    public int getScale() {
        return scale;
    }
    public void setScale(int scale) {
        this.scale = scale;
    }
}
