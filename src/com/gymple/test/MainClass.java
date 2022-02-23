/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gymple.test;

import com.gymple.dao.EquipmentCrud;
import com.gymple.dao.GymCrud;
import com.gymple.dao.RoomCrud;
import com.gymple.entity.Equipment;
import com.gymple.entity.Room;

public class MainClass {

    public static void main(String[] args) {

        // MyConnexion mc = MyConnexion.getInstance() ;
        GymCrud gc = GymCrud.getInstance();
        //gc.insertGym();
        //Gym g = new Gym("ariana","sauna");

        //Gym g = new Gym("tunis", "piscine");
        //gc.insertGym2(g);
        //System.out.println(gc.displayGym());
        //  gc.updateGym(g);
        // System.out.println(gc.displayGym());
        //System.out.println(gc.displayByIdGym(2));
        // gc.deleteGym(gc.displayByIdGym(20));
        //System.out.println(gc.displayGym());
        //  gc.searchByLocation("tunis");
//        gc.modifyGym(1, "bardo centre", "swimmingpool");
//        System.out.println(gc.displayByIdGym(1));
        // Gym g2 = new Gym("yalahwi", "warrraaaay");
        // gc.insertGym2(g2);
        // gc.updateGym(new Gym(19,"rades","piscone olympique"));
        //System.out.println(gc.displayByIdGym(19));
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        RoomCrud rc = RoomCrud.getInstance();
        //rc.insertRoom();

        //Room r = new Room("tennis", 7);
        //rc.insertRoom2(r);
       // System.out.println(rc.displayRoom());
        //System.out.println(rc.displayByIdRoom(2));
        // rc.updateRoom(new Room(4,"hejer",16));
        // System.out.println(rc.displayByIdRoom(4));
        //  rc.deleteRoom(rc.displayByIdRoom(7));
/////////////////////////////////////////////////////////////////////////////////////////////////////////

        EquipmentCrud ec = EquipmentCrud.getInstance();
       // ec.insertEquipment();

//        Equipment e = new Equipment("weights","lift weights",90);
//        ec.insertEquipment2(e);
//        Equipment e1 = new Equipment("bicycle","cardio",80);
//        ec.insertEquipment2(e1);
//        System.out.println(ec.displayEquipment());
//        System.out.println(ec.displayByIdEquipment(2));
//        ec.updateEquipment(new Equipment(4,"abdominal bench","abs",25));
//         System.out.println(ec.displayByIdEquipment(4));
//          ec.deleteEquipment(ec.displayByIdEquipment(7));

    }
}
