package com.greensopinion.wikitext.examples.simple;

import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.eclipse.mylyn.wikitext.parser.DocumentBuilder;
import org.eclipse.mylyn.wikitext.parser.MarkupParser;
import org.eclipse.mylyn.wikitext.parser.builder.HtmlDocumentBuilder;
import org.eclipse.mylyn.wikitext.parser.markup.MarkupLanguage;
import org.eclipse.mylyn.wikitext.util.ServiceLocator;

public class SimpleWikiTextExample {

	public void transformToHtml(String markupLanguageName, String input, OutputStream output) {
		MarkupLanguage markupLanguage = ServiceLocator.getInstance().getMarkupLanguage(markupLanguageName);
		transformToHtml(markupLanguage, input, output);
	}

	private void transformToHtml(MarkupLanguage markupLanguage, String input, OutputStream output) {
		MarkupParser parser = new MarkupParser(markupLanguage);
		DocumentBuilder builder = createDocumentBuilder(output);
		parser.setBuilder(builder);
		parser.parse(input);
	}

	private DocumentBuilder createDocumentBuilder(OutputStream output) {
		return new HtmlDocumentBuilder(new OutputStreamWriter(output, StandardCharsets.UTF_8), true);
	}
}
