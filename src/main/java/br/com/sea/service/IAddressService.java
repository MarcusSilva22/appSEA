package br.com.sea.service;

import br.com.sea.model.Address;
import java.util.List;

/**
 *
 * @author Marcus
 */
public interface IAddressService {

    public void saveAddress(Address andress);

    public void updateAddress(Address andress);

    public void removeAddress(Long id_Andress);

    public List<Address> listAddress();
}
