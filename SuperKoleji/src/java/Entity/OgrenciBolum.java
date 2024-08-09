
package Entity;


import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "ogrenci_bolum")
public class OgrenciBolum implements Serializable{
    private static final long serialVersionUID = 1L;
 
    @Id     //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)   //Otomatik olarak id artar ve herkese uniqe değer verir
    private int id; 

    @ManyToOne
    @JoinColumn(name = "ogrenci_id")
    private Ogrenci ogrenci;

    @ManyToOne
    @JoinColumn(name = "bolum_id")
    private Bolum bolum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ogrenci getOgrenci() {
        return ogrenci;
    }

    public void setOgrenci(Ogrenci ogrenci) {
        this.ogrenci = ogrenci;
    }

    public Bolum getBolum() {
        return bolum;
    }

    public void setBolum(Bolum bolum) {
        this.bolum = bolum;
    }

}

