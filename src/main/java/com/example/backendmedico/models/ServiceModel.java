package com.example.backendmedico.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "services")
@Data
@NoArgsConstructor
public class ServiceModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "service_id", nullable = false, length = 36)
	private String serviceId;

	@Column(name = "name", nullable = false, length = 60)
	private String name;

	@Column(name = "description", nullable = false, length = 100)
	private String description;

	@Column(name = "price", nullable = false)
	private Double price;
}
