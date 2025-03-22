package com.iuh;

public class CompositePatternTest {
    public static void main(String[] args) {

        Shape tamgiac1 = new Triangle();
        Shape tamgiac2 = new Triangle();
        Shape tron1 = new Circle();

        Drawing bigDrawing = new Drawing();
        bigDrawing.add(tamgiac1);
        bigDrawing.add(tron1);

        Drawing smallDrawing = new Drawing();
        smallDrawing.add(tamgiac2);

        bigDrawing.add(smallDrawing);

        bigDrawing.draw("Green");
    }
}
