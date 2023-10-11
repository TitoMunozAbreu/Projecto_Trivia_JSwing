package org.netbeans.validation.api.builtin.stringvalidation;

import org.netbeans.validation.api.Problems;
import org.openide.util.NbBundle;

public class NombreValidacion extends StringValidator{


    @Override
    public void validate(Problems problems, String nombre, String model) {
        String regExNombre = "^[A-Z][a-z]+$";
        if(model.isEmpty() || !model.matches(regExNombre)){
            String msj = NbBundle.getMessage(NombreValidacion.class,"MSG_NOMBRE_FIRST_LETTER_UPPER_CASE",nombre);
            problems.add(msj);
        }
    }
}
