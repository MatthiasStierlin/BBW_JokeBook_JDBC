package ch.bbw.mssz.jokebook.rest.mapper;

import ch.bbw.mssz.jokebook.business.bo.JokeBO;
import ch.bbw.mssz.jokebook.rest.controller.response.JokeResponse;
import org.mapstruct.Mapper;

import java.util.Collection;

/**
 * JokeMapper
 *
 * @author Matthias Stierlin
 * @version 22.09.2020
 */
@Mapper(componentModel = "spring")
public interface JokeMapper {

    public Collection<JokeResponse> mapJokes(Collection<JokeBO> jokes);
}
