import java.util.Scanner;

public class App{


    /**
     * Data la classe Orario, svolgere la classe TestOrario che gestisce un array di 100 oggetti
     *  della classe Orario. Gestire un menù con le seguenti voci: 
     * - premi 0 per uscire 
     * - premi 1 per inserire un orario prendendo in input la città e l'orario (ore,muniti,secondi) 
     * - premi 2 per visualizzare tutti gli oggetti della classe Orario 
     * - premi 3 per visualizzare l'orario di tutte le città 
     * - premi 4 per visualizzare l'orario (e il valore dell'attributo solare) 
     * di una città il cui nome viene preso in input
     * 

     */

    public static void main(String[] args) throws Exception{
        int scelta;
        Orario[] orari = new Orario[1000];
        int cont = 0, ore, minuti, secondi;
        String citta;
        Scanner scanner = new Scanner(System.in);

        do{
            System.out.println("0. esci");
            System.out.println("1. Inserisci orario");
            System.out.println("2. visualizzare orari");
            System.out.println("3. visualizzare orari (no asttributo solare)");
            System.out.println("4. orario di una citta' in input");

            scelta = scanner.nextInt();
            scanner.nextLine();

            switch(scelta){
                case 0:
                    break;
                case 1:
                    if(cont < 1000){
                        System.out.println("Inserisci nome citta");
                        citta = scanner.nextLine();
                        System.out.println("Inserisci ore");
                        ore = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci minuti");
                        minuti = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Inserisci secondi");
                        secondi = scanner.nextInt();
                        scanner.nextLine();

                        orari[cont] = new Orario(citta, ore, minuti, secondi);
                        cont++;
                    }else{
                        System.out.println("L'array e' pieno");
                    }
                    break;
                case 2:
                    if(cont > 0){
                        for(int i = 0; i < cont; i++){
                            orari[i].visualizza();
                        }
                    }else{
                        System.out.println("Non ci sono elementi nell'array");
                    }                    
                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:
                System.out.println("Scelta non prevista");
                    break;
            }
        }while(scelta != 0);
    }
}