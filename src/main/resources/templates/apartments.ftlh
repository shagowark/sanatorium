<#import "parts/common-base.ftlh" as base>

<@base.page>
    <p><a href="/home">Основная страница</a></p>
    <#list apartments as apartment>
        <div>
            <p>${apartment?index + 1}) Цена за ночь: ${apartment.priceOneNight} Кол-во
                комнат:${apartment.getRoomsNumber()}</p>
        </div>
    </#list>
</@base.page>
