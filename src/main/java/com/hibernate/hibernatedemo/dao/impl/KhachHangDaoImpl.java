package com.hibernate.hibernatedemo.dao.impl;

import com.hibernate.hibernatedemo.dao.KhachHangDao;
import com.hibernate.hibernatedemo.entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;
@Repository
@Slf4j
public class KhachHangDaoImpl implements KhachHangDao {
//    @Autowired
//    private SessionFactory sessionFactory;

    @Autowired
    private EntityManagerFactory entityManagerFactory;

    @Override
    public List<KhachHang> findAll(String diachi) {
//        Session session = null;
//        Transaction transaction = null;
        EntityManager entityManager = null;
        EntityTransaction entityTransaction =  null;
        List<KhachHang> lists = null;
        try {
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
            entityManager = entityManagerFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
//            lists = session.createQuery("select k from KhachHang k", KhachHang.class).getResultList();
//            transaction.commit();
            lists = entityManager.createQuery("select k from KhachHang k where k.diaChi like :diachi", KhachHang.class).setParameter("diachi","%"+diachi+"%").getResultList();
            entityTransaction.commit();
        }catch (Exception e){
            log.error("exception occurred ",e);
//            if(transaction!=null){
//                transaction.rollback();
//            }
            if(entityTransaction!=null){
                entityTransaction.rollback();
            }
        }finally {
//            session.close();
            entityManager.close();
        }
        return lists;
    }
}
