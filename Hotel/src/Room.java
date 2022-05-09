import java.util.ArrayList;

public class Room {
	
	int roomNumber;
	int roomPrice;
	String roomLevel;
	boolean[] daysAvailable;
	boolean allAvailable;
	
	public Room(int roomNumber, int roomPrice, String roomLevel, boolean[] daysAvailable)
	{
		this.roomNumber = roomNumber;
		this.roomPrice = roomPrice;
		this.roomLevel = roomLevel;
		this.daysAvailable = daysAvailable;
	}
	
	public int getRoomNumber()
	{
		return roomNumber;
	}
	
	public int getRoomPrice()
	{
		return roomPrice;
	}
	
	public String getRoomLevel()
	{
		return roomLevel;
	}
	
	public void bookRoom(int startDate, int endDate)
	{
		for (int i = startDate - 1; i <= endDate; i++)
		{
			daysAvailable[i] = false;
		}
	}

}
