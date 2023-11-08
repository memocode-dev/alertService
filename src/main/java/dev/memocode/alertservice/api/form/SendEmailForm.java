package dev.memocode.alertservice.api.form;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class SendEmailForm {

    @NotBlank(message = "이메일을 작성해주세요")
    @Email(message = "이메일 형식으로 작성해주세요")
    private String email;

    @NotBlank(message = "제목을 작성해주세요")
    private String title;

    @NotBlank(message = "내용을 작성해주세요")
    private String content;
}
