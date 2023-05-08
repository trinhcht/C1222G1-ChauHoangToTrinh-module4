package ss5.ss5.repository.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import ss5.ss5.model.Product;
import ss5.ss5.repository.ConnectionUtil;
import ss5.ss5.repository.IProductRepository;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {


    @Override
    public List<Product> listProductByName(String name) {
        TypedQuery<Product> query = ConnectionUtil.entityManager.createQuery("SELECT p FROM Product AS p WHERE P.name LIKE :param", Product.class);
        query.setParameter("param", "%" + name + "%");
        return query.getResultList();
    }

    @Override
    public void createProduct(Product product) {
        Transaction transaction = null;
        Session session = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(product);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public Product findById(int id) {
        Session session = null;
        Product product;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            product = (Product) session.createQuery("FROM Product where id = :id").setParameter("id", id).getSingleResult();
        }finally {
            if (session != null){
                session.close();
            }
        }
        return product;
    }


    @Override
    public void updateProduct(int id, Product product) {
        Transaction transaction = null;
        Session session = null;
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(product);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public void deleteProduct(int id) {
        Transaction transaction = null;
        Session session = null;
        Product product = findById(id);
        try{
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.delete(product);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

    @Override
    public List<Product> findAll() {
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            return session.createQuery("FROM Product", Product.class).getResultList();
        }catch (Exception e){
            throw e;
        }finally {
            if (session != null){
                session.close();
            }
        }
    }
}