package com.example.vet.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "reserve")
public class Reserve {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	@Column(name = "date")
	private String date;
	@Column(name = "hora")
	private String hour;
	@JoinColumn(name = "client_id")
	@ManyToOne
	private Client client;
	@JoinColumn(name = "id_attention_type")
	@ManyToOne
	private AttentionType attentionType;
	

	public Reserve(Long id, String date, String hour, Client client, AttentionType attentionType) {
		this.id = id;
		this.date = date;
		this.hour = hour;
		this.client = client;
		this.attentionType = attentionType;
	}

	public AttentionType getAttentionType() {
		return attentionType;
	}

	public void setAttentionType(AttentionType attentionType) {
		this.attentionType = attentionType;
	}

	public Reserve() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHour() {
		return hour;
	}

	public void setHour(String hour) {
		this.hour = hour;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
