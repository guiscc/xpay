package com.xpay.channel.common.util;

import java.security.MessageDigest;


public class MD5Util {

	private static String byteArrayToHexString(byte b[]) {
		StringBuffer resultSb = new StringBuffer();
		for (int i = 0; i < b.length; i++)
			resultSb.append(byteToHexString(b[i]));
		return resultSb.toString();
	}

	private static String byteToHexString(byte b) {
		int n = b;
		if (n < 0)
			n += 256;
		int d1 = n / 16;
		int d2 = n % 16;
		return hexDigits[d1] + hexDigits[d2];
	}

	public static String MD5Encode(String origin, String charsetname) {
		String resultString = null;
		try {
			resultString = new String(origin);
			MessageDigest md = MessageDigest.getInstance("MD5");
			if (charsetname == null || "".equals(charsetname)){
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes()));
			}else{
				resultString = byteArrayToHexString(md.digest(resultString
						.getBytes(charsetname)));
			}	
		} catch (Exception exception) {
		}
		return resultString;
	}

	private static final String hexDigits[] = { "0", "1", "2", "3", "4", "5",
			"6", "7", "8", "9", "a", "b", "c", "d", "e", "f" };
	
		
	public static String sha1(String str) {
		if (str == null || str.length() == 0) {
			return null;
		}
		
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		
		try {
			MessageDigest mdTemp = MessageDigest.getInstance("SHA1");
			mdTemp.update(str.getBytes());
			
			byte[] md = mdTemp.digest();
			int j = md.length;
			char buf[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				buf[k++] = hexDigits[byte0 >>> 4 & 0xf];
				buf[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(buf);
		} catch (Exception e) {
			return null;
		}
	}

	
	  public static final String getMessageDigest(byte[] buffer)
	  {
	    char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
	    try {
	      MessageDigest mdTemp = MessageDigest.getInstance("MD5");
	      mdTemp.update(buffer);
	      byte[] md = mdTemp.digest();
	      int j = md.length;
	      char[] str = new char[j * 2];
	      int k = 0;
	      for (int i = 0; i < j; ++i) {
	        byte byte0 = md[i];
	        str[(k++)] = hexDigits[(byte0 >>> 4 & 0xF)];
	        str[(k++)] = hexDigits[(byte0 & 0xF)];
	      }
	      return new String(str); } catch (Exception e) {
	    }
	    return null;
	  }

	/**
	 *
	 * @param text
	 * @param salt
	 * @return
	 * @throws Exception
	 */
	public static String md5(String text, String salt) throws Exception {
		byte[] bytes = (text + salt).getBytes();

		MessageDigest messageDigest = MessageDigest.getInstance("MD5");
		messageDigest.update(bytes);
		bytes = messageDigest.digest();

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < bytes.length; i++) {
			if ((bytes[i] & 0xff) < 0x10) {
				sb.append("0");
			}
			sb.append(Long.toString(bytes[i] & 0xff, 16));
		}
		return sb.toString().toLowerCase();
	}

}
