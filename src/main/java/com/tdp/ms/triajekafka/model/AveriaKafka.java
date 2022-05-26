package com.tdp.ms.triajekafka.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Document(collection = "collTriageKafka")
@JsonPropertyOrder({ "idTriageKafka" })
public class AveriaKafka implements Serializable {

	private static final long serialVersionUID = 4894729030347835498L;

	/*
	 * @Id
	 * 
	 * @Field("_id") private String idProvisionKafka;
	 */

	@Id
	@Field("_id")
	private String idTriageKafka;

	@Field("data")
	private String data;

	@Field("date_kafka")
	private String dateKafka;

	@Field("xa_request")
	private String xaRequest;

	@Field("status")
	private String status;

	@Field("masive")
	private String masive;

	@Field("bandeja")
	private String bandeja;

	@Field("motivo")
	private String motivo;

	@Field("id_servicio")
	private String idServicio;

	@Field("seq")
	private long seq;

	@Field("register_date")
	private LocalDateTime registerDate = LocalDateTime.now(ZoneOffset.of("-05:00"));

	public String getIdTriageKafka() {
		return idTriageKafka;
	}

	public String getData() {
		return data;
	}

	public String getDateKafka() {
		return dateKafka;
	}

	public String getXaRequest() {
		return xaRequest;
	}

	public String getStatus() {
		return status;
	}

	public String getMasive() {
		return masive;
	}

	public String getBandeja() {
		return bandeja;
	}

	public String getMotivo() {
		return motivo;
	}

	public String getIdServicio() {
		return idServicio;
	}

	public long getSeq() {
		return seq;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setIdTriageKafka(String idTriageKafka) {
		this.idTriageKafka = idTriageKafka;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setDateKafka(String dateKafka) {
		this.dateKafka = dateKafka;
	}

	public void setXaRequest(String xaRequest) {
		this.xaRequest = xaRequest;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setMasive(String masive) {
		this.masive = masive;
	}

	public void setBandeja(String bandeja) {
		this.bandeja = bandeja;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public void setIdServicio(String idServicio) {
		this.idServicio = idServicio;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

}
