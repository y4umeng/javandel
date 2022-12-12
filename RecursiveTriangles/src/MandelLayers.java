
import objectdraw.*;
import java.awt.*;

public class MandelLayers extends FrameWindowController {
	private static int COUNT = 1;
	private final static double QUALITY = 0.01;

	public static void main(String[] args) {
		MandelLayers s = new MandelLayers();
	}
	public MandelLayers() {


		while (COUNT < 100) {
			for (double re = -2.5; re <= 2.5; re+=QUALITY) {
				for (double im = -2.5; im <= 2.5; im+=QUALITY) {
					Complex c = new Complex (re, im);
					int mandel = checkMandelbrot(c, new Complex(0, 0));
					if (mandel == COUNT) {
						FilledOval fo = new FilledOval(200 + re*90,160 + im*90, 2,2,canvas); 
						int color = (int) 255 - (mandel % 255);
						fo.setColor(new Color (color, color, color));
					}
				}
			}
			
			COUNT+= COUNT;
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
