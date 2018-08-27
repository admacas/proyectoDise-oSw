package model.strategy;

import java.util.Date;

public class Efectivo extends AbstractPaymentProvider {

    public Efectivo(String ruc, double monto, Date fecha) {
        super(ruc, monto, fecha);
    }

    @Override
    public boolean executePayment() {
        return true;
    }
}
