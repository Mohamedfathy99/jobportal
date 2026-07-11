package com.fathy.jobportal.service;

import com.fathy.jobportal.dto.CompanyDto;
import com.fathy.jobportal.entity.Company;

import java.util.List;

public interface ICompanyService {

    List<CompanyDto> getAllCompanies();
}
