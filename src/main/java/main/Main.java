package main;

import ohtu.ohtuvarasto.Varasto;

public class Main {
    
    static final double SADAN_VARASTO =100.0;
    static final double OLUT_SALDO =    20.2;
   
    public static void main(String[] args) {

        Varasto mehua = new Varasto(SADAN_VARASTO);
        Varasto olutta = new Varasto(SADAN_VARASTO, OLUT_SALDO);

        System.out.println("Luonnin jälkeen:");
        System.out.println("Mehuvarasto: " + mehua);
        System.out.println("Olutgetterit:");
        System.out.println("getSaldo()     = " + olutta.getSaldo());
        System.out.println("paljonkoMahtuu = " + olutta.paljonkoMahtuu());        
    }
}
