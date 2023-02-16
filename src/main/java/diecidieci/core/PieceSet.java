package diecidieci.core;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import java.awt.*;
import java.security.SecureRandom;

public class PieceSet {

    //costruttore privato per nascondere quello pubblico di default
    private PieceSet(){}

    //set dei possibili pezzi
    private static final Piece[] possibleSet = new Piece[]{
            // STRAIGTH
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}})),
                    Piece.ShapeType.STRAIGHT1X,
                    Color.ORANGE),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{-0.5, 0}, {0.5, 0}})),
                    Piece.ShapeType.STRAIGHT2X,
                    Color.BLUE),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{-1, 0}, {0, 0}, {1, 0}})),
                    Piece.ShapeType.STRAIGHT3X,
                    Color.RED),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{-1.5, 0}, {-0.5, 0}, {0.5, 0}, {1.5, 0}})),
                    Piece.ShapeType.STRAIGHT4X,
                    Color.CYAN),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{-2, 0}, {-1, 0}, {0, 0}, {1, 0}, {2, 0}})),
                    Piece.ShapeType.STRAIGHT5X,
                    Color.GREEN),

            // SQUARES
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {-0.5, -0.5}, {-0.5, 0.5},
                    {0.5, 0.5}, {0.5, -0.5}})),
                    Piece.ShapeType.SQUARE2X,
                    Color.PINK),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {0, 0}, {0, 1}, {0, -1},
                    {1, 0}, {1, 1}, {1, -1},
                    {-1, 0}, {-1, 1}, {-1, -1}})),
                    Piece.ShapeType.SQUARE3X,
                    Color.DARK_GRAY),
            //ELLES
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {-0.5, -0.5}, {-0.5, 0.5}, {0.5, -0.5}})),
                    Piece.ShapeType.ELLE2X,
                    Color.MAGENTA),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {0, 0}, {1, 0}, {2, 0}, {0, 1}, {0, 2}})),
                    Piece.ShapeType.ELLE3X,
                    Color.YELLOW)
    };
    private static final SecureRandom gen = new SecureRandom();

    //possible set getter
    public static Piece[] getPossibleSet() {
        return possibleSet;
    }

    //generatore pezzo casuale
    public static Piece getRandomPiece(){
        return new Piece(possibleSet[gen.nextInt(possibleSet.length)]);
    }
}