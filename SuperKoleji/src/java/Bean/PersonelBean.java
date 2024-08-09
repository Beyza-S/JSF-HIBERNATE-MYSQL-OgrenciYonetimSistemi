package Bean;

import DAO.PersonelDAO;
import Entity.Departman;
import Entity.Personel;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean(name = "personelBean")
@SessionScoped   //HTTP oturumu başladığında oluşturulur ve oturum sonlandığında yok edilir.
public class PersonelBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Personel personel = new Personel();
    private List<Personel> personelList;

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setPersonelList(List<Personel> personelList) {
        this.personelList = personelList;
    }

    public List<Personel> getPersonelList() {
        return personelList;
    }

    @PostConstruct
    public void init() { //İlk başlatılmasnı sağlar
        PersonelDAO daod = new PersonelDAO();
        personelList = daod.findAll();
    }

    public String kaydet() {
        PersonelDAO dao = new PersonelDAO();
        dao.kaydet(personel);
        personel = new Personel(); // Yeni kayıt için formu temizler
        personelList = dao.findAll(); // Listeyi güncelle
        return "admin?faces-redirect=true"; // Admin sayfasına yönlendir
    }

    public void sil(Personel personel) {
        PersonelDAO dao = new PersonelDAO();
        dao.sil(personel);
        personelList = dao.findAll();
    }

    public String guncelle(Personel personel) {
        this.personel = personel;
        return "personelEkle?faces-redirect=true";
    }
    
}
