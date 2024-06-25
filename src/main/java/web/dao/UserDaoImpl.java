package web.dao;

import web.models.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private final SessionFactory sessionFactory;

    @Autowired
    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional(readOnly = true)
    public List<User> index() {
        return sessionFactory.getCurrentSession().createQuery("from User", User.class).list();
    }

    @Override
    @Transactional(readOnly = true)
    public User show(int id) {
        return sessionFactory.getCurrentSession().get(User.class, id);
    }

    @Override
    @Transactional
    public void save(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @Transactional
    public void update(int id, User user) {
        sessionFactory.getCurrentSession().update(user);
    }

    @Override
    @Transactional
    public void delete(int id) {
        User user = sessionFactory.getCurrentSession().load(User.class, id);
        if (user != null) {
            sessionFactory.getCurrentSession().delete(user);
        }
    }
}
