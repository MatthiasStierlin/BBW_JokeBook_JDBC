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
public class AccessJokeDaoImpl implements JokeDao {

    private static final String DATABASEURL = "jdbc:ucanaccess://C:/Developer/Data//BBW/M151//BBW_JokeBook_JDBC/SQL/JokeDB.mdb";
    private static final String DBDRIVER = "net.ucanaccess.jdbc.UcanaccessDriver";

    @Override
    public Collection<Joke> getAllJokes() {
        Collection<Joke> jokes =new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(DATABASEURL);
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

    @Override
    public Joke getSpecificJoke(int jokeId) {
        Joke joke = new Joke();
        try {
            Connection connection = DriverManager.getConnection(DATABASEURL);
            String sql = "SELECT * FROM  joke WHERE jokeid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, jokeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                joke = createJokeObjectForList(resultSet);
            }
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return joke;
    }

    @Override
    public void addAccessJoke(Joke joke) {
        try {
            Class.forName(DBDRIVER);
            Connection connection = DriverManager.getConnection(DATABASEURL);
            String sql = "INSERT INTO joke (content, rating, date) VALUES (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, joke.getContent());
            preparedStatement.setInt(2, joke.getRating());
            preparedStatement.setDate(3, joke.getDate());
            preparedStatement.executeUpdate();
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccessJoke(int jokeId,Joke joke) {
        try {
            Class.forName(DBDRIVER);
            Connection connection = DriverManager.getConnection(DATABASEURL);
            String sql = "UPDATE joke SET content=?, rating=?, date=? WHERE jokeid=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, joke.getContent());
            preparedStatement.setInt(2, joke.getRating());
            preparedStatement.setDate(3, joke.getDate());
            preparedStatement.setInt(4, jokeId);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
