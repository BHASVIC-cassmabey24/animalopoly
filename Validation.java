public class Validation {
    public static boolean isInteger(String str) {
        try {
            int number = Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    public static boolean containsNumber(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isInteger(str.substring(i, i + 1))) {
                return true;
            }
        }
        return false;
    }

    public static boolean containsSymbol(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.substring(i, i + 1).equals("!") || str.substring(i, i + 1).equals("$") ||
                    str.substring(i, i + 1).equals("%") || str.substring(i, i + 1).equals("^") ||
                    str.substring(i, i + 1).equals("&") || str.substring(i, i + 1).equals("£") ||
                    str.substring(i, i + 1).equals("*") || str.substring(i, i + 1).equals("(") ||
                    str.substring(i, i + 1).equals(")") || str.substring(i, i + 1).equals("<") ||
                    str.substring(i, i + 1).equals(">") || str.substring(i, i + 1).equals("?") ||
                    str.substring(i, i + 1).equals("/") || str.substring(i, i + 1).equals("@") ||
                    str.substring(i, i + 1).equals(";") || str.substring(i, i + 1).equals(":") ||
                    str.substring(i, i + 1).equals("[") || str.substring(i, i + 1).equals("]") ||
                    str.substring(i, i + 1).equals("{") || str.substring(i, i + 1).equals("}")


            ) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
