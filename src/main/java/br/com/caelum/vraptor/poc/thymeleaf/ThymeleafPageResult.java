package br.com.caelum.vraptor.poc.thymeleaf;

import java.io.IOException;
import javax.enterprise.inject.Specializes;
import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.thymeleaf.context.WebContext;

import br.com.caelum.vraptor.core.MethodInfo;
import br.com.caelum.vraptor.http.MutableRequest;
import br.com.caelum.vraptor.http.MutableResponse;
import br.com.caelum.vraptor.view.DefaultPageResult;
import br.com.caelum.vraptor.view.ResultException;

@Specializes
public class ThymeleafPageResult extends DefaultPageResult {

	private static final Logger logger = LoggerFactory.getLogger(ThymeleafPageResult.class);

	@Inject
	private MutableRequest request;

	@Inject
	private MutableResponse response;

	@Inject
	private MethodInfo methodInfo;

	@Inject
	private ThymeleafConfig thymeleafConfig;

	@Override
	public void defaultView() {
		try {
			final WebContext ctx = new WebContext(request, response, request.getServletContext(), request.getLocale());
			final String templateName = thymeleafConfig.getTemplateName(methodInfo);

			logger.debug("forwarding template name {}", templateName);

			thymeleafConfig.getTemplateEngine().process(templateName, ctx, response.getWriter());
		} catch (IOException e) {
			throw new ResultException(e);
		}
	}

}
