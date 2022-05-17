package com.api.games.controller;

import com.api.games.model.Distributor;
import com.api.games.model.Game;
import com.api.games.service.IDistributorService;
import com.api.games.service.IGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private IGameService service;
    @Autowired
    private IDistributorService distributorService;

    /**
     * @return
     */
    @GetMapping()
    public String index() {
        return "index";
    }

    @GetMapping("/all")
    public String getAll(Model model) {
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
    public String findByName(@RequestParam("q") String name, Model model) {
        model.addAttribute("games", service.findByName(name));
        return "index";
    }

    /**
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newGame(Game game, Model model) {
        model.addAttribute("game", game);
        return "index";
    }

    /**
     * @param game
     * @return
     */
    @PostMapping("/new")
    public String newGame(@ModelAttribute Game game) {
        if (!game.isEmpty()) {
            service.save(game);
        }
        return "redirect:/game";
    }

    /**
     * @return
     */
    @ModelAttribute("title")
    public String title() {
        return "Game";
    }

    /**
     * @return
     */
    @ModelAttribute("url")
    public String url() {
        return "game";
    }

    /**
     * @return
     */
    @ModelAttribute("distributors")
    public List<Distributor> getDistributors() {
        return distributorService.getAll();
    }
}
