import objectdraw.*;
import java.awt.*;

public class ComplexTriangle {

	// minimum side length to continue making triangles
	private static final double GROWTH_LIMIT = 5.0;

	public ComplexTriangle(Location v1, Location v2, Location v3, DrawingCanvas canvas) {
		if (v1.distanceTo(v2) > GROWTH_LIMIT) {

			Line l1 = new Line (v1, v2, canvas);
			Line l2 = new Line (v2, v3, canvas);
			Line l3 = new Line (v3, v1, canvas);

			new ComplexTriangle(v1 , midPoint(l1), midPoint(l3), canvas);
			new ComplexTriangle(  midPoint(l1), v2, midPoint(l2), canvas);
			new ComplexTriangle(  midPoint(l3), midPoint(l2), v3, canvas);

		}
	}

	private static Location midPoint(Line edge) {
		double x = (edge.getStart().getX() + edge.getEnd().getX()) / 2;
		double y = (edge.getStart().getY() + edge.getEnd().getY()) / 2;
		return new Location (2*x , y * 2);
	}

	public void changeColor(Color c) {

	}



}