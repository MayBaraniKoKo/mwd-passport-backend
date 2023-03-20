package com.example.mwdpassportbe.repo;

import com.example.mwdpassportbe.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author maybaranikoko
 * @since 20-Mar-23
 * Purpose:
 */
public interface RegistrationRepo extends JpaRepository <Registration, String> {
}
