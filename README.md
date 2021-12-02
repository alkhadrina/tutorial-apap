# Tutorial APAP
## Authors
* **Alkhadrina Rasyidah Azzah Zahra** - *1906399764* - *A*
---
## Tutorial 7
### What I have learned today

1. Ceritakan langkah - langkah yang kalian lakukan untuk solve LATIHAN no.1, dan mengapa kalian melakukan langkah - langkah tersebut?
ditambah setState dengan value default, setelah melakukan add state saat ini belum dikembalikan ke value default maka dari itu harus di setState
2. Jelaskan fungsi dari async dan await!
async menjalankan fungsi tanpa harus menunggu jadi pasti akan me-return sesuatu.
await menunggu fungsi yang dipanggil selesai baru mereturn sesuatu.
3. Masukkan jawaban dari Screenshot yang diperintahkan di halaman 9 pada Component Lifecycle
pada pertanyaan ini.
[SS hasil](https://docs.google.com/document/d/14Ti8_mwLPmqUvEpc3qX0O8MAY_qIRrnL/edit?usp=sharing&ouid=103490587925619836082&rtpof=true&sd=true)
 
4. Jelaskan fungsi dari componentDidMount, shouldComponentUpdate,
componentDidUpdate, componentWillReceiveProps, componentWillUnmount.
Notes : Penjelasan harus mencantumkan “kapan fungsi dipanggil” dan “use case apa saja
yang biasanya menggunakan lifecycle method tersebut”.
componentDidMount= dipanggil saat sebuat component sudah selesai mounting. digunakan saat ada component yang harus di re-render. dilakukan saat mounting.
shouldComponentUpdate= dipanggil setelah sebuah components props atau state berubah. method ini menentukan apakah sebuah component harus dire-render. dilakukan saat updating.
componentDidUpdate= dipanggil setelah sebuah component re-render. semua pekerjaan manual yang dilakukan diluar React saat update harus dilakukan disini. dilakukan saat updating.
componentWillReceiveProps= dipanggil setelah sebuah component telah menerima props yang valuenya sudah berubah. dilakukan saat updating.
componentWillUnmount= dipanggil saat sebuah component dihapus dari DOM. melakukan clean-up. dilakukan saat unmounting.
---
## Tutorial 7
### What I have learned today

1. Jelaskan apa yang Anda lakukan di latihan dalam satu paragraf per-soal. Berikan screenshot sebagai ilustrasi dari apa yang Anda jelaskan.
    Dalam latihan nomor satu saya menambah function handleDeleteItemFromCart yang berisi code yang berlawanan dengan handleAddItemToCart. 
    
    Pada latihan nomor 2 saya hanya menambah line yang akan mengubah balance saat ini pada function handleDeleteItemFromCart untuk ditambah balancenya dan handleAddItemToCart untuk dikurangi balancenya. 
    
    Pada latihan nomor 3 saya hanya menambah code if else pada handleAddItemToCart yang conditionnya jika balancenya cukup maka ditambah ke MyCart jika tidak cukup maka akan menampilkan alert. 

2. Menurut pemahaman kamu selama pengerjaan tutorial ini, apa perbedaan antara state dan
props?
Props (prop in plural), merupakan singkatan dari property.
State merupakan data yang tersimpan dalam sebuah component. State bersifat private dan hanya relevan terhadap component itu sendiri. Berbeda dengan props yang valuenya dilempar dari component lain, state justru dapat menyimpan dan mengubah datanya sendiri dari dalam.

3. Menurut kamu, apakah sebaiknya kita menggunakan component (e.g. List, Item) dalam
React? sebutkan alasannya.
Iya, karena akan mempermudah kita dalam me-manage UI. component dapat digunakan berulang-ulang sehingga dapat mempercepat kita dalam membangun UI.

4. Apa perbedaan class component dan functional component?
Functional component hanya bisa menggunakan props itu sebabnya function component disebut stateless component atau biasa digunakan juga sebagai UI Component (komponen yang menangani tampilan). Sedangkan Class component dapat menggunakan state dan props.

5. Dalam react, apakah perbedaan component dan element?
Elemen adalah blok bangunan terkecil di React, yang menggambarkan apa yang akan dilihat oleh user di layar mereka.
Komponen pada React secara konsep sama seperti function pada JavaScript, perbedaannya adalah jika function menerima sebarang input yang disebut parameter atau argumen dan me-return sebuah nilai, komponen menerima input yang disebut props dan me-return React Element yang menggambarkan apa yang akan ditampilkan di layar. Komponen memungkinkan kita untuk membuat UI yang independent, isolated, dan reusable sehingga mengurangi repetisi kode.

---
## Tutorial 6
### What I have learned today

1. Jelaskan secara singkat perbedaan Otentikasi dan Otorisasi! Di bagian mana (dalam kode
yang telah anda buat) konsep tersebut diimplementasi?

Otentikasi adalah proses identifikasi pengguna.
Proses Otentikasi ada pada configAuthentication di WebSecurityConfig.
Otorisasi adalah proses menentukan apakah pengguna saat ini diperbolehkan untuk melakukan tugas tertentu atau tidak.
Proses Otorisasi ada pada configure hasAuthority di WebSecurityConfig.

2. Apa itu BCryptPasswordEncoder? Jelaskan secara singkat cara kerja dan tujuannya.
implementasi dari PasswordEncoder yang mengunakan fungsi hashing BCrypt. Tunjuannya untuk men-ecrypt atau hashing password.

3. Apakah penyimpanan password sebaiknya menggunakan encryption atau hashing? Mengapa
demikian?
Iya, untuk melindungi password yang disimpan pada database.

4. Jelaskan secara singkat apa itu UUID beserta penggunaannya!
UUID digunakan untuk mengidentifikasi informasi yang unik dalam sebuah system. UUID bergantung pada urutan digit yang berisi 128 bits.

5. Apa kegunaan class UserDetailsServiceImpl.java? Mengapa harus ada class tersebut?
untuk mengambil data user dari database. Karena untuk mengambil detail user harus diautentikasi terlebih dahulu.

---
## Tutorial 5
### What I have learned today

1. Apa itu Postman? Apa kegunaannya?
sebuah aplikasi yang berfungsi sebagai REST CLIENT untuk uji coba REST API
2. Jelaskan fungsi dari anotasi @JsonIgnoreProperties dan @JsonProperty.
@JsonIgnoreProperties = mengabaikan property yang ditentukan dalam serialization dan deserialization JSON
@JsonProperty = digunakan untuk memetakan nama properti dengan keys JSON selama erialization dan deserialization
3. Apa kegunaan atribut WebClient?
baseUrl = Konfigurasikan URL dasar untuk permintaan.
build = Buat instance WebClient.
get = Mulai buat permintaan HTTP GET.
uri = menentukan URI untuk permintaan menggunakan template URI dan variabel URI. Jika UriBuilderFactory dikonfigurasi untuk klien (misalnya dengan URI dasar), itu akan digunakan untuk memperluas template URI.
retrieve = mendeklarasikan cara mengekstrak respons.
post = Mulai membuat permintaan HTTP POST. 
4. Apa itu ResponseEntity dan BindingResult? Apa kegunaannya?
ResponseEntity = Extension dari HttpEntity yang menambah HttpStatus status code.
BindingResult = General interface that represents binding results. Extends the interface for error registration capabilities, allowing for a Validator to be applied, and adds binding-specific analysis and model building.

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
