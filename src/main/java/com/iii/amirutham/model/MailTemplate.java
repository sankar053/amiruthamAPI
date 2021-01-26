/**
 * 
 */
package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "emailtemplate")
@Table(name = "emailtemplate")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MailTemplate {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(unique = true, nullable = false)
	private Integer id;
	
	private String templateName;
	
	private String template;
	
	private String isAttachment;
	
	private String attachment;
}
