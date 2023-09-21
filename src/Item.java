/*
  @author   george
  @project   cafe
  @class  Item
  @version  1.0.0 
  @since 20.09.23 - 19.35
*/

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class Item implements IFreshness {
    private ItemType type;
    private String name;
    private List<Ingredient> ingredients;

    public Item() {
    }

    public Item(ItemType type, String name, List<Ingredient> ingredients) {
        this.type = type;
        this.name = name;
        this.ingredients = ingredients;
    }

    @Override
    public LocalDate getExpirationDate() {

        Ingredient ingredientMin = ingredients
                .stream()
                .min(Comparator.comparing(Ingredient::getExpirationDate))
                .orElse(null);
        return ingredientMin.getExpirationDate();
    }

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    @Override
    public String toString() {
        return "Item{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", ingredients=" + ingredients +
                '}';
    }
}
