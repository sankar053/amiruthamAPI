package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iii.amirutham.model.PaymentFailure;

@Repository
public interface PaymentFailureRepository extends JpaRepository<PaymentFailure, Integer> {

}
