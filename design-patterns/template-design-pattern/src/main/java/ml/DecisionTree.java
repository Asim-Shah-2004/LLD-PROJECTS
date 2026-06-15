package ml;

public class DecisionTree extends Model{
    @Override
    public void load() {
        System.out.println("Loading Decision Tree");
    }
    @Override
    public void preprocess() {
        System.out.println("Preprocessing for Decision Tree");
    }
    @Override
    public void train() {
        System.out.println("Training Decision Tree");
    }
    @Override
    public void evaluate() {
        System.out.println("Evaluating Decision Tree");
    }
    @Override
    public void save() {
        System.out.println("Saving Decision Tree");
    }
}
