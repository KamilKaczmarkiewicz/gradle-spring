package ProfessionalJavaDeveloper.mail.service;

import ProfessionalJavaDeveloper.mail.EmailDetails;

public interface EmailService {

    String sendSimpleMail(EmailDetails details);

    String sendMailWithAttachment(EmailDetails details);
}
