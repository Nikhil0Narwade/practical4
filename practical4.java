  class Pro4 {
    public static void main(String[] args) {
    
    byte b = getByte(128);
    System.out.println(b);
 
    short c=getShort(12);
    System.out.println(c);
    
    String result = getNumber(5, "binary");
    System.out.println(result);
    
    String resultt = getNumber(5, "octal");
    System.out.println(resultt);
    
    String resultp = getNumber(5, "short");
    System.out.println(resultp);
    

    
    }

static byte getByte(int num) {  
       byte ans; 
      int temp = num / 128; 
       
      if (temp % 2 == 0) {
          ans = (byte) (num % 128);
       } else {
           ans = (byte) ((num % 128) - 128); 
      }
     return ans; 
    }

 static short getShort(int num) {
     short ans;
       int temp = num / 32768;
       
      if (temp % 2 == 0) {
          ans = (short) (num % 32768);
       } else {
          ans = (short) ((num % 32768) - 32768);
       }
      return ans;
   }
   
   
   
  static String getNumber(int num, String type) {
    String result = "";
    type = type.toLowerCase();  

    switch (type) {
        case "byte":
            result = convertToByte(num);
            break;
        case "short":
            result = convertToShort(num);
            break;
        case "binary":
            result = convertToBinary(num);
            break;
        case "hexadecimal":
            result = convertToHexadecimal(num);
            break;
        case "octal":
            result = convertToOctal(num);
            break;
        default:
            result = "Invalid type";
    }

    return result;
}


static String convertToByte(int num) {
    byte ans;
    int temp = num / 128;
    
    if (temp % 2 == 0) {
        ans = (byte) (num % 128);
    } else {
        ans = (byte) ((num % 128) - 128);
    }
    return String.valueOf(ans);
}


static String convertToShort(int num) {
    short ans;
    int temp = num / 32768;  // 32768 is the max value for a short
    
    if (temp % 2 == 0) {
        ans = (short) (num % 32768);
    } else {
        ans = (short) ((num % 32768) - 32768);
    }
    return String.valueOf(ans);
}

static String convertToBinary(int num) {
    StringBuilder binary = new StringBuilder();
    if (num == 0) return "0";
    
    while (num != 0) {
        binary.insert(0, num % 2);
        num /= 2;
    }
    return binary.toString();
}

static String convertToHexadecimal(int num) {
    StringBuilder hex = new StringBuilder();
    if (num == 0) return "0";
    
    while (num != 0) {
        int remainder = num % 16;
        hex.insert(0, (remainder < 10) ? (char) ('0' + remainder) : (char) ('A' + remainder - 10));
        num /= 16;
    }
    return hex.toString();
}

static String convertToOctal(int num) {
    StringBuilder octal = new StringBuilder();
    if (num == 0) return "0";
    
    while (num != 0) {
        octal.insert(0, num % 8);
        num /= 8;
    }
    return octal.toString();
}
 
 
 
 

    public static String toXXString(String num, String XX) {
             num = num.toLowerCase();
             int givenRadix = 10;

             if(num.startsWith("0b") || num.startsWith("0B")) {
                 givenRadix = 2;
             }else if(num.matches("^0[xX]?[0-9a-fA-F]+$")) {
                 givenRadix = 16;
             }else if(num.startsWith("0o") || num.startsWith("0")) {
                 givenRadix = 8;
             } else {
                 givenRadix = 10;
             }
             if(num.startsWith("0x") || num.startsWith("0b") || num.startsWith("0o") ) {
                 num = num.substring(2);
             }
        
             switch(XX.toLowerCase()) {
                case "b": return getBinary(num, givenRadix);
                case "o": return getOctal(num, givenRadix);
                case "h": return getHexadecimal(num, givenRadix);
                default : return getDecimal(num, givenRadix); }
        }

        public static String getBinary(String num, int radix) {
                Integer i = Integer.parseInt(num, radix);
                return Integer.toBinaryString(i);
            }
            
        public static String getHexadecimal(String num, int radix) {
                 Integer i = Integer.parseInt(num, radix);
                 return Integer.toHexString(i);
            }
        
        public static String getOctal(String num, int radix) {
                Integer i = Integer.parseInt(num, radix);
                return Integer.toOctalString(i);
            }

        public static String getDecimal(String num, int radix) {
                Integer i = Integer.parseInt(num, radix);
                return i.toString();
            }

}
