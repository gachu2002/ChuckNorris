class Converter {

    /**
     * It returns a double value or 0 if an exception occurred
     */
    public static double convertStringToDouble(String input) {
        double i = 0;
        try {
            i = Double.parseDouble(input);
            return i;
        } catch (Exception e) {
            return i;
        }
    }
}