<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="stylesheet" type="text/css" href="css/style.css">
    <title>Ninja Gold</title>
</head>
<body>
    <div id='wrapper'>
        <header>
            <h1>The Ninja Gold Game</h1>
        </header>
        <main>
            <div class='mainhead'>
                <h4>Your Gold: ${gold}</h4>
            </div>
            <div class='mainboxes'>
                <div class='card' id='farmbox'>
                    <h3>Farm</h3>
                    <h4>Earns 10-20 Gold</h4>
                    <form action="/process_gold" id="farmform" method="post">
                        <input type="hidden" name="option" value="farm">
                        <input id="farmbutton" name="farm" type="submit" value="Find Gold!">
                    </form>
                </div>
                <div class='card' id='cavebox'>
                    <h3>Cave</h3>
                    <h4>Earns 5-10 Gold</h4>
                    <form action="/process_gold" id="caveform" method="post">
                        <input type="hidden" name="option" value="cave">
                        <input id="cavebutton" name="cave" type="submit" value="Find Gold!">
                    </form>
                </div>
                <div class='card' id='housebox'>
                    <h3>House</h3>
                    <h4>Earns 2-5 Gold</h4>
                    <form action="/process_gold" id="houseform" method="post">
                        <input type="hidden" name="option" value="house">
                        <input id="housebutton" name="house" type="submit" value="Find Gold!">
                    </form>
                </div>
                <div class='card' id='farmbox'>
                    <h3>Casino</h3>
                    <h4>Earns <span class='italic'>or takes</span> 0-50 Gold)</h4>
                    <form action="/process_gold" id="casinoform" method="post">
                        <input type="hidden" name="option" value="casino">
                        <input id="casinobutton" name="casino" type="submit" value="Find Gold!">
                    
                </div>
            </div>
        </main>
        <footer>
        	<ul>
			 <c:forEach items="${activities}" var="value">
			  <li><c:out value="${value}"/></li>
			 </c:forEach>
        	</ul>
        </footer>
    </div>
</body>
</html>