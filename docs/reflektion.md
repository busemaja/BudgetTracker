# Reflektion kodkvalitet

## Namngivning
|Namn |Förklaring |Reflektion och regler från Clean Code |
|-----|-----------|--------------------------------------|
|BudgetTracker|Namnet på huvudklassen|**Class names**: klassnamn bör vara substantiv eller substantivfraser, varav denna tillhör de senare|
|addTransactionAndLogIt|Namn på en metod som lägger till en transaktion till programmet och även loggar händelsen|**Use intention-revealing names**: namnet berättar precis vad som händer i metoden. **Method names**: namnet består en verbfras|
|getInfoOnLargestTransaction|Namn på en metod som returnerar basinformationen hos en "aktiv"(ej raderad) transaktion|**Use searchable names**: så länge man minns namnet så är det definitivt en metod som är lätthittad mha sökverktyg **Use pronounceable names**: väldigt lätt att uttala då det är en egen liten mening i kamelform|
|categoryPercentageString|En lokal variabel från metoden getPercentagesByCategory(), konkatering av kategorinamn och procentandel|**Avoid disinformation**: man kan argumentera för att namnet är något otydligt, iaf om man läser det utanför metoden där den används, innehåller den endast en procentsats eller mer? |
|transactionLogCopy|En ArrayList av strings som används lokalt i metoden getTransactionLog() för att inte råka sabba nåt i originalloggen|**Use intention-revealing names**: tydligare blir det inte, detta är en kopia av transactionLog. (fler regler gäller, men jag har redan använt dem ovan, så redundans)|

### Reflektion kapitel 2 - Meaningful names
Det känns överlag väldigt bekant, särskilt om man haft Mats som lärare. Det ska vara tydligt, läsbart, och inte förvirrande. Känns självklart, absolut om man läst både andras och sin egen gamla kod och suttit med frågetecken krypandes ur öronen.  
Kommunikation är något av det svåraste vi kan ta för oss som människor (lustigt nog mtp att vi är flockdjur), och för både egen och andras skull är detta något vi verkligen borde arbeta mycket på.
Jag håller väl kanske inte med om riktigt allt i kapitlet, som tex att man inte ska använda ord som "List" även om det är en lista man skapat, men det kan ju också bero på att jag är såpass grön som jag är.  
Absolut att man bör sikta på "*clarity is king*", men kanske inte till absurdum, vilket ju iofs Bob också diskuterar.. balansen mellan tydliga namn och vansinnigt långa namn. Svårt!

## Funktioner
|Metodnamn |Länk eller kod |Antal rader (ej ws) |Reflektion |
|----------|---------------|--------------------|-----------|
|addTransactionAndLogIt|[Länk till kod](../src/budgettracker/BudgetTracker.java#L28)|13|**Do one thing**: här bryter vi lite mot reglerna genom att ha input-validering i metoden, det skulle lätt kunna brytas ut till en egen metod eller tre **Function arguments**: jag mår lite dåligt över 3 parametrar här, men kunde verkligen inte komma på en annan lösning utan en massa parsning|
|removeTransactionAndLogIt|[Länk till kod](../src/budgettracker/BudgetTracker.java#L50)|16|**Use descriptive names**: jag tycker ju det gäller för alla mina metoder. Det är tydligt vad som händer, en transaktion tas bort och händelsen loggas. Vill man verkligen så kan det väl förvisso uppstå förvirring kring vad som loggas exakt, men där kommer ju javadoc in.. **Extract Try/Catch Blocks**: här skulle jag helt klart kunna bryta ut min felhantering, men det känns nånstans ändå lite fel att ha en metod removeTransactionAndLogIt() och en removeTransaction()|
|getInfoOnLargestTransaction|[Länk till kod](../src/budgettracker/BudgetTracker.java#L100)|6|**Small!**: ja, kortast av de längsta är den iaf **Have no side effects**: jag gör en kopia av loggen i klassen just för att inte påverka originalet, men ändå kunna manipulera den efter behov|
|getPercentagesByCategory|[Länk till kod](../src/budgettracker/BudgetTracker.java#L114)|17|**One level of abstraction per function**: här är jag lite osäker, men jag tror jag bryter mot denna genom att ha metodanrop blandat med beräkningar och strängformatering. Jag skulle säkert kunna lösa det genom att bryta ut formateringen till egna metoder, men just i detta fallet kändes det ovärt för mig|
|logTransaction|[Länk till kod](../src/budgettracker/BudgetTracker.java#L172)|14|**Switch statements**: jag gillar switchar. Just i den här modulen kommer den mest troligen aldrig att växa sig särskilt stor heller, men annars finns alternativet att antingen byta till en rule switch som är lite smalare uppbyggd, eller som Bob föreslår, bryta ut det hela till en separat subklass (overkill här, ändå privat liten metod)|

### Reflektion kapitel 3 - Functions
Bob är en hård man med strikta regler. Otroligt mycket matnyttigt dock, jag är glad för boken! Kapitlet lämnar inga tvivel till vad man bör göra, det är många tydliga exempel och förklaringar. Jag hade tex aldrig funderat så mycket över det där med antalet parametrar (även om jag ogillat för många sen jag började), och att bryta ut try/catch kom som en rolig nyhet som jag gärna provar i framtiden. 

### Reflektion över min egen kodkvalitet
Jag har rätt svårt att läsa kod, både min egen och andras, så jag tenderar att ha det väldigt luftigt och försöka vara övertydlig. Självklart brister jag och sitter lika förvirrad som om jag läste en grekisk ordbok lite för ofta.  
Kommentarer är något jag använt sparsamt den här gången, mest för att jag ogillar att skriva dem och hjärnan sållar ändå bort dem sen, men också för att jag kände att jag "fick lov" iom boken (ja, jag vet att kommentarer kommer nästa gång, men det kändes stort att skala ner!).  
Jag bryter uppenbart mot ett flertal regler (som jag nämner i mina tabeller ovan), men överlag skulle jag ändå vilja påstå att den är hyfsat läsbar och ganska lätt att förstå. Jag läste kapitel 2 och 3 en bra bit innan jag började koda, så jag hade dem färska i bakhuvudet vilket såklart påverkade en hel del. Hann tyvärr glömma en del också, men det blir desto roligare att läsa om boken med färdig kod då.  
Det som satt sig mest hos mig, som jag inte implementerade alls eller lite för lite innan, är bland annat Interfaces och implementationer och dess namngivningar, smidigt att differtiera tydligt med "factory" direkt i namnet.  
Jag skulle mycket väl kunna göra mig skyldig till roliga namn också, men det får väl stanna i egna små projekt som inte ser dagens ljus.  
Sen kan jag tycka att det visserligen är bekvämt med små metoder, men personligen tycker jag det är otroligt jobbigt att behöva läsa igenom metod efter metod för att hänga med i vad som händer. Sen å andra sidan är det ofantligt besvärligt med stora metoder som gör sjuttioelva saker också, så damned if you do etc..  

### Bonus - Små tankar under kodandet
*Små - för att jag glömde skriva ner allt.*  
- Inte helt nöjd med modulnamnet SecureBudget, men kommer inte på något bättre just nu. **– Ändrat till BudgetTracker**
- Ändrat metodnamn för att bättre spegla exakt vad som händer – tex från addTransaction() till addTransactionAndLogIt().
- Ändra från print av summa till return double i getCurrentTotal() för att minska antalet saker metoden gör.
- Lånade filehandler metod från tidigare projekt (men strippade den en del och gjorde om lite)
