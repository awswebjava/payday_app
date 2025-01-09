package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainconstantes_default
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"[apo_jub_ali]"), "Alícuota de Aporte Jubiliación");
      domain.put(new String((String)"[contr_OS_FSR_ali]"), "Alícuota de Contribución Patronal Obra Social/FSR (ex ANSSAL)");
      domain.put(new String((String)"[distr_OS_ali]"), "Porcentaje a contribuir de Obra social (el resto va a FSR (ex ANSSAL)");
      domain.put(new String((String)"[apo_INSSJyP_ali]"), "Alícuota de Aporte INSSJyP");
      domain.put(new String((String)"[apo_OS_ali]"), "Alícuota de Aporte Obra Social");
      domain.put(new String((String)"[apo_OS_adh_ali]"), "Alícuota Obra Social Adherente");
      domain.put(new String((String)"[base_imp_max]"), "Base imponible máxima");
      domain.put(new String((String)"[smvm]"), "Salario Mínimo Vital y Movil");
      domain.put(new String((String)"[horas_noct]"), "Alícuota Horas Nocturnas");
      domain.put(new String((String)"[limite_medicos]"), "Alícuota para límite anual en deducción de Honorarios médicos");
      domain.put(new String((String)"[limite_prepaga]"), "Alicuota para límite anual en deducción de Cuota médico asistencial");
      domain.put(new String((String)"[tope_sepelio]"), "Tope anual deducción ganancias para Gastos de sepelio");
      domain.put(new String((String)"[tope_seguros]"), "Tope anual deducción ganancias para Seguros");
      domain.put(new String((String)"[tope_hipoteca]"), "Tope anual deducción ganancias para intereses de créditos hipotecarios");
      domain.put(new String((String)"[ded_hijo]"), "Deducción [Art. 30] Hijo");
      domain.put(new String((String)"[ded_hijo_incap]"), "Deducción [Art. 30] Hijo incapacitado para el trabajo");
      domain.put(new String((String)"[ded_cony]"), "Deducción [Art. 30] Cónyuge / unión convivencial");
      domain.put(new String((String)"[ded_especial]"), "Deducción [Art. 30, inc c, A. 2] Especial");
      domain.put(new String((String)"[mni]"), "Deducción [Artículo 30, inciso a)] Mínimo no imponible");
      domain.put(new String((String)"[piso_ganancias_casados]"), "Piso de sueldo bruto para pagar Ganancias para casados con 2 hijos");
      domain.put(new String((String)"[piso_ganancias_solteros]"), "Piso de sueldo bruto para pagar Ganancias para solteros sin hijos");
      domain.put(new String((String)"[piso_ganancias_SAC]"), "Piso de sueldo bruto para gravar SAC en ganancias (Cálculo obsoleto desde 2024)");
      domain.put(new String((String)"[tope_bonos]"), "Tope para sueldo bruto promedio aplicable a exención de ganancias para Bonos de Productividad");
      domain.put(new String((String)"[alicuota_donaciones]"), "Alícuota para límite en deducción de Donaciones");
      domain.put(new String((String)"[fijo_ART]"), "Contribución Suma Fija ART");
      domain.put(new String((String)"[gan_escala]"), "Ganancias: Tasas y Tramos de Escala");
      domain.put(new String((String)"[ded_esp_inc_tabla]"), "Tabla de deduccion especial incrementadas fijas");
      domain.put(new String((String)"[base_imp_min]"), "Base imponible mínima");
      domain.put(new String((String)"[importe_a_detraer_default]"), "Importe a detraer");
      domain.put(new String((String)"[svc_Fijo]"), "Importe fijo por seguro de vida colectivo");
      domain.put(new String((String)"[ley_27541_ali]"), "Alìcuotas para contribuciones a la seguridad social según incisos de la ley 27541");
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

