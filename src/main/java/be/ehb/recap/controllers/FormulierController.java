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
public class FormulierController {

    @Autowired
    private ItemRepository repo;

    @RequestMapping(value = {"/formulier"}, method = RequestMethod.GET)
    public String showFormulier (ModelMap map){
        return "formulier";
    }

    @ModelAttribute("nieuwItem")
    public Item itemToSave(){return new Item();};

    @RequestMapping(value= "/formulier", method=RequestMethod.POST)
    public String saveItem (@ModelAttribute ("nieuwItem") @Valid Item nieuwItem, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "formulier";
        }
        repo.save(nieuwItem);
        return "redirect:/index";
    }

}
