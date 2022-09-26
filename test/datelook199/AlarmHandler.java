package datelook199;

import java.util.*;
import java.awt.*;
import java.applet.*;
import java.net.*;


/*
 *  /*
 *  Title:        DentalGest Calendar
 *  Copyright:    Copyright (c) 2022
 *  Author:       Mascommunication
 */
/**
 *  Checks for all events in the event memory whether an alarm is to be given now.
 */
public class AlarmHandler extends TimerTask {

  private EventMemory event_memory;


  /**
   *  Constructor for the AlarmHandler object
   *
   * @param  tm  event memory, storing the local database
   */
  public AlarmHandler(EventMemory tm) {
    event_memory = tm;
  }


  /**
   *  Main processing method of the AlarmHandler object
   */
  public void run() {
    long now_ms = new GregorianCalendar().getTime().getTime();
    int open_alarm_frame_counter = 0;
    boolean saving_needed = false;
    for (int i = event_memory.get_size() - 1; i > -1; i--) {
      Event t = event_memory.get_event(i);
      while (t.get_my_editor_frame() == null & t.get_alarm_active() &
          !(Converter.UTCplusPeriod2UTC(t.get_alarm_UTC_ms(), t.get_period(),
          t.get_alarm_counter(), t.get_period_multiplier()) > now_ms) &&
          t.get_number_of_periods() > t.get_alarm_counter()) {

        AlarmFrame af = new AlarmFrame(t);
        af.setLocation(50 + open_alarm_frame_counter * 20, 50 + open_alarm_frame_counter * 20);
        af.setVisible(true);
        af.requestFocus();
        af.getToolkit().beep();
        t.inc_alarm_counter();
        saving_needed = true;
        open_alarm_frame_counter++;
      }
    }
    if (saving_needed) { // needed to save increased alarm counters
      event_memory.save();
    }
  }

}

