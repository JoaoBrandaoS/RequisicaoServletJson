package br.com.treinamento.requisicaojson;

import java.io.BufferedReader;
import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("/jsonrequisicao")
public class Controllerjson implements Filter {
	
	@Override
    public void init(FilterConfig filterConfig) throws ServletException {
		  System.out.println("oi vitu");
    }
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
	        throws IOException, ServletException {

	    if (request instanceof HttpServletRequest) {
	        HttpServletRequest httpRequest = (HttpServletRequest) request;

	        if ("POST".equalsIgnoreCase(httpRequest.getMethod())) {

	            BufferedReader reader = httpRequest.getReader();
	            StringBuilder jsonBuilder = new StringBuilder();
	            String line;
	            while ((line = reader.readLine()) != null) {
	                jsonBuilder.append(line);
	            }
	            String json = jsonBuilder.toString();

	            MeuHttpServletRequestWrapper requestWrapper = new MeuHttpServletRequestWrapper(httpRequest);
	            requestWrapper.setJsonPayload(json);  
	       
	            System.out.println("Possivel json: " + json);
	            request.setAttribute("jsonPayload", json);
	            chain.doFilter((ServletRequest) requestWrapper, response);
	        }
	    }
	}
     
    @Override
    public void destroy() {
    	System.out.println('c');
    }   
	
}
