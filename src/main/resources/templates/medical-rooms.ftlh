<#import "parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <#list medicalRooms as room>
        <p>${room?index + 1}) ${room.number} ${room.name}</p>
    </#list>
</@base.page>