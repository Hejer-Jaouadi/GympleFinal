/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Asma
 */
public class Trainer extends User {
    
    private float cost_per_hour;
    private String description;
    private String experience;
    private Gym gym;
    private int reports=0;

    public int getReports() {
        return reports;
    }

    public void setReports(int reports) {
        this.reports = reports;
    }

    public Trainer(float cost_per_hour, String description, String experience,Gym g, String first_name, String last_name, String email, String password) {
        super(first_name, last_name, email, password);
        this.cost_per_hour = cost_per_hour;
        this.description = description;
        this.experience = experience;
        this.gym=g;
        this.setRole("trainer");
    }

    public Trainer(float cost_per_hour, String description, String experience,Gym g, int id, String first_name, String last_name, String email, String password) {
        super(id, first_name, last_name, email, password);
        this.cost_per_hour = cost_per_hour;
        this.description = description;
        this.experience = experience;
        this.gym=g;
        this.setRole("trainer");
    }

    public Trainer() {
        this.setRole("trainer");
    }

    public float getCost_per_hour() {
        return cost_per_hour;
    }

    public void setCost_per_hour(float cost_per_hour) {
        this.cost_per_hour = cost_per_hour;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public Gym getGym() {
        return gym;
    }

    public void setGym(Gym gym) {
        this.gym = gym;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cost(h) : " + cost_per_hour + ", Description : " + description + ", Experience :" + experience +" "+gym.toString();
    }
    
}
