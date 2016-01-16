/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sea.dao.impl;

import br.com.sea.dao.IAddressDAO;
import br.com.sea.model.Address;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Marcus
 */
@Repository
public class AddressDAO implements IAddressDAO {

    @PersistenceContext(name="DesafioPU")
    private EntityManager em;

    @Override
    public void saveAddress(Address andress) {
        try {
            em.persist(andress);
            System.out.println("Sucess!");
        } catch (Exception e) {
            System.out.println("Error!" + e);
        }
    }

    @Override
    public void updateAddress(Address andress) {
        try {
            if (em.find(Address.class, andress.getId_Address()) == null) {
                System.out.println("Endereço não cadastrado!!");
            } else {
                em.merge(andress);
                System.out.println("Success!");
            }
        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public void removeAddress(Long id_Andress) {
        Address andress = em.find(Address.class, id_Andress);

        try {
            if (andress == null) {
                System.out.println("Endreço não cadastrado no sistema!");
            } else {
                em.remove(andress);
                System.out.println("Success!");
            }

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    @Override
    public List<Address> listAddress() {
        try {
            List<Address> addresses = em.createNamedQuery("Address.findAll").getResultList();
            return addresses;
        } catch (Exception e) {
            System.out.println("Erro ao listar telefones!");
        }
        return null;
    }
}
