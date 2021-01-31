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

/*INSERT INTO `sequence` (`id`,`created_by`,`creation_ts`,`active_yn`,`deleted_yn`,`updated_by`,`update_ts`,`sequencecharacter`,`sequencecurrentvalue`,`sequencelimitvalue`,`sequencename`,`sequencenextvalue`) VALUES (1,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 17:35:35','PROD',1,999999,'PRODUCT',1);
INSERT INTO `sequence` (`id`,`created_by`,`creation_ts`,`active_yn`,`deleted_yn`,`updated_by`,`update_ts`,`sequencecharacter`,`sequencecurrentvalue`,`sequencelimitvalue`,`sequencename`,`sequencenextvalue`) VALUES (2,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 06:03:03','CATE',1,999999,'CATEGERY',1);
INSERT INTO `sequence` (`id`,`created_by`,`creation_ts`,`active_yn`,`deleted_yn`,`updated_by`,`update_ts`,`sequencecharacter`,`sequencecurrentvalue`,`sequencelimitvalue`,`sequencename`,`sequencenextvalue`) VALUES (3,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-31 05:20:29','CART',1,999999,'CART',1);
INSERT INTO `sequence` (`id`,`created_by`,`creation_ts`,`active_yn`,`deleted_yn`,`updated_by`,`update_ts`,`sequencecharacter`,`sequencecurrentvalue`,`sequencelimitvalue`,`sequencename`,`sequencenextvalue`) VALUES (4,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-31 05:20:43','AMIR_OD',1,999999,'ORDER',1);
INSERT INTO `sequence` (`id`,`created_by`,`creation_ts`,`active_yn`,`deleted_yn`,`updated_by`,`update_ts`,`sequencecharacter`,`sequencecurrentvalue`,`sequencelimitvalue`,`sequencename`,`sequencenextvalue`) VALUES (5,NULL,'2020-12-06 16:10:54','Y','N',NULL,'2021-01-17 05:24:54','BANNER',1,999999,'BANNER',1);;

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
