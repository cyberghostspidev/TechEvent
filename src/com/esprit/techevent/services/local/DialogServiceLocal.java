/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.techevent.services.local;

import com.esprit.techevent.entities.Dialog;

/**
 *
 * @author Yacine Ben Ouirane
 */
public interface DialogServiceLocal {

    //Default Service
    public void ajouterDialog(Dialog dialog);

    public void supprimerDialog(Dialog dialog);

    public void modifierDialog(Dialog dialog);

    public Dialog chercherDialog(int idDialog);

    public int compterDialog();

    //Added Service
}
