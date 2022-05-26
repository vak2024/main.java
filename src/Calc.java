import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String znachCalc = calc(sc.nextLine());
        System.out.println(znachCalc);
    }

    public static String calc(String input) throws Exception{
        String[] mass = input.split(" ");
        String[] arab = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] roman = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "L", "C"};
        String[] oper = {"+", "-", "*", "/"};
        String result = null, tensRom = null, onesRom = null;
        int ara1 = 0, ara2 = 0, rom1 = 0, rom2 = 0, num1 = 0, num2 = 0, sum = 0;
        boolean romss = false;
        if (mass.length != 3) {
            throw new Exception("Ввод данных не соответствует ТЗ");
        }
        for (int i = 0; i < 10; i++) {
            if (true == roman[i].equals(mass[0])) {
                num1 = rom1 = i + 1;
                break;
            } else if (true != roman[i].equals(mass[0])) {
                if (i == 9) {
                    rom1 = 0;
                }
            }
        }
        for (int j = 0; j < 10; j++) {
            if (true == roman[j].equals(mass[2])) {
                num2 = rom2 = j + 1;
                break;
            } else if (true != roman[j].equals(mass[2])) {
                if (j == 9) {
                    rom2 = 0;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (true == arab[i].equals(mass[0])) {
                num1 = ara1 = i + 1;
                break;
            } else if (true != arab[i].equals(mass[0])) {
                if (i == 9) {
                    ara1 = 0;
                }
            }
        }
        for (int i = 0; i < 10; i++) {
            if (true == arab[i].equals(mass[2])) {
                num2 = ara2 = i + 1;
                break;
            } else if (true != arab[i].equals(mass[2])) {
                if (i == 9) {
                    ara2 = 0;
                }
            }
        }
        if (ara1 == 0) {
            if (rom1 == 0)
                throw new Exception("Неверное значение первого числа");
            if (ara2 > 0)
                throw new Exception("Разные системы счисления");
        }
        if (ara2 == 0) {
            if (rom2 == 0)
                throw new Exception("Неверное значение второго числа");
            if (ara1 > 0)
                throw new Exception("Разные системы счисления");
        }
        if (rom1 > 0) {
            if (rom2 > 0) {
                romss = true;
            }
        }
        if (romss != true) {
            num1 = ara1;
            num2 = ara2;
        }else{
            num1 = rom1;
            num2 = rom2;
        }
        switch (mass[1]){
            case "+": sum = num1 + num2;
            break;
            case "-": sum = num1 - num2;
            break;
            case "*": sum = num1 * num2;
            break;
            case "/": sum = num1 / num2;
            break;
            default: throw new Exception("Введено неверное значение операции");
        }
        if (romss == false){
           result = Integer.toString(sum);
        }else{
            if (sum < 1){
                throw new Exception("Значение в римской системе счисления не может быть меньше 1") ;
            }else{
                if (sum == 100){
                    result = roman[11];
                }else{
                    int tens = sum / 10;
                    switch (tens){
                        case 1: tensRom = "X";break;
                        case 2: tensRom = "XX";break;
                        case 3: tensRom = "XXX";break;
                        case 4: tensRom = "XL";break;
                        case 5: tensRom = "L";break;
                        case 6: tensRom = "LX";break;
                        case 7: tensRom = "LXX";break;
                        case 8: tensRom = "LXXX";break;
                        case 9: tensRom = "XC";break;
                        default: tensRom = "";break;
                    }int ones = sum % 10;
                    switch (ones){
                        case 1: onesRom = "I";break;
                        case 2: onesRom = "II";break;
                        case 3: onesRom = "III";break;
                        case 4: onesRom = "IL";break;
                        case 5: onesRom = "V";break;
                        case 6: onesRom = "VI";break;
                        case 7: onesRom = "VII";break;
                        case 8: onesRom = "VIII";break;
                        case 9: onesRom = "IX";break;
                        default: onesRom = "";break;
                    }
                    result = tensRom + onesRom;
                }
            }
        }
        return result;
    }
}


