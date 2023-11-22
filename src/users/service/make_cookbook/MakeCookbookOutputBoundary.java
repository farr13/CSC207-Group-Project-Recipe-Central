package users.service.make_cookbook;

public interface MakeCookbookOutputBoundary {
    void prepareSuccesView(MakeCookbookOutputData response);

    void prepareFailView(MakeCookbookOutputData error);
}
