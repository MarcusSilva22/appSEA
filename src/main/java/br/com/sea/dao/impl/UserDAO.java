package br.com.sea.dao.impl;

import br.com.sea.dao.IUserDAO;
import br.com.sea.model.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcus
 */
@Repository
public class UserDAO implements IUserDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void saveUser(User user) {
        try {
            em.persist(user);
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao cadastrar usuário!" + e);
        }
    }

    @Override
    public void updateUser(User user) {
        try {
            if (em.find(User.class, user.getId_User()) == null) {
                System.out.println("Usuário não cadastrado!!");
            } else {
                em.merge(user);
                System.out.println("Usuário atualizado!");
            }
        } catch (Exception e) {
            System.out.println("Erro ao atualizar usuário!");
        }

    }

    @Override
    public void removeUser(Long id_User) {
        User user = em.find(User.class, id_User);

        try {
            if (user == null) {
                System.out.println("Usuário não cadastrado no sistema!");
            } else {
                em.remove(user);
                System.out.println("Usuário removido!");
            }

        } catch (Exception e) {
            System.out.println("Erro ao remover usuário!");
        }
    }

    @Override
    public List<User> getName(String name) {
        try {

            TypedQuery<User> query = em.createNamedQuery("User.byName", User.class);
            query.setParameter("name", name);
            return query.getResultList();

        } catch (Exception e) {
            System.out.println("Erro ao consultar usuário!\n" + e);
        }

        return null;
    }

    @Override
    public List<User> listUser() {
        try {
            List<User> users = em.createNamedQuery("User.findAll").getResultList();
            return users;
        } catch (Exception e) {
            System.out.println("Erro ao listar alunos!");
        }
        return null;
    }
}
