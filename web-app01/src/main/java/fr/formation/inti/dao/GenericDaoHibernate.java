package fr.formation.inti.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import fr.formation.inti.utils.HibernateUtils;

public class GenericDaoHibernate<T, I extends Serializable> implements IGenericDao<T, I> {

	private static final Log log = LogFactory.getLog(GenericDaoHibernate.class);
	private SessionFactory sf;
	protected Session session;
	private Transaction tx;

	private final Class<T> type;

	public GenericDaoHibernate() {
		sf = HibernateUtils.getSessionFactory();
		session = sf.getCurrentSession();
		tx = session.getTransaction();
		ParameterizedType genericSuperclass = (ParameterizedType) getClass().getGenericSuperclass();
		this.type = (Class<T>) genericSuperclass.getActualTypeArguments()[0];
	}

	public GenericDaoHibernate(Class<T> type) {
		this.type = type;
	}

	public Class<T> getType() {
		return type;
	}

	public void beginTransaction() {
		if (!session.isOpen()) {
			session = sf.openSession();
		}
		if(!tx.isActive())
			session.getTransaction().begin();
		log.info("---------------- Start transaction -----------------");
	}

	public void commitTransaction() {
		session.getTransaction().commit();
	}

	public void rollBackTransaction() {
		session.getTransaction().rollback();
	}

	public void closeTransaction() {
		session.close();
		sf.close();
	}

	@Override
	public I save(T t) {
		I id = (I) session.save(t);
		return id;
	}

	@Override
	public void update(T t) {
		session.update(t);

	}

	@Override
	public void delete(I i) {
		T e = findById(i);
		session.delete(e);

	}

	@Override
	public T findById(I i) {
		return session.get(type, i);
	}

	@Override
	public List<T> findAll() {
		return session.createQuery("select e from " + type.getName() + " e").getResultList();
	}

	@Override
	public void delete(T t) {
		// TODO Auto-generated method stub
		
	}

}
