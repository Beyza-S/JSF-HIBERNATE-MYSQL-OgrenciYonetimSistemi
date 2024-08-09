package DAO;

import Entity.Personel;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import utils.HibernateUtil;

public class PersonelDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public PersonelDAO() {

    }

    public Personel findByKullanici_adiAndSifre(String kullanici_adi, String sifre) {
        Session session = HibernateUtil.openSession();
        Personel personel = null;
        try {
            personel = (Personel) session.createQuery("from Personel p where p.kullanici_adi = :kullanici_adi and p.sifre = :sifre")
                    .setParameter("kullanici_adi", kullanici_adi)
                    .setParameter("sifre", sifre)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personel;
    }

    public List<Personel> findAll() {
        Session session = HibernateUtil.openSession();
        List<Personel> personeller = null;
        try {
            System.out.println("burda");
             personeller = session.createQuery(
                    "select distinct p from Personel p " +
                    "left join fetch p.departmanlar")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return personeller;
    }

    public void kaydet(Personel personel) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(personel);
            transaction.commit(); // İşlem tamamlanır (commit)
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); //Hata olursa işlem geri alınır (rollback)
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void sil(Personel personel) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(personel);
            transaction.commit(); // İşlem tamamlanır (commit)
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback(); //Hata olursa işlem geri alınır (rollback)
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
