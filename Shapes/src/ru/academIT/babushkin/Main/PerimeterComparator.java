package ru.academIT.babushkin.Main;

import ru.academIT.babushkin.Shapes.Shape;
import java.util.Comparator;

public class PerimeterComparator implements Comparator<Shape> {
    @Override
    public int compare(Shape shape1, Shape shape2){
        return Double.compare(shape1.getPerimeter(), shape2.getPerimeter());
    }
}
