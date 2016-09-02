<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.nationalparks.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		<link rel="stylesheet" type="text/css" href="styles.css">
		<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
		<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
		<link href="https://fonts.googleapis.com/css?family=Raleway" rel="stylesheet">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Delete a Park</title>
	</head>
	<body>
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container-fluid">
				<ul class="nav navbar-nav">
					<li class="home"><a href="index.html"><span class="glyphicon glyphicon-tree-conifer"></span> Home</a></li>
					<li class="dropdown">
						<a class="dropdown-toggle" data-toggle="dropdown" href="#"><span class="glyphicon glyphicon-menu-hamburger"></span> National Parks</a>
						<ul class="dropdown-menu">
							<li><a href="readTable.jsp"><span class="glyphicon glyphicon-map-marker"></span> View List</a></li>
							<li><a href="addToTable.html"><span class="glyphicon glyphicon-pushpin"></span> Add National Park</a></li>
							<li><a href="updateToTable.jsp"><span class="glyphicon glyphicon-ok-circle"></span> Update National Park</a></li>
							<li><a href="deleteToTable.jsp"><span class="glyphicon glyphicon-trash"></span> Remove National Park</a></li>					
						</ul>
					</li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="images/ListOfParks.pdf"><span class="glyphicon glyphicon-grain"></span> About</a></li>
					<li><a href="mailto:stuart.filar@gmail.com"><span class="glyphicon glyphicon-fire"></span> Contact</a></li>
				</ul>
			</div>
		</nav>
		<p id="list">Delete National Park</p>
		<% 
			DAO.readFromTable();
		%>
		<div id="thedropdown">
			<form id="deleting" action="deleteToTable" method="post">
				<select id="box" name="deletename" onchange="this.form.submit()">
					<option selected="selected" style="display:none">Select a Park to Delete</option>
				<%		
					for (int i = 0; i < DAO.myParks.size(); i++) {
						ParkInfo readToJSP = DAO.myParks.get(i);
				%>
					<option id="dropthebox"><%=readToJSP.getParkName()%></option>
				<% }

				DAO.myParks.clear();
				
				%>
				</select>
			</form>
		</div>
	</body>
</html>