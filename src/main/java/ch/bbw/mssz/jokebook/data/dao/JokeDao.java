package ch.bbw.mssz.jokebook.data.dao;

import ch.bbw.mssz.jokebook.data.entity.Joke;

import java.util.Collection;

/**
 * JokeDao
 *
 * @author Matthias Stierlin
 * @version 22.09.2020
 */
public interface JokeDao {

    public Collection<Joke> getAllJokes();

    public void addJoke(Joke joke);

    public void updateJoke(int jokeId, Joke joke);

    public Joke getSpecificJoke(int jokeId);

    public void deleteJoke(int jokeId);
}
