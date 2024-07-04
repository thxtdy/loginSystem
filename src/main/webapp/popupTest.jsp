<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html> 
<head> 
    <title>Popup Box Example</title> 
    <style> 
        /* Styles for the popup box */ 
        .popup { 
            display: none; 
            position: fixed; 
            z-index: 1; 
            left: 0; 
            top: 0; 
            width: 100%; 
            height: 100%; 
            overflow: auto; 
            background-color: rgba(0,0,0,0.5); 
        } 
 
        .popup-content { 
            background-color: #fefefe; 
            margin: 15% auto; 
            padding: 20px; 
            border: 1px solid #888; 
            width: 80%; 
        } 
    </style> 
</head> 
<body> 
 
<h1>My Form</h1> 
 
<form action="submit.jsp" method="post"> 
    <!-- Your form fields go here --> 
    <input type="text" name="name" placeholder="Name"> 
    <input type="email" name="email" placeholder="Email"> 
    <button type="submit">Submit</button> 
</form> 
 
<div id="popup" class="popup"> 
    <div class="popup-content"> 
        <span class="close" onclick="closePopup()">&times;</span> 
        <p>This is a popup box!</p> 
    </div> 
</div> 
 
<script> 
    function openPopup() { 
        document.getElementById('popup').style.display = 'block'; 
    } 
 
    function closePopup() { 
        document.getElementById('popup').style.display = 'none'; 
    } 
</script> 
 
</body> 
</html> 