# Auditorium - Nézőtér
<h2>Informatika érettségi emelt szintű feladat: 2014. október</h2>
<p>A Fregoli Színházban a jegyeladásokat elektronikusan rögzítik. A színházban 15 sor, és soronként 20 szék van. A sorokat 1-től 15-ig számozzák, a sorokon belül pedig a székeket 1-től 20-ig. Egy előadásra a pillanatnyilag eladott jegyek eloszlását a foglaltsag.txt szöveges állomány tartalmazza, melyben "x" jelzi a foglalt és "o" a szabad helyeket.</p>

<p>Például:</p>
<pre>
ooxxxoxoxoxoxxxooxxx
xxxxxxxxxxxxxxxxxxxx
oxxxxxoooxxxxxxxxxxo
…
</pre>
<p>Az első sor 1-2. széke például még szabad, míg a 2. sorba az összes jegyet eladták. A jegyek ára nem egyforma, összege a helytől függően ötféle lehet. Azt, hogy az adott szék az öt közül melyik árkategóriába tartozik, a kategoria.txt fájl tartalmazza az alábbi formában:</p>
<p>Például:</p>
<pre>
33222111111111122233
43322221111112222334
44433322222222333444
…
</pre>
<p>A példa szerint az 1. sor 2. széke a 3. kategóriába, a 2. sor 1. széke a 4. kategóriába esik.</p>
<p>Készítsen programot nezoter néven a következő feladatok megoldására! A program futása során a képernyőre való kiíráskor, illetve az adatok billentyűzetről való beolvasásakor utaljon a feladat sorszámára (például: 3. feladat), és a kiírandó, illetve bekérendő tartalomra! Az ékezetmentes kiírás is elfogadott.</p>
<ol>
<li>Olvassa be és tárolja el a <i>foglaltsag.txt</i> és a <i>kategoria.txt</i> fájl adatait!
<li>Kérje be a felhasználótól egy sor, és azon belül egy szék számát, majd írassa ki a képernyőre, hogy az adott hely még szabad-e vagy már foglalt!
<li>Határozza meg, hogy hány jegyet adtak el eddig, és ez a nézőtér befogadóképességének hány százaléka! A százalékértéket kerekítse egészre, és az eredményt a következő formában írassa ki a képernyőre:<br /><pre>Például: Az előadásra eddig 156 jegyet adtak el, ez a nézőtér 42%-a.</pre>
<li>Határozza meg, hogy melyik árkategóriában adták el a legtöbb jegyet! Az eredményt írassa ki a képernyőre az alábbi formában:<br /> <pre>Például: A legtöbb jegyet a(z) 3. árkategóriában értékesítették.</pre>
<li>A jegyek árát kategóriánként a következő táblázat tartalmazza: 
<table>
<tr><th>árkategória</th><td>1</td><td>2</td><td>3</td><td>4</td><td>5</td></tr>
<tr><th>ár (Ft)</th><td>5000</td><td>4000</td><td>3000</td><td>2000</td><td>1500</td></tr>
</table>Mennyi lenne a színház bevétele a pillanatnyilag eladott jegyek alapján? Írassa ki az eredményt a képernyőre!
<li>Mivel az emberek általában nem egyedül mennek színházba, ha egy üres hely mellett nincs egy másik üres hely is, akkor azt nehezebben lehet értékesíteni. Határozza meg, és írassa ki a képernyőre, hogy hány ilyen "egyedülálló" üres hely van a nézőtéren!
<li>A színház elektronikus eladási rendszere az érdeklődőknek az üres helyek esetén a hely árkategóriáját jeleníti meg, míg a foglalt helyeket csak egy "x" karakterrel jelzi. Készítse el ennek megfelelően a fenti adatokat tartalmazó <i>szabad.txt</i> fájlt!
<pre>
Például:
33xxx1x1x1x1xxx22xxx
xxxxxxxxxxxxxxxxxxxx
4xxxxx222xxxxxxxxxx4
…
</pre>
</ol>
<hr>
<h3>Források:</h3>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2014osz_emelt/e_inf_14okt_fl.pdf">Feladatlap</a>
<li><a href="https://www.oktatas.hu/bin/content/dload/erettsegi/feladatok_2014osz_emelt/e_inffor_14okt_fl.zip">Forrásállományok</a>