import java.util.function.BiConsumer;
public class HelloFunctional {
    public static void main(String[] args) {
        BiConsumer<String, Integer> PANGGIL =
            (NAMA, NIM)-> System.out.println("HELLO WORD, IM "+ NAMA + "-"+ NIM);
            PANGGIL.accept("MUHAMMAD PANDU DEWANATA YASEH HIDAYAT", 240202841);
        
    }
}
