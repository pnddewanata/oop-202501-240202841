class MAHASISWA {
    String NAMA; int NIM;
    MAHASISWA(String NM, int NI){NAMA=NM; NIM=NI; }
    void PANGGIL(){ System.out.println("HELLO WORD, IM "+ NAMA + " -"+ NIM);}
}

public class HelloOOP {
    public static void main(String[] args) {
        MAHASISWA RAJIN = new MAHASISWA("MUHAMMAD PANDU DEWANATA YASEH HIDAYAT", 240202841);
        RAJIN.PANGGIL();
    }

}
