package br.com.sea.controller;

import br.com.sea.model.Phone;
import br.com.sea.service.IPhoneService;
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
@RequestMapping(value = "phones")
public class PhoneController {

    @Autowired
    IPhoneService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity savePhone(@RequestBody Phone phone) {
        try {
            service.savePhone(phone);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updatePhone(@RequestBody Phone phone) {
        try {
            service.updatePhone(phone);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "{id_Phone}", method = RequestMethod.DELETE)
    public ResponseEntity deletePhone(@PathVariable("id_Phone") Long id_Phone) {
        try {
            service.removePhone(id_Phone);
            return new ResponseEntity(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity listPhone() {
        try {
            List<Phone> phones = service.listPhone();
            return new ResponseEntity(phones, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

}
