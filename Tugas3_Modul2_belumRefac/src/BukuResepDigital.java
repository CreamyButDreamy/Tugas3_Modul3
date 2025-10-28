import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class BukuResepDigital {

    // Semua data dan fungsionalitas menggunakan static (mirip variabel global)
    static List<Map<String, Object>> bukuResep = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== BUKU RESEP DIGITAL =====");
            System.out.println("1. Tambah Resep Baru");
            System.out.println("2. Lihat Semua Judul Resep");
            System.out.println("3. Cari dan Tampilkan Resep");
            System.out.println("4. Keluar");
            System.out.println("==========================================");
            System.out.print("Pilih menu (1-4): ");
            String pilihan = scanner.nextLine();

            if (pilihan.equals("1")) {
                // Logika tambah resep langsung di sini
                System.out.println("\n--- Menambah Resep Baru ---");
                System.out.print("Masukkan Judul Resep: ");
                String judul = scanner.nextLine();

                List<String> bahan = new ArrayList<>();
                System.out.println("Masukkan bahan (ketik 'selesai' untuk berhenti):");
                while (true) {
                    System.out.print("- ");
                    String inputBahan = scanner.nextLine();
                    if (inputBahan.equalsIgnoreCase("selesai")) break;
                    bahan.add(inputBahan);
                }

                List<String> langkah = new ArrayList<>();
                System.out.println("Masukkan langkah (ketik 'selesai' untuk berhenti):");
                int nomorLangkah = 1;
                while (true) {
                    System.out.print(nomorLangkah++ + ". ");
                    String inputLangkah = scanner.nextLine();
                    if (inputLangkah.equalsIgnoreCase("selesai")) break;
                    langkah.add(inputLangkah);
                }

                // Membuat Map untuk resep baru
                Map<String, Object> resepBaru = new HashMap<>();
                resepBaru.put("judul", judul);
                resepBaru.put("bahan", bahan);
                resepBaru.put("langkah", langkah);
                bukuResep.add(resepBaru);
                System.out.println("SUKSES: Resep '" + judul + "' berhasil ditambahkan.");

            } else if (pilihan.equals("2")) {
                // Logika lihat semua resep langsung di sini
                System.out.println("\n--- Daftar Resep Tersedia ---");
                if (bukuResep.isEmpty()) {
                    System.out.println("Buku resep masih kosong.");
                } else {
                    for (Map<String, Object> resep : bukuResep) {
                        System.out.println("- " + resep.get("judul"));
                    }
                }
                System.out.println("-----------------------------");

            } else if (pilihan.equals("3")) {
                // Logika cari resep langsung di sini
                System.out.println("\n--- Cari Resep ---");
                System.out.print("Masukkan judul resep yang ingin dicari: ");
                String judulCari = scanner.nextLine();

                boolean ditemukan = false;
                // Pencarian dilakukan dengan looping
                for (Map<String, Object> resep : bukuResep) {
                    if (((String) resep.get("judul")).equalsIgnoreCase(judulCari)) {
                        System.out.println("\n===== " + resep.get("judul") + " =====");

                        // Casting tidak aman dari Object ke List<String>
                        List<String> bahan = (List<String>) resep.get("bahan");
                        System.out.println("\nBahan-bahan:");
                        for (String itemBahan : bahan) {
                            System.out.println("- " + itemBahan);
                        }

                        List<String> langkah = (List<String>) resep.get("langkah");
                        System.out.println("\nLangkah-langkah:");
                        for (int i = 0; i < langkah.size(); i++) {
                            System.out.println((i + 1) + ". " + langkah.get(i));
                        }
                        System.out.println("==========================");
                        ditemukan = true;
                        break;
                    }
                }
                if (!ditemukan) {
                    System.out.println("\nERROR: Resep '" + judulCari + "' tidak ditemukan.");
                }

            } else if (pilihan.equals("4")) {
                System.out.println("\nTerima kasih!");
                break; // Keluar dari loop
            } else {
                System.out.println("\nPilihan tidak valid.");
            }
            System.out.println("\nTekan Enter untuk kembali ke menu...");
            scanner.nextLine();
        }
    }
}