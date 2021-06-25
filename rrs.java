import java.util.*;

public class rrs {
   static int C=40;
   static int R=30;
   static int W=20;
   LinkedList<String> confirmed_queue;
   LinkedList<String> rac_queue;
   LinkedList<String> waiting_queue;

   public rrs()
   	{
     confirmed_queue=new LinkedList<String>();
     rac_queue=new LinkedList<String>();
     waiting_queue=new LinkedList<String>();
 	}
   public void reserve(String passenger_name)
  {
       if(confirmed_queue.size()==C) //Confirmed Queue full
      {
          if(rac_queue.size()==R) //RAC Queue full
          {
                if(waiting_queue.size()==W)  //Waiting List Queue full
                {
                       System.out.println("\nSeats are empty\n");
                       return; 
                }
                else
                 {
                      waiting_queue.add(passenger_name);
                      System.out.println("Your reservation is under Waiting List with Seat No: "+waiting_queue.size());
                 }
          }
          else
           {
                 rac_queue.add(passenger_name);
                 System.out.println("Your reservation is under RAC with Seat No: "+rac_queue.size());
          }
      }
     else
     {
            confirmed_queue.add(passenger_name);
            System.out.println("Your reservation is confirmed with Seat No: "+confirmed_queue.size());
     }

 }

public void cancel(String passenger_name)
{
   for(String element:confirmed_queue)
   {
        if(element.equals(passenger_name))
        {
                confirmed_queue.remove(passenger_name);
               	if(rac_queue.size()>0)
                confirmed_queue.add(rac_queue.remove());
                
                if(waiting_queue.size()>0)
                	rac_queue.add(waiting_queue.remove());
                return;
         }
   }
  for(String element:rac_queue)
  {
      if(element.equals(passenger_name))
      {
             rac_queue.remove(passenger_name);
             if(waiting_queue.size()>0)
             rac_queue.add(waiting_queue.remove());
             return;
      }   

  }
  for(String element:waiting_queue)
 {
      if(element.equals(passenger_name))
      {
           waiting_queue.remove(passenger_name); 
           return;
      }  
  }
  System.out.println("Passenger does not exist\n");
     
}

public void print_details()
{
     if(confirmed_queue.size()==0)
     {
           System.out.println("Confirmation List Empty");
     }
    else
     {
        System.out.println("Confirmation List Passengers: ");
         int sno=1;
         for(String element:confirmed_queue)
         {
             System.out.println(sno+". "+element);
             sno++;
         }
     int count1 = C - confirmed_queue.size(); 
     System.out.println("Available seats in confirmed list are: "+ count1);
	}
    if(rac_queue.size()==0)
    {
            System.out.println("RAC List Empty");
    }
    else
    	{
           System.out.println("RAC List Passengers");
           int sno=1;
          for(String element:rac_queue)
          {
               System.out.println(sno+". "+element);
                sno++;
          }
     int count2 = R - rac_queue.size();
     System.out.println("Available seats in RAC list are: "+ count2);
	}

      if(waiting_queue.size()==0)
       {
              System.out.println("Waiting List Empty\n");
        }
        else
        {
               System.out.println("Waiting List Passengers");
               int sno=1;
               for(String element:waiting_queue)
               {
                    System.out.println(sno +". "+element);
                    sno++;
               }
           	int count3 = W - waiting_queue.size();
                System.out.println("Available seats in Waiting list are: "+ count3);

        }
}

public void setC(int c)
{
    C=c; 
}

public void setR(int r)
{
    R=r;
}

public void setW(int w)
{
    W=w;
}

public static void main(String[] args) {
        
        rrs r= new rrs();
        System.out.println("/**********4JN18IS001 - ABHISHEK J M - 6A /**********");
        while(true)
        {
            System.out.println("/**********Railway Reservation Menu /**********");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Details");
            System.out.println("4. Settings");
            System.out.println("5. Exit");
 
            System.out.println("Enter your choice");
            Scanner in=new Scanner(System.in);
             int choice=in.nextInt();
             switch(choice)
             {
                       
                        case 1: if(r.waiting_queue.size()==W){
                        		System.out.println("No seats available\n");
                        		break;
                        	}
                        	  	System.out.println("Enter the passenger name");
                                 	in=new Scanner(System.in);
                                   	String passenger=in.nextLine();
                                   	r.reserve(passenger);  		
                               break;
                        case 2: System.out.println("Enter the passenger name");
                                  in=new Scanner(System.in);
                                    passenger=in.nextLine();
                                   r.cancel(passenger);
                                   break;
                        case 3:r.print_details();
                                   break;
                        case 4:System.out.println("Which setting to change: C-Confirmation, R-RAC, W-Waiting List");
                               in=new Scanner(System.in);
                               String ch=in.nextLine();
                               if(ch.equals("C"))
                                {
                                   System.out.println("Enter new value ");
                                   int nw=in.nextInt();
                                   r.setC(nw);
                                } 
                                else if(ch.equals("R"))
                                {
                                   System.out.println("Enter new value ");
                                   int nw=in.nextInt();
                                   r.setR(nw);
                                } 
                                else if(ch.equals("W"))
                                {
                                   System.out.println("Enter new value ");
                                   int nw=in.nextInt();
                                   r.setW(nw);
                                } 
                               break;
                       case 5: r.print_details();
                    		System.exit(0);
                  }
                                    

             }
        }
    }


