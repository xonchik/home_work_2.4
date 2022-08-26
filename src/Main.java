public class Main {

    public static void main(String[] args) {

    }

    public static boolean checkLoginAndPassword(String login, String password, String confirmPassword){
        try {
            if (login.toCharArray().length > 20) {
                throw new WrongLoginException("Логин слишком длинный! Допустимо до 20 символов.");
            }
            if (password.toCharArray().length >= 20) {
                throw new WrongPasswordException("Пароль слишком длинный! Допустимо меньше 20 символов.");
            }
            if (!login.matches("\\w{1,20}")) {
                throw new WrongLoginException("Логин содержит недопустимые символы.");
            }
            if (!password.matches("\\w{1,19}")) {
                throw new WrongPasswordException("Пароль содержит недопустимые символы.");
            }
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совподают!");
            }
        } catch (WrongLoginException | WrongPasswordException exception) {
            System.out.println(exception.getMessage());
            return false;
        }
        return true;
    }
}