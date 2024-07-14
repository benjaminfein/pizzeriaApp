<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Benny's pizza</title>
    <#--        <link href="style/my.css" rel="stylesheet">-->
</head>
<body>
<h1>Pizza forever!</h1><hr>
<h4>Similar product information</h4>
<b>Name of the pizza: </b>${product.title}<br>
<b>Description of the pizza: </b>${product.description}<br>
<b>Price of the pizza: </b>${product.price} $<br>
<hr>
<h3>Delete pizza</h3>
<form action="/product/delete/${product.id}" method="post">
    <input type="submit" value="Delete pizza">
</form>
</body>
</html>