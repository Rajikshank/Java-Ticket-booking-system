

//Team members
//AA1868-K.Rajikshan
//AA1889-Noel sanujan
//AA2056-Nimnas ahamed
//1832-H.R.Ann Kishanthi 




import java.util.Scanner;
import java.util.Objects; 

public class BookingRecord{
	
	private int R_t,R_n,N_p,C_s,B_p,Day,Month,Year;

	
	public BookingRecord(int i,int j,int k,int f,int g,int d,int m,int y){
		R_t=i;
		R_n=j;
		N_p=k;
		C_s=f;
		B_p=g;
		Day=d;
		Month=m;
		Year=y;
	}
	
	
	
	
	
	
	
	public void setcs(int i){
		this.C_s=i;
	}
	
	public int getRt(){
		return this.R_t;
	}
	
	public int getRn(){
		return this.R_n;
	}
	
	public int getNp(){
		return this.N_p;
	}
		
	public int getcs(){
		return this.C_s;
	}
	
	public int getbookpin(){
		return this.B_p;
		}
		
	public int getRv(int v,int c,int b,int s){
		if(this.Day==v && this.Month==c && this.Year==b && this.R_t==s){
			return this.R_n;
		}
		
		else
			return 0;
	}
	
	
	public void printdate(){
		System.out.println("booked date (dd//mm//yy)-"+this.Day+"//"+this.Month+"//"+this.Year);
	}
	
	public void dateSplit(String s,int arr[]){
		int j=0;
		for(String i:s.split("/",0)){
			arr[j]=Integer.parseInt(i);
			j++;
		}
	}
	
	public static void main(String args[]){
		
		int bk_pn=100;
		int Room_type=0;
		int Room_no=0;
		int bed_no=0;
		int no_peop=0;
		int v,v_1,darr[]=new int[3];
		int search=0,select=0,price=0,date,month,year,m_s,q=0,confirm_local=0,del=0;
		Room r;
		boolean login=false,uname_ver,log_in_ver,save_new=true,M_sel,Skip=false,loop=true,Date=true;
		BookingRecord record[]=new BookingRecord[10];
		String F_con="pending",date_string;
		
		
		
		
		
		Scanner sc=new Scanner(System.in);
		int i=0;
		 customer c []=new customer[10];
		c[i]=new customer("empty","empty","empty","empty");
		record[i]=new BookingRecord(-1,-1,-1,-1,-1,-1,-1,-1);//initializing with fake values to acces the methods from the object;
		
			while(loop){// main loop to toggle between sections 
		System.out.println("-------------------Welcome to ABC hotel Online Room Booking Portal Main page -----------------------");
	
		
		System.out.println("1.Do a Booking\n2.Login Handling\n3.New user Registration\n4.Quit programme");
		System.out.print("please enter your choice :");
		int ch=sc.nextInt();
			sc.nextLine();
		
		r=new Room(Room_type,Room_no,no_peop);
			r.setRoom();
		
		
		
		if(ch==1){
			
			
			M_sel=true;
			m_s=0;
			
			
			
			while(M_sel==true){//main loop to repeat the booking page without goin to main menu 
			
			
			try{	// this codeblock will fail if there is an exception and trigger the catch code block to show an error message if user has encountered any unusual thing
				
			System.out.println("\n\n----------- Room boooking page  ---------");
			System.out.println("Available Room details \nRoom type-1   no of bed-1   available rooms-"+r.Roomnumfunc(1)+"    price per day=Rs.1000/= \nRoom Type-2   no of bed-2   available rooms-"+r.Roomnumfunc(2)+"    price per day =Rs.2000/=\nRoom type-3   no of bed-4   available rooms-"+r.Roomnumfunc(3)+"    price per day=Rs.3000/=\n");
			System.out.print("Enter the room type you want :");
			Room_type=sc.nextInt();
			System.out.print("How many room do you want to book :");
			Room_no=sc.nextInt();
			System.out.print("Enter the Number of people going to stay at the Room :");
			no_peop=sc.nextInt();
			sc.nextLine();
			System.out.println("when you want to book for room ?");
			System.out.print("Date (dd//mm//yy):");
			date_string=sc.nextLine();
			
			record[0].dateSplit(date_string,darr);// splitting the day,month,year from the string using datesplit method
			date=darr[0];month=darr[1];year=darr[2];//assigning the splitted values to the variables
			
	
			
		if(date==0 || month == 0 || year==0)
		{
			System.out.println("\ninvalid date format or date please try again\n");
			Date=false;
		}
		else
			Date=true;
		
		
			
			if(r.Roomnumfunc(Room_type)<Room_no||Room_type>3||Room_type<1)
		{
			System.out.println("\nsorry !!! required number of room not available at this moment only \n");
			Skip=true;
		}
			
			
			
			
			
			v=0;
			int p=0;
		while(v<i&&Skip==false){// make sure there are rooms available by matchingthe date given by user
			
				p=p+record[v].getRv(date,month,year,Room_type);
					v++;
		}
			p=p+Room_no;
			if (p>r.Roomnumfunc(Room_type)){
				Skip=true;
				System.out.println("\n\nSorry required amount of room is not available at this date..........\n\n");
				
			}
			
			else
				Skip=false;//to skip the entire loop or continue according this variable 
		
		
		
		
		
			
				v=0;
			while(v<3 && Skip!=true && Date==true ){//user registration and account finding queue
				r.setRoom();
				r=r.getroomRec(v);
				
				
				if(no_peop<=r.getbedNopeop() && Room_type==r.getRoomtype()){//continues only if the required amount of pepople can be acceptable by the system
					System.out.println("------------Room available------------\n \n");
		System.out.println("please provide your details to book a room\n");
		
		if(i>0)
		{
		System.out.print("if you are a old user press 1 to skip this new account registration terminal ");//to make booking easy already registed user can simply book using their user name 
		 q=sc.nextInt();
		sc.nextLine();
		}
		
		if(q==1&& i>0){//old user booking inusring page and that there are registered users in the system 
		System.out.println("\n------------ User login page  --------------\n");	
			
		System.out.println("enter user name");
		String k=sc.nextLine();
		
		System.out.println("enter password");
		String l=sc.nextLine();
		search=0;
		
		
		while(search<i){
			login=c[search].userlogin(k,l);
			
			if(login==true){
				System.out.println("\nlogin success.....\n");
				break;
			}
				
			search++;
		}
		
		
		if(login==false)
			System.out.println("\nlogin failed!!!");
		
		
		
		if(login==true && record[search].getRn()!=-1){//to save the booking details only if user created a new account just now
		c[i]=new customer(k,l,c[search].getcname(),c[search].getphone());
		del=1;
				}
		}
		
		
		else{
		System.out.println("\n-----------  New account registration page  -----------\n");
		System.out.println("enter your name:");
		String o=sc.nextLine();
		
		System.out.println("enter your  phone no: ");
		String  j=sc.nextLine();
		
		c[i]=new customer("empty","empty",o,j);//dummy record to check there username availablity 
		
		uname_ver=false;	
		while(uname_ver==false){	//checking the user name availablity
		
		System.out.println("please chose a user name:");
			String k=sc.nextLine();
		
		
		
		System.out.println("please choose a  password:");
		String l=sc.nextLine();
		
		String s=c[i].getstaffid();
		if(s.equals(k))
		{
			System.out.println("\nyou entered staff account username you cant create a new account with this user name!!!!\n");
			uname_ver=false;
			continue;
		}
		
		
		
		
		
		v_1=0;
		while(v_1<i){
			if(c[v_1].userlogin(k,l)){
				uname_ver=false;
				break;
			}
			else
				uname_ver=true;
			v_1++;
		}
		
		
		if(i==0)uname_ver=true;
		if(uname_ver==false)
			System.out.println("\n username already available!!!\n");
			
		else if(uname_ver== true){
		c[i].setid(k);
		c[i].setps(l);
		}
		
		}
	System.out.println("do you want to submit ? 1-yes 2-No");
	 select=sc.nextInt();
		
					
		}		
					break;
					
				}
			else if(no_peop!=r.getbedNopeop() && Room_type==r.getRoomtype()){
				System.out.println("\n Sorry!!! this room cant hold number of people you have entered please book bigger room\n");break;
				
					
				
			}
			
			v++;
			
		}
		
		if(login==true||select==1){// confirmation and order review

			System.out.println("do you want to submit this booking for the confirmation ? 1-yes 2-No");
			int sel=sc.nextInt();
		
		
		
		if(login==true && sel==1 && record[search].getRt()!=-1 || select==1 && sel==1){
			record[i]=new BookingRecord(Room_type,Room_no,no_peop,3,bk_pn,date,month,year);
			System.out.println("booking sended successfully for the review please login to your account to get the confirmation status");
			bk_pn++;
			save_new=true;
			
			int pr_t=record[i].getRt();
			if(pr_t==1){price=1000;}
			if(pr_t==2){price=2000;}
			if(pr_t==3){price=3000;}
			
		System.out.println("\n---------------------booking order review-----------------------\nName -"+c[i].getcname()+"    customer contact no -"+c[i].getphone()+"    booked Room Type -"+record[i].getRt()+"\nbooked Room no -"+record[i].getRn()+"   Rooms no of peoples goint to stay -"+record[i].getNp()+"   price per day for the room ="+price+"Rs   your booking order pin -"+record[i].getbookpin()+"   booking status -not confirmed  ");	
		record[i].printdate();
		i++;
				
		}
		
		
	else if(login==true && sel==1 && record[search].getRt()==-1)
	{
			System.out.println("search value "+search+"\n\n\n\n");
			record[search]=new BookingRecord(Room_type,Room_no,no_peop,3,bk_pn,date,month,year);
			System.out.println("booking sended successfully for the review please login to your account to get the confirmation status");
			bk_pn++;
			
			save_new=false;
		int pr_t=record[search].getRt();
			if(pr_t==1){price=1000;}
			if(pr_t==2){price=2000;}
			if(pr_t==3){price=3000;}		
		
	System.out.println("---------------------booking order review-----------------------\nName -"+c[search].getcname()+"    customer contact no -"+c[search].getphone()+"    booked Room Type -"+record[search].getRt()+"\nbooked Room no -"+record[search].getRn()+"   Rooms no of peoples goint to stay -"+record[search].getNp()+"   price per day for the room ="+price+"Rs   your booking order pin -"+record[search].getbookpin()+"   booking status -not confirmed  ");		
	record[search].printdate();
	}
	
	
	else if(select==1 && sel==2)
{
	System.out.println("\nBooking cancelled.............\n");
	c[i]=new customer("empty","empty","empty","empty");//assuming that user dont enter entry like empty  using this to flush the previous data 
}

	
else if(login==true && sel==2&&del==1)
{
	System.out.println("\nBooking cancelled.............\n");
	
		record[i]=new BookingRecord(-1,-1,-1,-1,-1,-1,-1,-1);
		del=0;
}

	}
	
	
select=0;
login=false;
Skip=false;

System.out.print("\n\nDo you want to Make another booking ? 1-New booking 2-Return to main menu 	please enter your selection ? :");
 m_s=sc.nextInt();//return page choosing section
	sc.nextLine();
	


	if(m_s==1)
		M_sel=true;
	else
		M_sel=false;
	
	System.out.println("\n");
			}
			
			
			catch(Exception e)//to indicate invalid input error messages and avoid the program fail while running 
			{
				sc.nextLine();	//to catch the wrong/invalid input that user entered in the try block 
				System.out.println("something went wrong ......... please check your input and try again .......");//to indicate there was an error
				
				if(record[i]==null && c[i]!=null);
				{
					c[i]=new customer("empty","empty","empty","empty");//to flush the previous data
					
				}
				
			}
			
		}
		
		System.out.println("\nThank you for making a booking with us we will update your booking confirmation status soon stay connected with us.......\n");
			
}
	
	else if(ch==2){// user and staff login system 
	
	M_sel=true;
	m_s=0;
			
	while(M_sel==true){
	
	System.out.println("\n-----------user login page--------------");
	
		log_in_ver=true;
		try {
		while(log_in_ver==true){// repeat the entries untill everything matches 
		
			
		System.out.println("enter your user name");
		String k=sc.nextLine();
		
		System.out.println("enter your password");
		String l=sc.nextLine();
		
	
			v=0;
		String s=c[v].getstaffid();
		String h=c[v].getstaffpas();
		
		
		if(s.equals(k) && l.equals(h) )
		{																				//staff account login portal
			log_in_ver=false;
			System.out.println("------------staff account logged in succesfully----------------");
			if(i>0)
			System.out.println(" booking records pending to be confirmed");
			
				
			
			while(v<i){
				if(record[v].getcs()==2 ||record[v].getcs()==1)
			{
			
					v++;
					continue;
			}
		
		else if(record[v].getRt()==-1)
			{ 
					
					v++;
					continue;
			}
			
			
				System.out.println("customer name - "+c[v].getcname()+" customer phone no - "+c[v].getphone()+" Room type- "+record[v].getRt()+" Room no- "+record[v].getRn()+" Number of people- "+record[v].getNp()+"  booking pin no -"+record[v].getbookpin());
				record[v].printdate();
				System.out.println("\ndo you want to confirm this booking ? 1.Yes/2.N0 choose your selection");
				 confirm_local=sc.nextInt();
				record[v].setcs(confirm_local);
				v++;
			}
			
			if(confirm_local==0)
				{
				System.out.println(" There are no booking records pending to be confirmed !!!! ");	
				}
				
				confirm_local=0;
		}
	
	
	else{
		v=0;
		while(v<i){
	
	
		String temp=c[v].getuid();
		String temp2=c[v].getpassword();
		
		
		
		int temp3=record[v].getcs();// to get the booking confirm status as a string 
		if(temp3==1)
		{
			 F_con="Confirmed";
		}
		
		
		else if (temp3==2)
		{
			F_con="cancelled";
		}
		
		else if(temp3==3)
		{
			 F_con="pending";
		}
		else if (temp3==-1)
		{
			F_con="Error";
		}
		
		
		if(k.equals(temp) && l.equals(temp2) &&record[v].getRt()==-1 && F_con.equals("Error"))
			{
		System.out.println("\nSorry there is no booking entries from your account!!!.....\n please login if you booked a room previously with us \n");
		log_in_ver=false;
		break;
			}
		
		
		
		
		
	else if(k.equals(temp) &&l.equals(temp2)&&F_con.equals("Confirmed"))
	 {
			log_in_ver=false;
			int pr_t=record[v].getRt();
			if(pr_t==1){price=1000;}//getting price for the room
			if(pr_t==2){price=2000;}
			if(pr_t==3){price=3000;}
			System.out.println("-----welcome "+temp+"-------");
			System.out.println("------------- booking order pin no "+record[v].getbookpin()+"-------\nName -"+c[v].getcname()+"    customer contact no -"+c[v].getphone()+"    booked Room Type -"+record[v].getRt()+"\nbooked Room no -"+record[v].getRn()+"   Rooms no of peoples goint to stay -"+record[v].getNp()+"   price per day for the room ="+price+"   booking status -"+F_con);			
			record[v].printdate();
	}
	
	
	
	else if(k.equals(temp)==false|| l.equals(temp2)==false)
	{
		System.out.println("\nusername or password  incorrect!!!!.....\n----------please check your user name and password and re enter---------\n ");
		log_in_ver=true;	
		break;
		
	}
	
	
	
	else if(k.equals(temp) &&l.equals(temp2)&&F_con.equals("pending"))
	{
		System.out.println("  your booking order is pending!!!! for the confirmation right now you can't login to our system.........\n\n");
		log_in_ver=false;
		break;
		
	}
	
	
	else if(k.equals(temp) &&l.equals(temp2)&& F_con.equals("cancelled"))
	{
		System.out.println("\nSorry!!! your booking order pin "+record[v].getbookpin()+" got cancelled by our hotel staff for some reason's please contact our hotline for more informations\n Hotline=0771234567     email:Abc@hotel.com \n");
		log_in_ver=false;
	}
	 
	 
	 
	v++;
	
		}
	
	if(v==0)
			{
		System.out.println("\nThere are no booking records pending to be showed from our system please make a booking to move further !!! ");
		log_in_ver=false;
			}
	
	}
	

	}
	
	System.out.print("\n\n1-login to another account 2-Return to main menu 	please enter your selection? :");
 m_s=sc.nextInt();
	sc.nextLine();
	


	if(m_s==1)
		M_sel=true;
	else
		M_sel=false;
	System.out.println("\n");
		}
		catch(Exception e)// to indicate a input error or failures happens in the program 
		{
			sc.nextLine();
			System.out.println("\nFailed to move further steps please check your input and try again........\n");
		}
	}
	
	
	}	
	else if(ch==3){
		System.out.println("\n--------------New account registration page------------------");
		
		System.out.println("enter your name:");
		String o=sc.nextLine();
		
		System.out.println("enter your  phone no: ");
		String j=sc.nextLine();
		
		c[i]=new customer("empty","empty",o,j);
		
		
		uname_ver=false;	
		while(uname_ver==false){	
		
		System.out.println("please choose a user name:");
			String k=sc.nextLine();
		
		
		
		System.out.println("please choose a  password:");
		String l=sc.nextLine();
		
		
		String s=c[i].getstaffid();
		if(s.equals(k)){
			System.out.println("\nyou entered staff account username you cant create a new account with this user name!!!!\n");
			uname_ver=false;
			continue;
		}
		
		
		v_1=0;
		
		while(v_1<i){
			if(c[v_1].userlogin(k,l)){
				uname_ver=false;
				break;
			}
			else
				uname_ver=true;
			v_1++;
		}
		
		
		if(i==0)uname_ver=true;
		if(uname_ver==false)
			System.out.println("\n username already available!!!\n");
			
		else if(uname_ver== true){
		c[i].setid(k);
		c[i].setps(l);
		}	
	}	
		
		
		
		System.out.println("Are you sure do you want to create a new account ? 1-Yes/2-No");
		int sel_3=sc.nextInt();
		
		if(sel_3==1){
		record[i]=new BookingRecord(-1,-1,-1,-1,-1,-1,-1,-1);//to save a dummy record to match the record to avoid being a null record 
		
		System.out.println("------Account registered successfully-----\n       Returning back to main page \n");
		i++; 
		}
		
		
		
		else{
			System.out.println("-------- new account registration page terminated------");
					c[i]=new customer("empty","empty","empty","empty");
		
		}
		
			
}


	else{//this will allow prgramme to quit when user enters a number that not belongs to the available selection list 
	System.out.println("\n\n---------------Program quitted -----------------");
		loop=false;
	}


}
}	
}
	
