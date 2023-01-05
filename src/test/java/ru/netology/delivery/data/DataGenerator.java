package ru.netology.delivery.data;

import com.github.javafaker.CreditCardType;
import com.github.javafaker.Faker;
import lombok.Value;
import lombok.val;
//import lombok.var;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Random;

public class DataGenerator {
    private DataGenerator() {
    }
//    public static class Registration {
//        private Registration() {
//
//        }
//
//        public static RegistrationByCardInfo generateByCard(String locale) {
//            Faker faker = new Faker(new Locale(locale));
//            return new RegistrationByCardInfo(
//                    faker.name().fullName(),
//                    faker.finance().creditCard(CreditCardType.MASTERCARD),
//                    LocalDate.now().plusYears(1)
//            );
//        }
//    }
//
//    @Value
//    public static class RegistrationByCardInfo {
//        String name;
//        String card;
//        LocalDate cardExpire;
//
//    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

    public static String generateCity(String locale) {
        var cities = new String[]{ "Кострома", "Москва", "Санкт-Петербург", "Калининград", "Иваново", "Мурманск",
                "Пермь", "Пенза", "Хабаровск", "Казань"
        };
        return cities[new Random().nextInt(cities.length)];
    }

    public static String generateName(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String name = faker.name().fullName();
        return name;
    }

    public static String generatePhone(String locale) {
        Faker faker = new Faker(new Locale(locale));
        String phone = faker.phoneNumber().phoneNumber();
        return phone;
    }

    public static class Registration {
        private Registration() {
        }

        public static UserInfo generateUser(String locale) {
            UserInfo user = new UserInfo(generateCity("ru"), generateName("ru"), generatePhone("ru"));
            return user;
        }
    }

    @Value
    public static class UserInfo {
        String city;
        String name;
        String phone;
    }
}