package encho_belezirev;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;

public class SendMailApache {
    public static void main(String[] args) throws MalformedURLException{
        EmailAttachment attachment = new EmailAttachment();
        attachment.setURL(new URL("http://d3dsacqprgcsqh.cloudfront.net/photo/azbW3zq_460sa_v1.gif"));
        attachment.setDisposition(EmailAttachment.ATTACHMENT);
        attachment.setName("Biting horse!");
        
        MultiPartEmail mail = new MultiPartEmail();
        mail.setHostName("smtp.gmail.com");
        mail.setSmtpPort(587);
        mail.setAuthenticator(new DefaultAuthenticator("encho.belezirev", ""));
        mail.setSSLOnConnect(true);
        mail.setDebug(true);
        try {
            mail.setFrom("encho.belezirev@gmail.com");
            mail.setSubject("Test email");
            mail.setMsg("This is a test message ----- :-)");
            mail.addTo("teodor.m.stamenov@gmail.com");
            mail.attach(attachment);
            mail.send();
        } catch (EmailException e) {
            e.printStackTrace();
        }
        
    }
}
