<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/apartment-bookings">Брони комнат</a></p>
    <form action="/apartment-bookings/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${apartmentBooking.id}" readonly required></label></p>
        <p><label>ID комнаты: <input type="text" name="residentialApartment" value="${apartmentBooking.residentialApartment.id}" required></label></p>
        <p><label>ID клиента: <input type="text" name="client" value="${apartmentBooking.client.id}" required></label></p>
        <p><label>Дата заезда: <input type="datetime-local" name="arrivalDateTime" value="${apartmentBooking.arrivalDateTime.withSecond(0).withNano(0)}" required></label></p>
        <p><label>Дата выезда: <input type="datetime-local" name="departureDateTime" value="${apartmentBooking.departureDateTime.withSecond(0).withNano(0)}" required></label></p>
        <p><input type="submit" value="Сохранить"></p>
    </form>
    <form action="/apartment-bookings/delete/${apartmentBooking.id}" method="post">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>