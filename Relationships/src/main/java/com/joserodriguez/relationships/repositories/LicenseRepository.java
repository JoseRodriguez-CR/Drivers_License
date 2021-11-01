package com.joserodriguez.relationships.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.joserodriguez.relationships.models.License;

@Repository
public interface LicenseRepository extends CrudRepository <License, Long>{
	
	List<License> findTopByOrderByNumberDesc();
}