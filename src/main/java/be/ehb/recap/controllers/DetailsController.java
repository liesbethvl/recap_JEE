package be.ehb.recap.controllers;

import be.ehb.recap.model.Item;
import be.ehb.recap.model.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class DetailsController {

    @Autowired
    private ItemRepository repo;

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showDetails (@PathVariable(name="id") int id , ModelMap map){

        Item detItem = repo.findById(id).get();
        map.addAttribute("product", detItem);
        return "details";
    }
}
