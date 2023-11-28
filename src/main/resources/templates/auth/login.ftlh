<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2 style="text-align: center">Вход</h2>
    <br>
    <div class="d-flex justify-content-center">
        <form action="/login" method="post">
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
    <hr>
    <div style="text-align: center"><a href="/registration">Регистрация</a></div>
</@base.page>