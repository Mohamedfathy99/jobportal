package com.fathy.jobportal.contact.service;


import com.fathy.jobportal.dto.ContactRequestDto;

public interface IcontactService {

        boolean saveContact( ContactRequestDto contactRequestDto);
}
