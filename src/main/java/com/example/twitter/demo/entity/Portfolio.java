package com.example.twitter.demo.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "portfolio")
public class Portfolio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idportfolio")
    private Integer idPortfolio;

    @Column(name = "description")
    private String description;

    @Column(name = "experience_summary")
    private String experienceSummary;

    @Column(name="image_url")
    private String imageUrl;

    @Column(name="last_names")
    private String lastNames;

    @Column(name="names")
    private String names;

    @Column(name="user_id")
    private String userId;

    @Column(name="address")
    private String address;

    @Column(name="email")
    private String email;

    @Column(name="experience")
    private String experience;

    @Column(name="image_path")
    private String imagePath;

    @Column(name="name")
    private String name;

    @Column(name="phone")
    private String phone;

    @NotNull(message = "el campo twitterUserId no puede ser nulo")
    @NotEmpty(message = "el campo twitterUserId no puede ser vacío")
    @Column(name = "twitter_user_id")
    private String twitterUserId;

    @Column(name="twitter_user_name")
    private String twitterUserName;

    @Column(name="zip_code")
    private String zipCode;

    @Column(name="tittle")
    private String tittle;




}
