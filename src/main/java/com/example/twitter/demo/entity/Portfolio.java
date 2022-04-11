package com.example.twitter.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idportfolio")
    @JsonIgnore
    private Integer idportfolio;

    @Column(name = "description")
    private String description;

    @Column(name = "twitter_user_id")
    private String twitterUserId;
}
