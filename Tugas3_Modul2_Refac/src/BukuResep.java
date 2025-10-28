import java.util.HashMap;
import java.util.Map;

/**
 * Merepresentasikan sebuah buku resep yang berisi kumpulan resep.
 * Kelas ini berfungsi untuk mengelola, menambah, dan mencari resep.
 */
public class BukuResep {
    private Map<String, Resep> daftarResep = new HashMap<>();

    /**
     * Menambahkan sebuah resep baru ke dalam buku resep.
     * Resep tidak akan ditambahkan jika judulnya sudah ada (case-insensitive).
     *
     * @param resep  Objek Resep yang akan ditambahkan
     */
    public void tambahResep(Resep resep) {
        String kunciJudul = resep.getJudul().toLowerCase();
        if (this.daftarResep.containsKey(kunciJudul)) {
            System.out.println("ERROR: Resep dengan judul '" + resep.getJudul() + "' sudah ada.");
        } else {
            this.daftarResep.put(kunciJudul, resep);
            System.out.println("SUKSES: Resep '" + resep.getJudul() + "' berhasil ditambahkan.");
        }
    }

    /**
     * Mencari dan menampilkan detail resep berdasarkan judulnya.
     * Jika resep tidak ditemukan, sebuah pesan error akan ditampilkan.
     *
     * @param judul Judul resep yang ingin ditampilkan (case-insensitive).
     */
    public void tampilkanResep(String judul) {
        Resep resep = this.daftarResep.get(judul.toLowerCase());
        if (resep != null) {
            resep.tampilkanDetail();
        } else {
            System.out.println("\nERROR: Resep '" + judul + "' tidak ditemukan.");
        }
    }

    /**
     * Menampilkan semua judul resep yang tersimpan di dalam buku resep.
     * Jika buku resep kosong, akan menampilkan pesan informasi.
     */
    public void tampilkanSemuaJudulResep() {
        System.out.println("\n--- Daftar Resep Tersedia ---");
        if (daftarResep.isEmpty()) {
            System.out.println("Buku resep masih kosong.");
        } else {
            for (Resep resep : daftarResep.values()) {
                System.out.println("- " + resep.getJudul());
            }
        }
        System.out.println("-----------------------------");
    }

// --- PENAMBAHAN FITUR BARU ---
    /**
     * Menghapus resep dari buku resep berdasarkan judul.
     * Memberikan notifikasi sukses jika berhasil atau error jika resep tidak ditemukan.
     *
     * @param judul Judul resep yang akan dihapus (case-insensitive).
     */
    public void hapusResep(String judul) {
        String kunciJudul = judul.toLowerCase();
        if (daftarResep.containsKey(kunciJudul)) {
            daftarResep.remove(kunciJudul);
            System.out.println("SUKSES: Resep '" + judul + "' berhasil dihapus.");
        } else {
            System.out.println("\nERROR: Resep '" + judul + "' tidak ditemukan, tidak ada yang dihapus.");
        }
    }
}