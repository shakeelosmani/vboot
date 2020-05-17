package com.vboot.backend.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.vboot.Interface.Phone;

import lombok.Data;

@Entity(name = "Developer")
@Table(name = "developer")
@Data
public class Developer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "developer_id")
	private UUID developerID;

	@Column(name = "first_name")
	@NotNull(message = "First name is required.")
	private String firstName;

	@Column(name = "last_name")
	@NotNull(message = "Last name is required.")
	private String lastName;

	@Column(name = "email", unique = true)
	@Email(message = "Must provide a valid email address")
	@Pattern(regexp = "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\." + "[A-Za-z0-9!#$%&'*+/=?^_`{|}~-]+)*@"
			+ "(?:[A-Za-z0-9](?:[A-Za-z0-9-]*[A-Za-z0-9])?\\.)+[A-Za-z0-9]"
			+ "(?:[A-Za-z0-9-]*[A-Za-z0-9])?", message = "{invalid.email}")
	private String email;

	@Column(name = "phone_number")
	@Phone(message = "Must be a valid phone number")
	private String phoneNumber;

	@Column(name = "position")
	@Size(min = 2, max = 64, message = "The position shoule be at least 2 charcters long and at max 64 characters long.")
	private String position;

	@Column(name = "user_name", unique = true)
	@NotNull(message = "Username is required")
	@Size(min = 4, max = 64, message = "The username shoule be at least 4 charcters long and at max 64 characters long.")
	private String userName;

	@Column(name = "team_name")
	@Size(min = 4, max = 64, message = "The username shoule be at least 4 charcters long and at max 64 characters long.")
	private String teamName;
}