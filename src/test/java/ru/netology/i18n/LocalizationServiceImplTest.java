package ru.netology.i18n;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;

import static org.junit.jupiter.api.Assertions.*;

class LocalizationServiceImplTest {

    @Test
    void localeCountryUsaAndOthers() {
        //given
        LocalizationServiceImpl localizationService = Mockito.spy(LocalizationServiceImpl.class);
        //when
        localizationService.locale(Country.GERMANY);
        //then
        assertEquals("Welcome", localizationService.locale(Country.GERMANY));
        System.out.println("Test \"localeCountryUsaAndOthers\" completed");
    }
}