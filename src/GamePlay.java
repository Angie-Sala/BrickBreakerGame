import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements KeyListener, ActionListener {

    private boolean play = false;
    private int score = 0;

    private int totalbricks = 21;

    private Timer timer;
    private int delay = 8;

    private int playerX = 310;

    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;

    private MapGenerator map;

    public GamePlay(){
        map = new MapGenerator(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    public void paint (Graphics graphics){
        //background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(1, 1, 692, 592);

        //drawing map
        Graphics2D g2d = (Graphics2D) graphics;
        map.draw(g2d);

        //borders
        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, 3, 592);
        graphics.fillRect(0, 0, 692, 3);
        graphics.fillRect(691, 0, 3, 592);

        //score
        graphics.setColor(Color.WHITE);
        graphics.setFont(new Font("serif", Font.BOLD, 25));
        graphics.drawString(""+score, 590,30);

        // the paddle
        graphics.setColor(Color.GREEN);
        graphics.fillRect(playerX, 550, 100, 10);

        //ball
        graphics.setColor(Color.YELLOW);
        graphics.fillOval(ballposX, ballposY, 20, 20);

        if (totalbricks <= 0){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("serif", Font.BOLD, 30));
            graphics.drawString("You Won:  "+score, 260,300);

            graphics.setFont(new Font("serif", Font.BOLD, 20));
            graphics.drawString("Press Enter to Restart", 230, 350);

        }

        if (ballposY > 570){
            play = false;
            ballXdir = 0;
            ballYdir = 0;
            graphics.setColor(Color.RED);
            graphics.setFont(new Font("serif", Font.BOLD, 30));
            graphics.drawString("Game Over, Scores: "+score, 190,300);

            graphics.setFont(new Font("serif", Font.BOLD, 20));
            graphics.drawString("Press Enter to Restart", 230, 350);
        }

        graphics.dispose();
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(play){
            if(new Rectangle(ballposX, ballposY, 20, 20).intersects((new Rectangle(playerX, 550, 100, 8)))){
                ballYdir = -ballYdir;
            }
            A: for(int i = 0; i < map.map.length; i++){
                for (int j = 0; j<map.map[0].length; j++){
                    if(map.map[i][j] > 0){
                        int brickX = j*map.brickWidth + 80;
                        int brickY = i*map.brickHeight + 50;
                        int brickWidth = map.brickWidth;
                        int brickHeigth = map.brickHeight;

                        Rectangle rectangle = new Rectangle(brickX, brickY, brickWidth, brickHeigth);
                        Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
                        Rectangle brickRect = rectangle;

                        if (ballRect.intersects(brickRect)){
                            map.setBrickValue(0, i, j);
                            totalbricks --;
                            score += 5;

                            if (ballposX + 19<= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
                                ballXdir = -ballXdir;
                            } else {
                                ballYdir = -ballYdir;
                            }
                            break A;
                        }
                    }
                }
            }

            ballposX += ballXdir;
            ballposY += ballYdir;
            if(ballposX < 0){
                ballXdir = -ballXdir;
            }
            if(ballposY < 0){
                ballYdir = -ballYdir;
            }
            if(ballposX > 670){
                ballXdir = -ballXdir;
            }

        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}
    @Override
    public void keyReleased(KeyEvent e) {}


    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 600){
                playerX = 600;
            } else {
                moveRight();
            }
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX < 10){
                playerX = 10;
            } else {
                moveLeft();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_ENTER){
            if (!play){
                play = true;
                ballposX = 120;
                ballposY = 350;
                ballXdir = -1;
                ballYdir = -2;
                playerX = 310;
                score = 0;
                totalbricks = 21;
                map = new MapGenerator(3, 7);

                repaint();
            }
        }

    }

    public void moveRight(){
        play = true;
        playerX += 20;
    }

    public void moveLeft(){
        play = true;
        playerX -= 20;
    }


}
