/*
 *  IMAGE EXTRACTION LIBRARY
 *
 *  DISCOVIR - Distributed Content-based Visual Information Retrieval System on Peer-to-Peer(P2P) Network
 *  http://www.cse.cuhk.edu.hk/~miplab/discovir
 *
 *  Copyright (C) 2002  Multimedia Information Processing Laboratory
 *  http://www.cse.cuhk.edu.hk/~miplab
 *  The Chinese University of Hong Kong
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 *
 */
package com.util.biometric;

import java.awt.*;
import java.awt.color.*;


/** The methods of this class are used to return an array of values containing the converted
 * color model, by inputting an array of values used to convert.
 * All values in the array for both input and output are for separate components.
 * For example, two RGB pixel is a 'double' array of size 6, [R, G, B, R, G, B].
 *
 * @author Mo How Shin
 * @modified Tong Kan Chuen Arthur
 */
public class ColorConversion
{
	/** Public method responsible for magnifying and reducing the input ranges
	 * double:	[0,1]
	 * int:	[0,255]
	 *
	 * @param d a double array
	 * @return Int array
	 */
	public static int[] double2int(double[] d)
	{
		int[] result = new int[d.length/3];
		for (int i=0; i<d.length; i+=3) {
			result[i] = (int)Math.round(d[i]*255) << 16;
			result[i] |= (int)Math.round(d[i+1]*255) << 8;
			result[i] |= (int)Math.round(d[i+2]*255);
		}
		return (result);
	}

	/** Public method responsible for magnifying and reducing the input ranges
	 * double:	[0,1]
	 * int:	[0,255]
	 *
	 * @param in int array
	 * @return double array
	 */
	public static double[] int2double(int[] in)
	{
		double[] result = new double[in.length*3];
		for (int i=0; i<in.length; i++) {
			result[i*3] = ((in[i]>>16&0xff) / 255.0);
			result[i*3+1] = ((in[i]>>8&0xff) / 255.0);
			result[i*3+2] = ((in[i]&0xff) / 255.0);
		}
		return (result);
	}

	/** Convert RGB to CMY
	 * Input	: [0,1]
	 * Output	: [0,1]
	 *
	 * @param rgb double array of RGB
	 * @return double array of CMY
	 */
	public static double[] RGB2CMY01(double[] rgb)
	{
		double[] cmy = new double[rgb.length];
		int i = 0;
		/*
		 * [C] = [1] - [R]
		 * [M] = [1] - [G]
		 * [Y] = [1] - [B]
		 */
		for (i = 0; i < rgb.length; i++)
			cmy[i]   = 1 - rgb[i];
		return (cmy);
	}

	/** Convert RGB to CMY
	 * Input	: [0,255]
	 * Output	: [0,255]
	 *
	 * @param rgb int array of RGB
	 * @return int array of CMY
	 */
	public static int[] RGB2CMY256(int[] rgb)
	{
		int[] cmy = new int[rgb.length];
		for (int i = 0; i < rgb.length; i++)
			cmy[i]   = ~rgb[i];
		return (cmy);
	}

	/** Convert RGB to CMY
	 * Input	: [0,1]
	 * Output	: [0,255]
	 *
	 * @param rgb double array of RGB
	 * @return int array of CMY
	 */
	public static int[] RGB2CMY256(double[] rgb)
	{
		return (double2int(RGB2CMY01(rgb)));
	}

	/** Convert RGB to CMY
	 * Input	: [0,255]
	 * Output	: [0,1]
	 *
	 * @param rgb int array of RGB
	 * @return double array of CMY
	 */
	public static double[] RGB2CMY01(int[] rgb)
	{
		return (RGB2CMY01(int2double(rgb)));
	}

	/** Convert CMY to RGB
	 * Input	: [0,1]
	 * Output	: [0,1]
	 *
	 * @param cmy double array of CMY
	 * @return double array of RGB
	 */

	public static double[] CMY2RGB01(double[] cmy)
	{
		double[] rgb = new double[cmy.length];
		int i = 0;
		/*
		 * [R] = [1] - [C]
		 * [G] = [1] - [M]
		 * [B] = [1] - [Y]
		 */
		for (i = 0; i < cmy.length; i++)
			rgb[i] = 1 - cmy[i];
		return (rgb);
	}

	/** Convert CMY to RGB
	 * Input	: [0,255]
	 * Output	: [0,255]
	 *
	 * @param cmy int array of CMY
	 * @return int array of RGB
	 */
	public static int[] CMY2RGB256(int[] cmy)
	{
		int[] rgb = new int[cmy.length];
		for (int i = 0; i < cmy.length; i++)
			rgb[i]   = ~cmy[i];
		return (cmy);
	}

	/** Convert CMY to RGB
	 * Input	: [0,1]
	 * Output	: [0,255]
	 *
	 * @param rgb double array of CMY
	 * @return int array of RGB
	 */
	public static int[] CMY2RGB256(double[] rgb)
	{
		return (double2int(CMY2RGB01(rgb)));
	}

	/** Convert CMY to RGB
	 * Input	: [0,255]
	 * Output	: [0,1]
	 *
	 * @param rgb int array of RGB
	 * @return double array of RGB
	 */
	public static double[] CMY2RGB01(int[] rgb)
	{
		return (CMY2RGB01(int2double(rgb)));
	}

	/** Convert RGB to YIQ
	 * Input	: [0,1]
	 * Output	: [0,1]
	 *
	 * @param rgb double array of RGB
	 * @return double array of YIQ
	 */
	public static double[] RGB2YIQ01(double[] rgb)
	{
		double[] yiq = new double[rgb.length];
		int i = 0;
		/*
		 * [Y]   [ 0.299   0.587   0.114] [R]
		 * [I] = [ 0.596  -0.275  -0.321] [G]
		 * [Q]   [ 0.212  -0.523   0.311] [B]
		 */
		for (i = 0; i < rgb.length; i = i + 3)
		{
			yiq[i]   = 0.299*rgb[i] + 0.587*rgb[i+1] + 0.114*rgb[i+2];
			yiq[i+1] = 0.596*rgb[i] - 0.275*rgb[i+1] - 0.321*rgb[i+2];
			yiq[i+2] = 0.212*rgb[i] - 0.523*rgb[i+1] + 0.311*rgb[i+2];
		}
		return (yiq);
	}

	/** Convert RGB to YIQ
	 * Input	: [0,255]
	 * Output	: [0,255]
	 *
	 * @param rgb int array of RGB
	 * @return int array of YIQ
	 */
	public static int[] RGB2YIQ256(int[] rgb)
	{
		return (double2int(RGB2YIQ01(int2double(rgb))));
	}

	/** Convert RGB to YIQ
	 * Input	: [0,1]
	 * Output	: [0,255]
	 *
	 * @param rgb double array of RGB
	 * @return int arry of YQI
	 */
	public static int[] RGB2YIQ256(double[] rgb)
	{
		return (double2int(RGB2YIQ01(rgb)));
	}

	/** Convert RGB to YIQ
	 * Input	: [0,255]
	 * Output	: [0,1]
	 *
	 * @param rgb int array of RGB
	 * @return double array of YIQ
	 */
	public static double[] RGB2YIQ01(int[] rgb)
	{
		return (RGB2YIQ01(int2double(rgb)));
	}


	/** Convert YIQ to RGB
	 * Input	: [0,1]
	 * Output	: [0,1]
	 *
	 * @param yiq double array of YIQ
	 * @return double array of RGB
	 */
	public static double[] YIQ2RGB01(double[] yiq)
	{
		double[] rgb = new double[yiq.length];
		int i = 0;

		/*
		 * [R]   [ 1   0.956   0.621] [Y]
		 * [G] = [ 1  -0.272  -0.647] [I]
		 * [B]   [ 1  -1.105   1.702] [Q]
		 */
		for (i = 0; i < rgb.length; i = i + 3)
		{
			rgb[i]   = yiq[i] + 0.956*yiq[i+1] + 0.621*yiq[i+2];
			rgb[i+1] = yiq[i] - 0.272*yiq[i+1] - 0.647*yiq[i+2];
			rgb[i+2] = yiq[i] - 1.105*yiq[i+1] + 1.702*yiq[i+2];
		}
		return (rgb);
	}

	/** Convert YIQ to RGB
	 * Input	: [0,255]
	 * Output	: [0,255]
	 *
	 * @param rgb int array of YIQ
	 * @return int array of RGB
	 */
	public static int[] YIQ2RGB256(int[] yiq)
	{
		return (double2int(YIQ2RGB01(int2double(yiq))));
	}

	/** Convert YIQ to RGB
	 * Input	: [0,1]
	 * Output	: [0,255]
	 *
	 * @param rgb double array of YIQ
	 * @return int array of RGB
	 */
	public static int[] YIQ2RGB256(double[] yiq)
	{
		return (double2int(YIQ2RGB01(yiq)));
	}

	/** Convert YIQ to RGB
	 * Input	: [0,255]
	 * Output	: [0,1]
	 *
	 * @param rgb int array of YIQ
	 * @return double array of RGB
	 */
	public static double[] YIQ2RGB01(int[] yiq)
	{
		return (YIQ2RGB01(int2double(yiq)));
	}

	/** Transform the RGB array into a gray scale array
	 *
	 * @param rgb int array of RGB
	 * @level number of gray scale level
	 * @return gray int array of grayscal
	 */
	public static int[] RGB2grayscale(int[] rgb, int level)
	{
		int Y[] = new int[rgb.length];
		int i = 0;

		for (i = 0; i < rgb.length; i++)
		{
			// Y = 0.299R + 0.587G + 0.114B
			Y[i] = (int)((0.299 * (rgb[i]>>16 & 0xff) + 0.587 * (rgb[i]>>8 & 0xff)
					+ 0.114 * (rgb[i] & 0xff)) / 256 * level + 0.5);
		}

		return Y;
	}

	/** Transform the RGB array into a gray scale array of 256 levels
	 *
	 * @param rgb int array of RGB
	 * @return gray int array of grayscal of 256 levels
	 */
	public static int[] RGB2grayscale256(int[] rgb)
	{
		return RGB2grayscale(rgb, 256);
	}


	/** RGB model convert to HSI model
	 * Input	: [0,1]
	 * Output	: [0,1] for SI; [0,2PI] for H
	 *
	 * @param rgb double array of RGB
	 * @return double array of HSI
	 */
	public static double[] RGB2HSI(double[] rgb)
	{
		double[] hsi = new double[rgb.length];
		int i = 0;
		double max, min, diff, r, g, b;

		for (i = 0; i < rgb.length; i = i + 3)
		{
			/*
			 * For 0 <= R,G,B <= 1
			 *
			 * H = cos^(-1){{0.5 * [(R-G)+(R-B)]}/[(R-G)^2+(R-B)(G-B)]^(0.5)}
			 * 	** H is in range [0, 2PI]
			 * S = 1 - [3 / (R + G + B)] * min(R,G,B)
			 * I = (R + G + B) / 3
			 *
			 * If B/I > G/I then H = 2 * PI - H
			 * if R = G = B, H is undefined. and if I = 0, S is undefined.
			 */

			r = rgb[i]; g = rgb[i+1]; b = rgb[i+2];
			min = Math.min(r,g); min = Math.min(min, b);

			hsi[i] = Math.acos
				((0.5*((r-g)+(r-b))) / Math.pow((Math.pow(r-g,2) + (r-b)*(g-b)), 0.5));
			hsi[i+1] = 1 - (3.0 / (r + g + b)) * min;
			hsi[i+2] = (r + g + b) / 3.0;

			if ((b / hsi[i+2]) > (g / hsi[i+2]))
			{
				hsi[i] = 2 * Math.PI - hsi[i];
			}

			if ((r == g) && (g == b))
			{
				hsi[i] = -1;
				if (hsi[i+2] == 0)
				{
					hsi[i+1] = -1;
				}
			}
		}
		return (hsi);
	}

	/** RGB model convert to HSI model
	 * Input	: [0,255]
	 * Output	: [0,1] for SI; [0,2PI] for H
	 *
	 * @param rgb int array of RGB
	 * @return double array of HSI
	 */
	public static double[] RGB2HSI(int[] rgb)
	{
		return (RGB2HSI(int2double(rgb)));
	}

	/** HSI model convert to RGB model
	 * Input	: [0,1] for SI; [0,2PI] for H
	 * Output	: [0,1]
	 *
	 * @param hsi double array of HSI
	 * @return double array of RGB
	 */
	public static double[] HSI2RGB01(double[] hsi)
	{
		double[] rgb = new double[hsi.length];
		int k = 0;
		double h, s, i;

		for (k = 0; k < hsi.length; k = k + 3)
		{
			h = hsi[k]; s = hsi[k+1]; i = hsi[k+2];

			/*
			 * Case : 0 < H <= 2 * PI / 3
			 *
			 * R = I * [ 1 + ((S * cos(H))/cos(PI/3 - H))]
			 * G = 3I * (1 - (R+B)/3I)
			 * B = I*(1-S)
			 */
			if ((0 < h) && (h <= 2 * Math.PI / 3))
			{
				rgb[k] = i * (1 + ((s * Math.cos(h)) / Math.cos(Math.PI / 3 - h)));
				rgb[k+2] = i * (1 - s);
				rgb[k+1] = 3 * i * (1 - (rgb[k] + rgb[k+2]) / (3 * i));
			}
			/*
			 * Case : 2 * PI / 3 < H <= 4 * PI / 3
			 *
			 * H = H - 2 * PI / 3
			 *
			 * G = I * (1 - S)
			 * R = I * (1 + ((S * cos(H)) / cos(PI/3 - H)))
			 * B = 3 * I * (1 - (R + G) / (3 * I))
			 */
			else if ((2 * Math.PI / 3 < h) && (h <= 4 * Math.PI / 3))
			{
				h = h - 2 * Math.PI / 3;

				rgb[k+1] = i * (1 - s);
				rgb[k] = i * (1 + ((s * Math.cos(h)) / Math.cos(Math.PI / 3 - h)));
				rgb[k+2] = 3 * i * (1 - (rgb[k] + rgb[k+1]) / (3 * i));
			}
			/*
			 * Case : 4 * PI / 3 < H <= 2 * PI
			 *
			 * H = H - 4 * PI / 3
			 *
			 * B = I * (1 + (S * cos(H)) / cos(PI/3 - H))
			 * G = I * (1 - S)
			 * R = 3 * I * (1 - (G + B) / (3 * I))
			 */
			else if ((4 * Math.PI / 3 < h) && (h <= 2 * Math.PI))
			{
				h = h - 4 * Math.PI / 3;

				rgb[k+2] = i * (1 + (s * Math.cos(h)) / Math.cos(Math.PI / 3 - h));
				rgb[k+1] = i * (1 - s);
				rgb[k] = 3 * i * (1 - (rgb[k+1] + rgb[k+2]) / (3 * i));
			}
			else
			{
				System.out.println("The hue value is out of range.");
			}
		}

		return (rgb);
	}

	/** HSI model convert to RGB model
	 * Input	: [0,1] for SI; [0,2PI] for H
	 * Output	: [0,255]
	 *
	 * @param rgb double array of HSI
	 * @return int array of RGB
	 */
	public static int[] HSI2RGB256(double[] hsi)
	{
		return (double2int(HSI2RGB01(hsi)));
	}

	/** RGB model convert to XYZ model
	 * Input	: [0,1]
	 * Output	: [0,1]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb double array of RGB
	 * @return double array of XYZ
	 */
	public static double[] RGB2XYZ01(double[] rgb)
	{
		double[] xyz = new double[rgb.length];
		int i = 0;

		/*
		 * [X] = [ 0.412453  0.357580  0.180423 ] [R]
		 * [Y] = [ 0.212671  0.715160  0.072169 ] [G]
		 * [Z] = [ 0.019334  0.119193  0.950227 ] [B]
		 */

		for (i = 0; i < rgb.length; i = i + 3)
		{
			xyz[i]   = 0.412453*rgb[i] + 0.357580*rgb[i+1] + 0.180423*rgb[i+2];
			xyz[i+1] = 0.212671*rgb[i] + 0.715160*rgb[i+1] + 0.072169*rgb[i+2];
			xyz[i+2] = 0.019334*rgb[i] + 0.119193*rgb[i+1] + 0.950227*rgb[i+2];
		}

		return (xyz);
	}

	/** RGB model convert to XYZ model
	 * Input	: [0,255]
	 * Output	: [0,255]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb int array of RGB
	 * @return int array of XYZ
	 */
	public static int[] RGB2XYZ256(int[] rgb)
	{
		return (double2int(RGB2XYZ01(int2double(rgb))));
	}

	/** RGB model convert to XYZ model
	 * Input	: [0,1]
	 * Output	: [0,255]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb double array of RGB
	 * @return int array of XYZ
	 */
	public static int[] RGB2XYZ256(double[] rgb)
	{
		return (double2int(RGB2XYZ01(rgb)));
	}

	/** RGB model convert to XYZ model
	 * Input	: [0,255]
	 * Output	: [0,1]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb int array of RGB
	 * @return double array of XYZ
	 */
	public static double[] RGB2XYZ01(int[] rgb)
	{
		return (RGB2XYZ01(int2double(rgb)));
	}

	/** XYZ model convert to RGB model
	 * Input	: [0,1]
	 * Output	: [0,1]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param xyz double array of XYZ
	 * @return double array of RGB
	 */
	public static double[] XYZ2RGB01(double[] xyz)
	{
		double[] rgb = new double[xyz.length];
		int i = 0;

		/*
		 * [R] = [ 3.240479  -1.537150  -0.498535 ] [X]
		 * [G] = [-0.969256   1.875992   0.041556 ] [Y]
		 * [B] = [ 0.055648  -0.204043   1.057311 ] [Z]
		 */

		for (i = 0; i < xyz.length; i = i + 3)
		{
			rgb[i]   = 3.240479*xyz[i] - 1.537150*xyz[i+1] - 0.498535*xyz[i+2];
			rgb[i+1] = -0.969256*xyz[i] + 1.875992*xyz[i+1] + 0.041556*xyz[i+2];
			rgb[i+2] = 0.055648*xyz[i] - 0.204043*xyz[i+1] + 1.057311*xyz[i+2];
		}

		return (rgb);
	}

	/** XYZ model convert to RGB model
	 * Input	: [0,255]
	 * Output	: [0,255]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb int array of RGB
	 * @return int array of XYZ
	 */
	public static int[] XYZ2RGB256(int[] rgb)
	{
		return (double2int(XYZ2RGB01(int2double(rgb))));
	}

	/** XYZ model convert to RGB model
	 * Input	: [0,1]
	 * Output	: [0,255]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb double array of XYZ
	 * @return int array of RGB
	 */
	public static int[] XYZ2RGB256(double[] rgb)
	{
		return (double2int(XYZ2RGB01(rgb)));
	}

	/** XYZ model convert to RGB model
	 * Input	: [0,255]
	 * Output	: [0,1]
	 *
	 * Some XYZ color may be transformed to RGB values that are negative or
	 * greater than one. This means that not all visible colors can be
	 * produced using the RGB system.
	 *
	 * @param rgb int array of XYZ
	 * @return double array of RGB
	 */
	public static double[] XYZ2RGB01(int[] rgb)
	{
		return (XYZ2RGB01(int2double(rgb)));
	}


/*
	public static double[] XYZ2UVW(double[] xyz)
	{
		double uvw[] = new double[xyz.length];


		return (uvw);
	}
	public static double[] RGB2UVW(double[] rgb)
	{
		double[] uvw = new double[rgb.length];
		double[] xyz = new double[rgb.length];

		xyz = RGB2XYZ(rgb);


		return (uvw);
	}

	public static double[] XYZ2Lab(double[] xyz)
	{
		double[] lab = new double[xyz.length];

		// Observer. = 2 degree, Illuminant = D65
		double ref_X = 95.047,
		       ref_Y = 100.000,
		       ref_Z = 108.883,

		       var_X, var_Y, var_Z;

		return (lab);
	}



	public static double[] RGB2Lab(double[] rgb)
	{
		double[] lab = new double[rgb.length];
		double[] xyz = new double[rgb.length];

		xyz = RGB2XYZ(rgb);

		return (lab);
	}
*/

	/** Convert RGB to HSV
	 *
	 * input and output value : RGB [0, 255],
	 * H: any floating point number. The floor of this number is subtracted
	 * from it to create a fraction between 0 and 1. This fractional
	 * number is then multiplied by 360 to produce the hue angle in the
	 * HSB model.
	 * S, V : [0,1]
	 *
	 * @param rgb int array of RGB
	 * @return float array of HSV
	 */
	public static double[] RGB2HSV(int[] rgb)
	{
		double[] hsv = new double[rgb.length*3];
		float[] temp = new float[3];
		int i = 0;

		for (i = 0; i < rgb.length; i++)
		{
			Color.RGBtoHSB(rgb[i]>>24&0xff, rgb[i]>>16&0xff, rgb[i]&0xff, temp);
			hsv[3*i] = (double)temp[0];
			hsv[3*i+1] = (double)temp[1];
			hsv[3*i+2] = (double)temp[2];
		}

		return (hsv);
	}

	/** Convert HSV to RGB
	 *
	 * input and output value : RGB [0, 255],
	 * H: any floating point number. The floor of this number is subtracted
	 * from it to create a fraction between 0 and 1. This fractional
	 * number is then multiplied by 360 to produce the hue angle in the
	 * HSB model.
	 * S, V : [0,1]
	 *
	 * @param hsv double array of HSV
	 * @return int array of RGB
	 */
	public static int[] HSV2RGB256(double[] hsv)
	{
		int[] rgb = new int[hsv.length/3];
		int temp;
		int i = 0;

		for (i = 0; i < hsv.length/3; i++)
		{
			rgb[i] = Color.HSBtoRGB((float)hsv[3*i], (float)hsv[3*i+1], (float)hsv[3*i+2]);
		}

		return (rgb);
	}

	/************************************************************************/
/*
	public static int[] RGB2RGBc(int[] from)
	{
		int[] to = new int[from.length];

		return (to);
	}

	public static int[] RGB2RGBprime(int[] from)
	{
		int[] to = new int[from.length];

		return (to);
	}

	public static int[] RGB2HLS(int[] from)
	{
		int[] to = new int[from.length];

		return (to);
	}
*/
}