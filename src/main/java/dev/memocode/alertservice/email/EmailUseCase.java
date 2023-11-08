package dev.memocode.alertservice.email;

public interface EmailUseCase {
    void sendCode(String email, String title, String content);
}
