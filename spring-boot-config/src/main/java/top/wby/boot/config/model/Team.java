package top.wby.boot.config.model;

import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class Team {
    @Value("${team.name}")
    @NotNull
    @Length(min = 3, max = 20)
    private String name;

    @Value("${team.leader}")
    @Size(min = 3, max = 20)
    private String leader;

    @Value("${team.age}")
    @Min(1)
    @Max(4)
    private Integer age;

    @Value("${team.phone}")
    @Pattern(regexp = "^[0-9]{11}$")
    private String phone;
}
