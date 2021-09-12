package com.iii.amirutham.repo;

import java.util.Date;
import java.util.stream.Stream;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.iii.amirutham.model.user.PasswordResetToken;
import com.iii.amirutham.model.user.User;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);
    
    PasswordResetToken findByOneTimePassword(String otp);

    PasswordResetToken findByUser(User user);

    Stream<PasswordResetToken> findAllByExpiryDateLessThan(Date now);

    void deleteByExpiryDateLessThan(Date now);
    
    @Modifying
    @Query("update PasswordResetToken set  pwdActive='N' where id = ?1")
    void updatePwdFlag(Long i);

    @Modifying
    @Query("delete from PasswordResetToken t where t.expiryDate <= ?1")
    void deleteAllExpiredSince(Date now);
}