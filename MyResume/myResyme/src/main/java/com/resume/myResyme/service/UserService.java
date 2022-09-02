package com.resume.myResyme.service;

import com.resume.myResyme.dto.DetailsDto;
import com.resume.myResyme.dto.GetDetails;

public interface UserService {
    public void addDetails(DetailsDto detailsDto);

    public GetDetails getDetails();

    public void updateDetails(DetailsDto detailsDto);
}
