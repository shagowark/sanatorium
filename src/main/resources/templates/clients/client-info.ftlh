<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/clients">Клиенты</a></p>
    <form action="/clients/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${client.id}" readonly></label></p>
        <p><label>Фамилия: <input type="text" name="lastName" value="${client.lastName}"></label></p>
        <p><label>Имя: <input type="text" name="firstName" value="${client.firstName}"></label></p>
        <p><label>Отчество: <input type="text" name="middleName" value="${client.middleName}"></label></p>
        <p><label>Возраст: <input type="number" name="age" value="${client.age}"></label></p>
        <p><label>Паспортные данные (серия+номер слитно): <input type="number" name="passport"
                                                                 value="${client.passport?c}"></label></p>
        <p><input type="submit" value="Сохранить"></p>
    </form>
    <form action="/clients/delete/${client.id}" method="post">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>