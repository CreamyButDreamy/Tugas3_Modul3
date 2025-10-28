import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas utama yang berfungsi sebagai titik masuk (entry point) untuk aplikasi Buku Resep Digital.
 * Kelas ini menangani semua interaksi dengan pengguna, termasuk menampilkan menu
 * dan memproses input dari pengguna.
 */
public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static BukuResep bukuSaya = new BukuResep();

    /**
     * Metode utama yang menjalankan aplikasi.
     * Metode ini akan terus menampilkan menu dan menerima input pengguna
     * hingga pengguna memilih untuk keluar.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam aplikasi ini).
     */
    public static void main(String[] args) {
        while (true) {
            tampilkanMenu();
            System.out.print("Pilih menu (1-4): ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1": prosesTambahResep(); break;
                case "2": bukuSaya.tampilkanSemuaJudulResep(); break;
                case "3": prosesCariResep(); break;
                //menambahkan case untuk hapus
                case "4": prosesHapusResep(); break;
                case "5":
                    System.out.println("\nTerima kasih telah menggunakan Buku Resep Digital!");
                    return;
                default:
                    System.out.println("\nPilihan tidak valid. Silakan masukkan angka 1-4.");
            }
            System.out.println("\nTekan Enter untuk kembali ke menu...");
            scanner.nextLine();
        }
    }

    /**
     * Menampilkan menu utama aplikasi ke konsol.
     */
    private static void tampilkanMenu() {
        System.out.println("\n===== BUKU RESEP DIGITAL =====");
        System.out.println("1. Tambah Resep Baru");
        System.out.println("2. Lihat Semua Judul Resep");
        System.out.println("3. Cari dan Tampilkan Resep");
        //menambahkan opsi hapus
        System.out.println("4. Hapus resep yang sudah ada");
        System.out.println("5. Keluar");
        System.out.println("==============================");
    }

    /**
     * Memproses alur untuk menambahkan resep baru berdasarkan input pengguna.
     * Pengguna akan diminta memasukkan judul, bahan-bahan, dan langkah-langkah.
     */
    private static void prosesTambahResep() {
        System.out.println("\n--- Menambah Resep Baru ---");
        System.out.print("Masukkan Judul Resep: ");
        String judul = scanner.nextLine();

        List<String> bahan = new ArrayList<>();
        System.out.println("Masukkan bahan satu per satu (ketik 'selesai' untuk berhenti):");
        while (true) {
            System.out.print("- ");
            String inputBahan = scanner.nextLine();
            if (inputBahan.equalsIgnoreCase("selesai")) break;
            bahan.add(inputBahan);
        }

        List<String> langkah = new ArrayList<>();
        System.out.println("Masukkan langkah satu per satu (ketik 'selesai' untuk berhenti):");
        int nomorLangkah = 1;
        while (true) {
            System.out.print(nomorLangkah++ + ". ");
            String inputLangkah = scanner.nextLine();
            if (inputLangkah.equalsIgnoreCase("selesai")) break;
            langkah.add(inputLangkah);
        }

        Resep resepBaru = new Resep(judul, bahan, langkah);
        bukuSaya.tambahResep(resepBaru);
    }

    /**
     * Memproses alur untuk mencari resep berdasarkan judul yang diinput pengguna.
     */
    private static void prosesCariResep() {
        System.out.println("\n--- Cari Resep ---");
        System.out.print("Masukkan judul resep yang ingin dicari: ");
        String judul = scanner.nextLine();
        bukuSaya.tampilkanResep(judul);
    }
// --- TAMBAHKAN METODE BARU UNTUK PROSES HAPUS ---
    /**
     * Memproses alur untuk menghapus resep berdasarkan judul yang diinput pengguna.
     */
    private static void prosesHapusResep() {
        System.out.println("\n--- Hapus Resep ---");
        System.out.print("Masukkan judul resep yang ingin dihapus: ");
        String judul = scanner.nextLine();
        bukuSaya.hapusResep(judul);
    }

}