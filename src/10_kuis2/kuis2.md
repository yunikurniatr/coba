Nama : Yuni Kurnia Taramita
NIM  : 1941723002
Kuis 2 ini terdiri dari soal Praktik dan Teori. Berikut soal-soal yang Anda harus selesaikan.

Sifat ujian: Terbuka.

1. Implementasikan materi/pertemuan sebelumnya tentang data binding, fragment, navigation, dan ViewModel pada ide project akhir Anda! (minimal 1 fitur tiap materi tersebut) Cantumkan tautan github Anda yang tertuju pada file markdown (.md) berisi screenshot tiap fitur tersebut.
2. Jelaskan perbedaan Data Binding dan ViewModel ? lalu pada saat kapan harus menggunakan Data Binding dan ViewModel ? (Mohon cantumkan referensinya).
Jawaban :

    - Library Data Binding adalah support library yang memungkinkan Anda mengikat komponen UI dalam tata letak ke sumber data di aplikasi Anda menggunakan format deklaratif, bukan secara terprogram.
    - Class ViewModel dirancang untuk menyimpan dan mengelola data terkait UI dengan cara yang berbasis siklus proses. Class ViewModel memungkinkan data bertahan saat terjadi perubahan konfigurasi seperti pada saat rotasi layar.

    Referensi :
    - https://developer.android.com/topic/libraries/data-binding
    - https://developer.android.com/topic/libraries/architecture/viewmodel
3. Jelaskan perbedaan fragment dan Activity ? lalu pada saat kapan harus menggunakan fragment dan Activity ? (Mohon cantumkan referensinya).

    Jawaban :
    - Activity merupakan salah satu komponen yang ada di Android Studio yang berfungsi untuk menampilkan user interface (UI) dari aplikasi yang akan dibuat, biasanya diletakkan pada “setcontentview”.

    - Fragment merupakan salah satu komponen pada Android Studio dengan fungsi yang hampir sama seperti activity tetapi memiliki “lifecycle” yang berbeda. Fragment merupakan bagian dari sebuah activity yang mana sebuah fragment tidak akan ada bila tidak ada sebuah activity karena fragment membutuhkan akses dari activity untuk dapat dijalankan.

    Kesimpulan : 
    
        Fragment tidak bisa hidup atau berdiri sendiri(standalone) tanpa adanya minimal 1 Activity ,dan Activity dapat memuat banyak Fragment ,dan yang pasti keduanya digunakan untuk keperluan user inteface pada Aplikasi Android.
    Referensi : https://socs.binus.ac.id/2017/09/26/activity-dan-fragment-di-android-studio/