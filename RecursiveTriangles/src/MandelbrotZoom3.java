
import objectdraw.*;
import java.awt.*;

public class MandelbrotZoom3 extends FrameWindowController {
	private final static int COUNT = 1000;
	private final static int WINDOE_SIZE = 1000;
	private final static int SCALE = 4000; 
	private final static int REALMIDDLE = 3100;
	private final static int IMAGMIDDLE = -500;
	private final static double QUALITY = 0.0003	;

	// seahorse zoom 2

	public static void main(String[] args) {
		MandelbrotZoom3 s = new MandelbrotZoom3();
	}
	public MandelbrotZoom3() {
		resize(WINDOE_SIZE, WINDOE_SIZE);

		new FilledOval(WINDOE_SIZE/2 + REALMIDDLE, WINDOE_SIZE/2 - IMAGMIDDLE, 2,2,canvas); 
		//new FilledOval(200,160,10,10,canvas);

		for (double re = -0.9; re <= -0.65; re+=QUALITY) {
			for (double im = -.25; im <= 0; im+=QUALITY) {
				Complex c = new Complex (re, im);
				int mandel = checkMandelbrot(c, new Complex(0, 0));

				double realpoint = (WINDOE_SIZE/2) + REALMIDDLE + re*SCALE;
				double imagpoint = (WINDOE_SIZE/2) - IMAGMIDDLE + im*SCALE;
				//System.out.println(realpoint + ", " + imagpoint);
				FilledOval fo = new FilledOval(realpoint, imagpoint, 2,2,canvas); 
				
				
				int color = (int) 255 - (mandel % 255);
				fo.setColor(new Color (color, color, color));

			}

		}
	}

	public int checkMandelbrot (Complex c, Complex z) {
		int count = 0;
		while (count < COUNT) {
			z = z.times(z);
			Complex ans = z.plus(c);
			if (ans.abs() > 2.0) 
				return count;
			else
				z = ans;
			count++;
		}
		return count;
	}

}
