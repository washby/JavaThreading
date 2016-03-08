import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Timer;

import fileUtilities.DownloadSetup;
import fileUtilities.FileFormatter;
import threadingUtils.CompileAndRunJavaProgram;
import threadingUtils.CompileJavaThread;
import threadingUtils.RunJavaProgramThread;


public class ProcessMain {
	
	public static void main(String[] args){
		//test1();
		//test2();
		test3();
	}
	
	public static void test1(){
		String properOutput = "Hello World.\n";
		
		String testDir = "C:\\JavaHomeworks\\HW1";
		
		try {
			DownloadSetup ds = new DownloadSetup(testDir);
			File dir = new File(testDir);
			File[] files = dir.listFiles();
			for(File file : files){
				String filename = file.getAbsolutePath(); 
				System.out.println("----"+file.getName());
				CompileAndRunJavaProgram mp = new CompileAndRunJavaProgram(filename);
				String str = mp.getOutput();
				if(str.trim().equalsIgnoreCase(properOutput.trim())){
					System.out.println(filename + " is correct.");
				}else{
					System.out.println("-----");
					System.out.println("--"+filename);
					System.out.println("--|"+mp.getOutput() + "| != |"+str+"|");
					System.out.println("-----");
				}				
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void test2(){
		String filename= "C:\\JavaHomeworks\\HW1\\amfinn.java";
		CompileAndRunJavaProgram mp = new CompileAndRunJavaProgram(filename);
		
	}

	public static void test3(){
		System.out.println("Start of test 3\n------------------");
		String dirname= "C:\\JavaHomeworks\\HW1\\";
		String filename = "amfinn.java";
		CompileJavaThread comp = new CompileJavaThread(dirname,filename);
		comp.run();
		System.out.println("Compile exit value of "+comp.getCompileExitValue());
		 
		if(comp.getCompileExitValue() == 0){
			RunJavaProgramThread program = new RunJavaProgramThread(dirname, filename.substring(0,filename.lastIndexOf(".")));
			//program.run();
			program.start();
				try {
				Thread.currentThread();
				Thread.sleep(1000);
				
				if(program.isAlive()){
					System.out.println("Still Alive");
					Thread.sleep(2000);
					System.out.println(" - Tried kill with isAlive now "+program.isAlive());
				}else{
					System.out.println("Dead");
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else{
			System.out.println(comp.getErrorOutput());
		}
		
		
		
		
		System.out.println("End of test 3\n------------------\n");
	}
}
