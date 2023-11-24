<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/apartments">Жилые комнаты</a></p>
    <form action="/apartments/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${apartment.id}" readonly required></label></p>
        <p><label>Кол-во комнат: <input type="text" name="roomsNumber" value="${apartment.roomsNumber?c}" required></label></p>
        <p><label>Цена за ночь: <input type="text" name="priceOneNight" value="${apartment.priceOneNight?c}" required></label></p>
        <p><label><input type="submit" value="Сохранить"></label></p>
    </form>
    <form action="/apartments/delete/${apartment.id}" method="post">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>