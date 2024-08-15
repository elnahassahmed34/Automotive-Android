class Calc {
    Integer x;
    Integer y;
    String op;
    Integer result;

    Calc(Integer oper1, Integer oper2, String operation) {
        x = oper1;
        y = oper2;
        op = operation;
    }

    Integer calculate() {
        switch (op) {
            case "+":
                result = x + y;
                break;
            case "-":
                result = x - y;
                break;
            case "x":
                result = x * y;
                break;
            case "/":
                if (y == 0) {
                    System.out.println("Can't divide by zero");
                    result = null;  // Set result to null to indicate an error
                } else {
                    result = x / y;
                }
                break;
            default:
                System.out.println("Invalid operation");
                result = null;
                break;
        }
        return result;
    }
}

class Main {
    public static void main(String[] args) {
        if (args.length != 3) {
            System.out.println("Enter exactly three arguments: operand1 operator operand2");
            return;
        }

        
        Integer operand1 = Integer.parseInt(args[0]);
        Integer operand2 = Integer.parseInt(args[2]);
        String operator = args[1];
        if (!"+".equals(operator) && !"-".equals(operator) && !"x".equals(operator) && !"/".equals(operator)) {
            System.out.println("You should enter a valid operation: +, -, x, or /");
            return;
        }
        Calc calc = new Calc(operand1, operand2, operator);
        Integer result = calc.calculate();
        if (result != null) {
            System.out.println("Result: " + result);
        }
        
        
    }
}
