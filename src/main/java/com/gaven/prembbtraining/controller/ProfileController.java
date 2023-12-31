package com.gaven.prembbtraining.controller;

import com.gaven.prembbtraining.model.request.GetProfileRequest;
import com.gaven.prembbtraining.model.request.PostProfileRequest;
import com.gaven.prembbtraining.model.response.GetProfileResponse;
import com.gaven.prembbtraining.model.response.GetProfilesResponse;
import com.gaven.prembbtraining.service.GetProfileService;
import com.gaven.prembbtraining.service.GetProfilesService;
import com.gaven.prembbtraining.service.PostProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProfileController {

    private final GetProfileService getProfileService;
    private final GetProfilesService getProfilesService;
    private final PostProfileService postProfileService;

    @GetMapping("/v1/profile/")
    public GetProfilesResponse getProfiles() {
        return getProfilesService.execute();
    }

    @GetMapping("/v1/profile/{username}/")
    public GetProfileResponse getProfile(@PathVariable String username) {
        var request = GetProfileRequest.builder()
                .username(username).build();
        return getProfileService.execute(request);
    }

    @PostMapping("/v1/profile/")
    @ResponseStatus(HttpStatus.CREATED)
    public void postProfile(@RequestBody PostProfileRequest request) {
        postProfileService.execute(request);
    }
}
