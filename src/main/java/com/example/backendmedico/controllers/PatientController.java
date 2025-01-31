package com.example.backendmedico.controllers;

import com.example.backendmedico.models.PatientModel;
import com.example.backendmedico.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/patients", produces = "application/json")
@RequiredArgsConstructor
public class PatientController {

	private final PatientService PATIENT_SERVICE;

	@GetMapping
	public ResponseEntity<Object> getAllPatients(final @RequestParam Map<String, String> keywords) {
		List<PatientModel>
			patients =
			keywords.isEmpty() ? PATIENT_SERVICE.getAllPatients() : PATIENT_SERVICE.filterPatients(
				keywords);
		return ResponseEntity.ok(patients);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Object> getPatientById(final @PathVariable("id") String patientId) {
		return ResponseEntity.ok(PATIENT_SERVICE.getPatientById(patientId));
	}

	@PostMapping
	public ResponseEntity<Object> addPatient(final @RequestBody PatientModel patient) {
		PatientModel patientSaved = PATIENT_SERVICE.addPatient(patient);
		return ResponseEntity.ok(patientSaved);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Object> updatePatient(
		final @PathVariable("id") String patientId,
		final @RequestBody PatientModel patient
	)
	{
		PatientModel patientUpdated = PATIENT_SERVICE.updatePatient(patientId, patient);
		return ResponseEntity.ok(patientUpdated);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deletePatient(final @PathVariable("id") String patientId) {
		Integer result = PATIENT_SERVICE.deletePatient(patientId);
		return ResponseEntity.ok(result);
	}
}
