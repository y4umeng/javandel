
import objectdraw.*;
import java.awt.*;

public class MandelAutoScale extends FrameWindowController {
	
	// BEST VERSION (set to zoom in to a tiny portion of the set)
	// it's the best version bc it automatically renders the set in the window rather rather than
	// playing around with the numbers until it appears
	// to render the whole thing change REALSTART and IMAGSTART to -2 and REALEND and IMAGEND to 2
	// also make QUALITY a much larger value
	
	private final static int COUNT = 1000; // number of iterations
	private final static int DOTSIZE = 2; // size of pixels
	
	
	private final static int SCALE = 250000; // size of render
	private final static double QUALITY = 0.000005; // quality (smaller = finer detail)
			
	private final static double REALSTART = -0.867; // start of the render on the real axis
	private final static double REALEND = -0.8637; // end of the render on the real axis
	
	private final static double IMAGSTART = -.2443; // start of the render on the imaginary axis
	private final static double IMAGEND = -.2443 + 0.0033; // end of the render on the imaginary axis
			
	// yktv

	public static void main(String[] args) {
		MandelAutoScale s = new MandelAutoScale();
	}
	public MandelAutoScale() {
		resize(1000, 1000); 

		for (double re = REALSTART; re <= REALEND; re+=QUALITY) {
			for (double im = IMAGSTART; im <= IMAGEND; im+=QUALITY) {
				
				Complex c = new Complex (re, im);
				int mandel = checkMandelbrot(c, new Complex(0, 0)); // checks if in mandelbrot set

				double realpoint =  (re - REALSTART) * SCALE; // centers the render
				double imagpoint = (im - IMAGSTART) * SCALE; // centers the render
				//System.out.println(realpoint + ", " + imagpoint);
				FilledOval fo = new FilledOval(realpoint, imagpoint, DOTSIZE,DOTSIZE,canvas); 
				// creates pixel
				
				int color = (int) 255 - (mandel % 255); // color value
				fo.setColor(new Color (color, color, color)); // changes color of pixel
			}
		}
	}

	public int checkMandelbrot (Complex c, Complex z) { 
		// checks if complex number c is in mandelbrot set or if it's not how close it is
		// closer the return value is to static int COUNT, closer it is to being in mandelbrot
		int count = 0;
		while (count < COUNT) {
			z = z.times(z);
			Complex ans = z.plus(c);
			if (ans.abs() > 2.0) 
				return count;
			z = ans;
			count++;
		}
		return count;
	}

}
