package fr.formation.inti.dao;

import org.hibernate.query.Query;

import fr.formation.inti.entity.User;

public class UserDaoImpl extends GenericDaoHibernate<User, Integer> {

	public User findUserByLoginAndPassword(String login, String password) {
		Query<User> query = this.session.createQuery("select u from User u where u.login =: login and u.password=: password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		User user = (User) query.getSingleResult();
		return user;
	}

}
