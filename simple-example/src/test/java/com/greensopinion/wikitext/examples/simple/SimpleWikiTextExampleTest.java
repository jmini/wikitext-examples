package com.greensopinion.wikitext.examples.simple;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import com.google.common.io.Resources;

public class SimpleWikiTextExampleTest {

	private SimpleWikiTextExample example = new SimpleWikiTextExample();

	@Test
	public void parseTextile() {
		assertEquals(resource("parseTextile.html"), transformToHtml("Textile", "parseTextile.textile"));
	}

	@Test
	public void parseMarkdown() {
		assertEquals(resource("parseMarkdown.html"), transformToHtml("Markdown", "parseMarkdown.md"));
	}

	private String resource(String resourceName) {
		try {
			return Resources.toString(SimpleWikiTextExampleTest.class.getResource(resourceName),
					StandardCharsets.UTF_8);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private String transformToHtml(String languageName, String resourceName) {
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		example.transformToHtml(languageName, resource(resourceName), output);
		return new String(output.toByteArray(), StandardCharsets.UTF_8);
	}
}
