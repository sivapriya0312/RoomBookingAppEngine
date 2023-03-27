package roomBooking;

public class RoomSelection {
	private String roomNo;
	private int roomCapacity;
	private String roomType1;
	private String bookingId;

	public RoomSelection(String roomNo, int roomCapacity, String roomType1, String bookingId) {
		this.roomNo = roomNo;
		this.roomCapacity = roomCapacity;
		this.roomType1 = roomType1;
		this.bookingId = bookingId;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}

	public int getRoomCapacity() {
		return roomCapacity;
	}

	public void setRoomCapacity(int roomCapacity) {
		this.roomCapacity = roomCapacity;
	}

	public String getRoomType1() {
		return roomType1;
	}

	public void setRoomType(String roomType1) {
		this.roomType1 = roomType1;
	}

	public String getBookingId() {
		return bookingId;
	}

	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}

	public String toString() {
		return String.format("RoomSelection{roomNo = '%s', roomCapacity = %d,roomType1='%s',bookingId='%s'}", roomNo,
				roomCapacity, roomType1, bookingId);
	}

}
