package com.resume.myResyme.repository;

import com.resume.myResyme.dto.DetailsDto;
import com.resume.myResyme.dto.GetDetails;
import com.resume.myResyme.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

public interface UserRepository extends JpaRepository<User,Long> {


     @Modifying
     @Transactional
     @Query(value = "insert into user values(1,?1,?2,?3,?4,?5)",nativeQuery = true) // This query inserts the details of the user into the database
     void addDetails( String firstName,String lastName,String email,String mobileNumber,String skills);

     @Query(value = "select user_id as userId, user_first_name as userFirstName, user_last_name as userLastName, user_email as userEmail, user_mobile_number as userMobileNumber, user_skills as userSkills from user where user_id=1",nativeQuery = true)
     GetDetails getDetails(); // This query gets the data from the database and sends it to service layer

     @Transactional
     @Modifying
     @Query(value = "update user set user_first_name=?1, user_last_name=?2, user_email=?3, user_mobile_number=?4, user_skills=?5 where user_id=1",nativeQuery = true)
     void updateDetails(String firstName,String lastName,String email,String mobileNumber,String skills);
     // This query updates the data in the database
}
