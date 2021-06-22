# Railway_Collection_Framework

Railway department maintain 3 information’s
1. Reservation (confirmed) - C no. of tickets
2. RAC - Reservation against cancellation - R no. of tickets
3. Waiting List - W no. of tickets.
All passengers expect their reservation is going to be confirmed.
If C no. tickets already confirmed, their reservation will be treated as RAC.
If R no. tickets already confirmed, their reservation will be listed under waiting
list.
Any passenger under any of these 3 lists, can cancel the ticket.
If cancellation is done in confirmed list, then one passenger info from RAC, is
moved to Confirmed list and one passenger info from waiting list is moved to
RAC
If cancellation is done in RAC, then one passenger info from Waiting list is
moved to RAC list
Finalize best data structure from Java collection frame work. Implement menu
driven Railway reservation system.
Menu should have the following:
Display your USN, Name and Section and the following option
1. Reservation
2. Cancellation
3. Details of the three list, availability etc.
4. Settings - C, R and W tickets - This can change in the middle of the program
0. Exit

User can select any of these option in any order, any no. of times until option 0
to terminates
When program terminates, it should print all reservation details - How may C,
R and W. 

