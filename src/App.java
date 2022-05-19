import java.util.Scanner;

public class App {

    /**
     * Data la classe Orario, svolgere la classe TestOrario che gestisce un array di
     * 100 oggetti
     * della classe Orario. Gestire un menù con le seguenti voci:
     * - premi 0 per uscire
     * - premi 1 per inserire un orario prendendo in input la città e l'orario
     * (ore,muniti,secondi)
     * - premi 2 per visualizzare tutti gli oggetti della classe Orario
     * - premi 3 per visualizzare l'orario di tutte le città
     * - premi 4 per visualizzare l'orario (e il valore dell'attributo solare)
     * di una città il cui nome viene preso in input
     * 
     * 
     */

    static int trovaCitta(Orario[] o, String citta, int cont) {
        citta = citta.toLowerCase();
        for (int i = 0; i < cont; i++) {
            if (o[i].citta.toLowerCase().equals(citta)) {
                return i;
            }
        }

        return -1;
    }

    static void ordina(Orario[] o, int cont) {

        for (int i = 0; i < cont; i++) {
            for (int k = i + 1; k < cont; k++) {
                if (o[i].ore > o[k].ore) {
                    Orario temp = o[i];
                    o[i] = o[k];
                    o[k] = temp;
                    
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int scelta;
        Orario[] orari = new Orario[1000];
        int cont = 0, ore, minuti, secondi;
        String citta, nazione;
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("0. esci");
            System.out.println("1. Inserisci orario");
            System.out.println("2. visualizzare orari");
            System.out.println("3. visualizzare orari (no attributo solare)");
            System.out.println("4. orario di una citta' in input");
            System.out.println("5. Impostare ora solare per citta presa in input");
            System.out.println("6. Impostare ora legale per citta presa in input");
            System.out.println("7. Numero di fusi orari per nazione in input");
            System.out.println("8. Nazione in input e conto quante citta ci sono");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 0:
                    break;
                case 1:
                    if (cont < 1000) {
                        System.out.println("Inserisci nome citta");
                        citta = scanner.nextLine();
                        System.out.println("Inserisci Nazione");
                        nazione = scanner.nextLine();
                        System.out.println("Inserisci ore");
                        ore = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci minuti");
                        minuti = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci secondi");
                        secondi = scanner.nextInt();
                        scanner.nextLine();

                        orari[cont] = new Orario(citta, nazione, ore, minuti, secondi);
                        cont++;
                    } else {
                        System.out.println("L'array e' pieno");
                    }
                    break;
                case 2:
                    if (cont > 0) {
                        for (int i = 0; i < cont; i++) {
                            orari[i].visualizza();
                        }
                    } else {
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 3:
                    if (cont > 0) {
                        for (int i = 0; i < cont; i++) {
                            System.out.println("************");
                            System.out.println("Citta= " + orari[i].citta);
                            System.out.println("Nazione= " + orari[i].nazione);
                            System.out.println("Ora= " + orari[i].ore + ":" + orari[i].minuti + ":" + orari[i].secondi);
                            System.out.println("************");
                        }
                    } else {
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 4:
                    if (cont > 0) {
                        int ind;

                        System.out.println("Inserisci la citta da cercare");
                        citta = scanner.nextLine();

                        ind = trovaCitta(orari, citta, cont);
                        if (ind > -1) {
                            orari[ind].visualizza();
                        } else {
                            System.out.println("La citta' cercata non e' presente nell'array");
                        }
                    } else {
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 5:
                    if (cont > 0) {
                        int ind;

                        System.out.println("Inserisci citta da cercare");
                        citta = scanner.nextLine();

                        ind = trovaCitta(orari, citta, cont);
                        if (ind > -1) {
                            if (orari[ind].toSolare()) {
                                System.out.println("ora solare impostata con successo");
                            } else {
                                System.out.println("L'ora solare e' gia' impostata");
                            }
                        } else {
                            System.out.println("La citta cercata non e' presente nell'array");
                        }
                    } else {
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 6:
                    if (cont > 0) {
                        int ind;

                        System.out.println("Inserisci citta da cercare");
                        citta = scanner.nextLine();

                        ind = trovaCitta(orari, citta, cont);
                        if (ind > -1) {
                            if (orari[ind].toLegale()) {
                                System.out.println("ora legale impostata con successo");
                            } else {
                                System.out.println("L'ora legale e' gia' impostata");
                            }
                        } else {
                            System.out.println("La citta cercata non e' presente nell'array");
                        }
                    } else {
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 7:
                    if (cont > 0) {
                        int k = 0;
                        int ultimo = -1;
                        ordina(orari, cont);
                        System.out.println("Inserisci la nazione");
                        nazione = scanner.nextLine();

                        for (int i = 0; i < cont; i++) {
                            if (orari[i].nazione.equals(nazione)) {
                                if (orari[i].ore != ultimo) {
                                    k++;
                                    ultimo = orari[i].ore;
                                }
                            }
                        }

                        if (k < 1) {
                            System.out.println("La nazione inserita non e' presente nell'array");
                        }else{
                            System.out.println("Numero di fusi orari= " + k);
                        }

                    } else {
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                case 8:
                    if(cont > 0){
                        int k = 0;

                        System.out.println("inserisci la nazione da cercare");
                        nazione = scanner.nextLine();

                        for(int i = 0; i < cont; i++){
                            if(orari[i].nazione.equals(nazione)){
                                k++;
                            }
                        }

                        if(k > 0){
                            System.out.println("Nazione= " + nazione + ", citta= " + k);
                        }else{
                            System.out.println("La nazione inserita non e' presente nell'array");
                        }
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }
                    break;
                default:
                    System.out.println("Scelta non prevista");
                    break;
            }
        } while (scelta != 0);
    }
}
