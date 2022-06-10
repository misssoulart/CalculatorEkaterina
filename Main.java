import java.util.Scanner;

public class Main {
    static String input;
    private static Integer integer;
    private static Scanner scanner;

    public static void main(String[] args) throws Exception {
        int total;
        System.out.println("Введите Ваше значение от 1 до 10 либо  I до X");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        calc(input);
        }

    public static String calc(String input) throws Exception {

        String userValue = input;
        String[] example = userValue.split(" ");
        int total = 0;
        String result1;

        if (example.length != 3) {
            throw new Exception("//т.к.формат математической операции не удовлетворяет заданию - два числа и один оператор (+, -, /, *)");
        } else {

            try {
                int oneAr = Integer.parseInt(example[0].trim());
                int twoAr = Integer.parseInt(example[2].trim());

                if (oneAr <= 0) {
                    throw new Exception("// Ошибка. Числа должны быть положительными"); //Проверим первое число
                } else if (oneAr > 10) {
                    throw new Exception("// Ошибка. Числа должны быть строго от 1 до 10");
                } else if (twoAr <= 0) {
                    throw new Exception("// Ошибка. Числа должны быть положительными"); //Проверим второе число
                } else if (twoAr > 10) {
                    throw new Exception("// Ошибка. Числа должны быть строго от 1 до 10");

                } else {
                    switch (example[1]) {
                        case "+" -> { total = oneAr + twoAr; break; }
                        case "-" -> { total = oneAr - twoAr; break; }
                        case "*" -> { total = oneAr * twoAr; break; }
                        case "/" -> { total = oneAr / twoAr; break; }
                        default -> throw new Exception("// Ошибка. Введенные данные противоречат условию. Введите числа от 1 до 10 или от I до X через пробел"); }

                    result1 = integer.toString(total);
                    System.out.println(result1);
                    return input; }

            } catch (NumberFormatException nfe) {
                try {
                    RimEnum one = RimEnum.valueOf(example[0]); //Получим значения перечисления по его строковому представлению с помощью valueOf
                    int number1 = one.getNumber();
                    RimEnum two = RimEnum.valueOf(example[2]);
                    int number2 = two.getNumber();

                    try {
                        if (number1 <= 0) {
                            throw new Exception("// Ошибка. Числа должны быть положительными или 0"); //Проверим первое число
                        } else if (number1 > 10) {
                            throw new Exception("// Ошибка. Числа должны быть строго от I до X");
                        } else if (number2 <= 0) {
                            throw new Exception("// Ошибка. Числа должны быть положительными или 0"); //Проверим второе число
                        } else if (number2 > 10) {
                            throw new Exception("// Ошибка. Число должны быть строго от I до X");
                        } else {
                            switch (example[1]) {
                                case "+" -> { total = number1 + number2; break; }
                                case "-" -> { total = number1 - number2; break; }
                                case "*" -> { total = number1 * number2; break; }
                                case "/" -> { total = number1 / number2; break; }
                                default -> throw new Exception("//Ошибка. Введенные данные противоречат условию. Введите числа от 1 до 10 или от I до X через пробел");
                            }
                            try {
                                System.out.println(RimEnum.values()[total - 1]); // Получаем имя элемента enum через его индекс (порядковый номер) с помощью: .values()[индекс]
                            } catch (ArrayIndexOutOfBoundsException th) {
                                throw new Exception("// Ошибка. В римской системе нет отрицательных чисел");
                            }
                        }
                    } catch (IllegalArgumentException e) {
                        throw new Exception("// Ошибка. Неверно введены данные, проверьте условие и попробуйте снова");
                    }
                } catch (IllegalArgumentException e) {
                    throw new Exception("// Ошибка. Введенные одновременно две системы исчесления");
                }
            }
        }
        return input;
    }
}