package com.app.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
public class ContactInformation {

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "twitter")
    private String twitter;

    @Column(name = "instagram")
    private String instagram;
}