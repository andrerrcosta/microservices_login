package com.hummel.testgwan.common.models;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.EqualsAndHashCode;

@MappedSuperclass
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@EqualsAndHashCode.Include
	private Long id;

}
