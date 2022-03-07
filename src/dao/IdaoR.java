/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Room;
import java.util.List;
import javafx.collections.ObservableList;
import javafx.scene.chart.XYChart;

public interface IdaoR<T> {

    public void insertRoom(String roomName, String roomNumber, String idgym);

    public void insertRoom2(T o);

    public List<T> displayRoom();

    public boolean updateRoom(T os);

    public T displayByIdRoom(int id);

    public void deleteRoom(T o);

    public void searchByName(String room);

    public boolean modifyRoom(int id, String roomName, String roomNumber, String idgym);

    public ObservableList<XYChart.Series<String, Double>> statistique();

   

}
