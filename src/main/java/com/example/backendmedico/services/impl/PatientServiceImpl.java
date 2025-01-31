package com.example.backendmedico.services.impl;

import com.example.backendmedico.dao.PatientDAO;
import com.example.backendmedico.models.PatientModel;
import com.example.backendmedico.services.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {
	private final PatientDAO patientDAO;

	@Override
	public List<PatientModel> getAllPatients() {
		return patientDAO.getAllPatients();
	}

	@Override
	public PatientModel getPatientById(final String patientId) {
		return patientDAO.getPatientById(patientId);
	}

	@Override
	public PatientModel addPatient(final PatientModel patient) {
		return patientDAO.addPatient(patient);
	}

	@Override
	public PatientModel updatePatient(final String patientId, final PatientModel patient) {
		return patientDAO.updatePatient(patientId, patient);
	}

	@Override
	public Integer deletePatient(final String patientId) {
		return patientDAO.deletePatient(patientId);
	}

	@Override
	public PatientModel getPatientByDni(final String dni) {
		return patientDAO.getPatientByDni(dni);
	}

	@Override
	public List<PatientModel> filterPatients(final Map<String, String> valuesToFilter) {
		return patientDAO.filterPatients(valuesToFilter);
	}
}
