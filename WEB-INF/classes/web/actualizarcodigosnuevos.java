package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class actualizarcodigosnuevos extends GXProcedure
{
   public actualizarcodigosnuevos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( actualizarcodigosnuevos.class ), "" );
   }

   public actualizarcodigosnuevos( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( int aP0 )
   {
      actualizarcodigosnuevos.this.AV17CliCod = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "clicod ", "")+GXutil.trim( GXutil.str( AV17CliCod, 6, 0))) ;
      /* Using cursor P00GE2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV17CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A469ConCodOld = P00GE2_A469ConCodOld[0] ;
         A3CliCod = P00GE2_A3CliCod[0] ;
         A26ConCodigo = P00GE2_A26ConCodigo[0] ;
         AV31item = (web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem)new web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem(remoteHandle, context);
         AV31item.setgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo( A26ConCodigo );
         AV31item.setgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold( A469ConCodOld );
         AV9sdt_codigosnuevos.add(AV31item, 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      GXt_char1 = AV21deMesesAnterioresPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.palabra_demesesanteriores(remoteHandle, context).execute( AV17CliCod, GXv_char2) ;
      actualizarcodigosnuevos.this.GXt_char1 = GXv_char2[0] ;
      AV21deMesesAnterioresPalabra = GXt_char1 ;
      GXt_char1 = AV8conceptoPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigoconcepto(remoteHandle, context).execute( AV17CliCod, false, GXv_char2) ;
      actualizarcodigosnuevos.this.GXt_char1 = GXv_char2[0] ;
      AV8conceptoPalabra = GXt_char1 ;
      GXv_char2[0] = AV118adelantoRetencionPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[adelanto_retencion]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV118adelantoRetencionPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV112topeIndemnizatorioPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[tope_indemnizatorio]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV112topeIndemnizatorioPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV113novedadHorasPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[novedad_cantidad]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV113novedadHorasPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV96osApoAdicPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[os_apo_adic]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV96osApoAdicPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV97diasVacacionesPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[dias_vacaciones]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV97diasVacacionesPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV95diasMesPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[dias_mes]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV95diasMesPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV55tipoLiqEgresoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[tipoLiq]", false, false, GXv_char2) ;
      actualizarcodigosnuevos.this.AV55tipoLiqEgresoPalabra = GXv_char2[0] ;
      GXt_char1 = AV56tipoLiqEgreso ;
      GXt_char3 = AV56tipoLiqEgreso ;
      GXv_char2[0] = GXt_char3 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      actualizarcodigosnuevos.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV17CliCod, GXt_char3, GXv_char4) ;
      actualizarcodigosnuevos.this.GXt_char1 = GXv_char4[0] ;
      AV56tipoLiqEgreso = GXt_char1 ;
      AV55tipoLiqEgresoPalabra = GXutil.strReplace( AV55tipoLiqEgresoPalabra, " X", " "+GXutil.trim( AV56tipoLiqEgreso)) ;
      GXv_char4[0] = AV116clasePalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[clase]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV116clasePalabra = GXv_char4[0] ;
      AV117claseJornal = httpContext.getMessage( "J", "") ;
      AV115claseJornalPalabra = GXutil.strReplace( AV116clasePalabra, " X", " "+GXutil.trim( AV117claseJornal)) ;
      GXv_char4[0] = AV15cantidadMismoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[novedad_cantidad]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV15cantidadMismoPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV54siPalabra ;
      new web.palabraformulaif(remoteHandle, context).execute( AV17CliCod, GXv_char4) ;
      actualizarcodigosnuevos.this.AV54siPalabra = GXv_char4[0] ;
      GXt_char3 = AV16cantidadPalabra ;
      GXv_char4[0] = GXt_char3 ;
      new web.cantidadpalabra(remoteHandle, context).execute( AV17CliCod, GXv_char4) ;
      actualizarcodigosnuevos.this.GXt_char3 = GXv_char4[0] ;
      AV16cantidadPalabra = GXt_char3 ;
      AV49valorGenPalabra = httpContext.getMessage( "G", "") ;
      GXv_char4[0] = AV78deduccionPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[monto_siradig]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV78deduccionPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV119calculoDeduccionPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[deduccion]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV119calculoDeduccionPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV20contrARTPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[ART_ali]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV20contrARTPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV111remuVacNoGozadasPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[remuneracion_vacaciones_no_gozadas]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV111remuVacNoGozadasPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV93osCantidadAdherentesPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[os_cantidad_adherentes]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV93osCantidadAdherentesPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV62cuotaSindicalPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[alicuota_sindical]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV62cuotaSindicalPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV94apo_OS_Adh_aliPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[apo_OS_adh_ali]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV94apo_OS_Adh_aliPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV10apoJubPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[apo_jub_ali]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV10apoJubPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV13apoPamiPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[apo_INSSJyP_ali]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV13apoPamiPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV12apoOSPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[apo_OS_ali]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV12apoOSPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV11apoOSAdhPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[apo_OS_adh_ali]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV11apoOSAdhPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV40smvmPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[smvm]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV40smvmPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV38pctHonMedPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[limite_medicos]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV38pctHonMedPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV47topeSegurosPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[tope_seguros]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV47topeSegurosPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV43topeCargaHijoPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[ded_hijo]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV43topeCargaHijoPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV42topeCargaConyugePalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[ded_cony]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV42topeCargaConyugePalabra = GXv_char4[0] ;
      GXv_char4[0] = AV27minimoNoImpoPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[mni]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV27minimoNoImpoPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV44topeDedEspPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[ded_especial]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV44topeDedEspPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV52limiteDonacionesPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[alicuota_donaciones]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV52limiteDonacionesPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV82limitePrepagaPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[limite_prepaga]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV82limitePrepagaPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV83topeSepelioPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[tope_sepelio]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV83topeSepelioPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV86topeHipotecaPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[tope_hipoteca]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV86topeHipotecaPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV28horaNocdPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[horas_noct]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV28horaNocdPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV57sumaFijaARTPalabra ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV17CliCod, "[fijo_ART]", false, false, GXv_char4) ;
      actualizarcodigosnuevos.this.AV57sumaFijaARTPalabra = GXv_char4[0] ;
      AV73OpeCliId = "[gan_escala]" ;
      GXv_char4[0] = "" ;
      GXv_char2[0] = "" ;
      GXv_boolean5[0] = false ;
      GXv_char6[0] = AV68ganTasaPalabra ;
      GXv_boolean7[0] = false ;
      new web.obteneropecli(remoteHandle, context).execute( AV17CliCod, AV73OpeCliId, localUtil.ymdtod( 2022, 1, 1), GXv_char4, GXv_char2, GXv_boolean5, GXv_char6, GXv_boolean7) ;
      actualizarcodigosnuevos.this.AV68ganTasaPalabra = GXv_char6[0] ;
      GXv_char6[0] = "" ;
      GXv_char4[0] = "" ;
      GXv_boolean7[0] = false ;
      GXv_char2[0] = AV77pisoGananciasPalabra ;
      GXv_boolean5[0] = false ;
      new web.obteneropecli(remoteHandle, context).execute( AV17CliCod, "[piso_ganancias_solteros]", localUtil.ymdtod( 2022, 1, 1), GXv_char6, GXv_char4, GXv_boolean7, GXv_char2, GXv_boolean5) ;
      actualizarcodigosnuevos.this.AV77pisoGananciasPalabra = GXv_char2[0] ;
      GXv_char6[0] = AV74ganCantCuotasPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[gan_cuotas]", false, false, GXv_char6) ;
      actualizarcodigosnuevos.this.AV74ganCantCuotasPalabra = GXv_char6[0] ;
      GXv_char6[0] = AV75mesPeriodoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[mes_Periodo]", false, false, GXv_char6) ;
      actualizarcodigosnuevos.this.AV75mesPeriodoPalabra = GXv_char6[0] ;
      AV79semestrePalabra = "semestre" ;
      GXt_char3 = AV35mejorPalabra ;
      GXv_char6[0] = GXt_char3 ;
      new web.palabra_mejor(remoteHandle, context).execute( AV17CliCod, GXv_char6) ;
      actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
      AV35mejorPalabra = GXt_char3 ;
      AV90anualPalabra = "acumulado" ;
      AV80mismoperiodoPalabra = "mismoPeriodo" ;
      /* Using cursor P00GE3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV17CliCod)});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P00GE3_A3CliCod[0] ;
         A148ConFormula = P00GE3_A148ConFormula[0] ;
         n148ConFormula = P00GE3_n148ConFormula[0] ;
         A469ConCodOld = P00GE3_A469ConCodOld[0] ;
         A153ConObservacion = P00GE3_A153ConObservacion[0] ;
         A157ConValorGen = P00GE3_A157ConValorGen[0] ;
         n157ConValorGen = P00GE3_n157ConValorGen[0] ;
         A41ConDescrip = P00GE3_A41ConDescrip[0] ;
         A26ConCodigo = P00GE3_A26ConCodigo[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{adelanto_retencion}", ""), GXutil.trim( AV118adelantoRetencionPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{tope_indemnizatorio}", ""), GXutil.trim( AV112topeIndemnizatorioPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{novedad_horas}", ""), GXutil.trim( AV15cantidadMismoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{claseJornal}", ""), GXutil.trim( AV115claseJornalPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{tipoLiqEgreso}", ""), GXutil.trim( AV55tipoLiqEgresoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{dias_vacaciones}", ""), GXutil.trim( AV97diasVacacionesPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{os_apo_adic}", ""), GXutil.trim( AV96osApoAdicPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{os_cantidad_adherentes}", ""), GXutil.trim( AV93osCantidadAdherentesPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{apo_OS_Adh_ali}", ""), GXutil.trim( AV94apo_OS_Adh_aliPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{diasLicenciaNoGozada}", ""), GXutil.trim( AV91diasLicenciaNoGozadaPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{tope_seguros}", ""), GXutil.trim( AV47topeSegurosPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{minimoNoImponible}", ""), GXutil.trim( AV27minimoNoImpoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{remunerativos_sin_sac}", ""), GXutil.trim( AV87remunerativossinSACPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{topeHipoteca}", ""), GXutil.trim( AV86topeHipotecaPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{topeSepelio}", ""), GXutil.trim( AV83topeSepelioPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{limitePrepaga}", ""), GXutil.trim( AV82limitePrepagaPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{limiteDonaciones}", ""), GXutil.trim( AV52limiteDonacionesPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{mismoPeriodo}", ""), GXutil.trim( AV80mismoperiodoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{semestre}", ""), GXutil.trim( AV79semestrePalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{mejor}", ""), GXutil.trim( AV35mejorPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{anual}", ""), GXutil.trim( AV90anualPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{deMesesAnteriores}", ""), GXutil.trim( AV21deMesesAnterioresPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{mesPeriodo}", ""), GXutil.trim( AV75mesPeriodoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{deduccion}", ""), GXutil.trim( AV78deduccionPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{calcu_deduc}", ""), GXutil.trim( AV119calculoDeduccionPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{ant_importe}", ""), GXutil.trim( AV58antiguedadImportePalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{ant_alicuota}", ""), GXutil.trim( AV59antiguedadAlicuotaPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{pres_importe}", ""), GXutil.trim( AV61presentismoImportePalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{pres_alicuota}", ""), GXutil.trim( AV60presentismoAlicuotaPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "Si([CCO 6600 T] = [UIC P 1]", ""), GXutil.trim( AV54siPalabra)+"("+GXutil.trim( AV55tipoLiqEgresoPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO ", "")+GXutil.trim( A469ConCodOld)+httpContext.getMessage( " C]", ""), GXutil.trim( AV15cantidadMismoPalabra)) ;
         n148ConFormula = false ;
         if ( GXutil.strcmp(A469ConCodOld, "4150") != 0 )
         {
            AV18codigosAux.add("4010", 0);
            AV18codigosAux.add("4020", 0);
            AV18codigosAux.add("4050", 0);
            AV18codigosAux.add("4060", 0);
            AV18codigosAux.add("4090", 0);
            AV18codigosAux.add("6460", 0);
            AV18codigosAux.add("6820", 0);
            AV18codigosAux.add("1230", 0);
            AV18codigosAux.add("2076", 0);
            AV18codigosAux.add("6490", 0);
            AV18codigosAux.add("6680", 0);
            AV18codigosAux.add("6500", 0);
            AV18codigosAux.add("6520", 0);
            AV18codigosAux.add("6690", 0);
            AV18codigosAux.add("6380", 0);
            AV18codigosAux.add("6390", 0);
            AV18codigosAux.add("6370", 0);
            AV18codigosAux.add("6530", 0);
            AV18codigosAux.add("6360", 0);
            AV18codigosAux.add("5250", 0);
            AV18codigosAux.add("6810", 0);
            AV18codigosAux.add("6470", 0);
            AV18codigosAux.add("6830", 0);
            AV18codigosAux.add("5050", 0);
            AV18codigosAux.add("5350", 0);
            AV18codigosAux.add("1020", 0);
            AV18codigosAux.add("1030", 0);
            AV18codigosAux.add("1180", 0);
            AV18codigosAux.add("1181", 0);
            AV18codigosAux.add("1182", 0);
            AV18codigosAux.add("4210", 0);
            if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "* ( [MAT PDG N]:  [CCO 6850 T] ) / [UIC P 100]", ""), 1) != 0 )
            {
               A153ConObservacion = httpContext.getMessage( "Saco de la fórmula el porcentaje de disminución, porque por lo que vi, ya no se usa más. Fórmula original: ", "") + GXutil.trim( A148ConFormula) ;
               A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "* ( [MAT PDG N]:  [CCO 6850 T] ) / [UIC P 100]", ""), "") ;
               n148ConFormula = false ;
               A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "* ( [MAT PDG N]:  [CCO 6875 T] ) / [UIC P 100]", ""), "") ;
               n148ConFormula = false ;
            }
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[MAT MES G]: [UIC P 0]", ""), AV75mesPeriodoPalabra) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[MAT PRO G]: [UIC P 0]", ""), GXutil.trim( AV74ganCantCuotasPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 4210 G]", ""), GXutil.trim( AV62cuotaSindicalPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 1180 G]", ""), GXutil.trim( AV65bonifSecundarioPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 1181 G]", ""), GXutil.trim( AV64bonifSecuTecnicoPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 1182 G]", ""), GXutil.trim( AV63bonifTerciarioPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 4010 G]", ""), GXutil.trim( AV10apoJubPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 4020 G]", ""), GXutil.trim( AV13apoPamiPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 4050 G]", ""), GXutil.trim( AV12apoOSPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 4060 G]", ""), GXutil.trim( AV11apoOSAdhPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 4090 G]", ""), GXutil.trim( AV40smvmPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6460 G]", ""), GXutil.trim( AV38pctHonMedPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6820 G]", ""), GXutil.trim( AV38pctHonMedPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6810 G]", ""), GXutil.trim( AV38pctHonMedPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 1230 G]", ""), GXutil.trim( AV28horaNocdPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 2076 G]", ""), GXutil.trim( AV28horaNocdPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6520 G]", ""), GXutil.trim( AV47topeSegurosPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6690 G]", ""), GXutil.trim( AV47topeSegurosPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6390 G]", ""), GXutil.trim( AV43topeCargaHijoPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6380 G]", ""), GXutil.trim( AV42topeCargaConyugePalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6370 G]", ""), GXutil.trim( AV27minimoNoImpoPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6530 G]", ""), GXutil.trim( AV27minimoNoImpoPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6360 G]", ""), GXutil.trim( AV44topeDedEspPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 5250 G]", ""), GXutil.trim( AV20contrARTPalabra)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 6830 G]", ""), GXutil.trim( AV52limiteDonacionesPalabra)) ;
            n148ConFormula = false ;
            if ( GXutil.strcmp(A469ConCodOld, "6470") == 0 )
            {
               new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "pucha antes ", "")+A148ConFormula) ;
            }
            if ( GXutil.strcmp(A469ConCodOld, "6470") == 0 )
            {
               new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "pucha ", "")+AV53topePCTMedicosPalabra) ;
               new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "pucha despues ", "")+A148ConFormula) ;
            }
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO 5350 G]", ""), GXutil.trim( AV57sumaFijaARTPalabra)) ;
            n148ConFormula = false ;
            if ( (AV18codigosAux.indexof(GXutil.rtrim( A469ConCodOld))>0) )
            {
               A157ConValorGen = DecimalUtil.ZERO ;
               n157ConValorGen = false ;
            }
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO ", "")+GXutil.trim( A469ConCodOld)+httpContext.getMessage( " G]", ""), GXutil.trim( GXutil.str( A157ConValorGen, 14, 4))) ;
            n148ConFormula = false ;
         }
         AV126GXV1 = 1 ;
         while ( AV126GXV1 <= AV9sdt_codigosnuevos.size() )
         {
            AV31item = (web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem)((web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem)AV9sdt_codigosnuevos.elementAt(-1+AV126GXV1));
            A148ConFormula = GXutil.strReplace( A148ConFormula, GXutil.trim( AV31item.getgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodold()), GXutil.trim( AV31item.getgxTv_Sdtsdt_codigosnuevos_sdt_codigosnuevosItem_Concodigo())) ;
            n148ConFormula = false ;
            AV126GXV1 = (int)(AV126GXV1+1) ;
         }
         GXt_char3 = AV76sueldoBrutoConCodigo ;
         GXv_char6[0] = GXt_char3 ;
         new web.conceptosueldobruto(remoteHandle, context).execute( AV17CliCod, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         AV76sueldoBrutoConCodigo = GXt_char3 ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{sueldoBruto}", ""), "["+GXutil.trim( AV8conceptoPalabra)+" "+GXutil.trim( AV76sueldoBrutoConCodigo)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{sueldoBrutoCodigo}", ""), GXutil.trim( AV76sueldoBrutoConCodigo)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{gan_min_impo}", ""), GXutil.trim( AV77pisoGananciasPalabra)) ;
         n148ConFormula = false ;
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "MAT ", ""), 1) == 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 25]", ""), "25") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 1.5]", ""), "1.5") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 1.5000]", ""), "1.5") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 2.0000]", ""), "2") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 9]", ""), "9") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 200.0000]", ""), "200") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 5.0000]", ""), "5") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 200]", ""), "200") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC N  1]", ""), "-1") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 25.0000]", ""), "25") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 30]", ""), "30") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 2]", ""), "2") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 170]", ""), "170") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 8.0000]", ""), "8") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 0.03]", ""), "0.03") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 0]", ""), "0") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 100]", ""), "100") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 1]", ""), "1") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 100.0000]", ""), "100") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 1.0000]", ""), "1") ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[UIC P 12]", ""), "12") ;
            n148ConFormula = false ;
         }
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "Es ", ""), "") ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[antiguedad]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[ANT AEA]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[antiguedad_indemnizacion]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[ANT F3M]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "{concepto}", false, true, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CCO", ""), "["+GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[dias_mes]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CDM]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[dias_semestre]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[CDS]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[dias_trabajados_mes]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[DTM]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[dias_remunerados_semestre]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[DTS]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[LEG ", ""), "[") ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[plan_medico]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[PME]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[remu_var]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[REMVAR]", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[basico_mensual]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{basico_mensual}", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXt_char3 = A148ConFormula ;
         GXv_char6[0] = GXt_char3 ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[hora_basica]", false, false, GXv_char6) ;
         actualizarcodigosnuevos.this.GXt_char3 = GXv_char6[0] ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{valor_hora}", ""), GXutil.trim( GXt_char3)) ;
         n148ConFormula = false ;
         GXv_char6[0] = AV36motegrPalabra ;
         new web.codigoopeformula(remoteHandle, context).execute( AV17CliCod, "[motivo_egreso]", false, true, GXv_char6) ;
         actualizarcodigosnuevos.this.AV36motegrPalabra = GXv_char6[0] ;
         new web.msgdebug2(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&motegrPalabra ", "")+AV36motegrPalabra) ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "MotEgr", ""), GXutil.trim( AV36motegrPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "MOTEGR", ""), GXutil.trim( AV36motegrPalabra)) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 2 000 000 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV21deMesesAnterioresPalabra)+" 0 ") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 2 001 001 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV21deMesesAnterioresPalabra)+" 1 ") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 2 001 005 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV21deMesesAnterioresPalabra)+" 5 ") ;
         n148ConFormula = false ;
         AV22desdeHastaPalabra = httpContext.getMessage( "ERROR#35#", "") ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 1 01 06 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV22desdeHastaPalabra)+" 01 06 ") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 1 07 12 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV22desdeHastaPalabra)+" 07 12 ") ;
         n148ConFormula = false ;
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "TOTAL DEDUCCIONES 1", "")) == 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "TOTAL DEDUCCIONES 1 antes ", "")+GXutil.trim( A148ConFormula)) ;
         }
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 1 01 12 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV22desdeHastaPalabra)+" 01 12 ") ;
         n148ConFormula = false ;
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "TOTAL DEDUCCIONES 1", "")) == 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "TOTAL DEDUCCIONES 1 despues 1 ", "")+GXutil.trim( A148ConFormula)) ;
         }
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T 1 3 ", ""), httpContext.getMessage( " T 1 ", "")+GXutil.trim( AV22desdeHastaPalabra)+" ") ;
         n148ConFormula = false ;
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "TOTAL DEDUCCIONES 1", "")) == 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "TOTAL DEDUCCIONES 1 despues 2 ", "")+GXutil.trim( A148ConFormula)) ;
         }
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " P 0]", ""), httpContext.getMessage( " P_0]", "")) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, " 0]", "]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " P_0]", ""), httpContext.getMessage( " P 0]", "")) ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, " 3]", " "+GXutil.trim( AV35mejorPalabra)+"]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T ", "")+GXutil.trim( AV33liqAntPalabra)+" 3 ", httpContext.getMessage( " T ", "")+GXutil.trim( AV33liqAntPalabra)+" "+GXutil.trim( AV22desdeHastaPalabra)+" ") ;
         n148ConFormula = false ;
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "TOTAL DEDUCCIONES 1", "")) == 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "TOTAL DEDUCCIONES 1 despues 3 ", "")+GXutil.trim( A148ConFormula)) ;
         }
         AV34matriz_HIJ = httpContext.getMessage( "HIJ", "") ;
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "( 1 - [TAU ANS C2] )", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "( 1 - [TAU ANS C2] ) )", ""), GXutil.trim( AV24distr_anssal_superaTopePalabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo la forma de calcular el porcentaje anssal para que lo saque del nuevo snippet ", "") + GXutil.trim( AV24distr_anssal_superaTopePalabra) + ". " + GXutil.trim( A153ConObservacion) ;
            new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "( 1 - [TAU ANS C1] )", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "( 1 - [TAU ANS C1] )", ""), GXutil.trim( AV23distr_anssal_hastaTopePalabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo la forma de calcular el porcentaje anssal para que lo saque del nuevo snippet ", "") + GXutil.trim( AV23distr_anssal_hastaTopePalabra) + ". " + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "CONTRIBUCION OBRA SOCIAL", "")) == 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "ConFormula ", "")+A148ConFormula) ;
         }
         AV32letraGenericoFijo = httpContext.getMessage( "G", "") ;
         AV109obraSocialAnssalConCodigo = httpContext.getMessage( "CAL005", "") ;
         AV110obraSocialConCodigo = httpContext.getMessage( "DES003", "") ;
         if ( GXutil.strSearch( A148ConFormula, "["+GXutil.trim( AV8conceptoPalabra)+" "+GXutil.trim( AV109obraSocialAnssalConCodigo)+" "+GXutil.trim( AV32letraGenericoFijo)+"]", 1) != 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "concodigo ", "")+A26ConCodigo+httpContext.getMessage( " encuentra cal8", "")) ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, "["+GXutil.trim( AV8conceptoPalabra)+" "+GXutil.trim( AV110obraSocialConCodigo)+" "+GXutil.trim( AV32letraGenericoFijo)+"]", GXutil.trim( AV12apoOSPalabra)) ;
            n148ConFormula = false ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU ANS C2]", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU ANS C2]", ""), GXutil.trim( AV26distr_OS_superaTopePalabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU ANS C2] \"(Tabla aux.) Aporte a Obra Social (Resto va a Anssal) según ObraSocial\" (mas de $ciertoImporte), por ", "") + GXutil.trim( AV26distr_OS_superaTopePalabra) + ". " + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU ANS C1]", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU ANS C1]", ""), GXutil.trim( AV25distr_OS_hastaTopePalabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU ANS C1] \"(Tabla aux.) Aporte a Obra Social (Resto va a Anssal) según ObraSocial\" (hasta $ciertoImporte), por ", "") + GXutil.trim( AV25distr_OS_hastaTopePalabra) + ". " + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C1]", ""), 1) != 0 )
         {
            new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "ENCUENTRA [TAU CP1 C1]", "")) ;
            if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C1] / 100", ""), 1) != 0 )
            {
               new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "ENCUENTRA CON LA DIVISION", "")) ;
            }
            else
            {
               new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "no ENCUENTRA CON LA DIVISION", "")) ;
               new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, A148ConFormula) ;
            }
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C1] / 100", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU CP1 C1] / 100", ""), GXutil.trim( AV37palabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU CP1 C1] \"(Tabla aux.) Porcentaje de Contribución patronal de jubilación segun LugarDePago\", por ", "") + GXutil.trim( AV37palabra) + httpContext.getMessage( " y lo hago depender del tipo de empleador.", "") + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C2] / 100", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU CP1 C2] / 100", ""), GXutil.trim( AV37palabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU CP1 C2] \"(Tabla aux.) Porcentaje de Contribución patronal de Asignaciones Familiares segun LugarDePago\", por", "") + GXutil.trim( AV37palabra) + httpContext.getMessage( " y lo hago depender del tipo de empleador.", "") + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C3] / 100", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU CP1 C3] / 100", ""), GXutil.trim( AV37palabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU CP1 C3] \"(Tabla aux.) Porcentaje de Contribución patronal de Fondo de Empleo segun LugarDePago\", por ", "") + GXutil.trim( AV37palabra) + httpContext.getMessage( " y lo hago depender del tipo de empleador.", "") + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C4] / 100", ""), 1) != 0 )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU CP1 C4] / 100", ""), GXutil.trim( AV37palabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU CP1 C4]  \"(Tabla aux.) Porcentaje de Contribución patronal de INSSJP segun LugarDePago\", por ", "") + GXutil.trim( AV37palabra) + httpContext.getMessage( " y lo hago depender del tipo de empleador.", "") + GXutil.trim( A153ConObservacion) ;
         }
         if ( GXutil.strSearch( A148ConFormula, httpContext.getMessage( "[TAU CP1 C5] / 100", ""), 1) != 0 )
         {
            new web.msgdebug6(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "&porcContrPalabra ", "")+GXutil.trim( AV39porcContrPalabra)) ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "[TAU CP1 C5] / 100", ""), GXutil.trim( AV39porcContrPalabra)) ;
            n148ConFormula = false ;
            A153ConObservacion = httpContext.getMessage( "Reemplazo [TAU CP1 C5] \"(Tabla aux.) Porcentaje de Contribución patronal de obra social segun LugarDePago\", por ", "") + GXutil.trim( AV39porcContrPalabra) + httpContext.getMessage( ", y lo hago depender del tipo de Empleador.", "") + GXutil.trim( A153ConObservacion) ;
         }
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " T]", ""), "]") ;
         n148ConFormula = false ;
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " I]", ""), "]") ;
         n148ConFormula = false ;
         if ( GXutil.strcmp(A41ConDescrip, httpContext.getMessage( "TOTAL DEDUCCIONES 1", "")) == 0 )
         {
            new web.msgdebug7(remoteHandle, context).execute( AV123Pgmname, httpContext.getMessage( "TOTAL DEDUCCIONES 1 despues 4 ", "")+GXutil.trim( A148ConFormula)) ;
         }
         A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( " VAR]", ""), "]") ;
         n148ConFormula = false ;
         GXv_char6[0] = A148ConFormula ;
         new web.corregirespaciosformula(remoteHandle, context).execute( A3CliCod, GXv_char6) ;
         actualizarcodigosnuevos.this.A148ConFormula = GXv_char6[0] ;
         n148ConFormula = ((GXutil.strcmp("", A148ConFormula)==0) ? true : false) ;
         /* Using cursor P00GE4 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, A153ConObservacion, Boolean.valueOf(n157ConValorGen), A157ConValorGen, Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "actualizarcodigosnuevos");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV123Pgmname = "" ;
      scmdbuf = "" ;
      P00GE2_A469ConCodOld = new String[] {""} ;
      P00GE2_A3CliCod = new int[1] ;
      P00GE2_A26ConCodigo = new String[] {""} ;
      A469ConCodOld = "" ;
      A26ConCodigo = "" ;
      AV31item = new web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem(remoteHandle, context);
      AV9sdt_codigosnuevos = new GXBaseCollection<web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem>(web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem.class, "sdt_codigosnuevosItem", "PayDay", remoteHandle);
      AV21deMesesAnterioresPalabra = "" ;
      AV8conceptoPalabra = "" ;
      AV118adelantoRetencionPalabra = "" ;
      AV112topeIndemnizatorioPalabra = "" ;
      AV113novedadHorasPalabra = "" ;
      AV96osApoAdicPalabra = "" ;
      AV97diasVacacionesPalabra = "" ;
      AV95diasMesPalabra = "" ;
      AV55tipoLiqEgresoPalabra = "" ;
      AV56tipoLiqEgreso = "" ;
      GXt_char1 = "" ;
      AV116clasePalabra = "" ;
      AV117claseJornal = "" ;
      AV115claseJornalPalabra = "" ;
      AV15cantidadMismoPalabra = "" ;
      AV54siPalabra = "" ;
      AV16cantidadPalabra = "" ;
      AV49valorGenPalabra = "" ;
      AV78deduccionPalabra = "" ;
      AV119calculoDeduccionPalabra = "" ;
      AV20contrARTPalabra = "" ;
      AV111remuVacNoGozadasPalabra = "" ;
      AV93osCantidadAdherentesPalabra = "" ;
      AV62cuotaSindicalPalabra = "" ;
      AV94apo_OS_Adh_aliPalabra = "" ;
      AV10apoJubPalabra = "" ;
      AV13apoPamiPalabra = "" ;
      AV12apoOSPalabra = "" ;
      AV11apoOSAdhPalabra = "" ;
      AV40smvmPalabra = "" ;
      AV38pctHonMedPalabra = "" ;
      AV47topeSegurosPalabra = "" ;
      AV43topeCargaHijoPalabra = "" ;
      AV42topeCargaConyugePalabra = "" ;
      AV27minimoNoImpoPalabra = "" ;
      AV44topeDedEspPalabra = "" ;
      AV52limiteDonacionesPalabra = "" ;
      AV82limitePrepagaPalabra = "" ;
      AV83topeSepelioPalabra = "" ;
      AV86topeHipotecaPalabra = "" ;
      AV28horaNocdPalabra = "" ;
      AV57sumaFijaARTPalabra = "" ;
      AV73OpeCliId = "" ;
      AV68ganTasaPalabra = "" ;
      GXv_char4 = new String[1] ;
      GXv_boolean7 = new boolean[1] ;
      AV77pisoGananciasPalabra = "" ;
      GXv_char2 = new String[1] ;
      GXv_boolean5 = new boolean[1] ;
      AV74ganCantCuotasPalabra = "" ;
      AV75mesPeriodoPalabra = "" ;
      AV79semestrePalabra = "" ;
      AV35mejorPalabra = "" ;
      AV90anualPalabra = "" ;
      AV80mismoperiodoPalabra = "" ;
      P00GE3_A3CliCod = new int[1] ;
      P00GE3_A148ConFormula = new String[] {""} ;
      P00GE3_n148ConFormula = new boolean[] {false} ;
      P00GE3_A469ConCodOld = new String[] {""} ;
      P00GE3_A153ConObservacion = new String[] {""} ;
      P00GE3_A157ConValorGen = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00GE3_n157ConValorGen = new boolean[] {false} ;
      P00GE3_A41ConDescrip = new String[] {""} ;
      P00GE3_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      A153ConObservacion = "" ;
      A157ConValorGen = DecimalUtil.ZERO ;
      A41ConDescrip = "" ;
      AV91diasLicenciaNoGozadaPalabra = "" ;
      AV87remunerativossinSACPalabra = "" ;
      AV58antiguedadImportePalabra = "" ;
      AV59antiguedadAlicuotaPalabra = "" ;
      AV61presentismoImportePalabra = "" ;
      AV60presentismoAlicuotaPalabra = "" ;
      AV18codigosAux = new GXSimpleCollection<String>(String.class, "internal", "");
      AV65bonifSecundarioPalabra = "" ;
      AV64bonifSecuTecnicoPalabra = "" ;
      AV63bonifTerciarioPalabra = "" ;
      AV53topePCTMedicosPalabra = "" ;
      AV76sueldoBrutoConCodigo = "" ;
      GXt_char3 = "" ;
      AV36motegrPalabra = "" ;
      AV22desdeHastaPalabra = "" ;
      AV33liqAntPalabra = "" ;
      AV34matriz_HIJ = "" ;
      AV24distr_anssal_superaTopePalabra = "" ;
      AV23distr_anssal_hastaTopePalabra = "" ;
      AV32letraGenericoFijo = "" ;
      AV109obraSocialAnssalConCodigo = "" ;
      AV110obraSocialConCodigo = "" ;
      AV26distr_OS_superaTopePalabra = "" ;
      AV25distr_OS_hastaTopePalabra = "" ;
      AV37palabra = "" ;
      AV39porcContrPalabra = "" ;
      GXv_char6 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.actualizarcodigosnuevos__default(),
         new Object[] {
             new Object[] {
            P00GE2_A469ConCodOld, P00GE2_A3CliCod, P00GE2_A26ConCodigo
            }
            , new Object[] {
            P00GE3_A3CliCod, P00GE3_A148ConFormula, P00GE3_n148ConFormula, P00GE3_A469ConCodOld, P00GE3_A153ConObservacion, P00GE3_A157ConValorGen, P00GE3_n157ConValorGen, P00GE3_A41ConDescrip, P00GE3_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      AV123Pgmname = "actualizarCodigosNuevos" ;
      /* GeneXus formulas. */
      AV123Pgmname = "actualizarCodigosNuevos" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV17CliCod ;
   private int A3CliCod ;
   private int AV126GXV1 ;
   private java.math.BigDecimal A157ConValorGen ;
   private String AV123Pgmname ;
   private String scmdbuf ;
   private String A469ConCodOld ;
   private String A26ConCodigo ;
   private String AV21deMesesAnterioresPalabra ;
   private String AV8conceptoPalabra ;
   private String AV118adelantoRetencionPalabra ;
   private String AV112topeIndemnizatorioPalabra ;
   private String AV113novedadHorasPalabra ;
   private String AV96osApoAdicPalabra ;
   private String AV97diasVacacionesPalabra ;
   private String AV95diasMesPalabra ;
   private String AV55tipoLiqEgresoPalabra ;
   private String AV56tipoLiqEgreso ;
   private String GXt_char1 ;
   private String AV116clasePalabra ;
   private String AV117claseJornal ;
   private String AV115claseJornalPalabra ;
   private String AV15cantidadMismoPalabra ;
   private String AV54siPalabra ;
   private String AV16cantidadPalabra ;
   private String AV49valorGenPalabra ;
   private String AV78deduccionPalabra ;
   private String AV119calculoDeduccionPalabra ;
   private String AV20contrARTPalabra ;
   private String AV111remuVacNoGozadasPalabra ;
   private String AV93osCantidadAdherentesPalabra ;
   private String AV62cuotaSindicalPalabra ;
   private String AV94apo_OS_Adh_aliPalabra ;
   private String AV10apoJubPalabra ;
   private String AV13apoPamiPalabra ;
   private String AV12apoOSPalabra ;
   private String AV11apoOSAdhPalabra ;
   private String AV40smvmPalabra ;
   private String AV38pctHonMedPalabra ;
   private String AV47topeSegurosPalabra ;
   private String AV43topeCargaHijoPalabra ;
   private String AV42topeCargaConyugePalabra ;
   private String AV27minimoNoImpoPalabra ;
   private String AV44topeDedEspPalabra ;
   private String AV52limiteDonacionesPalabra ;
   private String AV82limitePrepagaPalabra ;
   private String AV83topeSepelioPalabra ;
   private String AV86topeHipotecaPalabra ;
   private String AV28horaNocdPalabra ;
   private String AV57sumaFijaARTPalabra ;
   private String AV73OpeCliId ;
   private String AV68ganTasaPalabra ;
   private String GXv_char4[] ;
   private String AV77pisoGananciasPalabra ;
   private String GXv_char2[] ;
   private String AV74ganCantCuotasPalabra ;
   private String AV75mesPeriodoPalabra ;
   private String AV79semestrePalabra ;
   private String AV35mejorPalabra ;
   private String AV90anualPalabra ;
   private String AV80mismoperiodoPalabra ;
   private String AV91diasLicenciaNoGozadaPalabra ;
   private String AV87remunerativossinSACPalabra ;
   private String AV58antiguedadImportePalabra ;
   private String AV59antiguedadAlicuotaPalabra ;
   private String AV61presentismoImportePalabra ;
   private String AV60presentismoAlicuotaPalabra ;
   private String AV65bonifSecundarioPalabra ;
   private String AV64bonifSecuTecnicoPalabra ;
   private String AV63bonifTerciarioPalabra ;
   private String AV53topePCTMedicosPalabra ;
   private String AV76sueldoBrutoConCodigo ;
   private String GXt_char3 ;
   private String AV36motegrPalabra ;
   private String AV22desdeHastaPalabra ;
   private String AV33liqAntPalabra ;
   private String AV34matriz_HIJ ;
   private String AV24distr_anssal_superaTopePalabra ;
   private String AV23distr_anssal_hastaTopePalabra ;
   private String AV32letraGenericoFijo ;
   private String AV109obraSocialAnssalConCodigo ;
   private String AV110obraSocialConCodigo ;
   private String AV26distr_OS_superaTopePalabra ;
   private String AV25distr_OS_hastaTopePalabra ;
   private String AV37palabra ;
   private String AV39porcContrPalabra ;
   private String GXv_char6[] ;
   private boolean GXv_boolean7[] ;
   private boolean GXv_boolean5[] ;
   private boolean n148ConFormula ;
   private boolean n157ConValorGen ;
   private String A148ConFormula ;
   private String A153ConObservacion ;
   private String A41ConDescrip ;
   private IDataStoreProvider pr_default ;
   private String[] P00GE2_A469ConCodOld ;
   private int[] P00GE2_A3CliCod ;
   private String[] P00GE2_A26ConCodigo ;
   private int[] P00GE3_A3CliCod ;
   private String[] P00GE3_A148ConFormula ;
   private boolean[] P00GE3_n148ConFormula ;
   private String[] P00GE3_A469ConCodOld ;
   private String[] P00GE3_A153ConObservacion ;
   private java.math.BigDecimal[] P00GE3_A157ConValorGen ;
   private boolean[] P00GE3_n157ConValorGen ;
   private String[] P00GE3_A41ConDescrip ;
   private String[] P00GE3_A26ConCodigo ;
   private GXSimpleCollection<String> AV18codigosAux ;
   private GXBaseCollection<web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem> AV9sdt_codigosnuevos ;
   private web.Sdtsdt_codigosnuevos_sdt_codigosnuevosItem AV31item ;
}

final  class actualizarcodigosnuevos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00GE2", "SELECT ConCodOld, CliCod, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (Not (char_length(trim(trailing ' ' from ConCodOld))=0)) ORDER BY CliCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00GE3", "SELECT CliCod, ConFormula, ConCodOld, ConObservacion, ConValorGen, ConDescrip, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00GE4", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?, ConObservacion=?, ConValorGen=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getLongVarchar(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((String[]) buf[4])[0] = rslt.getLongVarchar(4);
               ((java.math.BigDecimal[]) buf[5])[0] = rslt.getBigDecimal(5,4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               ((String[]) buf[7])[0] = rslt.getVarchar(6);
               ((String[]) buf[8])[0] = rslt.getString(7, 10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 2 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setNLongVarchar(2, (String)parms[2], false);
               if ( ((Boolean) parms[3]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[4], 4);
               }
               stmt.setInt(4, ((Number) parms[5]).intValue());
               stmt.setString(5, (String)parms[6], 10);
               return;
      }
   }

}

