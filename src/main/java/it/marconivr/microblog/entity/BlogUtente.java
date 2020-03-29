/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Tutor
 */
@Entity
public class BlogUtente implements Serializable {
    
    @Id
    public String username;
    
    @Column(unique = true, nullable = false)
    public String email;
    
    @Column(nullable = false)
    public String password;
    
    @Column(unique = true, nullable = false)
    public String salt;
    
    @Column(nullable = false)
    public String ruolo = "UTENTE";




    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getRuolo() {
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }

    public BlogUtente() {
    }
}
