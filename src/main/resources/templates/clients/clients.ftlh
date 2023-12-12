<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2>Клиенты</h2>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить клиента</b>
    <form action="/clients/create" method="post">
        <p><label>Фамилия: <input type="text" name="lastName" required></label></p>
        <p><label>Имя: <input type="text" name="firstName" required></label></p>
        <p><label>Отчество: <input type="text" name="middleName" required></label></p>
        <p><label>Возраст: <input type="number" name="age" required></label></p>
        <p><label>Паспортные данные (серия+номер слитно): <input type="number" name="passport" required></label></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <hr>
    <b>Искать клиента</b>
    <form action="/clients" method="get">
        <p><label>ID: <input type="text" name="id"></label></p>
        <p><label>Фамилия: <input type="text" name="lastName"></label></p>
        <p><label>Имя: <input type="text" name="firstName"></label></p>
        <p><label>Отчество: <input type="text" name="middleName"></label></p>
        <p><label>Возраст: <input type="number" name="age"></label></p>
        <p><label>Паспортные данные (серия+номер слитно): <input type="number" name="passport"></label></p>
        <p><label><input type="submit" value="Искать"></label></p>
    </form>
    <b>Список клиентов</b>
    <p>Всего записей в таблице: ${totalClientsNumber}</p>
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
                <td><a href="/clients/${client.id}">${client.id}</a></td>
                <td>${client.lastName}</td>
                <td>${client.firstName}</td>
                <td>${client.middleName}</td>
                <td>${client.age}</td>
                <td>${client.passport?c}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>