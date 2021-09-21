package sk.fri.uniza.exceptions;

public class NedovolPohnutException extends Exception{
    public NedovolPohnutException() {
    }

    @Override
    public String getMessage() {
        return "Packam sa nedokazal pohnut danym smerom";
    }
}
