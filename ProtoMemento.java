/**
 * Interface for a mix between the Prototype design pattern
 * and the Memento design pattern. This somewhat hides the
 * data like a Memento but allows us to not have to make a
 * new memento class for each class that needs one.
 * @param <T>
 */
public interface ProtoMemento<T> {
    ProtoMemento<T> copy();

    void restore(ProtoMemento<T> memento);
}
