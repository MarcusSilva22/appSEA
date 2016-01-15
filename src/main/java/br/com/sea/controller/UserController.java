package br.com.sea.controller;

import br.com.sea.model.User;
import br.com.sea.service.IUserService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Marcus
 */
@Controller
@RequestMapping(value = "users")
public class UserController {

    @Autowired
    IUserService service;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity saveUser(@RequestBody User user) {
        try {
            service.saveUser(user);
            return new ResponseEntity(HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity(HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity listUser() {
        List<User> user = service.listUser();

        return new ResponseEntity(user, HttpStatus.OK);
    }

}
