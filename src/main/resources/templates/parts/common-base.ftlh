<#macro page>
    <!DOCTYPE html>
    <html lang="ru">
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.3.1/dist/css/bootstrap.min.css"
              integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
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
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
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
    <div class="form-group"><input type="submit" value=${button}></div>
</form>
</#macro>