<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<!-- let's add tag srping:url -->
	<spring:url value="/resources/reset.css" var="reset" />
	<spring:url value="/resources/bootstrap.min.css" var="boots" />
	<spring:url value="/resources/style.css" var="style" />

	<link href="${reset}" rel="stylesheet" />
	<link href="${bootst}" rel="stylesheet" />
	<link href="${style}" rel="stylesheet" />

		<title>CWITTER</title>				
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
		
	</head>
	
	<body style="background-color:Lightblue">
			<head>
				<meta charset="UTF-8">
				<title>Twitter Client</title>
				<link href='http://fonts.googleapis.com/css?family=Quicksand:300,400' rel='stylesheet' type='text/css'>
				<link href='http://fonts.googleapis.com/css?family=Lato:400,300' rel='stylesheet' type='text/css'>
				<link href="http://netdna.bootstrapcdn.com/font-awesome/3.1.1/css/font-awesome.css" rel="stylesheet">
				
			</head>
	
	<body>
		<div>
			
				<span class="first"> 
					@Cwitter
					<span class="icon-edit new"></span>
				</span>
				<ul class="timeline">
					
					<li>
						<div class="avatar">
							<img src="">
							<div class="hover">
								<div class="icon-twitter"></div>
							</div>
						</div>
						<div class="bubble-container">
							<div class="bubble">
								<div class="retweet">
									<div class="icon-retweet"></div>
								</div>
								<form method="post" action="/addcweet">
									<div class="form-group">
										<label for="comment">post cweet:</label><br>
										<textarea class="form-control" name="text" id="text" rows="3" id="comment"></textarea>
										<input type="submit" class="btn btn-default" name="post" value="post"> 
									</div>
								</form>
							</div>
							<div>
								
							</div>
							<div class="arrow"></div>
						</div>
						
					</li>

			<%
				try
						{
						//String s=(String)session.getAttribute("userid");
						Class.forName("com.mysql.jdbc.Driver");
						String url="jdbc:mysql://localhost/cwitter";
						String username="root";
						String password="matrix24";
						String query="select * from messages";
						Connection conn=DriverManager.getConnection(url,username,password);
						Statement stmt=conn.createStatement();
						ResultSet rs=stmt.executeQuery(query);
						while(rs.next())
						{
						
					%>
					<li>
				<div class="avatar">
					<img src="">
					<div class="hover">
						<div class="icon-twitter"></div>
					</div>
				</div>
				<div class="bubble-container">
					<div class="bubble">
						<div align="left"> @<%=rs.getString("userid") %> <div> <br>
						<center>	<%=rs.getString("message") %> </center> <br>
						<div align="right">	<%=rs.getString("time") %> </div>
						<div class="over-bubble">
							<div class="icon-mail-reply action"></div>
							<div class="icon-retweet action"></div>
							<div class="icon-star"></div>
						</div>
					</div>
					<div class="arrow"></div>
				</div>
			</li>
			
			<%
			
			}
					rs.close();
					stmt.close();
					conn.close();
					}
					catch(Exception e)
					{
					e.printStackTrace();
					}
				%>		
				
			
			
		</ul>

	</div>
</body>
</html> 