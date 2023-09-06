package br.com.treinamento.requisicaojson;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

public class MeuHttpServletRequestWrapper extends HttpServletRequestWrapper {

    private String jsonPayload;

    // Declarando apenas um construtor
    public MeuHttpServletRequestWrapper(HttpServletRequest httpRequest) {
        super(httpRequest);
    }

    public void setJsonPayload(String json) {
        this.jsonPayload = json;
    }

    public String getJsonPayload() {
        return jsonPayload;
    }
}
