import java.awt.*;
import java.applet.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.*;

public class handsup extends JApplet implements Runnable, KeyListener, MouseListener { 
    Thread t;   
    int timeStep = 30;
    int vy = 30;
    double v = .05;
    int booty = 1;
    int month = 0;
    int day = 0;
    int year = 0;
    ArrayList<Target> targets = new ArrayList();
    Random r = new Random();
<<<<<<< HEAD
=======
    boolean b = true;
    String s = "";
    boolean whiteout = true;
>>>>>>> origin/master

    public void init() {
        setFocusable(true);
        //         for (int i = 0; i < 1; i++){
        //             int randx = r.nextInt(359);
        //             int randy = r.nextInt(359);
        //             targets.add(new Vertical(randx, randy, vy));
        //             targets.add(new Horizontal(randx, randy, vy));
        //             targets.add(new Circular(300,300,400,400,.1,30));
        //             targets.add(new Seeking(randx, randy, v));
        //             targets.add(new Circular(300,300,400,400,.1,30));
        //             targets.add(new CounterCircular(300,300,400,400,.1,100));
        //         }
        newtarget();
        resize(800,800);
        addMouseListener(this);
        addKeyListener(this);
        t = new Thread(this);
        t.start();
    }

    public void newtarget () {
        for (int i = 0; i < 1; i++){
            int randx = r.nextInt(359);
            int randy = r.nextInt(359);
            targets.add(new Vertical(randx, randy, vy));
            targets.add(new Horizontal(randx, randy, vy));
<<<<<<< HEAD
            targets.add(new Circular(300,300,400, 400, .1,30));
=======
            targets.add(new Circular(300,300,400,400,.1,30));
>>>>>>> origin/master
            targets.add(new Seeking(randx, randy, v));
            targets.add(new Circular(300,300,400,400,.1,30));
            targets.add(new CounterCircular(300,300,400,400,.1,100));
        }
    }

    public void paint(Graphics g) {
        Graphics offScreenG;
        Image offScreenI = null;

        showStatus(""+b + " " + s); 
        offScreenI = createImage(getWidth(), getHeight());
        offScreenG = offScreenI.getGraphics();

        subpaint(offScreenG);
        if(b)
            g.drawImage(offScreenI, 0, 0, this);
    }

    public void subpaint(Graphics g){
        if (whiteout == true){
            g.setColor(Color.white);
            g.fillRect(0,0,1420,880);
            whiteout = false;
        }
        for (Target t: targets){
            if (t instanceof Circular || t instanceof CounterCircular){
                g.setColor(Color.red);
            }
            if (t instanceof Horizontal || t instanceof Vertical){
                g.setColor(Color.green);
            }
            if (t instanceof Seeking) {
                g.setColor(Color.black);
            }
            g.fillOval(t.x,t.y,30,30);
            g.drawRect(380, 380, 40, 40);
        }
        

    }

    public void clearScreen(){
        while (targets.size() > 0) targets.remove(0);
        whiteout = true;
        repaint();
        newtarget();
    }

    public void keyPressed(KeyEvent e){
        s+=e.getKeyChar();
        if (e.getKeyChar() == 'c') {
            clearScreen(); 
            b = false;
        }
        repaint();
    }

    public void keyTyped(KeyEvent e){

    }

    public void keyReleased(KeyEvent e){}

    public void mouseClicked(MouseEvent e) {

        // loop through the ArrayList, remove any element clickedb = true;
        int x = e.getX();
        int y = e.getY();
    }

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {
        b = true;
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void run() {
        try {
            while(true) {
                for (int i = 0; i < targets.size(); i++){
                    targets.get(i).move();
                }
                repaint();
                t.sleep(timeStep);

                for (int i = 0; i < targets.size(); i++)
                {
                    Target t = targets.get(i);
                    if(t instanceof Seeking){
                        if (t.removal == true) {
                            targets.remove(i);
                        }
                        t.move();
                    }

                }
            }

        } catch (InterruptedException e) {}
    }
}