<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Mobile Data</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f0f0f0;
    }
    form {
        background-color: #ffffff;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 300px;
        margin: 50px auto;
    }
    h2 {
        color: #4CAF50;
        text-align: center;
    }
    input[type="text"],
    input[type="number"] {
        width: 100%;
        padding: 10px;
        margin: 5px 0;
        box-sizing: border-box;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 4px;
        cursor: pointer;
        width: 100%;
    }
    input[type="submit"]:hover {
        background-color: #45a049;
    }
</style>
</head>
<body>
    <h2>Add Mobile Data</h2>
    <form action="add-mobile" method="post">
        Brand: <input type="text" name="brand" /><br/>
        Model: <input type="text" name="model" /><br/>
        Processor: <input type="text" name="processor" /><br/>
        Battery (mAh): <input type="number" name="batteryMah" /><br/>
        Camera (MP): <input type="number" name="cameraMegaPixel" /><br/>
        Price: <input type="number" step="0.01" name="price" /><br/>
        <input type="submit" value="Submit" />
    </form>
</body>
</html>
