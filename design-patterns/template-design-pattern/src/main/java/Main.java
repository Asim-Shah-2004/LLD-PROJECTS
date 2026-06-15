import ml.DecisionTree;
import ml.Model;
import ml.NeuralNetwork;
import ml.SVM;

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Decision Tree Test ---");
        Model decisionTree = new DecisionTree();
        decisionTree.executePipeline();

        System.out.println("\n--- Neural Network Test ---");
        Model neuralNetwork = new NeuralNetwork();
        neuralNetwork.executePipeline();

        System.out.println("\n--- SVM Test ---");
        Model svm = new SVM();
        svm.executePipeline();
    }
}
