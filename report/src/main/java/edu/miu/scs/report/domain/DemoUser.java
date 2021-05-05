package edu.miu.scs.report.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DemoUser {
	@Id
	private int id;
	private String name;
	private int age;
	private String city;
	private String email;


}
