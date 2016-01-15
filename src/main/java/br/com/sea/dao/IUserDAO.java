package br.com.sea.dao;

import br.com.sea.model.User;
import java.util.List;

/**
 *
 * @author Marcus
 */
public interface IUserDAO {

    public void saveUser(User user);
    
    public void updateUser(User user);
    
    public void removeUser(Long id_User);

    public List<User> getName(String name);
    
    public List<User> listUser();

}
