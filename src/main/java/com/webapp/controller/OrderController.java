package com.webapp.controller;

import com.webapp.model.Order;
import com.webapp.model.Person;
import com.webapp.service.OrderService;
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

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private PersonService personService;

    @GetMapping
    public String list(@RequestParam(defaultValue = "0") int page,
                       @RequestParam(defaultValue = "5") int size,
                       @RequestParam(defaultValue = "orderDate") String sortBy,
                       @RequestParam(defaultValue = "desc") String sortDir,
                       Model model) {

        Sort sort = sortDir.equalsIgnoreCase("desc") ?
                Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Order> orders = orderService.findAll(pageable);

        model.addAttribute("orders", orders);
        model.addAttribute("sortBy", sortBy);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        return "order/list";
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        Order order = new Order();
        // Setează data curentă ca default
        order.setOrderDate(LocalDateTime.now());

        model.addAttribute("order", order);

        // Încarcă toate persoanele pentru dropdown
        List<Person> persons = personService.findAll();
        model.addAttribute("persons", persons);

        return "order/form";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Order> order = orderService.findById(id);
        if (order.isPresent()) {
            model.addAttribute("order", order.get());

            // Încarcă toate persoanele pentru dropdown
            List<Person> persons = personService.findAll();
            model.addAttribute("persons", persons);

            return "order/form";
        }
        return "redirect:/orders";
    }

    @PostMapping
    public String save(@Valid @ModelAttribute Order order, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // Reîncarcă persoanele pentru dropdown în caz de eroare
            List<Person> persons = personService.findAll();
            model.addAttribute("persons", persons);
            return "order/form";
        }

        // Generează numărul comenzii dacă e nouă
        if (order.getId() == null && (order.getOrderNumber() == null || order.getOrderNumber().isEmpty())) {
            order.setOrderNumber(generateOrderNumber());
        }

        orderService.save(order);
        return "redirect:/orders";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        orderService.deleteById(id);
        return "redirect:/orders";
    }

    // Metoda pentru generarea numărului comenzii
    private String generateOrderNumber() {
        return "ORD-" + System.currentTimeMillis();
    }
}