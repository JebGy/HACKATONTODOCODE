package com.example.backendmedico.utils;

import com.example.backendmedico.models.PatientModel;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PatientSpecification {
	public static Specification<PatientModel> filterPatients(Map<String, String> valuesToFilter) {
		return (root, query, criteriaBuilder) -> {
			List<Predicate> predicates = new ArrayList<>();

			valuesToFilter.forEach((key, value) -> {
				if (value != null && !value.trim().isEmpty()) {
					switch (key) {
						case "first_name":
							predicates.add(criteriaBuilder.like(
								root.get("firstName"),
								"%" + value + "%"
							));
							break;
						case "last_name":
							predicates.add(criteriaBuilder.like(
								root.get("lastName"),
								"%" + value + "%"
							));
							break;
						case "email":
							predicates.add(criteriaBuilder.equal(root.get("email"), value));
							break;
						case "dni":
							predicates.add(criteriaBuilder.equal(root.get("dni"), value));
							break;
					}
				}
			});

			return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
		};
	}
}
