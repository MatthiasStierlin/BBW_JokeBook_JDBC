package ch.bbw.mssz.jokebook.rest.controller;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.business.service.JokeService;
import ch.bbw.mssz.jokebook.data.entity.Joke;
import ch.bbw.mssz.jokebook.rest.mapper.JokeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

/**
 * AccessJokeBookController
 *
 * @author Matthias Stierlin
 * @version 18.09.2020
 */
@Controller
public class AccessJokeBookController {

    @Autowired
    private JokeService jokeService;

    @Autowired
    private JokeMapper jokeMapper;

    @GetMapping("/accessDB")
    public String getAccessJokes(Model model) {
        model.addAttribute("accessJokes", this.jokeService.getAllJokes());
        model.addAttribute("newAccessJoke", new JokeBO());
        return "accessJokeList";
    }

    @PostMapping("/addAccessDBJoke")
    public String addAccessJokes(@ModelAttribute JokeBO jokeBO, Model model) {
        jokeService.addAccessJoke(jokeBO);
        model.addAttribute("accessJokes", this.jokeService.getAllJokes());
        return "redirect:/accessDB";
    }
    @GetMapping("/updateAccessDBJoke/{id}")
    public String updateAccessJoke(@PathVariable("id") int jokeId, Model model) {
        JokeBO jokeBoId = jokeService.getSpecificJoke(jokeId);
        model.addAttribute("accessJoke", jokeBoId);
        return "accessUpdate";
    }

    @PostMapping("/updateAccessDBJoke")
    public String postUpdateAccessJoke(JokeBO jokeBO, Model model) {
        jokeService.updateAccessJoke(jokeBO.getJokeId(),jokeBO);
        return "redirect:/accessDB";
    }

    @GetMapping("/deleteAccessDBJoke")
    public String deleteAccessDBJoke(@RequestParam(name="id", required = true) int jokeId, Model model) {
        jokeService.deleteAccessJoke(jokeId);
        return "redirect:/accessDB";
    }
}
