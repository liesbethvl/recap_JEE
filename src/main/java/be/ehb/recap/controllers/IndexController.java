package be.ehb.recap.controllers;

import be.ehb.recap.model.Item;
import be.ehb.recap.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
public class IndexController {

    @Autowired
    private ItemRepository repo;

    @ModelAttribute("all")
    public Iterable<Item> findAll() {
        return repo.findAll();
    }

    @RequestMapping (value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndex (ModelMap map){
        return "index";
    }

    @ModelAttribute("nieuwProduct")
    public Item productToSave(){
        return new Item();
    }




}
