package br.com.sea.service.impl;

import br.com.sea.dao.IPhoneDAO;
import br.com.sea.model.Phone;
import br.com.sea.service.IPhoneService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Marcus
 */
@Service
public class PhoneService implements IPhoneService {

    @Autowired
    private IPhoneDAO dao;

    public void setPessoaDAO(IPhoneDAO PhoneDAO) {
        this.dao = PhoneDAO;
    }

    @Override
    @Transactional
    public void savePhone(Phone phone) {
        dao.savePhone(phone);
    }

    @Override
    @Transactional
    public void updatePhone(Phone phone) {
        dao.updatePhone(phone);
    }

    @Override
    @Transactional
    public void removePhone(Long id_Phone) {
        dao.removePhone(id_Phone);
    }

    @Override
    @Transactional
    public List<Phone> listPhone() {
        List<Phone> phone = this.dao.listPhone();
        return phone;
    }
}
