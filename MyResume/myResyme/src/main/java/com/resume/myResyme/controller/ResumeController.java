package com.resume.myResyme.controller;

import com.resume.myResyme.dto.DetailsDto;
import com.resume.myResyme.dto.GetDetails;
import com.resume.myResyme.dto.SuccessMessage;
import com.resume.myResyme.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ResumeController {

    @Autowired
    UserServiceImpl userService;

    @CrossOrigin
    @PostMapping("/resume/addDetails")
    @ResponseBody
    public void addDetail(@RequestBody DetailsDto detailsDto){   // This function captures the data coming from frontend

        userService.addDetails(detailsDto);

    }

    @CrossOrigin
    @GetMapping("/resume/getDetails") // This function return the data on request from frontend
    @ResponseBody
    public GetDetails getDetails(){
       return userService.getDetails();
    }

    @CrossOrigin
    @PostMapping("/resume/updateDetails")
    @ResponseBody
    public SuccessMessage updateDetails(@RequestBody DetailsDto detailsDto){ // This function updates the data send by front end
          userService.updateDetails(detailsDto);

          return new SuccessMessage("Details Updated");
    }

}
