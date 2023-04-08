
class BigIntegerConverter {

    /**
     * @param number string representing the number
     * @return BigInteger instance
     */
    public static Number getBigInteger(String number) {
        // create BigInteger instance here
        return new java.math.BigInteger(number);
    }
}