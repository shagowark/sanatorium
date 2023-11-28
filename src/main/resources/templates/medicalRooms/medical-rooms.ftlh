<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить медицинский кабинет</b>
    <form action="/medical-rooms/create" method="post">
        <p><label>Номер: <input type="text" name="number" required></label></p>
        <p><label>Название: <input type="text" name="name" required></label></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список медицинских кабинетов</b>

    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Номер</th>
            <th scope="col">Название</th>
        </tr>
        <#foreach medicalRoom in medicalRooms>
            <tr>
                <td><a href="/medical-rooms/${medicalRoom.id}">${medicalRoom.id}</a></td>
                <td>${medicalRoom.number}</td>
                <td>${medicalRoom.name}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>