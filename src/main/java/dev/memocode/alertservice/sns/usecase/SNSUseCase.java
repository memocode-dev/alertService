package dev.memocode.alertservice.sns.usecase;

public interface SNSUseCase {
    void sendSNS(String phoneNumber, String message);
}
