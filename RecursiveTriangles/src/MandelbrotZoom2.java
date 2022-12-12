
import objectdraw.*;
import java.awt.*;

public class MandelbrotZoom2 extends FrameWindowController {
	private final static int COUNT = 1000;
	private final static int WINDOE_SIZE = 1000;
	private final static int SCALE = 350;
	private final static int REALOFFSET = 150;
	private final static int IMAGOFFSET = 150;
	private final static double QUALITY = 0.005;
	private final static double REALZOOM = 0;
	private final static double IMAGZOOM = 0;
	private final static double ZOOMSCALE = 2;

	public static void main(String[] args) {
		MandelbrotZoom2 s = new MandelbrotZoom2();
	}
	
	// RAINBOW MANDELBROT
	
	public MandelbrotZoom2() {
		resize(WINDOE_SIZE, WINDOE_SIZE);
		
		//new FilledOval(WINDOE_SIZE/2 + REALOFFSET, WINDOE_SIZE/2 - IMAGOFFSET, 10,10,canvas); 
		
		
		for (double re = REALZOOM - ZOOMSCALE; re <= REALZOOM + ZOOMSCALE; re+=QUALITY) {
			for (double im = IMAGZOOM - ZOOMSCALE; im <= IMAGZOOM + ZOOMSCALE; im+=QUALITY) {
				Complex c = new Complex (re, im);
				// int mandel = checkMandelbrot(c, new Complex(0, 0));
				Object [] returns = checkMandelbrot (c, new Complex(0, 0));
				

					double realpoint = (WINDOE_SIZE /2)+ REALOFFSET + re*SCALE;
					double imagpoint = (WINDOE_SIZE/2) - IMAGOFFSET + im*SCALE;
					FilledOval fo = new FilledOval(realpoint, imagpoint, 3,3,canvas); 
					//zn 
					int mandel = (int) returns[1];
					Complex finalAns = (Complex) returns[0];
					Complex zn = finalAns.times(new Complex(mandel, 0));
					float nsmooth = (float) (COUNT + 1 - Math.log(Math.log(zn.abs()))/Math.log(2));
					

//					float hue = 1; //hue
//					float saturation = 0.6f; //saturation
//					float brightness = mandel*0.001f; //brightness
//					Color myRGBColor = Color.getHSBColor(hue, saturation, brightness);
					//fo.setColor(myRGBColor);
			
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
