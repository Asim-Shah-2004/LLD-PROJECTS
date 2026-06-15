package ml;

public abstract class Model {
    public final void executePipeline(){
        load();
        preprocess();
        train();
        evaluate();
        save();
    }
    public abstract void load();
    public abstract void preprocess();
    public abstract void train();
    public abstract void evaluate();
    public abstract void save();
}
