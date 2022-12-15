package org.example;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;

import java.awt.*;
import java.util.Random;

public class PieceSet {
    private static PieceSet set;
    private final Piece[] possibleSet;

    private PieceSet(){
        this.possibleSet = new Piece[]{
                // STRAIGTH
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}}),
                        new ArrayRealVector(new double[]{0, 0})),
                        Piece.ShapeType.STRAIGHT2x,
                        Color.BLUE),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}}),
                        new ArrayRealVector(new double[]{0, 0})),
                        Piece.ShapeType.STRAIGHT3x,
                        Color.RED),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}}),
                        new ArrayRealVector(new double[]{0, 0})),
                        Piece.ShapeType.STRAIGHT4x,
                        Color.CYAN),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}}),
                        new ArrayRealVector(new double[]{0, 0})),
                        Piece.ShapeType.STRAIGHT5x,
                        Color.GREEN),

                // SQUARES
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {0, 0}, {0, 1},
                        {1, 0}, {-1, 1}}),
                        new ArrayRealVector(new double[]{0, 0})),
                        Piece.ShapeType.SQUARE2x,
                        Color.PINK),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {0, 0}, {0, 1}, {0, -1},
                        {1, 0}, {1, 1}, {1, -1},
                        {-1, 0}, {-1, 1}, {-1, -1}}),
                        new ArrayRealVector(new double[]{-1, 1})),
                        Piece.ShapeType.SQUARE3x,
                        Color.DARK_GRAY),
                //ELLES
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {0, 0}, {0, -1}, {1, 0}}),
                        new ArrayRealVector(new double[]{1, 0})),
                        Piece.ShapeType.ELLE2x,
                        Color.MAGENTA),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}}),
                        new ArrayRealVector(new double[]{-1, 1})),
                        Piece.ShapeType.ELLE3x,
                        Color.YELLOW)
        };
    }

    public static PieceSet getInstance(){
        if(set == null)
        {
            set = new PieceSet();
        }

        return set;
    }

    public Piece[] getPossibleSet() {
        return this.possibleSet;
    }

    public Piece getRandomPiece(){
        return this.possibleSet[new Random().nextInt(this.possibleSet.length)];
    }
}