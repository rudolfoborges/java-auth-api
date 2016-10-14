package br.com.rudolfoborges.models;

import com.auth0.jwt.JWTSigner;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "sessions")
public class Session {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Temporal(TemporalType.TIMESTAMP)
    private Date lastLogin;

    @NotNull @Length(max = 500)
    private String token;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Session(){}

    public Session(User user, Date loginDate, String token){
        this.user = user;
        this.lastLogin = loginDate;
        this.token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
