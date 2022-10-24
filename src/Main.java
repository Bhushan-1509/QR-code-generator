import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Main extends JFrame {
    public Main() {
        JFrame mainFrame = new JFrame();
        mainFrame.setTitle("QR Code generator");
        mainFrame.setLocation(30,30);
        JLabel backgroundImage = new JLabel(new ImageIcon("images/hands-scanning-qr-code-close-up.jpg"));
        JButton generateQrCodeBtn = new JButton("Generate QR-Code");
        JButton readQrCodeBtn = new JButton("Read QR-Code");
        generateQrCodeBtn.setBounds(50,100,230, 60);
        generateQrCodeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitialLoading.load.dispose();
                try{
                    new PlayAudio();
                } catch(LineUnavailableException ex) {
                    ex.printStackTrace();
                } catch(IOException ex) {
                    ex.printStackTrace();
                } catch(UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                }
                InitialLoading.load = new GenerateQr();
//                InitialLoading.load.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
        });
        readQrCodeBtn.setBounds(50,200,230, 60);
        readQrCodeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InitialLoading.load.dispose();
                try{
                    new PlayAudio();
                } catch(LineUnavailableException ex) {
                    ex.printStackTrace();
                } catch(IOException ex) {
                    ex.printStackTrace();
                } catch(UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                }
                InitialLoading.load = new ReadQr();
//                InitialLoading.load.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
        mainFrame.setSize(820,600);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(readQrCodeBtn);
        mainFrame.add(generateQrCodeBtn);
        mainFrame.add(backgroundImage);
        mainFrame.setVisible(true);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}
