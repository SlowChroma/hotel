import java.util.ArrayList;
//The room class is what represents a room object
public class Room {
	
	int roomNumber;
	int roomPrice;
	String roomLevel;
	boolean[] daysAvailable;
	boolean allAvailable;
	//the room constructor, which sets the room number, price, level, and a boolean array of the days that it is avilable
	public Room(int roomNumber, int roomPrice, String roomLevel, boolean[] daysAvailable)
	{
		this.roomNumber = roomNumber;
		this.roomPrice = roomPrice;
		this.roomLevel = roomLevel;
		this.daysAvailable = daysAvailable;
	}
	//this method returns the room number
	public int getRoomNumber()
	{
		return roomNumber;
	}
	//this method returns the room price
	public int getRoomPrice()
	{
		return roomPrice;
	}
	//this method returns the room level
	public String getRoomLevel()
	{
		return roomLevel;
	}
	//this method allows one to book a room for a certain amount of days
	public void bookRoom(int startDate, int endDate)
	{
		for (int i = startDate - 1; i <= endDate; i++)
		{
			daysAvailable[i] = false;
		}
	}

}
