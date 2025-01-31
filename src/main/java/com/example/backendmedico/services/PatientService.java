package com.example.backendmedico.services;

import com.example.backendmedico.models.PatientModel;

import java.util.List;
import java.util.Map;

public interface PatientService {
	List<PatientModel> getAllPatients();

	PatientModel getPatientById(final String patientId);

	PatientModel addPatient(final PatientModel patient);

	PatientModel updatePatient(final String patientId,final PatientModel patient);

	Integer deletePatient(final String patientId);

	PatientModel getPatientByDni(final String dni);

	List<PatientModel> filterPatients(final Map<String, String> valuesToFilter);
}
