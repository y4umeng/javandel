
import objectdraw.*;
import java.awt.*;

public class MandelbrotStarter extends FrameWindowController {
	private final static int COUNT = 1000;

	public static void main(String[] args) {
		MandelbrotStarter s = new MandelbrotStarter();
	}
	public MandelbrotStarter() {

		// small set

		for (double re = -2.5; re <= 2.5; re+=0.01) {
			for (double im = -2.5; im <= 2.5; im+=0.01) {
				Complex c = new Complex (re, im);
				int mandel = checkMandelbrot(c, new Complex(0, 0));
				if (mandel == COUNT) {
					FilledOval fo = new FilledOval(200 + re*90,160 + im*90, 2,2,canvas); 
				}
				//				else
				//					new FilledOval (200 + re*90,160 + im*90, 5,5,canvas);
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
