package threadingUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class CompileJavaThread extends Thread{
	
	private String command = "javac ";
	private int compileExitValue  = -1;
	private String output;
	private String errorOutput;
	
	public CompileJavaThread(String dirName, String programName){
		this.command += dirName+programName;
	}
		
	/**
	 * @return the compileExitValue
	 */
	public int getCompileExitValue() {
		return compileExitValue;
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
	@Override
	public void run(){
	    Process pro;
		try {
			pro = Runtime.getRuntime().exec(this.command);
		    output = outputToString(pro.getInputStream());
		    errorOutput = outputToString(pro.getErrorStream());
		    pro.waitFor();
		    this.compileExitValue = pro.exitValue();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			this.compileExitValue = -42;
		}
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
