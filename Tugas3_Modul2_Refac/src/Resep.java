import java.util.List;

/**
 * Merepresentasikan sebuah resep masakan tunggal.
 * Kelas ini menyimpan informasi tentang judul, bahan-bahan,
 * dan langkah-langkah pembuatan resep.
 */
public class Resep {
    private String judul;
    private List<String> bahan;
    private List<String> langkah;

    /**
     *konstruktor untuk membuat objek resep baru
     *
     * @param judul (judul dari resep masanan.)
     * @param bahan (daftar bahan yang dibutuhkan)
     * @param langkah (daftar langkah-langkah untuk membuat masakan)
     */
    public Resep(String judul, List<String> bahan, List<String> langkah) {
        this.judul = judul;
        this.bahan = bahan;
        this.langkah = langkah;
    }

    /**
     * mengambil judul dari resep
     *
     * @return String yang berisi judul resep
     */
    public String getJudul() { return this.judul; }

    /**
     * Menampilkan detail lengkap resep ke konsol,
     * termasuk judul, bahan, dan langkah-langkah.
     */
    public void tampilkanDetail() {
        System.out.println("\n===== " + this.judul + " =====");
        System.out.println("\nBahan-bahan:");
        for (String itemBahan : this.bahan) {
            System.out.println("- " + itemBahan);
        }
        System.out.println("\nLangkah-langkah:");
        for (int i = 0; i < this.langkah.size(); i++) {
            System.out.println((i + 1) + ". " + this.langkah.get(i));
        }
        System.out.println("==========================");
    }
}