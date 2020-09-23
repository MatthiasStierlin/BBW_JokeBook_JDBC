package ch.bbw.mssz.jokebook.business.mapper;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.data.entity.Joke;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * JokeBOMapper
 *
 * @author Matthias Stierlin
 * @version 22.09.2020
 */
@Mapper(componentModel = "spring")
public interface JokeBOMapper {

    public Collection<JokeBO> mapJokes(Collection<Joke> jokes);
}
