public class SiparisIslemleri{

    public static void main(String[] args) {
        // Verilen tablodaki verileri temsil eden bir dizi oluşturuldu.
        int[][] veriler = {
                {1000, 2000, 12, 100510},
                {1000, 2001, 31, 200000},
                {1000, 2002, 22, 150860},
                {1000, 2003, 41, 250000},
                {1000, 2004, 55, 244000},
                {1001, 2001, 88, 44531},
                {1001, 2002, 121, 88110},
                {1001, 2004, 74, 211000},
                {1001, 2002, 14, 88110},
                {1002, 2003, 2, 12100},
                {1002, 2004, 3, 22300},
                {1002, 2003, 8, 12100},
                {1002, 2002, 16, 94000},
                {1002, 2005, 9, 44100},
                {1002, 2006, 19, 90000}
        };

        // a. Üç siparişteki malların toplam tutarının çıktısını veren java kodu.
        toplamTutar(veriler);

        // b. Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.
        ortalamaFiyat(veriler);

        // c. Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.
        malBazliOrtalamaFiyat(veriler);

        // d. Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren java kodu.
        malBazliSiparisAdeti(veriler);
    }

    // a. Üç siparişteki malların toplam tutarının çıktısını veren java kodu.
    private static void toplamTutar(int[][] veriler) {
        int toplamTutar = 0;
        for (int[] siparis : veriler) {
            toplamTutar += siparis[2] * siparis[3]/100;
        }
        System.out.println("a. Üç siparişteki malların toplam tutarı: " + toplamTutar + " TL");
    }

    // b. Üç siparişteki bütün malların ortalama fiyatını bulan java kodu.
    private static void ortalamaFiyat(int[][] veriler) {
        int toplamMiktar = 0;
        int toplamTutar = 0;
        for (int[] siparis : veriler) {
            toplamMiktar += siparis[2];
            toplamTutar += siparis[2] * siparis[3];
        }
        double ortalamaFiyat = (double) toplamTutar / toplamMiktar;
        System.out.println("b. Üç siparişteki bütün malların ortalama fiyatı: " + ortalamaFiyat + " TL");
    }

    // c. Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatını bulan java kodu.
    private static void malBazliOrtalamaFiyat(int[][] veriler) {
        int[] malMiktarlari = new int[veriler.length];
        int[] malToplamTutar = new int[veriler.length];

        for (int i = 0; i < veriler.length; i++) {
            int miktar = veriler[i][2];
            int birimFiyat = veriler[i][3];

            malMiktarlari[i] += miktar;
            malToplamTutar[i] += miktar * birimFiyat;
        }

        System.out.println("c. Üç siparişteki bütün malların tek tek mal bazlı ortalama fiyatı:");

        for (int i = 0; i < veriler.length; i++) {
            int malNumarasi = veriler[i][1];
            double ortalamaFiyat = (double) malToplamTutar[i] / malMiktarlari[i];
            System.out.println("   Mal Numarası " + malNumarasi + ": " + ortalamaFiyat + " TL");
        }
    }

    // d. Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğunun çıktısını veren java kodu.
    private static void malBazliSiparisAdeti(int[][] veriler) {
        System.out.println("d. Tek tek mal bazlı, malların hangi siparişlerde kaç adet olduğu:");

        for (int i = 0; i < veriler.length; i++) {
            int siparisNumarasi = veriler[i][0];
            int malNumarasi = veriler[i][1];
            int miktar = veriler[i][2];

            System.out.println("   Mal Numarası " + malNumarasi + " - Sipariş Numarası " + siparisNumarasi + ": " + miktar + " adet");
        }
    }
}
