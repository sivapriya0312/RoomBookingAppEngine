<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Room Details</title>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
function rooms(){
	 var roomNumber = document.getElementById("roomNumber").value;
	  var roomType = document.getElementById("roomType").value;
	  var capacity = document.getElementById("capacity").value;
	  var status = document.getElementById("status").value;

	  var myData = {
			"roomType": roomType,
	      "roomNumber": roomNumber,
	      "capacity": capacity,
	      "status": status
	  };
	  $.ajax({
	    type: "POST",
	    url: "https://sivapriya-dot-internship-full.uc.r.appspot.com/booking",
	    data: JSON.stringify(myData),
	    contentType: "application/json; charset=utf-8",
	    dataType: "json"
	  }); 
	window.location.replace("https://sivapriya-dot-internship-full.uc.r.appspot.com/booking");
}

function booked(){
      var roomNo = document.getElementById("roomNo").value;
	  var roomType1 = document.getElementById("roomType1").value;
	  var roomCapacity = document.getElementById("roomCapacity").value;
	  var bookingId = document.getElementById("bookingId").value;

	  var data = {
		"roomType1": roomType1,
	     "roomNo": roomNo,
	      "roomCapacity": roomCapacity,
	      "bookingId": bookingId
	  };
	  $.ajax({
	    type: "POST",
	    url: "https://sivapriya-dot-internship-full.uc.r.appspot.com/selection",
	    contentType: "application/json; charset=utf-8",
	    data:JSON.stringify(data),
	    dataType: "json"
	  });
	window.location.replace("https://sivapriya-dot-internship-full.uc.r.appspot.com/selection");
}

</script>
</head>
<body>

<h1>Room Details</h1>
<label style=font-family:verdana>Room Number </label>
<input type="text" id="roomNumber" name="roomNumber"/><br/><br/> 
<label style=font-family:verdana>Room Type</label>
<input type="text" id="roomType" name="roomType"/><br/><br/>
<label style=font-family:verdana>Capacity</label>
<input type="text" id="capacity" name="capacity"/><br/><br/>
<label style=font-family:verdana>Status</label>
<input type="text" id="status" name="status"/><br/><br/>
<input type="button" value="Add" onclick="rooms()"/>

<h1>Room Booking</h1>
<label style=font-family:verdana>Room Number</label>
<input type="text" name="roomNo" id="roomNo"/><br/><br/>
<label style=font-family:verdana>Room Type</label>
<input type="text" name="roomType1" id="roomType1"/><br/><br/>
<label style=font-family:verdana>Capacity</label>
<input type="text" name="roomCapacity" id="roomCapacity"/><br/><br/>
<label style=font-family:verdana>Booking Id</label>
<input type="text" name="bookingId" id="bookingId"/><br/><br/>
<input type="button" value="submit" onclick="booked()"/>

</body>
</html>