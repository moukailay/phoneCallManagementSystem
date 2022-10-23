package org.appareil.phoneApp;

import java.util.Date;

public class AppelEmis extends Appel {

    public AppelEmis ( int numero , Date dateAppel , double dureeAppel ) {
        super( numero , dateAppel , dureeAppel );
    }

    public AppelEmis ( ) {
        super();
    }

    public double cout ( ) {
        return dureeAppel * 2;
    }
}
