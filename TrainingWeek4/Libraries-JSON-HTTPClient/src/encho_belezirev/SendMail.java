package encho_belezirev;

import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendMail {

    public static void main(String[] args) {
        Properties props = System.getProperties();
        props.put("mail.smtp.starttls.enable", true); 
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", "encho.belezirev");
        props.put("mail.smtp.password", "");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", true);

        Session session = Session.getInstance(props,null);
        MimeMessage message = new MimeMessage(session);
        try {
            InternetAddress from = new InternetAddress("encho.belezirev");
            message.setSubject("Send email java");
            message.setFrom(from);
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse("teodor.m.stamenov@gmail.com"));

            
            Multipart multipart = new MimeMultipart("alternative");

            
            BodyPart messageBodyPart = new MimeBodyPart();
            messageBodyPart.setText("teeessstttt");
            String filePath = "C:\\Users\\Belezirev\\Desktop\\azbW3zq_460sa_v1.gif";
            String fileName = "azbW3zq_460sa_v1.gif";
            DataSource source = new FileDataSource(filePath);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(fileName);
            multipart.addBodyPart(messageBodyPart);
            message.setContent(multipart);
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", "encho.belezirev", "9507Megaboy");
            System.out.println("Transport: "+transport.toString());
            transport.sendMessage(message, message.getAllRecipients());
        } catch (AddressException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (MessagingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
