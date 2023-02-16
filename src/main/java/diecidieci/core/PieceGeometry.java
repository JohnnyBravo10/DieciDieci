package diecidieci.core;

import org.apache.commons.math3.linear.*;
import java.util.*;
import java.util.stream.Collectors;

public class PieceGeometry {
    private RealMatrix shape;
    private RealVector leftSquareCorner;
    private static final RealMatrix PI_QUARTER_ROTATION = new Array2DRowRealMatrix(new double[][]{{0, -1}, {1, 0}});

    //costruttore di nuova geometria data la matrice di shape
    public PieceGeometry(RealMatrix shape) {
        this.shape = shape;
        this.leftSquareCorner = new ArrayRealVector(this.calculateLeftCorner());
    }

    //costruttore nuova geometria copia di una precedente
    public PieceGeometry(PieceGeometry pieceGeometry) {
        this.shape = pieceGeometry.getShape().copy();
        this.leftSquareCorner = pieceGeometry.getLeftSquareCorner().copy();
    }

    //getters
    public RealMatrix getShape() {
        return this.shape;
    }

    public RealVector getLeftSquareCorner() {
        return this.leftSquareCorner;
    }

    //rotazione pezzo
    public void rotate() {
        this.shape = this.shape.multiply(PI_QUARTER_ROTATION);
        this.leftSquareCorner = new ArrayRealVector(this.calculateLeftCorner());
    }

    //calcolo upperLeftCorner
    public double[] calculateLeftCorner() {
        OptionalDouble maxY = Arrays.stream(this.shape.getColumn(1)).max();

        if (maxY.isPresent()) {
            List<double[]> leftCandidates = Arrays.stream(this.shape.getData()).filter(c -> Double.compare(c[1], maxY.getAsDouble()) == 0)
                    .collect(Collectors.toList());

            Optional<double[]> min = leftCandidates.stream().min(Comparator.comparingDouble(h -> h[0]));
            if (min.isPresent()) {

                return min.get();
            }
        }
        throw new RuntimeException("Errore nel calcolo dell'angolo");
    }
}
