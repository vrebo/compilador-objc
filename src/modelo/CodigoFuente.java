/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.File;

/**
 *
 * @author Victor Daniel Rebolloso Degante
 */
public class CodigoFuente {

    private final File archivo;
    private boolean modificado;

    public CodigoFuente(File archivo) {
        this.archivo = archivo;
    }

    public boolean isModificado() {
        return modificado;
    }

    public void setModificado(boolean modificado) {
        this.modificado = modificado;
    }

    public File getArchivo() {
        return archivo;
    }

}
