package com.rj.TouristManagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rj.TouristManagement.entity.Tourist;

public interface TouristManagementRepository extends JpaRepository<Tourist, Long>{

}
