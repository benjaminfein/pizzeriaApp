<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Benny's pizza</title>
    <#--        <link href="style/my.css" rel="stylesheet">-->
</head>
<body>
<h1>Pizza forever!</h1><hr>
<h4>All pizza making with love!</h4>
<form action="/" method="get">
    Search by name of the pizza: <input type="text" name="title"><br>
    <input type="submit" value="Search">
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} $ | <a href="/product/${product.id}">About</a></p>
    </div>
    <#else>
    <h3>
        No pizza :'(
    </h3>
</#list>
<hr>
<h3>Create your pizza!</h3>
<form action="/product/create" method="post">
    Name of the pizza: <input type="text" name="title"/><br><br>
    Description of the pizza: <input type="text" name="description"/><br><br>
    Price of the pizza: <input type="text" name="price"/><br><br>
    <input type="submit" value="Add pizza!">
</form>
</body>
</html>