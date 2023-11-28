<#macro page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset="UTF-8">
        <title>Sanatorium</title>
        <style>
            /* Chrome, Safari, Edge, Opera */
            input::-webkit-outer-spin-button,
            input::-webkit-inner-spin-button {
                -webkit-appearance: none;
                margin: 0;
            }

            /* Firefox */
            input[type=number] {
                -moz-appearance: textfield;
            }
        </style>
    </head>
    <body>
    <#nested>
    </body>
    </html>
</#macro>

<#macro login path button>
<form action="${path}" method="post">
    <div class="form-group">
        <label> Имя пользователя:</label>
        <input class="form-control" type="text" name="username"/>
    </div>
    <div class="form-group">
        <label> Пароль: </label>
        <input class="form-control" type="password" name="password"/>
    </div>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    <div><input type="submit" value=${button}></div>
</form>
</#macro>