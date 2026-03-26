# CaloriX
<img width="122" height="124" alt="image 10" src="https://github.com/user-attachments/assets/175fdf1c-cac5-4b9a-9709-8d2ea8c11931" />


## Projekti nimi
CaloriX – kalorite ja toitumise jälgimise mobiilirakendus

## Projekti eesmärk
CaloriX on mobiilirakendus, mille eesmärk on aidata kasutajatel jälgida oma igapäevast kaloraaži, toitumisharjumusi ja toidu toiteväärtust. 
Rakendus aitab kasutajal teha teadlikumaid valikuid ning toetab tervislikku eluviisi.

## Projekti lühitutvustus
CaloriX võimaldab kasutajal lisada päeva jooksul söödud toite, jälgida tarbitud kaloreid ning saada ülevaadet oma toitumisest. 
Lisaks saab kasutaja vaadata erinevate toiduainete toiteväärtust ning seada isiklikke eesmärke, näiteks kaalulangus, kaalutõus või tasakaalustatud toitumine.
## Projekti disain ja WelcomePage niimoodi välja näevad.
<img width="343" height="670" alt="image" src="https://github.com/user-attachments/assets/6e0e57ff-1511-4f94-990f-8dac0c55ed27" />

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
- Vitali Kolesnikov
- Aleksandr Gritsenko
- Emil Munassypov

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

## Projekti struktuur
- `data/` – andmete haldus (API, DB, repositories)
- `model/` – andmemudelid
- `ui/` – ekraanid, komponendid ja teemad
- `viewmodel/` – vaadete äriloogika
- `di/` – dependency injection (Hilt/Koin)
- `util/` – abifunktsioonid
