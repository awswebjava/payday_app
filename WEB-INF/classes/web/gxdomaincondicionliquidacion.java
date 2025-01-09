package web ;
import web.*;
import com.genexus.*;

public final  class gxdomaincondicionliquidacion
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"A0"), "Siempre");
      domain.put(new String((String)"A1"), "Se ingresó por novedad el concepto de código relacionado a la condición");
      domain.put(new String((String)"A3"), "Trabajador no es Jubilado y aplica a liquidación de aportes");
      domain.put(new String((String)"A4"), "Resultado de la suma de conceptos agregados en liquidación anterior con la misma clasificación sea mayor a cerO, y que el concepto de la liquidación anterior tenga asignado tipo de liquidación igual al código relacionado a la condición de este concepto");
      domain.put(new String((String)"A5"), "Es alcanzado por ganancias y calcula adelanto de retención (parámetro)");
      domain.put(new String((String)"A8"), "Legajo tiene saldo distinto de cero en DDJJ F1357 del año anterior");
      domain.put(new String((String)"A9"), "Tiene familiares adherentes a la obra social");
      domain.put(new String((String)"A10"), "Tiene Sindicato");
      domain.put(new String((String)"A11"), "Tiene jornada parcial");
      domain.put(new String((String)"A12"), "Obra social tiene aporte adicional");
      domain.put(new String((String)"A13"), "Empleador es agente de retención");
      domain.put(new String((String)"A14"), "El empleador es agente de retención y el empleado es alcanzado por ganancias");
      domain.put(new String((String)"B1"), "Legajo tiene cargado licencia igual al código  relacionado a la condición");
      domain.put(new String((String)"B2"), "Legajo tiene cargado SIRADIG de igual código  relacionado a la condición");
      domain.put(new String((String)"B3"), "Tiene obligación activa de igual al código relacionado a la condición");
      domain.put(new String((String)"B4"), "Hay licencias o feriados con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal");
      domain.put(new String((String)"B5"), "Hay feriado no trabajado, y la empresa está configurada para exponer los feriados");
      domain.put(new String((String)"B6"), "Hay día no laborable em periodo, y la empresa está configurada para exponer los feriados");
      domain.put(new String((String)"B7"), "El legajo es empleado mensual y hay licencia sin goce de sueldo");
      domain.put(new String((String)"B9"), "Es egreso y no maneja fondo de cese laboral");
      domain.put(new String((String)"B10"), "Tipo de liquidación, mes de liquidación, y marca de SAC en alta de liquidación son compatibles con la liquidación del SAC.");
      domain.put(new String((String)"B11"), "Liquida sac o alcanza ganancias");
      domain.put(new String((String)"B12"), "Empresa o convenio liquidan antiguedad");
      domain.put(new String((String)"B13"), "Empresa o convenio liquidan presentismo");
      domain.put(new String((String)"B14"), "Legajo tiene cargado comprobante para reintegro igual al código relacionado a la condición");
      domain.put(new String((String)"B15"), "Legajo tiene cargado hijo o hija con asignación de servicio de guardería");
      domain.put(new String((String)"N01"), "Nunca  (Calcular siempre en segundo plano luego de generar el recibo)");
      domain.put(new String((String)"B16"), "Legajo tiene tipo de tarifa \"por periodo\", de frecuencia mensual y el concepto no fué previamente liquidado en el mismo periodo");
      domain.put(new String((String)"B19"), "Legajo es empleado mensual, tiene cargado vacaciones y la empresa está configurada para no prorratear el sueldo");
      domain.put(new String((String)"B20"), "Legajo es empleado mensual, tiene cargado días de licencia (distinta a vacaciones) y la empresa está configurada para no prorratear el sueldo");
      domain.put(new String((String)"B21"), "Legajo es empleado mensual, hay feriado no trabajado y la empresa está configurada para exponer los feriados y no proratear el sueldo");
      domain.put(new String((String)"B22"), "Legajo es empleado mensual, hay día no laborable no trabajado y la empresa está configurada para exponer los feriados y no prorratear el sueldo");
      domain.put(new String((String)"B23"), "Legajo tiene asignado tìtulo igual al código relacionado a la condición");
      domain.put(new String((String)"B24"), "Parametro para desglosar adicional está activado, legajo está en convenio y su categoría tiene adicional por zona desfavorable");
      domain.put(new String((String)"VP"), "Hay vacaciones con plus y la empresa está configurada para prorratear sueldos o el legajo es de clase jornal");
      domain.put(new String((String)"AI"), "Legajo es de clase mensual y tiene cargadas ausencias injustificadas");
      domain.put(new String((String)"R1"), "Forma de pago es distinta a transferencia o parámetro está configurado para liquidar siempre redondeo");
      domain.put(new String((String)"MI"), "Legajo tiene tipo de tarifa \"por periodo\" de frecuencia mensual, empresa está configurada para no prorratear sueldo y fecha de ingreso es mayor al primero o fecha de egreso menor al último día del mes");
      domain.put(new String((String)"H1"), "Si liquidación es compatible con SAC liquidar como concepto principal, y si no liquidarlo como concepto auxiliar en segundo plano");
      domain.put(new String((String)"LA"), "Legajo aplica a liquidación de aportes");
      domain.put(new String((String)"GU"), "Legajo tiene configurado grossing up");
   }

   public static String getDescription( com.genexus.internet.HttpContext httpContext ,
                                        String key )
   {
      if (domain.containsKey( key.trim() ))
      {
         return httpContext != null ? httpContext.getMessage((String)domain.get( key.trim() )) : (String)domain.get( key.trim() );
      }
      else
      {
         return "";
      }
   }

   public static GXSimpleCollection<String> getValues( )
   {
      GXSimpleCollection<String> value = new GXSimpleCollection<String>(String.class, "internal", "");
      java.util.Iterator itr = domain.keySet().iterator();
      while(itr.hasNext())
      {
         value.add((String) itr.next());
      }
      return value;
   }

}

