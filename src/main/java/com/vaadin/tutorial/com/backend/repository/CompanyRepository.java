package com.vaadin.tutorial.com.backend.repository;

import com.vaadin.tutorial.com.backend.entity.Company;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {
}
