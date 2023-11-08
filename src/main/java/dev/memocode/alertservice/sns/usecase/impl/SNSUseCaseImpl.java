package dev.memocode.alertservice.sns.usecase.impl;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import dev.memocode.alertservice.sns.usecase.SNSUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class SNSUseCaseImpl implements SNSUseCase {

    private final AmazonSNS amazonSNS;

    @Override
    public void sendSNS(String phoneNumber, String message) {
        PublishRequest request = new PublishRequest()
                .withPhoneNumber(phoneNumber)
                .withMessage(message)
                .withMessageAttributes(Map.of(
                        "AWS.SNS.SMS.SMSType", new MessageAttributeValue()
                                // Transactional => 중요한 메세지
                                // Promotional => 광고성 메세지
                                .withStringValue("Transactional") // 또는 "Promotional"
                                .withDataType("String")));
        amazonSNS.publish(request);
    }
}
