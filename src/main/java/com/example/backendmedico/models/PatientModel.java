package com.example.backendmedico.models;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "patients")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatientModel {
	@Id
	@Column(name = "patient_id", nullable = false, length = 36)
	private String patientId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 60)
	private String lastName;

	@Column(name = "email", unique = true, nullable = false, length = 50)
	private String email;

	@Column(name = "dni", unique = true, nullable = false, length = 8)
	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date")
	private LocalDate birthDate;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "address", nullable = false)
	private String address;
}
