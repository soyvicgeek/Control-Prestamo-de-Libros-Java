package view.components.ButtonHover;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JButton;

public class ButtonHover extends JButton implements MouseListener {
    
    private Color colorHover= new Color(123, 83, 11);
    private Color colorPressed= new Color(123, 83, 11);
    private Color colorNormal= new Color(123, 83, 11);
    
    private Color colorTextHover= new Color(255,255,255);
    private Color colorTextPressed= new Color(255,255,255);
    private Color colorTextNormal= new Color(255,255,255);
    
    public ButtonHover()
    {
        super();
        this.setBorder(null);
        this.setContentAreaFilled(false);
        this.setOpaque(false);
        this.setFont(new Font("Roboto", Font.BOLD,14));
        this.setBackground(new Color(123,83,11) );
        this.setForeground(Color.white);
        this.setPreferredSize(new Dimension(200,40));
        this.setSize(200, 40);
        this.setCursor(new Cursor(12));
        addMouseListener((MouseListener) (this));
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        if (getModel().isPressed()) {
            g2.setColor(getBackground().darker());
        } else if (getModel().isRollover()) {
            g2.setColor(getBackground().brighter());
        } else {
            g2.setColor(getBackground());
        }
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        g2.dispose();
        super.paintComponent(g);
    }

    @Override
    public void mouseClicked(MouseEvent e) 
    {
        
    }

    @Override
    public void mousePressed(MouseEvent e) 
    {
         this.setBackground(this.colorPressed);
        this.setForeground(this.colorTextPressed);
    }

    @Override
    public void mouseReleased(MouseEvent e) 
    {
        this.setBackground(this.colorHover);
        this.setForeground(this.colorTextHover);
    }

    @Override
    public void mouseEntered(MouseEvent e) 
    {
        this.setBackground(this.colorHover);
        this.setForeground(this.colorTextHover);
    }

    @Override
    public void mouseExited(MouseEvent e) 
    {
        this.setBackground(this.colorNormal);
        this.setForeground(this.colorTextNormal);
    }

    public Color getColorHover() {
        return colorHover;
    }

    public void setColorHover(Color colorHover) {
        this.colorHover = colorHover;
    }

    public Color getColorNormal() {
        return colorNormal;
    }

    public void setColorNormal(Color colorNormal) {
        this.colorNormal = colorNormal;
        this.setBackground(this.colorNormal);
    }

    public Color getColorTextHover() {
        return colorTextHover;
    }

    public void setColorTextHover(Color colorTextHover) {
        this.colorTextHover = colorTextHover;
    }

    public Color getColorTextNormal() {
        return colorTextNormal;
    }

    public void setColorTextNormal(Color colorTextNormal) {
        this.colorTextNormal = colorTextNormal;
        this.setForeground(this.colorTextNormal);
    }

    public Color getColorPressed() {
        return colorPressed;
    }

    public void setColorPressed(Color colorPressed) {
        this.colorPressed = colorPressed;
         this.setBackground(this.colorPressed);
    }

    public Color getColorTextPressed() {
        return colorTextPressed;
    }

    public void setColorTextPressed(Color colorTextPressed) {
        this.colorTextPressed = colorTextPressed;
         this.setForeground(this.colorTextPressed);
    }
    
}
