package interviewprep.string;

public class DateConversion {

    public static String timeConversion(String s) {
        char ap = s.charAt(s.length()-2);
        String[] splitted = s.split(":");

        StringBuilder stb = new StringBuilder();
        String val;
        if ((ap == 'A') && (Integer.parseInt(splitted[0]) >= 12)) {
//            stb.append(Integer.parseInt(splitted[0]) - 12);
            val = Integer.toString(Integer.parseInt(splitted[0]) - 12);
        } else if ((ap == 'P') && (Integer.parseInt(splitted[0]) < 12)) {
                val = Integer.toString(Integer.parseInt(splitted[0]) + 12);
//            stb.append(Integer.parseInt(splitted[0]) + 12);
        } else {
//            stb.append(splitted[0]);
            val = splitted[0];
        }
        if (val.length() == 1) {
            val = "0" + val;
        }

        stb.append(val);

        stb.append(":");
        stb.append(splitted[1]);
        stb.append(":");
        stb.append(splitted[2].charAt(0));
        stb.append(splitted[2].charAt(1));

        return stb.toString();
    }
    public static void main(String[] args) {
        System.out.println(timeConversion("12:05:45AM"));
    }
}
