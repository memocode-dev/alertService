package dev.memocode.alertservice.email.usecase;

public interface EmailUseCase {
    void sendCode(String email, String title, String content);
}
