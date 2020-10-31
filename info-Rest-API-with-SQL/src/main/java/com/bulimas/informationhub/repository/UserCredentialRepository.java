package com.bulimas.informationhub.repository;

import javax.sql.DataSource;

public interface UserCredentialRepository<UserCredentialInformation, String> {

    DataSource findByUserName();
}
