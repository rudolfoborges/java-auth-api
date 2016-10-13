package br.com.rudolfoborges.models;

import br.com.rudolfoborges.utils.encrypt.BCrypt;
import br.com.rudolfoborges.utils.encrypt.EncryptStrategy;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

public class Login {

    @NotEmpty
    private String email;
    @NotEmpty
    private String password;

    public Boolean verify(EncryptStrategy encryptStrategy, User user){
        String encodePassword = encryptStrategy.encode(password, user.getSalt());
        return (user != null && user.verifyPassword(encodePassword));
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

}
