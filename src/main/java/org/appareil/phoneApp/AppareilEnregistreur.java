package org.appareil.phoneApp;

import java.util.*;
import java.util.stream.Collectors;

public class AppareilEnregistreur implements IAppareil {

    private List<Contact> contacts = new ArrayList<>();
    private Map<Integer, Appel> appels = new HashMap<>();


    public void enregistrerContact ( Contact contact ) {
        contacts.add( contact );
    }

    public void enregistrerAppel ( Appel appel , String numTel ) {
        Contact contact1 = null;
        for(Contact unContact: contacts)
            if ( unContact.getNumeroTel().equals( numTel ) ) {
                contact1 = unContact;
                break;
            }
        appel.setContact( contact1 );
        appels.put( appel.getNumero(),  appel);
    }

    public Contact consulterContact ( int numContact ) throws Exception {
        for ( Contact c : contacts ) {
            if ( c.getNumero() == numContact )
                return c;
        }
        throw new Exception("Contact " + numContact + " introuvable");
    }

    public List<Contact> consulterListContactParMotCle ( String motCle ) {
        List<Contact> contactList = new ArrayList<>();
        for ( Contact c : contacts ) {
            if ( c.getNom().contains( motCle ) ) { //c.getNom().indexOf( motCle ) >= 0
                contactList.add( c );
            }
        }
        return contactList;

       /* return contacts.stream()
                .filter( c -> c.getNom().contains( motCle ) )
                .collect( Collectors.toList());*/
    }

    @Override
    public double coutTotalDesAppels ( ) {
        double coutTotal = 0.0;
        for ( Appel appel : appels.values() ) {
            coutTotal += appel.cout();
        }
        return coutTotal;
    }

    @Override
    public double coutDesAppels ( Date dateD1 , Date dateD2 ) {
        double coutTotal = 0.0;

        /**for ( Appel appel : appels.values() ) {
            if ( appel.dateAppel.after( dateD1 ) && appel.dateAppel.before( dateD2  ) )
                coutTotal += appel.cout();
        }*/

        for ( Appel appel : appels.values() ) {
            if ((  appel.dateAppel.getTime() >= dateD1.getTime())
                    && ((appel.dateAppel.getTime() <= dateD2.getTime() ))) {
                coutTotal += appel.cout();
            }
        }
        return coutTotal;
    }



    @Override
    public double coutAppels ( int numero ) {
        double coutTotal = 0.0;
        for ( Appel appel : appels.values() ) {
            if (  appel.getContact().getNumero() == numero) {
                coutTotal += appel.cout();
            }
        }
        return coutTotal;
    }

}
