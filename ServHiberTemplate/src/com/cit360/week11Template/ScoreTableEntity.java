package com.cit360.week11Template;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "score_table", schema = "snake", catalog = "")
public class ScoreTableEntity {
    private int id;
    private String username;
    private Integer lastScore;
    private Integer highScore;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "last_score")
    public Integer getLastScore() {
        return lastScore;
    }

    public void setLastScore(Integer lastScore) {
        this.lastScore = lastScore;
    }

    @Basic
    @Column(name = "high_score")
    public Integer getHighScore() {
        return highScore;
    }

    public void setHighScore(Integer highScore) {
        this.highScore = highScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScoreTableEntity that = (ScoreTableEntity) o;
        return id == that.id &&
                Objects.equals(username, that.username) &&
                Objects.equals(lastScore, that.lastScore) &&
                Objects.equals(highScore, that.highScore);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, lastScore, highScore);
    }
}
