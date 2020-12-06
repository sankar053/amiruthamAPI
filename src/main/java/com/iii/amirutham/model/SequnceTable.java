package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity(name = "sequnce")
@Table(name = "AMIR_SEQUNCE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SequnceTable extends BaseEntity{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@ApiModelProperty(notes = "FirstName Should have Atleast two character")
	@Column(name = "AMIR_SEQ_NM")
	private String seqName;
	
	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@ApiModelProperty(notes = "FirstName Should have Atleast two character")
	@Column(name = "AMIR_SEQ_CHAR")
	private String seqChar;

	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	@Column(name = "AMIR_SEQ_CUR_VAL")
	private Integer seqCurVal;

	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	@Column(name = "AMIR_SEQ_NXT_VAL")
	private Integer seqNxtVal;

	@ApiModelProperty(notes = "LastName Should have Atleast two character")
	@Column(name = "AMIR_SEQ_LIM_VAL")
	private Integer seqLimVal;

}
