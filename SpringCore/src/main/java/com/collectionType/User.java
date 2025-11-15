package com.collectionType;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
	private int id;
	private String name;
	private List<String> contactNames;
	private Set<Long> contact;
	private Map<Integer, String> map;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getContactNames() {
		return contactNames;
	}

	public void setContactNames(List<String> contactNames) {
		this.contactNames = contactNames;
	}

	public Set<Long> getContact() {
		return contact;
	}

	public void setContact(Set<Long> contact) {
		this.contact = contact;
	}

	public Map<Integer, String> getMap() {
		return map;
	}

	public void setMap(Map<Integer, String> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", contactNames=" + contactNames + ", contact=" + contact
				+ ", map=" + map + "]";
	}

}
