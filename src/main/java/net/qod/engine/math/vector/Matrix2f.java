package net.qod.engine.math.vector;

public class Matrix2f implements IMatrix<Float> {
    float m00, m01, m10, m11;

    public Matrix2f() {}

    public Matrix2f(float m00, float m01, float m10, float m11) {
        this.m00 = m00;
        this.m01 = m01;
        this.m10 = m10;
        this.m11 = m11;
    }

    public Matrix2f(float... flatArray) throws IllegalShapeException {
        if(flatArray.length != 4)
            throw new IllegalShapeException(4, flatArray.length);
        this.m00 = flatArray[0];
        this.m01 = flatArray[1];
        this.m10 = flatArray[2];
        this.m11 = flatArray[3];
    }

    public Matrix2f(float[][] flatArray) throws IllegalShapeException {
        if(flatArray.length == 2) {
            if(flatArray[0].length == 2) {
                m00 = flatArray[0][0];
                m01 = flatArray[0][1];
                m10 = flatArray[1][0];
                m11 = flatArray[1][1];
            } else throw new IllegalShapeException(2, flatArray[0].length);
        } else throw new IllegalShapeException(2, flatArray.length);
    }

    public IMatrix<Float> rotation(double angle) {
        double rad = Math.toRadians(angle);
        m00 = (float) Math.cos(rad);
        m01 = (float) -Math.sin(rad);
        m10 = (float) Math.sin(rad);
        m11 = (float) Math.cos(rad);
        return this;
    }

    public IMatrix<Float> identity() {
        m00 = 1;
        m01 = 0;
        m10 = 0;
        m11 = 1;
        return this;
    }

    public IMatrix<Float> transpose() {
        float tmp = m01;
        m01 = m10;
        m10 = tmp;
        return this;
    }

    @Override
    public Float get(int column, int row) throws IllegalShapeException {
        if(column == 0) {
            if(row == 0) {
                return m00;
            } else if(row == 1) {
                return m10;
            }
            throw new IllegalShapeException(2, row+1);
        } else if(column == 1) {
            if(row == 0) {
                return m01;
            } else if(row == 1) {
                return m11;
            }
            throw new IllegalShapeException(2, row+1);
        }
        throw new IllegalShapeException(2, column+1);
    }

    public int columns() {
        return 2;
    }

    public int rows() {
        return 2;
    }

    public float determinant() {
        return m00*m11 - m01*m10;
    }

    public float[] toArray() {
        return new float[]{m00, m01, m10, m11};
    }

    public float[][] toMultiArray() {
        return new float[][]{
                {m00, m01},
                {m10, m11}
        };
    }
}
