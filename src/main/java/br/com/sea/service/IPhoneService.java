package br.com.sea.service;

import br.com.sea.model.Phone;
import java.util.List;

/**
 *
 * @author Marcus
 */
public interface IPhoneService {

    public void savePhone(Phone phone);

    public void updatePhone(Phone phone);

    public void removePhone(Long id_Phone);

    public List<Phone> listPhone();
}
