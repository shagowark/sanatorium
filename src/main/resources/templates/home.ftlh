<#import "parts/common-base.ftlh" as base>

<@base.page>
<body>
<p><a href="/clients">Клиенты</a></p>
<p><a href="/apartments">Жилые комнаты</a></p>
<p><a href="/medical-rooms">Медицинские кабинеты</a></p>
<p><a href="/procedures">Процедуры</a></p>
<p><a href="/staff">Персонал</a></p>
<p><a href="/apartment-bookings">Бронь номеров</a></p>
<p><a href="/medical-room-bookings">Бронь медицинских кабинетов</a></p>
<br>
<p><a href="/users">Панель администратора</a></p>

<br>

<form action="/logout" method="post">
    <input type="submit" value="Выйти из аккаунта">
    <input type="hidden" name="_csrf" value="${_csrf.token}">
</form>
</@base.page>