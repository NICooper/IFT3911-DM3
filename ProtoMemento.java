public interface ProtoMemento<T> {
    ProtoMemento<T> copy();

    void restore(ProtoMemento<T> object);
}
