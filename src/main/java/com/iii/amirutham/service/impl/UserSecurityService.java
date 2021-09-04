package com.iii.amirutham.service.impl;

import java.util.Base64;
import java.util.Calendar;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.model.user.PasswordResetToken;
import com.iii.amirutham.repo.PasswordResetTokenRepository;
import com.iii.amirutham.service.ISecurityUserService;

@Service
@Transactional
public class UserSecurityService implements ISecurityUserService {

	@Autowired
	private PasswordResetTokenRepository passwordTokenRepository;

	@Override
	public String validatePasswordResetToken(String token) {
		final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);

		return !isTokenFound(passToken) ? "invalidToken" : isTokenExpired(passToken) ? "expired" : null;
	}

	private boolean isTokenFound(PasswordResetToken passToken) {
		return passToken != null;
	}

	private boolean isTokenExpired(PasswordResetToken passToken) {
		final Calendar cal = Calendar.getInstance();
		return passToken.getExpiryDate().before(cal.getTime());
	}

	@Override
	public String validateOneTimePassword(String otp) {
		// TODO Auto-generated method stub
		byte[] decriptedOtpByts = Base64.getDecoder().decode(otp);
		String decriptedOtpstr = new String(decriptedOtpByts);
		String[] otpArr = decriptedOtpstr.split("-");
		if (otpArr.length > 0) {
			final PasswordResetToken passToken = passwordTokenRepository.findByOneTimePassword(otpArr[0]);

			return !isTokenFound(passToken) ? "invalidToken" : isTokenExpired(passToken) ? "expired" : null;
		}
		return null;
	}
}