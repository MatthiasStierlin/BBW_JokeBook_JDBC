package ch.bbw.mssz.jokebook.rest.controller.response;

import java.sql.Date;

/**
 * JokeResponse
 *
 * @author Matthias Stierlin
 * @version 22.09.2020
 */
public class JokeResponse {
    private int jokeId;
    private String content;
    private int rating;
    private Date date;

    public JokeResponse() {
    }

    public int getJokeId() {
        return jokeId;
    }

    public void setJokeId(int jokeId) {
        this.jokeId = jokeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
