import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GamePanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 600;
    static final int SCREEN_HEIGHT = 600;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 100;
    static final int WIDTH = SCREEN_WIDTH / UNIT_SIZE;
    static final int HEIGHT = SCREEN_HEIGHT / UNIT_SIZE;


    private Snake snake;
    private Point apple;
    private int appleCounter = 0;

    private Timer timer;
    private boolean running = false;



    public GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.BLACK);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());

        startGame();
    }

    public void startGame() {
        snake = new Snake(10, 10, 3);
        running = true;
        timer = new Timer(DELAY, this);
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }

    private void drawCell(Graphics g, int x, int y, Color c){
        g.setColor(c);
        g.fillRect(x * UNIT_SIZE, y * UNIT_SIZE, UNIT_SIZE, UNIT_SIZE);
    }

    private void draw(Graphics g){
        if (!running) return;

        // draw lines
        g.setColor(new Color(50, 50, 50));
        for (int i = 0; i < SCREEN_WIDTH / UNIT_SIZE; i++){
            g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
        }

        for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++){
            g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
        }
        // draw apple
        if (apple != null)drawCell(g, apple.x, apple.y, Color.RED);

        // draw snake
        boolean isHead = true;
        for (Point p : snake.getBody()) {
            if (isHead){
                drawCell(g, p.x, p.y, new Color(0, 130, 0));
                isHead = false;
            } else {
                drawCell(g, p.x, p.y, new Color(0, 100, 0));
            }
        }
    }

    public void gameOver(){
        running = false;
        timer.stop();
    }

    public void spawnApple(){
        int x, y;
        Point newApple;

        do {
            x = (int) (Math.random() * WIDTH);
            y = (int) (Math.random() * HEIGHT);
            newApple = new Point(x, y);
        }while(snake.contains(newApple));

        apple = newApple;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (running){
            Point nextHead = snake.getNextHead();

            if (nextHead.x < 0 || nextHead.y < 0 || nextHead.x >= WIDTH || nextHead.y >= HEIGHT){
                gameOver();
            }
            else if (snake.contains(nextHead)){
                gameOver();
            }
            else {
                boolean ateApple = (nextHead.equals(apple));
                snake.move(nextHead, ateApple);

                if (ateApple){
                    apple = null;
                    appleCounter = 0;
                }

                if (apple == null){
                    appleCounter++;
                    if (appleCounter >= 10){
                        spawnApple();
                    }
                }
            }
        }
        repaint();
    }

    private class MyKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e){
            switch(e.getKeyCode()){
                case KeyEvent.VK_UP: case KeyEvent.VK_W:
                    snake.setDirection(Direction.UP); break;
                case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:
                    snake.setDirection(Direction.RIGHT);break;
                case KeyEvent.VK_DOWN: case KeyEvent.VK_S:
                    snake.setDirection(Direction.DOWN);break;
                case KeyEvent.VK_LEFT: case KeyEvent.VK_A:
                    snake.setDirection(Direction.LEFT);break;

            }
        }
    }

}


