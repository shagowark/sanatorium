<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <b>Добавить бронь медицинского кабинета</b>
    <form action="/medical-room-bookings/create" method="post">
        <p><label>ID кабинета: <input type="text" name="medicalRoom" required></label></p>
        <p><label>ID процедуры: <input type="text" name="procedure" required></label></p>
        <p><label>ID персонала: <input type="text" name="staff" required></label></p>
        <p><label>ID клиента: <input type="text" name="client" required></label></p>
        <p><label>Дата начала: <input type="datetime-local" name="startDateTime" required></label></p>
        <p><label>Дата конца: <input type="datetime-local" name="endDateTime" required></label></p>
        <p><label><input type="submit" value="Добавить"></label></p>
    </form>
    <b>Список броней</b>

    <table class="table table-bordered">
        <tr>
            <th scope="col">ID</th>
            <th scope="col">ID кабинета</th>
            <th scope="col">ID процедуры</th>
            <th scope="col">ID персонала</th>
            <th scope="col">ID клиента</th>
            <th scope="col">Дата начала</th>
            <th scope="col">Дата конца</th>
        </tr>
        <#foreach medicalRoomBooking in medicalRoomBookings>
            <tr>
                <td><a href="/medical-room-bookings/${medicalRoomBooking.id}">${medicalRoomBooking.id}</a></td>
                <td>${medicalRoomBooking.medicalRoom.id}</td>
                <td>${medicalRoomBooking.procedure.id}</td>
                <td>${medicalRoomBooking.staff.id}</td>
                <td>${medicalRoomBooking.client.id}</td>
                <td>${medicalRoomBooking.getFormattedStartDateTime()}</td>
                <td>${medicalRoomBooking.getFormattedEndDateTime()}</td>
            </tr>
        </#foreach>
    </table>

</@base.page>