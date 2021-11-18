package com.laptrinhweb.shopkibe.service;

import com.laptrinhweb.shopkibe.entity.Profile;
import com.laptrinhweb.shopkibe.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class ProfileService implements IProfileService {
    @Autowired
    private ProfileRepository profileRepository;
    @Override
    public Profile updateProfile(Long id, Profile profile) {
        if(profile != null){
            Profile profile1=profileRepository.getById(id);
            if(profile1 != null){
                profile1.setName(profile.getName());
                profile1.setNameShop((profile.getNameShop()));
                profile1.setPhoneNumber(profile.getPhoneNumber());
                profile1.setEmail(profile.getEmail());
                profile1.setSex(profile.getSex());
                return profileRepository.save(profile1);
            }
        }        return null;
    }


}
