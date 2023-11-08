package dev.memocode.alertservice.email.impl;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailService;
import com.amazonaws.services.simpleemail.model.*;
import dev.memocode.alertservice.email.EmailUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class EmailUseCaseImpl implements EmailUseCase {

    @Value("${custom.email.from_email}")
    private String FROM_EMAIL;

    private final AmazonSimpleEmailService sesClient;

    public void sendCode(String email, String title, String content) {
        // 제목
        Content subject = new Content().withCharset("UTF-8").withData(title);

        // 내용
        Body body = new Body().withHtml(new Content()
                .withCharset("UTF-8")
                .withData(content));

        // 메시지 생성
        SendEmailRequest request = new SendEmailRequest()
                .withSource(FROM_EMAIL)
                .withDestination(new Destination().withToAddresses(email)) // 받는 사람
                .withMessage(new Message()
                        .withSubject(subject)
                        .withBody(body)
                );

        try {
            sesClient.sendEmail(request);
        } catch (Exception ex) {
            throw ex;
        }
    }
}
