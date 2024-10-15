package se.lexicon.week42_emailsenderapi_springrest.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.lexicon.week42_emailsenderapi_springrest.domain.dto.EmailDTO;
import se.lexicon.week42_emailsenderapi_springrest.service.EmailService;

@RequestMapping("/api/v1/email")
@RestController
public class EmailController {

    EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    public ResponseEntity<Void> doSendEmail(@RequestBody @Valid EmailDTO emailDTO) {
        emailService.sendEmail(emailDTO);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
