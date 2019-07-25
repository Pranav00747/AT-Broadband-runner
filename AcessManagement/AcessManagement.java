import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;

class button3  extends JButton 
{
    private int alpha1, alpha2, size;
    private Color color;
    private String title;  

public button3(String text)
{
    setBorderPainted(false);
    setFocusPainted(false);
    setContentAreaFilled(false);
    alpha1 = 180;
    alpha2 = 10;
    size = 12;
    color = new Color(255, 255, 255);
    title = text;
    addMouseListener(new MouseAdapter()
            {
                @Override
  public void mouseEntered(MouseEvent e)
  {
      super.mouseEntered(e);
      alpha1 = 220;
      alpha2 = 40;
      size = 14;
      color = new Color(220, 200, 0);
      repaint();

  }
  
   @Override
  public void mouseExited(MouseEvent e)
  {
      super.mouseExited(e);
     
     alpha1 = 180;
      alpha2 = 10;
      size =12;
      color = new Color(255, 255, 255);
      repaint();

  }
            });
}
  @Override
  public void paintComponent(Graphics g)
  {
     super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      rh.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
      g2.setRenderingHints(rh);
      g2.setPaint(new GradientPaint(getWidth(), getHeight()/2, new Color(180, 0, 0),
      getWidth(), getHeight(), new Color(220, 0, 0)));
      g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
            g2.setPaint(new GradientPaint(getWidth(), 7, new Color(255, 255, 255, alpha1),
      getWidth(), 15, new Color(255, 255, 255, alpha2)));
             g2.fillRoundRect(1, 1, getWidth()-1, 15, 25, 25);
             g2.setFont(new Font("Impact", Font.PLAIN, size));
             g2.setColor(color);
             g2.drawString(title, 18, 15);
}
  
  
}
class pane3 extends JPanel
{
    private JFrame parent;
    
    public pane3(JFrame p)
    {
        parent = p;
    }
  @Override
  public void paintComponent(Graphics g)
  {
     super.paintComponent(g);
      Graphics2D g2 = (Graphics2D)g;
      RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
      rh.put(RenderingHints.KEY_COLOR_RENDERING, RenderingHints.VALUE_COLOR_RENDER_QUALITY);
      g2.setRenderingHints(rh);
      g2.setPaint(new GradientPaint(getWidth(), getHeight()/2, new Color(250, 250, 250),
      getWidth(), getHeight(), new Color(240, 240, 240)));
      g2.fillRoundRect(0, 0, getWidth(), getHeight(), 25, 25);
      g2.setColor(new Color(20, 20, 20));
      g2.drawLine(0, 0, getWidth(), 0);
      g2.drawLine(0, 0, 0, getHeight());
      g2.drawLine(getWidth()-1, 0, getWidth(), getHeight());
      g2.drawLine(0, getHeight()-1, getWidth(), getHeight());
      
      g2.setFont(new Font("Impact", Font.ROMAN_BASELINE, 22));
      g2.drawString("Access Management", 120, 30);
   
   }
}

class AcessManagement
{
 public AcessManagement()
 {
   final JFrame f = new JFrame("Acess Management");
   f.setUndecorated(true);
   f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   f.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width-400)/2, 
(Toolkit.getDefaultToolkit().getScreenSize().height-400)/2, 400, 400);
     f.setIconImage(Toolkit.getDefaultToolkit().getImage("AT-Logo.png"));
  pane3 p = new pane3(f);
  button3 save= new button3("Save"), close = new button3("Close");

save.setBounds(150, 360, 80, 26);
save.setVisible(true);

close.setBounds(260, 360, 80, 26);
close.setVisible(true);
close.addActionListener(new ActionListener(){
    public void actionPerformed(ActionEvent e)
    {
        f.dispose();
    }
});
  p.setLayout(null);
 p.add(save);
 p.add(close);
  f.add(p);
  f.setVisible(true);
 }
}

