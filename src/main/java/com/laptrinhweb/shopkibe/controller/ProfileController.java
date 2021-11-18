package com.laptrinhweb.shopkibe.controller;

import com.laptrinhweb.shopkibe.entity.Profile;
import com.laptrinhweb.shopkibe.repository.ProfileRepository;
import com.laptrinhweb.shopkibe.service.IProfileService;
import com.laptrinhweb.shopkibe.service.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    private ProfileService profileService;
@Autowired
    ProfileRepository profileRepository;
    //API update profile
    @PutMapping("/update")
    public Profile updateProfile (@RequestBody Profile profile){
                return profileRepository.save(profile);
        }

    //API delete
    @DeleteMapping("/delete/{id}")
    public void deleteProfile(@PathVariable long id){
        profileRepository.deleteById(id);
    }


}
