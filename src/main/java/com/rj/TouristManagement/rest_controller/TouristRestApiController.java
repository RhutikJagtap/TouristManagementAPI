package com.rj.TouristManagement.rest_controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rj.TouristManagement.entity.Tourist;
import com.rj.TouristManagement.exception.TouristNotFoundException;
import com.rj.TouristManagement.service.TouristService;

@RestController
public class TouristRestApiController {

	@Autowired
	private TouristService touristService;

	/**
	 * method=POST
	 *  url=localhost:8080/TouristManagementAPI/register
	 * 
	 * @author Rhutik Jagtap
	 * @param Tourist
	 * @return {@link ResponseEntity}
	 */
	@PostMapping("/register")
	public ResponseEntity<String> registerTourist(@RequestBody Tourist tourist) {
		String status = touristService.registerTourist(tourist);
		return new ResponseEntity<String>(status, HttpStatus.CREATED);
	}

	/**
	 * method=GET 
	 * url=localhost:8080/TouristManagementAPI/getTourist/2
	 * 
	 * @author Rhutik Jagtap
	 * @param touristId
	 * @return {@link ResponseEntity}
	 * @throws TouristNotFoundException
	 */
	
	/*
	 * @GetMapping("/getTourist/{touristId}") public ResponseEntity<?>
	 * getTourist(@PathVariable Long touristId) { Tourist tourist; try { tourist =
	 * touristService.fetchTouristById(touristId); return new
	 * ResponseEntity<Tourist>(tourist, HttpStatus.OK); } catch
	 * (TouristNotFoundException e) { return new
	 * ResponseEntity<String>(e.toString(), HttpStatus.BAD_REQUEST); } }
	 */
	
	//Don't handle the exception here
	//seperate the logic i.e AOP
	
	@GetMapping("/getTourist/{touristId}")
	public ResponseEntity<Tourist> getTourist(@PathVariable Long touristId) {
		
		Tourist tourist = touristService.fetchTouristById(touristId);
		return new ResponseEntity<Tourist>(tourist, HttpStatus.OK);
		
	}
	
	
	
	/**
	 * method=GET
	 *  url=localhost:8080/TouristManagementAPI/getAllTourists
	 * 
	 * @author Rhutik Jagtap
	 * @return ResponseEntity<List<Tourist>>
	 * 
	 */
	@GetMapping("/getAllTourists")
	public ResponseEntity<List<Tourist>> getAll() {

		List<Tourist> tourists = touristService.fetchAllTourist();

		return new ResponseEntity<List<Tourist>>(tourists, HttpStatus.OK);
	}

	/**
	 * method=PUT
	 *  url=localhost:8080/TouristManagementAPI/updateTourist
	 * 
	 * @author Rhutik Jagtap
	 * @param Tourist
	 * @return ResponseEntity<String>
	 * @PutMapping is used to update the most fields
	 */

	@PutMapping("/updateTourist")
	public ResponseEntity<String> updateTouristInfo(@RequestBody Tourist tourist) {
			String status = touristService.updateTouristInfo(tourist);
			return new ResponseEntity<String>(status, HttpStatus.OK);
	}

	/**
	 * method=PATCH
	 * url=localhost:8080/TouristManagementAPI/updateTouristBudget/1/33333
	 * 
	 * @author Rhutik Jagtap
	 * @param touristId
	 * @param budget
	 * @return ResponseEntity<String>
	 * throws {@link TouristNotFoundException}
	 * @PatchMapping is used to update the minimal fields
	 */

	@PatchMapping("/updateTouristBudget/{touristId}/{budget}")
	public ResponseEntity<String> updateTouristBudgetById(@PathVariable Long touristId, @PathVariable Double budget) {
			String status = touristService.updateTouristInfo(touristId, budget);
			return new ResponseEntity<String>(status, HttpStatus.OK);

	}

	/**
	 * method=DELETE
	 *  url=localhost:8080/TouristManagementAPI/deleteTourist/1
	 * 
	 * @author Rhutik Jagtap
	 * @param touristId
	 * @return ResponseEntity<String>
	 * @throws TouristNotFoundException
	 */

	@DeleteMapping("/deleteTourist/{touristId}")
	public ResponseEntity<String> updateTouristBudgetById(@PathVariable Long touristId) {

			String status = touristService.deleteTouristById(touristId);
			return new ResponseEntity<String>(status, HttpStatus.OK);

	}
	
	

}
