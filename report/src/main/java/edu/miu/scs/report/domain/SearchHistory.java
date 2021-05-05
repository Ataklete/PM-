package edu.miu.scs.report.domain;

import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@ToString
@Setter
@Getter
@AllArgsConstructor
@Entity
public class SearchHistory {
    @Id
	private int id;
    private String userName;
    private String searchWord;
    private String customerIP;

}
