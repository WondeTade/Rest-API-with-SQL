package com.bulimas.informationhub.controllers.personalInformation;


import com.bulimas.informationhub.exception.ApiBadRequestException;
import com.bulimas.informationhub.exception.ApiResourceException;
import com.bulimas.informationhub.repository.NicknameFinderRepository;
import com.bulimas.informationhub.repository.PersonalInformationRepository;
import com.bulimas.informationhub.resource.peronalinfoentity.PersonalInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/person")
public class PersonalInfoController {

    private final PersonalInformationRepository personalInformationRepository;
    private final NicknameFinderRepository nicknameFinderRepository;

    public PersonalInfoController(PersonalInformationRepository personalInformationRepository,
                                  NicknameFinderRepository nicknameFinderRepository) {
        this.personalInformationRepository = personalInformationRepository;
        this.nicknameFinderRepository = nicknameFinderRepository;
    }
    

    private PersonalInformation personalInformation;

    @GetMapping("/")
    public List<PersonalInformation> personalInformationList() {
        return personalInformationRepository.findAll();
    }

    @GetMapping("user/name/{nickName}")
    public PersonalInformation getPersonalInfoByNickName(@PathVariable("nickName") String nickName) {

        personalInformation = nicknameFinderRepository.findByNickName(nickName)
                .orElseThrow(() ->new ApiResourceException("Person not found"));

        return personalInformation;
    }

    @GetMapping("user/{fullName}")
    public PersonalInformation getPersonalInfoByFullName(@PathVariable("fullName") String fullName) {

        personalInformation = personalInformationRepository.findByFullName(fullName)
                .orElseThrow(() -> new ApiBadRequestException("Person not found or Unidentified Path"));
        return personalInformation;

    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public void postPersonalInformation(@Valid @RequestBody PersonalInformation personalInformation) {
        personalInformationRepository.save(personalInformation);
    }


    @PutMapping("/user/{fullName}")
    public void updatePersonInfoByUserName(@Valid @PathVariable("fullName") String fullName,
                                           @RequestBody PersonalInformation updateInformation) {

        personalInformation = personalInformationRepository.findByFullName(fullName)
                .orElseThrow(() -> new ApiBadRequestException("Person not found / Unidentified Path / Full name must be 2 char"));

        try {
                personalInformation.setFullName(updateInformation.getFullName());
                personalInformation.setFacebookInfo(updateInformation.getFacebookInfo());
                personalInformation.setNickName(updateInformation.getNickName());
                personalInformation.setEmail(updateInformation.getEmail());
                personalInformation.setMaritalStatus(updateInformation.getMaritalStatus());
                personalInformation.setPhoneNumber(updateInformation.getPhoneNumber());
                personalInformation.setYoutubeInfo(updateInformation.getYoutubeInfo());

                personalInformationRepository.save(personalInformation);
            }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        if (updateInformation.getFullName().length() < 2) {
            System.out.println("Full name lenght is less than 2 characters printing from exception");
        }

    }

    @DeleteMapping("/admin/{fullName}")
    public void deletePersonInfoById(@PathVariable("fullName") String fullName) {
        try {

            personalInformation = personalInformationRepository.findByFullName(fullName)
                    .orElseThrow(() -> new ApiBadRequestException("Person not found or Unidentified Path"));
            Optional<PersonalInformation> personalInformation = personalInformationRepository.findByFullName(fullName);

            personalInformationRepository.delete(personalInformation.get());
        } catch (Exception e) {
            e.getMessage();
        }

    }

}
