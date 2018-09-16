import java.text.SimpleDateFormat;
import java.util.Calendar;


public class AlarmClock {
  public static int AlarmTime;
  public static int SAlarmTime;
    public static void main(String[] args) {
        GUI gui = new GUI();
        gui.makegui();
      //  gui.setVisible(true);
        AlarmClock alarmTime = new AlarmClock();
       // AlarmClock.setAlarmTime(1541);

        //TextToSpeech textToSpeech = new TextToSpeech();
        try {
            while (true) {
                Thread.sleep(2000);
                int time = alarmTime.TimeDef();
                String stime_b = alarmTime.TimeDef_S();
                System.out.println(time);
                System.out.println("Stand by. Time has not come yet........................................");

               // AlarmTime = gui.getTime();
                if (time == gui.getTime()) {
                    System.out.println(stime_b);
                    Alarm.play("C:\\Java\\AlarmClock\\src\\ala.wav");
                    gui.dataremover();
                    // textToSpeech.SpeakText(stime_b);


                }

            }

        } catch (Exception exc) {
        System.out.println(exc);
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
    public static int getAlarmTime(){
        int x=0;
        AlarmTime = x;
        return x;
    }

    public static String TimeDef_S() {
        Calendar cal;
       // SimpleDateFormat sdf_b = new SimpleDateFormat("yyyy EEE MMM 'at' HH:mm:ss");
        SimpleDateFormat sdf_b = new SimpleDateFormat("yyyy.MM.dd");
        String stime_b;
        cal = Calendar.getInstance();
        stime_b = sdf_b.format(cal.getTime());
        return stime_b;
    }
}