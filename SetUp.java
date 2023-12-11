import java.util.ArrayList;
import com.google.common.graph.*;

public class SetUp {
    Boolean done;
    Boolean constellationsInitialized;

    public SetUp(){
    this.done = false;
    this.constellationsInitialized = false;
    }

    /* Initializes the Constellation and Star classes required for the game */
    public ArrayList<Constellation> ConstellationsAndStars(){
        ArrayList<Constellation> constellations = new ArrayList<>();

        // Initialize the constellation Ursa Major
        DoubleStar mizar = new DoubleStar("Mizar");
        YellowStar merak = new YellowStar("Merak");
        RedStar dubhe = new RedStar("Dubhe");
        YellowStar phecda = new YellowStar("Phecda");
        YellowStar megrez = new YellowStar ("Megrez");
        YellowStar alioth = new YellowStar("Alioth");
        BlueStar alkaid = new BlueStar ("Alkaid");
        ImmutableGraph<Star> ursaMajorStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(alkaid, mizar)
        .putEdge(mizar, alioth)
        .putEdge(alioth, megrez)
        .putEdge(megrez, dubhe)
        .putEdge(dubhe, merak)
        .putEdge(merak, phecda)
        .putEdge(phecda, megrez)
        .build();
        Constellation ursaMajor = new Constellation("Ursa Major", ursaMajorStars);
        constellations.add(ursaMajor);

        // Initialize the constellation Ursa Minor
        YellowStar polaris = new YellowStar("Polaris");
        YellowStar yildun = new YellowStar("Yildun");
        DoubleStar circitores = new DoubleStar("Circitores");
        YellowStar akfaFarkadain = new YellowStar ("Akfa Farkadain");
        YellowStar yedPost = new YellowStar ("Yed Post");
        YellowStar pherkad = new YellowStar("Pherkad");
        RedStar kochab = new RedStar("Kochab");
        ImmutableGraph<Star> ursaMinorStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(polaris, yildun)
        .putEdge(yildun, circitores)
        .putEdge(circitores, akfaFarkadain)
        .putEdge(akfaFarkadain, yedPost)
        .putEdge(yedPost, pherkad)
        .putEdge(pherkad, kochab)
        .putEdge(kochab, akfaFarkadain)
        .build();
        Constellation ursaMinor = new Constellation("Ursa Minor", ursaMinorStars);
        constellations.add(ursaMinor);

        // Initialize the constellation Cassiopeia
        BlueStar segin = new BlueStar("Segin");
        DoubleStar ruchbah = new DoubleStar("Ruchbah");
        BlueStar navi = new BlueStar("Navi");
        RedStar schedar = new RedStar("Schedar");
        YellowStar caph = new YellowStar("Caph");
        ImmutableGraph<Star> cassiopeiaStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(segin, ruchbah)
        .putEdge(ruchbah, navi)
        .putEdge(navi, schedar)
        .putEdge(schedar, caph)
        .build();
        Constellation cassiopeia = new Constellation("Cassiopeia", cassiopeiaStars);
        constellations.add(cassiopeia);

        // Initialize the constellation Perseus
        StarCluster doubleCluster = new StarCluster("Double Cluster");
        RedStar miram = new RedStar("Miram");
        DoubleStar gammaPersei = new DoubleStar("Gamma Persei");
        YellowStar mirfak = new YellowStar("Mirfak");
        DoubleStar deltaPersei = new DoubleStar("Delta Persei");
        DoubleStar algol = new DoubleStar("Algol");
        ImmutableGraph<Star> perseusStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(doubleCluster, miram)
        .putEdge(miram, gammaPersei)
        .putEdge(gammaPersei, mirfak)
        .putEdge(mirfak, deltaPersei)
        .putEdge(mirfak, algol)
        .build();
        Constellation perseus = new Constellation("Perseus", perseusStars);
        constellations.add(perseus);

        // Initialize the constellation Andromeda
        YellowStar almach = new YellowStar("Almach");
        RedStar mirach = new RedStar("Mirach");
        DoubleStar deltaAndromedae = new DoubleStar("Delta Andromedae");
        BlueStar alpheratz = new BlueStar("alpheratz");
        DoubleStar piAndromedae = new DoubleStar("Pi Andromedae");
        YellowStar muAndromedae = new YellowStar("muAndromedae");
        RedStar nembus = new RedStar("Nembus");
        Galaxy andromedaGalaxy = new Galaxy("Andromeda Galaxy");
        ImmutableGraph<Star> andromedaStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(almach, mirach)
        .putEdge(mirach, deltaAndromedae)
        .putEdge(deltaAndromedae, alpheratz)
        .putEdge(alpheratz, piAndromedae)
        .putEdge(piAndromedae, muAndromedae)
        .putEdge(muAndromedae,nembus)
        .putEdge(muAndromedae,andromedaGalaxy)
        .build();
        Constellation andromeda = new Constellation("Andromeda", andromedaStars);
        constellations.add(andromeda);

        // Initialize the constellation Pegasus
        DoubleStar matar = new DoubleStar("Matar");
        RedStar scheat = new RedStar("Scheat");
        BlueStar algenib = new BlueStar("Algenib");
        BlueStar markab = new BlueStar("Markab");
        RedStar enif = new RedStar("Enif");
        ImmutableGraph<Star> pegasusStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(matar, scheat)
        .putEdge(scheat, alpheratz)
        .putEdge(alpheratz, algenib)
        .putEdge(algenib, markab)
        .putEdge(markab, scheat)
        .putEdge(markab, enif)
        .build();
        Constellation pegasus = new Constellation("Pegasus", pegasusStars);
        constellations.add(pegasus);

        //Initialize the constellation Cygnus
        YellowStar deneb = new YellowStar("Deneb");
        YellowStar sadr = new YellowStar("Sadr");
        DoubleStar fawaris = new DoubleStar("Fawaris");
        RedStar aljanah = new RedStar("Aljanah");
        RedStar etaCygni = new RedStar("Eta Cygni");
        DoubleStar albireo = new DoubleStar("Albireo");
        Nebula dumbbellNebula = new Nebula("Dumbbell Nebula");
        ImmutableGraph<Star> cygnusStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(deneb, sadr)
        .putEdge(sadr, fawaris)
        .putEdge(sadr, aljanah)
        .putEdge(sadr, etaCygni)
        .putEdge(etaCygni, albireo)
        .putEdge(albireo, dumbbellNebula)
        .build();
        Constellation cygnus = new Constellation("Cygnus", cygnusStars);
        constellations.add(cygnus);

        //Initialize the constellation Lyra
        YellowStar vega = new YellowStar("Vega");
        DoubleStar theDoubleDouble = new DoubleStar("The Double Double");
        DoubleStar zetaLyrae = new DoubleStar("Zeta Lyrae");
        DoubleStar deltaLyrae = new DoubleStar("Delta Lyrae");
        BlueStar sulafat = new BlueStar("Sulafat");
        Nebula ringNebula = new Nebula("Ring Nebula");
        DoubleStar sheliak = new DoubleStar("Sheliak");
        ImmutableGraph<Star> lyraStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(vega, theDoubleDouble)
        .putEdge(theDoubleDouble, zetaLyrae)
        .putEdge(zetaLyrae, vega)
        .putEdge(zetaLyrae, deltaLyrae)
        .putEdge(zetaLyrae, sheliak)
        .putEdge(deltaLyrae, sulafat)
        .putEdge(sulafat, ringNebula)
        .putEdge(ringNebula, sheliak)
        .build();
        Constellation lyra = new Constellation("Lyra", lyraStars);
        constellations.add(lyra);

        //Initialize the constellation Aquila
        RedStar tarazed = new RedStar("Tarazed");
        YellowStar altair = new YellowStar("Altair");
        YellowStar alshain = new YellowStar("Alshain");
        DoubleStar tseenFoo = new DoubleStar("Tseen Foo");
        DoubleStar deltaAquilae = new DoubleStar("Delta Aquilae");
        DoubleStar okab = new DoubleStar("Okab");
        BlueStar alThalimain = new BlueStar("Al Thalimain");
        StarCluster wildDuckCluster = new StarCluster("Wild Duck Cluster");
        ImmutableGraph<Star> aquilaStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(tarazed, altair)
        .putEdge(altair, alshain)
        .putEdge(alshain, tseenFoo)
        .putEdge(tseenFoo, deltaAquilae)
        .putEdge(deltaAquilae, okab)
        .putEdge(okab, altair)
        .putEdge(deltaAquilae, alThalimain)
        .putEdge(alThalimain, wildDuckCluster)
        .build();
        Constellation aquila = new Constellation("Aquila", aquilaStars);
        constellations.add(aquila);

        //Initialize the constellation Delphinus
        BlueStar aldulfin = new BlueStar("Aldulfin");
        DoubleStar rotanev = new DoubleStar("Rotanev");
        DoubleStar sualocin = new DoubleStar("Sualocin");
        DoubleStar gammaDelphini = new DoubleStar("Gamma Delphini");
        DoubleStar alUkud = new DoubleStar("Al Ukud");
        ImmutableGraph<Star> delphinusStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(aldulfin, rotanev)
        .putEdge(rotanev, sualocin)
        .putEdge(sualocin, gammaDelphini)
        .putEdge(gammaDelphini, alUkud)
        .putEdge(alUkud, rotanev)
        .build();
        Constellation delphinus = new Constellation("Delphinus", delphinusStars);
        constellations.add(delphinus);

        //Initialize the constellation Auriga
        DoubleStar capella = new DoubleStar("Capella");
        DoubleStar menkalinan = new DoubleStar("Menkalinan");
        DoubleStar mahasim = new DoubleStar("Mahasim");
        BlueStar elnath = new BlueStar("Elnath");
        RedStar hassaleh = new RedStar("Hassaleh");
        RedStar saclateni = new RedStar("Saclateni");
        ImmutableGraph<Star> aurigaStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(capella, menkalinan)
        .putEdge(menkalinan, mahasim)
        .putEdge(mahasim, elnath)
        .putEdge(elnath, hassaleh)
        .putEdge(hassaleh, saclateni)
        .putEdge(saclateni, capella)
        .build();
        Constellation auriga = new Constellation("Auriga", aurigaStars);
        constellations.add(auriga);

        //Initialize the constellation Taurus
        DoubleStar tianguan = new DoubleStar("Tianguan");
        RedStar aldebaran = new RedStar("Aldebaran");
        DoubleStar thetaTauri = new DoubleStar("Theta Tauri");
        YellowStar hyadumI = new YellowStar("Hyadum I");
        DoubleStar eudora = new DoubleStar("Eudora");
        StarCluster pleiades = new StarCluster("Pleiades");
        RedStar ain = new RedStar("Ain");
        ImmutableGraph<Star> taurusStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(tianguan, aldebaran)
        .putEdge(aldebaran, thetaTauri)
        .putEdge(thetaTauri, hyadumI)
        .putEdge(hyadumI, eudora)
        .putEdge(eudora, pleiades)
        .putEdge(eudora, ain)
        .putEdge(ain, elnath)
        .build();
        Constellation taurus = new Constellation("Taurus", taurusStars);
        constellations.add(taurus);

        //Initialize the constellation Orion
        BlueStar rigel = new BlueStar("Rigel");
        BlueStar saiph = new BlueStar("Saiph");
        DoubleStar alnitak = new DoubleStar("Alnitak");
        BlueStar alnilam = new BlueStar("Alnilam");
        DoubleStar mintaka = new DoubleStar("Mintaka");
        Nebula orionNebula = new Nebula("Orion Nebula");
        BlueStar bellatrix = new BlueStar("Bellatrix");
        BlueStar meissa = new BlueStar("Meissa");
        RedStar betelgeuse = new RedStar("Betelgeuse");
        ImmutableGraph<Star> orionStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(rigel, saiph)
        .putEdge(saiph, alnitak)
        .putEdge(alnitak, alnilam)
        .putEdge(alnilam, mintaka)
        .putEdge(mintaka, rigel)
        .putEdge(orionNebula, alnitak)
        .putEdge(orionNebula, saiph)
        .putEdge(orionNebula, rigel)
        .putEdge(alnitak, betelgeuse)
        .putEdge(betelgeuse, meissa)
        .putEdge(meissa, bellatrix)
        .putEdge(bellatrix, mintaka)
        .build();
        Constellation orion = new Constellation("Orion", orionStars);
        constellations.add(orion);

        //Initialize the constellation Gemini
        DoubleStar castor = new DoubleStar("Castor");
        RedStar pollux = new RedStar("Pollux");
        YellowStar alhena = new YellowStar("Alhena");
        RedStar tejat = new RedStar("Tejat");
        ImmutableGraph<Star> geminiStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(castor, pollux)
        .putEdge(pollux, alhena)
        .putEdge(alhena, tejat)
        .putEdge(tejat, castor)
        .build();
        Constellation gemini = new Constellation("Gemini", geminiStars);
        constellations.add(gemini);

        //Initialize the constellation Leo
        DoubleStar regulus = new DoubleStar("Regulus");
        YellowStar alJabhah = new YellowStar("Al Jabhah");
        DoubleStar algieba = new DoubleStar("Algieba");
        YellowStar adhafera = new YellowStar("Adhafera");
        RedStar rasalas = new RedStar("Rasalas");
        YellowStar algenubi = new YellowStar("Algenubi");
        ImmutableGraph<Star> leoStars = GraphBuilder.undirected()
        .<Star>immutable()
        .putEdge(regulus, alJabhah)
        .putEdge(alJabhah, algieba)
        .putEdge(algieba, adhafera)
        .putEdge(adhafera, rasalas)
        .putEdge(rasalas, algenubi)
        .build();
        Constellation leo = new Constellation("Leo", leoStars);
        constellations.add(leo);

        this.constellationsInitialized = true;

        return constellations;
    }

    /**
     * Initializes the player character
     * @param name name of the character
     * @return Player object
     */
    public Player PlayerCharacter(String name){
        Inventory pcInv = new Inventory();
        Player pc = new Player(name, 25, 2, 3, pcInv);
        return pc;
    }

    
}
