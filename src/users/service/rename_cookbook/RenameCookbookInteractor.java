package users.service.rename_cookbook;

import users.entity.Cookbook;
import users.repository.CookbookRepository

public class RenameCookbookInteractor implements RenameCookbookInputBoundary {
    private final CookbookRepository cookbookRepository;

    public RenameCookbookInteractor(CookbookRepository cookbookRepository) {
        this.cookbookRepository = cookbookRepository;
    }

    @Override
    public void execute(RenameCookbookInputData renameCookbookInputData) throws CookbookNotFoundException {
        String oldName = renameCookbookInputData.getOldName();
        String newName = renameCookbookInputData.getNewName();

        Cookbook cookbook = cookbookRepository.findCookbookByName(oldName);
        if (cookbook != null) {
            cookbook.setName(newName);
            cookbookRepository.saveCookbook(cookbook);
        } else {
            throw new CookbookNotFoundException("Cookbook with name '" + oldName + "' not found.");
        }
    }
}
