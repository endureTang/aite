package com.nj.core.doc2pdf.generator;


import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.poi.xwpf.converter.pdf.PdfConverter;
import org.apache.poi.xwpf.converter.pdf.PdfOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;

/**
 * Created by vserdiuk on 5/30/2016.
 */
public class PdfGeneratorImpl implements PdfGenerator {

    public void generate(String inputFilePath, String outputFilePath) {
        try {
            //pdf generator
            // 1) Load DOCX into XWPFDocument
            InputStream is = new FileInputStream(new File(
                    inputFilePath));
            XWPFDocument document = new XWPFDocument(is);

            // 2) Prepare Pdf options
            PdfOptions options = PdfOptions.create();
            
            //中文字体处理
            options.fontProvider(new IFontProvider() {
                public Font getFont(String familyName, String encoding, float size, int style, Color color) {
                    try {
                    //    BaseFont bfChinese = BaseFont.createFont("STSong-Light", "STSong-Light", BaseFont.NOT_EMBEDDED);
                    	BaseFont bfChinese=BaseFont.createFont("/encodePackage/simsun.ttc,1", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
                        Font fontChinese = new Font(bfChinese, size, style, color);
                        if (familyName != null)
                            fontChinese.setFamily(familyName);
                        return fontChinese;
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }

			
            });
            System.out.println("==="+options.getFontEncoding());
            System.out.println("getFontProvider==="+options.getFontProvider());
            options.fontEncoding("utf-8");

            // 3) Convert XWPFDocument to Pdf
            OutputStream os = new FileOutputStream(new File(
                    outputFilePath));
           // PdfConverter.getInstance().;
            PdfConverter.getInstance().convert(document, os, options);
            System.out.println("The doc file with name " + outputFilePath + " has been generated");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    


}
