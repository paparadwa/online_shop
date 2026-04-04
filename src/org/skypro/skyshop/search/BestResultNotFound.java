package org.skypro.skyshop.search;

public class BestResultNotFound extends Exception {
    public BestResultNotFound(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }
    @Override
    public String toString() {
        return "BestResultNotFound: " + this.getMessage();
    }
}
