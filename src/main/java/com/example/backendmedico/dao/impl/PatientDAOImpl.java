package com.example.backendmedico.dao.impl;

import com.example.backendmedico.dao.PatientDAO;
import com.example.backendmedico.models.PatientModel;
import com.example.backendmedico.repositories.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class PatientDAOImpl implements PatientDAO {
	final private PatientRepository patientRepository;

	@Override
	public List<PatientModel> getAllPatients() {
		return patientRepository.findAll();
	}

	@Override
	public PatientModel getPatientById(final String patientId) {
		return patientRepository.findById(patientId).orElse(null);
	}

	@Override
	public PatientModel addPatient(final PatientModel patient) {
		patient.setPatientId(UUID.randomUUID().toString());
		return patientRepository.save(patient);
	}

	@Override
	public PatientModel updatePatient(final String patientId, final PatientModel patient) {
		PatientModel foundPatient = getPatientById(patientId);

		foundPatient.setFirstName(patient.getFirstName());
		foundPatient.setLastName(patient.getLastName());
		foundPatient.setEmail(patient.getEmail());
		foundPatient.setPhone(patient.getPhone());
		foundPatient.setAddress(patient.getAddress());
		foundPatient.setDni(foundPatient.getDni());
		foundPatient.setBirthDate(patient.getBirthDate());

		return patientRepository.save(foundPatient);
	}

	@Override
	public Integer deletePatient(final String patientId) {
		PatientModel patient = getPatientById(patientId);
		patientRepository.delete(patient);
		return 1;
	}

	@Override
	public PatientModel getPatientByDni(final String dni) {
		return patientRepository.getPatientByDni(dni);
	}

	@Override
	public List<PatientModel> filterPatients(final Map<String, String> valuesToFilter) {

		List<PatientModel>
			filteredPatients =
			patientRepository.findPatientsByFirstNameOrLastNameOrEmailOrDni(
				valuesToFilter.containsKey("first_name")
					? valuesToFilter.get("first_name").trim()
					: null,
				valuesToFilter.containsKey("last_name")
					? valuesToFilter.get("last_name").trim()
					: null,
				valuesToFilter.containsKey("email") ? valuesToFilter.get("email").trim() : null,
				valuesToFilter.containsKey("dni") ? valuesToFilter.get("dni").trim() : null
			);

		return filteredPatients;
	}
}
