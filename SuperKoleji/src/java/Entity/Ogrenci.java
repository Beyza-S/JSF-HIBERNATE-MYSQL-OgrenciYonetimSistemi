package Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "ogrenci")
public class Ogrenci implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "kullanici_adi")
    private String kullanici_adi;

    @Column(name = "sifre")
    private String sifre;

    @Column(name = "telefon")
    private String telefon;

    @Column(name = "adres")
    private String adres;

    @Column(name = "giris_tarihi")
    private Date giris_tarihi;

    @Column(name = "cikis_tarihi")
    private Date cikis_tarihi;

    @Column(name = "tck_no", unique = true, nullable = false)
    private String tck_no;

    @ManyToMany
    @JoinTable(
        name = "ogrenci_bolum",
        joinColumns = @JoinColumn(name = "ogrenci_id"),
        inverseJoinColumns = @JoinColumn(name = "bolum_id")
    )
    private Set<Bolum> bolumler = new LinkedHashSet<>(); //Sıralı tutar


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKullanici_adi() {
        return kullanici_adi;
    }

    public void setKullanici_adi(String kullanici_adi) {
        this.kullanici_adi = kullanici_adi;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public Date getGiris_tarihi() {
        return giris_tarihi;
    }

    public void setGiris_tarihi(Date giris_tarihi) {
        this.giris_tarihi = giris_tarihi;
    }

    public Date getCikis_tarihi() {
        return cikis_tarihi;
    }

    public void setCikis_tarihi(Date cikis_tarihi) {
        this.cikis_tarihi = cikis_tarihi;
    }

    public String getTck_no() {
        return tck_no;
    }

    public void setTck_no(String tck_no) {
        this.tck_no = tck_no;
    }

    public Set<Bolum> getBolumler() {
        return bolumler;
    }

    public void setBolumler(Set<Bolum> bolumler) {
        this.bolumler = bolumler;
    }
}
