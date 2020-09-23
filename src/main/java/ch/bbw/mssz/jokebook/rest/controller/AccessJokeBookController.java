package ch.bbw.mssz.jokebook.rest.controller;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.business.service.JokeService;
import ch.bbw.mssz.jokebook.rest.controller.response.JokeResponse;
import ch.bbw.mssz.jokebook.rest.mapper.JokeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

/**
 * AccessJokeBookController
 *
 * @author Matthias Stierlin
 * @version 18.09.2020
 */
@RestController
@RequestMapping(path = "/accessDB", produces = "application/json;charset=UTF-8")
public class AccessJokeBookController {

    @Autowired
    private JokeService jokeService;

    @Autowired
    private JokeMapper jokeMapper;

    @GetMapping
    public Collection<JokeResponse> getAccessJokes() {

        Collection<JokeBO> jokeResponses = this.jokeService.getAllJokes();
        return this.jokeMapper.mapJokes(jokeResponses);
    }
}
