package fukushima;
import java.util.regex.Pattern;
public class Chap05 {
    String str1 = "fnct";
    String str2 = "福井高専";
    public static void main(String[] args) {
        var chap05 = new Chap05();
        chap05.test00();
        chap05.test01();
        chap05.test02();
        chap05.test03();
        chap05.test04();
        chap05.test05();
        chap05.test06();
        chap05.test07();
    }
    @SuppressWarnings("unused")
	protected void test00() {
        Integer v1 = 100;
//        double v2 = Double.parseDouble(1.5);
        long v3 = Integer.parseInt("300");
//        char v4 = "Java".charAt(5);
        boolean v5 = Boolean.parseBoolean("tRUe");
    }
    protected void test01() {
        System.out.println("str1 len=" + str1.length());
        System.out.println("str2 len=" + str2.length());
        byte[] b = str1.getBytes();
        for (int i = 0; i < b.length; i++) {
            System.out.print(String.format(" %02x", b[i]));
        }
        System.out.println("");
        b = str2.getBytes();
        for (int i = 0; i < b.length; i++) {
            System.out.print(String.format(" %02x", b[i]));
        }
        System.out.println("");
        System.out.println("str1 blen=" + str1.getBytes().length);
        System.out.println("str2 blen=" + str2.getBytes().length);
    }
    protected void test02() {
        System.out.println(str2.startsWith("福井"));
        System.out.println(str2.indexOf("高"));
        System.out.println(str2.contains("高専"));
        System.out.println(str2.endsWith("専"));
    }
    protected void test03() {
    	String str1="02";
    	String str2="02";
        System.out.println(str1.compareTo(str2));
        System.out.println(str2.compareTo(str1));
        System.out.println(str1.equals(str2));

    }
    protected void test04() {
        String str = "福井県鯖江市東鯖江3-7-1";
        String substr = str.substring(3,5);
        System.out.println(substr);
        substr = str.substring(str.indexOf("県")+1,str.indexOf("市"));
        System.out.println(substr);
    }
    protected void test05() {
        String[] files = {
                "abc.dat",
                "edfgh.dat",
                "dat.dat",
                "dat.dat.dat"
        };
        for (int i = 0; i < files.length; i++) {
            files[i] = files[i].replaceAll(".dat$", ".mp3");
        }
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }
    protected void test06() {
        String[] variables = {
            "abc_efd_0",
            "3EI",
            "_ab",
            "a-b",
            "AbcDefg99",
            "EI 3",
            "_"
        };
        String regx = "^_?([A-Z]|[a-z])+([A-Z]|[a-z]|[0-9]|_)*";
        for (String v : variables) {
            if (Pattern.matches(regx, v) == false) {
                System.out.println(v);
            }
        }
    }
    protected void test07() {
        String str = "福井高専の電話番号は0778-62-1111です。";
        String regx = "(\\d{2,4})-(\\d{2,4})-(\\d{4})";
        var ptn = Pattern.compile(regx);
        var matcher = ptn.matcher(str);
        for (; matcher.find();) {
            System.out.println("番号0:" + matcher.group(0));
            System.out.println("番号1:" + matcher.group(1));
            System.out.println("番号2:" + matcher.group(2));
            System.out.println("番号3:" + matcher.group(3));
        }
    }
}
