import ObjectsGame.Enemy;
import ObjectsGame.Map1;
import ObjectsGame.NormalEnemy;
import ObjectsGame.TankerEnemy;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GameStage extends JFrame implements ActionListener {

    int DeLay = 10;
    Timer timer;

    public GameStage() {
        initUI();;
        initTimer();
    }

    public void initTimer() {
        timer = new Timer(DeLay, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }

    private void initUI() {
        add(new startPanel(this));
        setSize(640+200,448);
        setTitle("TowerDefense");
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println(e.getX() + " " + e.getY());
            }
        });
    }
}

class controlPanel extends JPanel {

    Map1 map1;
    Enemy[] listTank = new Enemy[5];
    Enemy[] listTanks = new Enemy[5];


    public controlPanel() {
        map1 = new Map1();
        for (int i = 0; i < 5; i++) {
            listTank[i] = new NormalEnemy(32, 416 + i*128);
        }
        for (int i = 0; i < 5; i++) {
            listTanks[i] = new TankerEnemy(32, 416 + (i+5)*128);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        map1.render(g2d);
        for (int i = 0; i < 5; i++){
            listTank[i].render(g2d);
        }
        for (int i = 0; i < 5; i++){
            listTanks[i].render(g2d);
        }
    }
}

class startPanel extends JPanel  {
    GameStage gameStage;
    Image imgStart = new ImageIcon(getClass().getResource("/Defaultsize/Sample.png")).getImage();
    JButton jButtonStart = new JButton(new ImageIcon(getClass().getResource("/Defaultsize/1.png")));

    public startPanel(GameStage gameStage) {
        this.gameStage = gameStage;
        add(jButtonStart);
        setLayout(null);
        jButtonStart.setBounds(220, 280, 200, 51 );
        jButtonStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gameStage.getContentPane().removeAll();
                gameStage.getContentPane().add(new controlPanel());
                gameStage.validate();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imgStart, 0 , 0, null);
    }
}

