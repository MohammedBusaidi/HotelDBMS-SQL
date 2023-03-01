public class Main {

	public static void main(String[] args) {
		
		HotelTable newHotel = new HotelTable();
		RoomTypeTable newRoomType = new RoomTypeTable();
		RoomsTable newRoom = new RoomsTable();
		GuestTable newGuest = new GuestTable();
		EmployeeTypeTable newEmployeeType = new EmployeeTypeTable();
		EmployeesTable newEmployee = new EmployeesTable();

		newHotel.createHotelTable();
		newRoomType.createRoomTypeTable();
		newRoom.createRoomsTable();
		newGuest.createGuestTable();
		newEmployeeType.createEmployeeTypeTable();
		newEmployee.createEmployeesTable();
	}

}
