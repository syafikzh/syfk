import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Kopikenanganjiwa {

    static String[] dontbelate = new String[400];
    static String[] goncangjiwa = new String[300];
    static String[] jalankenangan = new String[300];
    static String[] tanparasa = new String[250];

    static int stok = dontbelate.length + goncangjiwa.length + jalankenangan.length + tanparasa.length;
    static int sisa = stok;

    public static void main(String[] args) {
        System.out.println("=========================================================\n\t\tProgram Pesan Kopi\n=========================================================");

        pesan();
    }

    static void print_data_pesanan() {
        //menambah total dengan mengecek setiap slot array jenis kopi yang terisi
        int total_dontbelate = 0;
        for (int i = 0; i < dontbelate.length; i++) {
            if (dontbelate[i] != null) {
                total_dontbelate++;
            }
        }

        int total_goncangjiawa = 0;
        for (int i = 0; i < goncangjiwa.length; i++) {
            if (goncangjiwa[i] != null) {
                total_goncangjiawa++;
            }
        }

        int total_jalankenangan = 0;
        for (int i = 0; i < jalankenangan.length; i++) {
            if (jalankenangan[i] != null) {
                total_jalankenangan++;
            }
        }

        int total_tanparasa = 0;
        for (int i = 0; i < tanparasa.length; i++) {
            if (tanparasa[i] != null) {
                total_tanparasa++;
            }
        }

        //menampilkan data
        sisa = stok - total_dontbelate - total_goncangjiawa - total_jalankenangan - total_tanparasa;
        System.out.println("\n=========================================================\n\t\tData Penjualan Kopi\n=========================================================");
        System.out.println("Don't Be Late\t      : " + total_dontbelate + " Cup terjual | " + (dontbelate.length-total_dontbelate) + " Cup tersisa");
        System.out.println("Goncang Jiwa\t      : " + total_goncangjiawa + " Cup terjual | " + (goncangjiwa.length-total_goncangjiawa) + " Cup tersisa");
        System.out.println("Jalan Kenangan\t      : " + total_jalankenangan + " Cup terjual | " + (jalankenangan.length-total_jalankenangan) + " Cup tersisa");
        System.out.println("Kopi Pahit Tanpa Rasa : " + total_tanparasa + " Cup terjual | " + (tanparasa.length-total_tanparasa) + " Cup tersisa" );

        //membuat daftar total penjualan setiap jenis kopi
        ArrayList<Integer> penjualan = new ArrayList<Integer>();
        penjualan.add(total_dontbelate);
        penjualan.add(total_goncangjiawa);
        penjualan.add(total_jalankenangan);
        penjualan.add(total_tanparasa);

        //mengurutkan agar nilai terbesar berada di atas (index 0) dan tekecil paling bawah (index 3)
        Collections.sort(penjualan, Collections.reverseOrder());

        //cetak semua nama jika memiliki penjualan sama dengan nilai pnejualan tertinggi
        System.out.println("=========================================================");
        System.out.println("\t\tKopi paling banyak disukai\n" );

        if (total_dontbelate == penjualan.get(0)) {
            System.out.println("- Don't Be Late");
        }

        if (total_goncangjiawa == penjualan.get(0)) {
            System.out.println("- Goncang Jiwa");
        }

        if (total_jalankenangan == penjualan.get(0)) {
            System.out.println("- Jalan Kenangan");
        }

        if (total_tanparasa == penjualan.get(0)) {
            System.out.println("- Pahit Tanpa Rasa");
        }

        System.out.println("=========================================================");
        System.out.println("\t\tKopi paling tidak disukai\n");

        //cetak semua nama jika memiliki penjualan sama dengan nilai penjualan terendah
        if (total_dontbelate == penjualan.get(3)) {
            System.out.println("- Don't Be Late");
        }

        if (total_goncangjiawa == penjualan.get(3)) {
            System.out.println("- Goncang Jiwa");
        }

        if (total_jalankenangan == penjualan.get(3)) {
            System.out.println("- Jalan Kenangan");
        }

        if (total_tanparasa == penjualan.get(3)) {
            System.out.println("- Pahit Tanpa Rasa");
        }

        System.out.println("=========================================================");
        System.out.println("Total kopi terjual\t\t: " + (total_dontbelate + total_goncangjiawa + total_jalankenangan + total_tanparasa) + " Cup");
        System.out.println("Total sisa kopi\t\t\t: " + sisa + " Cup");
        System.out.println("=========================================================");
    }

    static void cek_data_pesanan(String[] jenis, String pembeli) {
        for (int i = 0; i < jenis.length; i++) {
            /*
             *mengecek setiap slot dalam array jenis kopi
             *memasukan nama pembeli ke slot array jenis kopi yang masih kosong
             */
            if (jenis[i] == null) {
                jenis[i] = pembeli;
                break;
            }
        }
    }

    static void data_pesanan(int jenis, String nama){
        System.out.print(nama + " memesan Kopi ");

        //memilih jenis kopi sesuai input angka hasil random
        switch (jenis) {
            case 1:
                cek_data_pesanan(dontbelate, nama);
                System.out.println("Don't Be Late");
                break;
            case 2:
                cek_data_pesanan(goncangjiwa, nama);
                System.out.println("Goncang jiwa");
                break;
            case 3:
                cek_data_pesanan(jalankenangan, nama);
                System.out.println("Jalan Kenangan");
                break;
            case 4:
                cek_data_pesanan(tanparasa, nama);
                System.out.println("Pahit Tanpa Rasa");
                break;
        }

        print_data_pesanan();
    }

    static void pesan() {
        //pake try biar gak warning terus di vscode
        try (Scanner pembeli = new Scanner(System.in)) {
            while (true) {
                //interaksi untuk memasukan nama (string)
                System.out.print("\nnama pembeli : ");
                String nama_pemebeli =  pembeli.nextLine();

                //jika kosong
                if (nama_pemebeli.isBlank()) {
                    System.out.println("nama pembeli wajib diisi");
                    pesan();
                }else if (sisa == 0) {
                    System.out.println("Maaf semua kopi sudah habis");
                    pesan();
                }else{
                    Random gacha = new Random();
                    //membuat variabel angka acak antara 0 sampa 3 lalu tamabah 1
                    int jenisrandom = gacha.nextInt(4) + 1;
                    //membuat data_pesanan
                    data_pesanan(jenisrandom, nama_pemebeli);
                }
            }
        }
    }
}