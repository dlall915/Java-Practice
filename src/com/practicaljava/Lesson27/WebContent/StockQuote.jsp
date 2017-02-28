<%@page import="com.practicaljava.lesson27.StockPriceGenerator"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<!-- This page is triggered when the user hits Submit -->

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Stock Quote</title>
</head>
<body>
	<jsp:useBean id="stock" class="com.practicaljava.lesson27.Stock" />
  	<jsp:setProperty property="*" name="stock" />
  	<%!StockPriceGenerator stockServer = new StockPriceGenerator();%>
	
   	Symbol: <%=stock.getSymbol()%>
   	Price: <%=stockServer.getPrice(stock.getSymbol())%>
</body>
</html>