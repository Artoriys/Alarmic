import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AlarmClock {
  private static int AlarmTime;
    public static void main(String[] args) {
        GUI gui = new GUI();
      //  gui.setVisible(true);
        AlarmClock alarmTime = new AlarmClock();
        AlarmClock.setAlarmTime(2400);
        //TextToSpeech textToSpeech = new TextToSpeech();
        try {
            while (true) {
                Thread.sleep(2000);
                int time = alarmTime.TimeDef();
                String stime_b = alarmTime.TimeDef_S();
                System.out.println("Stand by. Time has not come yet........................................");
                if (time == AlarmTime || time > AlarmTime) {
                    System.out.println(stime_b);
                    Alarm.play("C:\\Java\\AlarmClock\\src\\ala.wav");
                   // textToSpeech.SpeakText(stime_b);

                }

            }

        } catch (Exception exc) {
        System.out.println("Something wrong!!");
        }

    }
    public static void setAlarmTime(int x) {
        AlarmTime = x;
    }
    private int TimeDef() {
        Calendar cal;
        SimpleDateFormat sdf = new SimpleDateFormat("HHmm");
        String stime;
        int time;
        cal = Calendar.getInstance();
        stime = sdf.format(cal.getTime());
        time = Integer.parseInt(stime);
        return time;
    }

    private String TimeDef_S() {
        Calendar cal;
        SimpleDateFormat sdf_b = new SimpleDateFormat("yyyy EEE MMM 'at' HH:mm:ss");
        String stime_b;
        cal = Calendar.getInstance();
        stime_b = sdf_b.format(cal.getTime());
        return stime_b;
    }
}