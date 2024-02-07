package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDate;

class ZodiacUtilsTest {

    @MethodSource("getSignNameTestData")
    @ParameterizedTest
    void getSignName( LocalDate beginDate, LocalDate endDate, String signName) {
        for (LocalDate date = beginDate; !date.isAfter(endDate); date = date.plusDays(1)){
            System.out.println(signName+" "+beginDate+" "+endDate+" ? "+date);
            Assertions.assertEquals(signName, ZodiacUtils.getSignName(date.getDayOfMonth(), date.getMonthValue()));
        }
    }
    private static Object[][] getSignNameTestData(){
            return new Object[][]{
                    {LocalDate.parse("2023-03-21"), LocalDate.parse("2023-04-20"), "Овен"},
                    {LocalDate.parse("2023-04-21"), LocalDate.parse("2023-05-21"), "Телец"},
                    {LocalDate.parse("2023-05-22"), LocalDate.parse("2023-06-21"), "Близнецы"},
                    {LocalDate.parse("2023-06-22"), LocalDate.parse("2023-07-22"), "Рак"},
                    {LocalDate.parse("2023-07-23"), LocalDate.parse("2023-08-21"), "Лев"},
                    {LocalDate.parse("2023-08-22"), LocalDate.parse("2023-09-23"), "Дева"},
                    {LocalDate.parse("2023-09-24"), LocalDate.parse("2023-10-23"), "Весы"},
                    {LocalDate.parse("2023-10-24"), LocalDate.parse("2023-11-22"), "Скорпион"},
                    {LocalDate.parse("2023-11-23"), LocalDate.parse("2023-12-22"), "Стрелец"},
                    {LocalDate.parse("2023-12-23"), LocalDate.parse("2024-01-20"), "Козерог"},
                    {LocalDate.parse("2024-01-21"), LocalDate.parse("2024-02-19"), "Водолей"},
                    {LocalDate.parse("2024-02-20"), LocalDate.parse("2024-03-20"), "Рыбы"}
            };
    }


}