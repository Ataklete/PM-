package edu.miu.scs.report.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Data
@Table(name = "demo_user")
public class DemoUser {
	@Id
	private int id;
	private String name;
	private int age;
	private String city;
	private String email;


}
