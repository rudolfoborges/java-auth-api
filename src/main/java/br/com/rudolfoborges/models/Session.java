package br.com.rudolfoborges.models;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.auth0.jwt.JWTSigner;

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

    public Session(User user){
        this.user = user;
        this.lastLogin = new Date();
    }
    
    public void createJWTToken(String secret){
    	JWTSigner jwtSigner = new JWTSigner(secret);
    	Map<String, Object> claims = new HashMap<String, Object>();
    	claims.put("id", user.getId());
    	claims.put("email", user.getEmail());
    	claims.put("last_login", this.getLastLogin());
    	token = jwtSigner.sign(claims);
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
