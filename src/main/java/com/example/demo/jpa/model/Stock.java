package com.example.demo.jpa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
    CREATE TABLE `stock` (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) DEFAULT NULL,
    `num` int(11) DEFAULT NULL,
    `description` varchar(45) DEFAULT NULL,
    PRIMARY KEY (`ID`)
    ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
 */

@Entity
@Table(name="Stock")
public class Stock {
    @Id
    private int ID;
    @Column(name = "name")
    private String name;
    @Column(name = "num")
    private int num;

    @Column(name = "description")
    private String description;

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    public String getDescription() {
        return description;
    }
}
