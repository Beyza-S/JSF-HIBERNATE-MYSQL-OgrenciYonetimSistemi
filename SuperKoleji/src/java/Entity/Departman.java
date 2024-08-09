
package Entity;


import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "departman")
public class Departman implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ad")
    private String ad;

    @ManyToMany(mappedBy = "departmanlar")
    private Set<Personel> personeller = new LinkedHashSet<>();  //Sıralı tutar


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

    public Set<Personel> getPersoneller() {
        return personeller;
    }

    public void setPersoneller(Set<Personel> personeller) {
        this.personeller = personeller;
    }
}
