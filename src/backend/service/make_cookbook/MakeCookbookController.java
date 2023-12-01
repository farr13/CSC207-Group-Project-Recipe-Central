package backend.service.make_cookbook;

public class MakeCookbookController {

    final MakeCookbookInputBoundary makeCookbookUseCaseInteractor;

    public MakeCookbookController(MakeCookbookInputBoundary makeCookbookUseCaseInteractor) {
        this.makeCookbookUseCaseInteractor = makeCookbookUseCaseInteractor;
    }

    public void execute(String title) {
        MakeCookbookInputData makeCookbookInputData = new MakeCookbookInputData(title);

        makeCookbookUseCaseInteractor.execute(makeCookbookInputData);
    }
}
