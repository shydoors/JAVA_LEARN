package com.ds.stu.cuit;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MusicPlayer {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            // 指定音频文件的路径
            String path = sc.nextLine();
            File audioFile = new File(path);
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
class MusicList{
    private char ch1='\"',ch2='\'';
    static ArrayList<String> MySongs;
    public MusicList(){}
    public MusicList(String path){
        if(path.charAt(0)!=ch1){
            path=path.substring(1,path.length()-1);
        }
        if(MySongs == null){MySongs = new ArrayList<String>();}
        else{MySongs.add(path);}
    }

}