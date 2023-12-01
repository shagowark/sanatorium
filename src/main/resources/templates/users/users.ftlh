<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2>Панель администратора</h2>
    <p><a href="/home">Основная страница</a></p>
    <br>
    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Имя пользователя</th>
            <th scope="col">Активность</th>
            <th scope="col">Роли</th>
        </tr>
        <#foreach usr in users>
            <tr>
                <td><a href="/users/${usr.id}">${usr.id}</a></td>
                <td>${usr.username}</td>
                <td>${usr.active?string}</td>
                <td><#list usr.roles as role>${role.name}<#sep>, </#list></td>
            </tr>
        </#foreach>
    </table>
</@base.page>