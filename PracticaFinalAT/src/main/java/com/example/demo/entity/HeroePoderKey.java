package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class HeroePoderKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "heroeId")
	private Integer heroeId;
	
	@Column(name = "poderId")
	private Integer poderId;

	
}
