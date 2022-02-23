/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.entity;


public class Room {
    
     private int idR;
      private String roomName;
      private int roomNumber;

    public Room(int idR, String roomName, int roomNumber) {
        this.idR = idR;
        this.roomName = roomName;
        this.roomNumber = roomNumber;
    }

    public Room(String roomName, int roomNumber) {
        this.roomName = roomName;
        this.roomNumber = roomNumber;
    }

    public Room() {
          }

    public int getIdR() {
        return idR;
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

    @Override
    public String toString() {
        return "Room{" + "idR=" + idR + ", roomName=" + roomName + ", roomNumber=" + roomNumber + '}'+"\n";
    }
      
    
      
    
}
