<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2>Процедуры</h2>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить процедуру</b>
    <form action="/procedures/create" method="post">
        <p><label>Название: <input type="text" name="name" required></label></p>
        <p><label>Длительность (мин.): <input type="text" name="durationMinutes" required></label></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список процедур</b>
    <p>Всего записей в таблице: ${totalProceduresNumber}</p>
    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Название</th>
            <th scope="col">Длительность (мин.)</th>
        </tr>
        <#foreach procedure in procedures>
            <tr>
                <td><a href="/procedures/${procedure.id}">${procedure.id}</a></td>
                <td>${procedure.name}</td>
                <td>${procedure.durationMinutes?c}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>