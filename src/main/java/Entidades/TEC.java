/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Sebastián
 */
public class TEC {
    public int idUsuario;
    public boolean convenioVigente;
    public int compraMes;
    public int idEmpresaConvenio;

    public TEC(int idUsuario, boolean convenioVigente, int compraMes, int idEmpresaConvenio) {
        this.idUsuario = idUsuario;
        this.convenioVigente = convenioVigente;
        this.compraMes = compraMes;
        this.idEmpresaConvenio = idEmpresaConvenio;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isConvenioVigente() {
        return convenioVigente;
    }

    public void setConvenioVigente(boolean convenioVigente) {
        this.convenioVigente = convenioVigente;
    }

    public int getCompraMes() {
        return compraMes;
    }

    public void setCompraMes(int compraMes) {
        this.compraMes = compraMes;
    }

    public int getIdEmpresaConvenio() {
        return idEmpresaConvenio;
    }

    public void setIdEmpresaConvenio(int idEmpresaConvenio) {
        this.idEmpresaConvenio = idEmpresaConvenio;
    }
}
