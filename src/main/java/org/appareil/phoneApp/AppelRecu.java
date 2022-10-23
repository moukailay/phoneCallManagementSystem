package org.appareil.phoneApp;

import java.util.Date;

public class AppelRecu extends Appel {

    public AppelRecu ( int numero , Date dateAppel , double dureeAppel ) {
        super( numero , dateAppel , dureeAppel );
    }

    public AppelRecu ( ) {
        super();
    }

    public double cout ( ) {
        return 0;
    }
}
