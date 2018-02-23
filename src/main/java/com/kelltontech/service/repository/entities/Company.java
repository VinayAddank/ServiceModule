package com.kelltontech.service.repository.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 * A Company.
 */
@Document(collection = "company")
public class Company implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	@Field("cid")
	private Integer cid;

	@Field("cname")
	private String cname;

	private List<Product> products;

	private Contact contact;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Contact getContact() {
		return contact;
	}

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	// jhipster-needle-entity-add-field - JHipster will add fields here, do not
	// remove
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getCid() {
		return cid;
	}

	public Company cid(Integer cid) {
		this.cid = cid;
		return this;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public Company cname(String cname) {
		this.cname = cname;
		return this;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}
	// jhipster-needle-entity-add-getters-setters - JHipster will add getters and
	// setters here, do not remove

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Company company = (Company) o;
		if (company.getId() == null || getId() == null) {
			return false;
		}
		return Objects.equals(getId(), company.getId());
	}

	public Company(int cid, String cname, List<Product> products, Contact contact) {
		this.cid = cid;
		this.cname = cname;
		this.products = products;
		this.contact = contact;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();

		String jsonString = "";
		try {
			mapper.enable(SerializationFeature.INDENT_OUTPUT);
			jsonString = mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}

		return jsonString;
	}
}
