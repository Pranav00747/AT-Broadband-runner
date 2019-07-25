import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.net.*;

class button  extends JButton 
{
    private int alpha1, alpha2, size;
    private Color color;
    boolean isClicked;
  
    public boolean getClicked()
    {
        return isClicked;
    }
public button()
{
    setBorderPainted(false);
    setFocusPainted(false);
    setContentAreaFilled(false);
    alpha1 = 180;
    alpha2 = 10;
    size = 18;
    isClicked = false;
    color = new Color(255, 255, 255);
    addMouseListener(new MouseAdapter()
            {
                
                  @Override
  public void mouseClicked(MouseEvent e)
  {
      super.mouseClicked(e);
      if(isClicked==false)
            {
          isClicked=true;
        alpha1 = 220;
      alpha2 = 40;
      size = 20;
      color = new Color(220, 200, 0);
      repaint();
            }
      else
            {
          isClicked=false;
             alpha1 = 180;
      alpha2 = 10;
      size =18;
      color = new Color(255, 255, 255);
      repaint();
            }
  }
                @Override
  public void mouseEntered(MouseEvent e)
  {
      super.mouseEntered(e);
     if( isClicked==false)
            {
      alpha1 = 220;
      alpha2 = 40;
      size = 20;
      color = new Color(220, 200, 0);
      repaint();
            }
  }
  
   @Override
  public void mouseExited(MouseEvent e)
  {
      super.mouseExited(e);
      if( isClicked==false)
            {
     alpha1 = 180;
      alpha2 = 10;
      size =18;
      color = new Color(255, 255, 255);
      repaint();
            }
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
             g2.drawString("Detect Device", 52, 22);
}
  
  
}
class pane extends JPanel
{
    private JFrame parent;
    
    public pane(JFrame p)
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
     try
     {
      g2.drawImage(Toolkit.getDefaultToolkit().getImage("AT-Logo.png"), 10, 10,  250, 250, 
              this);
      }
       catch(Exception e)
      {
       parent.dispose();
      }
   }
}
public class AT_Broadband
{
    public static void setStates(button b, JLabel lab1, JLabel lab2, JLabel lab3, JLabel lab4)
    {
        if(b.getClicked()==false)
        {
        try
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com"); 
  
            BufferedReader sc = 
            new BufferedReader(new InputStreamReader(url_name.openStream())); 
             int status;
             Process p = Runtime.getRuntime().exec("ping www.google.com");
              int state = p.waitFor();
              if(state==0)
              {
            lab1.setText("LocalHost :"+InetAddress.getLocalHost().getHostName());
            lab2.setText("System Address :"+InetAddress.getLocalHost().getHostAddress());
            lab3.setText("Public Address :"+sc.readLine().trim());
            lab4.setText("Connectivity :"+"Connected");
              }
          
        }
        catch(UnknownHostException e)
        {
            lab1.setText("LocalHost :"+"No Connectivity");
            lab2.setText("System Address :"+"No Connectivity");
            lab3.setText("Public Address :"+"No Connectivity");
            lab4.setText("Connectivity :"+"Disconnected");
            e.printStackTrace();
        }
        catch(IOException e)
        {
        e.printStackTrace();
        }
        catch(InterruptedException e)
        {
        e.printStackTrace();
        }
        }
    }

 public static void main(String args[]) 
 {
     try
     {
     JFrame f = new JFrame("AT-Broadband");
    pane p = new pane(f);
    final button b = new button();
    String menu[]= {"Interface Setup", 
        "Advanced Setup", "Access Management", "Maintainance"};
    final JLabel labels[] = new JLabel[4];
    final JLabel lab1 = new JLabel("Undefined"), 
            lab2 = new JLabel("Undefined"), lab3=new JLabel("Undefined"), lab4=new JLabel("Undefined");
    
    int step = 0;
     final BufferedReader br = null;
     final int status = -1;
    for(int x=0;x<4;x++)
    {
        labels[x] = new JLabel(menu[x]);
        labels[x].setFont(new Font("MS Sans Serif", Font.ROMAN_BASELINE, 12));
        labels[x].setBounds(270+step, 200, 120, 18);
        labels[x].setVisible(true);
        final int i=x;
        labels[x].addMouseListener(new MouseAdapter()
        {
         
                @Override
  public void mouseEntered(MouseEvent e)
  {
      super.mouseEntered(e);
      labels[i].setFont(new Font("MS Sans Serif", Font.BOLD, 12));
      labels[i].repaint();
  }
  
   @Override
  public void mouseExited(MouseEvent e)
  {
      super.mouseExited(e);
      labels[i].setFont(new Font("MS Sans Serif", Font.ROMAN_BASELINE, 12));
      labels[i].repaint();
           
  }
   });
        p.add(labels[x]);
        step+=140;
    }
    labels[0].addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            InterfaceSetup Is = new InterfaceSetup();
        }
    });
    
     labels[1].addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            AdvancedSetup As = new AdvancedSetup();
        }
    });
     
      labels[2].addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            AcessManagement Am = new AcessManagement();
        }
    });
      
       labels[3].addMouseListener(new MouseAdapter()
    {
        @Override
        public void mouseClicked(MouseEvent e)
        {
            super.mouseClicked(e);
            Maintainance Mn = new Maintainance();
        }
    });
         lab1.setBounds(260, 300, 300, 18);
         lab1.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
         lab1.setForeground(new Color(10, 10, 10));
         lab1.setVisible(true);
         
         lab2.setBounds(260, 328, 300, 18);
         lab2.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
         lab2.setForeground(new Color(10, 10, 10));
         lab2.setVisible(true);
         
         lab3.setBounds(260, 356, 300, 18);
         lab3.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
         lab3.setForeground(new Color(10, 10, 10));
         lab3.setVisible(true);
    
         lab4.setBounds(260, 384, 300, 18);
         lab4.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
         lab4.setForeground(new Color(10, 10, 10));
         lab4.setVisible(true);
         
    JLabel label = new JLabel("Copyright© AT-Broadband India Pvt .Ltd");
    label.setFont(new Font("MS Sans Serif", Font.PLAIN, 14));
    label.setBounds(280, 540, 260, 18);
    label.setForeground(new Color(10, 10, 10));
    label.setVisible(true);
    b.setBounds(260, 440, 220, 38);
    b.setVisible(true);
    b.addActionListener(new ActionListener(){
        public void actionPerformed(ActionEvent e)
        {
            AT_Broadband.setStates(b, lab1, lab2, lab3, lab4);
            
        }
    });
    p.setLayout(null);
    p.add(b);
    p.add(lab1);
    p.add(lab2);
    p.add(lab3);
    p.add(lab4);
    p.add(label);
   
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    f.setUndecorated(true);
    f.setIconImage(Toolkit.getDefaultToolkit().getImage("AT-Logo.png"));
    f.setBounds((Toolkit.getDefaultToolkit().getScreenSize().width-800)/2,
(Toolkit.getDefaultToolkit().getScreenSize().height-600)/2, 800, 600);
    f.add(p);
    AT_Broadband.setStates(b, lab1, lab2, lab3, lab4);  // performed once
    f.setVisible(true);
    
     }
     catch(Exception e)
     {
       
     }
 }
}
