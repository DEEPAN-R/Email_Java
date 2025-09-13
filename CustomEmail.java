
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.*;
import java.io.File;

public class CustomEmail {
    public static void main(String[] args) {

        final String username = "deepan41103@gmail.com";
        final String password = "wwlrprzdokjrxpmq";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("massdeepan777@gmail.com"));

            message.setSubject("Sample Email with Text, HTML, and Image");


            Multipart multipart = new MimeMultipart();

            MimeBodyPart textPart = new MimeBodyPart();
            textPart.setText("This is the plain text part.");

            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent("<h2>This is HTML content</h2><p style='color:red;'>Red text</p>", "text/html");

            MimeBodyPart imagePart = new MimeBodyPart();
            imagePart.attachFile(new File("C:\\Users\\Sarathi.M\\Desktop\\download.jpg"));

            multipart.addBodyPart(textPart);
            multipart.addBodyPart(htmlPart);
            multipart.addBodyPart(imagePart);


            message.setContent(multipart);

            Transport.send(message);


            System.out.println("Email sent successfully with text, HTML, and image!");

        } catch (Exception e) {
        	  System.out.println("Exception caught: " + e.getMessage());
        }
    }
}
