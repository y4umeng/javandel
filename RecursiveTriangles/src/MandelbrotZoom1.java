
import objectdraw.*;
import java.awt.*;

public class MandelbrotZoom1 extends FrameWindowController {
	private final static int COUNT = 1000;
	private final static int WINDOE_SIZE = 1000;
	private final static int SCALE = 1700;
	private final static int REALMIDDLE = 800;
	private final static int IMAGMIDDLE = -800;
	private final static double QUALITY = 0.01;

	
	// actual good zoom
	
	
	public static void main(String[] args) {
		MandelbrotZoom1 s = new MandelbrotZoom1();
	}
	public MandelbrotZoom1() {
		resize(WINDOE_SIZE, WINDOE_SIZE);
		
		new FilledOval(WINDOE_SIZE/2 + REALMIDDLE, WINDOE_SIZE/2 - IMAGMIDDLE, 10,10,canvas); 
		//new FilledOval(200,160,10,10,canvas);
		
		for (double re = -0.9; re <= -0.1; re+=QUALITY) {
			for (double im = -2; im <= -.3; im+=QUALITY) {
				Complex c = new Complex (re, im);
				int mandel = checkMandelbrot(c, new Complex(0, 0));
				
				//if (mandel == 1000) {
					double realpoint = (WINDOE_SIZE/2) + REALMIDDLE + re*SCALE;
					double imagpoint = (WINDOE_SIZE/2) - IMAGMIDDLE + im*SCALE;
					//System.out.println(realpoint + ", " + imagpoint);
					FilledOval fo = new FilledOval(realpoint, imagpoint, 10,10,canvas); 
					int color = (int) 255 - (mandel % 255);
					fo.setColor(new Color (color, color, color));
				//}
			}

		}
	}

	public int checkMandelbrot (Complex c, Complex z) {
		int count = 0;
		while (count < COUNT) {
			z = z.times(z);
			Complex ans = z.plus(c);
			if (ans.abs() > 2.0) {
				//System.out.println(ans);
				return count;
			}
			else
				z = ans;
			count++;
		}
		return count;
	}

}
