import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.encoder.QRCode;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class GenerateQr extends JFrame {
    private JTextField inputField;
    private JButton generateButton;
    private JLabel qrCodeLabel;

    public GenerateQr(){
        setTitle("Generate QR");
        setSize(820,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputPanel.add(inputField, BorderLayout.CENTER);

        generateButton = new JButton("Generate QR Code");
        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try{
                    new PlayAudio();
                } catch(LineUnavailableException ex) {
                    ex.printStackTrace();
                } catch(IOException ex) {
                    ex.printStackTrace();
                } catch(UnsupportedAudioFileException ex) {
                    ex.printStackTrace();
                }
                generateQRCode();
            }
        });
        inputPanel.add(generateButton, BorderLayout.SOUTH);

        add(inputPanel, BorderLayout.NORTH);

        // Label to display QR code
        qrCodeLabel = new JLabel();
        add(qrCodeLabel, BorderLayout.CENTER);

        setVisible(true);

        setVisible(true);
        setDefaultCloseOperation(3);
    }

    private void generateQRCode() {
        String qrText = inputField.getText();
        try {
            int size = 300;
            QRCodeWriter writer = new QRCodeWriter();
            BitMatrix bitMatrix = writer.encode(qrText, BarcodeFormat.QR_CODE, size, size);
            BufferedImage qrImage = new BufferedImage(size, size, BufferedImage.TYPE_INT_RGB);
            for (int x = 0; x < size; x++) {
                for (int y = 0; y < size; y++) {
                    qrImage.setRGB(x, y, bitMatrix.get(x, y) ? Color.BLACK.getRGB() : Color.WHITE.getRGB());
                }
            }
            ImageIcon icon = new ImageIcon(qrImage);
            qrCodeLabel.setIcon(icon);
        } catch (WriterException ex) {
            ex.printStackTrace();
        }
    }

}
