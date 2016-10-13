package br.com.rudolfoborges.models;

import br.com.rudolfoborges.utils.encrypt.EncryptStrategy;
import br.com.rudolfoborges.utils.encrypt.Salt;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull @Length(max = 100)
    private String name;

    @NotNull @Length(max = 100) @Email
    @Column(unique = true)
    private String email;

    @NotNull @Length(max = 100)
    private String password;

    @Length(max = 50)
    private String salt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date created;

    @NotNull @Temporal(TemporalType.TIMESTAMP)
    private Date modified;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Phone> phones;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Session> session;

    public User(){
        this.modified = new Date();
    }

    public void defineCreatedDate(){
        this.created = new Date();
    }

    public void encodePassword(EncryptStrategy encryptStrategy){
        salt = Salt.get();
        password = encryptStrategy.encode(password, salt);
    }

    public Boolean verifyPassword(String chekedPassword){
        return password.equals(chekedPassword);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    public Date getCreated() { return created; }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public List<Session> getSession() {
        return session;
    }

    public void setSession(List<Session> session) {
        this.session = session;
    }
}
