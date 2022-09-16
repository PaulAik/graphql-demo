package com.paulaikman.graphqldemo.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "titles")
public class Title implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name="emp_no", nullable=false)
    private Employee employee;

    @Id
    @Column(name = "title")
    private String title;

    @Id
    @Column(name = "from_date")
    private Date fromDate;

    private Date toDate;

}
