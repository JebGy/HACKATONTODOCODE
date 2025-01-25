package com.example.backendmedico.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "doctors")
@Data
@NoArgsConstructor
public class DoctorModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "doctor_id", nullable = false, length = 36)
	private String doctorId;

	@Column(name = "first_name", nullable = false, length = 50)
	private String firstName;

	@Column(name = "last_name", nullable = false, length = 60)
	private String lastName;

	@Column(name = "email", nullable = false, length = 50)
	private String email;

	@Column(name = "dni", nullable = false, length = 8)
	private String dni;

	@Temporal(TemporalType.DATE)
	@Column(name = "birth_date", nullable = false)
	private LocalDate birthDate;

	@Column(name = "phone", length = 20)
	private String phone;

	@Column(name = "address", nullable = false, length = 100)
	private String address;

	@Column(name = "specialty", nullable = false, length = 60)
	private String specialty;

	@Column(name = "turn", nullable = false, length = 20)
	private String turn;

	@Column(name = "salary", nullable = false)
	private Double salary;
}
