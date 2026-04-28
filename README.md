# CaloriX
<img width="122" height="124" alt="image 10" src="https://github.com/user-attachments/assets/175fdf1c-cac5-4b9a-9709-8d2ea8c11931" />

# Valime kihilise arhitektuuri MVVM (Model-View-ViewModel) mustri abil.
<img width="1152" height="648" alt="image" src="https://github.com/user-attachments/assets/2dc2b875-42ce-40f8-9a6c-c89066fa0ca6" />


### 1. Persoonad

| Karakteristik | Persona 1: Joonas (Üliõpilane) | Persona 2: Eeva (Treenija) |
| :--- | :--- | :--- |
| **Vanus** | 21 aastat | 28 aastat |
| **Pilt** | <img src="https://github.com/user-attachments/assets/9d96012b-43ec-4bd2-8833-0f2a3b9a311c" width="200" /> | <img src="https://github.com/user-attachments/assets/caab0872-342e-4bd1-8a63-331c3a382cc3" width="200" /> |
| **Elustiil** | **Aktiivne, kuid kiire.** Käib loengutes, töötab poole kohaga ja sööb sageli väljas või teel olles. | **Rutiinne ja tervislik.** Istuv kontoritöö, kuid käib 3-4 korda nädalas jõusaalis ja planeerib toidukordi ette. |
| **Eesmärk** | Kaalu langetamine ilma stressita. | Lihasmassi kasvatamine ja makrode jälgimine. |
| **Vajadus** | Kiire ja lihtne toidu lisamine loengute vahel. | Detailne statistika valkude ja süsivesikute kohta. |
| **Probleem** | Unustab sageli vahepalasid kirja panna. | Tahab näha edusamme pikas perspektiivis. |

---

### 2. Kasutusstsenaariumid

#### Stsenaarium A: Kiire sissekanne (Joonas)
Joonas on loengute vahelisel pausil ja ostab kohvikust kiirtoidu. Tal on vaid paar minutit aega. Ta avab CaloriX äpi, sisestab otsingusse toidu nime ja lisab selle ühe klikiga oma päeva logisse. Äpp näitab talle kohe, kui palju kaloreid on tal veel päeva lõpuni jäänud, mis aitab tal järgmisi söögikordi paremini planeerida.

#### Stsenaarium B: Toitainete tasakaalu analüüs (Eeva)
Eeva on lõpetanud õhtuse treeningu ja soovib teada, kas ta on tarbinud piisavalt valku. Ta avab rakenduses statistika vaate ja näeb graafikut, mis jaotab päeva jooksul söödud toidu valkudeks, rasvadeks ja süsivesikuteks. Ta märkab, et valgu eesmärk on peaaegu täis ja otsustab õhtusöögiks valmistada midagi kergemat, et püsida oma seatud plaanis.

---

### 3. Kasutajalood (User Stories)

* **Toidu otsing:** Kasutajana soovin otsida toiduaineid andmebaasist, et ma ei peaks kaloreid ja toitaineid käsitsi sisestama.
* **Päevane ülevaade:** Kasutajana soovin näha visuaalset progressiriba oma päevasest kalorieesmärgist, et saaksin kiiresti hinnata oma hetkeseisu.
* **Makrotoitainete jaotus:** Kasutajana soovin näha valkude, rasvade ja süsivesikute jaotust, et tagada oma toitumise tasakaalustatus.
* **Ajaloo logi:** Kasutajana soovin näha oma eelmiste päevade logisid, et analüüsida oma toitumisharjumusi ja märgata mustreid.
* **Eesmärkide seadmine:** Kasutajana soovin määrata oma individuaalse kaloraaži ja makrode eesmärgid vastavalt oma füüsilisele aktiivsusele.

# Juhised käivitamiseks

Järgige neid samme, et seadistada ja käivitada CaloriX projekt oma arvutis.

### 1. Koodi hankimine
1. Vajutage repositooriumi lehel rohelist nuppu **"Code"**.
2. Valige **"Download ZIP"**.
3. Pakige alla laetud arhiiv lahti sobivasse kausta oma arvutis.

### 2. Ettevalmistus
* Paigaldage **Android Studio**.
* Veenduge, et teil on installitud **JDK 17**.

### 3. Firebase'i seadistamine ⚠️ **Oluline**
Ilma selle sammuta projekt ei kompileeru ega käivitu korrektselt:
1. Looge uus projekt [Firebase Console'is](https://console.firebase.google.com/).
2. Lisage projekti Android-rakendus paketinimega (Package Name): `ee.vtyzee.calorix`.
3. Laadige alla konfigureerimisfail **`google-services.json`**.
4. Kopeerige see fail projekti kausta järgmisel teel: `CaloriX-main/app/`.

### 4. Käivitamine
1. Avage **Android Studio**.
2. Valige **"Open"** ja navigeerige kaustani, kuhu arhiivi lahti pakkisite.
3. Oodake, kuni projekt laetakse ja **Gradle Sync** on lõppenud.
4. **Virtuaalne emulaator:** Avage paremal üleval nurgas asuv **Device Manager**, valige oma loodud virtuaalne seade ja vajutage **Play** (Launch) nuppu. Kui seadet pole, looge uus, vajutades "Create Device".
5. Vajutage ülemisel paneelil ikooni **Run** (roheline kolmnurk).


## Projekti nimi
CaloriX – kalorite ja toitumise jälgimise mobiilirakendus

## Projekti eesmärk
CaloriX on mobiilirakendus, mille eesmärk on aidata kasutajatel jälgida oma igapäevast kaloraaži, toitumisharjumusi ja toidu toiteväärtust. 
Rakendus aitab kasutajal teha teadlikumaid valikuid ning toetab tervislikku eluviisi.

## Projekti lühitutvustus
CaloriX võimaldab kasutajal lisada päeva jooksul söödud toite, jälgida tarbitud kaloreid ning saada ülevaadet oma toitumisest. 
Lisaks saab kasutaja vaadata erinevate toiduainete toiteväärtust ning seada isiklikke eesmärke, näiteks kaalulangus, kaalutõus või tasakaalustatud toitumine.

## Projekti disain Figmas
- Figma link - https://www.figma.com/design/c30RwLXJQkBz8D0KKsF4ZP/Untitled?node-id=0-1&t=HCDBqiiKo8FXUGPC-1

## Peamised funktsioonid
- kasutaja registreerimine ja sisselogimine
- toitude otsimine ja lisamine päevikusse
- päevase kaloraaži jälgimine
- makrotoitainete jälgimine
- toitumise analüüs
- isiklike eesmärkide seadmine
- kasutajasõbralik ja lihtne mobiililiides

## Sihtgrupp
Rakendus on mõeldud inimestele, kes soovivad:
- jälgida oma toitumist
- hoida kontrolli all päevast kaloraaži
- parandada oma toitumisharjumusi
- saavutada tervise- või kehakaaluga seotud eesmärke

## Grupiliikmed ja rollid

* **[Vitali Kolesnikov](https://github.com/Vitali-Kol)** – **Peamine arendus ja back-end.** Tegeles rakenduse loogika kirjutamisega Android Studios, andmebaaside ühendamise ja süsteemi tehnilise teostusega.
* **[Aleksandr Gritsenko](https://github.com/Terabyte23)** – **Disain ja UI/UX.** Tegeles rakenduse visuaalse poole disainimisega Figmas ja kasutajaliidese planeerimisega.
* **[Emil Munassypov](https://github.com/vTyzee)** – **GitHubi haldus ja projektijuhtimine.** Lõi projekti hoidla (repository), haldas koodi versioone ja hoidis kogu arendusprotsessi kontrolli all.

## Kasutatav arendusmudel
Meie projektis kasutame agiilset arendusmudelit, täpsemalt Kanbani-metoodikat.

## Miks valisime Kanbani?
Valisime Kanbani, sest see on lihtne ja visuaalne arendusmudel, mis sobib hästi meie meeskonnaprojekti jaoks. 
Kanban aitab meil ülesandeid selgelt jagada, jälgida töö edenemist ja hoida kogu projekt organiseerituna. 
Selle mudeli eelis on paindlikkus, sest vajadusel saame ülesandeid kiiresti ümber korraldada ja prioriteete muuta.

## Kuidas me plaanime töötada?
- jagame projekti sprintideks
- koostame backlog’i
- määrame ülesanded grupiliikmete vahel
- jälgime edenemist regulaarselt
- arutame tulemusi ja viime sisse parandused

## Repositooriumi eesmärk
Selles repositooriumis hoiame kogu projekti lähtekoodi, dokumentatsiooni, disainifaile ja teisi olulisi materjale. 
GitHub võimaldab kõigil grupiliikmetel teha koostööd, jälgida muudatusi ja arendada projekti ühes keskkonnas.

## Tulevased arendused
Edaspidi soovime lisada:
- toidusoovitused kasutaja eesmärkide põhjal
- veetarbimise jälgimise
- iganädalased statistilised ülevaated
- visuaalsed graafikud kasutaja edenemise kohta

## Tehnoloogiad
- **IDE:** Android Studio
- **Keel:** Kotlin
- **UI:** Jetpack Compose
- **Andmed:** Firebase

## Pildid
<img width="360" height="700" alt="UusParool" src="https://github.com/user-attachments/assets/e966fec1-7271-4818-945f-f84c94b7307a" />
<img width="360" height="700" alt="UnustasidParooli" src="https://github.com/user-attachments/assets/bdb183a5-1dc9-4ace-a1a5-286c09fa2bba" />
<img width="360" height="700" alt="Register" src="https://github.com/user-attachments/assets/f2a5fee9-58be-4981-856e-0932c4754bdf" />
<img width="360" height="700" alt="Login" src="https://github.com/user-attachments/assets/a86b6872-3395-4831-8be2-0752cc4a87bd" />
<img width="360" height="700" alt="Welcome" src="https://github.com/user-attachments/assets/7d86a85a-c95e-485f-9dc4-dc9aec16d527" />


## Projekti struktuur
```
caloriX/
├── app/src/main/java/com/example/calorix/
│   ├── ui/                       # Rakenduse värvid, tüpograafia ja teema
│   │   └── theme/
│   │       ├── Color.kt
│   │       ├── Theme.kt 
│   │       └── Typography.kt
│   │
│   ├── MainActivity.kt           # Rakenduse sisenemispunkt ja navigeerimiskeskus
│   │
│   ├── WelcomeScreen.kt          # Avaleht (tervitusekraan)
│   ├── LoginScreen.kt            # Kasutaja sisselogimise ekraan
│   ├── RegistrationScreen.kt     # Uue konto loomise ekraan
│   ├── ForgotPasswordScreen.kt   # Unustatud parooli lähtestamise päring
│   ├── UusParoolScreen.kt        # Uue turvalise parooli määramine
│   │
│   └── HomeScreen.kt             # Peamine töölaud (dashboard) pärast sisselogimist
│
├── app/src/main/res/             # Vektorgraafika (SVG/XML pildid), fondid (Nunito)
└── app/src/androidTest/          # UI (kasutajaliidese) instrumentaaltestid
    └── tests.kt                  # Automaattestide koodifail

```
<img width="300" height="822" alt="image" src="https://github.com/user-attachments/assets/5df7c045-9a50-4914-bef9-fc14f3686ea7" />









