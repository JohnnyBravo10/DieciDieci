package org.example;

import org.apache.commons.math3.geometry.euclidean.twod.Vector2D;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class PieceGeometry {
    private final RealMatrix shape;
    private final RealVector leftSquareCorner;

    public PieceGeometry(RealMatrix shape, RealVector leftSquareCorner)
    {
        this.shape = shape;
        this.leftSquareCorner = leftSquareCorner;
    }

    public RealMatrix getShape() {
        return this.shape;
    }

    public RealVector getLeftSquareCorner() {
        return this.leftSquareCorner;
    }
}
