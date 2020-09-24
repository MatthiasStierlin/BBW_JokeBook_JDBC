package ch.bbw.mssz.jokebook.business.service;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.data.entity.Joke;

import java.util.Collection;

/**
 * JokeService
 *
 * @author Matthias Stierlin
 * @version 22.09.2020
 */
public interface JokeService {

    public Collection<JokeBO> getAllAccessJokes();

    public void addAccessJoke(JokeBO jokeBO);

    public void updateAccessJoke(int jokeId, JokeBO jokeBO);

    public JokeBO getSpecificJoke(int jokeId);

    public void deleteAccessJoke(int jokeId);
}
