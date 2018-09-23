import java.io.*;
import javax.sound.sampled.*;
class Alarm {

 static void play(String file) {
    File file1 = new File(file);
    try
    {
        Clip clip = AudioSystem.getClip();
        AudioInputStream mus = AudioSystem.getAudioInputStream(file1);
        clip.open(mus);
        AudioFormat format = mus.getFormat();
        long dur = mus.getFrameLength();
        double durationInSeconds = (dur+0.0) / format.getFrameRate()*1000;
        int duration = (int) durationInSeconds;


        clip.start();
        Thread.sleep( duration );

    }
    catch (Exception exc) {
        exc.printStackTrace(System.out);
    }
}
}
