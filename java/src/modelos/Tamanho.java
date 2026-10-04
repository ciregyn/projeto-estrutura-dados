package modelos;

public enum Tamanho {
    ML_200(200),
    ML_300(300),
    ML_500(500);

    private final int volumeMl;

    Tamanho(int volumeMl) {
        this.volumeMl = volumeMl;
    }

    public int getVolumeMl() {
        return volumeMl;
    }

    @Override
    public String toString() {
        return volumeMl + "ml";
    }
}