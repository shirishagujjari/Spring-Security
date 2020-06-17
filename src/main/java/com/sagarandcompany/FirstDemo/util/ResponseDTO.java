package com.sagarandcompany.FirstDemo.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO {
    private boolean status;
    private String message;
    private Object data;
}
