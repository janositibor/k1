# Vizsgafeladat

A feladatok megoldásához az IDEA fejlesztőeszközt használd! Bármely régebbi osztályt megnyithatsz.

Új repository-ba dolgozz! Ezen könyvtár tartalmát nyugodtan át lehet másolni (`pom.xml`, tesztek). Projekt, könyvtár,
repository neve legyen: `sv2-2021-jvjbf-kepesito`. GroupId: `training360`, artifactId: `sv2-2021-jvjbf-kepesito`.

Ha ezzel kész vagy, azonnal commitolj, a commit szövege legyen: `init`.

Az egyes feladatokat külön csomagba szervezd! A csomagneveket a feladat leírásában találod. Minden egyes
feladathoz tartoznak előre elkészített tesztosztályok. Ezekkel a megoldásod helyességét ellenőrizheted.

A feladatra 3 órád van összesen!

Ha letelik az idő, mindenképp commitolj, akkor is, ha nem vagy kész! A commit időpontja alapján fogjuk
ellenőrizni a megoldásod. Ha nincs commitod az idő lejárta előtt, akkor sajnos nem tudjuk értékelni a megoldásod!

## Bővelkedő számok (Algoritmusos feladat, 20 pont)

A számelméletben bővelkedő számnak nevezünk minden olyan egészt, amelyre a valódi osztók összege nagyobb, mint maga a szám. Azaz az `n` egész esetén `s(n) > n`. (<i>Forrás: Wikipédia </i>)
Egy osztó valódi osztó ha nem egyezik meg a számmal. Pl.: A `6` valódi osztói az `1`, `2`, `3`. A `6` nem bővelkedő, mert `1 + 2 + 3 = 6` és ez nem nagyobb, mint
maga a szám, azaz nem nagyobb, mint `6`. 
A 24 valódi osztói 1,2,3,4,6,8,12 és 1+2+3+4+6+8+12 = 36, tehát a 24 bővelkedő. <br>
A `Numbers` nevű osztályban írj egy `boolean isAbundantNumber(int number)` nevű metódust, amely eldönti egy számról, hogy bővelkedő-e!
Figyelj arra, hogy a paraméterül átadott szám pozitív kell, hogy legyen! Amennyiben nem pozitív, dobj a tesztesetnek
megfelelő kivételt!

## Streaming szolgáltató (OOP, 20 pont)

A feladatban egy Streaming szolgáltató felépítését fogjuk modellezni. Az alapegység a videó lesz és a szolgáltatón 
elérhetőek lesznek filmek és sorozatok.
A filmek egy videóból állnak, a sorozatok többől.

Készítsd el a `Video` osztályt! Minden videónak van egy címe és egy hossza (egész szám, percben), ezeket konstruktorban kapja meg.
Hozd létre a `Genre` nevű felsoroló típust a következő felsorolókkal: `ADVENTURE`, `ACTION`, `THRILLER`, `HORROR`, `COMEDY`!

Hozd létre a `Content` nevű interface-t a következő absztrakt metódusokkal! `String getTitle()`, `double getRating()`, `int getLength()` és
`Genre getGenre()`. Az interface terjessze ki a `Comparable` interface-t és itt alapértelmezetten definiálja felül a `compareTo()` metódust úgy, 
hogy két `Content` az értékelés alapján legyen összehasonlítható!

Készítsd el a `Movie` osztályt, melynek adattagjai `Video video`, `Genre genre` és `double rating`! Az adattagokat konstruktorban állítjuk be. Ez az osztály implementálja a `Content`
interface-t! Értelemszerűen definiáljuk felül a metódusokat! A cím és a hossz a filmhez tartozó videóban találhatóak.

Készítsd el a `Series` osztályt, melynek adattagjai `String title`, `List<Video> videos`, `Genre genre` és `double rating`. Itt a cím adattag magát 
a sorozat címét jelöli, ezen felül persze minden egyes résznek van egy külön címe. Konstruktorban állítsuk be az objektum állapotát, de
figyeljünk, hogy sorozatot nem lehet üres listával vagy `null` listával létrehozni! (Ekkor dobjon a tesztesetnek megfelelő kivételt!)  
Ez az osztály is implementálja a `Content` interface-t!
A cím lekérésekor a sorozat címét adjuk vissza, a hosszánál pedig a videók hosszának összegét!

Készítsd el a `StreamingService` osztályt, melyben hozz létre egy `Content`-eket tartalmazó listát és egy metódust aminek segítségével elemet lehet hozzáadni!

## Streaming szolgáltató (Collection, 20 pont)

A következő metódusokat a `StreamingService` osztályba készítsd el:

*  `List<Content> getContentsSortedByRating()`, értékelés alapján sorbarendezve adja vissza a tartalmakat (filmeket és sorozatokat)! Az eredeti lista ne módosuljon!
*  `List<Content> findByTitle(String title)`, cím alapján adja vissza a tartalmakat, amiknek címe egyezik a paraméterül átadott értékkel.  
*  `Map<Genre,Integer> countContentByGenre()`, műfajonként összegyűjti a tartalmak darabszámát!

## Üzenetek (Filekezelés, 20 pont)

Adott a `data.txt` és `data2.txt` nevű állomány, melyekben egy-egy üzenetváltás található. A fájl blokkokból áll, 
melynek az első sora tartalmazza a nevet és a küldés idejét, majd a következő sor az üzenetet, majd egy üres sor.

Erre egy példa:

```
John 13:43
Hello

Jane 14:54
Hello

John 14:56
How are you?
```

Készítsd el a `Message` osztályt melynek adattagjai egy küldő (`String`) egy `LocalTime` típusú idő és egy üzenet!

Készítsd el a `MessageService` osztályt, mely beolvassa a fájl tartalmát egy üzeneteket tartalmazó listába!

<i>Segítség: `String`-et `LocalTime` típussá a `LocalTime.parse()` metódussal lehet konvertálni.</i>

Készítsd el benne még az `isMessagesInOrder()` metódust, ami igazzal tér vissza, ha az időpontok egymás után növekvő sorrendben szerepelnek!
Ha a lista üres, vagy egy elem van benne, akkor `true` értékkel térjen vissza!

## Vonatok (Adatbáziskezelés, 20 pont)

A `trains` táblában a következő adatok találhatók: a vonat célállomása, indulási idő (pl: 2022.03.11 12:30), maximum kapacitás és
a már jegyet váltott utasok száma. 
A migrációs sql fájl elnevezéseinek megfelelően hozd létre a `Train` osztályt, melynek adattagjai legyenek a tábla oszlopai!

A `TrainRepository` osztályban valósítsd meg a `long insertTrain(String destination, LocalDateTime departure, int maxCapacity)` metódust,
mellyel egy vonatot lehet beszúrni a táblába! A `number_of_passengers` alapértéke ilyenkor 0. A beszúrást követően adjuk vissza az adatbázis által
generált egyedi azonosítót!
Készíts egy `Train findById(long id)` metódust mely id alapján visszaad egy vonatot! Készíts egy
`List<Train> getTrainsByDestination(String destination)` metódust, ami célállomás alapján visszaadja az összes vonatot, időpont szerint növekvő sorrendben!
És legyen még benne egy `void updateNumberOfPassengersById(long id, int amount)` metódus, ami az eddigi utasszámhoz a megfelelő id-jú vonaton hozzáadja
a paraméterül kapott mennyiséget!

Készíts egy `TrainService` nevű osztályt, mely egy repository objektumot kap konstruktorban! Legyen benne egy
`Train buyTicketForTrain(String destination, int amount)` metódus, ami először lekéri az összes vonatot célállomás szerint,
majd megpróbál sorban jegyet venni. Jegyet akkor tud venni, ha a vásárolni kívánt mennyiséggel, nem haladja meg az utasok száma
a vonat maximum kapacitását. Az első olyan vonatnál, ahol ez a feltétel teljesül, növeljük az utasok számát (használva a repository már létező metódusát) 
és térjünk vissza a már módosított értéket tartalmazó vonattal!
Ha egyik vonatra sem sikerül jegyet vennie, dobj `IllegalStateException`-t!
