/**
 * 
 */
package com.iii.amirutham.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 * @author sanka
 *
 */
@Service
public class ReportService {

	private final TemplateEngine templateEngine;

	public ReportService(TemplateEngine templateEngine) {
		this.templateEngine = templateEngine;

	}

	public File getpdfTemplate(String templateName, Object data, String fileName) throws IOException {

		Context context = new Context();
		context.setVariable("data", data);
		context.setVariable("to", "Baeldung");
		String html = this.templateEngine.process(templateName, context);
		return generatePdfFromHtml(html, fileName);
	}

	public File generatePdfFromHtml(String html, String fileName) throws IOException {

		File output = new File(fileName);
		ITextRenderer iTextRenderer = new ITextRenderer();
		// FontResolver resolver = iTextRenderer.getFontResolver();
		// iTextRenderer.getFontResolver().addFont("MyFont.ttf", true);
		iTextRenderer.setDocumentFromString(html);
		iTextRenderer.layout();
		OutputStream os = new FileOutputStream(output);
		iTextRenderer.createPDF(os);
		os.close();

		return output;

	}

}
