import java.util.Scanner; 
 
 public class user{
	private String id;//to store user name 
	private String ps;// password of users 
	
	
	
	
	
	
	
	public void setid(String i){//setters for user name and password
		this.id=i;
	}
	
	public void setps(String k){
		this.ps=k;
	}
	
	
	public String getuid(){//getters for user name and password
		return this.id;
 }
 
 public String getpassword(){
	 return this.ps;
 }
 
 

 
 }
 
 
 
 
 
	 class staff extends user{
		private String id,ps;
	public staff(){
		id="staff_account";
		ps="password";
	}
		
	public String getstaffid()
	{
			return this.id;
	}
	
	
	public String getstaffpas()
	{
		return this.ps;
	}
	
	
	 }
	
	
	
	
	
	class customer extends staff{
	
		private String C_name;
		private String C_phone;// choosed string type to avoid integer size issuees to various ph numbers
		
		public customer(String k,String l,String o,String j){
			super();
			super.setid(k);
			super.setps(l);
			staff s=new staff();
			C_name=o;
			C_phone=j;
		}
		
		
	


		public String getcname(){
			return this.C_name;
		}
		
		public String getphone(){
			return this.C_phone;
		}
		
		
	 public boolean userlogin(String k,String l){
		boolean login=false;
			String temp=super.getuid();
			String temp2=super.getpassword();
		
			
			if(temp.equals(k)==true && temp2.equals(l)==true){
				 login=true;
				
			}
			
			
			else if (temp.equals(k)==false && temp2.equals(l)==false){
				login=false;
		
			}
				
		return login;
	 }		 
		
	}		
			
