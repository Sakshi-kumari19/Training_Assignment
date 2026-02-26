//Q2.Lambda expression to add space between each character of given string.
package Excercise2;

public class StringFormat {
    public static void main(String[] args) {
        Formatted st = (s)->{
            StringBuilder newst = new StringBuilder();
            for(int i=0;i<s.length();i++){
                newst.append(s.charAt(i));
                newst.append(" ");
            }
            return newst.toString();
        };

        System.out.println(st.addspace("row"));
    }
}

