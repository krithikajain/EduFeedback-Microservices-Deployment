package swe642.hw3.SpringBoot.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import swe642.hw3.SpringBoot.model.UserInfo;


@Repository
public interface UserInfoRepository extends CrudRepository<UserInfo, Long> {

}

