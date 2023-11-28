<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <div class=" d-flex justify-content-center">
        <h2>Регистрация</h2>
        <form action="/registration" method="post">
            <div class="form-group">
                <label> Имя пользователя:</label>
                <input class="form-control" type="text" name="username"/>
            </div>
            <div class="form-group">
                <label> Пароль: </label>
                <input class="form-control" type="password" name="password"/>
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}">
            <div><input type="submit" value="Войти"/></div>
        </form>
    </div>
</@base.page>