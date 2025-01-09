package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class crearconceptoslsd_basesimponibles extends GXProcedure
{
   public crearconceptoslsd_basesimponibles( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( crearconceptoslsd_basesimponibles.class ), "" );
   }

   public crearconceptoslsd_basesimponibles( int remoteHandle ,
                                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public int executeUdp( int aP0 ,
                          short aP1 ,
                          int aP2 ,
                          short[] aP3 )
   {
      crearconceptoslsd_basesimponibles.this.aP4 = new int[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        short[] aP3 ,
                        int[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             short[] aP3 ,
                             int[] aP4 )
   {
      crearconceptoslsd_basesimponibles.this.AV19CliCod = aP0;
      crearconceptoslsd_basesimponibles.this.AV18calc_parm = aP1;
      crearconceptoslsd_basesimponibles.this.AV46ConOrden_parm = aP2;
      crearconceptoslsd_basesimponibles.this.aP3 = aP3;
      crearconceptoslsd_basesimponibles.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV106Pgmname, httpContext.getMessage( "fdsfasfds", "")) ;
      GXt_char1 = AV48palabraconcepto ;
      GXv_char2[0] = GXt_char1 ;
      new web.codigoopeformulasinmayusculas(remoteHandle, context).execute( AV19CliCod, "{concepto}", GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char2[0] ;
      AV48palabraconcepto = GXt_char1 ;
      GXt_char1 = AV53baseImpMaxPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV19CliCod, "[base_imp_max]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char2[0] ;
      AV53baseImpMaxPalabra = GXt_char1 ;
      GXt_char1 = AV72baseImpMinPalabra ;
      GXv_char2[0] = GXt_char1 ;
      new web.getopeclicodigo(remoteHandle, context).execute( AV19CliCod, "[base_imp_min]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char2[0] ;
      AV72baseImpMinPalabra = GXt_char1 ;
      AV11ConOrden = AV46ConOrden_parm ;
      AV17calc = AV18calc_parm ;
      GXt_char1 = AV15baseImpRemTra ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptoporold(remoteHandle, context).execute( AV19CliCod, "2910", GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char2[0] ;
      AV15baseImpRemTra = GXt_char1 ;
      GXt_char1 = AV16baseImpRemVac ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptoporold(remoteHandle, context).execute( AV19CliCod, "2930", GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char2[0] ;
      AV16baseImpRemVac = GXt_char1 ;
      GXt_char1 = AV14baseImpRemSac ;
      GXv_char2[0] = GXt_char1 ;
      new web.getconceptoporold(remoteHandle, context).execute( AV19CliCod, "2950", GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char2[0] ;
      AV14baseImpRemSac = GXt_char1 ;
      GXv_char2[0] = AV95diasProporTopePalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_proporcionar_tope]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV95diasProporTopePalabra = GXv_char2[0] ;
      GXv_char2[0] = AV103diasProporSacPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_proporcionar_sac]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV103diasProporSacPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV82baseImponible1Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_1]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV82baseImponible1Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV84baseImponible2Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_2]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV84baseImponible2Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV85baseImponible3Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_3]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV85baseImponible3Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV88baseImponible4Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_4]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV88baseImponible4Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV83baseImponible5Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_5]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV83baseImponible5Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV89baseImponible6Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_6]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV89baseImponible6Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV90baseImponible7Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_7]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV90baseImponible7Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV91baseImponible8Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_8]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV91baseImponible8Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV92baseImponible9Palabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_9]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV92baseImponible9Palabra = GXv_char2[0] ;
      GXv_char2[0] = AV99topeImponible1SueldoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_1_sueldo]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV99topeImponible1SueldoPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV100topeImponibleSACPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_sac]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV100topeImponibleSACPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV101topeImponibleAdelVacProxPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_imponible_adelantoVac]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV101topeImponibleAdelVacProxPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV86baseDifAPOOSPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_dif_apo_OS_FSR]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV86baseDifAPOOSPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV87baseDifConOSPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[base_dif_con_OS_FSR]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV87baseDifConOSPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV73importeADetraerPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[importe_a_detraer]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV73importeADetraerPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV69diasMesPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_mes]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV69diasMesPalabra = GXv_char2[0] ;
      AV75diasMesPostaPalabra = AV69diasMesPalabra ;
      GXv_char2[0] = AV76diasTrabajadosPostaPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_trabajados_mes]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV76diasTrabajadosPostaPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV70diasSemestrePalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_semestre]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV70diasSemestrePalabra = GXv_char2[0] ;
      GXv_char2[0] = AV93sueldoBrutoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[sueldo_bruto]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV93sueldoBrutoPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV66diasLicienciaPeriodoPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_vacaciones]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV66diasLicienciaPeriodoPalabra = GXv_char2[0] ;
      GXv_char2[0] = AV65diasTrabajadosSemestrePalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[dias_remunerados_semestre]", false, false, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.AV65diasTrabajadosSemestrePalabra = GXv_char2[0] ;
      GXt_char1 = AV62sacConCodigo ;
      GXt_char3 = AV62sacConCodigo ;
      GXv_char2[0] = GXt_char3 ;
      new web.concepto_sac_codigoparam(remoteHandle, context).execute( GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char2[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char3, GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char4[0] ;
      AV62sacConCodigo = GXt_char1 ;
      GXt_char3 = AV63sacProporConCodigo ;
      GXt_char1 = AV63sacProporConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacpropor_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char2[0] ;
      AV63sacProporConCodigo = GXt_char3 ;
      GXt_char3 = AV64vacacionesConCodigo ;
      GXt_char1 = AV64vacacionesConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_adelantovacaciones_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char1 = GXv_char4[0] ;
      GXv_char2[0] = GXt_char3 ;
      new web.getparametro(remoteHandle, context).execute( AV19CliCod, GXt_char1, GXv_char2) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char2[0] ;
      AV64vacacionesConCodigo = GXt_char3 ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV43conceptoSueldoBruto = AV44ConCodigo ;
      GXt_char3 = AV9ConDescrip ;
      GXv_char4[0] = GXt_char3 ;
      new web.getdescripcionremuneracionbruta(remoteHandle, context).execute( AV19CliCod, GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV9ConDescrip = GXt_char3 ;
      AV45ConFormula = AV93sueldoBrutoPalabra ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculootros(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV96DiasProporTopeConCodigo = AV44ConCodigo ;
      AV9ConDescrip = httpContext.getMessage( "DÍAS PARA PROPORCIONAR TOPE", "") ;
      AV45ConFormula = GXutil.trim( AV95diasProporTopePalabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.concepto_diasproportopesueldo_codigoparam(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV102DiasProporSACConCodigo = AV44ConCodigo ;
      AV9ConDescrip = httpContext.getMessage( "DÍAS PARA PROPORCIONAR SAC", "") ;
      AV45ConFormula = GXutil.trim( AV103diasProporSacPalabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtiposac(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.concepto_diasproporsac_codigoparam(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE SAC", "") ;
      AV45ConFormula = GXutil.trim( AV100topeImponibleSACPalabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponibleaportes(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.concepto_topeimponiblesac_codigoparam(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE ADELANTO VACACIONES MES PRÓXIMO", "") ;
      AV45ConFormula = GXutil.trim( AV101topeImponibleAdelVacProxPalabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponibleaportes(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.concepto_topeimponibleadelvac_codigoparam(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV28concepto_BaseDiferencialApoOSYFSR = AV44ConCodigo ;
      AV9ConDescrip = httpContext.getMessage( "Base de cálculo diferencial Aportes OS y FSR", "") ;
      AV74baseImpMaxProporTrabaj = "(" + GXutil.trim( AV53baseImpMaxPalabra) + " / " + GXutil.trim( AV75diasMesPostaPalabra) + ") * " + GXutil.trim( AV76diasTrabajadosPostaPalabra) ;
      AV45ConFormula = GXutil.trim( AV86baseDifAPOOSPalabra) ;
      GXv_char4[0] = AV80horasJornadaPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[horas_jornal]", false, false, GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.AV80horasJornadaPalabra = GXv_char4[0] ;
      GXv_char4[0] = AV81horasJorCompletaPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV19CliCod, "[horas_jornada_completa]", false, false, GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.AV81horasJorCompletaPalabra = GXv_char4[0] ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponibleaportes(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_basedifapoosfsr(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV30concepto_BaseDiferencialContrOSYFSR = AV44ConCodigo ;
      AV9ConDescrip = httpContext.getMessage( "Base de cálculo diferencial Contribución OS y FSR", "") ;
      AV45ConFormula = GXutil.trim( AV87baseDifConOSPalabra) ;
      AV10ConObservacion = httpContext.getMessage( "Pendiente", "") ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponiblecontribucion(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_basedifcontrosfsr(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV33concepto_baseImp1 = AV44ConCodigo ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 1 - Aportes SIPA ", "") ;
      AV45ConFormula = GXutil.trim( AV82baseImponible1Palabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponibleaportes(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV94baseImponible2ConCodigo = AV44ConCodigo ;
      AV34concepto_baseImp2 = AV44ConCodigo ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 2 - CONTRIBUCIONES SIPA e INSSJyP", "") ;
      AV45ConFormula = AV84baseImponible2Palabra ;
      AV10ConObservacion = httpContext.getMessage( "No entiendo porquè en el documento G18-Armado-bases imponibles-LSD.pdf lo junta con el base imponible 3, mas alla de que los 2 son contribuciones me confunde el hecho de si los 2 tienen que considerar las mismas contribuciones, o si esta es solo de SIPA y INSSJyP.", "") ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponiblecontribucion(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible2(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 3 - CONTRIBUCIONES FNE, AAFF, y RENATRE", "") ;
      AV35concepto_baseImp3 = AV44ConCodigo ;
      AV45ConFormula = GXutil.trim( AV85baseImponible3Palabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponiblecontribucion(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible3(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 4 - APORTES OS y FSR", "") ;
      AV36concepto_baseImp4 = AV44ConCodigo ;
      AV45ConFormula = GXutil.trim( AV88baseImponible4Palabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponibleaportes(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible4(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 5 - APORTES INSSJyP", "") ;
      AV37concepto_baseImp5 = AV44ConCodigo ;
      AV45ConFormula = GXutil.trim( AV83baseImponible5Palabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponibleaportes(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible5(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 6 - APORTES DIFERENCIALES", "") ;
      AV45ConFormula = GXutil.trim( AV89baseImponible6Palabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible6(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 7 - APORTES PERSONAL REGIMENES ESPECIALES", "") ;
      AV45ConFormula = AV90baseImponible7Palabra ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible7(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "BASE IMPONIBLE 8 - CONTRIBUCIONES OS y FSR", "") ;
      AV38concepto_baseImp8 = AV44ConCodigo ;
      AV45ConFormula = AV91baseImponible8Palabra ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponiblecontribucion(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible8(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "Base Imponible 9 - Contribuciones LRT", "") ;
      AV39concepto_baseImp9 = AV44ConCodigo ;
      AV45ConFormula = AV92baseImponible9Palabra ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      GXt_char3 = AV13SubTipoConCod2 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipo2baseimponiblecontribucion(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV13SubTipoConCod2 = GXt_char3 ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible9(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      AV17calc = (short)(AV17calc+1) ;
      AV52ConCodigoDetraer = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV44ConCodigo = AV52ConCodigoDetraer ;
      AV9ConDescrip = httpContext.getMessage( "Importe a Detraer", "") ;
      AV45ConFormula = GXutil.trim( AV73importeADetraerPalabra) ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_importeadetraer(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      GXt_int5 = AV11ConOrden ;
      GXv_int6[0] = GXt_int5 ;
      new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
      crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
      AV11ConOrden = (int)(AV11ConOrden+(GXt_int5)) ;
      AV17calc = (short)(AV17calc+1) ;
      AV44ConCodigo = httpContext.getMessage( "CAL", "") + GXutil.padl( GXutil.str( AV17calc, 4, 0), (short)(3), "0") ;
      AV9ConDescrip = httpContext.getMessage( "Base Imponible 10", "") ;
      AV45ConFormula = httpContext.getMessage( "Si([", "") + GXutil.trim( AV48palabraconcepto) + " " + GXutil.trim( AV52ConCodigoDetraer) + "] = 0, 0, [" + GXutil.trim( AV48palabraconcepto) + " " + GXutil.trim( AV94baseImponible2ConCodigo) + "] - [" + GXutil.trim( AV48palabraconcepto) + " " + GXutil.trim( AV52ConCodigoDetraer) + "])" ;
      AV10ConObservacion = "" ;
      GXt_char3 = AV12SubTipoConCod1 ;
      GXv_char4[0] = GXt_char3 ;
      new web.subtipocalculobaseimp(remoteHandle, context).execute( GXv_char4) ;
      crearconceptoslsd_basesimponibles.this.GXt_char3 = GXv_char4[0] ;
      AV12SubTipoConCod1 = GXt_char3 ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = GXutil.trim( AV44ConCodigo) + " - " + GXutil.upper( GXutil.trim( AV9ConDescrip)) ;
      new web.newconcepto(remoteHandle, context).execute( AV19CliCod, AV44ConCodigo, GXutil.upper( AV9ConDescrip), AV47ConTipo, false, (byte)(0), false, AV45ConFormula, DecimalUtil.doubleToDec(0), AV10ConObservacion, false, true, "CAL_ARG", AV12SubTipoConCod1, AV13SubTipoConCod2, "", AV8ConCodYDesc, AV11ConOrden, false, "N", false, false, false) ;
      new web.grabaparametro(remoteHandle, context).execute( AV19CliCod, new web.parametro_concepto_lsd_baseimponible10(remoteHandle, context).executeUdp( ), AV44ConCodigo, "") ;
      /* Using cursor P00HP2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV19CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A148ConFormula = P00HP2_A148ConFormula[0] ;
         n148ConFormula = P00HP2_n148ConFormula[0] ;
         A3CliCod = P00HP2_A3CliCod[0] ;
         A26ConCodigo = P00HP2_A26ConCodigo[0] ;
         if ( GXutil.like( A148ConFormula , GXutil.padr( httpContext.getMessage( "%{baseImponible%", "") , 2000 , "%"),  ' ' ) )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible1}", ""), GXutil.trim( AV33concepto_baseImp1)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible2}", ""), GXutil.trim( AV34concepto_baseImp2)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible3}", ""), GXutil.trim( AV35concepto_baseImp3)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible4}", ""), GXutil.trim( AV36concepto_baseImp4)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible5}", ""), GXutil.trim( AV37concepto_baseImp5)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible8}", ""), GXutil.trim( AV38concepto_baseImp8)) ;
            n148ConFormula = false ;
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{baseImponible9}", ""), GXutil.trim( AV39concepto_baseImp9)) ;
            n148ConFormula = false ;
            /* Using cursor P00HP3 */
            pr_default.execute(1, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A3CliCod), A26ConCodigo});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      /* Using cursor P00HP4 */
      pr_default.execute(2, new Object[] {Integer.valueOf(AV19CliCod)});
      while ( (pr_default.getStatus(2) != 101) )
      {
         A148ConFormula = P00HP4_A148ConFormula[0] ;
         n148ConFormula = P00HP4_n148ConFormula[0] ;
         A3CliCod = P00HP4_A3CliCod[0] ;
         A26ConCodigo = P00HP4_A26ConCodigo[0] ;
         if ( GXutil.like( A148ConFormula , GXutil.padr( httpContext.getMessage( "%{sueldoBruto%", "") , 2000 , "%"),  ' ' ) )
         {
            A148ConFormula = GXutil.strReplace( A148ConFormula, httpContext.getMessage( "{sueldoBruto}", ""), GXutil.trim( AV43conceptoSueldoBruto)) ;
            n148ConFormula = false ;
            /* Using cursor P00HP5 */
            pr_default.execute(3, new Object[] {Boolean.valueOf(n148ConFormula), A148ConFormula, Integer.valueOf(A3CliCod), A26ConCodigo});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         }
         pr_default.readNext(2);
      }
      pr_default.close(2);
      /* Using cursor P00HP6 */
      pr_default.execute(4, new Object[] {Integer.valueOf(AV19CliCod)});
      while ( (pr_default.getStatus(4) != 101) )
      {
         A469ConCodOld = P00HP6_A469ConCodOld[0] ;
         A3CliCod = P00HP6_A3CliCod[0] ;
         A40ConOrden = P00HP6_A40ConOrden[0] ;
         A26ConCodigo = P00HP6_A26ConCodigo[0] ;
         GXt_int5 = A40ConOrden ;
         GXv_int6[0] = GXt_int5 ;
         new web.wwpbaseobjects.ordenintervalo(remoteHandle, context).execute( GXv_int6) ;
         crearconceptoslsd_basesimponibles.this.GXt_int5 = GXv_int6[0] ;
         A40ConOrden = (int)(AV11ConOrden+GXt_int5) ;
         /* Using cursor P00HP7 */
         pr_default.execute(5, new Object[] {Integer.valueOf(A40ConOrden), Integer.valueOf(A3CliCod), A26ConCodigo});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("Concepto");
         pr_default.readNext(4);
      }
      pr_default.close(4);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = crearconceptoslsd_basesimponibles.this.AV17calc;
      this.aP4[0] = crearconceptoslsd_basesimponibles.this.AV11ConOrden;
      Application.commitDataStores(context, remoteHandle, pr_default, "crearconceptoslsd_basesimponibles");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV106Pgmname = "" ;
      AV48palabraconcepto = "" ;
      AV53baseImpMaxPalabra = "" ;
      AV72baseImpMinPalabra = "" ;
      AV15baseImpRemTra = "" ;
      AV16baseImpRemVac = "" ;
      AV14baseImpRemSac = "" ;
      AV95diasProporTopePalabra = "" ;
      AV103diasProporSacPalabra = "" ;
      AV82baseImponible1Palabra = "" ;
      AV84baseImponible2Palabra = "" ;
      AV85baseImponible3Palabra = "" ;
      AV88baseImponible4Palabra = "" ;
      AV83baseImponible5Palabra = "" ;
      AV89baseImponible6Palabra = "" ;
      AV90baseImponible7Palabra = "" ;
      AV91baseImponible8Palabra = "" ;
      AV92baseImponible9Palabra = "" ;
      AV99topeImponible1SueldoPalabra = "" ;
      AV100topeImponibleSACPalabra = "" ;
      AV101topeImponibleAdelVacProxPalabra = "" ;
      AV86baseDifAPOOSPalabra = "" ;
      AV87baseDifConOSPalabra = "" ;
      AV73importeADetraerPalabra = "" ;
      AV69diasMesPalabra = "" ;
      AV75diasMesPostaPalabra = "" ;
      AV76diasTrabajadosPostaPalabra = "" ;
      AV70diasSemestrePalabra = "" ;
      AV93sueldoBrutoPalabra = "" ;
      AV66diasLicienciaPeriodoPalabra = "" ;
      AV65diasTrabajadosSemestrePalabra = "" ;
      AV62sacConCodigo = "" ;
      AV63sacProporConCodigo = "" ;
      AV64vacacionesConCodigo = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      AV44ConCodigo = "" ;
      AV43conceptoSueldoBruto = "" ;
      AV9ConDescrip = "" ;
      AV45ConFormula = "" ;
      AV12SubTipoConCod1 = "" ;
      AV13SubTipoConCod2 = "" ;
      AV8ConCodYDesc = "" ;
      AV10ConObservacion = "" ;
      AV96DiasProporTopeConCodigo = "" ;
      AV102DiasProporSACConCodigo = "" ;
      AV28concepto_BaseDiferencialApoOSYFSR = "" ;
      AV74baseImpMaxProporTrabaj = "" ;
      AV80horasJornadaPalabra = "" ;
      AV81horasJorCompletaPalabra = "" ;
      AV30concepto_BaseDiferencialContrOSYFSR = "" ;
      AV33concepto_baseImp1 = "" ;
      AV94baseImponible2ConCodigo = "" ;
      AV34concepto_baseImp2 = "" ;
      AV35concepto_baseImp3 = "" ;
      AV36concepto_baseImp4 = "" ;
      AV37concepto_baseImp5 = "" ;
      AV38concepto_baseImp8 = "" ;
      AV39concepto_baseImp9 = "" ;
      AV52ConCodigoDetraer = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      scmdbuf = "" ;
      P00HP2_A148ConFormula = new String[] {""} ;
      P00HP2_n148ConFormula = new boolean[] {false} ;
      P00HP2_A3CliCod = new int[1] ;
      P00HP2_A26ConCodigo = new String[] {""} ;
      A148ConFormula = "" ;
      A26ConCodigo = "" ;
      P00HP4_A148ConFormula = new String[] {""} ;
      P00HP4_n148ConFormula = new boolean[] {false} ;
      P00HP4_A3CliCod = new int[1] ;
      P00HP4_A26ConCodigo = new String[] {""} ;
      P00HP6_A469ConCodOld = new String[] {""} ;
      P00HP6_A3CliCod = new int[1] ;
      P00HP6_A40ConOrden = new int[1] ;
      P00HP6_A26ConCodigo = new String[] {""} ;
      A469ConCodOld = "" ;
      GXv_int6 = new int[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.crearconceptoslsd_basesimponibles__default(),
         new Object[] {
             new Object[] {
            P00HP2_A148ConFormula, P00HP2_n148ConFormula, P00HP2_A3CliCod, P00HP2_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P00HP4_A148ConFormula, P00HP4_n148ConFormula, P00HP4_A3CliCod, P00HP4_A26ConCodigo
            }
            , new Object[] {
            }
            , new Object[] {
            P00HP6_A469ConCodOld, P00HP6_A3CliCod, P00HP6_A40ConOrden, P00HP6_A26ConCodigo
            }
            , new Object[] {
            }
         }
      );
      AV106Pgmname = "crearConceptosLSD_BasesImponibles" ;
      /* GeneXus formulas. */
      AV106Pgmname = "crearConceptosLSD_BasesImponibles" ;
      Gx_err = (short)(0) ;
   }

   private byte AV47ConTipo ;
   private short AV18calc_parm ;
   private short AV17calc ;
   private short Gx_err ;
   private int AV19CliCod ;
   private int AV46ConOrden_parm ;
   private int AV11ConOrden ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private int GXt_int5 ;
   private int GXv_int6[] ;
   private String AV106Pgmname ;
   private String AV48palabraconcepto ;
   private String AV53baseImpMaxPalabra ;
   private String AV72baseImpMinPalabra ;
   private String AV15baseImpRemTra ;
   private String AV16baseImpRemVac ;
   private String AV14baseImpRemSac ;
   private String AV95diasProporTopePalabra ;
   private String AV103diasProporSacPalabra ;
   private String AV82baseImponible1Palabra ;
   private String AV84baseImponible2Palabra ;
   private String AV85baseImponible3Palabra ;
   private String AV88baseImponible4Palabra ;
   private String AV83baseImponible5Palabra ;
   private String AV89baseImponible6Palabra ;
   private String AV90baseImponible7Palabra ;
   private String AV91baseImponible8Palabra ;
   private String AV92baseImponible9Palabra ;
   private String AV99topeImponible1SueldoPalabra ;
   private String AV100topeImponibleSACPalabra ;
   private String AV101topeImponibleAdelVacProxPalabra ;
   private String AV86baseDifAPOOSPalabra ;
   private String AV87baseDifConOSPalabra ;
   private String AV73importeADetraerPalabra ;
   private String AV69diasMesPalabra ;
   private String AV75diasMesPostaPalabra ;
   private String AV76diasTrabajadosPostaPalabra ;
   private String AV70diasSemestrePalabra ;
   private String AV93sueldoBrutoPalabra ;
   private String AV66diasLicienciaPeriodoPalabra ;
   private String AV65diasTrabajadosSemestrePalabra ;
   private String AV62sacConCodigo ;
   private String AV63sacProporConCodigo ;
   private String AV64vacacionesConCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String AV44ConCodigo ;
   private String AV43conceptoSueldoBruto ;
   private String AV12SubTipoConCod1 ;
   private String AV13SubTipoConCod2 ;
   private String AV96DiasProporTopeConCodigo ;
   private String AV102DiasProporSACConCodigo ;
   private String AV28concepto_BaseDiferencialApoOSYFSR ;
   private String AV74baseImpMaxProporTrabaj ;
   private String AV80horasJornadaPalabra ;
   private String AV81horasJorCompletaPalabra ;
   private String AV30concepto_BaseDiferencialContrOSYFSR ;
   private String AV33concepto_baseImp1 ;
   private String AV94baseImponible2ConCodigo ;
   private String AV34concepto_baseImp2 ;
   private String AV35concepto_baseImp3 ;
   private String AV36concepto_baseImp4 ;
   private String AV37concepto_baseImp5 ;
   private String AV38concepto_baseImp8 ;
   private String AV39concepto_baseImp9 ;
   private String AV52ConCodigoDetraer ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String A469ConCodOld ;
   private boolean n148ConFormula ;
   private String AV45ConFormula ;
   private String AV10ConObservacion ;
   private String A148ConFormula ;
   private String AV9ConDescrip ;
   private String AV8ConCodYDesc ;
   private int[] aP4 ;
   private short[] aP3 ;
   private IDataStoreProvider pr_default ;
   private String[] P00HP2_A148ConFormula ;
   private boolean[] P00HP2_n148ConFormula ;
   private int[] P00HP2_A3CliCod ;
   private String[] P00HP2_A26ConCodigo ;
   private String[] P00HP4_A148ConFormula ;
   private boolean[] P00HP4_n148ConFormula ;
   private int[] P00HP4_A3CliCod ;
   private String[] P00HP4_A26ConCodigo ;
   private String[] P00HP6_A469ConCodOld ;
   private int[] P00HP6_A3CliCod ;
   private int[] P00HP6_A40ConOrden ;
   private String[] P00HP6_A26ConCodigo ;
}

final  class crearconceptoslsd_basesimponibles__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00HP2", "SELECT ConFormula, CliCod, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00HP3", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00HP4", "SELECT ConFormula, CliCod, ConCodigo FROM Concepto WHERE CliCod = ? ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00HP5", "SAVEPOINT gxupdate;UPDATE Concepto SET ConFormula=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00HP6", "SELECT ConCodOld, CliCod, ConOrden, ConCodigo FROM Concepto WHERE (CliCod = ?) AND (ConCodOld = ( '5050')) ORDER BY CliCod  FOR UPDATE OF Concepto",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00HP7", "SAVEPOINT gxupdate;UPDATE Concepto SET ConOrden=?  WHERE CliCod = ? AND ConCodigo = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getLongVarchar(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((int[]) buf[2])[0] = rslt.getInt(2);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               return;
            case 4 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
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
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 3 :
               if ( ((Boolean) parms[0]).booleanValue() )
               {
                  stmt.setNull( 1 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(1, (String)parms[1]);
               }
               stmt.setInt(2, ((Number) parms[2]).intValue());
               stmt.setString(3, (String)parms[3], 10);
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setString(3, (String)parms[2], 10);
               return;
      }
   }

}

