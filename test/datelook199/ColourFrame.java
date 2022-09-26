package datelook199;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.geom.*;
import java.awt.datatransfer.*;
import java.util.*;
import java.io.*;
import javax.swing.filechooser.*;


/*
 *  Title:        DentalGest Calendar
 *  Copyright:    Copyright (c) 2022
 *  Author:       Mascommunication
 */
/**
 *  Description of the Class
 */
public class ColourFrame extends JFrame {

  private JPanel contentPane;
  private EditorFrame my_editor_frame;
  private ColourPanel colour_panel;
  private DateLookPanel datelook_panel;


  /**
   *  Construct the frame
   *
   * @param  dlp  the datelook panel if created from this or null 
   * @param  ef   editor frame if created from this or null
   * @param  c    if opened from ef the current colour of the event otherwise null
   */
  public ColourFrame(DateLookPanel dlp, EditorFrame ef, Color c) {

    datelook_panel = dlp;
    my_editor_frame = ef; // if != null then the predefined colours are NOT editable

    enableEvents(AWTEvent.WINDOW_EVENT_MASK);
    try {
      contentPane = (JPanel) this.getContentPane();
      setIconImage(Toolkit.getDefaultToolkit().createImage(EditorFrame.class.getResource("dl.png")));
      this.setSize(new Dimension(14 * DateLookPanel.slot_height + DateLookPanel.frame_decor_width,
          9 * DateLookPanel.slot_height + DateLookPanel.frame_decor_height));
      if (my_editor_frame == null) {
        this.setTitle("PredefColourEditor");
      }
      else {
        this.setTitle("ColourChooser");
      }
      colour_panel = new ColourPanel(ef, c, this);
      contentPane.add(colour_panel);
      this.addKeyListener(colour_panel);
    }
    catch (Exception e) {
      e.printStackTrace();
    }
  }


  /**
   *  Description of the Method
   *
   * @param  e  Description of the Parameter
   */
  protected void processWindowEvent(WindowEvent e) {
    super.processWindowEvent(e);
    if (e.getID() == WindowEvent.WINDOW_CLOSING) {
      if (my_editor_frame != null) {
        my_editor_frame.delete_colour_frame(null);
      }
      if (datelook_panel != null) {
        datelook_panel.set_colour_frame(null);
      }
    }
  }


  /**
   *  Description of the Method
   */
  public void dispose() {
    if (my_editor_frame != null) {
      my_editor_frame.delete_colour_frame(null);
    }
    if (datelook_panel != null) {
      datelook_panel.set_colour_frame(null);
    }
    super.dispose();
  }


  /**
   *  Description of the Class
   */
  public static class ColourPanel extends RPanel {

    private EditorFrame my_editor_frame;
    private ArrayList mouse_receiver_list = new ArrayList(); // all RComponents with mouse response (no RButtons!)
    private ArrayList renderer_list = new ArrayList();  // all RComponents and RButtons to be drawn

    private String colour_settings_file_name = "";

    // all RComponents
    private RComponent[] red_rc = new RComponent[8];
    private RComponent[] green_rc = new RComponent[8];
    private RComponent[] blue_rc = new RComponent[8];
    private RButton[] colour_button = new RButton[8];

    private RButton save_button;
    private RButton cancel_button;

    private JTextField[] colour_text = new JTextField[8];

    // arrays to store colour settings (predefined colours and labels) after read from colourrc-file
    private String[] label = {"current", "Dott. Cerella", "Dott. Ciampaglia", "Dott. Costigliola", "Dott. Damiano ", "Dott. Famiglietti", "Dott. Pagliarulo", "Dott.ssa Calabrese"};
    private Color[] colours = {Color.blue, Color.blue, Color.green, Color.yellow, Color.red, Color.pink, Color.orange, Color.cyan};


    /**
     *  Constructor for the ColourPanel object
     *
     * @param  ef  Description of the Parameter
     * @param  c   Description of the Parameter
     * @param  pw  parent window
     */
    public ColourPanel(EditorFrame ef, Color c, Window pw) {
      super(pw, true);
      my_editor_frame = ef;

      read_colour_settings(); // read predefined colours and labels from file and fill label- and colours-array
      if (c != null) {
        // colour[0] is the colour of current event if there is any
        colours[0] = new Color(c.getRed() / 5 * 5, c.getGreen() / 5 * 5, c.getBlue() / 5 * 5);
      }

      String select_button_string = "";
      if (my_editor_frame != null) {
        select_button_string = "seleziona";
      }

      for (int i = 1; i < 8; i++) {
        // colour choosers
        red_rc[i] = new RComponent(this, new Color(240, 220, 220), new Color(255, 50, 50), colours[i].getRed(), 255, 0, 5, null, "", 340, 40 + i * 120, 120, 48);
        green_rc[i] = new RComponent(this, new Color(220, 240, 220), new Color(50, 255, 50), colours[i].getGreen(), 255, 0, 5, null, "", 480, 40 + i * 120, 120, 48);
        blue_rc[i] = new RComponent(this, new Color(200, 220, 240), new Color(100, 150, 255), colours[i].getBlue(), 255, 0, 5, null, "", 620, 40 + i * 120, 120, 48);
        colour_button[i] = new RButton(this, colours[i], colours[i], colours[i], select_button_string, 500, 40 + i * 120, 260, 48);

        // colour_text
        colour_text[i] = new JTextField();
        colour_text[i].setText(label[i]);
        colour_text[i].addKeyListener(this);
        this.add(colour_text[i]);

        // add to renderer_list
        //renderer_list.add(red_rc[i]);
        //renderer_list.add(green_rc[i]);
        //renderer_list.add(blue_rc[i]);
        renderer_list.add(colour_button[i]);

        if (my_editor_frame == null) {
          colour_text[i].setBackground(Color.white);
          colour_text[i].setEditable(false);
          //mouse_receiver_list.add(red_rc[i]);
          //mouse_receiver_list.add(green_rc[i]);
          //mouse_receiver_list.add(blue_rc[i]);
        }
        else {
          colour_text[i].setBackground(bg_color);
          colour_text[i].setEditable(false);
        }
      }

      if (my_editor_frame == null) {
        // create button for save and cancel
        save_button = new RButton(this, Color.gray, Color.orange, Color.red, "salva", 20, 30, 470, 48);
        cancel_button = new RButton(this, Color.gray, Color.orange, Color.red, "cancella", 510, 30, 470, 48);
      }
      else {
        // create row for current colour (index = 0)
        // colour choosers
        red_rc[0] = new RComponent(this, new Color(240, 220, 220), new Color(255, 50, 50), colours[0].getRed(), 255, 0, 5, null, "", 340, 40, 120, 48);
        green_rc[0] = new RComponent(this, new Color(220, 240, 220), new Color(50, 255, 50), colours[0].getGreen(), 255, 0, 5, null, "", 480, 40, 120, 48);
        blue_rc[0] = new RComponent(this, new Color(200, 220, 240), new Color(100, 150, 255), colours[0].getBlue(), 255, 0, 5, null, "", 620, 40, 120, 48);
        colour_button[0] = new RButton(this, colours[0], colours[0], colours[0], select_button_string, 500, 40, 260, 48);

        //renderer_list.add(red_rc[0]);
        //renderer_list.add(green_rc[0]);
        //renderer_list.add(blue_rc[0]);
        renderer_list.add(colour_button[0]);

        //mouse_receiver_list.add(red_rc[0]);
        //mouse_receiver_list.add(green_rc[0]);
        //mouse_receiver_list.add(blue_rc[0]);

        // colour_text
        colour_text[0] = new JTextField();
        colour_text[0].setEditable(false);
        colour_text[0].setText("corrente");
        colour_text[0].setBackground(Color.white);
        colour_text[0].addKeyListener(this);
        this.add(colour_text[0]);
      }
    }


    /**
     *  Process component event.<br>
     *  If component resized it resizes all components, <br>
     *  if then components are overlapping it resizes the frame
     *
     * @param  e  component event
     */
    public void processComponentEvent(ComponentEvent e) {
      super.processComponentEvent(e);
      if (e.getID() == ComponentEvent.COMPONENT_RESIZED) {
        Graphics g = this.getGraphics();
        Graphics2D g2 = (Graphics2D) g;
        Font font = new Font("SansSerif", Font.PLAIN, 48 * this.getWidth() / 1000);
        Rectangle2D bounds = font.getStringBounds("0", g2.getFontRenderContext());
        for (int i = 0; i < 8; i++) {
          if (colour_text[i] != null) {
            colour_text[i].setFont(font);
            int pw = this.getWidth();
            colour_text[i].setBounds(pw * 20 / 1000, this.getHeight() * (30 + i * 120) / 1000, pw * 420 / 1000, (int) bounds.getHeight() * 4 / 3);
          }
        }
      }
    }


    /**
     *  Paint component
     *
     * @param  g  Graphics object
     */
    public void paintComponent(Graphics g) {
      super.paintComponent(g);

      for (int i = 0; i < renderer_list.size(); i++) {
        // draw all labels
        ((Renderer) renderer_list.get(i)).draw(g2);
      }
      if (my_editor_frame == null) {
        save_button.draw(g2);
        cancel_button.draw(g2);
      }
    }


    /**
     *  Check for pressed key and handles it.<br>
     *  F1 - opens HelpFrame<br>
     *  ctrl-Q - closes the ColourFrame and if PredefColourEditor saves
     *  predefined colours<br>
     *  ctrl-S - closes the ColourFrame and if PredefColourEditor saves
     *  predefined colours<br>
     *  ctrl-C - closes the ColourFrame without any saving<br>
     *
     *
     * @param  e  key event
     */
    public void keyPressed(KeyEvent e) {
      if (e.getKeyCode() == KeyEvent.VK_F1) {
        if (my_editor_frame != null) {
          HelpFrame.get_instance().help("ColourChooser");
        }
        else {
          HelpFrame.get_instance().help("Predefined_colours");
        }
      }
      else {
        if (e.getModifiers() == InputEvent.CTRL_MASK) {
          if ((e.getKeyCode() == KeyEvent.VK_Q) || (e.getKeyCode() == KeyEvent.VK_S)) {
            if (my_editor_frame == null) {
              write_colour_settings();
            }
            else
                if (my_editor_frame != null) {
              my_editor_frame.delete_colour_frame(new Color(red_rc[0].get_value(), green_rc[0].get_value(), blue_rc[0].get_value()));
            }
            parent_window.dispose();
            return;
          }
          if (e.getKeyCode() == KeyEvent.VK_C) {
            parent_window.dispose();
            return;
          }
        }
      }
    }


    /**
     *  Handle mouse click.<br>
     *  Check whether buttons are hit and if true handle the action.<br>
     *  if ColourFrame works as predefColourEditor then<br>
     *  save button - saves the predefined colours and closes the ColourFrame
     *  <br>
     *  cancel button - closes the ColourFrame without saving<br>
     *  else (ColouFrame works as ColourChooser for the current event)<br>
     *  on of the eight colour buttons - closes the ColourFrame and set set
     *  colour of event to this colour
     *
     * @param  e  mouse event
     */
    public void mouseClicked(MouseEvent e) {
      for (int i = 0; i < mouse_receiver_list.size(); i++) {
        ((RComponent) mouse_receiver_list.get(i)).mouse_clicked(e);
      }
      if (my_editor_frame != null) {
        for (int i = 0; i < 8; i++) {
          if (colour_button[i].mouse_clicked(e)) {
            if (my_editor_frame != null) {
              my_editor_frame.delete_colour_frame(new Color(red_rc[i].get_value(), green_rc[i].get_value(), blue_rc[i].get_value()));
            }
            parent_window.dispose();
          }
        }
      }
      else {
        if (save_button.mouse_clicked(e)) {
          this.write_colour_settings();
          parent_window.dispose();
          return;
        }
        if (cancel_button.mouse_clicked(e)) {
          parent_window.dispose();
          return;
        }
      }
    }


    /**
     *  Description of the Method
     *
     * @param  e  Description of the Parameter
     */
    public void mousePressed(MouseEvent e) {
      for (int i = 0; i < mouse_receiver_list.size(); i++) {
        ((RComponent) mouse_receiver_list.get(i)).mouse_pressed(e);
      }
      if (my_editor_frame != null) {
        for (int i = 0; i < 8; i++) {
          colour_button[i].mouse_pressed(e);
        }
      }
      else {
        save_button.mouse_pressed(e);
        cancel_button.mouse_pressed(e);
      }
      this.colour_set();
      this.repaint();
    }


    /**
     *  Description of the Method
     *
     * @param  e  Description of the Parameter
     */
    public void mouseReleased(MouseEvent e) {
      for (int i = 0; i < mouse_receiver_list.size(); i++) {
        ((RComponent) mouse_receiver_list.get(i)).mouse_released(e);
      }
      if (my_editor_frame == null) {
        save_button.mouse_released(e);
        cancel_button.mouse_released(e);
      }
      else {
        for (int i = 0; i < 8; i++) {
          colour_button[i].mouse_released(e);
        }
      }
      this.repaint();
    }


    /**
     *  Description of the Method
     *
     * @param  e  Description of the Parameter
     */
    public void mouseMoved(MouseEvent e) {
      for (int i = 0; i < mouse_receiver_list.size(); i++) {
        ((RComponent) mouse_receiver_list.get(i)).mouse_over(e);
      }
      if (my_editor_frame != null) {
        for (int i = 0; i < 8; i++) {
          colour_button[i].mouse_over2(e);
        }
      }
      else {
        save_button.mouse_over(e);
        cancel_button.mouse_over(e);
      }
      this.repaint();
    }


    /**
     *  Description of the Method
     *
     * @param  e  mouse wheel event
     */
    public void mouseWheelMoved(MouseWheelEvent e) {
      for (int i = 0; i < mouse_receiver_list.size(); i++) {
        ((RComponent) mouse_receiver_list.get(i)).mouse_wheel_rotate(e);
      }
      this.colour_set();
      this.repaint();
    }


    /**
     *  Set the colour of colour-buttons if changed.
     */
    private void colour_set() {
      Color tmp_colour;
      if (my_editor_frame == null) {
        for (int i = 1; i < 8; i++) {
          tmp_colour = new Color(red_rc[i].get_value(), green_rc[i].get_value(), blue_rc[i].get_value());
          colour_button[i].set_bg_colour(tmp_colour);
        }
      }
      else {
        tmp_colour = new Color(red_rc[0].get_value(), green_rc[0].get_value(), blue_rc[0].get_value());
        colour_button[0].set_bg_colour(tmp_colour);
        colour_button[0].set_high_light_colour(tmp_colour);
      }
    }


    /**
     *  Description of the Method
     */
    private void read_colour_settings() {
      try {
        colour_settings_file_name = FileSystemView.getFileSystemView().getDefaultDirectory().getAbsolutePath()
             + File.separatorChar + ".datelook" + File.separatorChar + "colourrc";
        File colour_settings_file = new File(colour_settings_file_name);

        if (colour_settings_file.canRead() & !colour_settings_file.isDirectory()) {
          //read file
          ObjectInputStream in = new ObjectInputStream(new FileInputStream(colour_settings_file_name));
          label = ((String[]) in.readObject());
          colours = ((Color[]) in.readObject());
          in.close();
        }
      }
      catch (Exception b) {
        b.printStackTrace();
      }
    }


    /**
     *  Description of the Method
     */
    private void write_colour_settings() {
      for (int i = 1; i < 8; i++) {
        colours[i] = new Color(red_rc[i].get_value(), green_rc[i].get_value(), blue_rc[i].get_value());
        label[i] = colour_text[i].getText();
      }

      try {
        new File(colour_settings_file_name).delete();
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(colour_settings_file_name));
        out.writeObject(label);
        out.writeObject(colours);
        out.close();
      }
      catch (Exception b) {
        b.printStackTrace();
      }
    }
  }
}

