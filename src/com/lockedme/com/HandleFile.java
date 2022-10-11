package com.lockedme.com;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
public class HandleFile {

	public static void main(String[] args) throws IOException {
		String path="D:\\LockersDocs\\";
		boolean flag1=true;
		boolean flag2=true;
		Scanner sc=new Scanner(System.in);
		
		System.out.println("Welcome To LockersApp");
		System.out.println("...................");
		System.out.println("App name:\t LockersApp v1");
		System.out.println("Developed by:\t Princia");
		System.out.println("App description:\t Easy and userfriendy App for File Management");
		System.out.println("Press 1 to continue with the application");
		if(sc.nextInt()==1)
		{
			while(flag1) {	
				System.out.println("\n\nPlease Choose an Option From the Following");
				System.out.println("1-Show Saved Files within LockersDocs");
				System.out.println("2-Handle Files within LockersDocs");
				System.out.println("3-Close the Program");
				int operation=sc.nextInt();
				switch(operation) {
				case 1:
					File f=new File(path);
					File filenames[]=f.listFiles();
					boolean flag3 = true;
					System.out.println("LockersDocs\n.................");
					for(File ff:filenames) {
						if(ff.getName() != null) {
							System.out.println(ff.getName());
						}
						else
						{
							flag3=false;
						}
					}
					if(flag3)
						System.out.println("LockersDocs is Empty");
						
					break;
				case 3:
					flag1=false;
					System.out.println("Exited!! Bye..");
					System.exit(0);
					break;
					
				case 2:
					while(flag2) {
						System.out.println("\n\nChoose From the Following \n 1-Create File(add),2-Delete File,3-Search File,4-Back to Main Menu");
						int subopr=sc.nextInt();
						switch(subopr) {
						case 1:
							System.out.println("Enter Filename to Create");
							String filetoadd=sc.next();
							File fa=new File(path+filetoadd);
							boolean b=fa.createNewFile();
							if(b) {
								System.out.println("File Created successfully");
								FileWriter fo=new FileWriter(path+filetoadd);
								System.out.println("Enter data into the file:"+filetoadd);
								String inputOfFile=sc.next()+sc.nextLine();
								fo.write(inputOfFile);
								System.out.println("Data Added Successfully");
								fo.close();
							}
							else
							{
								System.out.println("File Creation Failed");
							}
							break;
						case 2:
							System.out.println("Enter the filename you want to delete");
							String filetodelete=sc.next();
							File f2=new File(path+filetodelete);
							if(f2.delete())
							{System.out.println("file got deleted");
							}
							else
							{
							 System.out.println("file deletion failed");
							}
							break;
						case 3:
							System.out.println("Enter the filename to search");
							String filetosearch=sc.next();
							File f3=new File(path);
							File filesinf[]=f3.listFiles();
							String res="File not found";
							for(File fs:filesinf) {
								if(fs.getName().equals(filetosearch)) {
									res="The file "+filetosearch+"is found";
									break;
								}
								
						}
							System.out.println(res);
							break;
						case 4:
							flag2=false;
							break;
						default : System.out.println("invalid operation..Please Choose Valid option");
					
						break;
					}
						
						}
					default : 
					
					break;
					

				}
				}
				
			}
		
		

	}

}
