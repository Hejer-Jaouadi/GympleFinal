/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Adnene
 */
public class Tips {

    private int id;
    private String caption;
    private String category;

    public Tips() {
    }

    public Tips(int id, String caption, String category) {
        this.id = id;
        this.caption = caption;
        this.category = category;
    }

    public Tips(String caption, String category) {
        this.caption = caption;
        this.category = category;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getCaption() {
        return caption;
    }

    public String getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Tips{" + "id=" + id + ", caption=" + caption + ", category=" + category + '}';
    }

}
