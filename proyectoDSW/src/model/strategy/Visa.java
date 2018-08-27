package model.strategy;

import java.util.Date;

public class Visa extends AbstractPaymentProvider {

    private String numTarjeta;
    private String cvc;

    public Visa(String ruc, double monto, Date fecha, String numTarjeta, String cvc) {
        super(ruc, monto, fecha);
        this.numTarjeta = numTarjeta;
        this.cvc = cvc;
    }

    @Override
    public boolean executePayment() {
        System.out.println("Contactando con el procesador de pagos de VISA!");
        System.out.println("Pago exitoso!");
        return true;
    }
}
