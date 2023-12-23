<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <div style="text-align: center">
        <h1>Во время работы произошла ошибка!</h1>
        <hr>
        <br>
        <br>
        <h3>Статус ошибки:</h3>
        <p>${status.toString()}</p>
        <h3>Текст ошибки: </h3>
        <p>${errorMessage}</p>
        <p><a href="/home">Основная страница</a></p>
    </div>
</@base.page>