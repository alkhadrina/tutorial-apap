# Tutorial APAP
## Authors
* **Alkhadrina Rasyidah Azzah Zahra** - *1906399764* - *A*

---
## Tutorial 4
### What I have learned today

1. Jelaskan perbedaan th:include dan th:replace!
th:include = menyisipkan isi dari tag yang didefinisikan ke dalam tag saat ini
th:replace = mengganti tag saat ini dengan tag yang didefinisikan

2. Jelaskan apa fungsi dari th:object!
untuk menspesifikasi object mana yang akan disubmit ke form
3. Jelaskan perbedaan dari * dan $ pada saat penggunaan th:object! Kapan harus dipakai?
${...} - Variable Expressions. expression standar
*{...} - Selection Variable Expressions. sama dengan Variable Expressions tetapi digunakan saat dikombinasikan dengan th:object


---
## Tutorial 3
### What I have learned today

1. Tolong jelaskan secara singkat apa kegunaan dari anotasi-anotasi yang ada pada model
(@AllArgsConstructor, @NoArgsConstructor, @Setter, @Getter, @Entity, @Table)
@AllArgsConstructor = secara otomatis membuat constructor dengan parameter setiap atribut dalam kelas tersebut
@NoArgsConstructor = secara otomatis membuat constructor tanpa parameter
@Setter = secara otomatis membuat method setter default 
@Getter = secara otomatis membuat method getter default 
@Entity = mendefinisikan bahwa class tersebut dapat dipetakan kedalam sebuah table 
@Table = memungkinkan untuk menentukan detail tabel yang akan digunakan untuk entity dalam database

2. Pada class CabangDB, terdapat method findByNoCabang, apakah kegunaan dari method
tersebut?
mendapatkan object cabang berdasarkan nocabang

3. Jelaskan perbedaan kegunaan dari anotasi @JoinTable dan @JoinColumn
@JoinTable = untuk memetakan relasi table kelas tersebut dengan tabel lain.
@JoinColumn = untuk memetakan entity dengan primary key

4. Pada class PegawaiModel, digunakan anotasi @JoinColumn pada atribut cabang, apa
kegunaan dari name, referencedColumnName, dan nullable dalam anotasi tersebut? dan apa
perbedaan nullable dan penggunaan anotasi @NotNull
name = untuk primary key yang nantinya dipetakan ke entity.
referencedColumnName = nama column dalam table yang akan direference dengan kolom yang dianotasi
nullable = menentukan apakah entity boleh null atau tidak

5. Jelaskan kegunaan FetchType.LAZY, CascadeType.ALL, dan FetchType.EAGER
FetchType.LAZY = memberitahu Hibernate untuk hanya mengambil entity terkait dari database saat menggunakan relasi
CascadeType.ALL = akan menjalankan semua aksi
FetchType.EAGER = mengambil semua entity yang terkait

---
## Tutorial 2
### What I have learned today

1.  Pertanyaan 1: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut setelah menjalankan program: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom&noTelepon=081xxx Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi
Error, karena belum ada templatenya sehingga Ketika return tidak ada filenya

2.  Pertanyaan 2: Menurut kamu anotasi @Autowired pada class Controller tersebut merupakan implementasi dari konsep apa? Dan jelaskan secara singkat cara kerja @Autowired tersebut dalam konteks service dan controller yang telah kamu buat
Konsep dependency injection, jadi kita akan melakukan inisialisasi terhadap class tersebut, dan lalu mengisi (inject) semua kebutuhannya (dependency). Untuk injection ini, kita juga tidak perlu lagi menyediakan setter method maupun menambahkan argumen di constructor. Semua field/property yang memiliki anotasi @Autowired akan diisikan oleh Spring dengan object bertipe-data sesuai.

3.  Pertanyaan 3: Cobalah untuk menambahkan sebuah Kebun dengan mengakses link berikut: http://localhost:8080/kebun-safari/add?id=1&nama=Papa%20APAP&alamat=Maung% 20Fasilkom Apa yang terjadi? Jelaskan mengapa hal tersebut dapat terjadi.
Error, karena kurang parameter noTelepon yang statusnya required untuk membuat object ini.

4.  Pertanyaan 4: Jika Papa APAP ingin melihat Kebun Safari dengan nama Papa APAP, link apa yang harus diakses?
http://localhost:8080/kebun-safari/?id=1

5.  Pertanyaan 5: Tambahkan 1 contoh Kebun Safari lainnya sesukamu. Lalu cobalah untuk mengakses http://localhost:8080/ , apa yang akan ditampilkan? Sertakan juga bukti screenshotmu.
Daftar semua kebun safari yang sudah dibuat.
[SS hasil](https://ibb.co/SXn3dDL)


---
## Tutorial 1
### What I have learned today
(Masukkan pertanyaan yang diikuti jawaban di setiap nomor, contoh seperti dibawah. Anda
juga boleh menambahkan catatan apapun di bagian ini)
### Github
1. Apa itu Issue Tracker? Apa saja masalah yang dapat diselesaikan dengan Issue Tracker?
Untuk mencatat, atau membuat issue baru. masalah atau permintaan perubahan dapat di-track dengan mudah.
jika terjadi masalah
2. Apa perbedaan dari git merge dan git merge --squash?
git merge semua commit dari branch ditambah ke main.
git merge --squash semua commit dari sebuah branch disatukan menjadi satu commit.
3. Apa keunggulan menggunakan Version Control System seperti Git dalam pengembangan
suatu aplikasi? 
melacak semua perubahan kode yang dilakukan.
### Spring
4. Apa itu library & dependency?
library = koleksi dari kode-kode yang sudah ditulis yang dapat digunakan oleh user untuk membantu mengerjakan tasks.
dependency = fungsi, library atau kode yang esensial untuk sebuah bagian dari kode yang berbeda agar tasks yang diinginkan berjalan.
5. Apa itu Maven? Mengapa kita menggunakan Maven? Apakah ada alternatif dari Maven? software project management dan comprehension tools. karena ini adalah alat automasi untuk project java. alternatifnya ada Gradle.
6. Selain untuk pengembangan web, apa saja yang bisa dikembangkan dengan Spring framework?
Cloud, Microservices, Event Driven.
7. Apa perbedaan dari @RequestParam dan @PathVariable? Kapan sebaiknya
menggunakan @RequestParam atau @PathVariable?
@RequestParam mengambil value dari query string. @PathVariable mengambil value dari URL path;
### What I did not understand
(tuliskan apa saja yang kurang Anda mengerti, Anda dapat men-_check_ apabila Anda
sudah mengerti dikemudian hari, dan tambahkan tulisan yang membuat Anda mengerti)
- [ ] Kenapa saya harus belajar APAP?
agar mengerti dasar-dasar aplikasi perusahaan.
- [x] Kenapa?
Karena …

(Anda dapat membuat tampilan code dalam README.md menjadi lebih baik. Cari tahu
lebih dalam tentang penulisan README.md di GitHub pada link
[berikut](https://help.github.com/en/articles/basic-writing-and-formatting-syntax))
