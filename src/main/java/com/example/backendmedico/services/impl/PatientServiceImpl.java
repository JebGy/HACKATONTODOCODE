package com.example.backendmedico.services.impl;

import com.example.backendmedico.dao.PatientDAO;
import com.example.backendmedico.models.PatientModel;
import com.example.backendmedico.services.PatientService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class PatientServiceImpl implements PatientService {
	private final PatientDAO patientDAO;

	public PatientServiceImpl(PatientDAO patientDAO) {
		this.patientDAO = patientDAO;
	}

	@Override
	public List<PatientModel> getAllPatients(Pageable page) {
		return patientDAO.getAllPatients(page);
	}

	@Override
	public PatientModel getPatientById(String patientId) {
		return patientDAO.getPatientById(patientId);
	}

	@Override
	public PatientModel addPatient(PatientModel patient) {
		if (patient.getPatientId() == null || patient.getPatientId().isBlank()) {
			patient.setPatientId(UUID.randomUUID().toString());
		}
		return patientDAO.addPatient(patient);
	}

	@Override
	public PatientModel updatePatient(String patientId, PatientModel patient) {
		PatientModel foundPatient = getPatientById(patient.getPatientId());

		foundPatient.setFirstName(patient.getFirstName());
		foundPatient.setLastName(patient.getLastName());
		foundPatient.setEmail(patient.getEmail());
		foundPatient.setPhone(patient.getPhone());
		foundPatient.setAddress(patient.getAddress());
		foundPatient.setDni(foundPatient.getDni());
		foundPatient.setBirthDate(patient.getBirthDate());

		return patientDAO.updatePatient(foundPatient);
	}

	@Override
	public Integer deletePatient(String patientId) {
		return patientDAO.deletePatient(patientId);
	}

	@Override
	public PatientModel getPatientByDni(String dni) {
		return patientDAO.getPatientByDni(dni);
	}

	@Override
	public List<PatientModel> filterPatients(Map<String, String> valuesToFilter, Pageable page) {
		return patientDAO.filterPatients(valuesToFilter, page);
	}
}
