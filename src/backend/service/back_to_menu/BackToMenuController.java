package backend.service.back_to_menu;

public class BackToMenuController {
    final BackToMenuInputBoundary backToMenuInteractor;

    public BackToMenuController(BackToMenuInputBoundary backToMenuInteractor){
        this.backToMenuInteractor = backToMenuInteractor;
    }

    public void execute() {
        backToMenuInteractor.execute();
    }
}
