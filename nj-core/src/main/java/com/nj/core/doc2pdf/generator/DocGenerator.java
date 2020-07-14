package com.nj.core.doc2pdf.generator;



/**
 * Created by vserdiuk on 5/30/2016.
 */
public interface DocGenerator {

    void generate(String templateFilePate, String outputFilePath, Object obj);

}
