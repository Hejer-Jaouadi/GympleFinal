/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.time.LocalDate;

/**
 *
 * @author Asma
 */
public class Membership {
    
    private int idm;
    private LocalDate expire_date;
    private LocalDate start_date;
    private String type;

    public int getIdm() {
        return idm;
    }

    public void setIdm(int id) {
        this.idm = id;
    }

    public LocalDate getExpire_date() {
        return expire_date;
    }

    public void setExpire_date(LocalDate expire_date) {
        this.expire_date = expire_date;
    }

    public LocalDate getStart_date() {
        return start_date;
    }

    public void setStart_date(LocalDate start_date) {
        this.start_date = start_date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Membership(int id, LocalDate expire_date, LocalDate start_date, String type) {
        this.idm = id;
        this.expire_date = expire_date;
        this.start_date = start_date;
        this.type = type;
    }
    public Membership(LocalDate expire_date, LocalDate start_date, String type) {
        this.expire_date = expire_date;
        this.start_date = start_date;
        this.type = type;
    }
     public Membership(){
         
     }

    @Override
    public String toString() {
        return "Membership{" + "idm=" + idm + ", expire_date=" + expire_date + ", start_date=" + start_date + ", type=" + type + '}';
    }

    
}
