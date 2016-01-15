package br.com.sea.dao.impl;

import br.com.sea.dao.IPhoneDAO;
import br.com.sea.model.Phone;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcus
 */
@Repository
public class PhoneDAO implements IPhoneDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void savePhone(Phone phone) {
        try {
            em.persist(phone);
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.out.println("Error!" + e);
        }
    }

    @Override
    public void updatePhone(Phone phone) {
        try {
            if (em.find(Phone.class, phone.getId_Phone()) == null) {
                System.out.println("Phone não cadastrado!!");
            } else {
                em.merge(phone);
                System.out.println("Success!");
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public void removePhone(Long id_Phone) {
        Phone phone = em.find(Phone.class, id_Phone);

        try {
            if (phone == null) {
                System.out.println("Phone não cadastrado no sistema!");
            } else {
                em.remove(phone);
                System.out.println("Success!");
            }

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public List<Phone> listPhone() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
