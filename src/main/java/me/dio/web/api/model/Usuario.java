package me.dio.web.api.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter
@Setter
@Entity
public class Usuario implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_id")
    private Integer id;
    @Column(length = 50,nullable = false)
    private String login;
    @Column(length = 100,nullable = false)
    private String password;
    public Usuario(String login, String password){
        this.login = login;
        this.password = password;
    }
    public Usuario(){}
}
