package datelook199;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.geom.*;
import java.util.*;


/*
 *  Title:        DentalGest Calendar
 *  Copyright:    Copyright (c) 2022
 *  Author:       Mascommunication
 */
/**
 *  A panel containing RButtons and RComponents.<br>
 *  It receives and handles all mouse and key event and<br>
 *  resizes the parent window if some components are overlapping.
 */
public abstract class RPanel extends JPanel implements KeyListener, MouseListener, MouseMotionListener, MouseWheelListener {

  /**
   *  redering hints with antialiasing.
   */
  protected RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  /**
   *  redering hints without antialiasing.
   */
  protected RenderingHints normalHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
  /**
   *  graphics object
   */
  protected Graphics2D g2;
  /**
   *  background colour
   */
  protected Color bg_color = new Color(220, 220, 220);
  /**
   *  parent window
   */
  protected Window parent_window;
  
  private boolean font_antialiasing;
  private int initial_width;    // own width at creation time, needed to determine whether components are overlapping
  private int initial_heigth;   // heigth width at creation time, needed to determine whether components are overlapping
  private boolean first_draw;
  private javax.swing.Timer resize_timer;
  private boolean resizing_required;
  private RPanel me;


  /**
   *  Constructor for the RPanel object
   *
   * @param  pw                 parent window
   * @param  resizing_required  true - enables resizing if inner components are overlapping<br>
   *                            false - no resizing.
   *
   */
  public RPanel(Window pw, boolean rr) {
    super();
    me = this;
    resizing_required = rr;
    first_draw = true;
    parent_window = pw;
    this.setLayout(null);
    enableEvents(AWTEvent.COMPONENT_EVENT_MASK);
    font_antialiasing = true;
    this.setBackground(bg_color);

    this.addMouseListener(this);
    this.addMouseMotionListener(this);
    this.addMouseWheelListener(this);
    this.addKeyListener(this);
    
    if (resizing_required) {  // if true then create timer that controls the resizing
      resize_timer = new javax.swing.Timer(500,
        new ActionListener() {
          public void actionPerformed(ActionEvent evt) {
            int h = me.getHeight();
            int w = me.getWidth();
            
            if (h * initial_width < w * initial_heigth) { // if true then components are overlapping
              int ph = parent_window.getHeight();
              int pw = parent_window.getWidth();
              
              parent_window.setSize(pw, (w * initial_heigth) / initial_width + ph - h);
              parent_window.paintAll(parent_window.getGraphics());
            }
            resize_timer.stop();
          }
        });
    }
  }


  /**
   *  Process component event.<br>
   *  If the components are overlapping it resizes the parent window if required.
   *
   * @param  e  component event
   */
  public void processComponentEvent(ComponentEvent e) {
    if (e.getID() == ComponentEvent.COMPONENT_RESIZED && resizing_required) {
      resize_timer.restart();
    }
    super.processComponentEvent(e);
  }


  /**
   *  Paint component
   *
   * @param  g  Graphics object
   */
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    g2 = (Graphics2D) g;
    if (font_antialiasing) { 
      g2.setRenderingHints(qualityHints);
    }
    else {
      g2.setRenderingHints(normalHints);
    }
    if (first_draw) {   // store initial width and height
      initial_width = this.getWidth();
      initial_heigth = this.getHeight();
      first_draw = false;
    }
  }

  
  public void set_font_antialiasing (boolean b) {
    font_antialiasing = b;
  }
  
  
  /**
   *  Dummy
   *
   * @param  e  key event
   */
  public void keyPressed(KeyEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  key event
   */
  public void keyReleased(KeyEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  key event
   */
  public void keyTyped(KeyEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mouseClicked(MouseEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mousePressed(MouseEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mouseReleased(MouseEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mouseExited(MouseEvent e) {
    this.mouseMoved(e);
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mouseEntered(MouseEvent e) {
    this.mouseMoved(e);
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mouseDragged(MouseEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  mouse event
   */
  public void mouseMoved(MouseEvent e) {
  }


  /**
   *  Dummy
   *
   * @param  e  mouse wheel event
   */
  public void mouseWheelMoved(MouseWheelEvent e) {
  }
}

