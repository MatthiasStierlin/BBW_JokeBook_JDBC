package ch.bbw.mssz.jokebook.business.service.impl;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.business.mapper.JokeBOMapper;
import ch.bbw.mssz.jokebook.business.service.JokeService;
import ch.bbw.mssz.jokebook.data.dao.JokeDao;
import ch.bbw.mssz.jokebook.data.entity.Joke;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Access;
import java.util.Collection;

/**
 * AccessJokeBookServiceImpl
 *
 * @author Matthias Stierlin
 * @version 18.09.2020
 */
@Service
public class JokeServiceImpl implements JokeService {

    @Autowired
    private JokeDao jokeDao;

    @Autowired
    private JokeBOMapper jokeBOMapper;

    @Override
    public Collection<JokeBO> getAllJokes() {
        Collection<Joke> jokes = jokeDao.getAllJokes();
        return this.jokeBOMapper.mapJokes(jokes);
    }
}