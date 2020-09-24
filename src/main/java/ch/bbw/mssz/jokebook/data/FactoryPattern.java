package ch.bbw.mssz.jokebook.data;

import ch.bbw.mssz.jokebook.data.dao.JokeDao;
import ch.bbw.mssz.jokebook.data.dao.impl.AccessJokeDaoImpl;
import ch.bbw.mssz.jokebook.data.dao.impl.MySqlJokeDaoImpl;
import ch.bbw.mssz.jokebook.data.dao.impl.PostgreSqlJokeDaoImpl;

/**
 * Factory
 *
 * @author Matthias Stierlin
 * @version 24.09.2020
 */
public class FactoryPattern {
    public JokeDao getJokeDAO(String Database) {
        return switch (Database) {
            case "access" -> new AccessJokeDaoImpl();
            case "mysql" -> new MySqlJokeDaoImpl();
            case "postgres" -> new PostgreSqlJokeDaoImpl();
            default -> null;
        };
    }
}
