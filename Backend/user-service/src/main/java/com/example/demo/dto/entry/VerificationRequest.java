package com.example.demo.dto.entry;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VerificationRequest {
    private String email;
    private String verificationCode;


}
