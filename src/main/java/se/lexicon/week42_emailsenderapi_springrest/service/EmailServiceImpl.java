package se.lexicon.week42_emailsenderapi_springrest.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import se.lexicon.week42_emailsenderapi_springrest.config.EmailProperties;
import se.lexicon.week42_emailsenderapi_springrest.domain.dto.EmailDTO;
import se.lexicon.week42_emailsenderapi_springrest.domain.entity.Email;
import se.lexicon.week42_emailsenderapi_springrest.exception.EmailException;
import se.lexicon.week42_emailsenderapi_springrest.repository.EmailRepository;

@Service
public class EmailServiceImpl implements EmailService {

    EmailRepository emailRepository;
    JavaMailSender javaMailSender;
    EmailProperties emailProperties;

    @Autowired
    public EmailServiceImpl(EmailRepository emailRepository, JavaMailSender javaMailSender, EmailProperties emailProperties) {
        this.emailRepository = emailRepository;
        this.javaMailSender = javaMailSender;
        this.emailProperties = emailProperties;
    }

    @Override
    public void sendEmail(EmailDTO dto) {
        if(dto == null)
            throw new IllegalArgumentException("Email DTO form is null...");

        try {
            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "utf-8");
            mimeMessage.setContent(dto.getHtml(), "text/html");
            helper.setTo(dto.getTo());
            helper.setFrom(emailProperties.getUsername());
            helper.setSubject(dto.getSubject());

            Email entity = Email.builder()
                    .to(dto.getTo())
                    .from(emailProperties.getUsername())
                    .subject(dto.getSubject())
                    .content(dto.getHtml())
                    .type(dto.getType())
                    .build();

            emailRepository.save(entity);
            javaMailSender.send(mimeMessage);
        } catch (MessagingException e) {
            throw new EmailException("Error Sending Email. " + e.getMessage(), e);
        }
    }
}
