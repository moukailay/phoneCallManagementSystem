package org.appareil;

import org.appareil.phoneApp.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws ParseException {

        IAppareil appareilEnregistreur = new AppareilEnregistreur();
        appareilEnregistreur.enregistrerContact( new Contact(1, "contact1", "514-123-1721") );
        appareilEnregistreur.enregistrerContact( new Contact(2, "contact2", "514-657-9809") );
        appareilEnregistreur.enregistrerContact( new Contact(3, "contact3", "514-212-1221") );
        appareilEnregistreur.enregistrerContact( new Contact(4, "contact4", "514-236-4555") );
        appareilEnregistreur.enregistrerContact( new Contact(5, "contact5", "514-092-1002") );

        appareilEnregistreur.enregistrerAppel( new AppelEmis(1, new Date(), 124 ), "514-123-1721" );
        appareilEnregistreur.enregistrerAppel( new AppelEmis(2, new Date(), 166 ), "514-657-9809" );
        appareilEnregistreur.enregistrerAppel( new AppelRecu(3, new Date(), 122 ), "514-212-1221" );
        appareilEnregistreur.enregistrerAppel( new AppelRecu(4, new Date(), 196 ), "514-092-1002" );

        System.out.println("---------------------------------------");
        System.out.println("Consulter un contact sachant son numero");
        System.out.println("---------------------------------------");

        try {
            Contact unContact = appareilEnregistreur.consulterContact( 1 );
            System.out.println("Num = " + unContact.getNumero());
            System.out.println("Nom : " + unContact.getNom());
            System.out.println("Tel : " + unContact.getNumeroTel());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("---------------------------------------");
        System.out.println("Consulter un contact sachant par mot clé");
        System.out.println("---------------------------------------");

        List<Contact> contactList = appareilEnregistreur.consulterListContactParMotCle( "c" );
        for ( Contact c : contactList) {
            System.out.println("Nom: " + c.getNom());
            System.out.println("Tel: " + c.getNumeroTel());
            System.out.println("      *");
        }

        System.out.println("---------------------------------------");
        System.out.println("Consulter le cout total des appels");
        System.out.println("---------------------------------------");

        double totalCout = appareilEnregistreur.coutTotalDesAppels();
        System.out.println("Cout total: " + totalCout);

        System.out.println("---------------------------------------");
        System.out.println("Consulter le cout total des appels");
        System.out.println("---------------------------------------");

        double couDunAppel = appareilEnregistreur.coutAppels( 2 );
        System.out.println("Cout: " + couDunAppel);

        System.out.println("---------------------------------------");
        System.out.println("Consulter le cout entre deux dates");
        System.out.println("---------------------------------------");

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date1 = simpleDateFormat.parse( "11/10/2022" );
        Date date2 = simpleDateFormat.parse( "14/10/2022" );

        System.out.println(appareilEnregistreur.coutDesAppels( date1, date2 ));




    }
}
