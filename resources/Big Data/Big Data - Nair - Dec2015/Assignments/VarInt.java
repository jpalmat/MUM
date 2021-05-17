/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package W2D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 *
 * @author 984363
 */
public class VarInt {

	public static int byteRequiredForInt(int n) {
		int size = 1;
		if ((n >>> 28) != 0)
			size = 5;
		else if ((n >>> 21) != 0)
			size = 4;
		else if ((n >>> 14) != 0)
			size = 3;
		else if ((n >>> 7) != 0)
			size = 2;

		return size;
	}

	public static int[] dgap(int[] input){
		int prev = input[0];
            	for(int i=2;i<input.length;i+=2){
               		int temp = input[i] - prev;
               		prev = input[i];
               		input[i] = temp;
            	}
            	return input;
	}
	public static byte[] encodeInt(int n) {
		int size = byteRequiredForInt(n);

		byte[] code = new byte[size];

		for (int i = 0; i < size; i++) {
			code[i] = (byte) (n & 0x0000007F);
			n = n >>> 7;
		}
		byte mask = (byte) 0x80;
		code[0] = (byte) (code[0] | mask);

		return code;
	}

	public static int decodeInt(byte[] code) {
		byte mask = (byte) 0x7F;
		code[0] = (byte) (code[0] & mask);

		int n = 0;
		for (int i = code.length - 1; i >= 0; i--) {
			n = n << 7;
			n = (n | code[i]);
		}
		return n;
	}

	public static byte[] encode(int[] values) {
		byte[] codes = new byte[0];
		for (int value : values) {
			codes = combine(codes, encodeInt(value));
		}
		return codes;
	}

	public static byte[] combine(byte[] a, byte[] b) {
		int length = a.length + b.length;
		byte[] result = new byte[length];
		System.arraycopy(a, 0, result, 0, a.length);
		System.arraycopy(b, 0, result, a.length, b.length);
		return result;
	}

	public static int[] decode(byte[] code) {
		List<Integer> result = new ArrayList<Integer>();
		List<Byte> encodeByte = new ArrayList<Byte>();
		for (int i = 0; i < code.length; i++) {
			encodeByte.add(code[i]);
			if (i == code.length - 1) {
				result.add(decodeInt(toByteArray(encodeByte)));
				break;
			}
			String next = toStringByte(code[i + 1]);
			if (next.charAt(0) == '1') {
				result.add(decodeInt(toByteArray(encodeByte)));
				encodeByte.clear();
			}
		}
		return toIntArray(result);
	}

	private static int[] toIntArray(List<Integer> list) {
		int[] ret = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	private static byte[] toByteArray(List<Byte> list) {
		byte[] ret = new byte[list.size()];
		for (byte i = 0; i < list.size(); i++) {
			ret[i] = list.get(i);
		}
		return ret;
	}

	public static String toStringByte(byte b) {
		String str = "";
		StringBuilder sb = new StringBuilder("");
		for (int i = 0; i < 8; i++) {
			str = (b < 0) ? "1" : "0";
			sb.append(str);
			b = (byte) (b << 1);
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		int[] plist = { 100, 8, 150, 7, 300, 24, 500, 36 };
		//int[] plist2 = { 500 };
		// you can add whatever you want
		byte[] encodeBytes = encode(plist);
		System.out.println("Encode byte");
		for (byte b : encodeBytes) {
			System.out.print(toStringByte(b));
		}

		System.out.println("\nDecode int");
		for (int i : decode(encodeBytes)) {
			System.out.print(i + " ");
		}

		// System.out.println(decodeInt(encodeInt(500)));

	}

}
