/*
 * Copyright 2014-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.restdocs.config;

import org.springframework.mock.web.MockHttpServletRequest;

/**
 * A configurer that can be used to configure the generated documentation snippets.
 * 
 * @author Andy Wilkinson
 *
 */
public class SnippetConfigurer extends
		AbstractNestedConfigurer<RestDocumentationConfigurer> {

	/**
	 * The default encoding for documentation snippets
	 * @see #withEncoding(String)
	 */
	public static final String DEFAULT_SNIPPET_ENCODING = "UTF-8";

	private String snippetEncoding = DEFAULT_SNIPPET_ENCODING;

	SnippetConfigurer(RestDocumentationConfigurer parent) {
		super(parent);
	}

	/**
	 * Configures any documentation snippets to be written using the given
	 * {@code encoding}. The default is UTF-8.
	 * @param encoding The encoding
	 * @return {@code this}
	 */
	public SnippetConfigurer withEncoding(String encoding) {
		this.snippetEncoding = encoding;
		return this;
	}

	@Override
	void apply(MockHttpServletRequest request) {
		RestDocumentationContext context = RestDocumentationContext.currentContext();
		if (context != null) {
			context.setSnippetEncoding(this.snippetEncoding);
		}
	}

}
