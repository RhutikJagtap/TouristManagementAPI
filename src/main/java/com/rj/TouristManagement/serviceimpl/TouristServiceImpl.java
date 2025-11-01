package com.rj.TouristManagement.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.TouristManagement.dao.TouristManagementRepository;
import com.rj.TouristManagement.entity.Tourist;
import com.rj.TouristManagement.exception.TouristNotFoundException;
import com.rj.TouristManagement.service.TouristService;

@Service
public class TouristServiceImpl implements TouristService {

	@Autowired
	private TouristManagementRepository repo;

	@Override
	public String registerTourist(Tourist tourist) {
		Tourist savedTourist = repo.save(tourist);
		return "Tourist info registere with id " + savedTourist.getTouristId();
	}

	@Override
	public Tourist fetchTouristById(Long touristId) {

		Optional<Tourist> optional = repo.findById(touristId);

		if (optional.isPresent()) {
			return optional.get();
		} else {
			TouristNotFoundException touristNotFoundException = new TouristNotFoundException();
			throw touristNotFoundException;
		}

	}

	@Override
	public List<Tourist> fetchAllTourist() {

		return repo.findAll();
	}

	@Override
	public String updateTouristInfo(Tourist tourist) {

		// to update first check this tourist is present in database by using id
		Optional<Tourist> optional = repo.findById(tourist.getTouristId());

		if (optional.isPresent()) {
			// if tourist is present then get the tourist
			Tourist databaseTourist = optional.get();

			// save method perform upsert operation
			// if record is available in database it will update
			// if record is not available it will insert new record
			repo.save(tourist);

			return "Tourist Info is updated successfully ";
		} else {
			TouristNotFoundException touristNotFoundException = new TouristNotFoundException();
			throw touristNotFoundException;
		}

	}

	@Override
	public String updateTouristInfo(Long touristId, Double budget) {

		Optional<Tourist> optional = repo.findById(touristId);

		if (optional.isPresent()) {
			Tourist tourist = optional.get();
			tourist.setBudget(budget);

			repo.save(tourist);

			return "Toursit budget is updated ";
		} else {
			throw new TouristNotFoundException();
		}

	}

	@Override
	public String deleteTouristById(Long touristId) {

		Optional<Tourist> optional = repo.findById(touristId);
		if (optional.isPresent()) {
			repo.deleteById(touristId);

			return "Tourist Deleted successfully";
		} else {
			throw new TouristNotFoundException();
		}

	}

}
