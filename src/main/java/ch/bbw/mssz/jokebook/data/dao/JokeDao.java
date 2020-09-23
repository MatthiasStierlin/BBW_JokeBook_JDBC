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
}
