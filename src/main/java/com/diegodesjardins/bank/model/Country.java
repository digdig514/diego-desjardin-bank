package com.diegodesjardins.bank.model;

import java.io.Serializable;

import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@Table(name = "country", schema = "public")
@Builder
public class Country  implements Serializable{
	
	

	private static final long serialVersionUID = -4550792368107759729L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "country")
	@Nullable
	private String name;
	
	@Column(name = "coins")
	@Nullable
	private String coin;

}
