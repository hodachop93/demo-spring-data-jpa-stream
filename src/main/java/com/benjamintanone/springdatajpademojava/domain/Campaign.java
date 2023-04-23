package com.benjamintanone.springdatajpademojava.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Campaign {
    @Id
    private Long id;
    private String name;
}
