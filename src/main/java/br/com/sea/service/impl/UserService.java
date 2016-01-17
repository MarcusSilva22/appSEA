package br.com.sea.service.impl;

import br.com.sea.dao.IUserDAO;
import br.com.sea.model.User;
import br.com.sea.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcus
 */
@Repository
public class UserService implements IUserService {

    @Autowired
    private IUserDAO dao;

    public void setUserDAO(IUserDAO UserDAO) {
        this.dao = UserDAO;
    }

    @Override
    @Transactional
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    @Transactional
    public void removeUser(Long id_User) {
        dao.removeUser(id_User);
    }

    @Override
    @Transactional
    public List<User> getName(String name) {
        List<User> user = this.dao.getName(name);
        return user;
    }

    @Override
    @Transactional
    public List<User> listUser() {
        List<User> user = this.dao.listUser();
        return user;
    }
}
