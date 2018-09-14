import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.security.BasicPermission;


public class GUI extends JFrame {
    private JTextField InputH = new JTextField(2);
    private JTextField InputM = new JTextField(2);
    private JLabel labelH = new JLabel("Hours");
    private JLabel labelM = new JLabel("Minutes");
    private JLabel label = new JLabel("Set alarm time");
    private JButton Setbutton = new JButton("Set");
    private JPanel panelN = new JPanel();
    private JPanel panelE = new JPanel();
    private JFrame frame = new JFrame();

    public GUI() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Alarmic");

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setHgap(10);

        panelN.setLayout(layout);
        panelE.setLayout(new BoxLayout(panelE, BoxLayout.Y_AXIS));

        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        frame.setLayout(borderLayout);

        panelN.add(InputH);
        panelN.add(labelH);
        panelN.add(InputM);
        panelN.add(labelM);
        panelE.add(label);
        panelE.add(Setbutton);

        frame.getContentPane().add(borderLayout.NORTH,panelN);
        frame.getContentPane().add(borderLayout.WEST,panelE);

        frame.setSize(300, 150);
        frame.setVisible(true);
        Setbutton.addActionListener(new SetListener());
        frame.setResizable(false);
    }
    class SetListener implements ActionListener {


    public void actionPerformed(ActionEvent event) {
        String s1 = InputH.getText();
        String s2 = InputM.getText();
        String s = s1+s2;
        AlarmClock.setAlarmTime(Integer.parseInt(s));
    }
    }



}
/*



 */

