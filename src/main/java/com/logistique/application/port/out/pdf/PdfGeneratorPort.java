package com.logistique.application.port.out.pdf;

public interface PdfGeneratorPort {
    byte[] generate(String templateName, Object data);
}
