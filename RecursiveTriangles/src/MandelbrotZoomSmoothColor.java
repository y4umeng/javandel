
import objectdraw.*;
import java.awt.*;

public class MandelbrotZoomSmoothColor extends FrameWindowController {
	private final static int COUNT = 1000;
	private final static int WINDOE_SIZE = 1000;
	private final static int SCALE = 1700;
	private final static int REALMIDDLE = 800;
	private final static int IMAGMIDDLE = -800;
	private final static double QUALITY = 0.002;

	public static void main(String[] args) {
		MandelbrotZoomSmoothColor s = new MandelbrotZoomSmoothColor();
	}
	public MandelbrotZoomSmoothColor() {
		resize(WINDOE_SIZE, WINDOE_SIZE);
		
		
		// RAINBOW COLOR ZOOM
		
		new FilledOval(WINDOE_SIZE/2 + REALMIDDLE, WINDOE_SIZE/2 - IMAGMIDDLE, 10,10,canvas); 
		//new FilledOval(200,160,10,10,canvas);
		
		for (double re = -0.9; re <= -0.1; re+=QUALITY) {
			for (double im = -2; im <= -.3; im+=QUALITY) {
				Complex c = new Complex (re, im);
				Object [] returns = checkMandelbrot (c, new Complex(0, 0));
				
					double realpoint = (WINDOE_SIZE/2) + REALMIDDLE + re*SCALE;
					double imagpoint = (WINDOE_SIZE/2) - IMAGMIDDLE + im*SCALE;
					
					// i stole the algorithm for the nsmooth value from stackoverflow
					// i don't really like how it looks anyway
					
					FilledOval fo = new FilledOval(realpoint, imagpoint, 10,10,canvas); 
					int mandel = (int) returns[1];
					Complex finalAns = (Complex) returns[0];
					Complex zn = finalAns.times(new Complex(mandel, 0));
					float nsmooth = (float) (COUNT + 1 - Math.log(Math.log(zn.abs()))/Math.log(2));
					fo.setColor(Color.getHSBColor(0.95f + 10 * nsmooth ,0.6f,1.0f));
			}

		}
	}

	public Object[] checkMandelbrot (Complex c, Complex z) {
		Object [] returnValues = new Object [2];
		int count = 0;
		while (count < COUNT) {
			z = z.times(z);
			Complex ans = z.plus(c);
			returnValues[0] = ans;
			returnValues[1] = count;
			
			if (ans.abs() > 2.0) {
				//System.out.println(ans);
				return returnValues;
			}
			else
				z = ans;
			count++;
		}
		
		return returnValues;
	}

}
