public class Orario{
    /**
     * Ogni orario sarà descritto dalla classe Orario che ha cinque caratteristiche: il nome della città,
     *  l’orario (formato da 3 attributi ore,minuti,secondi) e infine un attributo solare di tipo boolean
     *  che indica se l’ora attuale è solare (vero) o legale (falso). Nella classe Orario gestire le seguenti
     *  azioni: visualizzare l’orario (ore, minuti, secondi), impostare l’ora legale (se l’ora attuale è 
     * solare avanzare l’orario di un’ora), impostare l’ora solare (se l’ora attuale è legale arretrare 
     * l’orario di un’ora). Inoltre nella classe Orario occorre prevedere un costruttore che imposti il nome 
     * e l’orario attuale della città ricevuti come parametri, mentre il valore di solare viene inizializzato 
     * a true.
     */


    String citta;
    int ore, minuti, secondi;
    boolean solare;

    public Orario (String citta, int ore, int minuti, int secondi){
        this.citta = citta;
        this.ore = ore;
        this.minuti = minuti;
        this.secondi = secondi;
        this.solare =  true;
    }

    boolean toSolare (){
        if(!this.solare){
            this.ore -= 1;
            return true;
        }

        return false;
    }

    boolean toLegale(){
        if(this.solare){
            this.ore += 1;
            return true;
        }

        return false;
    }

    void visualizza (){
        System.out.println("Citta= " + this.citta);
        System.out.println("Orario= " + this.ore + ":" + this.minuti + ":" + this.secondi);
        System.out.println("Solare= " + this.solare);
    }


}
