package com.example.backendmedico.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "packages")
@Data
@NoArgsConstructor
public class PackageModel {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	@Column(name = "package_id", length = 36)
	private String packageId;

	@Column(name = "price")
	private Double price;

	// private ServiceModel service;
}
