/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;


public class Room {
    
     private int idR;
      private String roomName;
      private int roomNumber;
      private int max_nbr;

    public Room(int idR, String roomName, int roomNumber,int max_nbr) {
        this.idR = idR;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
          this.max_nbr = max_nbr;
    }

    public Room(String roomName, int roomNumber,int max_nbr) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
         this.max_nbr = max_nbr;
    }

    public Room() {
          }

    public Room(String name, String number) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Room(String idRoom, String name, String number1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Room(String idRoom, String name, int number1, int capacity1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getIdR() {
        return idR;
    }

    public int getMax_nbr() {
        return max_nbr;
    }

    public void setMax_nbr(int max_nbr) {
        this.max_nbr = max_nbr;
    }

    public void setIdR(int idR) {
        this.idR = idR;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
//
//    @Override
//    public String toString() {
//        return "Room{" + "idR=" + idR + ", roomName=" + roomName + ", roomNumber=" + roomNumber + '}'+"\n";
//    }

    @Override
    public String toString() {
        return "Room{" + "idR=" + idR + ", roomName=" + roomName + ", roomNumber=" + roomNumber + ", max_nbr=" + max_nbr + '}'+"\n";
    }
      
    
      
    
}
