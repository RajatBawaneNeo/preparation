package com.videostream.app.videostream.response;

import com.videostream.app.videostream.dto.UserRequestDTO;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseDTO {

    private Long id;

    private String message;


}
