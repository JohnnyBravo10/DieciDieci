package org.example;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;

import java.awt.*;
import java.util.Random;

public class PieceSet {
    private static PieceSet set;

    //ho reso possibleSet un campo static final perché alla fine è una costante. Tenendo così
    //non dobbiamo più usare un costruttore che costruisce il possibleSet (i prof fanno così nelle cell dell'esempio della banca)
    // ho modificato anche i test. ora non c'è neanche bisogno di istanziare la classe pieceset, secondo me così è meglio in caso ditemi
    //se non vi convince. (poi volendo tutt questo campo final si potrebbe addiritture mettere nella classe piece e cancellare la class pieceset
    // in alternativa si potrebbe anche pensare di rendere pieceset una classe record :o
    private static final Piece[] possibleSet=new Piece[]{
            // STRAIGTH
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}})),
                    Piece.ShapeType.STRAIGHT1x,
                    Color.ORANGE),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}})),
                    Piece.ShapeType.STRAIGHT2x,
                    Color.BLUE),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}})),
                    Piece.ShapeType.STRAIGHT3x,
                    Color.RED),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}})),
                    Piece.ShapeType.STRAIGHT4x,
                    Color.CYAN),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}})),
                    Piece.ShapeType.STRAIGHT5x,
                    Color.GREEN),

            // SQUARES
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {0, 0}, {0, 1},
                    {1, 0}, {1, 1}})),
                    Piece.ShapeType.SQUARE2x,
                    Color.PINK),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {0, 0}, {0, 1}, {0, -1},
                    {1, 0}, {1, 1}, {1, -1},
                    {-1, 0}, {-1, 1}, {-1, -1}})),
                    Piece.ShapeType.SQUARE3x,
                    Color.DARK_GRAY),
            //ELLES
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {0, 0}, {0, 1}, {1, 0}})),
                    Piece.ShapeType.ELLE2x,
                    Color.MAGENTA),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}})),
                    Piece.ShapeType.ELLE3x,
                    Color.YELLOW),

            //REVERSED ELLES "Γ"

            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {0, 0}, {0, -1}, {1, 0}})),
                    Piece.ShapeType.REVERSED_ELLE2X,
                    Color.LIGHT_GRAY),
            new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                    {-1, 1}, {-1, 0}, {-1, -1}, {0, 1}, {1, 1}})),
                    Piece.ShapeType.REVERSED_ELLE3X,
                    Color.BLACK),
    };
    private static final Random gen = new Random();

    /*
    private PieceSet(){
        this.possibleSet = new Piece[]{
                // STRAIGTH
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}})),
                        Piece.ShapeType.STRAIGHT2x,
                        Color.BLUE),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}})),
                        Piece.ShapeType.STRAIGHT3x,
                        Color.RED),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}})),
                        Piece.ShapeType.STRAIGHT4x,
                        Color.CYAN),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}, {4, 0}})),
                        Piece.ShapeType.STRAIGHT5x,
                        Color.GREEN),

                // SQUARES
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {0, 0}, {0, 1},
                        {1, 0}, {1, 1}})),
                        Piece.ShapeType.SQUARE2x,
                        Color.PINK),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {0, 0}, {0, 1}, {0, -1},
                        {1, 0}, {1, 1}, {1, -1},
                        {-1, 0}, {-1, 1}, {-1, -1}})),
                        Piece.ShapeType.SQUARE3x,
                        Color.DARK_GRAY),
                //ELLES
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {0, 0}, {0, 1}, {1, 0}})),
                        Piece.ShapeType.ELLE2x,
                        Color.MAGENTA),
                new Piece(new PieceGeometry(new Array2DRowRealMatrix(new double[][]{
                        {-1, 1}, {-1, 0}, {-1, -1}, {0, -1}, {1, -1}})),
                        Piece.ShapeType.ELLE3x,
                        Color.YELLOW)
        };
    }
    */


    /*
    public static PieceSet getInstance(){
        if(set == null)
        {
            set = new PieceSet();
        }

        return set;
    }
    */


    //anche questi due metodi li ho resi statici
    public static Piece[] getPossibleSet() {
        return possibleSet;
    }

    public static Piece getRandomPiece(){
        return possibleSet[gen.nextInt(possibleSet.length)];
    }
}