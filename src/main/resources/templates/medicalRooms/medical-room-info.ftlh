<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/medical-rooms">Медицинские кабинеты</a></p>
    <form action="/medical-rooms/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${medicalRoom.id}" readonly required></label></p>
        <p><label>Кол-во комнат: <input type="text" name="number" value="${medicalRoom.number?c}" required></label></p>
        <p><label>Цена за ночь: <input type="text" name="name" value="${medicalRoom.name}" required></label></p>
        <p><label><input type="submit" value="Сохранить"></label></p>
    </form>
    <form action="/medical-rooms/delete/${medicalRoom.id}" method="post">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>