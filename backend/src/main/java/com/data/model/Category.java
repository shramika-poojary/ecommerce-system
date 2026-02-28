package com.data.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@Table(name="categories")
public class Category {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int categoryId;
	
	@NonNull
	@NotBlank(message="This field is required")
	private String categoryName;
	
	@NonNull
	@NotBlank(message="This field is required")
	private String description;
	
	@NonNull
	@CreatedDate
	private LocalDateTime createdAt;
	
	
	@CreatedDate
	private LocalDateTime updatedAt;
	

	private Boolean status;
}
