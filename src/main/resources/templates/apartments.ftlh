<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Apartments</title>
</head>
<body>
<#list apartments as apartment>
<div>
    <p>${apartment?index + 1}) Цена за ночь: ${apartment.priceOneNight} Кол-во комнат:${apartment.roomsNumber}</p>
</div>
</#list>
</body>
</html>