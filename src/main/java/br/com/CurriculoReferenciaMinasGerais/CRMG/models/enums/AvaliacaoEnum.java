package br.com.CurriculoReferenciaMinasGerais.CRMG.models.enums;

public enum AvaliacaoEnum {

    NAOCONCLUIDO(1, "Não Concluido"),
    PARCIAL(2, "Parcial"),
    CONCLUIDO(3, "Concluído");

    private Integer codigo;
    private String descricao;

    AvaliacaoEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public static AvaliacaoEnum toEnum(Integer codigo){
        if (codigo == null){
            return null;
        }

        for (AvaliacaoEnum x : AvaliacaoEnum.values()){
            if(codigo.equals(x.getCodigo())){
                return x;
            }
        }

        throw new IllegalArgumentException("Id Invalido" + codigo);
    }
}
