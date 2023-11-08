package dev.memocode.alertservice.api.form;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendSNSForm {

    @NotBlank(message = "핸드폰 번호를 작성해주세요")
    private String phoneNumber;

    @NotBlank(message = "메세지를 작성해주세요")
    private String message;
}
