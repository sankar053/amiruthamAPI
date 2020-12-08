package com.iii.amirutham.service;
public interface ISecurityUserService {

    String validatePasswordResetToken(String token);
    String validateOneTimePassword(String otp);

}