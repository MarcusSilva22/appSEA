package br.com.sea.service.impl;

import br.com.sea.dao.IAddressDAO;
import br.com.sea.model.Address;
import br.com.sea.service.IAddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcus
 */
@Service
public class AddressService implements IAddressService {

    @Autowired
    private IAddressDAO dao;

    public void setPessoaDAO(IAddressDAO AddressDAO) {
        this.dao = AddressDAO;
    }

    @Override
    @Transactional
    public void saveAddress(Address andress) {
        dao.saveAddress(andress);
    }

    @Override
    @Transactional
    public void updateAddress(Address andress) {
        dao.updateAddress(andress);
    }

    @Override
    @Transactional
    public void removeAddress(Long id_Andress) {
        dao.removeAddress(id_Andress);
    }

    @Override
    @Transactional
    public List<Address> listAddress() {
        List<Address> address = this.dao.listAddress();
        return address;
    }

}
