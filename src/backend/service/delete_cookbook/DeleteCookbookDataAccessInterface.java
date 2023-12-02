package backend.service.delete_cookbook;

public interface DeleteCookbookDataAccessInterface {

    public String[] getStoredCookbooks();

    public void deleteStoredCookbooks();
}
