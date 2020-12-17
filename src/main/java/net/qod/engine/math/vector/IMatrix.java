package net.qod.engine.math.vector;

public interface IMatrix<T> {
    IMatrix<T> rotation(double angle);
    IMatrix<T> identity();
    IMatrix<T> transpose();
    T get(int column, int row) throws IllegalShapeException;
    int columns();
    int rows();
}
