import users.entity.Ingredient;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Recipe implements Iterable<Ingredient> {
    private List<Ingredient> ingredients;
    private String name;
    private List<String> instructions;

    public Recipe(String name) {
        this.name = name;
        ingredients = new ArrayList<>();
        instructions = new ArrayList<>();
    }

    public List<Ingredient> getIngredientList() {
        return ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(ingredient);
    }

    public void addInstruction(String instruction) {
        instructions.add(instruction);
    }

    @Override
    public Iterator<Ingredient> iterator() {
        return ingredients.iterator();
    }

    public Instruction getInstructions() {
        return () -> instructions.iterator();
    }
}
