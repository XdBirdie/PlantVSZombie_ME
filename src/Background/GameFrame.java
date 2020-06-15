package Background;

import java.awt.Point;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Plants.WallNut;

public class GameFrame extends JFrame {
  public GameFrame() {
    this.setTitle("PlantVSZombie");
    this.setSize(1200, 600);
    this.setResizable(false);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // 窗口监听
    this.addWindowListener(
        new WindowAdapter() {
          //监听器
          public void windowClosing(WindowEvent e) {
            int dialog =
                JOptionPane.showConfirmDialog(null, "是否退出", "退出", JOptionPane.CLOSED_OPTION);
            if (dialog == JOptionPane.OK_OPTION) System.exit(0);
          }
        });

    // 音乐播放
    MusicPlayer musicplayer = new MusicPlayer("bgm.wav");
    musicplayer.loop(-1);

    GamePanel panel = new GamePanel();
    this.getContentPane().add(panel);
    this.setVisible(true);
  }

  public static void main(String[] args) {
    GameFrame fr = new GameFrame();
    fr.setVisible(true);
  }
}