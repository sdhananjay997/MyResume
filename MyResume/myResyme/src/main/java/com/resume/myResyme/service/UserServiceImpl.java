package com.resume.myResyme.service;

import com.resume.myResyme.dto.DetailsDto;
import com.resume.myResyme.dto.GetDetails;
import com.resume.myResyme.model.User;
import com.resume.myResyme.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;
    @Override
    public void addDetails(DetailsDto detailsDto) { // This function call the repository function to save data into data base
        User s = new User(detailsDto.getFirstName(), detailsDto.getLastName()
                , detailsDto.getEmail(), detailsDto.getMobileNumber(), detailsDto.getSkills());
        userRepository.save(s);

        /*userRepository.addDetails(detailsDto.getFirstName(),detailsDto.getLastName()
        ,detailsDto.getEmail(),detailsDto.getMobileNumber(),detailsDto.getSkills());
*/
    }

    @Override
    public GetDetails getDetails() {
        return userRepository.getDetails(); // Here we fetch the data from database using respository
    }

    @Override
    public void updateDetails(DetailsDto detailsDto) { // This function updates the data in the database
        userRepository.updateDetails(detailsDto.getFirstName(),detailsDto.getLastName(),
                detailsDto.getEmail(),detailsDto.getMobileNumber(),detailsDto.getSkills());
    }
}
