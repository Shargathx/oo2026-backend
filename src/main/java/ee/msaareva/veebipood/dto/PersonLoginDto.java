package ee.msaareva.veebipood.dto;

import lombok.Data;

@Data
public class PersonLoginDto {
    private String email;
    private String password;
}
