package es.taw.tawebayspringbootgrupo21.dao.analista;

public interface CustomRepository {
    public String CheckQuery(String strq);

    public java.util.List QueryOnDemand(String strq);
}
