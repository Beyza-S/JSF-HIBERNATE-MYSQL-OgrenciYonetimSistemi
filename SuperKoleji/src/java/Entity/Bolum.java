
package Entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bolum")
public class Bolum implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ad")
    private String ad;

    @ManyToMany(mappedBy = "bolumler")
    private Set<Ogrenci> ogrenciler = new LinkedHashSet<>();//Sıralı tutar


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public Set<Ogrenci> getOgrenciler() {
        return ogrenciler;
    }

    public void setOgrenciler(Set<Ogrenci> ogrenciler) {
        this.ogrenciler = ogrenciler;
    }
}
