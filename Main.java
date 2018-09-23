public class Main {
    static int time;
    //Enter main method
    public static void main(String[] args) {
    GUI gui = new GUI();

    try {
        Time.RestoreList();
    } catch (Exception e) {
        e.printStackTrace();
    }
        gui.go();
    while (true) {
        try {
            time = Time.getActualTime();
            Time AlarmTime = Time.alarmTimeList.get(0);
            if (time == AlarmTime.AlarmTime) {
                Fileplay.play("C:\\Java\\Alarmic\\src\\AlarmSounds\\AlarmClock.wav");
                Time.TimeRemove(0);
                Time.SaveList();
            }


        } catch (Exception e) {
        }
    }
    } //Exit main method

}
