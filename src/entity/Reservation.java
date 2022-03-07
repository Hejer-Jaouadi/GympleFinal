/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author amorl
 */
public class Reservation {

    private int rid;
    private String reserved_date;
    private String reserved_time;
    private String courseName;
    private String coachName;
    private String type;

    public Reservation() {
    }

    public Reservation(int rid, String reserved_date, String courseName, String coachName, String type, String reserved_time) {
        this.rid = rid;
        this.reserved_date = reserved_date;
        this.reserved_time = reserved_time;
        this.courseName = courseName;
        this.coachName = coachName;
        this.type = type;
    }

    /**
     * @return the rid
     */
    public int getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(int rid) {
        this.rid = rid;
    }

    /**
     * @return the reserved_date
     */
    public String getReserved_date() {
        return reserved_date;
    }

    /**
     * @param reserved_date the reserved_date to set
     */
    public void setReserved_date(String reserved_date) {
        this.reserved_date = reserved_date;
    }

    /**
     * @return the reserved_time
     */
    public String getReserved_time() {
        return reserved_time;
    }

    /**
     * @param reserved_time the reserved_time to set
     */
    public void setReserved_time(String reserved_time) {
        this.reserved_time = reserved_time;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the coachName
     */
    public String getCoachName() {
        return coachName;
    }

    /**
     * @param coachName the coachName to set
     */
    public void setCoachid(String coachName) {
        this.coachName = coachName;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Reservation{" + "rid=" + rid + ", reserved_date=" + reserved_date + ", reserved_time=" + reserved_time + ", courseName=" + courseName + ", coachName=" + coachName + ", type=" + type + '}';
    }

    
}
