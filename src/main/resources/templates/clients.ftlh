<#import "parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить клиента</b>
    <form action="/clients/create" method="post">
        <p><label>Фамилия: <input type="text" name="lastName"></label></p>
        <p><label>Имя: <input type="text" name="firstName"></label></p>
        <p><label>Отчество: <input type="text" name="middleName"></label></p>
        <p><label>Возраст: <input type="number" name="age"></label></p>
        <p><label>Паспортные данные (серия+номер слитно): <input type="number" name="passport"></label></p>
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список клиентов</b>

    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">Фамилия</th>
            <th scope="col">Имя</th>
            <th scope="col">Отчество</th>
            <th scope="col">Возраст</th>
            <th scope="col">Паспортные данные</th>
        </tr>
        <#foreach client in clients>
            <tr>
                <td><a href="/clients/${client.id?c}">${client.id?c}</a></td>
                <td>${client.lastName}</td>
                <td>${client.firstName}</td>
                <td>${client.middleName}</td>
                <td>${client.age}</td>
                <td>${client.passport?c}</td>
            </tr>
        </#foreach>
    </table>

<#--<#list clients as client>-->
<#--    <div>-->
<#--        <p><a href="/clients/${client.id?c}"> ${client?index + 1}) ${client.lastName} ${client.firstName} ${client.middleName} ${client.age}</a></p>-->
<#--    </div>-->
<#--</#list>-->

</@base.page>