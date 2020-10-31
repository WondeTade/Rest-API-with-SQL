package com.bulimas.informationhub.resource.peronalinfoentity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.scheduling.annotation.Scheduled;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = PersonalInformation.TABLE_NAME)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonalInformation {

    public static final String TABLE_NAME = "personalInformation";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long personId = 0000L;

    @NotEmpty(message = "Name is required. Please provide")
    @Size(min = 2, message = "Name should be at least 2 characters")
    @Column(nullable = false)
    private String fullName;

    private String nickName;
    private String email;
    private String phoneNumber;
    private String maritalStatus;
    private String youtubeInfo;
    private String facebookInfo;

    public PersonalInformation() {

    }

    public PersonalInformation(Long personId, String fullName, String nickName, String email,
                               String phoneNumber, String maritalStatus,
                               String youtubeInfo, String facebookInfo) {
        this.personId = personId;
        this.fullName = fullName;
        // nick name should not be more than 15 characters including spaces
        this.nickName = nickName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.maritalStatus = maritalStatus;
        this.youtubeInfo = youtubeInfo;
        this.facebookInfo = facebookInfo;
    }

    public Long getPersonalId() {
        return personId;
    }

    public void setPersonId(long id) {
        this.personId = personId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getYoutubeInfo() {
        return youtubeInfo;
    }

    public void setYoutubeInfo(String youtubeInfo) {
        this.youtubeInfo = youtubeInfo;
    }

    public String getFacebookInfo() {
        return facebookInfo;
    }

    public void setFacebookInfo(String facebookInfo) {
        this.facebookInfo = facebookInfo;
    }



}
