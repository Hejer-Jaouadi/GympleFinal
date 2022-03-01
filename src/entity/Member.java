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
public class Member extends User{
    
    private Membership membership;
    private int id_card;
    private float height;
    private float weight;
    private String training_level;

    public Member(Membership membership, int id_card, float height, float weight, String training_level, String first_name, String last_name, String email, String password) {
        super(first_name, last_name, email, password);
        this.membership = membership;
        this.id_card = id_card;
        this.height = height;
        this.weight = weight;
        this.training_level = training_level;
        this.setRole("member");
    }

    public Member(Membership membership, int id_card, float height, float weight, String training_level, int id, String first_name, String last_name, String email, String password) {
        super(id, first_name, last_name, email, password);
        this.membership = membership;
        this.id_card = id_card;
        this.height = height;
        this.weight = weight;
        this.training_level = training_level;
        this.setRole("member");
    }

    public Member(){ 
        this.setRole("member");
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public int getId_card() {
        return id_card;
    }

    public void setId_card(int id_card) {
        this.id_card = id_card;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String getTraining_level() {
        return training_level;
    }

    public void setTraining_level(String training_level) {
        this.training_level = training_level;
    }

    @Override
    public String toString() {
        return super.toString()+" Member{" + "membership=" + membership + ", id_card=" + id_card + ", height=" + height + ", weight=" + weight + ", training_level=" + training_level + '}';
    }
     
}
