
import objectdraw.*;
import java.awt.*;
import java.util.Random;

public class Events extends FrameWindowController {

	// size of the program window
	private static final int WINDOW_SIZE = 1000;
	// should be 600

	private static Random rand = new Random();

	// the three vertices of the complex triangle
	private static final Location VERTEX_1 = new Location(50, 400);
	private static final Location VERTEX_2 = new Location(500, 400);
	private static final Location VERTEX_3 = new Location(275, 50);

	// the triangle itself
	private ComplexTriangle triangle;

	// create the complex triangle
	public Events() {
		// resize(WINDOW_SIZE, WINDOW_SIZE);
		resize(1000, 100);
		//triangle = new ComplexTriangle(VERTEX_1, VERTEX_2, VERTEX_3, canvas);
	}

}
