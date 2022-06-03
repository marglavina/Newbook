package controller;


import java.io.*;
import java.util.*;
import Model.User;

public class UserController {

	public String setUserInfo(String userName) {
		
		String info = "";
		
		try{
			
			File users = new File(userName+".txt");
			BufferedReader bf = new BufferedReader (new FileReader(users));
			
			info = bf.readLine();
						
			bf.close();	
			
		}
		catch(IOException e){
			
			System.out.println (e);
			
		}			
		return info;		
	}
	
	
	public boolean checkUserPass (String userName, String passWord) {
				
		boolean username = false;
		boolean password = false;
		boolean correct = false;
		
		try {
			
			File users = new File("users.txt");
			BufferedReader bf = new BufferedReader (new FileReader(users));
			String user;
			String[] userPandU;
			
			while((user = bf.readLine())!= null)
			{
				userPandU = user.split(", ");
				username = userName.equals(userPandU[0]);
				password = passWord.equals(userPandU[1]);
				if(username && password)
				{
					correct = true;
					break;
					
				}
			
			}
			bf.close();			
		}
		catch(IOException e){
			System.out.println (e);
			correct = false;
		}		
		return correct;
	}
	
}
