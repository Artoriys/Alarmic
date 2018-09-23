import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;


public class GUI extends JFrame {
    private ArrayList<Integer> time = new ArrayList<Integer>(100);
    private DefaultListModel data = new DefaultListModel();
    private JList ShowAlarm = new JList(data);
    private JScrollPane scrollPane = new JScrollPane(ShowAlarm);
    private JTextField InputH = new JTextField(2);
    private JTextField InputM = new JTextField(2);
    private JLabel labelH = new JLabel("Hours");
    private JLabel labelM = new JLabel("Minutes");
    private JLabel label = new JLabel("Set alarm time");
    private JButton Setbutton = new JButton("Set");
    private JButton DelButton = new JButton("Delete");
    private JPanel panelEF = new JPanel();
    private JPanel panelN = new JPanel();
    private JPanel panelE = new JPanel();
    private JFrame frame = new JFrame();
    private JPanel panelS = new JPanel();
    public GUI() {

    }

     void makegui() {

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Alarmic");

        FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
        layout.setHgap(10);
        panelN.setLayout(layout);
        panelEF.setLayout(layout);

        panelE.setLayout(new BoxLayout(panelE, BoxLayout.Y_AXIS));

        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        frame.setLayout(borderLayout);
        //Scroller
        ShowAlarm.setVisibleRowCount(10);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
      //  ShowAlarm.setText("Hello");
      //  ShowAlarm.append("Not hello");
       // ShowAlarm.selectAll();

        panelN.add(InputH);
        panelN.add(labelH);
        panelN.add(InputM);
        panelN.add(labelM);
        panelE.add(label);
        panelEF.add(Setbutton);
        panelEF.add(DelButton);
        panelS.add(scrollPane);

        panelE.add(panelEF);

        frame.getContentPane().add(BorderLayout.NORTH,panelN);
        frame.getContentPane().add(BorderLayout.WEST,panelE);
        frame.getContentPane().add(BorderLayout.SOUTH,panelS);


        frame.setSize(320, 300);
        frame.setVisible(true);
        Setbutton.addActionListener(new SetListener());
        DelButton.addActionListener(new DelListener());
        frame.setResizable(false);
    }
    class SetListener implements ActionListener {


    public void actionPerformed(ActionEvent event) {
        String s1 = InputH.getText();
        String s2 = InputM.getText();
        String s = s1+s2;
        String sm = AlarmClock.TimeDef_S()+" "+s1+":"+s2;

       // sData.add(s1+":"+s2);
            data.addElement(sm);
           // AlarmClock.setAlarmTime(Integer.parseInt(s));
            time.add(Integer.parseInt(s));

       // System.out.println(data);

    }
    }
    class DelListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            data.remove(ShowAlarm.getSelectedIndex());
            time.remove(0);
        }
    }
    public int getTime() {
        int x;
        x = time.get(0);
        return x;
    }

 void dataremover() {
        data.remove(0);
        time.remove(0);
        AlarmClock.setAlarmTime(time.get(0));

}
}
/*



 */

