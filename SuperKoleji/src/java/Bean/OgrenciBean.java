package Bean;

import DAO.OgrenciDAO;
import Entity.Bolum;
import Entity.Ogrenci;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

@ManagedBean(name = "ogrenciBean")
@SessionScoped //HTTP oturumu başladığında oluşturulur ve oturum sonlandığında yok edilir.
public class OgrenciBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private Ogrenci ogrenci = new Ogrenci();
    private List<Ogrenci> ogrenciList;

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }
    
      public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public void setogrenciList(List<Ogrenci> ogrenciList) {
        this.ogrenciList = ogrenciList;
    }

    public List<Ogrenci> getOgrenciList() {
        return ogrenciList;
    }

    @PostConstruct
    public void init() {
        OgrenciDAO daod = new OgrenciDAO();
        ogrenciList = daod.findAll();
    }

    public String kaydet() {
        OgrenciDAO dao = new OgrenciDAO();
        dao.kaydet(ogrenci);
        ogrenci = new Ogrenci(); // Yeni kayıt için formu temizler
        ogrenciList = dao.findAll(); // Listeyi güncelle
        return "admin?faces-redirect=true"; // Admin sayfasına yönlendir
    }

    public void sil(Ogrenci ogrenci) {
        OgrenciDAO dao = new OgrenciDAO();
        dao.sil(ogrenci);
        ogrenciList = dao.findAll(); 
    }

    public String guncelle(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
        return "ogrenciEkle?faces-redirect=true";
    }
    
//    public String getBolumlerString(Ogrenci ogrenci) {
//    StringBuilder bolumlerOgrenci = new StringBuilder();
//    for (Bolum bolum : ogrenci.getBolumler()) {
//        if (bolumlerOgrenci.length() > 0) {
//            bolumlerOgrenci.append(", ");
//        }
//        bolumlerOgrenci.append(bolum.getAd());
//    }
//    return bolumlerOgrenci.toString();
//}

}
