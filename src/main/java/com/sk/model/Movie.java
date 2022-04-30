package com.sk.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Movie {

	@PrimaryKey
	private String title;

	@Column("also_viewed_title")
	private String alsoViewedTitle;

	private int count;
}
