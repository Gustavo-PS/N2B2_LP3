package project.N2_LP3.MODEL;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.UUID;

public class Aluno {
    private final UUID id;
    private final String name;
    private final String login;
    private final String password;
    private final Date birthday;
    private final Character genre;
    private final Double width;
    private final Double height;
    private final String training;
    private final String instructor;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public Character getGenre() {
        return genre;
    }

    public Double getWidth() {
        return width;
    }

    public Double getHeight() {
        return height;
    }

    public String getTraining() {
        return training;
    }

    public String getInstructor() {
        return instructor;
    }

    public Aluno(@JsonProperty("id") UUID id, @JsonProperty("name") String name, @JsonProperty("login") String login,
                 @JsonProperty("password") String password, @JsonProperty("birthday") Date birthday,
                 @JsonProperty("genre") Character genre, @JsonProperty("width") Double width, @JsonProperty("heigth") Double heigth,
                 @JsonProperty("training") String training, @JsonProperty("instructor") String instructor) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.birthday = birthday;
        this.genre = genre;
        this.width = width;
        this.height = heigth;
        this.training = training;
        this.instructor = instructor;
    }
}
