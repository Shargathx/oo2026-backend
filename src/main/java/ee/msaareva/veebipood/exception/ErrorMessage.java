package ee.msaareva.veebipood.exception;

import lombok.Data;

import java.util.Date;

@Data // @Getter  @Setter  @NoArgsConstructor
public class ErrorMessage {
    private String message;
    private Date timestamp;
    private int status;
}
