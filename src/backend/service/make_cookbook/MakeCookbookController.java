package backend.service.make_cookbook;

public class MakeCookbookController {

    final MakeCookbookInputBoundary makeCookbookUseCaseInteractor;

    public MakeCookbookController(MakeCookbookInputBoundary makeCookbookUseCaseInteractor) {
        this.makeCookbookUseCaseInteractor = makeCookbookUseCaseInteractor;
    }

    public void execute(String newCookbookName) {
        MakeCookbookInputData makeCookbookInputData = new MakeCookbookInputData(newCookbookName);

        makeCookbookUseCaseInteractor.execute(makeCookbookInputData);
    }
}
