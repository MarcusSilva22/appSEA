package br.com.sea.controller;

import br.com.sea.model.Address;
import br.com.sea.service.IAddressService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcus
 */
@Controller
@RequestMapping(value = "addresses")
public class AddressController {
    
    @Autowired
    IAddressService service;
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity savePhone(@RequestBody Address address) {
        try {
            service.saveAddress(address);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePhone(@RequestBody Address address) {
        try {
            service.updateAddress(address);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "{id_Address}", method = RequestMethod.DELETE)
    public ResponseEntity deletePhone(@PathVariable("id_Address") Long id_Address) {
        try {
            service.removeAddress(id_Address);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity listPhone() {
        try {
            List<Address> addresses = service.listAddress();
            return new ResponseEntity(addresses, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
