package users.service.rename_cookbook;

public class CookbookNotFoundException extends Exception {
    public CookbookNotFoundException(String message) {
        super(message);
    }
}
