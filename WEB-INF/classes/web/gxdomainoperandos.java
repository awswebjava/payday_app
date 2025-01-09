package web ;
import web.*;
import com.genexus.*;

public final  class gxdomainoperandos
{
   private static java.util.TreeMap domain = new java.util.TreeMap();
   static
   {
      domain.put(new String((String)"[antiguedad]"), "Antiguedad en años");
      domain.put(new String((String)"[antiguedad_indemnizacion]"), "Antig. fracción 3 meses = 1 año");
      domain.put(new String((String)"{concepto}"), "Concepto");
      domain.put(new String((String)"{conceptos}"), "Conceptos");
      domain.put(new String((String)"[dias_mes]"), "Cantidad de dias del mes. Si el parámetro \"Todos los meses tienen 30 dias\" está en \"Si\", devuelve el valor 30, si no devuelve la cantidad de días del mes reales.");
      domain.put(new String((String)"[dias_semestre]"), "Cantidad de dias del semestre. Tiene en cuenta el parámetro \"Todos los meses tienen 30 días\" para calcular la cantidad de días del semestre.");
      domain.put(new String((String)"[dias_trabajados_mes]"), "Cantidad de dias trabajados de forma normal en el mes. Es la cantidad de días del mes menos los días de licencia y los días feriados trabajados (que se liquidan aparte), contemplando fecha de ingreso y egreso.");
      domain.put(new String((String)"[dias_remunerados_semestre]"), "Cantidad de dias remunerados en el semestre. Es la cantidad de días del semestre menos las ausencias injustificadas, contemplando fecha de ingreso y egreso.");
      domain.put(new String((String)"[plan_medico]"), "Plan Médico");
      domain.put(new String((String)"[remu_var]"), "Remuneraciones Variables");
      domain.put(new String((String)"[basico_mensual]"), "Sueldo Básico Mensual");
      domain.put(new String((String)"[contr_OS_ali]"), "Alícuota para contribución patronal destinada a obra social");
      domain.put(new String((String)"[contr_FSR_ali]"), "Alìcuota para contribuciòn patronal destinada a FSR (ex ANSSAL)");
      domain.put(new String((String)"[apo_Dif]"), "Total No Remunerativos que tributan a  aporte de Régimenes Diferenciales");
      domain.put(new String((String)"[tipoLiq]"), "Tipo de Liquidación");
      domain.put(new String((String)"[mes_Periodo]"), "Mes Periodo");
      domain.put(new String((String)"[novedad_cantidad]"), "Cantidad de horas (jornalizados) o días (mensualizados) informadas en agenda de novedades");
      domain.put(new String((String)"[novedad_importe]"), "Importe informado en agenda de novedades");
      domain.put(new String((String)"[ART_ali]"), "Alícuota de Contribución Patronal ART según Empresa");
      domain.put(new String((String)"[gan_cuotas]"), "Ganancias - Cantidad de cuotas faltantes");
      domain.put(new String((String)"[con_discapacidad]"), "Legajo con Discapacidad");
      domain.put(new String((String)"[sexo]"), "Legajo Sexo");
      domain.put(new String((String)"[motivo_egreso]"), "Legajo Motivo de Egreso");
      domain.put(new String((String)"[area]"), "Legajo Area");
      domain.put(new String((String)"[categoria]"), "Legajo Categoria");
      domain.put(new String((String)"[convenio]"), "Legajo Convenio");
      domain.put(new String((String)"[clase]"), "Legajo Clase");
      domain.put(new String((String)"[sindicato]"), "Legajo Sindicato");
      domain.put(new String((String)"[obraSocial]"), "Obra Social_");
      domain.put(new String((String)"[edad]"), "Edad");
      domain.put(new String((String)"[monto_siradig]"), "Importes de items ingresados en SIRADIG al 100% para el concepto. En el caso de deducciones generales anuales el importe se aplicará en el mes de diciembre o en liquidación final.");
      domain.put(new String((String)"[hora_basica]"), "Valor hora básico");
      domain.put(new String((String)"[horas_extras_exentas]"), "Horas extras exentas.");
      domain.put(new String((String)"[exentas]"), "Ganancias - remuneraciones totalmente exentas.");
      domain.put(new String((String)"[descuentos_ley_ganancias]"), "Ganancias - Descuentos de ley sobre remuneración bruta");
      domain.put(new String((String)"[deduce_conyuge]"), "Ganancias - Deduce conyuge");
      domain.put(new String((String)"[cant_hijos]"), "Cantidad de hijos menores a 18 años, no incapacitados para el trabajo");
      domain.put(new String((String)"[cant_hijos_incap]"), "Cantidad de hijos incapacitados para el trabajo");
      domain.put(new String((String)"[prc_ded_hijos]"), "Ganancias - Porcentaje deducción hijos no incapacitados para el trabajo");
      domain.put(new String((String)"[prc_ded_hijos_incap]"), "Ganancias - Porcentaje deducción hijos incapacitados para el trabajo");
      domain.put(new String((String)"[ded_esp_inc]"), "Deduccion especial incrementada");
      domain.put(new String((String)"[descuentos_anticipo_sac]"), "Descuentos de ley sobre anticipo de SAC");
      domain.put(new String((String)"[pagos_a_cuenta_anteriores]"), "Pagos a cuenta actualizados. Se recorren las liquidaciones de periodos anteriores para tomar los valores actualizados de pagos a cuenta considerando la carga al día de SIRADIG");
      domain.put(new String((String)"[alicuota_ley]"), "Alicuota total descuentos de ley según legajo");
      domain.put(new String((String)"[sueldo_bruto_promedio]"), "Sueldo Bruto Promedio Anual. Este valor es recalculado de forma retroactiva para siempre reflejar el promedio más actualizado");
      domain.put(new String((String)"[nro_cuota]"), "Número de cuota para ganancias. En liquidaciones de egreso en donde el empleado no continua relación con otro empleador el valor equivale a la cantidad de cuotas totales del año.");
      domain.put(new String((String)"[agente_retencion]"), "Empresa es agente de retención para el empleado");
      domain.put(new String((String)"[mni_zona]"), "Deducción [Artículo 30, inciso a)] Mínimo no imponible. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.");
      domain.put(new String((String)"[ded_hijo_zona]"), "Deducción [Art. 30] Hijo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.");
      domain.put(new String((String)"[ded_hijo_incap_zona]"), "Deducción [Art. 30] Hijo incapacitado para el trabajo. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.");
      domain.put(new String((String)"[ded_cony_zona]"), "Deducción [Art. 30] Cónyuge / unión convivencial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.");
      domain.put(new String((String)"[ded_especial_zona]"), "Deducción [Art. 30, inc c, A. 2] Especial. Cálculo que toma la variable de la deducción, y aplica porcentaje de aumento según zona.");
      domain.put(new String((String)"[cant_cuotas]"), "Cantidad de cuotas a retener ganancias");
      domain.put(new String((String)"[f1357_saldo]"), "Saldo de F1357 del año anterior. Aplica en el mes de abril.");
      domain.put(new String((String)"[descuentos_retencion]"), "Descuentos de Ley más descuentos sobre anticipo de SAC");
      domain.put(new String((String)"[os_cantidad_adherentes]"), "Cantidad de adherentes adicionales a la obra social");
      domain.put(new String((String)"[horas_mes]"), "Horas del mes según categoría, o en su defecto el valor de la variable de horas mes default");
      domain.put(new String((String)"[os_apo_adic]"), "Aporte adicional obra social");
      domain.put(new String((String)"[horas_jornal]"), "Horas por día que trabaja el empleado");
      domain.put(new String((String)"[dias_vacaciones]"), "Cantidad de días de vacaciones del periodo");
      domain.put(new String((String)"[remuneracion_licencia]"), "Càlculo de remuneraciòn por la licencia paga");
      domain.put(new String((String)"[viaticos]"), "Total de viáticos. Incluye importes de otros empleos informado en siradig para el periodo");
      domain.put(new String((String)"[materiales_didacticos]"), "Total de materiales didácticos de personal docente. Incluye importes de otros empleos informados en siradig para el periodo");
      domain.put(new String((String)"[descuentos_sobre_gravados]"), "Descuentos de ley sobre impuesto gravado");
      domain.put(new String((String)"[remuneracion_vacaciones_no_gozadas]"), "Mismo cálculo que se realiza para vacaciones, pero la cantidad de días es la que corresponde por ley según años de antiguedad, siempre y cuando el empleado no se haya tomado ya las vacaciones.");
      domain.put(new String((String)"[tope_indemnizatorio]"), "Tope Indemnizatorio del convenio");
      domain.put(new String((String)"[alicuota_sindical]"), "Alícuota de cuota sindical");
      domain.put(new String((String)"[adelanto_retencion]"), "Adelanto de retencion de ganancias");
      domain.put(new String((String)"[adicional_convenio]"), "Adicional por convenio");
      domain.put(new String((String)"[horas_jornada_completa]"), "Cantidad de horas de la jornada completa");
      domain.put(new String((String)"[valor_categoria]"), "Sueldo Categoria");
      domain.put(new String((String)"{feriado_trabajado_horas}"), "Horas feriado trabajado");
      domain.put(new String((String)"[feriados_no_trabajados]"), "Feriados no trabajados");
      domain.put(new String((String)"[base_imponible_5]"), "Base imponible 5 -Aportes INSSJYP");
      domain.put(new String((String)"[base_imponible_2]"), "Base imponible 2 - CONTRIBUCIONES SIPA E INSSJYP");
      domain.put(new String((String)"[base_imponible_3]"), "base Imponible 3 - ONTRIBUCIONES FNE, AAFF, Y RENATRE");
      domain.put(new String((String)"[base_imponible_4]"), "Base imponible 4 - APORTES OS Y FSR");
      domain.put(new String((String)"[base_dif_apo_OS_FSR]"), "base Diferencial - Aportes OS y FSR");
      domain.put(new String((String)"[base_dif_con_OS_FSR]"), "Base diferencial - Contribuciones OS y FSR");
      domain.put(new String((String)"[base_imponible_8]"), "base Imponible 8  -  CONTRIBUCIONES OS Y FSR");
      domain.put(new String((String)"[base_imponible_9]"), "base Imponible 9 - CONTRIBUCIONES LRT");
      domain.put(new String((String)"[importe_a_detraer]"), "Importe a detraer");
      domain.put(new String((String)"[base_imponible_6]"), "Base imponible 6 - APORTES DIFERENCIALES");
      domain.put(new String((String)"[base_imponible_7]"), "base Imponible 7 - APORTES ESPECIALES");
      domain.put(new String((String)"[remuneracion_adelanto_vacaciones]"), "Remuneracion adelanto de vacaciones");
      domain.put(new String((String)"[sueldo_bruto]"), "Sueldo Bruto");
      domain.put(new String((String)"[descuento_adelanto]"), "Descuento por adelanto");
      domain.put(new String((String)"[dias_proporcionar_tope]"), "Días para proporcionar tope para cálculo de máximo imponible de sueldo");
      domain.put(new String((String)"[base_imponible_1_sueldo]"), "Tope para base imponible 1 sueldo");
      domain.put(new String((String)"[base_imponible_sac]"), "Tope para base imponible para SAC");
      domain.put(new String((String)"[base_imponible_adelantoVac]"), "Tope para base imponible para adelanto de vacaciones de mes próximo");
      domain.put(new String((String)"[base_imponible_1]"), "Base imponible 1 - Aportes SIPA");
      domain.put(new String((String)"[sueldo_basico]"), "Sueldo básico");
      domain.put(new String((String)"[calculo_sac]"), "Cálculo SAC");
      domain.put(new String((String)"[haberes_sac]"), "Haberes Sac");
      domain.put(new String((String)"[anticipo_sac]"), "Anticipo de SAC");
      domain.put(new String((String)"[sac_estimado]"), "Estimación de próximo SAC");
      domain.put(new String((String)"[total_exentos_sin_sac]"), "Total Exentos Sin Sac");
      domain.put(new String((String)"[cuotas_prorrateo]"), "Cuotas prorrateos");
      domain.put(new String((String)"[prorrateables]"), "Prorrateables");
      domain.put(new String((String)"[exento_concepto]"), "Cálculo exento");
      domain.put(new String((String)"[deduccion]"), "Calculo Deduccion");
      domain.put(new String((String)"[retencion_ganancias]"), "Retención ganancias");
      domain.put(new String((String)"[empresa_antiguedad]"), "Importe o alícuota para antiguedad por empresa (fuera de convenio)");
      domain.put(new String((String)"[empresa_presentismo]"), "Importe o alícuota para presentismo por empresa (fuera de convenio)");
      domain.put(new String((String)"[asistencia_perfecta]"), "Flag de asistencia perfecta. Si se registran faltas injustificadas o llegadas tarde es 0, caso contrario es 1");
      domain.put(new String((String)"[es_primera_quincena]"), "Es primera quincena");
      domain.put(new String((String)"[ART_fijo]"), "Importe fijo de ART");
      domain.put(new String((String)"[contr_jub_ali]"), "Alìcuota de contribuciòn dej ubilaciòn");
      domain.put(new String((String)"[contr_inssjyp_ali]"), "Alìcuota de contribución PAMI");
      domain.put(new String((String)"[contr_aaff_ali]"), "Alìcuota de contribuciòn asignaciones familiares");
      domain.put(new String((String)"[contr_fne_ali]"), "Alìcuota de contribuciòn fondo nacional de empleo");
      domain.put(new String((String)"[obligacion]"), "Obligación");
      domain.put(new String((String)"[liquidar_sac]"), "liquidar_sac");
      domain.put(new String((String)"[plus_vacacional]"), "Plus Vacacional");
      domain.put(new String((String)"[no_laborables]"), "Días no laborables no trabajados");
      domain.put(new String((String)"[remuneracion_descuento]"), "Ausencias injustificadas");
      domain.put(new String((String)"[dias_proporcionar_sac]"), "Cantidad de días para proporcionar SAC");
      domain.put(new String((String)"[hora_normal]"), "Valor de hora normal");
      domain.put(new String((String)"[extra]"), "Aumento de hora extra sobre hora normal");
      domain.put(new String((String)"[recargo]"), "Recargo por tipo de trabajo (por ejemplo nocturno)");
      domain.put(new String((String)"[jubilacion]"), "Jubilación");
      domain.put(new String((String)"[obra_social]"), "Obra Social");
      domain.put(new String((String)"[ley_19032]"), "Ley 19032");
      domain.put(new String((String)"[remuneracion_accidente_empresa]"), "Incapacidad laboral temporaria a cargo de la empresa");
      domain.put(new String((String)"[remuneracion_accidente_ART]"), "Incapacidad laboral temporaria a cargo de ART");
      domain.put(new String((String)"[ultimo_dia_mes]"), "Ultimo día del mes");
      domain.put(new String((String)"[dia_fecha_egreso]"), "Día de fecha de egreso");
      domain.put(new String((String)"[indemnizacion_antiguedad]"), "Indemnización por antiguedad");
      domain.put(new String((String)"[proporcion_antiguedad_motivo]"), "Proporción según antiguedad y motivo de egreso definido en el concepto");
      domain.put(new String((String)"[reintegro_guarderia]"), "Reintegro por gastos de guardería");
      domain.put(new String((String)"[beneficio_guarderia]"), "Beneficio Guarderia");
      domain.put(new String((String)"[ultimo_dia_mes_egreso]"), "Ultimo día del mes de egreso");
      domain.put(new String((String)"[dias_mes_egreso]"), "Cantidad de días del mes de egreso");
      domain.put(new String((String)"[cuota_sindical]"), "Cuota sindical");
      domain.put(new String((String)"[obra_social_adherentes]"), "Obra Social Adherentes");
      domain.put(new String((String)"[antiguedad_importe]"), "Antiguedad importe");
      domain.put(new String((String)"[presentismo_importe]"), "Presentismo importe");
      domain.put(new String((String)"{sueldo}"), "Sueldo");
      domain.put(new String((String)"{hora_completa}"), "Hora básica más adicional");
      domain.put(new String((String)"{feriados_trabajados}"), "Feriados trabajados");
      domain.put(new String((String)"[vacaciones_descuento]"), "Descuento por días no trabajados por vacaciones");
      domain.put(new String((String)"[licencias_descuento]"), "Descuento por días no trabajados por licencias");
      domain.put(new String((String)"{feriados_no_trabajados_descuento}"), "Descuento por días no trabajados feriados");
      domain.put(new String((String)"{no_laborables_descuento}"), "Descuento por días no trabajados no laborables");
      domain.put(new String((String)"{sac}"), "Sueldo anual complementario");
      domain.put(new String((String)"{sac_proporcional}"), "SAC Proporcional");
      domain.put(new String((String)"{sueldo_adicional}"), "Sueldo Adicional");
      domain.put(new String((String)"{vacaciones_no_gozadas_ant}"), "Vacaciones no gozadas de año anterior");
      domain.put(new String((String)"{egreso_descuento}"), "Descuento por días no trabajados por egreso");
      domain.put(new String((String)"{obra_social_diferencial}"), "Obra social diferencial");
      domain.put(new String((String)"{dias_HastaFinSemestre}"), "Dias faltantes hasta el fin del semestre");
      domain.put(new String((String)"{tratamiento_exencion}"), "Cálculo exento por tratamiento de exención de IIGG");
      domain.put(new String((String)"{horas_nocturnas}"), "Adicional por horas nocturna");
      domain.put(new String((String)"{extras_al_50}"), "Horas extras al 50%");
      domain.put(new String((String)"{extras_nocturnas_al_50}"), "Horas extras nocturnas al 50%");
      domain.put(new String((String)"{extras_nocturnas_al_100}"), "Horas extras nocturnas al 100%");
      domain.put(new String((String)"{extras_al_100}"), "Horas extras al 100%");
      domain.put(new String((String)"{retroactivo}"), "Recálculo de liquidaciones anteriores para calcular valores retroactivos");
      domain.put(new String((String)"{fondo_cese}"), "Fondo de cese laboral");
      domain.put(new String((String)"{plus_licencia}"), "Plus Licencia");
      domain.put(new String((String)"{redondeo}"), "Redondeo");
      domain.put(new String((String)"{leg_prop_adi}"), "Propiedad adicional de legajo");
      domain.put(new String((String)"{ded_art_30}"), "Deducciones artículo 30");
      domain.put(new String((String)"{devolucion_ganancias}"), "Devolución ganancias");
      domain.put(new String((String)"{ded_gen_men}"), "Deducciones generales mensuales");
      domain.put(new String((String)"{ded_gen_anu}"), "Deducciones generales anuales");
      domain.put(new String((String)"{rem_gravada_gan}"), "Remuneración gravada en ganancias");
      domain.put(new String((String)"{gan_neta}"), "Ganancia neta para impuesto a las ganancias");
      domain.put(new String((String)"{gnsi_sin_dei}"), "Ganancia neta sujeta a impuesto a las ganancias, menos deducción especial incrementada");
      domain.put(new String((String)"{gnsi}"), "Ganancia neta sujeta a impuesto a las ganancias");
      domain.put(new String((String)"{gan_neta_topes}"), "Ganancia neta para calcular topes de deducciones de impuestos a las ganancias");
      domain.put(new String((String)"{calculo_iigg_neto}"), "Cálculo de impuesto a las ganancias menos pagos a cuenta de periodos anteriores e importes pagados en liquidaciones anteriores");
      domain.put(new String((String)"{importe_iigg}"), "Importe a retener de impuesto a las ganancias");
      domain.put(new String((String)"[calculo_iigg]"), "Cálculo de impuesto a las ganancias usando tabla de escalas de AFIP");
      domain.put(new String((String)"{sueldo_bruto_ganancias}"), "Sueldo Bruto más sueldo bruto de otros empleos");
      domain.put(new String((String)"{sueldo_bruto_menos_ley}"), "Sueldo bruto menos descuentos de ley");
      domain.put(new String((String)"{alcanza_ganancias}"), "Empleado es alcanzado por impuesto a las ganancias");
      domain.put(new String((String)"{contribucion_jubilacion}"), "Contribución jubilación");
      domain.put(new String((String)"{contribucion_inssjp}"), "Contribución  ley 19032");
      domain.put(new String((String)"{contribucion_aaff}"), "Contribución asignaciones familiares");
      domain.put(new String((String)"{contribucion_fne}"), "Contribución FNE");
      domain.put(new String((String)"{grossing_up}"), "Grossing up");
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

