
package Entity;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "personel_departman")
public class PersonelDepartman implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToMany
    @JoinColumn(name = "personel_id")
    private Personel personel;

    @ManyToMany
    @JoinColumn(name = "departman_id")
    private Departman departman;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Personel getPersonel() {
        return personel;
    }

    public void setPersonel(Personel personel) {
        this.personel = personel;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    
}

