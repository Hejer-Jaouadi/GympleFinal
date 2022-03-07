/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.util.Date;

/**
 *
 * @author Adnene
 */
public class Courses {
////////////////////////////////////////////////////////Variables

    private int id;
    private String date = "";
    private String coursBegin = "";
    private String coursEnd = "";
    private int places ;
    private String category = "";
    private String planning = "";
    private String trainer = "";
    

    public Courses(int id,  String date, String coursBegin, String coursEnd, int places, String category, String planning, String trainer) {
        this.id = id;
        this.places = places;
        this.date = date;
        this.coursBegin = coursBegin;
        this.coursEnd = coursEnd;
        this.category = category;
        this.planning = planning;
        this.trainer = trainer;
    }

    public Courses( String date, String coursBegin, String coursEnd, int places, String category, String planning, String trainer) {
        this.places = places;
        this.date = date;
        this.coursBegin = coursBegin;
        this.coursEnd = coursEnd;
        this.category = category;
        this.planning = planning;
        this.trainer = trainer;
    }

    public Courses() {
    }
    

    public int getId() {
        return id;
    }

    public int getPlaces() {
        return places;
    }

    public String getDate() {
        return date;
    }

    public String getCoursBegin() {
        return coursBegin;
    }

    public String getCoursEnd() {
        return coursEnd;
    }

    public String getCategory() {
        return category;
    }

    public String getPlanning() {
        return planning;
    }

    public String getTrainer() {
        return trainer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPlaces(int places) {
        this.places = places;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCoursBegin(String coursBegin) {
        this.coursBegin = coursBegin;
    }

    public void setCoursEnd(String coursEnd) {
        this.coursEnd = coursEnd;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPlanning(String planning) {
        this.planning = planning;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    @Override
    public String toString() {
        return "Courses{" + "id=" + id + ", places=" + places + ", date=" + date + ", coursBegin=" + coursBegin + ", coursEnd=" + coursEnd + ", category=" + category + ", planning=" + planning + ", trainer=" + trainer + '}';
    }
    
    


    

}
