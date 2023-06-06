import java.util.Scanner;

public class Main {
    // Mã màu ANSI
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập độ dài cạnh thứ nhất: ");
        double side1 = scanner.nextDouble();
        System.out.print("Nhập độ dài cạnh thứ hai: ");
        double side2 = scanner.nextDouble();
        System.out.print("Nhập độ dài cạnh thứ ba: ");
        double side3 = scanner.nextDouble();

        boolean isValidTriangle = side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
        if (isValidTriangle) {
            System.out.println(GREEN + "Tam giác là hợp lệ." + RESET);

            boolean isEquilateral = side1 == side2 && side2 == side3;
            boolean isIsosceles = side1 == side2 || side1 == side3 || side2 == side3;
            boolean isRightAngled = Math.pow(side1, 2) + Math.pow(side2, 2) == Math.pow(side3, 2) || Math.pow(side1, 2) + Math.pow(side3, 2) == Math.pow(side2, 2) || Math.pow(side2, 2) + Math.pow(side3, 2) == Math.pow(side1, 2);

            if (isEquilateral) {
                System.out.println(GREEN + "Tam giác là tam giác đều." + RESET);
            } else if (isIsosceles) {
                System.out.println(GREEN + "Tam giác là tam giác cân." + RESET);
            } else if (isRightAngled) {
                System.out.println(GREEN + "Tam giác là tam giác vuông." + RESET);
            } else {
                System.out.println(GREEN + "Tam giác là tam giác thường." + RESET);
            }

            double perimeter = side1 + side2 + side3;
            System.out.println("Chu vi của tam giác: " + YELLOW + perimeter + RESET);

            double semiperimeter = perimeter / 2;
            double area = Math.sqrt(semiperimeter * (semiperimeter - side1) * (semiperimeter - side2) * (semiperimeter - side3));
            System.out.println("Diện tích của tam giác: " + YELLOW + area + RESET);
        } else {
            System.out.println(RED + "Tam giác không hợp lệ." + RESET);
        }
    }
}
