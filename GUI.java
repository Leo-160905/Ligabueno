import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GUI extends JFrame {


    public JButton bSTART = new JButton();
    public JButton bBACK = new JButton();
    public JButton bSETTINGS = new JButton();
    public JButton bQUIT = new JButton();
    public JButton bRESUME = new JButton();
    Timer timer = new Timer(1000, null);
    Dimension frameSize;
    public static int sek = 0;
    public Panel jpanel;

    public GUI() {

        super();
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        frameSize = new Dimension(d.width / 2, d.height / 2);
        jpanel = new Panel(frameSize);
        jpanel.setVisible(false);
        add(jpanel);
        setSize(frameSize);

        Point framePosition = new Point(480, 270);
        setLocation(framePosition);
        setLayout(null);
        setTitle("GUI");
        setResizable(false);
        //--------------------------------------------------------
        int Startwidth = 200;
        int Startheight = 100;
        int Startx = (frameSize.width / 2) - (Startwidth / 2);
        int Starty = (frameSize.height / 2) - (Startheight * 2);
        bSTART.setText("START");
        bSTART.setBounds(Startx, Starty, Startwidth, Startheight);
        bSTART.setForeground(Color.BLACK);
        bSTART.setVisible(true);
        bSTART.setFocusable(false);
        bSTART.addActionListener((e) -> {
            jpanel.setVisible(true);
            // listener.timer.start();
            bSTART.setVisible(false);
            bSETTINGS.setVisible(false);
            bQUIT.setVisible(false);
            timer.start();
        });

        add(bSTART);

        //--------------------------------------------------------
        bRESUME.addActionListener((e) -> {
            bRESUME.setVisible(false);
            bQUIT.setVisible(false);
            bSETTINGS.setVisible(false);
            jpanel.setVisible(true);
            sek = 0;
            timer.start();
        });
        int Resumewidth = 200;
        int Resumeheight = 100;
        int Resumex = (frameSize.width / 2) - (Resumewidth / 2);
        int Resumey = (frameSize.height / 2) - (Resumeheight * 2);
        bRESUME.setText("RESUME");
        bRESUME.setBounds(Resumex, Resumey, Resumewidth, Resumeheight);
        bRESUME.setForeground(Color.BLACK);
        bRESUME.setVisible(false);
        bRESUME.setFocusable(false);
        add(bRESUME);
        //--------------------------------------------------------

        bBACK.addActionListener((e) -> {
            bQUIT.setVisible(true);
            bSETTINGS.setVisible(true);
            bBACK.setVisible(false);
            bRESUME.setVisible(true);
            bSTART.setVisible(false);
            jpanel.setVisible(false);
            timer.stop();
        });
        int Backwidth = 100;
        int Backheight = 100;
        int Backx = (frameSize.width / 12) - (Backwidth / 2);
        int Backy = frameSize.height - (frameSize.height / 4) - (Backheight / 3);
        bBACK.setText("BACK");
        bBACK.setBounds(Backx, Backy, Backwidth, Backheight);
        bBACK.setForeground(Color.BLACK);
        bBACK.setVisible(false);
        bBACK.setFocusable(false);
        add(bBACK);
        //--------------------------------------------------------

        bSETTINGS.addActionListener((e) -> {
            bRESUME.setVisible(false);
            bQUIT.setVisible(false);
            bSETTINGS.setVisible(false);                                //Button Settings
            bBACK.setVisible(true);
            bSTART.setVisible(false);
        });
        int Setwidth = 200;
        int Setheight = 100;
        int Setx = (frameSize.width / 2) - (Setwidth / 2);
        int Sety = (frameSize.height / 2) - (Setheight / 2) - (Setheight / 4);
        bSETTINGS.setText("SETTINGS");
        bSETTINGS.setBounds(Setx, Sety, Setwidth, Setheight);
        bSETTINGS.setForeground(Color.BLACK);
        bSETTINGS.setVisible(true);
        bSETTINGS.setFocusable(false);
        add(bSETTINGS);
        //--------------------------------------------------------
        bQUIT.addActionListener((e) -> System.exit(0));
        int Quitwidth = 200;
        int Quitheight = 100;
        int Quitx = (frameSize.width / 2) - (Setwidth / 2);
        int Quity = (frameSize.height / 2) + (Quitheight / 2);
        bQUIT.setText("QUIT");
        bQUIT.setBounds(Quitx, Quity, Quitwidth, Quitheight);
        bQUIT.setForeground(Color.BLACK);
        bQUIT.setVisible(true);
        bQUIT.setFocusable(false);
        add(bQUIT);

        //--------------------------------------------------------

        //System.out.println(Startx+"|"+Starty);

        //--------------------------------------------------------

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyPressed(e);
                if (e.getKeyCode() == KeyEvent.VK_ESCAPE && jpanel.isVisible()) {
                    timer.stop();
                    jpanel.setVisible(false);
                    bRESUME.setVisible(true);
                    bSETTINGS.setVisible(true);
                    bQUIT.setVisible(true);
                    sek = 0;
                }
            }
        });
        //--------------------------------------------------------

        timer.addActionListener((e) -> {
            sek++;
            System.out.println(sek);
            if (sek == 11) {
                timer.stop();
                jpanel.setVisible(false);
                bSTART.setVisible(true);
                bSETTINGS.setVisible(true);
                bQUIT.setVisible(true);
                sek = 0;
            }
        });
        setVisible(true);
    }
}