package com.paulaikman.graphqldemo.models;

import com.paulaikman.graphqldemo.entities.Employee;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class TitleModel {

    public TitleModel(String title, Date fromDate, Date toDate) {
        this.title = title;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    private Employee employee;

    private String title;

    private Date fromDate;

    private Date toDate;
}
