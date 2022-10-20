package com.jeffnk.advoconnect;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

import com.jeffnk.advoconnect.controller.CompanyRestController;
import com.jeffnk.advoconnect.model.Company;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

@Component
public class CompanyModelAssembler implements RepresentationModelAssembler<Company, EntityModel<Company>> {

    @Override
    public EntityModel<Company> toModel(Company company) {
        return EntityModel.of(company,
                linkTo(methodOn(CompanyRestController.class).getCompanyDetails(company.getId())).withSelfRel(),
                linkTo(methodOn(CompanyRestController.class).getCompanies()).withRel("companies"));
    }
}
