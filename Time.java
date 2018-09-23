import javax.swing.*;
import java.io.*;
import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.*;

public class Time implements Serializable {
    int AlarmTime;
    String Date;
    static ArrayList<Time> alarmTimeList = new ArrayList<Time>();

    public Time() {

    }

    public Time(int alarmTime, String date) {
    AlarmTime = alarmTime;
    Date = date;
    }

    public static void addAlarmTime(Time x) {
        alarmTimeList.add(x);
    }

    public static void sortAlarmTime() {
        Collections.sort(alarmTimeList, new SortbyTime());
    }

    public static String Splitter(Time x) {
        String y = String.valueOf(x.getAlarmTime());
        if (y.equals("0")) {
            System.out.println("Zero alarm time!");
            return null;
        } else {
            String[] z = y.split("");
            String result = z[0] + z[1] + ":" + z[2] + z[3];
            return result;
        }
    }

    public  void setAlarmTime(int x) {
        AlarmTime = x;
    }

    public  int getAlarmTime(){
        int x=0;
        x = AlarmTime;
        return x;
    }

    public static void setArrayTimeDate(DefaultListModel x) {
        x.clear();
        String[] y = new String[Time.alarmTimeList.size()];

        for (int i = 0; i < Time.alarmTimeList.size(); i++) {

            y[i] = Time.alarmTimeList.get(i).Date+" "+Time.Splitter(Time.alarmTimeList.get(i));

        }

        for (int i = 0; i < y.length; i++) {

            x.addElement(y[i]);

        }
    }

    public static int getActualTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        int time;
        time = Integer.parseInt(sdf.format(Calendar.getInstance().getTime()));
        return time;
    }

    public static String getActualDate() {
        SimpleDateFormat sdf_b = new SimpleDateFormat("yyyy.MM.dd");
        String stime_b;

        stime_b = sdf_b.format(Calendar.getInstance().getTime());
        return stime_b;
    }

    public static void TimeRemove(int index) {
        alarmTimeList.remove(index);
        GUI.listModel.remove(index);
    }


    static class SortbyTime implements Comparator<Time> {
        public int compare(Time a, Time b)
        {
            return a.AlarmTime - b.AlarmTime;
        }
    }

    public static void SaveList() {
        try {
            TimeSaver time = new TimeSaver(alarmTimeList);
            FileOutputStream fs = new FileOutputStream("Alarm.ser");
            ObjectOutputStream  os = new ObjectOutputStream(fs);
            os.writeObject(time);
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void RestoreList() {
        try {
            TimeSaver time;
            FileInputStream fs = new FileInputStream("Alarm.ser");
            ObjectInputStream os = new ObjectInputStream(fs);
            Object one = os.readObject();
            time = (TimeSaver) one;
            os.close();
            Time.alarmTimeList = time.SaveAlarmTimeList;
            Time.setArrayTimeDate(GUI.listModel);
        } catch (Exception ex) {ex.printStackTrace();}

    }

}
