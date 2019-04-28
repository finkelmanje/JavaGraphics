package Review;

// (c) A+ Computer Science
// www.apluscompsci.com
// Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import static java.lang.Character.toUpperCase;
import java.util.List;
import java.util.ArrayList;

public class WinterScenePanel extends JPanel implements Runnable,KeyListener {

    private List<AbstractShape> shapes;
    private List<StormySnowFlake> stormyShapes;
    private AbstractShape sMan;
    private boolean stormy = false;

    public WinterScenePanel() {
        this.addKeyListener(this);
        setVisible(true);
        shapes = new ArrayList<AbstractShape>();
        stormyShapes = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            int y = (int) (Math.random() * 600);
            int s = (int) (Math.random() * 30) + 20;
            shapes.add(new SimpleSnowFlake(i * 14, y, s, s));
            shapes.add(new FancySnowFlake(i * 14, y, s, s));
        }
        for (int i = 0; i < 50; i++) {
            int y = (int) (Math.random() * 600);
            int s = (int) (Math.random() * 30) + 20;
            stormyShapes.add(new StormySnowFlake(i * 14, y, s, s));
        }
        sMan = new SnowMan(500, 350, 100, 300);
        new Thread(this).start();
    }

    public void update(Graphics window) {
        paint(window);
    }

    public void paint(Graphics window) {
        window.setColor(Color.BLUE);
        window.fillRect(0, 0, getWidth(), getHeight());
        window.setColor(Color.WHITE);
        window.drawRect(20, 20, getWidth() - 40, getHeight() - 40);
        window.setFont(new Font("TAHOMA", Font.BOLD, 18));
        window.drawString("MAKE A WINTER SCENE!", 40, 40);

        sMan.draw(window);

        if (!stormy) {
            for (AbstractShape shape : shapes) {
                shape.moveAndDraw(window);
                if (shape.getYPos() >= getHeight()) {
                    shape.setYPos(0);
                }
            }
        } else {
            for (StormySnowFlake shape : stormyShapes) {
                shape.moveAndDraw(window);
                if (shape.getYPos() >= getHeight()) {
                    shape.setYPos(0);
                }
                if (shape.getXPos() >= getWidth()) {
                    shape.setXPos(0);
                }
            }
        }
    }

    public void keyPressed(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                stormy = true;
                break;
        }
    }

    public void keyReleased(KeyEvent e) {
        switch (toUpperCase(e.getKeyChar())) {
            case 'W':
                break;

        }
    }
    
    public void keyTyped(KeyEvent e) {
        
    }

    public void run() {
        try {
            while (true) {
                Thread.currentThread().sleep(35);
                repaint();
            }
        } catch (Exception e) {
        }
    }
}
