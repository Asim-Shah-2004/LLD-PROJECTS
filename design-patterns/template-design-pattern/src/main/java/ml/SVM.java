package ml;

public class SVM extends Model {
    @Override
    public void load() {
        System.out.println("Loading SVM");
    }
    @Override
    public void preprocess() {
        System.out.println("Preprocessing for SVM");
    }
    @Override
    public void train() {
        System.out.println("Training SVM");
    }
    @Override
    public void evaluate() {
        System.out.println("Evaluating SVM");
    }
    @Override
    public void save() {
        System.out.println("Saving SVM");
    }
}
