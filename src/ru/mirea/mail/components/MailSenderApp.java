package ru.mirea.mail.components;

import ru.mirea.mail.utils.Sender;

import javax.mail.MessagingException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class MailSenderApp extends JFrame {

    private JLabel labelTo = new JLabel("To: ");
    private JTextField fieldTo = new JTextField(30);
    private Font fnt = new Font("ComicSans", Font.PLAIN, 14);

    private JLabel message = new JLabel("Message: ");
    private JTextArea messageArea = new JTextArea();
    private JButton sendButton = new JButton("Send");

    private Sender sender = new Sender();

    public MailSenderApp(String title) throws IOException {
        super(title);

        this.setFont(fnt);
        setLayout(null);
        setVisible(true);
        labelTo.setBounds(10, 10, 50, 20);
        labelTo.setFont(fnt);
        add(labelTo);
        fieldTo.setBounds(60, 10, 100, 20);
        add(fieldTo);
        message.setFont(fnt);
        message.setBounds(10, 30, 100, 20);
        add(message);
        messageArea.setBounds(10, 50, 250, 250);
        messageArea.setLineWrap(true);
        add(messageArea);
        sendButton.setBounds(270, 50, 120, 20);
        add(sendButton);

        sendButton.addActionListener(e -> {
            try {
                sender.send(fieldTo.getText(), messageArea.getText());
            } catch (MessagingException messagingException) {
                messagingException.printStackTrace();
            }
        });

        setSize(420, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
}
