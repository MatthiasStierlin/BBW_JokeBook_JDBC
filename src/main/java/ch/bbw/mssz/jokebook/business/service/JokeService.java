package ch.bbw.mssz.jokebook.business.service;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;

import java.util.Collection;

/**
 * JokeService
 *
 * @author Matthias Stierlin
 * @version 22.09.2020
 */
public interface JokeService {

    public Collection<JokeBO> getAllJokes();
}
