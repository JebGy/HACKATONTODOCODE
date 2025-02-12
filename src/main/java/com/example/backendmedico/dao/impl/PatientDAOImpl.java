package com.example.backendmedico.dao.impl;

import com.example.backendmedico.dao.PatientDAO;
import com.example.backendmedico.models.PatientModel;
import com.example.backendmedico.repositories.PatientRepository;
import com.example.backendmedico.utils.PatientSpecification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PatientDAOImpl implements PatientDAO {
	final private PatientRepository patientRepository;

	public PatientDAOImpl(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	@Override
	public List<PatientModel> getAllPatients(Pageable page) {
		return patientRepository.findAll(page).getContent();
	}

	@Override
	public PatientModel getPatientById(String patientId) {
		return patientRepository.findById(patientId).orElse(null);
	}

	@Override
	public PatientModel addPatient(PatientModel patient) {
		return patientRepository.save(patient);
	}

	@Override
	public PatientModel updatePatient(PatientModel patient) {
		return patientRepository.save(patient);
	}

	@Override
	public Integer deletePatient(String patientId) {
		PatientModel patient = getPatientById(patientId);
		patientRepository.delete(patient);
		return 1;
	}

	@Override
	public PatientModel getPatientByDni(String dni) {
		return patientRepository.getPatientByDni(dni);
	}

	@Override
	public List<PatientModel> filterPatients(Map<String, String> valuesToFilter, Pageable page) {
		Specification<PatientModel> spec = PatientSpecification.filterPatients(valuesToFilter);
		return patientRepository.findAll(spec, page).getContent();

		//			patientRepository.findPatientsByFirstNameOrLastNameOrEmailOrDni(
		//				valuesToFilter.containsKey("first_name")
		//					? valuesToFilter.get("first_name").trim()
		//					: null,
		//				valuesToFilter.containsKey("last_name")
		//					? valuesToFilter.get("last_name").trim()
		//					: null,
		//				valuesToFilter.containsKey("email") ? valuesToFilter.get("email").trim() : null,
		//				valuesToFilter.containsKey("dni") ? valuesToFilter.get("dni").trim() : null,
		//				(short) page.getOffset(),
		//				(short) page.getPageSize()
		//			);
		//		return filteredPatients;
	}
}
