package com.nduyhai.store.controller;

import com.nduyhai.store.repository.StoreRepository;
import com.nduyhai.store.repository.entities.Customer;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class StoreController {
    @Autowired
    private  StoreRepository repository;
    
    @RequestMapping(value = "/store", method = RequestMethod.GET)
    public List<Customer> getCustomer() {
        return repository.getCustomer();
    }
    
    @RequestMapping(value = "/fake", method = RequestMethod.GET)
    public List<Customer> getFakeCustomer() {
        return repository.getFakeCustomer();
    }
}
