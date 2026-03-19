package com.sree.snexacorpaibackend.ingestion.pdf;

import com.sree.snexacorpaibackend.controller.HealthController;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

@Service
public class PdfIngestionService {
    private static final Logger log = LoggerFactory.getLogger(PdfIngestionService.class);
    private static final String PDF_DIRECTORY = "data/pdfs";

    public void ingestPdfs() throws Exception {
        File[] pdfFiles = new File(PDF_DIRECTORY).listFiles();
        for (File pdfFile : pdfFiles) {
            ingestSinglePdf(pdfFile);
        }
    }

    private void ingestSinglePdf(File pdfFile) throws IOException {
        log.info("Ingesting single pdf: {}", pdfFile.getName());
        try (PDDocument document = PDDocument.load(pdfFile)) {
            PDFTextStripper stripper = new PDFTextStripper();
            String text = stripper.getText(document);
            log.info("......PDF name for extracted text: {} ....", pdfFile.getName());
            log.info("......PDF text extracted text: {}", text);
        }
    }
}
