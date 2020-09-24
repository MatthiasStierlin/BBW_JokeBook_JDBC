package ch.bbw.mssz.jokebook.rest.controller;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.business.service.JokeService;
import ch.bbw.mssz.jokebook.data.FactoryPattern;
import ch.bbw.mssz.jokebook.data.dao.JokeDao;
import ch.bbw.mssz.jokebook.data.entity.Joke;
import ch.bbw.mssz.jokebook.rest.mapper.JokeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * AccessJokeBookController
 *
 * @author Matthias Stierlin
 * @version 18.09.2020
 */
@Controller
public class AccessJokeBookController {

    private FactoryPattern factoryPattern = new FactoryPattern();

    JokeDao Access = factoryPattern.getJokeDAO("access");

    JokeDao MySql = factoryPattern.getJokeDAO("mysql");

    JokeDao Postgres = factoryPattern.getJokeDAO("postgres");

    @GetMapping("/accessDB")
    public String getAccessJokes(Model model) {
        model.addAttribute("accessJokes", Access.getAllJokes());
        model.addAttribute("newAccessJoke", new JokeBO());
        return "accessJokeList";
    }

    @PostMapping("/addAccessDBJoke")
    public String addAccessJokes(@ModelAttribute Joke joke, Model model) {
        Access.addJoke(joke);
        model.addAttribute("accessJokes", Access.getAllJokes());
        return "redirect:/accessDB";
    }
    @GetMapping("/updateAccessDBJoke/{id}")
    public String updateAccessJoke(@PathVariable("id") int jokeId, Model model) {
        Joke jokeBoId = Access.getSpecificJoke(jokeId);
        model.addAttribute("accessJoke", jokeBoId);
        return "accessUpdate";
    }

    @PostMapping("/updateAccessDBJoke")
    public String postUpdateAccessJoke(Joke joke, Model model) {
        Access.updateJoke(joke.getJokeId(),joke);
        return "redirect:/accessDB";
    }

    @GetMapping("/deleteAccessDBJoke")
    public String deleteAccessDBJoke(@RequestParam(name="id", required = true) int jokeId, Model model) {
        Access.deleteJoke(jokeId);
        return "redirect:/accessDB";
    }

    @GetMapping("/mysqlDB")
    public String getMysqlJokes(Model model) {
        model.addAttribute("mysqlJokes", MySql.getAllJokes());
        model.addAttribute("newMysqlJoke", new JokeBO());
        return "sqlJokeList";
    }

    @PostMapping("/addMysqlDBJoke")
    public String addMysqlJokes(@ModelAttribute Joke joke, Model model) {
        MySql.addJoke(joke);
        model.addAttribute("mysqlJokes", MySql.getAllJokes());
        return "redirect:/mysqlDB";
    }
    @GetMapping("/updateMysqlDBJoke/{id}")
    public String updateMysqlJoke(@PathVariable("id") int jokeId, Model model) {
        Joke jokeBoId = MySql.getSpecificJoke(jokeId);
        model.addAttribute("mysqlJoke", jokeBoId);
        return "mysqlUpdate";
    }

    @PostMapping("/updateMysqlDBJoke")
    public String postUpdateMysqlJoke(Joke joke, Model model) {
        MySql.updateJoke(joke.getJokeId(),joke);
        return "redirect:/mysqlDB";
    }

    @GetMapping("/deleteMysqlDBJoke")
    public String deleteMySqlDBJoke(@RequestParam(name="id", required = true) int jokeId, Model model) {
        MySql.deleteJoke(jokeId);
        return "redirect:/mysqlDB";
    }

    @GetMapping("/postgresDB")
    public String getPostgresJokes(Model model) {
        model.addAttribute("postgresJokes", Postgres.getAllJokes());
        model.addAttribute("newPostgresJoke", new JokeBO());
        return "postgresJokeList";
    }

    @PostMapping("/addPostgresDBJoke")
    public String addPostgresJokes(@ModelAttribute Joke joke, Model model) {
        Postgres.addJoke(joke);
        model.addAttribute("postgresJokes", Postgres.getAllJokes());
        return "redirect:/postgresDB";
    }
    @GetMapping("/updatePostgresDBJoke/{id}")
    public String updatePostgresJoke(@PathVariable("id") int jokeId, Model model) {
        Joke jokeBoId = Postgres.getSpecificJoke(jokeId);
        model.addAttribute("postgresJoke", jokeBoId);
        return "postgresUpdate";
    }

    @PostMapping("/updatePostgresDBJoke")
    public String postUpdatePostgresJoke(Joke joke, Model model) {
        Postgres.updateJoke(joke.getJokeId(),joke);
        return "redirect:/postgresDB";
    }

    @GetMapping("/deletePostgresDBJoke")
    public String deletePostgresDBJoke(@RequestParam(name="id", required = true) int jokeId, Model model) {
        Postgres.deleteJoke(jokeId);
        return "redirect:/postgresDB";
    }
}
