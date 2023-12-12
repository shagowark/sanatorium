<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2>Жилые комнаты</h2>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить жилую комнату</b>
    <form action="/apartments/create" method="post">
        <p><label>Кол-во комнат: <input type="text" name="roomsNumber" required></label></p>
        <p><label>Цена за ночь: <input type="text" name="priceOneNight" required></label></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список жилых комнат</b>
    <p>Всего записей в таблице: ${totalResidentialApartmentsNumber}</p>
    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Кол-во комнат</th>
            <th scope="col">Цена за ночь</th>
        </tr>
        <#foreach apartment in apartments>
            <tr>
                <td><a href="/apartments/${apartment.id}">${apartment.id}</a></td>
                <td>${apartment.roomsNumber}</td>
                <td>${apartment.priceOneNight}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>