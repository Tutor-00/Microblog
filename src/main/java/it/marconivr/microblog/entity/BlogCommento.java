/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.marconivr.microblog.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author Tutor
 */
@Entity
public class BlogCommento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    public Date dataOra;
    
    @Lob
    @Column(nullable = false)
    public String contenuto;
    
    @ManyToOne(targetEntity = BlogUtente.class)
    @JoinColumn(nullable = false)
    public BlogUtente utente;
    
    @ManyToOne(targetEntity = BlogPost.class)
    @JoinColumn(nullable = false)
    public BlogPost post;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDataOra() {
        return dataOra;
    }

    public void setDataOra(Date dataOra) {
        this.dataOra = dataOra;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public BlogUtente getUtente() {
        return utente;
    }

    public void setUtente(BlogUtente utente) {
        this.utente = utente;
    }

    public BlogPost getPost() {
        return post;
    }

    public void setPost(BlogPost post) {
        this.post = post;
    }

    public BlogCommento() {
    }
    
    
    
}
