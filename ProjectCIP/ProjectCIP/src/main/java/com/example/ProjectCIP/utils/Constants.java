package com.example.ProjectCIP.utils;

import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.beans.FeatureDescriptor;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Constants {
    public static final String DATABASE_DATE_FORMAT = "yyyy/MM/dd";
    public static final String SERVICE_RESPONSE_NAME = "serviceResponse";
    public static final String DATE_FORMAT = "dd/MM/yyyy";
    public static final String DB_DATE_FORMAT = "%d/%m/%Y";
    public static final String TIME_FORMAT = "HH:mm:ss";
    public static final String DATE_TIME_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String S2_TEXT_SEPARATOR = "-";
    public static final String APPLICATION_VND_MS_EXCEL = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
    public static final String APPLICATION_VND_WORD_DOCUMENT = "application/vnd.openxmlformats-officedocument.wordprocessingml.document";
    public static final String APPLICATION_PDF = "application/pdf";
    public static final String EXTENSION_XLS = "xls";
    public static final String EXTENSION_PDF = "pdf";
    public static final String EXTENSION_DOCX = "docx";
    public static final String MSG_NOT_FOUND = "msjNotFound";

    public static final String MSG_REGISTRO_INVALIDADO = "El registro ya no se encuentra vigente.";
    public static final String MSG_REGISTRO_YA_EXISTE = "El registro ya existe en la base de datos.";

    public static final String MSG_REGISTRO_NO_EDITABLE = "No es posible editar un registro que ya no se encuentra vigente.";

    public static final String MSG_REGISTRO_POSEE_HIJOS = "Este registro tiene dependencias, no puede ser eliminado";
    public static final String FECHA_FIN_VIGENCIA = "fechaFinVigencia";
    public static final String FECHA_FINAL_VIGENCIA = "fechaFinalVigencia";
    public static final String FECHA_FIN_VALIDEZ = "fechaFinValidez";
    public static final String ESTA_VIGENTE = "estaVigente";
    public static final Boolean IS_FILTER_CRITERIA_CASE_SENSITIVE = Boolean.FALSE;
    public static final String ESTA_VIGENTE_REQ = "El campo 'Esta vigente' es requerido";
    public static final String PAIS_CODIGO_ISO_ALFA2 = "SV";

    public static final String CAMPOS_OBLIGATORIOS_INSCRIBIR_EXPORTADOR = "Por favor especifique todos los campos marcados con *";

    public static final String S = "S";

    public static final String MSG_REGISTRO_YA_EXISTE_EXPORTADOR = "El Exportador que esta intentando registrar ya existe.";

    public static final String MSG_ELIMINAR_ACTIVIDAD_PRINCIPAL = "La Actividad es Principal, no se puede eliminar modifique la información para eliminarla";

    private Constants() {
        throw new IllegalStateException("Constants class must not be instantiated!");
    }

    public static String[] getNullPropertyNames(Object source) {
        final BeanWrapper wrappedSource = new BeanWrapperImpl(source);
        return Stream.of(wrappedSource.getPropertyDescriptors()).map(FeatureDescriptor::getName)
                .filter(propertyName -> wrappedSource.getPropertyValue(propertyName) == null).toArray(String[]::new);
    }

    public static String convertBindingResultErrorsToString(BindingResult bindingResult){
        List<String> errors = new ArrayList<>();
        for(FieldError error: bindingResult.getFieldErrors()){
            errors.add(error.getDefaultMessage());
        }
        return String.join("@", errors);
    }
}
