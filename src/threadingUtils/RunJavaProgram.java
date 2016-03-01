package threadingUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import fileUtilities.FileVariables;

public class RunJavaProgram {
	
	private FileVariables fv = new FileVariables();
	private int compileExitValue  = -1;
	private int runExitValue = -1;
	private String output;
	private String errorOutput;
	
	public RunJavaProgram(String filePath){
		String programName = filePath.substring(filePath.lastIndexOf(fv.dirDelimiter)+1,filePath.lastIndexOf("."));
		String dirName = filePath.substring(0,filePath.lastIndexOf(fv.dirDelimiter));
		try{
			compileExitValue = runProcess("javac "+filePath);
			if (compileExitValue == 0){
				runExitValue = runProcess("java -cp "+dirName+" "+programName);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/**
	 * @return the compileExitValue
	 */
	public int getCompileExitValue() {
		return compileExitValue;
	}

	/**
	 * @return the runExitValue
	 */
	public int getRunExitValue() {
		return runExitValue;
	}

	/**
	 * @return the output
	 */
	public String getOutput() {
		return output;
	}

	/**
	 * @return the errorOutput
	 */
	public String getErrorOutput() {
		return errorOutput;
	}

	/*
	 * methods below come from 
	 * http://stackoverflow.com/questions/4842684/how-to-compile-run-java-program-in-another-java-program
	 * with slight modification
	 * START
	 */
	private int runProcess(String command) throws Exception {
	    Process pro = Runtime.getRuntime().exec(command);
	    output = outputToString(pro.getInputStream());
	    errorOutput = outputToString(pro.getErrorStream());
	    pro.waitFor();
	    return pro.exitValue();
	}
	
	private String outputToString(InputStream ins) throws Exception {
	    String line = null;
	    String output = "";
	    BufferedReader in = new BufferedReader(new InputStreamReader(ins));
	    while ((line = in.readLine()) != null) {
	        output += line +'\n'; 
	    }
	    return output;
	  }
	/*
	 * END
	 */

}
