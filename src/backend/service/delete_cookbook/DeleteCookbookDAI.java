package backend.service.delete_cookbook;

public interface DeleteCookbookDAI {
    void deleteCookbooks(String[] cookbookNames) throws Exception;
}
