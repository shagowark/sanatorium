<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить бронь комнаты</b>
    <form action="/apartment-bookings/create" method="post">
        <p><label>ID комнаты: <input type="text" name="residentialApartment"></label></p>
        <p><label>ID клиента: <input type="text" name="client"></label></p>
        <p><label>Дата заселения: <input type="datetime-local" name="arrivalDateTime"></label></p>
        <p><label>Дата выселения: <input type="datetime-local" name="departureDateTime"></label></p>
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список броней</b>

    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">ID комнаты</th>
            <th scope="col">ID клиента</th>
            <th scope="col">Дата заселения</th>
            <th scope="col">Дата выселения</th>
        </tr>
        <#foreach apartmentBooking in apartmentBookings>
            <tr>
                <td><a href="/apartment-bookings/${apartmentBooking.id}">${apartmentBooking.id}</a></td>
                <td>${apartmentBooking.residentialApartment.id}</td>
                <td>${apartmentBooking.client.id}</td>
                <td>${apartmentBooking.getFormattedArrivalDateTime()}</td>
                <td>${apartmentBooking.getFormattedDepartureDateTime()}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>