package br.com.caelum.vraptor.poc.thymeleaf;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

import br.com.caelum.vraptor.core.MethodInfo;

@ApplicationScoped
public class ThymeleafConfig {

	@Inject
	private ThymeleafPathResolver resolver;

	private ServletContextTemplateResolver templateResolver;

	private TemplateEngine templateEngine;

	@PostConstruct
	private void init() {
		templateResolver = new ServletContextTemplateResolver();
		templateResolver.setTemplateMode(resolver.getTemplateMode());
		templateResolver.setPrefix(resolver.getPrefix());
		templateResolver.setSuffix("." + resolver.getExtension());
		templateResolver.setCharacterEncoding(resolver.getCharacterEncoding());
		templateResolver.setCacheTTLMs(resolver.getCache());

		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		templateEngine.initialize();
	}

	public TemplateEngine getTemplateEngine() {
		return templateEngine;
	}

	public String getTemplateName(final MethodInfo methodInfo) {
		final String to = resolver.pathFor(methodInfo.getControllerMethod());
		return to.replace(templateResolver.getPrefix(), "").replace(templateResolver.getSuffix(), "");
	}

}
