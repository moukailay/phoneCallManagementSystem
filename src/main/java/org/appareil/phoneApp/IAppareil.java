package org.appareil.phoneApp;

import java.util.Date;
import java.util.List;

public interface IAppareil {
    void enregistrerContact(Contact contact);
    void enregistrerAppel ( Appel appel, String numTel);
    Contact consulterContact(int numContact) throws Exception;
    List<Contact> consulterListContactParMotCle(String motCle);
    double coutTotalDesAppels();
    double coutDesAppels( Date dateD1, Date dateD2);
    double coutAppels(int numero);

}
