package com.fathy.jobportal.contact.service.impl;

import com.fathy.jobportal.contact.service.IcontactService;
import com.fathy.jobportal.dto.ContactRequestDto;
import com.fathy.jobportal.entity.Contact;
import com.fathy.jobportal.repository.ContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ContactServiceImpl implements IcontactService {


    private final ContactRepository contactRepository;

    @Override
    public boolean saveContact(ContactRequestDto contactRequestDto) {
        boolean result = false;
        Contact contact = contactRepository.save(transformContactRequestDtoToContact(contactRequestDto));
        if (contact != null&&contact.getId()!=null) {
            result = true;
        }
        return result;
    }


    private Contact transformContactRequestDtoToContact(ContactRequestDto contactRequestDto) {
        Contact contact = new Contact();
        // This will set all the properties from contactRequestDto to contact using reflection
        BeanUtils.copyProperties(contactRequestDto, contact);
//        contact.setCreatedAt(Instant.now());
//        contact.setCreatedBy("System"); // You can replace "System" with the actual user if you have authentication
        contact.setStatus("NEW");
        return contact;
    }
}
