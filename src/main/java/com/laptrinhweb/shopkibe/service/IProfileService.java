package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.entity.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProfileService {
    public Profile updateProfile(Long id, Profile profile);



}
