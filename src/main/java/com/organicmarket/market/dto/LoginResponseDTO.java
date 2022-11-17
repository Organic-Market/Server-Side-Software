package com.organicmarket.market.dto;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LoginResponseDTO {
    private Long id;
    private String name;
    private String lastname;
    private String address;
    private String username;
    private String email;

}
