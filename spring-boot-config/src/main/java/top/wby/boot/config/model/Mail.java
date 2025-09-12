package top.wby.boot.config.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class Mail {
    @NotNull
    @Email
    private String to;
    private String subject;
    private String content;
}
