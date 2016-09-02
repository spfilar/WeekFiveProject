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
		<title>Update a Park's Info</title>
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
		<p id="list">Update National Park</p>
		<% 
			DAO.readFromTable();
		%>
		<div id="thedropdown">
			<form id="updating" action="updateToTable" method="post">
				<div class="update-group">
					<select id="box" name="updatename">
						<option selected="selected" style="display:none">Select a Park to Update</option>
					<%		
						for (int i = 0; i < DAO.myParks.size(); i++) {
							ParkInfo readToJSP = DAO.myParks.get(i);
					%>
						<option id="dropthebox"><%=readToJSP.getParkName()%></option>
					<% }
						DAO.myParks.clear();
					%>
					</select>
				</div>	
				<div class="update-group">
					City/County:
					<input type="text" class="form-control" name="updatecity">
				</div><br>
				<div class="update-group">
					State:
					<input type="text" class="form-control" name="updatestate">
				</div><br>
				<div class="update-group">
					Year Established:
					<input type="text" class="form-control" name="updateyear">
				</div><br>
				<div class="update-group">
					Entry Fee:
					<input type="text" class="form-control" name="updatefee">
				</div><br>
				<button type="submit" value="Submit" class="btn btn-primary pull-right">Submit</button>
			</form>
		</div>
	</body>
</html>