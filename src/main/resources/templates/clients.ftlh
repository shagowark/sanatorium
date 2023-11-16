<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Clients</title>
</head>
<body>
<b>Добавить клиента</b>
<form action="/clients/create" method="post">
    <p><label>Фамилия <input type="text" name="lastName"></label></p>
    <p><label>Имя: <input type="text" name="firstName"></label></p>
    <p><label>Отчество: <input type="text" name="middleName"></label></p>
    <p><label>Возраст: <input type="number" name="age"></label></p>
    <p><label>Паспортные данные (серия+номер слитно): <input type="number" name="passport"></label></p>
    <p><label><input type="submit" value="Добавить"></label></p>
</form>
<b>Список клиентов</b>
<#list clients as client>
    <div>
        <p><a href="/clients/show/${client.id}"> ${client?index + 1}) ${client.lastName} ${client.firstName} ${client.middleName} ${client.age}</a></p>
    </div>
</#list>
</body>
</html>