
import objectdraw.*;
import java.awt.*;

public class MandelbrotFull extends FrameWindowController {
	private final static int COUNT = 1000;
	private final static int WINDOE_SIZE = 1000;
	private final static int SCALE = 350;
	private final static int MIDDLE = 150;
	private final static double QUALITY = 0.001;

	public static void main(String[] args) {
		MandelbrotFull s = new MandelbrotFull();
	}
	public MandelbrotFull() {
		resize(WINDOE_SIZE, WINDOE_SIZE);
		
		//new FilledOval(WINDOE_SIZE/2 + MIDDLE, WINDOE_SIZE/2 - MIDDLE, 10,10,canvas); 
		
		for (double re = -2; re <= 2; re+=QUALITY) {
			for (double im = -2; im <= 2; im+=QUALITY) {
				Complex c = new Complex (re, im);
				int mandel = checkMandelbrot(c, new Complex(0, 0));
				
				//if (mandel == 1000) {
					double realpoint = (WINDOE_SIZE/2) + MIDDLE + re*SCALE;
					double imagpoint = (WINDOE_SIZE/2) - MIDDLE + im*SCALE;
					FilledOval fo = new FilledOval(realpoint, imagpoint, 5,5,canvas); 
					int color = (int) (255 * mandel) / 1000;
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
