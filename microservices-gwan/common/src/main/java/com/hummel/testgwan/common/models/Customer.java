package com.hummel.testgwan.common.models;

import javax.persistence.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Customer extends AbstractEntity {
	
	@EqualsAndHashCode.Include
	private String name;
	private String email;
}