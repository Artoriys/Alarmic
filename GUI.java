import javax.swing.*;
import java.awt.*;
import java.awt.event.*;




public class GUI extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panellist = new JPanel();
    private JPanel boxpanel = new JPanel();
    private JPanel labelpanel = new JPanel();
    private JPanel buttonpanel = new JPanel();
    private JLabel labelH = new JLabel("Hours");
    private JLabel labelM = new JLabel("Minutes");
    private JLabel label = new JLabel("Set alarm time");
    private JButton Setbutton = new JButton("Set");
    private JButton DelButton = new JButton("Delete");
    public static DefaultListModel listModel = new DefaultListModel();
    private JList ShowAlarm = new JList(listModel);
    private JScrollPane scrollPane = new JScrollPane(ShowAlarm);
    private JTextField InputH = new JTextField(2);
    private JTextField InputM = new JTextField(2);


     GUI() {
         //GUI settings
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Alarmic");

        FlowLayout flowLayout = new FlowLayout(FlowLayout.CENTER);
        flowLayout.setHgap(10);
        labelpanel.setLayout(flowLayout);
        buttonpanel.setLayout(flowLayout);

        BoxLayout boxLayout = new BoxLayout(boxpanel, BoxLayout.Y_AXIS);
        boxpanel.setLayout(boxLayout);

        BorderLayout borderLayout = new BorderLayout();
        borderLayout.setHgap(10);
        frame.setLayout(borderLayout);


        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        ShowAlarm.setFixedCellWidth(120);


        labelpanel.add(InputH);
        labelpanel.add(labelH);
        labelpanel.add(InputM);
        labelpanel.add(labelM);

        buttonpanel.add(Setbutton);
        buttonpanel.add(DelButton);

        boxpanel.add(labelpanel);
        boxpanel.add(buttonpanel);
        panellist.add(scrollPane);

        frame.getContentPane().add(panellist, BorderLayout.WEST);
        frame.getContentPane().add(boxpanel, BorderLayout.EAST);
        // frame.setIconImage(Toolkit.getDefaultToolkit().getImage(("bud.jpg")));
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage((getClass().getResource("Images\\bud.jpg"))));

    }
    //GUI visible
     void go() {
        frame.setSize(360, 220);
        frame.setVisible(true);
        Setbutton.addActionListener(new SetListener());
        DelButton.addActionListener(new DelListener());
        frame.setResizable(false);
    }
    //Set button listener
    class SetListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            String s1 = InputH.getText();
            String s2 = InputM.getText();
            String s = s1+s2;
            InputH.setText("");
            InputM.setText("");
            int time = Integer.parseInt(s);
            String date = Time.getActualDate();

            Time AlarmTime = new Time(time, date);
            Time.addAlarmTime(AlarmTime);
            Time.sortAlarmTime();
            Time.setArrayTimeDate(listModel);
            Time.SaveList();
        }

    }
    //Del button listener
    class DelListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            Time.TimeRemove(ShowAlarm.getSelectedIndex());
            Time.SaveList();
        }
    }

}
