import java.util.*;
import java.util.LinkedList;
class Reservation{
	int C=20;
	int R=15;
	int W=10;
	LinkedList<String> confirmed_queue = new LinkedList<String>();
	LinkedList<String> rac_queue = new LinkedList<String>();
	LinkedList<String> waiting_queue = new LinkedList<String>();
   	public void reserve()
   	{
   		Scanner in = new Scanner(System.in);
   		if(waiting_queue.size()==W && rac_queue.size()==R & confirmed_queue.size()==C)
		{
			System.out.println("Tickets are not available");
      	}
    		else
    		{
    			System.out.println("Enter the Passenger name");
    			String name= in.nextLine();
    			if(confirmed_queue.size()<C){
        		confirmed_queue.add(name);
        		System.out.println("Your reservation is Confirmed with Seat No: "+confirmed_queue.size());
    			}
    			else if(rac_queue.size()<R){
    			System.out.println("Your seat is in RAC; For confirmation press 1");
    			int ch = in.nextInt();
    			if(ch==1){
				rac_queue.add(name);
				System.out.println("Your reservation is under RAC with Seat No: "+ rac_queue.size());
        			}
        		else{
        			return;
        			}
        			
        		}
        		else if(waiting_queue.size()<W){
        		System.out.println("Your seat is in Waiting list; For confirmation press 1");
    			int ch = in.nextInt();
    			if(ch==1){
				waiting_queue.add(name);
       	 		System.out.println("Your reservation is under Waiting List with Seat No: "+waiting_queue.size());
       	 	}
       	 else{
        			return;
        			}
        		}

       	 	
   	 	}
	}
    public void cancel(){
    					System.out.println("Reserved Passengers are:" +confirmed_queue);
					System.out.println("RAC Passengers are:" + rac_queue);
					System.out.println("Waiting List Passengers are:" + waiting_queue);
					System.out.println("ENTER 1:Confirmation Cancelation 2:RAC Cancelation 3:Waiting Cancelation\n");
					Scanner in=new Scanner(System.in);
					int p=in.nextInt();
					switch(p)
    					{
						case 1: System.out.println("Enter the Passenger Name");
        					Scanner m=new Scanner(System.in);
        					String name=m.nextLine();
        					if(confirmed_queue.contains(name))
        					{
        						confirmed_queue.remove(name);
           					System.out.println(confirmed_queue);
							if(rac_queue.isEmpty()== false)
							{
                       				String c=rac_queue.remove(0);
                        				confirmed_queue.add(c);
           					}
							if(waiting_queue.isEmpty()==false)
							{
           						String d=waiting_queue.remove(0);
           						rac_queue.add(d);
           					}
							System.out.println("Ticket Cancelled\n");
           				}
           				else if(!confirmed_queue.contains(name))
           				{
           					System.out.println("Invalid Passenger Name");
           				}
         					break;
         					case 2: System.out.println("Enter the Passenger Name\n");
        						  Scanner n=new Scanner(System.in);
        					        String name_2=n.nextLine();
         						   if(rac_queue.contains(name_2))
         							{
         								rac_queue.remove(name_2);
         								System.out.println(rac_queue);
         								if(waiting_queue.isEmpty()==false){
         									String e=waiting_queue.remove(0);
           								rac_queue.add(e);
         								}
	    							System.out.println("Ticket Cancelled\n");
         							}
         							else if(!rac_queue.contains(name_2))
           						{
           							System.out.println("Invalid Passenger Name");
           						}
								break;
         					case 3: System.out.println("Enter the Passenger Name\n");
        					Scanner o=new Scanner(System.in);
        					String name_3=o.nextLine();
        					if(waiting_queue.contains(name_3))
         							{
									waiting_queue.remove(name_3);
           							System.out.println("Ticket Cancelled\n");
     	     							}
     	    					else if(!waiting_queue.contains(name_3))
           				{
           					System.out.println("Invalid Passenger Name");
           				}
					
					}

					}  
  public void Details(){
        System.out.println("Confirmation List Passengers ");
        for(String m:confirmed_queue){
        	System.out.println(m);
        }
        System.out.println("AVAILABLE SLOTS ARE : "+ (C - confirmed_queue.size()));
        System.out.println("RAC List Passengers ");
        for(String n:rac_queue){
        System.out.println(n);
                    
        }
        System.out.println("AVAILABLE SLOTS ARE: "+ (R - rac_queue.size()));
        System.out.println("Waiting List Passengers ");
        for(String o:waiting_queue){
        System.out.println(o);
        }
        System.out.println("AVAILABLE SLOTS ARE: "+ (W - waiting_queue.size()));
     }
    
    
    public void settings() {
    	System.out.println("ENTER 1:C TICKETS 2:RAC TICKETS 3:W TICKETS");
    	Scanner s=new Scanner(System.in);
    	int x=s.nextInt();
    	switch(x)
    	{
    	case 1:System.out.println("Enter the size of C Tickets");
    		C=s.nextInt();
    		break;
    	case 2:System.out.println("Enter the size of RAC Tickets");
    	      R=s.nextInt();
    	      break;
    	case 3:System.out.println("Enter the size of W Tickets");
    		W=s.nextInt();
    		break;
    	default:System.out.println("Invalid choice");
    	}
    }
 }

public class Railway {
    public static void main(String[] args){
        
         System.out.println("/**********4JN18IS001 - ABHISHEK J M - 6A /**********");
         Reservation r = new Reservation();
        
        while(true){
        

    	 	 System.out.println("/**********Railway Reservation Menu /**********");
            System.out.println("1. Reservation");
            System.out.println("2. Cancelation");
            System.out.println("3. Details");
            System.out.println("4. Settings");
            System.out.println("5. Exit");
        	Scanner in = new Scanner(System.in);
        	System.out.println("Enter your choice");
        	int choice = in.nextInt();
        	switch (choice) {
        		case 1: r.reserve();
                			break;
            	case 2: 	r.cancel();
            			break;
            	case 3: r.Details();
					break;
            	case 4: r.settings();
					break;
            	case 5: r.Details();
            		   System.exit(0);
                
        }
       }
  	}
}

