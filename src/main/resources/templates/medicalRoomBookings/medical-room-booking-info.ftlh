<#import "../parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <p><a href="/medical-room-bookings">Брони кабинетов</a></p>
    <form action="/medical-room-bookings/put" method="post">
        <p><label>ID: <input type="text" name="id" value="${medicalRoomBooking.id}" readonly required></label></p>
        <p><label>ID кабинета: <input type="text" name="medicalRoom" value="${medicalRoomBooking.medicalRoom.id}" required></label></p>
        <p><label>ID процедуры: <input type="text" name="procedure" value="${medicalRoomBooking.procedure.id}" required></label></p>
        <p><label>ID персонала: <input type="text" name="staff" value="${medicalRoomBooking.staff.id}" required></label></p>
        <p><label>ID клиента: <input type="text" name="client" value="${medicalRoomBooking.client.id}" required></label></p>
        <p><label>Дата начала: <input type="datetime-local" name="startDateTime" value="${medicalRoomBooking.startDateTime.withSecond(0).withNano(0)}" required></label></p>
        <p><label>Дата конца: <input type="datetime-local" name="endDateTime" value="${medicalRoomBooking.endDateTime.withSecond(0).withNano(0)}" required></label></p>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><input type="submit" value="Сохранить"></p>
    </form>
    <form action="/medical-room-bookings/delete/${medicalRoomBooking.id}" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <p><input type="submit" value="Удалить"></p>
    </form>
</@base.page>