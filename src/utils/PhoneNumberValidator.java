package utils;

public class PhoneNumberValidator {
    public static boolean validate(String phoneNumber) {
        phoneNumber = phoneNumber.replace(" ", "");
        try {
            // verificar se contém apenas números
            Integer.parseInt(phoneNumber);
        } catch (NumberFormatException e) {
            // se tiver um erro, é porque não conseguiu converter em int,
            // ou seja, contem caracteres que não são números
            return false;
        }

        if ((phoneNumber.length() != 9))
            return false;
        if (!phoneNumber.startsWith("82") && !phoneNumber.startsWith("83") && !phoneNumber.startsWith("84") && !phoneNumber.startsWith("85") && !phoneNumber.startsWith("86") && !phoneNumber.startsWith("87") && !phoneNumber.startsWith("21"))
            return false;
        return true;
    }
}
