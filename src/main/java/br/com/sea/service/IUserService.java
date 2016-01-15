package br.com.sea.service;

import br.com.sea.model.User;
import java.util.List;

/**
 *
 * @author Marcus
 */
public interface IUserService {

    public void saveUser(User user);

    public void updateUser(User user);

    public void removeUser(Long id_User);

    public List<User> getName(String name);

    public List<User> listUser();
}
