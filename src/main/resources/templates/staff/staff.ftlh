<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2>Персонал</h2>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить персонал</b>
    <form action="/staff/create" method="post">
        <p><label>Фамилия: <input type="text" name="lastName" required></label></p>
        <p><label>Имя: <input type="text" name="firstName" required></label></p>
        <p><label>Отчество: <input type="text" name="middleName" required></label></p>
        <p><label>Профессия: <input type="text" name="profession" required></label></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список персонала</b>
    <p>Всего записей в таблице: ${totalStaffNumber}</p>
    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Имя</th>
            <th scope="col">Отчество</th>
            <th scope="col">Профессия</th>
        </tr>
        <#foreach staff_single in staff>
            <tr>
                <td><a href="/staff/${staff_single.id}">${staff_single.id}</a></td>
                <td>${staff_single.lastName}</td>
                <td>${staff_single.firstName}</td>
                <td>${staff_single.middleName}</td>
                <td>${staff_single.profession}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>