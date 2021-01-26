/**
 * 
 */
package com.iii.amirutham.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iii.amirutham.model.MailTemplate;

/**
 * @author sanka
 *
 */
public interface MailTemplateRepository extends JpaRepository<MailTemplate, Integer> {
	
	public MailTemplate findByTemplateName(String templateName);

}
