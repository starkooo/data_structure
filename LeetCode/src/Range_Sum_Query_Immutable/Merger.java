package Range_Sum_Query_Immutable;

public interface Merger<E> {
    E merge(E a, E b);
}
