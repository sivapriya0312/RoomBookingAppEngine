package roomBooking;

public class RoomList {
	private String roomNumber;
	private String roomType;
	private int capacity;
	private String status;

	public RoomList(String roomNumber, String roomType, int capacity, String status) {
		this.roomNumber = roomNumber;
		this.roomType = roomType;
		this.capacity = capacity;
		this.status = status;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public String getRoomType() {
		return roomType;
	}

	public double getCapacity() {
		return capacity;
	}

	public String getStatus() {
		return status;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return String.format("RoomList{roomNumber = '%s', roomType = '%s',capacity='%d',status='%s'}", roomNumber,
				roomType, capacity, status);
	}

}

