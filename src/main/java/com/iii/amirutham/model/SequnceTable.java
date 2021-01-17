package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*INSERT INTO `sequnce` (`id`,`creation_ts`,`update_ts`,`active_yn`,`deleted_yn`,`sequenceCharacter`,`sequenceCurrentValue`,`sequenceLimitValue`,`sequenceName`,`sequenceNextValue`,`created_by`,`updated_by`) VALUES (1,'2020-12-06 16:10:54','2020-12-06 17:31:41','Y','N','PROD',15,999999,'PRODUCT',16,NULL,NULL);
INSERT INTO `sequnce` (`id`,`creation_ts`,`update_ts`,`active_yn`,`deleted_yn`,`sequenceCharacter`,`sequenceCurrentValue`,`sequenceLimitValue`,`sequenceName`,`sequenceNextValue`,`created_by`,`updated_by`) VALUES (2,'2020-12-06 16:10:54','2020-12-06 16:57:50','Y','N','CATE',6,999999,'CATEGERY',7,NULL,NULL);
INSERT INTO `amirutham`.`sequnce` (`id`, `creation_ts`, `update_ts`, `active_yn`, `deleted_yn`, `sequencecharacter`, `sequencecurrentvalue`, `sequencelimitvalue`, `sequencename`, `sequencenextvalue`) VALUES ('3', '2020-12-06 16:10:54', '2020-12-06 16:10:54', 'Y', 'N', 'CART', '1', '999999', 'CART', '1');

*/
@Entity(name = "sequence")
@Table(name = "sequence")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SequnceTable extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@Column(name = "sequencename")
	private String seqName;

	@Size(min = 2, message = "FirstName Should have Atleast two character")
	@Column(name = "sequencecharacter")
	private String seqChar;
	
	@Column(name = "sequencecurrentvalue")
	private Integer seqCurVal;

	@Column(name = "sequencenextvalue")
	private Integer seqNxtVal;

	@Column(name = "sequencelimitvalue")
	private Integer seqLimVal;

}
