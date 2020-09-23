package ch.bbw.mssz.jokebook.data.dao.impl;

import ch.bbw.mssz.jokebook.data.dao.JokeDao;
import ch.bbw.mssz.jokebook.data.entity.Joke;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * AccessJokeBook
 *
 * @author Matthias Stierlin
 * @version 11.09.2020
 */
@Repository
public class AccessJokeImpl implements JokeDao {


    @Override
    public Collection<Joke> getAllJokes() {

        String databaseUrl = "jdbc:ucanaccess://C://Developer//Data//BBW//M151//BBW_JokeBook_JDBC//SQL//JokeDB.accdb";

        Collection<Joke> jokes =new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(databaseUrl);

            String sql = "SELECT * FROM  joke";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                jokes.add(createJokeObjectForList(resultSet));
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    return jokes;
    }

    private Joke createJokeObjectForList(ResultSet resultSet) throws SQLException {
        Joke joke = new Joke();

        joke.setJokeId(resultSet.getInt("jokeid"));
        joke.setContent(resultSet.getString("content"));
        joke.setRating(resultSet.getInt("rating"));
        joke.setDate(resultSet.getDate("date"));
        return joke;
    }

}
