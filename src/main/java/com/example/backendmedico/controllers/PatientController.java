package com.example.backendmedico.controllers;

import com.example.backendmedico.models.PatientModel;
import com.example.backendmedico.services.PatientService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/patients", produces = "application/json")
public class PatientController {
	private final PatientService patientService;

	public PatientController(PatientService patientService) {
		this.patientService = patientService;
	}

	@GetMapping
	public ResponseEntity<Object> getAllPatients(final @RequestParam Map<String, String> keywords) {
		short
			offset =
			keywords.containsKey("offset") ? Short.parseShort(keywords.get("offset")) : 0;
		short limit = keywords.containsKey("limit") ? Short.parseShort(keywords.get("limit")) : 10;

		Pageable page = PageRequest.of(offset, limit);

		List<PatientModel>
			patients =
			(keywords.isEmpty())
				? patientService.getAllPatients(page)
				: patientService.filterPatients(keywords, page);
		return ResponseEntity.ok(patients);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getPatientById(final @PathVariable("id") String patientId) {
		return ResponseEntity.ok(patientService.getPatientById(patientId));
	}

	@PostMapping
	public ResponseEntity<Object> addPatient(final @RequestBody PatientModel patient) {
		PatientModel patientSaved = patientService.addPatient(patient);
		return ResponseEntity.ok(patientSaved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePatient(
		final @PathVariable("id") String patientId,
		final @RequestBody PatientModel patient
	)
	{
		PatientModel patientUpdated = patientService.updatePatient(patientId, patient);
		return ResponseEntity.ok(patientUpdated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePatient(final @PathVariable("id") String patientId) {
		Integer result = patientService.deletePatient(patientId);
		return ResponseEntity.ok(result);
	}
}
