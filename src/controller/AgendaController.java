/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.AppointmentDao;
import entity.Admin_appointment;
import java.io.IOException;
import java.net.URL;
import java.time.Month;
import java.util.Calendar;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Callback;
import jfxtras.scene.control.agenda.Agenda;
import jfxtras.scene.control.agenda.Agenda.Appointment;

/**
 * FXML Controller class
 *
 * @author Asma
 */
public class AgendaController implements Initializable {
    @FXML
    private Button back;
    @FXML
    private Circle c;
    @FXML
    private Label country;
    @FXML
    private Label desc;
    @FXML
    private Label current;
    @FXML
    private Label min;
    @FXML
    private Label max;
    @FXML 
    private AnchorPane pane;
    @FXML
    private Agenda agenda;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         final Map<String, Agenda.AppointmentGroup> lAppointmentGroupMap = new TreeMap<String, Agenda.AppointmentGroup>();
       lAppointmentGroupMap.put("group01", new Agenda.AppointmentGroupImpl().withStyleClass("group1"));
       AppointmentDao ad=AppointmentDao.getInstance();
         agenda.createAppointmentCallbackProperty().set(new Callback<Agenda.CalendarRange, Agenda.Appointment>()
        {
            @Override
            public Agenda.Appointment call(Agenda.CalendarRange calendarRange)
            {
               Appointment a= new Agenda.AppointmentImpl()
                        .withStartTime(calendarRange.getStartCalendar())
                        .withEndTime(calendarRange.getEndCalendar())
                        .withSummary("new")
                        .withDescription("new")
                        .withAppointmentGroup(lAppointmentGroupMap.get("group01"));
                
                Admin_appointment an;
                     an = new Admin_appointment();
                     an.setDescription(a.getSummary());
                     an.setLocation(a.getLocation());
                     an.setStart(a.getStartLocalDateTime().toLocalDate());
                     an.setStart_time(a.getStartLocalDateTime().getHour());
                     an.setEnd_time(a.getEndLocalDateTime().getHour());
                     ad.insert(an);
                
                return a;
            }
        });
         
         

agenda.selectedAppointments().addListener(new ListChangeListener< Appointment >() {
     public void onChanged(Change<? extends Appointment> c) {
         while (c.next()) {
             if (c.wasPermutated()) {
                 for (int i = c.getFrom(); i < c.getTo(); ++i) {
                          Appointment a=c.getList().get(i);
                          Admin_appointment an;
                     an = new Admin_appointment();
                     an.setDescription(a.getSummary());
                     an.setLocation(a.getLocation());
                     an.setStart(a.getStartLocalDateTime().toLocalDate());
                     an.setStart_time(a.getStartLocalDateTime().getHour());
                     an.setEnd_time(a.getEndLocalDateTime().getHour());
                      ad.update(an);
                 }
             } else if (c.wasUpdated()) {
                      for (int i = c.getFrom(); i < c.getTo(); ++i) {
                          Appointment a=c.getList().get(i);
                          Admin_appointment an;
                     an = new Admin_appointment();
                     an.setDescription(a.getSummary());
                     an.setLocation(a.getLocation());
                     an.setStart(a.getStartLocalDateTime().toLocalDate());
                     an.setStart_time(a.getStartLocalDateTime().getHour());
                     an.setEnd_time(a.getEndLocalDateTime().getHour());
                      ad.update(an);
                 }
             } else {
                 for (Appointment a : c.getRemoved()) {
                         
                          Admin_appointment an;
                     an = new Admin_appointment();
                     an.setDescription(a.getSummary());
                     an.setLocation(a.getLocation());
                     an.setStart(a.getStartLocalDateTime().toLocalDate());
                     an.setStart_time(a.getStartLocalDateTime().getHour());
                     an.setEnd_time(a.getEndLocalDateTime().getHour());
                      ad.update(an);
                 }
                 for (Appointment a : c.getAddedSubList()) {
                         
                          Admin_appointment an;
                     an = new Admin_appointment();
                     an.setDescription(a.getSummary());
                     an.setLocation(a.getLocation());
                     an.setStart(a.getStartLocalDateTime().toLocalDate());
                     an.setStart_time(a.getStartLocalDateTime().getHour());
                     an.setEnd_time(a.getEndLocalDateTime().getHour());
                      ad.update(an);
                     
                 }
             }
         }
     }
 });
         
         
         
       Calendar lFirstDayOfWeekCalendar = getFirstDayOfWeekCalendar(agenda.getLocale(), agenda.getDisplayedCalendar());
        int lFirstDayOfWeekYear = lFirstDayOfWeekCalendar.get(Calendar.YEAR);
        int lFirstDayOfWeekMonth = lFirstDayOfWeekCalendar.get(Calendar.MONTH);
        int FirstDayOfWeek = lFirstDayOfWeekCalendar.get(Calendar.DATE);
        Calendar lToday = agenda.getDisplayedCalendar();
        int lTodayYear = lToday.get(Calendar.YEAR);
        int lTodayMonth = lToday.get(Calendar.MONTH);
        int lTodayDay = lToday.get(Calendar.DATE);
        agenda.appointments().addAll(ad.displayAllLists());
    }   
    static private Calendar getFirstDayOfWeekCalendar(Locale locale, Calendar c)
    {
        // result
        int lFirstDayOfWeek = Calendar.getInstance(locale).getFirstDayOfWeek();
        int lCurrentDayOfWeek = c.get(Calendar.DAY_OF_WEEK);
        int lDelta = 0;
        if (lFirstDayOfWeek <= lCurrentDayOfWeek)
        {
            lDelta = -lCurrentDayOfWeek + lFirstDayOfWeek;
        }
        else
        {
            lDelta = -lCurrentDayOfWeek - (7-lFirstDayOfWeek);
        }
        c = ((Calendar)c.clone());
        c.add(Calendar.DATE, lDelta);
        return c;
    }

    @FXML
    private void getBack(ActionEvent event) {
         Scene scene2 = null;
        Stage stageTheLabelBelongs = (Stage) back.getScene().getWindow();
        try {
            scene2 = new Scene(FXMLLoader.load(getClass().getResource("/view/homeAdmin.fxml")));
           
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        stageTheLabelBelongs.setScene(scene2);
    }
    
}
