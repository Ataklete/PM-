package edu.miu.scs.report.domain;

import java.time.LocalDateTime;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@ToString
@Setter
@Getter
@AllArgsConstructor
@Entity
@Data
@Table(name = "searchhistory")
public class SearchHistory {
    @Id
	private int id;
    private String userName;
    private String searchWord;
    private String customerIP;

}
