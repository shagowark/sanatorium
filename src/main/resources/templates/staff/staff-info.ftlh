<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/staff">Персонал</a></p>
    <form action="/staff/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${staff.id}" readonly required></label></p>
        <p><label>Фамилия: <input type="text" name="lastName" value="${staff.lastName}" required></label></p>
        <p><label>Имя: <input type="text" name="firstName" value="${staff.firstName}" required></label></p>
        <p><label>Отчество: <input type="text" name="middleName" value="${staff.middleName}" required></label></p>
        <p><label>Профессия: <input type="text" name="profession" value="${staff.profession}" required></label></p>
        <p><input type="submit" value="Сохранить"></p>
    </form>
    <form action="/staff/delete/${staff.id}" method="post">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>