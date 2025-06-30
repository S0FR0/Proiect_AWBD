package com.webapp.controller;

import com.webapp.model.Address;
import com.webapp.model.Person;
import com.webapp.service.AddressService;
import com.webapp.service.PersonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/addresses")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       @RequestParam(defaultValue = "city") String sortBy,
                       @RequestParam(defaultValue = "asc") String sortDir,
                       Model model) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Address> addresses = addressService.findAll(pageable);

        model.addAttribute("addresses", addresses);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "address/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("address", new Address());

        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);

        return "address/form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Address> address = addressService.findById(id);
        if (address.isPresent()) {
            model.addAttribute("address", address.get());

            List<Person> persons = personService.findAll();
            model.addAttribute("persons", persons);

            return "address/form";
        }
        return "redirect:/addresses";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Address address, BindingResult result, Model model) {
        if (result.hasErrors()) {
            List<Person> persons = personService.findAll();
            model.addAttribute("persons", persons);
            return "address/form";
        }
        addressService.save(address);
        return "redirect:/addresses";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        addressService.deleteById(id);
        return "redirect:/addresses";
    }
}