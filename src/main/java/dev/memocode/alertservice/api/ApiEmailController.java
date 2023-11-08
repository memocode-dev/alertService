package dev.memocode.alertservice.api;

import dev.memocode.alertservice.api.form.SendEmailForm;
import dev.memocode.alertservice.email.usecase.EmailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
public class ApiEmailController {

    private final EmailUseCase emailUseCase;

    @PostMapping("/email/send")
    public ResponseEntity<Void> sendEmail(@RequestBody SendEmailForm form) {

        emailUseCase.sendCode(form.getEmail(), form.getTitle(), form.getContent());

        return ResponseEntity.status(CREATED).build();
    }
}
