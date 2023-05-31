public class EAN13 {
    
    private String codice;

    /**
     * file che effettua le verifiche del codice EAN
     * 
     * @author Domenico Lorubbio
     * @version 1.8
     * @since 31/05/2023
     * /
     
     /* @param c serve per settare il codice EAN
     */
   
    public void setCodice(String c){
        codice = c;
    }
    
    /**
     * 
     * @return il codice EAN
     */

    public String getCodice(){
        return codice;
    }

    /**
     * 
     * @return false perchè verifica la lunghezza del codice EAN
     */

    public boolean verificaCodice(){

        // Verifica se l'attributo del codice è vuoto o nullo
        if (codice.equals(null) || codice == ""){
            throw new NullPointerException("Il codice EAN-13 risulta vuoto o nullo");
        }

        // Verifica se la lunghezza dell'attributo codice rispetta la lunghezza di 13
        if(codice.length() != 13) {
            return false;
        }
        
        // Calcolo della cifra di controllo
        int somma = 0;
        int cifra;
        
        for(int i = 0; i < codice.length() - 1; i++) {   
            cifra = Character.getNumericValue(codice.charAt(i));
            
            if(i % 2 == 0) {
                somma += cifra * 1;  
            } else {
                somma += cifra * 3; 
            }
        }
        
        // Calcola la cifra di controllo
        int cifraDiControllo = (10 - (somma % 10));

        // Confronta la cifra di controllo con quella del codice EAN13
        return cifraDiControllo == Character.getNumericValue(codice.charAt(12)); 
    }


}
