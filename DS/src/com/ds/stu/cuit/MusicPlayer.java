import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class MusicPlayer {
    public static void main(String[] args) {
        try {
            // 指定音频文件的路径
            File audioFile = new File("path/to/your/music.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // 播放音频
            clip.start();
            System.out.println("Playing music...");

            // 等待音乐播放完成
            Thread.sleep(clip.getMicrosecondLength() / 1000); // 转换为毫秒

            // 关闭音频流
            clip.close();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}