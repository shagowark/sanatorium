<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Medical rooms</title>
</head>
<body>
<#list medicalRooms as room>
    <p>${room?index + 1}) ${room.number} ${room.name}</p>
</#list>
</body>
</html>