package trayball;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class trayball extends JPanel implements Runnable{
    Clickinggame cl=new Clickinggame();
    @Override
    public void run() {
        while(cl.sayac!=0){
        cl.sayac--;
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        }
            JOptionPane.showMessageDialog(new Clickinggame(), "TIME OVER");
    }
}
class frame extends JFrame{
    public frame(){
        add(new Clickinggame());
    }
}
public class Clickinggame extends JPanel implements Runnable,MouseMotionListener {
    int sayac=60;
   Random r=new Random();
      int point=0;
      boolean randomizer=false;
      int y=0;
       int x=r.nextInt(960);
        int my=500;
       int mx=300;
    public Clickinggame(){
            addMouseMotionListener(this);
    }
public void paintComponent(Graphics g){
     if(randomizer){
                this.x=r.nextInt(960);
                randomizer=false;
    }
    super.paintComponent(g);
    Thread t=new Thread(this);
    g.setColor(Color.red);
    g.fillOval(x, y, 50, 50);
    g.setFont(new Font("a",Font.BOLD,40));
    g.drawString("\\____/",mx,my);
    g.setColor(Color.BLACK);
    g.drawString("POINT:"+this.point,00,40);
    t.start();
}
  @Override
    public void run() {
        y+=5;
        if(y>getHeight()){
            y=0;
        }
        try {
            if(point>=10 &&point<25){
          Thread.sleep(5);
            }
            else if(point>=25&&point<50){
                Thread.sleep(4);
            }
            else if(point>=50){
                Thread.sleep(3);
            }
            else{
                Thread.sleep(8);
            }
      } catch (Exception e) {
      }
        if(x<=mx+50&&x>=mx-50&&y<=my&&y>=my-50){
            randomizer=true;
            this.point++;
            y=0;
        }
        else if(y==0){
            randomizer=true;
        }
      repaint();
    }
     @Override
    public void mouseDragged(MouseEvent e) {
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        mx=e.getX();
    }
    public static void main(String[] args) {
        trayball sayac=new trayball();
        Thread t=new Thread(sayac);
        t.start();
frame f=new frame();
f.setVisible(true);
f.setResizable(false);
f.setSize(1000, 600);
f.setDefaultCloseOperation(EXIT_ON_CLOSE);
f.setLocation(600, 400);
    }
}
