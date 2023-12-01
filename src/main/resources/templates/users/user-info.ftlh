<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2>Информация о пользователе</h2>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/users">Пользователи</a></p>

    <div class="d-flex justify-content-left">
        <form action="/users" method="post">
            <div class="form-group">
                <label> ID:</label>
                <input class="form-control" type="text" name="id" value="${usr.id}" readonly required/>
            </div>

            <div class="form-group">
                <label> Имя пользователя:</label>
                <input class="form-control" type="text" name="username" value="${usr.username}" required/>
            </div>

            <div class="form-group">
                <label> Статус активности :</label>
                <input class="form-control" type="text" name="active" value="${usr.active?string}" required/>
            </div>
            <div class="form-group">
                <label> Роли:</label>
                <#list roles as role>
                    <div>
                        <input class="form-control" type="checkbox"
                               name="roles" ${usr.roles?seq_contains(role)?string("checked", "")}
                               required/> ${role.name}
                    </div>
                </#list>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div class="form-group"><input type="submit" value="Сохранить"></div>
        </form>
    </div>
</@base.page>
