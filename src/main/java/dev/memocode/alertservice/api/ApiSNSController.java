package dev.memocode.alertservice.api;

import dev.memocode.alertservice.api.form.SendSNSForm;
import dev.memocode.alertservice.sns.usecase.SNSUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ApiSNSController {

    private final SNSUseCase snsUseCase;

    @PostMapping("/sns/send")
    public ResponseEntity<Void> sendSNS(@RequestBody SendSNSForm form) {

        snsUseCase.sendSNS(form.getPhoneNumber(), form.getMessage());

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
