public class Room{
int roomtype,room_no,no_peop;
boolean confirm;
private Room rarray[]=new Room[3];


public Room(int r,int g,int u){
	roomtype=r;
	room_no=g;
	no_peop=u;
}
public void setRoom(){
	
	rarray[0]=new Room(1,2,2);
	
	rarray[1]=new Room(2,2,4);
	
	rarray[2]=new Room(3,2,8);
}
	
	
	
	
public void setRn(int i){
this.room_no= this.room_no-i;
}
	
public Room getroomRec(int i){
	return this.rarray[i];
}

public int getRoomtype(){
	return this.roomtype;
}


public int getbedNopeop(){
	return this.no_peop;
}

public int getRno(){
	return this.room_no;
}


public int Roomnumfunc(int k){
			int v=0,val=0;
			Room t=new Room(0,0,0);
			while(v<3){
				
				t.setRoom();
				t=t.getroomRec(v);
			if(t.getRoomtype()==k){
				val=t.getRno();
				break;
			}
			else
				val=-1;
			v++;
			}
			return val;
}


	
}