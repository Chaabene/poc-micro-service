package com.elis.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor 
@NoArgsConstructor
@Entity(name = "User")
@Table(name = "user",schema = "public")
public class User {
	
	@Id
	@SequenceGenerator(
		name="seq_user_id",
		sequenceName = "seq_user_id",
		allocationSize = 1
	)
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE,
			generator = "seq_user_id"
	)
	@Column(
			name="id"
	)
	private Long id;
	@Column(
			name="username"
	)
	private String username;
	@Column(
			name="address"
	)
	private String address;
	

}
