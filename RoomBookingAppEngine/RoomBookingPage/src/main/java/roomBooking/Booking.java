package roomBooking;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

public class Booking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	List<RoomList> rooms = new ArrayList<>();
	List<RoomSelection> booking = new ArrayList<>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String url = request.getRequestURL().toString();

		if (url.equals("https://sivapriya-dot-internship-full.uc.r.appspot.com/booking")) {
			String roomNumber = request.getParameter("roomNumber");
			if (roomNumber == null) {
				response.setContentType("application/json");
				response.getWriter().println(rooms.toString());
			} else {
				for (RoomList roomlist : rooms) {
					if (roomlist.getRoomNumber().equals(roomNumber)) {
						response.setContentType("application/json");
						response.getWriter().println(roomlist.toString());
					}
				}
			}
		} else if (url.equals("https://sivapriya-dot-internship-full.uc.r.appspot.com/selection")) {
			String roomNo = request.getParameter("roomNo");

			if (roomNo == null) {
				response.setContentType("application/json");
				response.getWriter().println(booking.toString());
			} else {
				for (RoomSelection roomselect : booking) {
					if (roomselect.getRoomNo().equals(roomNo)) {
						response.setContentType("application/json");
						response.getWriter().println(roomselect.toString());
					}
				}
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String url = request.getRequestURL().toString();

		if (url.equals("https://sivapriya-dot-internship-full.uc.r.appspot.com/booking")) {
			BufferedReader buffReader = request.getReader();
			StringBuilder strbuild = new StringBuilder();
			String newline;
			while ((newline = buffReader.readLine()) != null) {
				strbuild.append(newline);
			}

			String json = strbuild.toString();
			try {
				JSONObject jsonObject = new JSONObject(json);
				String roomType = jsonObject.getString("roomType");
				String roomNumber = jsonObject.getString("roomNumber");
				int capacity = jsonObject.getInt("capacity");
				String status = jsonObject.getString("status");
				RoomList lis = new RoomList(roomNumber, roomType, capacity, status);
				rooms.add(lis);
			} catch (JSONException e) {
				System.out.println(e);
			}
		} else if (url.equals("https://sivapriya-dot-internship-full.uc.r.appspot.com/selection")) {
			BufferedReader buffReader = request.getReader();
			StringBuilder strbuild = new StringBuilder();
			String newline;
			while ((newline = buffReader.readLine()) != null) {
				strbuild.append(newline);
			}

			String json = strbuild.toString();
			try {
				JSONObject jsonObject = new JSONObject(json);
				String roomType1 = jsonObject.getString("roomType1");
				String roomNo = jsonObject.getString("roomNo");
				int roomCapacity = jsonObject.getInt("roomCapacity");
				String bookingId = jsonObject.getString("bookingId");
				RoomSelection lis2 = new RoomSelection(roomNo, roomCapacity, roomType1, bookingId);
				booking.add(lis2);

				for (RoomList room : rooms) {

					if (roomNo.equals(room.getRoomNumber())) {
						room.setStatus("Not Available");

//						int availability = (int) room.getCapacity();
//						response.getWriter()
//								.println("You have Booked : " + roomCapacity + " Total Capacity : " + availability);
					}
				}
			} catch (JSONException e) {
				System.out.println(e);
			}

		}

//		if (url.equals("http://localhost:8080/RoomBooking/booking")) {
//			String roomType = request.getParameter("roomType");
//			String roomNumber = request.getParameter("roomNumber");
//			int capacity = Integer.parseInt(request.getParameter("capacity"));
//			String status = request.getParameter("status");
//			RoomList lis = new RoomList(roomNumber, roomType, capacity, status);
//			rooms.add(lis);
//		} else if (url.equals("http://localhost:8080/RoomBooking/selection")) {
//			String roomNo = request.getParameter("roomNo");
//			int roomCapacity = Integer.parseInt(request.getParameter("roomCapacity"));
//			String roomType = request.getParameter("roomType");
//			String bookingId = request.getParameter("bookingId");
//			RoomSelection lis2 = new RoomSelection(roomNo, roomCapacity, roomType, bookingId);
//			booking.add(lis2);
//
//			for (RoomList room : rooms) {
//				if (roomNo.equals(room.getRoomNumber())) {
//					room.setStatus("Not Available");
//					int availability = (int) room.getCapacity();
//					response.getWriter().println("You have Booked : " + roomCapacity +" Total Capacity : " + availability);
//				}
//			}
//		}
	}
}
