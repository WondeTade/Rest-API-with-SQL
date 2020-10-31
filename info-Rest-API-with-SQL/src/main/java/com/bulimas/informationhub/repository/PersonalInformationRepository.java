package com.bulimas.informationhub.repository;

import com.bulimas.informationhub.resource.peronalinfoentity.PersonalInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonalInformationRepository extends JpaRepository<PersonalInformation, Long> {

    Optional<PersonalInformation> findByFullName(String fullName);
}
