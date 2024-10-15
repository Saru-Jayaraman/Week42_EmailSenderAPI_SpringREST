package se.lexicon.week42_emailsenderapi_springrest.service;

import se.lexicon.week42_emailsenderapi_springrest.domain.dto.EmailDTO;

public interface EmailService {
    void sendEmail(EmailDTO dto);
}
