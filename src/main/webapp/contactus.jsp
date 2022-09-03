<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="stylecontactUsPage.css">
	<title>Contact Us</title>
</head>

<body>
		<div class="contact">
			<h1>Contact us</h1>
			<p>Fill this from in a decent manner</p>
		</div>
		<div id="container">
			<form action="contactus" method="post">
				Enter your Name <br>
				<input type="text" name="customerName" required><br>
				Enter your E-mail <br>
				<input type="email" name="customerEmail" required><br>
				Enter message <br>
				<textarea rows="10" cols="25" name="customerMessage"></textarea><br>
				<input type="submit" value="Submit">
			</form>
		</div>
		</div>
</body>

</html>