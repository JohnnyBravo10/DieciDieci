package org.example;

import org.apache.commons.math3.exception.*;
import org.apache.commons.math3.linear.*;

import java.util.*;
import java.util.stream.Collectors;

public class PieceGeometry {
    private RealMatrix shape;
    private RealVector leftSquareCorner;
    private static final RealMatrix PI_QUARTER_ROTATION = new Array2DRowRealMatrix(new double[][]{{0, -1}, {1, 0}});

    /////////////provato a cambiare
    public PieceGeometry(RealMatrix shape) {
        this.shape = shape;
        this.leftSquareCorner = new ArrayRealVector(this.calculateLeftCorner());
    }

    public RealMatrix getShape() {
        return this.shape;
    }

    public RealVector getLeftSquareCorner() {
        return this.leftSquareCorner;
    }

    public void rotate() {
        this.shape = this.shape.multiply(PI_QUARTER_ROTATION);
        this.leftSquareCorner = new ArrayRealVector(this.calculateLeftCorner());
    }

    // TODO: GET RID OF THE WARNING BECAUSE I HAVE TO CHECK IF THE OPTINAL VALUES ARE PRESENT USING isPresent() METHOD


    // Useare questo .collect(Collectors.toList()) al posto di .toList() perché a circleci non piace
    public double[] calculateLeftCorner() {
        OptionalDouble max_y = Arrays.stream(this.shape.getColumn(1)).max();

        List<double[]> leftCandidates = Arrays.stream(this.shape.getData()).filter(c -> Double.compare(c[1], max_y.getAsDouble()) == 0)
                .collect(Collectors.toList());

        Optional<double[]> min = leftCandidates.stream().min(Comparator.comparingDouble(h -> h[0]));

        return min.get();
    }
}
