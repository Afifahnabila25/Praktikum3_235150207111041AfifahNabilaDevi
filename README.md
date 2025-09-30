# Praktikum 3: State Management - Jetpack Compose

**Mahasiswa:** Afifah Nabila Devi  
**NIM:** 235150207111041  

## Deskripsi Aplikasi

Aplikasi Android yang mendemonstrasikan konsep State Management dalam Jetpack Compose melalui tiga tugas praktikum:

1. **Counter Plus-Minus** - Counter dengan validasi minimum 0
2. **Toggle Warna** - Box yang berubah warna Merah-Hijau saat diklik
3. **Profil Interaktif** - Kartu profil dengan tombol Follow/Unfollow dan status indicator

## Implementasi State

### State Lokal dengan remember dan mutableStateOf

State digunakan untuk menyimpan data yang dapat berubah dan memicu recomposition UI secara otomatis. Setiap perubahan state akan langsung tercermin pada tampilan tanpa perlu update manual.

Di aplikasi ini, state digunakan untuk menyimpan nilai counter, status warna box, dan status follow/unfollow. Remember memastikan state tidak hilang saat recomposition terjadi.

### Conditional UI Berdasarkan State

UI beradaptasi secara dinamis berdasarkan nilai state. Misalnya button "Kurang" akan disabled ketika counter bernilai 0, warna box berubah saat diklik, dan teks button berubah antara "Follow" dan "Unfollow".

Semua perubahan ini terjadi secara reaktif - ketika state berubah, Compose otomatis merender ulang komponen yang terpengaruh.

### State Hoisting

State hoisting adalah praktik memisahkan state dari komponen UI. Dengan memindahkan state ke level yang lebih tinggi, komponen menjadi stateless dan lebih reusable.

Parent component bertanggung jawab mengelola state dan mengirimkan data serta callback ke child component. Ini membuat kode lebih terorganisir dan mudah ditest.

### Recomposition Otomatis

Ketika state berubah, Compose secara otomatis me-render ulang bagian UI yang terpengaruh. Tidak perlu memanggil method update atau refresh secara manual. Sistem ini membuat UI selalu sinkron dengan data.

## Analisis: Jetpack Compose vs XML Tradisional

### Kesederhanaan Kode

Pada pendekatan XML tradisional, kita perlu membuat layout XML terpisah, kemudian di Activity melakukan findViewById, membuat variabel state manual, dan update UI secara imperatif setiap kali state berubah.

Pada Jetpack Compose, semua ada dalam satu file Kotlin. State langsung terhubung dengan UI, dan perubahan otomatis memicu recomposition. Tidak perlu findViewById atau update manual.

### Keunggulan Compose untuk State Management

**Declarative UI**  
Compose mendeskripsikan "apa yang ingin ditampilkan" berdasarkan state, bukan "bagaimana cara mengubah UI". Kode lebih mudah dipahami karena UI adalah fungsi dari state.

**State Terintegrasi**  
State langsung terhubung dengan UI tanpa boilerplate code. Tidak perlu listener atau observer pattern yang kompleks. Perubahan state otomatis memicu update tampilan.

**Recomposition Otomatis**  
UI selalu konsisten dengan state. Tidak ada risiko lupa update tampilan atau inconsistent state yang sering terjadi pada pendekatan imperatif.

**Kode Lebih Ringkas**  
Tidak perlu bolak-balik antara XML dan Kotlin. Semua logika UI, styling, dan state management ada dalam satu tempat. Lebih mudah dibaca dan dimaintain.

**Type Safety**  
Semua error terdeteksi saat compile-time, bukan runtime. IDE memberikan autocomplete dan refactoring yang lebih baik karena semuanya adalah Kotlin code.

### Contoh Konkret

Untuk membuat tombol Follow/Unfollow sederhana, pada XML tradisional perlu mendefinisikan button di XML, findViewById di Activity, membuat variabel boolean, set onClickListener, dan manual update text button setiap kali diklik.

Pada Compose cukup deklarasikan state dan button dalam beberapa baris. Compose otomatis handle semua update UI berdasarkan perubahan state. Kode lebih singkat, jelas, dan tidak ada boilerplate.

### Pengalaman Praktikum

Dari ketiga tugas yang dikerjakan, terlihat jelas bahwa Compose membuat implementasi state management jauh lebih sederhana. Counter dengan validasi, toggle warna, dan profil interaktif dapat dibuat dengan kode yang minimal namun powerful.

Yang paling terasa adalah tidak perlu lagi memikirkan "bagaimana" update UI - cukup ubah state, dan Compose yang mengurus sisanya. Ini sangat berbeda dengan pendekatan XML dimana kita harus eksplisit mengupdate setiap elemen UI.

## Kesimpulan

Jetpack Compose membuat state management lebih sederhana dengan paradigma declarative UI. Perubahan state otomatis memicu recomposition, sehingga UI selalu sinkron dengan data. Kode lebih ringkas, type-safe, dan mudah dimaintain dibandingkan pendekatan XML tradisional. Untuk kasus-kasus yang melibatkan state interaktif seperti di praktikum ini, Compose memberikan developer experience yang jauh lebih baik.
