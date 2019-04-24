package com.vote.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Setter
@Getter
@Entity
public class Vote {
    @Column(name = "age")
    private Long age;

    @Column(name = "vote")
    private boolean vote;

    @Id
    @Column(name = "name")
    private String name;
}
