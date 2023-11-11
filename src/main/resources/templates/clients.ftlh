<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
</head>
<body>
<#list clients as client>
    <div>
        <p>${client.lastName} ${client.firstName} ${client.middleName} ${client.age}</p>
    </div>
</#list>
</body>
</html>