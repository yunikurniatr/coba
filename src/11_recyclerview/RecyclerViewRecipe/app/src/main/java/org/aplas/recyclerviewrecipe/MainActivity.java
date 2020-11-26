package org.aplas.recyclerviewrecipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

import org.aplas.recyclerviewrecipe.ResepAdapter;
import org.aplas.recyclerviewrecipe.DataResep;

import java.util.ArrayList;
import java.util.List;
public class MainActivity extends AppCompatActivity implements ResepAdapter.OnUnsClickListener{

    public static final String Key_TabelActivity="Key_TabelActivity";

    public RecyclerView rv;
    public ResepAdapter unsurAdapter;
    public RecyclerView.LayoutManager layoutManager;
    public List<DataResep> dataUnsurList = new ArrayList<>();
    public EditText searchView;
    public CharSequence search="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = findViewById(R.id.unsurList);
        EditText search_bar = findViewById(R.id.search_bar);
        dataUnsurList.add(new DataResep("Ayam Goreng Tepung Saus Asam Manis","Bahan-Bahan :\n" +
                "300 gram daging ayam fillet yang sebelumnya telah Anda potong kecil-kecil sesuai dengan selera Anda\n" +
                "1 siung dari bawang putih yang telah dihaluskan\n" +
                "1 sendok teh garam\n" +
                "1/2 sendok teh merica bubuk1 butir telur ayam kampung yang telah di kocok lepas\n" +
                "40 gram tepung terigu\n" +
                "40 gram tepung kanji\n" +
                "minyak goreng secukupnya, usahakan minyak goreng yang belum pernah terpakai sebelumnya atau masih baru\n" +
                "Bahan Saus Asam Manis:\n" +
                "25 gram bawang bombay yang telah dicincang hingga halus\n" +
                "1 siung bawang putih yang sudah dicincang halus juga\n" +
                "2 sendok makan kacang polong\n" +
                "2 sendok teh tepung kanji lalu larutkan dengan sedikit air, usahakan air yang sudah Anda rebus\n" +
                "2 sendok makan saus cabai botolan\n" +
                "3 sendok makan  saus tomat botolan\n" +
                "1 sendok teh gula pasir\n" +
                "1 sendok teh garam\n" +
                "Cara Membuat Ayam Goreng Tepung Saus Asam Manis:\n" +
                "Campurkan larutan tepung terigu dan tepung kanji dan aduk keduanya hingga merata.\n" +
                "Campurkan juga irisan daging ayam fillet dengan bawang putih, merica dan garam hingga semua merata sempurna lalu remas-remas agar semua bumbu dapat meresap dengan baik.\n" +
                "Celupkan daging ayam dalam telur yang sudah Anda kocok, dan gulingkan pada campuran yang berisi tepung, lalu Sisihkan ayam.\n" +
                "Ulangi proses tersebut hingga potongan daging ayam yang Anda gunakan telah habis.\n" +
                "Selanjutnya goreng daging ayam hingga berwarna kuning keemasan menggunakan deep fryer. Lalu angkat dan tiriskan.Cara Membuat Saus :\n" +
                "Tumis bawang putih dan bawang bombay hingga terluhat layu dan beraroma harum.\n" +
                "Masukkan saus sambal, saus tomat, gila pasir, garam dan larutan kanji setelah itu aduk hingga semua adonan telah merata dan tercampur dengan sempurna.\n" +
                "Setelah itu masukkan kacang polong dan aduk-aduk hingga matang dan kental dengan sempurna.\n" +
                "Penyajian:\n" +
                "Tata daging ayam di atas piring saji, usahakan menggunakan piring yang bagus agar terlihat menarik saat hendak dikonsumsi.\n" +
                "Siram daging ayam tersebut dengan saus asam manis.\n" +
                "Ayam goreng tepung saus asam manis siap untuk Anda sajikan, saya sarankan untuk menyajikan selagi hangat.", R.drawable.ayam));
        dataUnsurList.add(new DataResep("Terong balado","Bahan-bahan:\n" +
                "- 2 buah terong ungu (belah empat bagian, potong panjang sesuai selera) \n" +
                "- 3 siung bawang putih \n" +
                "- 4 siung bawang merah \n" +
                "- 5 buah cabai rawit (atau sesuai selera) \n" +
                "- garam secukupnya \n" +
                "- gula secukupnya \n" +
                "- kaldu ayam bubuk secukupnya \n" +
                "- minyak goreng secukupnya \n" +
                "- air secukupnya \n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Haluskan bawang putih, bawang merah, cabai rawit, dan garam. Jika sudah halus, tumis dengan minyak hingga aromanya harum. \n" +
                "2. Masukkan terong ke dalam bumbu, lalu aduk hingga rata. \n" +
                "3. Agar tidak gosong dan kering, tambahkan sedikit air, lalu masak hingga terong matang dan empuk. \n" +
                "4. Tambahkan sedikit gula dan kaldu ayam bubuk. \n" +
                "5. Aduk semua bahan hingga bumbu meresap dan tercampur rata. \n" +
                "6. Angkat terong, lalu sajikan.", R.drawable.terong));
        dataUnsurList.add(new DataResep("Bihun goreng sayuran","Bahan-bahan:\n" +
                "- 1 papan bihun jagung (rendam di air panas dan tiriskan) \n" +
                "- 2 butir telur \n" +
                "- baby pakcoy secukupnya (iris tipis) \n" +
                "- kol secukupnya (iris tipis) \n" +
                "- kecap manis secukupnya \n" +
                "- penyedap rasa secukupnya \n" +
                "- minyak goreng secukupnya \n" +
                "- 6 siung bawang merah \n" +
                "- 3 siung bawang putih \n" +
                "- 3 butir kemiri \n" +
                "- 3 buah cabai rawit (atau sesuai selera) \n" +
                "\n" +
                "Cara membuat:\n" +
                "1. Panaskan minyak goreng, tumis bumbu yang telah dihaluskan hingga harum. \n" +
                "2. Masukkan kol dan pakcoy yang telah diiris tipis. Aduk rata hingga tercampur dan sayuran sedikit layu. \n" +
                "3. Dalam penggorengan, pinggirkan dulu sayuran, masukkan dua butir telur, orak-arik, lalu masukkan sedikit air. Aduk rata. \n" +
                "4. Masukkan bihun jagung yang telah direndam. Aduk rata, tambahkan kecap manis dan penyedap rasa. \n" +
                "5. Angkat dan sajikan selagi hangat.", R.drawable.bihun));

        unsurAdapter = new ResepAdapter(dataUnsurList);
        unsurAdapter.setListener(this);
        layoutManager = new LinearLayoutManager(getApplicationContext());
        rv.setAdapter(unsurAdapter);
        rv.setLayoutManager(layoutManager);



    }





    @Override
    public void onClick(View view, int position) {
        DataResep dataunsur = dataUnsurList.get(position);
        Intent i = new Intent(MainActivity.this,ResepActivity.class);
        i.putExtra(Key_TabelActivity,dataunsur);
        startActivity(i);
    }
}