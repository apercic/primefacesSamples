package org.primefaces.test;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class Incre implements Serializable {

    private int number;
    private String ikebana;

    @PostConstruct
    public void init() {
        ikebana = "Welcome";
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIkebana() {
        return ikebana;
    }

    public int getNumber() {
        return number;
    }

    public void setIkebana(String ikebana) {
        this.ikebana = ikebana;
    }

    public void increment() {
        ikebana = "bb";
        number++;
    }
}