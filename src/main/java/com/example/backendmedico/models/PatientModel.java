package com.example.backendmedico.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "patients")
@Data
@NoArgsConstructor
public class PatientModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
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
