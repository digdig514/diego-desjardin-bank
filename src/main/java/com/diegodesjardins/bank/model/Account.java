package com.diegodesjardins.bank.model;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.lang.Nullable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "account", schema = "public")
@Builder
public class Account implements Serializable{
	private static final long serialVersionUID = 7893904627985212604L;
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "accountNumber", unique = true)
	@Nullable
	private String accountNumber;
	
	@ManyToOne
	@JoinColumn( name = "owner_id")
	private Client client;
	
	

}
