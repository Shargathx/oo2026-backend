package ee.msaareva.veebipood.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ParcelMachine {
    @JsonProperty("ZIP")
    private String zip;
    @JsonProperty("NAME")
    private String name;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("A0_NAME")
    private String a0_name;
    @JsonProperty("A1_NAME")
    private String a1_name;
    @JsonProperty("A2_NAME")
    private String a2_name;
    @JsonProperty("A3_NAME")
    private String a3_name;
    @JsonProperty("A4_NAME")
    private String a4_name;
    @JsonProperty("A5_NAME")
    private String a5_name;
    @JsonProperty("A6_NAME")
    private String a6_name;
    @JsonProperty("A7_NAME")
    private String a7_name;
    @JsonProperty("A8_NAME")
    private String a8_name;
    @JsonProperty("X_COORDINATE")
    private String x_coordinate;
    @JsonProperty("Y_COORDINATE")
    private String y_coordinate;
    @JsonProperty("SERVICE_HOURS")
    private String service_hours;
    @JsonProperty("TEMP_SERVICE_HOURS")
    private String tEMP_service_hours;
    @JsonProperty("TEMP_SERVICE_HOURS_UNTIL")
    private String tEMP_service_hours_UNTIL;
    @JsonProperty("TEMP_SERVICE_HOURS_2")
    private String tEMP_service_hours_2;
    @JsonProperty("TEMP_SERVICE_HOURS_2_UNTIL")
    private String tEMP_service_hours_2_UNTIL;
    private String comment_est;
    private String comment_eng;
    private String comment_rus;
    private String comment_lav;
    private String comment_lit;
    @JsonProperty("MODIFIED")
    private Date modified;
}