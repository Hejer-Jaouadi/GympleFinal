/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.sql.Date;

/**
 *
 * @author Adnene
 */
public class Planning {
    private int id;
    private Date planningBegin, planningEnd;
    private String gym;

    public Planning() {
    }

    public Planning(int id, Date planningBegin, Date planningEnd, String gym) {
        this.id = id;
        this.planningBegin = planningBegin;
        this.planningEnd = planningEnd;
        this.gym = gym;
    }

    public Planning(Date planningBegin, Date planningEnd, String gym) {
        this.planningBegin = planningBegin;
        this.planningEnd = planningEnd;
        this.gym = gym;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlanningBegin(Date planningBegin) {
        this.planningBegin = planningBegin;
    }

    public void setPlanningEnd(Date planningEnd) {
        this.planningEnd = planningEnd;
    }

    public void setGym(String gym) {
        this.gym = gym;
    }

    public int getId() {
        return id;
    }

    public Date getPlanningBegin() {
        return planningBegin;
    }

    public Date getPlanningEnd() {
        return planningEnd;
    }

    public String getGym() {
        return gym;
    }

    @Override
    public String toString() {
        return "Planning{" + "id=" + id + ", planningBegin=" + planningBegin + ", planningEnd=" + planningEnd + ", gym=" + gym + '}';
    }
    
    
}
