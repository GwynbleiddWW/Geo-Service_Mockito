package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Matchers;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

class MessageSenderImplTest {

    @Test
    void sendRusIfIpRus() {
        //given
        GeoService geoServiceRu = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceRu.byIp("172.123.12.19")).thenReturn(new Location("Moscow", Country.RUSSIA, null, 0));

        LocalizationService localizationServiceRu = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceRu.locale(Country.RUSSIA)).thenReturn("Добро пожаловать");

        //when
        MessageSender messageSenderRu = new MessageSenderImpl(geoServiceRu, localizationServiceRu);
        Map<String, String> headersRu = new HashMap<String, String>();
        System.out.println("Russia");
        headersRu.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        messageSenderRu.send(headersRu);

        //then
       assertEquals("Добро пожаловать", messageSenderRu.send(headersRu));
    }

    @Test
    void sendEngIfIpEng() {
        //given
        GeoService geoServiceUSA = Mockito.mock(GeoServiceImpl.class);
        Mockito.when(geoServiceUSA.byIp("96.123.12.19")).thenReturn(new Location("New York", Country.USA, " 10th Avenue", 32));

        LocalizationService localizationServiceUSA = Mockito.mock(LocalizationServiceImpl.class);
        Mockito.when(localizationServiceUSA.locale(Country.USA)).thenReturn("Welcome");

        //when
        MessageSender messageSenderUSA = new MessageSenderImpl(geoServiceUSA, localizationServiceUSA);
        Map<String, String> headersUSA = new HashMap<String, String>();
        headersUSA.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.123.12.19");
        System.out.println("USA+");
        messageSenderUSA.send(headersUSA);

        //then
        assertEquals("Welcome", messageSenderUSA.send(headersUSA));
    }
}


