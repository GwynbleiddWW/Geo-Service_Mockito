package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    void byIpCountryUsaAndOthers() {
        //given
        GeoServiceImpl geoService = Mockito.spy(GeoServiceImpl.class);
        //when
        geoService.byIp("96.12.111.901");
        //then
        assertEquals(Country.USA, geoService.byIp("96.12.111.901").getCountry());
        System.out.println("Test \"byIpCountryUsaAndOthers\" completed");
    }
}