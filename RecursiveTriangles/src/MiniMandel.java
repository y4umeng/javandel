
import objectdraw.*;
import java.awt.*;

public class MiniMandel extends FrameWindowController {
	private final static int COUNT = 1000;
	private final static int WINDOE_SIZE = 1000;
	
	private final static int SCALE = 28500; 
	private final static int REALMIDDLE = 24700;
	
	private final static int IMAGMIDDLE = -6700;
	private final static double QUALITY = 0.00003	;

	// zoomed into a self similar mandelbrot set thing

	public static void main(String[] args) {
		MiniMandel s = new MiniMandel();
	}
	public MiniMandel () {
		resize(WINDOE_SIZE, WINDOE_SIZE);

		//new FilledOval(WINDOE_SIZE/2 + REALMIDDLE, WINDOE_SIZE/2 - IMAGMIDDLE, 2,2,canvas); 

		for (double re = -0.875; re <= -0.855; re+=QUALITY) {
			for (double im = -.25; im <= -.23; im+=QUALITY) {
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
