package com.iii.amirutham.dto.base;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class EmailTemplate {

	private String templateId;

	private String template;

	private Map<String, String> replacementParams;

	public EmailTemplate(String templateId) {
		this.templateId = templateId;
		try {
			this.template = loadTemplate(templateId);
		} catch (Exception e) {
			this.template = "Empty";
			log.error("Error in template file. {}", e.getMessage());
		}
	}

	private String loadTemplate(String templateId) throws Exception {
		ClassLoader classLoader = getClass().getClassLoader();
		// File file = new File(classLoader.getResource(templateId).getFile());
		File file = new File("C:\\Users\\sanka\\git\\amiruthamAPI\\" + templateId);
		String content = "Empty";
		try {
			content = new String(Files.readAllBytes(file.toPath()));
		} catch (IOException e) {
			log.error("Could not read template with ID =. {}", e.getMessage());
			throw new Exception("Could not read template with ID = " + templateId);

		}
		return content;
	}

	public String getTemplate(Map<String, String> replacements) {
		String cTemplate = this.template;

		// Replace the String
		for (Map.Entry<String, String> entry : replacements.entrySet()) {
			cTemplate = cTemplate.replace("{{" + entry.getKey() + "}}", entry.getValue());
		}
		return cTemplate;
	}
}