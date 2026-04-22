# CaloriX
<img width="122" height="124" alt="image 10" src="https://github.com/user-attachments/assets/175fdf1c-cac5-4b9a-9709-8d2ea8c11931" />

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
* **Virtuaalne emulaator:** Avage paremal üleval nurgas asuv **Device Manager**, valige oma loodud virtuaalne seade ja vajutage **Play** (Launch) nuppu. Kui seadet pole, looge uus, vajutades "Create Device".
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

## Grupiliikmed
- [Vitali Kolesnikov](https://github.com/Vitali-Kol)
- [Aleksandr Gritsenko](https://github.com/Terabyte23)
- [Emil Munassypov](https://github.com/vTyzee)

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









