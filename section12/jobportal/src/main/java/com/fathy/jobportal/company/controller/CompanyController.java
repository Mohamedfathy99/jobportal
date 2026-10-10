package com.fathy.jobportal.company.controller;

import com.fathy.jobportal.dto.CompanyDto;
import com.fathy.jobportal.company.service.ICompanyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/companies")
//@CrossOrigin(origins = {"http://localhost:5173/"})
public class CompanyController {

    private final ICompanyService companyService;

//    @Autowired //Optional in case of single constructor
//    public CompanyController(ICompanyService companyService) {
//        this.companyService = companyService;
//    }

    @GetMapping(path = "/public", version = "1.0")
    public ResponseEntity<List<CompanyDto>> getAllCompanies() {
        List<CompanyDto> companyList = companyService.getAllCompanies();
        return ResponseEntity.ok().body(companyList);
    }



}
