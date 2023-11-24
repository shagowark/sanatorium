<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/procedures">Процедуры</a></p>
    <form action="/procedures/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${procedure.id}" readonly required></label></p>
        <p><label>Название: <input type="text" name="name" value="${procedure.name}" required></label></p>
        <p><label>Длительность (мин.): <input type="text" name="durationMinutes" value="${procedure.durationMinutes?c}" required></label></p>
        <p><input type="submit" value="Сохранить"></p>
    </form>
    <form action="/procedures/delete/${procedure.id}" method="post">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>