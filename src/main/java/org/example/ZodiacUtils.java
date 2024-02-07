package org.example;

import java.time.LocalDate;

public class ZodiacUtils {

    public static String getSignName(int day, int month){
        try {LocalDate.parse(String.format("2024-%02d-%02d", month, day));}
        catch (Exception e) {throw new IllegalArgumentException("Incorrect day or month");}

        if ((month==3 && day >= 21) || (month==4 && day <= 20)) {
            return "Овен";
        }

        if ((month==4 && day >= 21) || (month==5 && day <= 21)) {
            return "Телец";
        }

        if ((month==5 && day >= 22) || (month==6 && day <= 21)) {
            return "Близнецы";
        }

        if ((month==6 && day >= 22) || (month==7 && day <= 22)) {
            return "Рак";
        }

        if ((month==7 && day >= 23) || (month==8 && day <= 21)) {
            return "Лев";
        }

        if ((month==8 && day >= 22) || (month==9 && day <= 23)) {
            return "Дева";
        }

        if ((month==9 && day >= 24) || (month==10 && day <= 23)) {
            return "Весы";
        }

        if ((month==10 && day >= 24) || (month==11 && day <= 22)) {
            return "Скорпион";
        }

        if ((month==11 && day >= 23) || (month==12 && day <= 22)) {
            return "Стрелец";
        }

        if ((month==12 && day >= 23) || (month==1 && day <= 20)) {
            return "Козерог";
        }

        if ((month==1 && day >= 21) || (month==2 && day <= 19)) {
            return "Водолей";
        }

        if ((month==2 && day >= 20) || (month==3 && day <= 20)) {
            return "Рыбы";
        }

        throw new IllegalArgumentException("Month:" + month + "Day:" + day);
    }

  /*  public static void main(String[] args) throws Exception {
        System.setOut(new PrintStream("code.txt"));

        String testCodeTemplate = Files.readString(Paths.get("templates.code.txt"));

        YearMonth yearMonth = YearMonth.of(2023, Month.MARCH );
        List<String> lines = Files.readAllLines(Paths.get("data.txt"));
        for (String line : lines){
            String signName = line.substring(0, line.indexOf(":"));

            String[]  lineItems = line.split(" ");
            //System.out.println(Arrays.toString(lineItems));
            LocalDate beginDate = LocalDate.parse(yearMonth +"-"+lineItems[1]);
            yearMonth = yearMonth.plusMonths(1);
            LocalDate endDate = LocalDate.parse(yearMonth +"-"+lineItems[4]);

            String testCode = testCodeTemplate
                    .replace("{bm}", String.valueOf(beginDate.getMonthValue()))
                    .replace("{bd}", String.valueOf(beginDate.getDayOfMonth()))
                    .replace("{em}", String.valueOf(endDate.getMonthValue()))
                    .replace("{ed}", String.valueOf(endDate.getDayOfMonth()))
                    .replace("{sn}", signName);


            System.out.println(testCode);
            System.out.println();
        }
    }*/
}
