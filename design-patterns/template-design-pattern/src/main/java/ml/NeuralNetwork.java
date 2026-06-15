package ml;

public class NeuralNetwork extends Model{
    @Override
    public void load() {
        System.out.println("Loading Neural Network");
    }
    @Override
    public void preprocess() {
        System.out.println("Preprocessing for Neural Network");
    }
    @Override
    public void train() {
        System.out.println("Training Neural Network");
    }
    @Override
    public void evaluate() {
        System.out.println("Evaluating Neural Network");
    }
    @Override
    public void save() {
        System.out.println("Saving Neural Network");
    }
}
