import java.util.*;

public class Reservation{
    private int C=20;
    private int R=15;
    private int W=10;
    LinkedList<String> confirmed_queue;
    LinkedList<String> rac_queue;
    LinkedList<String> waiting_queue;

    public Reservation(){

        confirmed_queue=new LinkedList<String>();
        rac_queue=new LinkedList<String>();
        waiting_queue=new LinkedList<String>();
 
    }

    Scanner in = new Scanner(System.in);

    public void reserve(){
        if(confirmed_queue.size() == C && rac_queue.size() == R && waiting_queue.size()==W){
            System.out.println("No seats available\n");
            return;
        }
        System.out.println("Enter the passenger name");
        String passenger=in.nextLine();   
            
        if(confirmed_queue.size() == C){
            if(rac_queue.size() == R){
                waiting_queue.add(passenger);
                System.out.println("Your reservation is under Waiting List with Seat No: "+waiting_queue.size());    
            }
            else{
                rac_queue.add(passenger);
                System.out.println("Your reservation is under RAC with Seat No: "+rac_queue.size());
            }
        }        
        else{
                confirmed_queue.add(passenger);
                System.out.println("Your reservation is confirmed with Seat No: "+confirmed_queue.size());
        }
    }

    public void cancel(){
        if(confirmed_queue.size() == 0 && rac_queue.size() == 0 && waiting_queue.size()==0){
            System.out.println("Seats are vacant");
            return;
        }

        System.out.println("Enter the passenger name");
        String passenger=in.nextLine();

        for(String element:confirmed_queue){
            if(element.equals(passenger)){
                confirmed_queue.remove(passenger);

                if(rac_queue.size()>0)
                    confirmed_queue.add(rac_queue.remove());
                
                if(waiting_queue.size()>0)
                    rac_queue.add(waiting_queue.remove());

                System.out.println("Your seat has been cancelled..!");
                return;
            }
        }
        for(String element:rac_queue){
            if(element.equals(passenger)){
                rac_queue.remove(passenger);
        
                if(waiting_queue.size()>0)
                    rac_queue.add(waiting_queue.remove());

                System.out.println("Your seat has been cancelled..!");
                return;
            }   
        }
        for(String element:waiting_queue){
            if(element.equals(passenger)){
                waiting_queue.remove(passenger); 

                System.out.println("Your seat has been cancelled..!");
                return;
            }  
        }
        System.out.println("Passenger does not exist\n");
    }

    public void print_details(){
        if(confirmed_queue.size()==0){
           System.out.println("Confirmation List Empty");
        }
        else{
            System.out.println("Confirmation List Passengers: ");
            int sno=1;
            for(String element:confirmed_queue){
                System.out.println(sno+". "+element);
                sno++;
            }
        }
        if(rac_queue.size()==0){
            System.out.println("RAC List Empty");
        }
        else{
            System.out.println("RAC List Passengers");
            int rno=1;
            for(String element:rac_queue){
                System.out.println(rno+". "+element);
                rno++;
            }    
        }

        if(waiting_queue.size()==0){
              System.out.println("Waiting List Empty\n");
        }
        else{
            System.out.println("Waiting List Passengers");
            int wno=1;
            for(String element:waiting_queue){
                System.out.println(wno +". "+element);
                wno++;
            }
            int count1 = C - confirmed_queue.size(); 
            System.out.println("Available seats in confirmed list: "+ count1);
            int count2 = R - rac_queue.size();
            System.out.println("Available seats in RAC list: "+ count2);
            int count3 = W - waiting_queue.size();
            System.out.println("Available seats in Waiting list: "+ count3);

        }
    }

    public void setC(int c){
        C=c; 
    }

    public void setR(int r){
        R=r;
    }
    
    public void setW(int w){
        W=w;
    }   
}

public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        Reservation r = new Reservation();

        System.out.println("/**********4JN18IS001 - ABHISHEK J M - 6A /**********\n");
        while(true){

            System.out.println("/**********Railway Reservation Menu /**********");
            System.out.println("1. Reservation");
            System.out.println("2. Cancellation");
            System.out.println("3. Details");
            System.out.println("4. Settings");
            System.out.println("5. Exit");
            System.out.println("Enter your choice");
            int choice = in.nextInt();

            switch(choice){
                       
                case 1: r.reserve();		
                        break;
                               
                case 2: r.cancel();
                        break;
                                   
                case 3:r.print_details();
                        break;
                                   
                case 4:System.out.println("Which setting to change: C-Confirmation, R-RAC, W-Waiting List");
                        in = new Scanner(System.in);
                        String ch=in.nextLine();

                        if(ch.equals("C")){
                            System.out.println("Enter new value ");
                            int nw=in.nextInt();
                            r.setC(nw);
                        } 
                        else if(ch.equals("R")){
                            System.out.println("Enter new value ");
                            int nw=in.nextInt();
                            r.setR(nw);
                        } 
                        else if(ch.equals("W")){
                            System.out.println("Enter new value ");
                            int nw=in.nextInt();
                            r.setW(nw); 
                        }    
                        break;
                               
                case 5: r.print_details();
                        System.out.println("\nThankyou...!\n");
                    	System.exit(0);
            }
        }
    }
}
