/**
 * Enum class with the possible colours which can be guessed (and EMPTY)
 * @author Jordy Meier - Groep 1
 */
public enum Colour {
    EMPTY, RED, GREEN, BLUE, YELLOW, PINK, ORANGE;

    /**
     * Turns enum into a char to display in the console.
     * @return only the first letter of the Colour or 'X' if empty
     */
    public char toChar() {
        if (this == Colour.EMPTY) {
            return 'X';
        }
        return super.toString().charAt(0);
    }

    /**
     * Turns input characters into the correct colour
     * @param colour the char to turn into a Colour
     * @return the corresponding Colour
     */
    public static Colour fromChar(char colour) {
        colour = Character.toUpperCase(colour);

        switch (colour) {
            case 'R':
                return Colour.RED;
            case 'G':
                return Colour.GREEN;
            case 'B':
                return Colour.BLUE;
            case 'Y':
                return Colour.YELLOW;
            case 'P':
                return Colour.PINK;
            case 'O':
                return Colour.ORANGE;
        }
        throw new InvalidInputException();
    }
}
