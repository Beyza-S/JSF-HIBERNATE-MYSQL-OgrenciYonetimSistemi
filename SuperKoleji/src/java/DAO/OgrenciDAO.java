package DAO;

import Entity.Ogrenci;
import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;
import utils.HibernateUtil;

public class OgrenciDAO implements Serializable {

    private static final long serialVersionUID = 1L;

    public OgrenciDAO() {
    }

    public Ogrenci findByKullanici_adiAndSifre(String kullanici_adi, String sifre) {
        Session session = HibernateUtil.openSession();
        Ogrenci ogrenci = null;
        try {
            ogrenci = (Ogrenci) session.createQuery("from Ogrenci o where o.kullanici_adi = :kullanici_adi and o.sifre = :sifre")
                    .setParameter("kullanici_adi", kullanici_adi)
                    .setParameter("sifre", sifre)
                    .uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ogrenci;
    }

    public List<Ogrenci> findAll() {
        Session session = HibernateUtil.openSession();
        List<Ogrenci> ogrenciler = null;
        try {
              ogrenciler = session.createQuery(
                    "select distinct o from Ogrenci o " +
                    "left join fetch o.bolumler")
                    .list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return ogrenciler;
    }

    public void kaydet(Ogrenci ogrenci) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.saveOrUpdate(ogrenci);
            transaction.commit(); // İşlem tamamlanır (commit)
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  //Hata olursa işlem geri alınır (rollback)
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void sil(Ogrenci ogrenci) {
        Session session = HibernateUtil.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(ogrenci);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
    }
}
