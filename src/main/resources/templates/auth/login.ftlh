<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <h2 style="text-align: center">Вход</h2>
    <br>
    <div class="d-flex justify-content-center">
        <@base.login "/login" "Войти"/>
    </div>
    <hr>
    <div style="text-align: center"><a href="/registration">Регистрация</a></div>
</@base.page>