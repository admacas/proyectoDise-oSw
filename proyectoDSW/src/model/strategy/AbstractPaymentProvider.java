package model.strategy;

import java.util.Date;

public abstract class AbstractPaymentProvider implements PaymentProvider {

    protected String ruc;
    protected double monto;
    protected Date fecha;

    protected AbstractPaymentProvider(String ruc, double monto, Date fecha) {
        this.ruc = ruc;
        this.monto = monto;
        this.fecha = fecha;
    }

    public abstract boolean executePayment();
}
