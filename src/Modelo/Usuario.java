package Modelo;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Usuario {
    private String nomeUsuario;
    private String senhaUsuario;
    private String tipoUsuario;
    private Date dataCriacao = new Date();
    private Endereco endereco;
    SimpleDateFormat formatarData = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    public Usuario(){

    }

   public Usuario(String nomeUsuario, String senhaUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
    }

    public Usuario(String nomeUsuario, String senhaUsuario, String tipoUsuario) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.tipoUsuario = tipoUsuario;
    }

    public Usuario(String nomeUsuario, String senhaUsuario, String tipoUsuario, Endereco endereco) {
        this.nomeUsuario = nomeUsuario;
        this.senhaUsuario = senhaUsuario;
        this.tipoUsuario = tipoUsuario;
        this.endereco = endereco;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaUsuario() {
        return senhaUsuario;
    }

    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }

    public String getTipoUsuario() { return tipoUsuario; }

    public void setTipoUsuario(String tipoUsuario) {this.tipoUsuario = tipoUsuario;}

    public String exibirDadosUsuario() {
        String dataFormatada = formatarData.format(dataCriacao);
        if (endereco != null) {
            return nomeUsuario + "," + senhaUsuario + "," + tipoUsuario + "," +
                    endereco.exibirDadosEndereco() + "," + dataFormatada;
        } else {
            return nomeUsuario + "," + senhaUsuario + "," + tipoUsuario + ",endereço não registrado," + dataFormatada;
        }
    }

}
