package Bean;

import DAO.OgrenciDAO;
import DAO.PersonelDAO;
import Entity.Ogrenci;
import Entity.Personel;
import java.io.IOException;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean(name = "loginBean")
@SessionScoped //HTTP oturumu başladığında oluşturulur ve oturum sonlandığında yok edilir.
public class LoginBean implements Serializable {

    private static final long serialVersionUID = 1L; //Benzersiz kimlik verir

    private String kullanici_adi;
    private String sifre;

    @ManagedProperty(value = "#{personelBean}")
    private PersonelBean personelBean;

    @ManagedProperty(value = "#{ogrenciBean}")
    private OgrenciBean ogrenciBean;

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

    public void setPersonelBean(PersonelBean personelBean) {
        this.personelBean = personelBean;
    }

    public void setOgrenciBean(OgrenciBean ogrenciBean) {
        this.ogrenciBean = ogrenciBean;
    }

    public String login() {
        PersonelDAO personelDao = new PersonelDAO();
        OgrenciDAO ogrenciDao = new OgrenciDAO();

        Personel personel = personelDao.findByKullanici_adiAndSifre(kullanici_adi, sifre);
        Ogrenci ogrenci = ogrenciDao.findByKullanici_adiAndSifre(kullanici_adi, sifre);
        if (personel != null) {
            personelBean.setPersonel(personel); // Personel bilgileri
            if ("Beyza".equals(kullanici_adi) && "123".equals(sifre)) {
                return "admin?faces-redirect=true";
            } else {
                return "personelAnaSayfa?faces-redirect=true";
            }
        } else if (ogrenci != null) {
            ogrenciBean.setOgrenci(ogrenci); // Öğrenci bilgileri
            return "ogrenciAnaSayfa?faces-redirect=true";
        }

        return "login?faces-redirect=true";
    }
}
