package org.drmacro.testditaot;

import java.io.File;

import org.dita.dost.Processor;
import org.dita.dost.ProcessorFactory;

public class RunOT {

  public static void main(String[] args) {
 // Create a reusable processor factory with DITA-OT base directory and temporary directory
    File ditaDir = new File("/Users/ekimber/workspace-ditaot/dita-ot-wek-dev/src/main"); 
    ProcessorFactory pf = ProcessorFactory.newInstance(ditaDir);
    
    File inputFile = new File("/Users/ekimber/workspace-ditaot/dita-ot-wek-dev/build.gradle");
    File outDir = new File("/Users/ekimber/workspace-ditaot/dita-ot-wek-dev/temp/out");
    File tempDir = new File("/Users/ekimber/workspace-ditaot/dita-ot-wek-dev/temp/ot-temp");
    pf.setBaseTempDir(tempDir);

    
    // Create a processor using the factory and configure the processor
    Processor p = pf.newProcessor("dci18n-test")
    .setInput(inputFile)
    .setOutputDir(outDir);
    

    // Run conversion
    try {
      System.err.println("Calling p.run()...");
      p.run();
    } catch (Exception e) {
      e.printStackTrace();
    }    
    System.err.println("After run.");
  }
}
