package com.api.games.controller;

import com.api.games.model.Distributor;
import com.api.games.service.IDistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/distributor")
public class DistributorController {

    @Autowired
    private IDistributorService service;

    /**
     * @return
     */
    @GetMapping()
    public String index() {
        return "index";
    }

    /**
     * @param model
     * @return
     */
    @GetMapping("/all")
    public String index(Model model) {
        model.addAttribute("elements", service.getAll());
        return "index";
    }

    /**
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/{id}")
    public String getById(@PathVariable int id, Model model) {
        model.addAttribute("elements", service.getById(id));
        return "index";
    }

    /**
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/find")
    public String getByDistributor(@RequestParam("q") String name, Model model) {
        model.addAttribute("elements", service.findByName(name));
        return "index";
    }

    /**
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newDistributor(Distributor distributor, Model model) {
        model.addAttribute("distributor", distributor);
        return "index";
    }

    /**
     * @param distributor
     * @return
     */
    @PostMapping("/new")
    public String newDistributor(@ModelAttribute Distributor distributor) {
        if (!distributor.isEmpty()) {
            service.save(distributor);
        }
        return "redirect:/distributor";
    }

    /**
     * @return
     */
    @ModelAttribute("title")
    public String title() {
        return "Distributor";
    }

    /**
     * @return
     */
    @ModelAttribute("url")
    public String url() {
        return "distributor";
    }

}
