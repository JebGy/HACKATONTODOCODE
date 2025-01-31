package com.example.backendmedico.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "consultations")
@Data
@NoArgsConstructor
public class ConsultationModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "consultation_id", length = 36)
	private String consultationId;

	@Temporal(TemporalType.DATE)
	@Column(name = "consultation_date", nullable = false)
	private LocalDate consultationDate;

	@Temporal(TemporalType.TIME)
	@Column(name = "consultation_time", nullable = false)
	private Date consultationTime;

	@Column(name = "total_amount", nullable = false)
	private Double totalAmount;

	@Column(name = "is_paid", nullable = false)
	private Boolean isPaid;

	//private PatientModel patient;

	//private DoctorModel doctor;

	//private ServiceModel service;

	//private PackageModel servicePackage;
}
