package com.example.gleamer.model;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;

@Entity
public class MetaData {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer rows;
    private Integer columns;
    private Integer resolution;
    private Date createdAt = new Date();

    protected MetaData() {}

    public MetaData(String name, Integer row, Integer columns, Integer resolution) {
        this.name = name;
        this.rows = row;
        this.columns = columns;
        this.resolution = resolution;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getRows() {
        return rows;
    }

    public Integer getColumns() {
        return columns;
    }

    public Integer getResolution() {
        return resolution;
    }

    public Date getCreatedAt() {
        return createdAt;
    }
}
