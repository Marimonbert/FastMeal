package garcon;

public class ChamarGarcon {

    private String mesa;
    private String nomeCliente;
    private long posicao;
    private String uid;

    public ChamarGarcon() {
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public long getPosicao() {
        return posicao;
    }

    public void setPosicao(long posicao) {
        this.posicao = posicao;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    @Override
    public String toString() {
        return "mesa: '" + mesa + nomeCliente;
    }
}
