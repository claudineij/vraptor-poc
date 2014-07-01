package br.com.caelum.vraptor.poc.thymeleaf;

import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import br.com.caelum.vraptor.http.FormatResolver;
import br.com.caelum.vraptor.view.DefaultPathResolver;

@Specializes
public class ThymeleafPathResolver extends DefaultPathResolver {

	/**
	 * @deprecated CDI eyes only
	 */
	protected ThymeleafPathResolver() {
		this(null);
	}

	@Inject
	public ThymeleafPathResolver(FormatResolver resolver) {
		super(resolver);
	}

	@Override
	protected String getPrefix() {
		return "/WEB-INF/template/";
	}

	@Override
	protected String getExtension() {
		return "html";
	}

	protected String getTemplateMode() {
		return "HTML5";
	}

	protected Long getCache() {
		return 3600000L;
	}

	protected String getCharacterEncoding() {
		return "UTF-8";
	}

}
