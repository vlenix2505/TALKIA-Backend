package com.upc.talkiaBackend.security.dtos;

@lombok.Data
public class AuthResponseDTO {
    private String jwt;
    private String rol;
    private Integer userId;
    private Integer levelId;
}