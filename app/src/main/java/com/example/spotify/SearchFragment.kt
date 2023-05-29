package com.example.spotify

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.spotify.databinding.FragmentSearchBinding


private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SearchFragment : Fragment() {

    private var param1: String? = null
    private var param2: String? = null

    private lateinit var recyclerView : RecyclerView
    private lateinit var binding: FragmentSearchBinding
    var playlists = mutableListOf<PlaylistData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.playlistRecyclerView
        recyclerView.adapter = PopularListAdapter(playlists)
        var gridLayout : GridLayoutManager  = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = gridLayout

        val playlists = mutableListOf<PlaylistData>(
            PlaylistData("Éxitos España", "2.000.001 seguidores", "https://i.scdn.co/image/ab67706f00000002a405760d5693a939dfa5dd8c",
                mutableListOf<Song>(Song("WHERE SHE GOES", "Bad Bunny", "https://www.lahiguera.net/musicalia/artistas/varios/disco/0/tema/29353/where_she_goes-portada.jpg", false), Song("Clavito", "Chanel", "https://cdn.smehost.net/sonymusices-45pressprod/wp-content/uploads/2023/04/f83f35e9-0ab0-4dd2-9260-69199957f981.jpg", false ), Song("Supernova", "Saiko", "https://images.genius.com/d985ab8d56a2a2be016f85d27ec27de6.1000x1000x1.png", false), Song("Vagabundo", "Sebastian Yatra", "https://i.scdn.co/image/ab67616d0000b2732d6016751b8ea5e66e83cd04", false), Song("EL TONTO", "Lola Indigo, Quevedo", "https://i.ytimg.com/an/4G8bm3zz1ck/3386224746610249315_mq.jpg?v=64390f61", false), Song("Arena y Sal", "Omar Montes, Saiko", "https://cdn.smehost.net/sonymusices-45pressprod/wp-content/uploads/2023/05/f4880190-210d-406e-b146-4fdc17a57e37.jpg", false),Song("Acrostico", "Shakira", "https://www.semana.com/resizer/UQkAq9WpHuGzw4kFpJSDB8aCR2E=/arc-anglerfish-arc2-prod-semana/public/RDUVOCX2BJC6XMUC3U3OGAMW7Y.jpg", false), Song("La Bebe- Remix", "Yng Lvcas, Peso Pluma",
                "https://www.billboard.com/wp-content/uploads/2023/03/Yng-Lvcas-cr-Javier-Garcia-Royal-Religion-billboard-1548.jpg", false),Song("La bachata", "Manuel Turizo", "https://i1.sndcdn.com/artworks-pEWZ3m9PGcB0fXwV-c7y1mg-t500x500.jpg", false), Song("Sangre y Fe", "Cruz Cafuné, Quevedo", "https://geniuslyrics.net/i/bands/350/cruz-cafune-me-muevo-con-dios.jpg", false), Song("Niña Bonita", "Feid, Sean Paul", "https://images.genius.com/59af062c65af48f244edf7dcf9121440.600x600x1.jpg", false))),

            PlaylistData("Pop con Ñ", "979.031 seguidores", "https://cdn.peoople.app/image/recommendation/1751628/1751628_21042020032611313265_opt_520.jpg",
                mutableListOf<Song>(Song("Acrostico", "Shakira", "https://www.semana.com/resizer/UQkAq9WpHuGzw4kFpJSDB8aCR2E=/arc-anglerfish-arc2-prod-semana/public/RDUVOCX2BJC6XMUC3U3OGAMW7Y.jpg",false),Song("Vagabundo", "Sebastian Yatra", "https://i.scdn.co/image/ab67616d0000b2732d6016751b8ea5e66e83cd04", false ), Song("Clavito", "Chanel", "https://cdn.smehost.net/sonymusices-45pressprod/wp-content/uploads/2023/04/f83f35e9-0ab0-4dd2-9260-69199957f981.jpg", false ), Song("Algo Sencillito", "Marta Santos", "https://m.media-amazon.com/images/I/41mgxBL-l8L._SX354_SY354_BL0_QL100__UXNaN_FMjpg_QL85_.jpg", false), Song("Nochentera", "Vicco", "https://img2.rtve.es/imagenes/portada-nochentera-cancion-vicco-para-benidorm-fest-2023/1671358100278.jpg", false), Song("MI BANDERA", "Nil Moliner", "https://m.media-amazon.com/images/I/51KsXIXi8ZL._UXNaN_FMjpg_QL85_.jpg", false),  Song("EL TONTO", "Lola Indigo, Quevedo", "https://i.ytimg.com/an/4G8bm3zz1ck/3386224746610249315_mq.jpg?v=64390f61", false))),

            PlaylistData("Pop Clásico", "234.422 seguidores", "https://i.scdn.co/image/ab67706f000000028e1ac5347842e3037314ce56",
                mutableListOf<Song>(Song("Tú y yo", "Beret", "https://i.scdn.co/image/ab67616d0000b273cb8dffe85b3fa5886f1c06ce", false), Song("Formentera", "Aitana, Nicki Nicole", "https://www.lahiguera.net/musicalia/artistas/aitana/disco/12472/tema/26450/aitana_formentera-portada.jpg", false ), Song("MENEITO", "Nil Moliner, Yera", "https://i.scdn.co/image/ab67616d0000b27311d60a800f737d0730147bb5", false), Song("Corazon Sin Vida", "Aitana", "https://pics.filmaffinity.com/Aitana_feat_Sebasti_n_Yatra_Coraz_n_sin_vida_V_deo_musical-987079527-large.jpg", false), Song("506", "Morat, Juanes", "https://i.scdn.co/image/ab67616d0000b273a530ec73bea160150cd823e2", false), Song("Lo Que Hará mi Boca", "Antonio José, Morat", "https://www.cadenadial.com/wp-content/uploads/2021/11/antonio-jose_Fotor-300x169.jpg", false),Song("Todo Contigo", "Alvaro De Luna", "https://i.scdn.co/image/ab67616d0000b2737d45bffb03d186c1f4a47a83", false), Song("Matame", "Beret", "https://www.cadenadial.com/wp-content/uploads/2022/01/Beret-e1641549874337.jpg", false))),

            PlaylistData("Pop Internacional", "26.195.307 seguidores", "https://i.scdn.co/image/ab67706f00000002ddc9dd3c97091ccc4b3fa7e0",
                mutableListOf<Song>(Song("One Dance", "Drake", "https://i.scdn.co/image/ab67616d0000b2739416ed64daf84936d89e671c", false), Song("Miss You", "Oliver Tree, Robin", "https://i.scdn.co/image/ab67616d0000b2737f2185309bd1ecdacda88fa7", false ), Song("Work", "Drake, Rihana", "https://i1.sndcdn.com/artworks-000194589034-absz9u-t500x500.jpg ", false), Song("Flowers", "Milew Cryus", "https://static.eldiario.es/clip/362bd961-67eb-462f-a0c0-d0dffc9dedd3_16-9-discover-aspect-ratio_default_0.jpg", false), Song("SNAP", "Rosa Linn", "https://i.scdn.co/image/ab67616d00001e022cb2bc4581ddf117470128ff", false), Song("My Way", " Calvin Harris", "https://upload.wikimedia.org/wikipedia/en/5/51/My_Way_Calvin_Harris.jpg ", false), (Song("Hotline Bling", "Drake", "https://i.scdn.co/image/ab67616d0000b2739416ed64daf84936d89e671c", false))),
            )
            )

            val action = { position: Int ->
                val intent = Intent(requireContext(), PlaylistSongsActivity::class.java)
                intent.putExtra("playlist", playlists[position])
                startActivity(intent)
            }
            val myAdatper = recyclerView.adapter as PopularListAdapter
            myAdatper.setAction(playlists, action)

    }

    companion object {


        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SearchFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}