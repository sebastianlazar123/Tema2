
## Tema2-IP-WeatherApp - - -Autor: Lazăr Sebastian
 :cloud: :cloud: :cloud:
Aplicatia Tema2-IP-WeatherApp răspunde cerințelor temei 2.
Este nevoie de un fișier de intrare(orase in cadrul porietctului) ce trebuie sa conțină câmpurile id, longitudine,latitudine,numele orașului si codul țării. Pentru fiecare linie din fișierul de intrare câmpurile vor fi distanțate prin tab.
Aplicația obține informații legate de vreme pentru orașul selectat de utilizator. Informațiile se obțin prin OpenWeather API.
Aplicația reține răspunsurile pentru fiecare utilizare a acesteia în fișierul istoric.txt.
Se folosește ahitectura MVC.
 :sunny: :sunny: :sunny:


## Modul de utilizare al aplicației și testarea acesteia
 :cloud: :cloud: :cloud:
Aplicația vine cu o serie de orașe în cadrul fișierului orase . Se pot adăuga și alte orașe în acel fișier cât timp se respectă structura.
În momentul în care se rulează aplicația trebuie ales câmpul Tara. În acea listă se regăsesc codurile țărilor identificate în fișierul de intrare.
După ce se selectează țara la nivelul listei de orașe se generează orașele disponibile pentru țara selectată.
Se alege orașul și se apasă butonul "Selecteaza" . După apăsarea butonului se vor afișa datele legate de vremea în orașul respectiv. Totodată se adaugă informații în fișierul istoric.txt .
Dacă nu se respectă   pașii anteriori și se apasă "Selecteaza", aplicația va afișa un mesaj de eroare prin care utilizatorul este atenționat că nu a procedat cum trebuie.
Aplicația a fost testată atât prin intermediul claselor de testare CityTest și CityTestMock cât și prin utilizarea acesteia. Componentele testate în cadrul claselor de testare funcționează bine, trecând absolut toate testele.
Totuși aplicația prezintă un bug, în contextul în care utilizatorul vrea să afle vremea în două orașe aparținând aceleași țări. Aplicația nu va interpreta alegerea aceleași țări și se va considera că nu s-a făcut selecția. Astfel soluția pentru utilizator este să aleagă un oraș aparținând altei țări urmând ca apoi să selecteze informațiile pentru cel de al doilea oraș dorit inițial, 
 :sunny: :sunny: :sunny:
## Detalii legate de implementare
 :cloud: :cloud: :cloud:
Aplicația funcționează după modelul MVC.
La nivelul clasei City se definește obiectul de tip City conținând identificatorul orașului, numele și codul țării
În cadrul fișierului MainPage.fxml  se realizează descrierea interfeței grafice.
La nivelul clasei CityEditController se realizează operațiile pentru asigurarea funcționalităților.
 :sunny: :sunny: :sunny:
