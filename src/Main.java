import java.util.ArrayList;
import javax.swing.JOptionPane;
//The Main class holds the main method, which runs most of the program. This class doesn't contain any other methods.
public class Main
{
	//the main method runs the code and also acts as the controller class
	public static void main(String[] args)
	{
		boolean[] room1Booking = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
		boolean[] room2Booking = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
		boolean[] room3Booking = new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true};
		Room[] hotel = new Room[] {new Room(1, 10, "low", room1Booking), new Room(2, 20, "medium", room2Booking), new Room(3, 30, "high", room3Booking)};
		hotel[0].allAvailable = true;
		hotel[1].allAvailable = true;
		hotel[2].allAvailable = true;
		boolean works = false;
		try
		{
			int totalToBePayed = 0;
			
			boolean runLoop = true;
			
			while (runLoop)
			{
				String[] mainMenuOptions = new String[] {"book a room", "view all available rooms", "view all booked rooms"};
				Object mainMenuOptionSelected = JOptionPane.showInputDialog(null, "total amount payed: $" + totalToBePayed + ".00\n" + "please select an option", "hotel program", 1, null, mainMenuOptions, 0);
				if (mainMenuOptionSelected == "book a room")
				{
					
					int roomNumberToBeBooked = Integer.parseInt(JOptionPane.showInputDialog(null, "please input the the room number of\nthe room you want to book (1, 2, or 3)"));
					
					int startDate = Integer.parseInt(JOptionPane.showInputDialog(null, "please input the start date\n(a number between 1 and 31)"));
					int endDate = Integer.parseInt(JOptionPane.showInputDialog(null, "please input the end date\n(a number between 1 and 31)"));
					
					int daysTaken = 0;
					for (int i = startDate - 1; i < endDate - 1; i++)
					{
						if (hotel[roomNumberToBeBooked - 1].daysAvailable[i] == false)
						{
							daysTaken++;
						}
						else{}
					}
					
					if (daysTaken > 0)
					{
						JOptionPane.showMessageDialog(null, "at least one of the days you tried\nto book are already taken for this room");
					}
					else
					{
						hotel[roomNumberToBeBooked - 1].bookRoom(startDate, endDate);
						JOptionPane.showMessageDialog(null, "you booked room " + roomNumberToBeBooked + ", which is a " + hotel[roomNumberToBeBooked-1].getRoomLevel() + " level room, for $" + hotel[roomNumberToBeBooked-1].getRoomPrice());
						hotel[roomNumberToBeBooked - 1].allAvailable = false;
						totalToBePayed += hotel[roomNumberToBeBooked - 1].getRoomPrice();
					}
				}
				else if (mainMenuOptionSelected == "view all available rooms")
				{
					String roomsAvailable = "";
					for (int i = 0; i < hotel.length; i++)
					{
						if (hotel[i].allAvailable)
						{
							roomsAvailable += hotel[i].roomNumber + " ";
						}
					}
					JOptionPane.showMessageDialog(null, "the room numbers available are " + roomsAvailable);
				}
				else if (mainMenuOptionSelected == "view all booked rooms")
				{
					String roomsBooked = "";
					for (int i = 0; i < hotel.length; i++)
					{
						if (!hotel[i].allAvailable)
						{
							roomsBooked += hotel[i].roomNumber + " ";
						}
					}
					JOptionPane.showMessageDialog(null, "the room numbers booked are " + roomsBooked);
				}
				else
				{
					runLoop = false;
				}	
			}
			
			works = true;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, e);
		}
	}
}
