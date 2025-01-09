package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class f1357 extends GXProcedure
{
   public f1357( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( f1357.class ), "" );
   }

   public f1357( int remoteHandle ,
                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             byte aP4 ,
                             boolean aP5 ,
                             int aP6 ,
                             byte aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             String aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             byte[] aP13 ,
                             java.math.BigDecimal[] aP14 )
   {
      f1357.this.aP15 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
      return aP15[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        byte aP4 ,
                        boolean aP5 ,
                        int aP6 ,
                        byte aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal aP9 ,
                        String aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        byte[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        String[] aP15 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             byte aP4 ,
                             boolean aP5 ,
                             int aP6 ,
                             byte aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal aP9 ,
                             String aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             byte[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             String[] aP15 )
   {
      f1357.this.AV8CliCod = aP0;
      f1357.this.AV12EmpCod = aP1;
      f1357.this.AV148LegnumeroJSON = aP2;
      f1357.this.AV20LiqPeriodo = aP3;
      f1357.this.AV15F1357CTipoPre = aP4;
      f1357.this.AV267simulacionParaAdelanto = aP5;
      f1357.this.AV268parm_LiqNro = aP6;
      f1357.this.AV279AdelantoTipo = aP7;
      f1357.this.AV318remuBrutaEstimadaConDescuento = aP8;
      f1357.this.AV269remuBrutaEstimada = aP9;
      f1357.this.AV322ProcesoLiquidacion = aP10;
      f1357.this.aP11 = aP11;
      f1357.this.aP12 = aP12;
      f1357.this.aP13 = aP13;
      f1357.this.aP14 = aP14;
      f1357.this.aP15 = aP15;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV270LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV161parametroPalabra ;
      GXt_char2 = AV161parametroPalabra ;
      GXv_char3[0] = GXt_char2 ;
      new web.metodorecalculo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      f1357.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      f1357.this.GXt_char1 = GXv_char4[0] ;
      AV161parametroPalabra = GXt_char1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, "1") ;
      AV16Legnumero.fromJSonString(AV148LegnumeroJSON, null);
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, "2") ;
      GXv_char4[0] = "" ;
      GXv_int5[0] = AV9EmpCUIT ;
      GXv_char3[0] = "" ;
      GXv_char6[0] = "" ;
      GXv_char7[0] = "" ;
      GXv_char8[0] = "" ;
      GXv_char9[0] = "" ;
      GXv_char10[0] = "" ;
      new web.getdatosempresa(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, GXv_char4, GXv_int5, GXv_char3, GXv_char6, GXv_char7, GXv_char8, GXv_char9, GXv_char10) ;
      f1357.this.AV9EmpCUIT = GXv_int5[0] ;
      AV13F1357CCuitAgente = GXutil.trim( GXutil.str( AV9EmpCUIT, 11, 0)) ;
      AV10F1357CPer = GXutil.trim( GXutil.str( GXutil.year( AV20LiqPeriodo), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( AV20LiqPeriodo), 10, 0), (short)(2), "0") ;
      AV28LiqPerAno = (short)(GXutil.year( AV20LiqPeriodo)) ;
      GXv_char10[0] = AV320SueldoSinSacConCodigo ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).executeUdp( ), GXv_char10) ;
      f1357.this.AV320SueldoSinSacConCodigo = GXv_char10[0] ;
      GXt_char2 = AV311anticiposDeSacConCodigo ;
      GXt_char1 = AV311anticiposDeSacConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV311anticiposDeSacConCodigo = GXt_char2 ;
      GXt_char2 = AV312sacLiquidadoConCodigo ;
      GXt_char1 = AV312sacLiquidadoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_sacliquidadoperiodo_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV312sacLiquidadoConCodigo = GXt_char2 ;
      GXt_char2 = AV285baseImponible1ConCodigo ;
      GXt_char1 = AV285baseImponible1ConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.parametro_concepto_lsd_baseimponible1(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV285baseImponible1ConCodigo = GXt_char2 ;
      GXt_char2 = AV246sacConCodigo ;
      GXt_char1 = AV246sacConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_sac_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV246sacConCodigo = GXt_char2 ;
      GXt_char2 = AV245SacProporConCodigo ;
      GXt_char1 = AV245SacProporConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_sacpropor_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV245SacProporConCodigo = GXt_char2 ;
      GXt_char2 = AV262descuentosSobreGravadoConCodigo ;
      GXt_char1 = AV262descuentosSobreGravadoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_descuentosleymasdescsobreanticiposac_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV262descuentosSobreGravadoConCodigo = GXt_char2 ;
      GXt_char2 = AV287remuneracionGravadaConCodigo ;
      GXt_char1 = AV287remuneracionGravadaConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.remuneraciongravada_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV287remuneracionGravadaConCodigo = GXt_char2 ;
      GXt_char2 = AV44bonosprod_DSubTipoConCod1 ;
      GXv_char10[0] = GXt_char2 ;
      new web.subtipopremio(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV44bonosprod_DSubTipoConCod1 = GXt_char2 ;
      GXt_char2 = AV45bonosprod_DSubTipoConCod2 ;
      GXv_char10[0] = GXt_char2 ;
      new web.conceptoafipbonoproductividad(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV45bonosprod_DSubTipoConCod2 = GXt_char2 ;
      GXt_char2 = AV222remuEspecial_DSubTipoConCod1 ;
      GXv_char10[0] = GXt_char2 ;
      new web.subtiponre_especiales(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV222remuEspecial_DSubTipoConCod1 = GXt_char2 ;
      GXt_char2 = AV223movvia_DSubTipoConCod2 ;
      GXv_char10[0] = GXt_char2 ;
      new web.subtipo2movyvia(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV223movvia_DSubTipoConCod2 = GXt_char2 ;
      GXt_char2 = AV225docentes_DSubTipoConCod2 ;
      GXv_char10[0] = GXt_char2 ;
      new web.subtipo2docmatdid(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV225docentes_DSubTipoConCod2 = GXt_char2 ;
      GXt_char2 = AV227copmenTeletrab_DSubTipoConCod2 ;
      GXv_char10[0] = GXt_char2 ;
      new web.subtipo2compenteletrabajo(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV227copmenTeletrab_DSubTipoConCod2 = GXt_char2 ;
      GXt_char2 = AV118dedEspecialIncrementadaConCodigo ;
      GXt_char1 = AV118dedEspecialIncrementadaConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_deduccionespecialincrementada_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV118dedEspecialIncrementadaConCodigo = GXt_char2 ;
      GXt_char2 = AV167otroEmplOSConCodigo ;
      GXt_char1 = AV167otroEmplOSConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.otroemplos_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV167otroEmplOSConCodigo = GXt_char2 ;
      GXt_char2 = AV188otroEmplSegSocConCodigo ;
      GXt_char1 = AV188otroEmplSegSocConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.otroemplsegsoc_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV188otroEmplSegSocConCodigo = GXt_char2 ;
      GXt_char2 = AV187otroEmplSindicatoConCodigo ;
      GXt_char1 = AV187otroEmplSindicatoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.otroemplsindicato_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV187otroEmplSindicatoConCodigo = GXt_char2 ;
      GXt_char2 = AV198OtrosEmplSACConCodigo ;
      GXt_char1 = AV198OtrosEmplSACConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.otroemplsac_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV198OtrosEmplSACConCodigo = GXt_char2 ;
      GXt_char2 = AV200otroEmplNoHabConCodigo ;
      GXt_char1 = AV200otroEmplNoHabConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.otroemplretrnohab_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV200otroEmplNoHabConCodigo = GXt_char2 ;
      GXt_char2 = AV191alcanzaGananciasConCodigo ;
      GXt_char1 = AV191alcanzaGananciasConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV191alcanzaGananciasConCodigo = GXt_char2 ;
      GXt_char2 = AV140pagosACuentaConCodigo ;
      GXt_char1 = AV140pagosACuentaConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV140pagosACuentaConCodigo = GXt_char2 ;
      GXt_char2 = AV137retencionConCodigo ;
      GXt_char1 = AV137retencionConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV137retencionConCodigo = GXt_char2 ;
      GXt_char2 = AV259adelantoRetencionConCodigo ;
      GXt_char1 = AV259adelantoRetencionConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.adelantoretencionganancias_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV259adelantoRetencionConCodigo = GXt_char2 ;
      GXt_char2 = AV29sacGravadoConCodigo ;
      GXt_char1 = AV29sacGravadoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_sacgravado_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV29sacGravadoConCodigo = GXt_char2 ;
      GXt_char2 = AV40sacExentoConCodigo ;
      GXt_char1 = AV40sacExentoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_sacexento_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV40sacExentoConCodigo = GXt_char2 ;
      GXt_char2 = AV219ExenExtConCodigo ;
      GXt_char1 = AV219ExenExtConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_horasextrasexentas_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV219ExenExtConCodigo = GXt_char2 ;
      GXt_char2 = AV46bonosExentosConCodigo ;
      GXt_char1 = AV46bonosExentosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_bonosexentos_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV46bonosExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV304fallosCajaExentosConCodigo ;
      GXt_char1 = AV304fallosCajaExentosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_falloscajaexentos_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV304fallosCajaExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV305simNatExentosConCodigo ;
      GXt_char1 = AV305simNatExentosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_simnatexenta_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV305simNatExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV220movviaExentosConCodigo ;
      GXt_char1 = AV220movviaExentosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_movviaexentos_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV220movviaExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV221perDocMatExentosConCodigo ;
      GXt_char1 = AV221perDocMatExentosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_perdocmatexentos_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV221perDocMatExentosConCodigo = GXt_char2 ;
      GXt_char2 = AV58primaSeguroConCodigo ;
      GXt_char1 = AV58primaSeguroConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedprimasegucodigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV58primaSeguroConCodigo = GXt_char2 ;
      GXt_char2 = AV164primasMixtosConCodigo ;
      GXt_char1 = AV164primasMixtosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.primasmixtos_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV164primasMixtosConCodigo = GXt_char2 ;
      GXt_char2 = AV61retiroPrivadoConCodigo ;
      GXt_char1 = AV61retiroPrivadoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedsegureti_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV61retiroPrivadoConCodigo = GXt_char2 ;
      GXt_char2 = AV165cuotapartesConCodigo ;
      GXt_char1 = AV165cuotapartesConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.cuotapartes_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV165cuotapartesConCodigo = GXt_char2 ;
      GXt_char2 = AV65sepelioConCodigo ;
      GXt_char1 = AV65sepelioConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedsepelio_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV65sepelioConCodigo = GXt_char2 ;
      GXt_char2 = AV68vehiculosConCodigo ;
      GXt_char1 = AV68vehiculosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_vehicorre_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV68vehiculosConCodigo = GXt_char2 ;
      GXt_char2 = AV72hipotecaConCodigo ;
      GXt_char1 = AV72hipotecaConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedcredhipoteca_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV72hipotecaConCodigo = GXt_char2 ;
      GXt_char2 = AV75aportesSGRConCodigo ;
      GXt_char1 = AV75aportesSGRConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedrecipro_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV75aportesSGRConCodigo = GXt_char2 ;
      GXt_char2 = AV78personalDomesticoConCodigo ;
      GXt_char1 = AV78personalDomesticoConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_deddome_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV78personalDomesticoConCodigo = GXt_char2 ;
      GXt_char2 = AV291educativosConCodigo ;
      GXt_char1 = AV291educativosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.gastosdeeducacion_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV291educativosConCodigo = GXt_char2 ;
      GXt_char2 = AV80alquilerConCodigo ;
      GXt_char1 = AV80alquilerConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedalquiler_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV80alquilerConCodigo = GXt_char2 ;
      GXt_char2 = AV82viaticosConCodigo ;
      GXt_char1 = AV82viaticosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedviaticorre_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV82viaticosConCodigo = GXt_char2 ;
      GXt_char2 = AV84induConCodigo ;
      GXt_char1 = AV84induConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedindumentaria_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV84induConCodigo = GXt_char2 ;
      GXt_char2 = AV162otrasDeduccionesConCodigo ;
      GXt_char1 = AV162otrasDeduccionesConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.otrasdeducciones_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV162otrasDeduccionesConCodigo = GXt_char2 ;
      GXt_char2 = AV91donacionesConCodigo ;
      GXt_char1 = AV91donacionesConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_deddonaciones_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV91donacionesConCodigo = GXt_char2 ;
      GXt_char2 = AV90honorariosMedicosConCodigo ;
      GXt_char1 = AV90honorariosMedicosConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_honomedi_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV90honorariosMedicosConCodigo = GXt_char2 ;
      GXt_char2 = AV93prepagaConCodigo ;
      GXt_char1 = AV93prepagaConCodigo ;
      GXv_char10[0] = GXt_char1 ;
      new web.concepto_dedprepaga_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV93prepagaConCodigo = GXt_char2 ;
      GXt_char2 = "" ;
      GXv_char10[0] = GXt_char2 ;
      new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[alicuota_donaciones]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV87alicuotaDonaciones = CommonUtil.decimalVal( GXt_char2, ".") ;
      GXt_char2 = "" ;
      GXv_char10[0] = GXt_char2 ;
      new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[limite_medicos]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV89limiteMedicos = CommonUtil.decimalVal( GXt_char2, ".") ;
      GXt_char2 = "" ;
      GXv_char10[0] = GXt_char2 ;
      new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[limite_prepaga]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
      f1357.this.GXt_char2 = GXv_char10[0] ;
      AV94limitePrepaga = CommonUtil.decimalVal( GXt_char2, ".") ;
      if ( ! AV267simulacionParaAdelanto )
      {
         /* Using cursor P00UO2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Byte.valueOf(AV15F1357CTipoPre), AV10F1357CPer});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A777F1357CPer = P00UO2_A777F1357CPer[0] ;
            A784F1357CTipoPre = P00UO2_A784F1357CTipoPre[0] ;
            A1EmpCod = P00UO2_A1EmpCod[0] ;
            A3CliCod = P00UO2_A3CliCod[0] ;
            A778F1357CSec = P00UO2_A778F1357CSec[0] ;
            AV11F1357CSec = A778F1357CSec ;
            AV14hay = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV14hay )
         {
            AV11F1357CSec = (byte)(AV11F1357CSec+1) ;
         }
         /*
            INSERT RECORD ON TABLE F1357Cab

         */
         A3CliCod = AV8CliCod ;
         A1EmpCod = AV12EmpCod ;
         A784F1357CTipoPre = AV15F1357CTipoPre ;
         A777F1357CPer = AV10F1357CPer ;
         A778F1357CSec = AV11F1357CSec ;
         A780F1357CCuitAgente = AV13F1357CCuitAgente ;
         A781F1357CCodImp = "0103" ;
         A782F1357CCodCon = "215" ;
         A783F1357CNumForm = "1357" ;
         A785F1357CVerSis = "00500" ;
         /* Using cursor P00UO3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), A780F1357CCuitAgente, A781F1357CCodImp, A782F1357CCodCon, A783F1357CNumForm, A785F1357CVerSis});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Cab");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, "3") ;
      GXt_char2 = AV197egresoTLiqCod ;
      GXt_char1 = AV197egresoTLiqCod ;
      GXv_char10[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV197egresoTLiqCod = GXt_char2 ;
      GXt_char2 = AV256mensualTliqCod ;
      GXt_char1 = AV256mensualTliqCod ;
      GXv_char10[0] = GXt_char1 ;
      new web.tipoliqmensual_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV256mensualTliqCod = GXt_char2 ;
      GXt_char2 = AV258aguTliqCod ;
      GXt_char1 = AV258aguTliqCod ;
      GXv_char10[0] = GXt_char1 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV258aguTliqCod = GXt_char2 ;
      GXt_char2 = AV257vacTLiqCod ;
      GXt_char1 = AV257vacTLiqCod ;
      GXv_char10[0] = GXt_char1 ;
      new web.tipoliqvacaciones_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV257vacTLiqCod = GXt_char2 ;
      AV17i = (short)(1) ;
      while ( AV17i <= AV16Legnumero.size() )
      {
         AV127LiqNro = 0 ;
         AV323auxLegNumero = ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() ;
         pr_default.dynParam(2, new Object[]{ new Object[]{
                                              Byte.valueOf(AV15F1357CTipoPre) ,
                                              A32TLiqCod ,
                                              AV197egresoTLiqCod ,
                                              Integer.valueOf(A2112LiqRelNro) ,
                                              Integer.valueOf(AV8CliCod) ,
                                              Short.valueOf(AV12EmpCod) ,
                                              Integer.valueOf(AV323auxLegNumero) ,
                                              AV20LiqPeriodo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              A283LiqPeriodo } ,
                                              new int[]{
                                              TypeConstants.BYTE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.DATE
                                              }
         });
         /* Using cursor P00UO4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV323auxLegNumero), AV20LiqPeriodo, AV197egresoTLiqCod, AV197egresoTLiqCod});
         while ( (pr_default.getStatus(2) != 101) )
         {
            A2112LiqRelNro = P00UO4_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P00UO4_n2112LiqRelNro[0] ;
            A32TLiqCod = P00UO4_A32TLiqCod[0] ;
            n32TLiqCod = P00UO4_n32TLiqCod[0] ;
            A283LiqPeriodo = P00UO4_A283LiqPeriodo[0] ;
            A6LegNumero = P00UO4_A6LegNumero[0] ;
            A1EmpCod = P00UO4_A1EmpCod[0] ;
            A3CliCod = P00UO4_A3CliCod[0] ;
            A31LiqNro = P00UO4_A31LiqNro[0] ;
            A2112LiqRelNro = P00UO4_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P00UO4_n2112LiqRelNro[0] ;
            AV127LiqNro = A31LiqNro ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(2);
         }
         pr_default.close(2);
         AV55F1357_DeduccionesGeneralesOtrosEmpleos = (web.SdtF1357_DeduccionesGenerales)new web.SdtF1357_DeduccionesGenerales(remoteHandle, context);
         AV54F1357_DeduccionesGenerales = (web.SdtF1357_DeduccionesGenerales)new web.SdtF1357_DeduccionesGenerales(remoteHandle, context);
         if ( AV15F1357CTipoPre == 3 )
         {
            GXt_int11 = AV205mesesAnio ;
            GXv_int12[0] = GXt_int11 ;
            new web.mesesanio(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, GXv_int12) ;
            f1357.this.GXt_int11 = GXv_int12[0] ;
            AV205mesesAnio = (byte)(GXt_int11) ;
            AV103cantMesesTributados = (short)(GXutil.month( AV20LiqPeriodo)) ;
         }
         else
         {
            AV205mesesAnio = (byte)(12) ;
            AV103cantMesesTributados = (short)(12) ;
         }
         AV250sdt_liquidacion.clear();
         AV192LiquidacionesSujetas.clear();
         /* Using cursor P00UO5 */
         pr_default.execute(3, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV323auxLegNumero)});
         while ( (pr_default.getStatus(3) != 101) )
         {
            brkUO5 = false ;
            A31LiqNro = P00UO5_A31LiqNro[0] ;
            A283LiqPeriodo = P00UO5_A283LiqPeriodo[0] ;
            A6LegNumero = P00UO5_A6LegNumero[0] ;
            A1EmpCod = P00UO5_A1EmpCod[0] ;
            A3CliCod = P00UO5_A3CliCod[0] ;
            A2112LiqRelNro = P00UO5_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P00UO5_n2112LiqRelNro[0] ;
            A2112LiqRelNro = P00UO5_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P00UO5_n2112LiqRelNro[0] ;
            AV250sdt_liquidacion.clear();
            while ( (pr_default.getStatus(3) != 101) && ( P00UO5_A3CliCod[0] == A3CliCod ) && ( P00UO5_A1EmpCod[0] == A1EmpCod ) && ( P00UO5_A6LegNumero[0] == A6LegNumero ) && GXutil.dateCompare(GXutil.resetTime(P00UO5_A283LiqPeriodo[0]), GXutil.resetTime(A283LiqPeriodo)) )
            {
               brkUO5 = false ;
               A31LiqNro = P00UO5_A31LiqNro[0] ;
               AV251itemLiquidacion = (web.Sdtsdt_liquidacion_sdt_liquidacionItem)new web.Sdtsdt_liquidacion_sdt_liquidacionItem(remoteHandle, context);
               AV251itemLiquidacion.setgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro( A31LiqNro );
               AV250sdt_liquidacion.add(AV251itemLiquidacion, 0);
               brkUO5 = true ;
               pr_default.readNext(3);
            }
            GXv_decimal13[0] = DecimalUtil.doubleToDec(AV307alcanza_ganancias) ;
            GXv_boolean14[0] = false ;
            GXv_int15[0] = (byte)(0) ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, A31LiqNro, A6LegNumero, AV191alcanzaGananciasConCodigo, AV322ProcesoLiquidacion, false, GXv_decimal13, GXv_boolean14, GXv_int15) ;
            f1357.this.AV307alcanza_ganancias = (short)(DecimalUtil.decToDouble(GXv_decimal13[0])) ;
            if ( AV307alcanza_ganancias == 0 )
            {
               AV342GXV1 = 1 ;
               while ( AV342GXV1 <= AV250sdt_liquidacion.size() )
               {
                  AV251itemLiquidacion = (web.Sdtsdt_liquidacion_sdt_liquidacionItem)((web.Sdtsdt_liquidacion_sdt_liquidacionItem)AV250sdt_liquidacion.elementAt(-1+AV342GXV1));
                  AV193LiquidacionesNoSujetas.add((int)(AV251itemLiquidacion.getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro()), 0);
                  AV342GXV1 = (int)(AV342GXV1+1) ;
               }
            }
            else
            {
               AV343GXV2 = 1 ;
               while ( AV343GXV2 <= AV250sdt_liquidacion.size() )
               {
                  AV251itemLiquidacion = (web.Sdtsdt_liquidacion_sdt_liquidacionItem)((web.Sdtsdt_liquidacion_sdt_liquidacionItem)AV250sdt_liquidacion.elementAt(-1+AV343GXV2));
                  AV192LiquidacionesSujetas.add((int)(AV251itemLiquidacion.getgxTv_Sdtsdt_liquidacion_sdt_liquidacionItem_Liqnro()), 0);
                  AV343GXV2 = (int)(AV343GXV2+1) ;
               }
            }
            if ( ! brkUO5 )
            {
               brkUO5 = true ;
               pr_default.readNext(3);
            }
         }
         pr_default.close(3);
         if ( AV267simulacionParaAdelanto )
         {
            AV192LiquidacionesSujetas.add((int)(AV268parm_LiqNro), 0);
         }
         GXt_char2 = "" ;
         GXv_char10[0] = GXt_char2 ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[tope_seguros]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
         f1357.this.GXt_char2 = GXv_char10[0] ;
         AV62topeSeguros = CommonUtil.decimalVal( GXt_char2, ".") ;
         GXt_char2 = "" ;
         GXv_char10[0] = GXt_char2 ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[tope_sepelio]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
         f1357.this.GXt_char2 = GXv_char10[0] ;
         AV66topeSepelios = CommonUtil.decimalVal( GXt_char2, ".") ;
         GXt_char2 = "" ;
         GXv_char10[0] = GXt_char2 ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[tope_hipoteca]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
         f1357.this.GXt_char2 = GXv_char10[0] ;
         AV71topeHipoteca = CommonUtil.decimalVal( GXt_char2, ".") ;
         GXt_char2 = "" ;
         GXv_char10[0] = GXt_char2 ;
         new web.getopeclivalor_sinvalidar(remoteHandle, context).execute( AV8CliCod, "[mni]", AV20LiqPeriodo, AV322ProcesoLiquidacion, GXv_char10) ;
         f1357.this.GXt_char2 = GXv_char10[0] ;
         AV201mniParaTopes = CommonUtil.decimalVal( GXt_char2, ".") ;
         GXv_decimal13[0] = AV326mniAnual ;
         GXv_char10[0] = AV334auxerror ;
         new web.articulo30conaumentoporzona(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, "[mni_zona]", AV322ProcesoLiquidacion, GXv_decimal13, GXv_char10) ;
         f1357.this.AV326mniAnual = GXv_decimal13[0] ;
         f1357.this.AV334auxerror = GXv_char10[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "1 auxerror ", "")+GXutil.trim( AV334auxerror)) ;
         AV325mniX1 = (AV326mniAnual.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&&mniAnual ", "")+GXutil.trim( GXutil.str( AV326mniAnual, 14, 2))+httpContext.getMessage( " &cantMesesTributados ", "")+GXutil.trim( GXutil.str( AV103cantMesesTributados, 4, 0))+httpContext.getMessage( " &mniX1 ", "")+GXutil.trim( GXutil.str( AV325mniX1, 14, 2))) ;
         GXv_decimal13[0] = AV204ZonPorcAumenDed ;
         new web.getaumentoporzona(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), GXv_decimal13) ;
         f1357.this.AV204ZonPorcAumenDed = GXv_decimal13[0] ;
         GXv_decimal13[0] = AV327F1357LDPEspecialAnual ;
         GXv_char10[0] = AV334auxerror ;
         new web.articulo30conaumentoporzona(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, "[ded_especial_zona]", AV322ProcesoLiquidacion, GXv_decimal13, GXv_char10) ;
         f1357.this.AV327F1357LDPEspecialAnual = GXv_decimal13[0] ;
         f1357.this.AV334auxerror = GXv_char10[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "2 auxerror ", "")+GXutil.trim( AV334auxerror)) ;
         AV330F1357LDPEspecialX1 = (AV327F1357LDPEspecialAnual.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)) ;
         GXv_decimal13[0] = AV328F1357LDPConyugeAnual ;
         GXv_char10[0] = AV334auxerror ;
         new web.articulo30conaumentoporzona(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, "[ded_cony_zona]", AV322ProcesoLiquidacion, GXv_decimal13, GXv_char10) ;
         f1357.this.AV328F1357LDPConyugeAnual = GXv_decimal13[0] ;
         f1357.this.AV334auxerror = GXv_char10[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "3 auxerror ", "")+GXutil.trim( AV334auxerror)) ;
         AV329F1357LDPConyugeX1 = (AV328F1357LDPConyugeAnual.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)) ;
         GXv_decimal13[0] = AV344Ded_hijoanual ;
         GXv_char10[0] = AV334auxerror ;
         new web.articulo30conaumentoporzona(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, "[ded_hijo_zona]", AV322ProcesoLiquidacion, GXv_decimal13, GXv_char10) ;
         f1357.this.AV344Ded_hijoanual = GXv_decimal13[0] ;
         f1357.this.AV334auxerror = GXv_char10[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "4 auxerror ", "")+GXutil.trim( AV334auxerror)) ;
         AV331ded_hijoX1 = (AV344Ded_hijoanual.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)) ;
         GXv_decimal13[0] = AV332ded_hijo_incapAnual ;
         GXv_char10[0] = AV334auxerror ;
         new web.articulo30conaumentoporzona(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, "[ded_hijo_incap_zona]", AV322ProcesoLiquidacion, GXv_decimal13, GXv_char10) ;
         f1357.this.AV332ded_hijo_incapAnual = GXv_decimal13[0] ;
         f1357.this.AV334auxerror = GXv_char10[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "5 auxerror ", "")+GXutil.trim( AV334auxerror)) ;
         AV333ded_hijo_incapX1 = (short)(DecimalUtil.decToDouble((AV332ded_hijo_incapAnual.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)))) ;
         GXv_char10[0] = AV151deduce_conyugeChar ;
         new web.deduceconyuge(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), GXv_char10) ;
         f1357.this.AV151deduce_conyugeChar = GXv_char10[0] ;
         AV150deduce_conyuge = (short)(GXutil.lval( AV151deduce_conyugeChar)) ;
         GXv_int12[0] = (short)(DecimalUtil.decToDouble(AV105F1357LDPCantHijos)) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), false, AV20LiqPeriodo, (short)(0), (short)(18), DecimalUtil.stringToDec("0.5"), GXv_int12) ;
         f1357.this.AV105F1357LDPCantHijos = DecimalUtil.doubleToDec(GXv_int12[0]) ;
         GXv_int12[0] = (short)(DecimalUtil.decToDouble(DecimalUtil.stringToDec("0.5"))) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), true, AV20LiqPeriodo, (short)(0), (short)(0), DecimalUtil.doubleToDec(18), GXv_int12) ;
         GXv_int12[0] = (short)(DecimalUtil.decToDouble(AV292F1357LDPCantHij100PC)) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), false, AV20LiqPeriodo, (short)(0), (short)(18), DecimalUtil.doubleToDec(1), GXv_int12) ;
         f1357.this.AV292F1357LDPCantHij100PC = DecimalUtil.doubleToDec(GXv_int12[0]) ;
         GXv_int12[0] = (short)(1) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), true, AV20LiqPeriodo, (short)(0), (short)(0), DecimalUtil.doubleToDec(18), GXv_int12) ;
         GXv_int12[0] = (short)(DecimalUtil.decToDouble(AV294F1357LDPcantHijMay18)) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), false, AV20LiqPeriodo, (short)(19), (short)(24), DecimalUtil.stringToDec("0.5"), GXv_int12) ;
         f1357.this.AV294F1357LDPcantHijMay18 = DecimalUtil.doubleToDec(GXv_int12[0]) ;
         GXv_int12[0] = (short)(1) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), false, AV20LiqPeriodo, (short)(0), (short)(19), DecimalUtil.doubleToDec(24), GXv_int12) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, "4") ;
         GXv_date16[0] = AV163LegFecIngreso ;
         new web.getfecingreso(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), GXv_date16) ;
         f1357.this.AV163LegFecIngreso = GXv_date16[0] ;
         if ( ( GXutil.year( AV163LegFecIngreso) == AV28LiqPerAno ) && ( GXutil.month( AV163LegFecIngreso) == GXutil.month( AV20LiqPeriodo) ) )
         {
            AV21diaInicio = GXutil.padl( GXutil.str( GXutil.day( AV163LegFecIngreso), 10, 0), (short)(2), "0") ;
         }
         else
         {
            AV21diaInicio = "01" ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "antes de crear leg &F1357CTipoPre ", "")+GXutil.trim( GXutil.str( AV15F1357CTipoPre, 1, 0))) ;
         AV47gananciaNeta = DecimalUtil.ZERO ;
         if ( ! AV267simulacionParaAdelanto )
         {
            /*
               INSERT RECORD ON TABLE F1357Leg

            */
            A3CliCod = AV8CliCod ;
            A1EmpCod = AV12EmpCod ;
            A784F1357CTipoPre = AV15F1357CTipoPre ;
            A777F1357CPer = AV10F1357CPer ;
            A778F1357CSec = AV11F1357CSec ;
            A6LegNumero = ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() ;
            A786F1357LTipoReg = "02" ;
            A787F1357LCuil = GXutil.trim( GXutil.str( AV19LegCUIL, 11, 0)) ;
            A788F1357LPerDesd = GXutil.trim( GXutil.str( GXutil.year( AV20LiqPeriodo), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( AV20LiqPeriodo), 10, 0), (short)(2), "0") + GXutil.trim( AV21diaInicio) ;
            A789F1357LPerHas = GXutil.trim( GXutil.str( GXutil.year( AV20LiqPeriodo), 10, 0)) + GXutil.padl( GXutil.str( GXutil.month( AV20LiqPeriodo), 10, 0), (short)(2), "0") + GXutil.padl( GXutil.str( GXutil.day( GXutil.eomdate( AV20LiqPeriodo)), 10, 0), (short)(2), "0") ;
            A790F1357LMeses = GXutil.padl( GXutil.str( GXutil.month( AV20LiqPeriodo), 10, 0), (short)(2), "0") ;
            if ( DecimalUtil.compareTo(AV204ZonPorcAumenDed, new web.aumentodedzonapatagonica(remoteHandle, context).executeUdp( AV8CliCod)) == 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               A791F1357LBeneficio = (byte)(2) ;
            }
            else
            {
               A791F1357LBeneficio = (byte)(1) ;
            }
            A792F1357LLargaDist = "0" ;
            A793F1357LLey27424 = "0" ;
            A795F1357LTeletrabajo = "0" ;
            A796F1357LMilitar = "0" ;
            A943F1357LLargaDistCT_40_1989 = "0" ;
            A794F1357L27549 = "0" ;
            /* Using cursor P00UO6 */
            pr_default.execute(4, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A786F1357LTipoReg, A787F1357LCuil, A788F1357LPerDesd, A789F1357LPerHas, A790F1357LMeses, Byte.valueOf(A791F1357LBeneficio), A792F1357LLargaDist, A793F1357LLey27424, A794F1357L27549, A795F1357LTeletrabajo, A796F1357LMilitar, A943F1357LLargaDistCT_40_1989});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357Leg");
            if ( (pr_default.getStatus(4) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "despues de crear leg &F1357CTipoPre ", "")+GXutil.trim( GXutil.str( AV15F1357CTipoPre, 1, 0))) ;
         AV48remuneracionGravadaTotal = DecimalUtil.ZERO ;
         AV49remuneracionExentaTotal = DecimalUtil.ZERO ;
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV167otroEmplOSConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV55F1357_DeduccionesGeneralesOtrosEmpleos.setgxTv_SdtF1357_DeduccionesGenerales_Os( GXt_decimal17 );
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV188otroEmplSegSocConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV55F1357_DeduccionesGeneralesOtrosEmpleos.setgxTv_SdtF1357_DeduccionesGenerales_Jub( GXt_decimal17 );
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV187otroEmplSindicatoConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV55F1357_DeduccionesGeneralesOtrosEmpleos.setgxTv_SdtF1357_DeduccionesGenerales_Cuotasin( GXt_decimal17 );
         AV50F1357_RemuneracionOtrosEmpleos = (web.SdtF1357_Remuneracion)new web.SdtF1357_Remuneracion(remoteHandle, context);
         AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Exenley27549( DecimalUtil.doubleToDec(0) );
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV200otroEmplNoHabConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Nohabgra( GXt_decimal17 );
         if ( GXutil.month( AV20LiqPeriodo) >= 6 )
         {
            AV199sacLiqPeriodo = localUtil.ymdtod( GXutil.year( AV20LiqPeriodo), 6, 1) ;
            AV199sacLiqPeriodo = GXutil.eomdate( AV199sacLiqPeriodo) ;
            GXt_decimal17 = DecimalUtil.ZERO ;
            GXv_boolean14[0] = false ;
            GXv_decimal13[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV199sacLiqPeriodo, AV198OtrosEmplSACConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
            f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
            AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Saccuo1gra( GXt_decimal17 );
            if ( GXutil.month( AV20LiqPeriodo) == 12 )
            {
               AV199sacLiqPeriodo = localUtil.ymdtod( GXutil.year( AV20LiqPeriodo), 12, 31) ;
               GXt_decimal17 = DecimalUtil.ZERO ;
               GXv_boolean14[0] = false ;
               GXv_decimal13[0] = GXt_decimal17 ;
               new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV199sacLiqPeriodo, AV198OtrosEmplSACConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
               f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
               AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Saccuo2gra( GXt_decimal17 );
            }
         }
         GXt_char2 = AV186otroEmplGananciaBrutaConCodigo ;
         GXt_char1 = AV186otroEmplGananciaBrutaConCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.otroemplgananciabruta_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         f1357.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
         f1357.this.GXt_char2 = GXv_char9[0] ;
         AV186otroEmplGananciaBrutaConCodigo = GXt_char2 ;
         GXt_char2 = AV183otroEmplhorasExtrasGravadasCodigo ;
         GXt_char1 = AV183otroEmplhorasExtrasGravadasCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.otroemplhorasextrasgravadas_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         f1357.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
         f1357.this.GXt_char2 = GXv_char9[0] ;
         AV183otroEmplhorasExtrasGravadasCodigo = GXt_char2 ;
         GXt_char2 = AV182otroEmplhorasExtrasExentasCodigo ;
         GXt_char1 = AV182otroEmplhorasExtrasExentasCodigo ;
         GXv_char10[0] = GXt_char1 ;
         new web.otroemplhorasextrasexentas_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         f1357.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
         f1357.this.GXt_char2 = GXv_char9[0] ;
         AV182otroEmplhorasExtrasExentasCodigo = GXt_char2 ;
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV186otroEmplGananciaBrutaConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Brugra( GXt_decimal17 );
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV183otroEmplhorasExtrasGravadasCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Horextgra( GXt_decimal17 );
         GXt_decimal17 = DecimalUtil.ZERO ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV182otroEmplhorasExtrasExentasCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV50F1357_RemuneracionOtrosEmpleos.setgxTv_SdtF1357_Remuneracion_Exenext( GXt_decimal17 );
         /* Execute user subroutine: 'REMUNERACIONES' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV48remuneracionGravadaTotal = AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Brugra() ;
         AV315LiqDLog += httpContext.getMessage( "Inicializa &remuneracionGravadaTotal con ", "") + GXutil.trim( GXutil.str( AV48remuneracionGravadaTotal, 16, 2)) ;
         if ( ! AV267simulacionParaAdelanto )
         {
            AV48remuneracionGravadaTotal = AV48remuneracionGravadaTotal.add((AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Nohabgra().add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Saccuo1gra()))) ;
            AV48remuneracionGravadaTotal = AV48remuneracionGravadaTotal.add((AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Saccuo2gra().add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Horextgra()).add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Movviagra()).add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Docengra()))) ;
            AV48remuneracionGravadaTotal = AV48remuneracionGravadaTotal.add((AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Brugra().add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Nohabgra()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Saccuo1gra()))) ;
            AV48remuneracionGravadaTotal = AV48remuneracionGravadaTotal.add((AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Saccuo2gra().add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Horextgra()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Movviagra()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Docengra()))) ;
            AV48remuneracionGravadaTotal = AV48remuneracionGravadaTotal.add((AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Ajustesgra().add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Ajustesgra()).add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Bonosgra()).add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Fallosgra()).add(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Similaresgra()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Bonosgra()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Fallosgra()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Similaresgra()))) ;
         }
         AV249F1357LRExenta = DecimalUtil.doubleToDec(AV243ExenSinExt).add(AV35ExenExt).add(DecimalUtil.doubleToDec(AV215MovViaExen)).add(DecimalUtil.doubleToDec(AV214DocenExen)).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Exensinext()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Exenext()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Movviaexen()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Docenexen()).add(DecimalUtil.doubleToDec(AV217NoHabExen)).add(AV230NoHabitualesNoAlcanzada).add(AV38SacCuo1Exen).add(AV247sacCuo1NoAlcanzado).add(AV39SacCuo2Exen).add(AV248sacCuo2NoAlcanzado) ;
         AV249F1357LRExenta = AV249F1357LRExenta.add((AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Nohabexen().add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Saccuo1exen()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Saccuo2exen()).add(AV42BonosExen).add(AV297FallosExen).add(AV299SimilaresExen).add(DecimalUtil.doubleToDec(AV226TeletrabajoExen)).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Bonosexen()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Teletrabajoexen()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Fallosexen()).add(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Similaresexen()))) ;
         if ( AV267simulacionParaAdelanto )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&remuBrutaLiqActual ", "")+GXutil.trim( GXutil.str( AV280remuBrutaLiqActual, 14, 2))) ;
            AV289remuBrutaLiqActualConDescuento = AV280remuBrutaLiqActual.subtract(AV283descuentoLiqActual) ;
            AV278remuBrutaTeorica = AV318remuBrutaEstimadaConDescuento ;
            AV316remuBrutaTeoricaParaDEI = AV319remuBrutaLiqActualSinSAC.add(AV269remuBrutaEstimada) ;
            AV315LiqDLog += httpContext.getMessage( ". &remuBrutaLiqActualSinSAC ", "") + GXutil.trim( GXutil.str( AV319remuBrutaLiqActualSinSAC, 14, 2)) + httpContext.getMessage( " &remuBrutaEstimada ", "") + GXutil.trim( GXutil.str( AV269remuBrutaEstimada, 14, 2)) ;
            AV315LiqDLog += httpContext.getMessage( ". &remuBrutaTeorica es ", "") + GXutil.trim( GXutil.str( AV318remuBrutaEstimadaConDescuento, 14, 2)) + httpContext.getMessage( " (&remuBrutaEstimadaConDescuento)", "") ;
            AV48remuneracionGravadaTotal = AV48remuneracionGravadaTotal.add(AV278remuBrutaTeorica) ;
            AV315LiqDLog += httpContext.getMessage( ". A &remuneracionGravadaTotal le suma ", "") + GXutil.trim( GXutil.str( AV278remuBrutaTeorica, 14, 2)) + " (" + GXutil.trim( GXutil.str( AV48remuneracionGravadaTotal, 16, 2)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&remuBrutaEstimadaConDescuento ", "")+GXutil.trim( GXutil.str( AV318remuBrutaEstimadaConDescuento, 14, 2))+httpContext.getMessage( " &remuBrutaTeorica ", "")+GXutil.trim( GXutil.str( AV278remuBrutaTeorica, 14, 2))+httpContext.getMessage( " &remuBrutaLiqActual ", "")+GXutil.trim( GXutil.str( AV280remuBrutaLiqActual, 14, 2))+httpContext.getMessage( " &descuentoLiqActual ", "")+GXutil.trim( GXutil.str( AV283descuentoLiqActual, 14, 2))+httpContext.getMessage( " &baseImponible1 ", "")+GXutil.trim( GXutil.str( AV284baseImponible1, 14, 2))) ;
         }
         else
         {
            /*
               INSERT RECORD ON TABLE F1357LegRemun

            */
            A3CliCod = AV8CliCod ;
            A1EmpCod = AV12EmpCod ;
            A784F1357CTipoPre = AV15F1357CTipoPre ;
            A777F1357CPer = AV10F1357CPer ;
            A778F1357CSec = AV11F1357CSec ;
            A6LegNumero = ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() ;
            A797F1357LRTipReg = "03" ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&F1357_Remuneracion brugra ", "")+GXutil.trim( GXutil.str( AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Brugra(), 16, 2))) ;
            A798F1357LRRemuneraciones = GXutil.trim( AV18F1357_Remuneracion.toJSonString(false, true)) ;
            A799F1357LRRemuOtr = GXutil.trim( AV50F1357_RemuneracionOtrosEmpleos.toJSonString(false, true)) ;
            A800F1357LRGravada = AV48remuneracionGravadaTotal ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&F1357LRExenta ", "")+GXutil.trim( GXutil.str( AV249F1357LRExenta, 16, 2))+httpContext.getMessage( " &ExenSinExt ", "")+GXutil.trim( GXutil.str( AV243ExenSinExt, 4, 0))+httpContext.getMessage( " &ExenExt ", "")+GXutil.trim( GXutil.str( AV35ExenExt, 16, 2))+httpContext.getMessage( " &MovViaExen ", "")+GXutil.trim( GXutil.str( AV215MovViaExen, 4, 0))+httpContext.getMessage( " &DocenExen ", "")+GXutil.trim( GXutil.str( AV214DocenExen, 4, 0))+httpContext.getMessage( " &F1357_RemuneracionOtrosEmpleos.ExenSinExt ", "")+GXutil.trim( GXutil.str( AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Exensinext(), 16, 2))+httpContext.getMessage( " &F1357_RemuneracionOtrosEmpleos.ExenExt ", "")+GXutil.trim( GXutil.str( AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Exenext(), 16, 2))+httpContext.getMessage( " &F1357_RemuneracionOtrosEmpleos.MovViaExen ", "")+GXutil.trim( GXutil.str( AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Movviaexen(), 16, 2))+httpContext.getMessage( " &F1357_RemuneracionOtrosEmpleos.DocenExen ", "")+GXutil.trim( GXutil.str( AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Docenexen(), 16, 2))+httpContext.getMessage( " &NoHabExen ", "")+GXutil.trim( GXutil.str( AV217NoHabExen, 4, 0))+httpContext.getMessage( " &NoHabitualesNoAlcanzada ", "")+GXutil.trim( GXutil.str( AV230NoHabitualesNoAlcanzada, 16, 2))+httpContext.getMessage( " &SacCuo1Exen ", "")+GXutil.trim( GXutil.str( AV38SacCuo1Exen, 16, 2))+httpContext.getMessage( " &sacCuo1NoAlcanzado ", "")+GXutil.trim( GXutil.str( AV247sacCuo1NoAlcanzado, 16, 2))+httpContext.getMessage( " &SacCuo2Exen ", "")+GXutil.trim( GXutil.str( AV39SacCuo2Exen, 16, 2))+httpContext.getMessage( " &sacCuo2NoAlcanzado ", "")+GXutil.trim( GXutil.str( AV248sacCuo2NoAlcanzado, 16, 2))) ;
            A801F1357LRExenta = AV249F1357LRExenta ;
            /* Using cursor P00UO7 */
            pr_default.execute(5, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A797F1357LRTipReg, A798F1357LRRemuneraciones, A799F1357LRRemuOtr, A800F1357LRGravada, A801F1357LRExenta});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegRemun");
            if ( (pr_default.getStatus(5) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "remu duplicate", "")) ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
         GXt_decimal17 = AV64F1357LDGSepelio ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV65sepelioConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV64F1357LDGSepelio = GXt_decimal17 ;
         if ( DecimalUtil.compareTo(AV64F1357LDGSepelio, AV66topeSepelios) > 0 )
         {
            AV64F1357LDGSepelio = AV66topeSepelios ;
         }
         GXt_decimal17 = AV67F1357LDGRodado ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV68vehiculosConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV67F1357LDGRodado = GXt_decimal17 ;
         AV69F1357LDGOblig = DecimalUtil.ZERO ;
         GXt_decimal17 = AV70F1357LDGHipoteca ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV72hipotecaConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV70F1357LDGHipoteca = GXt_decimal17 ;
         if ( DecimalUtil.compareTo(AV70F1357LDGHipoteca, AV71topeHipoteca) > 0 )
         {
            AV70F1357LDGHipoteca = AV71topeHipoteca ;
         }
         GXt_decimal17 = AV74F1357LDGSGR ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV75aportesSGRConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV74F1357LDGSGR = GXt_decimal17 ;
         GXt_decimal17 = AV76F1357LDGDomes ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV78personalDomesticoConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV76F1357LDGDomes = GXt_decimal17 ;
         if ( DecimalUtil.compareTo(AV76F1357LDGDomes, AV201mniParaTopes) > 0 )
         {
            AV76F1357LDGDomes = AV201mniParaTopes ;
         }
         GXt_decimal17 = AV290F1357LDGEducativos ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV291educativosConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV290F1357LDGEducativos = GXt_decimal17 ;
         if ( DecimalUtil.compareTo(AV290F1357LDGEducativos, (AV201mniParaTopes.multiply(DecimalUtil.stringToDec("0.4")))) > 0 )
         {
            AV290F1357LDGEducativos = (AV201mniParaTopes.multiply(DecimalUtil.stringToDec("0.4"))) ;
         }
         GXt_decimal17 = AV79F1357LDGAlquiler ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV80alquilerConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV79F1357LDGAlquiler = GXt_decimal17 ;
         if ( DecimalUtil.compareTo(AV79F1357LDGAlquiler, AV201mniParaTopes) > 0 )
         {
            AV79F1357LDGAlquiler = AV201mniParaTopes ;
         }
         GXt_decimal17 = AV81F1357LDGViaticos ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV82viaticosConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV81F1357LDGViaticos = GXt_decimal17 ;
         GXt_decimal17 = AV83F1357LDGIndu ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV84induConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV83F1357LDGIndu = GXt_decimal17 ;
         GXt_decimal17 = AV85F1357LDGOtras ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV162otrasDeduccionesConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV85F1357LDGOtras = GXt_decimal17 ;
         AV47gananciaNeta = AV48remuneracionGravadaTotal.subtract(AV57F1357LDGSeguro).subtract(AV59F1357LDGSeguMixto).subtract(AV60F1357LDGRetPriv).subtract(AV63F1357LDGCuotapartes).subtract(AV64F1357LDGSepelio).subtract(AV67F1357LDGRodado).subtract(AV69F1357LDGOblig).subtract(AV70F1357LDGHipoteca).subtract(AV74F1357LDGSGR).subtract(AV76F1357LDGDomes).subtract(AV79F1357LDGAlquiler).subtract(AV81F1357LDGViaticos).subtract(AV83F1357LDGIndu).subtract(AV85F1357LDGOtras).subtract(AV290F1357LDGEducativos) ;
         AV288deducciones = AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Jub().add(AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Os()).add(AV55F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Os()).add(AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin()).add(AV55F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Jub()).add(AV55F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin()) ;
         AV47gananciaNeta = AV47gananciaNeta.subtract(AV288deducciones) ;
         GXt_decimal17 = AV86F1357LDGDonaciones ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV91donacionesConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV86F1357LDGDonaciones = GXt_decimal17 ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&alicuotaDonaciones ", "")+GXutil.trim( GXutil.str( AV87alicuotaDonaciones, 6, 4))+httpContext.getMessage( " &gananciaNeta ", "")+GXutil.trim( GXutil.str( AV47gananciaNeta, 16, 2))) ;
         if ( DecimalUtil.compareTo(AV86F1357LDGDonaciones, (AV47gananciaNeta.multiply(AV87alicuotaDonaciones))) > 0 )
         {
            AV86F1357LDGDonaciones = (AV47gananciaNeta.multiply(AV87alicuotaDonaciones)) ;
         }
         if ( AV15F1357CTipoPre != 3 )
         {
            GXt_decimal17 = AV57F1357LDGSeguro ;
            GXv_boolean14[0] = false ;
            GXv_decimal13[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV58primaSeguroConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
            f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
            AV57F1357LDGSeguro = GXt_decimal17 ;
            if ( DecimalUtil.compareTo(AV57F1357LDGSeguro, AV62topeSeguros) > 0 )
            {
               AV57F1357LDGSeguro = AV62topeSeguros ;
            }
            GXt_decimal17 = AV59F1357LDGSeguMixto ;
            GXv_boolean14[0] = false ;
            GXv_decimal13[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV164primasMixtosConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
            f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
            AV59F1357LDGSeguMixto = GXt_decimal17 ;
            if ( DecimalUtil.compareTo(AV59F1357LDGSeguMixto, AV62topeSeguros) > 0 )
            {
               AV59F1357LDGSeguMixto = AV62topeSeguros ;
            }
            GXt_decimal17 = AV60F1357LDGRetPriv ;
            GXv_boolean14[0] = false ;
            GXv_decimal13[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV61retiroPrivadoConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
            f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
            AV60F1357LDGRetPriv = GXt_decimal17 ;
            if ( DecimalUtil.compareTo(AV60F1357LDGRetPriv, AV62topeSeguros) > 0 )
            {
               AV60F1357LDGRetPriv = AV62topeSeguros ;
            }
            GXt_decimal17 = AV63F1357LDGCuotapartes ;
            GXv_boolean14[0] = false ;
            GXv_decimal13[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV165cuotapartesConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
            f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
            AV63F1357LDGCuotapartes = GXt_decimal17 ;
            GXt_decimal17 = AV88F1357LDGMed ;
            GXv_boolean14[0] = false ;
            GXv_decimal13[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV90honorariosMedicosConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
            f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
            AV88F1357LDGMed = GXt_decimal17 ;
            if ( DecimalUtil.compareTo(AV88F1357LDGMed, (AV47gananciaNeta.multiply(AV89limiteMedicos))) > 0 )
            {
               AV88F1357LDGMed = (AV47gananciaNeta.multiply(AV89limiteMedicos)) ;
            }
         }
         GXt_decimal17 = AV92F1357LDGPrepaga ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV93prepagaConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV92F1357LDGPrepaga = GXt_decimal17 ;
         if ( DecimalUtil.compareTo(AV92F1357LDGPrepaga, (AV47gananciaNeta.multiply(AV94limitePrepaga))) > 0 )
         {
            AV92F1357LDGPrepaga = (AV47gananciaNeta.multiply(AV94limitePrepaga)) ;
         }
         GXt_decimal17 = AV95F1357LDGOtrasCaja ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV162otrasDeduccionesConCodigo, true, (byte)(0), "7", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV95F1357LDGOtrasCaja = GXt_decimal17 ;
         GXt_decimal17 = AV97F1357LDGOtrasAnses ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV162otrasDeduccionesConCodigo, true, (byte)(0), "1", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV97F1357LDGOtrasAnses = GXt_decimal17 ;
         GXt_decimal17 = AV98F1357LDGOtrasProf ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV162otrasDeduccionesConCodigo, true, (byte)(0), "2", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV98F1357LDGOtrasProf = GXt_decimal17 ;
         GXt_decimal17 = AV99F1357LDGOtrasActores ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV162otrasDeduccionesConCodigo, true, (byte)(0), "6", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV99F1357LDGOtrasActores = GXt_decimal17 ;
         GXt_decimal17 = AV100F1357LDGOtrasPrev ;
         GXv_boolean14[0] = false ;
         GXv_decimal13[0] = GXt_decimal17 ;
         new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV162otrasDeduccionesConCodigo, true, (byte)(0), "8", false, GXv_boolean14, GXv_decimal13) ;
         f1357.this.GXt_decimal17 = GXv_decimal13[0] ;
         AV100F1357LDGOtrasPrev = GXt_decimal17 ;
         if ( ! AV267simulacionParaAdelanto )
         {
            /*
               INSERT RECORD ON TABLE F1357LegDedGen

            */
            A1213F1357LDGMovEmpl = DecimalUtil.doubleToDec(0) ;
            A1214F1357LDGViaEmpl = DecimalUtil.doubleToDec(0) ;
            A1215F1357LDGCompAna = DecimalUtil.doubleToDec(0) ;
            A1216F1357LDGCompAnaCnt = (byte)(0) ;
            A3CliCod = AV8CliCod ;
            A1EmpCod = AV12EmpCod ;
            A784F1357CTipoPre = AV15F1357CTipoPre ;
            A777F1357CPer = AV10F1357CPer ;
            A778F1357CSec = AV11F1357CSec ;
            A6LegNumero = ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() ;
            A863F1357LDGTipReg = "04" ;
            A802F1357LDGPrepaga = AV92F1357LDGPrepaga ;
            A803F1357LDGSeguro = AV57F1357LDGSeguro ;
            A804F1357LDGSeguMixto = AV59F1357LDGSeguMixto ;
            A805F1357LDGRetPriv = AV60F1357LDGRetPriv ;
            A806F1357LDGCuotapartes = AV63F1357LDGCuotapartes ;
            A807F1357LDGSepelio = AV64F1357LDGSepelio ;
            A808F1357LDGRodado = AV67F1357LDGRodado ;
            A809F1357LDGDonaciones = AV86F1357LDGDonaciones ;
            A810F1357LDGOblig = AV69F1357LDGOblig ;
            A811F1357LDGMed = AV88F1357LDGMed ;
            A812F1357LDGHipoteca = AV70F1357LDGHipoteca ;
            A813F1357LDGSGR = AV74F1357LDGSGR ;
            A814F1357LDGOtrasCaja = AV95F1357LDGOtrasCaja ;
            A815F1357LDGAlquiler = AV79F1357LDGAlquiler ;
            A816F1357LDGDomes = AV76F1357LDGDomes ;
            A944F1357LDGEducativos = AV290F1357LDGEducativos ;
            A817F1357LDGViaticos = AV81F1357LDGViaticos ;
            A818F1357LDGIndu = AV83F1357LDGIndu ;
            A819F1357LDGOtras = AV85F1357LDGOtras ;
            AV96F1357LDGTotal = AV92F1357LDGPrepaga.add(AV57F1357LDGSeguro).add(AV59F1357LDGSeguMixto).add(AV60F1357LDGRetPriv).add(AV63F1357LDGCuotapartes).add(AV64F1357LDGSepelio).add(AV67F1357LDGRodado) ;
            AV96F1357LDGTotal = AV96F1357LDGTotal.add((AV86F1357LDGDonaciones.add(AV69F1357LDGOblig).add(AV88F1357LDGMed).add(AV70F1357LDGHipoteca).add(AV74F1357LDGSGR).add(AV95F1357LDGOtrasCaja).add(AV79F1357LDGAlquiler))) ;
            AV96F1357LDGTotal = AV96F1357LDGTotal.add((AV76F1357LDGDomes.add(AV81F1357LDGViaticos).add(AV83F1357LDGIndu).add(AV85F1357LDGOtras).add(AV290F1357LDGEducativos))) ;
            AV96F1357LDGTotal = AV96F1357LDGTotal.add((AV97F1357LDGOtrasAnses.add(AV98F1357LDGOtrasProf).add(AV99F1357LDGOtrasActores).add(AV100F1357LDGOtrasPrev))) ;
            A820F1357LDGTotal = AV96F1357LDGTotal ;
            A821F1357LDGOtrasAnses = AV97F1357LDGOtrasAnses ;
            A822F1357LDGOtrasProf = AV98F1357LDGOtrasProf ;
            A823F1357LDGOtrasActores = AV99F1357LDGOtrasActores ;
            A824F1357LDGOtrasPrev = AV100F1357LDGOtrasPrev ;
            A825F1357LDGDescuentosLey = AV54F1357_DeduccionesGenerales.toJSonString(false, true) ;
            A826F1357LDGOtrDescuLey = AV55F1357_DeduccionesGeneralesOtrosEmpleos.toJSonString(false, true) ;
            /* Using cursor P00UO8 */
            pr_default.execute(6, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A863F1357LDGTipReg, A802F1357LDGPrepaga, A803F1357LDGSeguro, A804F1357LDGSeguMixto, A805F1357LDGRetPriv, A806F1357LDGCuotapartes, A807F1357LDGSepelio, A808F1357LDGRodado, A809F1357LDGDonaciones, A810F1357LDGOblig, A811F1357LDGMed, A812F1357LDGHipoteca, A813F1357LDGSGR, A814F1357LDGOtrasCaja, A815F1357LDGAlquiler, A816F1357LDGDomes, A817F1357LDGViaticos, A818F1357LDGIndu, A819F1357LDGOtras, A820F1357LDGTotal, A821F1357LDGOtrasAnses, A822F1357LDGOtrasProf, A823F1357LDGOtrasActores, A824F1357LDGOtrasPrev, A825F1357LDGDescuentosLey, A826F1357LDGOtrDescuLey, A944F1357LDGEducativos, A1213F1357LDGMovEmpl, A1214F1357LDGViaEmpl, A1215F1357LDGCompAna, Byte.valueOf(A1216F1357LDGCompAnaCnt)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LegDedGen");
            if ( (pr_default.getStatus(6) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
         AV115F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
         AV116F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
         if ( ! AV267simulacionParaAdelanto )
         {
            /*
               INSERT RECORD ON TABLE F1357LDedPer

            */
            A3CliCod = AV8CliCod ;
            A1EmpCod = AV12EmpCod ;
            A784F1357CTipoPre = AV15F1357CTipoPre ;
            A777F1357CPer = AV10F1357CPer ;
            A778F1357CSec = AV11F1357CSec ;
            A6LegNumero = ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() ;
            A862F1357LDPTipReg = "05" ;
            A827F1357LDPGNI = AV77mni ;
            A828F1357LDPEspecial = AV101F1357LDPEspecial ;
            A829F1357LDPEspecifica = AV102F1357LDPEspecifica ;
            A830F1357LDPConyuge = (AV104F1357LDPConyuge.multiply(DecimalUtil.doubleToDec(AV150deduce_conyuge))) ;
            A831F1357LDPCantHijos = AV105F1357LDPCantHijos ;
            A832F1357LDPHijosImporte = AV107F1357LDPHijosImporte ;
            AV196F1357LDPTotalFami = (AV104F1357LDPConyuge.multiply(DecimalUtil.doubleToDec(AV150deduce_conyuge))).add(AV107F1357LDPHijosImporte).add(AV111F1357LDPHijosIncapImp) ;
            A833F1357LDPTotalFami = AV196F1357LDPTotalFami ;
            GXv_decimal13[0] = AV115F1357LDPEspIncremen1 ;
            GXv_decimal18[0] = AV116F1357LDPEspIncremen2 ;
            new web.f1357_calcularincrementadas(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV28LiqPerAno, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV118dedEspecialIncrementadaConCodigo, GXv_decimal13, GXv_decimal18) ;
            f1357.this.AV115F1357LDPEspIncremen1 = GXv_decimal13[0] ;
            f1357.this.AV116F1357LDPEspIncremen2 = GXv_decimal18[0] ;
            AV130F1357LDPTotalArt30 = AV77mni.add(AV101F1357LDPEspecial).add(AV102F1357LDPEspecifica).add(AV196F1357LDPTotalFami).add(AV115F1357LDPEspIncremen1).add(AV116F1357LDPEspIncremen2) ;
            A834F1357LDPTotalArt30 = AV130F1357LDPTotalArt30 ;
            A835F1357LDPSujAntes = DecimalUtil.doubleToDec(0) ;
            A836F1357LDPIncA = DecimalUtil.doubleToDec(0) ;
            A837F1357LDPIncB = DecimalUtil.doubleToDec(0) ;
            A838F1357LDPRemuSuj = DecimalUtil.doubleToDec(0) ;
            A839F1357LDPCantHijIncap = AV106F1357LDPCantHijIncap ;
            A840F1357LDPHijosIncapImp = AV111F1357LDPHijosIncapImp ;
            A841F1357LDPEspIncremen1 = AV115F1357LDPEspIncremen1 ;
            A842F1357LDPEspIncremen2 = AV116F1357LDPEspIncremen2 ;
            A945F1357LDPCantHij100PC = AV292F1357LDPCantHij100PC ;
            A946F1357ldpcAntHijIncap100pc = AV293F1357ldpcAntHijIncap100pc ;
            A947F1357LDPcantHijMay18 = AV294F1357LDPcantHijMay18 ;
            A948F1357LDPcantHijMay18_100pc = AV295F1357LDPcantHijMay18_100pc ;
            /* Using cursor P00UO9 */
            pr_default.execute(7, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A862F1357LDPTipReg, A827F1357LDPGNI, A828F1357LDPEspecial, A829F1357LDPEspecifica, A830F1357LDPConyuge, A831F1357LDPCantHijos, A832F1357LDPHijosImporte, A833F1357LDPTotalFami, A834F1357LDPTotalArt30, A835F1357LDPSujAntes, A836F1357LDPIncA, A837F1357LDPIncB, A838F1357LDPRemuSuj, A839F1357LDPCantHijIncap, A840F1357LDPHijosIncapImp, A841F1357LDPEspIncremen1, A842F1357LDPEspIncremen2, A945F1357LDPCantHij100PC, A946F1357ldpcAntHijIncap100pc, A947F1357LDPcantHijMay18, A948F1357LDPcantHijMay18_100pc});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LDedPer");
            if ( (pr_default.getStatus(7) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, "5") ;
         if ( AV15F1357CTipoPre != 3 )
         {
            GXt_decimal17 = AV139F1357CPagosCredDeb ;
            GXv_boolean14[0] = false ;
            GXv_decimal18[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV140pagosACuentaConCodigo, true, (byte)(6), "", false, GXv_boolean14, GXv_decimal18) ;
            f1357.this.GXt_decimal17 = GXv_decimal18[0] ;
            AV139F1357CPagosCredDeb = GXt_decimal17 ;
            GXt_decimal17 = AV141F1357LCPagosAduanta ;
            GXv_boolean14[0] = false ;
            GXv_decimal18[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV140pagosACuentaConCodigo, true, (byte)(12), "", false, GXv_boolean14, GXv_decimal18) ;
            f1357.this.GXt_decimal17 = GXv_decimal18[0] ;
            AV141F1357LCPagosAduanta = GXt_decimal17 ;
            GXt_decimal17 = AV144F1357LCCredDebMOv ;
            GXv_boolean14[0] = false ;
            GXv_decimal18[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV140pagosACuentaConCodigo, true, (byte)(14), "", false, GXv_boolean14, GXv_decimal18) ;
            f1357.this.GXt_decimal17 = GXv_decimal18[0] ;
            AV144F1357LCCredDebMOv = GXt_decimal17 ;
            GXt_decimal17 = AV145F1357LCPagosIncA ;
            GXv_boolean14[0] = false ;
            GXv_decimal18[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV140pagosACuentaConCodigo, true, (byte)(18), "", false, GXv_boolean14, GXv_decimal18) ;
            f1357.this.GXt_decimal17 = GXv_decimal18[0] ;
            AV145F1357LCPagosIncA = GXt_decimal17 ;
            GXt_decimal17 = AV146F1357LCPagosIncB ;
            GXv_boolean14[0] = false ;
            GXv_decimal18[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV140pagosACuentaConCodigo, true, (byte)(13), "", false, GXv_boolean14, GXv_decimal18) ;
            f1357.this.GXt_decimal17 = GXv_decimal18[0] ;
            AV146F1357LCPagosIncB = GXt_decimal17 ;
            GXt_decimal17 = AV138F1357LCPagosTotal ;
            GXv_boolean14[0] = false ;
            GXv_decimal18[0] = GXt_decimal17 ;
            new web.obtenerimportededuccion(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "[monto_siradig]", AV20LiqPeriodo, AV140pagosACuentaConCodigo, true, (byte)(0), "", false, GXv_boolean14, GXv_decimal18) ;
            f1357.this.GXt_decimal17 = GXv_decimal18[0] ;
            AV138F1357LCPagosTotal = GXt_decimal17 ;
         }
         AV263restarLeyTotal = false ;
         GXt_char2 = AV264modoDeduccionDescuentosLeyPalabra ;
         GXt_char1 = AV264modoDeduccionDescuentosLeyPalabra ;
         GXv_char10[0] = GXt_char1 ;
         new web.mododeducciondescuentosley_codigoparam(remoteHandle, context).execute( GXv_char10) ;
         f1357.this.GXt_char1 = GXv_char10[0] ;
         GXv_char9[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
         f1357.this.GXt_char2 = GXv_char9[0] ;
         AV264modoDeduccionDescuentosLeyPalabra = GXt_char2 ;
         AV266descuentosDeLeySobreGravadoLiqDImpCalcu = AV261descuentosSobreGravadoLiqDImpCalcu ;
         if ( GXutil.strcmp(AV264modoDeduccionDescuentosLeyPalabra, httpContext.getMessage( "TOTAL", "")) == 0 )
         {
            AV260descuentosDeLeyLiqDImpCalcu = AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Jub().add(AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Os()).add(AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin()).add(AV55F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Jub()).add(AV55F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Os()).add(AV55F1357_DeduccionesGeneralesOtrosEmpleos.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin()) ;
         }
         else
         {
            AV260descuentosDeLeyLiqDImpCalcu = AV266descuentosDeLeySobreGravadoLiqDImpCalcu ;
         }
         if ( AV267simulacionParaAdelanto )
         {
            GXv_decimal18[0] = AV194DeduccionEspecialIncrementadaAplicada ;
            GXv_int15[0] = (byte)(0) ;
            GXv_char10[0] = "" ;
            GXv_char9[0] = "" ;
            new web.deduccionespecialincrementada(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, 0, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV20LiqPeriodo, AV149gnsi, AV316remuBrutaTeoricaParaDEI, AV322ProcesoLiquidacion, GXv_decimal18, GXv_int15, GXv_char10, GXv_char9) ;
            f1357.this.AV194DeduccionEspecialIncrementadaAplicada = GXv_decimal18[0] ;
            AV315LiqDLog += httpContext.getMessage( ". Entra a DEI &gnsi ", "") + GXutil.trim( GXutil.str( AV149gnsi, 14, 2)) + httpContext.getMessage( " &&remuBrutaTeoricaParaDEI ", "") + GXutil.trim( GXutil.str( AV316remuBrutaTeoricaParaDEI, 14, 2)) + httpContext.getMessage( " &DeduccionEspecialIncrementadaAplicada ", "") + GXutil.trim( GXutil.str( AV194DeduccionEspecialIncrementadaAplicada, 16, 2)) ;
         }
         AV265auxArt30Importes = AV77mni.add(AV101F1357LDPEspecial).add(AV102F1357LDPEspecifica).add(AV196F1357LDPTotalFami).add(AV194DeduccionEspecialIncrementadaAplicada) ;
         if ( AV313liquidoSac1 )
         {
            AV309anticiposDeSac1erSemestre = DecimalUtil.ZERO ;
         }
         if ( AV314liquidoSac2 )
         {
            AV310anticiposDeSac2doSemestre = DecimalUtil.ZERO ;
         }
         if ( ! AV267simulacionParaAdelanto )
         {
            AV308anticiposDeSac = AV309anticiposDeSac1erSemestre.add(AV310anticiposDeSac2doSemestre) ;
         }
         else
         {
            AV308anticiposDeSac = DecimalUtil.doubleToDec(0) ;
         }
         AV149gnsi = AV48remuneracionGravadaTotal.add(AV308anticiposDeSac).subtract(AV96F1357LDGTotal).subtract(AV265auxArt30Importes) ;
         AV315LiqDLog += httpContext.getMessage( "&gnsi ", "") + GXutil.trim( GXutil.str( AV149gnsi, 14, 2)) + " = " + GXutil.trim( GXutil.str( AV48remuneracionGravadaTotal, 16, 2)) + httpContext.getMessage( " (&remuneracionGravadaTotal) - ", "") + GXutil.trim( GXutil.str( AV308anticiposDeSac, 14, 2)) + httpContext.getMessage( " (&anticiposDeSac) + ", "") + GXutil.trim( GXutil.str( AV96F1357LDGTotal, 16, 2)) + httpContext.getMessage( " (&F1357LDGTotal) ", "") ;
         AV315LiqDLog += " + " + GXutil.trim( GXutil.str( AV265auxArt30Importes, 14, 2)) + httpContext.getMessage( " (&auxArt30Importes)", "") ;
         if ( ! AV267simulacionParaAdelanto )
         {
            AV149gnsi = AV149gnsi.subtract(AV260descuentosDeLeyLiqDImpCalcu) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "leg ", "")+GXutil.trim( GXutil.str( ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), 8, 0))+httpContext.getMessage( " gnsi ", "")+GXutil.trim( GXutil.str( AV149gnsi, 14, 2))+httpContext.getMessage( " &remuneracionGravadaTotal ", "")+GXutil.trim( GXutil.str( AV48remuneracionGravadaTotal, 16, 2))+httpContext.getMessage( " &F1357LDGTotal ", "")+GXutil.trim( GXutil.str( AV96F1357LDGTotal, 16, 2))+httpContext.getMessage( " &auxArt30Importes ", "")+GXutil.trim( GXutil.str( AV265auxArt30Importes, 14, 2))+httpContext.getMessage( " &descuentosDeLeyLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV260descuentosDeLeyLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &DeduccionEspecialIncrementadaAplicada ", "")+GXutil.trim( GXutil.str( AV194DeduccionEspecialIncrementadaAplicada, 16, 2))) ;
         if ( AV149gnsi.doubleValue() < 0 )
         {
            AV149gnsi = DecimalUtil.doubleToDec(0) ;
            AV203gnsiSinHorasExtrasGravadas = DecimalUtil.doubleToDec(0) ;
         }
         else
         {
            AV203gnsiSinHorasExtrasGravadas = AV149gnsi.subtract(AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Horextgra()).subtract(AV50F1357_RemuneracionOtrosEmpleos.getgxTv_SdtF1357_Remuneracion_Horextgra()) ;
         }
         GXv_int15[0] = (byte)(0) ;
         GXv_char10[0] = "" ;
         GXv_decimal18[0] = AV134alicuota_porUnaje ;
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal19[0] = DecimalUtil.doubleToDec(0) ;
         GXv_decimal20[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char9[0] = "" ;
         GXv_char8[0] = "" ;
         new web.getgantasa(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, 0, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "", AV20LiqPeriodo, "Recalculo", new web.palabragantasaalicuota(remoteHandle, context).executeUdp( AV8CliCod), false, AV149gnsi, AV203gnsiSinHorasExtrasGravadas, AV337Pgmname, false, GXv_int15, GXv_char10, GXv_decimal18, GXv_decimal13, GXv_decimal19, GXv_decimal20, GXv_char9, GXv_char8) ;
         f1357.this.AV134alicuota_porUnaje = GXv_decimal18[0] ;
         GXv_int15[0] = AV125F1357LCAlicuota ;
         new web.pasarganalicuotaatabla(remoteHandle, context).execute( AV134alicuota_porUnaje, GXv_int15) ;
         f1357.this.AV125F1357LCAlicuota = GXv_int15[0] ;
         GXv_int15[0] = (byte)(0) ;
         GXv_char10[0] = "" ;
         GXv_decimal20[0] = AV129cuota_fija ;
         GXv_decimal19[0] = AV132tope_anterior ;
         GXv_decimal18[0] = AV135alicuotaAplicable_porUnaje ;
         GXv_decimal13[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char9[0] = "" ;
         GXv_char8[0] = "" ;
         new web.getgantasa(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, AV127LiqNro, 0, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), "", AV20LiqPeriodo, "Recalculo", "", true, AV149gnsi, AV203gnsiSinHorasExtrasGravadas, AV337Pgmname, false, GXv_int15, GXv_char10, GXv_decimal20, GXv_decimal19, GXv_decimal18, GXv_decimal13, GXv_char9, GXv_char8) ;
         f1357.this.AV129cuota_fija = GXv_decimal20[0] ;
         f1357.this.AV132tope_anterior = GXv_decimal19[0] ;
         f1357.this.AV135alicuotaAplicable_porUnaje = GXv_decimal18[0] ;
         GXv_int15[0] = AV128F1357LCAliApli ;
         new web.pasarganalicuotaatabla(remoteHandle, context).execute( AV135alicuotaAplicable_porUnaje, GXv_int15) ;
         f1357.this.AV128F1357LCAliApli = GXv_int15[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "calcula gnsi ", "")+GXutil.trim( GXutil.str( AV48remuneracionGravadaTotal, 16, 2))+" - "+GXutil.trim( GXutil.str( AV130F1357LDPTotalArt30, 16, 2))+" - "+GXutil.trim( GXutil.str( AV96F1357LDGTotal, 16, 2))+" - "+GXutil.trim( GXutil.str( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Jub(), 16, 2))+" - "+GXutil.trim( GXutil.str( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Os(), 16, 2))+" - "+GXutil.trim( GXutil.str( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin(), 16, 2))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&cuota_fija ", "")+GXutil.trim( GXutil.str( AV129cuota_fija, 14, 2))+httpContext.getMessage( " &cantMesesTributados ", "")+GXutil.trim( GXutil.str( AV103cantMesesTributados, 4, 0))+httpContext.getMessage( " gnsi ", "")+GXutil.trim( GXutil.str( AV149gnsi, 14, 2))+httpContext.getMessage( " topeanterior ", "")+GXutil.trim( GXutil.str( AV132tope_anterior, 14, 2))+httpContext.getMessage( " &alicuotaAplicable_porUnaje ", "")+GXutil.trim( GXutil.str( AV135alicuotaAplicable_porUnaje, 6, 4))) ;
         AV147F1357LCDeterminado = ((AV129cuota_fija.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV103cantMesesTributados))).add(((AV149gnsi.subtract(((AV132tope_anterior.divide(DecimalUtil.doubleToDec(AV205mesesAnio), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV103cantMesesTributados))))).multiply(AV135alicuotaAplicable_porUnaje))) ;
         if ( DecimalUtil.compareTo(AV138F1357LCPagosTotal, AV147F1357LCDeterminado) > 0 )
         {
            AV147F1357LCDeterminado = DecimalUtil.doubleToDec(0) ;
         }
         else
         {
            AV147F1357LCDeterminado = AV147F1357LCDeterminado.subtract(AV138F1357LCPagosTotal) ;
         }
         if ( ! AV267simulacionParaAdelanto )
         {
            /*
               INSERT RECORD ON TABLE F1357LCalculo

            */
            A3CliCod = AV8CliCod ;
            A1EmpCod = AV12EmpCod ;
            A784F1357CTipoPre = AV15F1357CTipoPre ;
            A777F1357CPer = AV10F1357CPer ;
            A778F1357CSec = AV11F1357CSec ;
            A6LegNumero = ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() ;
            A861F1357LCTipReg = "06" ;
            A844F1357LCAlicuota = AV125F1357LCAlicuota ;
            A845F1357LCAliApli = AV128F1357LCAliApli ;
            A866F1357LC_GNSI = AV149gnsi ;
            A867F1357LC_GanNeta = AV47gananciaNeta ;
            A871F1357LC_Cuota_fija = AV129cuota_fija ;
            A872F1357LC_MesesTributados = DecimalUtil.doubleToDec(AV103cantMesesTributados) ;
            A873F1357LC_Tope_anterior = AV132tope_anterior ;
            A846F1357LCDeterminado = AV147F1357LCDeterminado ;
            A847F1357LCRetenido = AV136F1357LCRetenido ;
            A848F1357LCPagosTotal = AV138F1357LCPagosTotal ;
            A849F1357LCSaldo = AV136F1357LCRetenido.subtract(AV147F1357LCDeterminado) ;
            A850F1357CPagosCredDeb = AV139F1357CPagosCredDeb ;
            A851F1357LCPagosAduanta = AV141F1357LCPagosAduanta ;
            A852F1357LCPagosTurismo = AV142F1357LCPagosTurismo ;
            A853F1357LCPagosBono = AV143F1357LCPagosBono ;
            A854F1357LCPagosIncA = AV145F1357LCPagosIncA ;
            A855F1357LCPagosIncB = AV146F1357LCPagosIncB ;
            A856F1357LCPagosIncC = DecimalUtil.doubleToDec(0) ;
            A857F1357LCPagosIncD = DecimalUtil.doubleToDec(0) ;
            A858F1357LCPagosIncE = DecimalUtil.doubleToDec(0) ;
            A859F1357LCCredDebMOv = AV144F1357LCCredDebMOv ;
            A860F1357LCViajeExterior = DecimalUtil.doubleToDec(0) ;
            A927F1357LC_DescuSobreGrav = AV266descuentosDeLeySobreGravadoLiqDImpCalcu ;
            A1082F1357LC_AnticiposDeSac = AV308anticiposDeSac ;
            /* Using cursor P00UO10 */
            pr_default.execute(8, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Byte.valueOf(A784F1357CTipoPre), A777F1357CPer, Byte.valueOf(A778F1357CSec), Integer.valueOf(A6LegNumero), A861F1357LCTipReg, Byte.valueOf(A844F1357LCAlicuota), Byte.valueOf(A845F1357LCAliApli), A846F1357LCDeterminado, A847F1357LCRetenido, A848F1357LCPagosTotal, A849F1357LCSaldo, A850F1357CPagosCredDeb, A851F1357LCPagosAduanta, A852F1357LCPagosTurismo, A853F1357LCPagosBono, A854F1357LCPagosIncA, A855F1357LCPagosIncB, A856F1357LCPagosIncC, A857F1357LCPagosIncD, A858F1357LCPagosIncE, A859F1357LCCredDebMOv, A860F1357LCViajeExterior, A866F1357LC_GNSI, A867F1357LC_GanNeta, A871F1357LC_Cuota_fija, A872F1357LC_MesesTributados, A873F1357LC_Tope_anterior, A927F1357LC_DescuSobreGrav, A1082F1357LC_AnticiposDeSac});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("F1357LCalculo");
            if ( (pr_default.getStatus(8) == 1) )
            {
               Gx_err = (short)(1) ;
               Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
            }
            else
            {
               Gx_err = (short)(0) ;
               Gx_emsg = "" ;
            }
            /* End Insert */
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, "6") ;
         AV17i = (short)(AV17i+1) ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&liqdlog ", "")+AV315LiqDLog) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'REMUNERACIONES' Routine */
      returnInSub = false ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "remuneraciones legajo ", "")+GXutil.trim( GXutil.str( ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), 8, 0))) ;
      AV236eneroFecha = localUtil.ymdtod( GXutil.year( AV20LiqPeriodo), 1, 1) ;
      AV237diciembreFecha = localUtil.ymdtod( GXutil.year( AV20LiqPeriodo), 12, 1) ;
      GXv_objcol_char21[0] = AV229noHabConCodigo ;
      new web.devuelveconceptosporhabitualidad(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), AV236eneroFecha, AV237diciembreFecha, httpContext.getMessage( "NO HABITUALES", ""), GXv_objcol_char21) ;
      AV229noHabConCodigo = GXv_objcol_char21[0] ;
      AV261descuentosSobreGravadoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV194DeduccionEspecialIncrementadaAplicada = DecimalUtil.ZERO ;
      AV30SacCuo1Gra = DecimalUtil.ZERO ;
      AV31SacCuo2Gra = DecimalUtil.ZERO ;
      AV27RemuneracionBrutaAlcanzada = DecimalUtil.ZERO ;
      AV32HorasExtras = DecimalUtil.ZERO ;
      AV238HorasExtrasNoAlcanzadas = DecimalUtil.ZERO ;
      AV247sacCuo1NoAlcanzado = DecimalUtil.ZERO ;
      AV248sacCuo2NoAlcanzado = DecimalUtil.ZERO ;
      AV239MovViaNoAlcanzado = DecimalUtil.ZERO ;
      AV241BonosNoAlcanzados = DecimalUtil.ZERO ;
      AV301FallosNoAlzanzados = DecimalUtil.ZERO ;
      AV303similarNoAlcanzado = DecimalUtil.ZERO ;
      AV240docenNoAlcanzados = DecimalUtil.ZERO ;
      AV35ExenExt = DecimalUtil.ZERO ;
      AV217NoHabExen = (short)(0) ;
      AV38SacCuo1Exen = DecimalUtil.ZERO ;
      AV39SacCuo2Exen = DecimalUtil.ZERO ;
      AV51AjustesGra = DecimalUtil.ZERO ;
      AV52AjustesExen = DecimalUtil.ZERO ;
      AV36RemuneracionExenta = DecimalUtil.ZERO ;
      AV41BonosProductividad = DecimalUtil.ZERO ;
      AV300FallosDeCaja = DecimalUtil.ZERO ;
      AV302SimilarNaturaleza = DecimalUtil.ZERO ;
      AV210NoHabituales = DecimalUtil.ZERO ;
      AV216movilidadYViaticos = DecimalUtil.ZERO ;
      AV224docentes = DecimalUtil.ZERO ;
      AV42BonosExen = DecimalUtil.ZERO ;
      AV297FallosExen = DecimalUtil.ZERO ;
      AV299SimilaresExen = DecimalUtil.ZERO ;
      AV226TeletrabajoExen = (short)(0) ;
      AV215MovViaExen = (short)(0) ;
      AV214DocenExen = (short)(0) ;
      AV136F1357LCRetenido = DecimalUtil.ZERO ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "cli ", "")+GXutil.trim( GXutil.str( AV8CliCod, 6, 0))+httpContext.getMessage( " emp ", "")+GXutil.trim( GXutil.str( AV12EmpCod, 4, 0))+httpContext.getMessage( " leg ", "")+GXutil.trim( GXutil.str( ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), 8, 0))+httpContext.getMessage( " ano ", "")+GXutil.trim( GXutil.str( AV28LiqPerAno, 4, 0))) ;
      pr_default.dynParam(9, new Object[]{ new Object[]{
                                           Integer.valueOf(A31LiqNro) ,
                                           AV193LiquidacionesNoSujetas ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Short.valueOf(AV17i) ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Short.valueOf(A585LiqPerAno) ,
                                           Short.valueOf(AV28LiqPerAno) ,
                                           A394DConCodigo ,
                                           AV137retencionConCodigo ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV12EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00UO11 */
      pr_default.execute(9, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV28LiqPerAno), AV137retencionConCodigo});
      while ( (pr_default.getStatus(9) != 101) )
      {
         A2112LiqRelNro = P00UO11_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO11_n2112LiqRelNro[0] ;
         A394DConCodigo = P00UO11_A394DConCodigo[0] ;
         A31LiqNro = P00UO11_A31LiqNro[0] ;
         A585LiqPerAno = P00UO11_A585LiqPerAno[0] ;
         A6LegNumero = P00UO11_A6LegNumero[0] ;
         A1EmpCod = P00UO11_A1EmpCod[0] ;
         A3CliCod = P00UO11_A3CliCod[0] ;
         A764LiqDImpReCalcu = P00UO11_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P00UO11_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00UO11_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO11_n2112LiqRelNro[0] ;
         A585LiqPerAno = P00UO11_A585LiqPerAno[0] ;
         if ( A6LegNumero == ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() )
         {
            AV160AuxLiqDImpCalcu = A764LiqDImpReCalcu ;
            AV136F1357LCRetenido = AV136F1357LCRetenido.add(AV160AuxLiqDImpCalcu) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "nosuj &F1357LCRetenido ", "")+GXutil.trim( GXutil.str( AV136F1357LCRetenido, 16, 2))+httpContext.getMessage( " &AuxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV160AuxLiqDImpCalcu, 14, 2))) ;
         }
         pr_default.readNext(9);
      }
      pr_default.close(9);
      GXt_char2 = AV306primeraQuincenaTLiqCod ;
      GXt_char1 = AV306primeraQuincenaTLiqCod ;
      GXv_char10[0] = GXt_char1 ;
      new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char10) ;
      f1357.this.GXt_char1 = GXv_char10[0] ;
      GXv_char9[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
      f1357.this.GXt_char2 = GXv_char9[0] ;
      AV306primeraQuincenaTLiqCod = GXt_char2 ;
      /* Using cursor P00UO12 */
      pr_default.execute(10, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV28LiqPerAno), AV259adelantoRetencionConCodigo});
      while ( (pr_default.getStatus(10) != 101) )
      {
         A31LiqNro = P00UO12_A31LiqNro[0] ;
         A2112LiqRelNro = P00UO12_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO12_n2112LiqRelNro[0] ;
         A394DConCodigo = P00UO12_A394DConCodigo[0] ;
         A585LiqPerAno = P00UO12_A585LiqPerAno[0] ;
         A6LegNumero = P00UO12_A6LegNumero[0] ;
         A1EmpCod = P00UO12_A1EmpCod[0] ;
         A3CliCod = P00UO12_A3CliCod[0] ;
         A764LiqDImpReCalcu = P00UO12_A764LiqDImpReCalcu[0] ;
         A81LiqDSecuencial = P00UO12_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00UO12_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO12_n2112LiqRelNro[0] ;
         A585LiqPerAno = P00UO12_A585LiqPerAno[0] ;
         if ( A6LegNumero == ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() )
         {
            AV160AuxLiqDImpCalcu = A764LiqDImpReCalcu ;
            AV136F1357LCRetenido = AV136F1357LCRetenido.add(AV160AuxLiqDImpCalcu) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "ade nosuj &F1357LCRetenido ", "")+GXutil.trim( GXutil.str( AV136F1357LCRetenido, 16, 2))+httpContext.getMessage( " &AuxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV160AuxLiqDImpCalcu, 14, 2))) ;
         }
         pr_default.readNext(10);
      }
      pr_default.close(10);
      AV206remuneracionesNoAlcanzadas = DecimalUtil.ZERO ;
      pr_default.dynParam(11, new Object[]{ new Object[]{
                                           Integer.valueOf(A31LiqNro) ,
                                           AV193LiquidacionesNoSujetas ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Short.valueOf(AV17i) ,
                                           A464DTipoConCod ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Short.valueOf(A585LiqPerAno) ,
                                           Short.valueOf(AV28LiqPerAno) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV12EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00UO13 */
      pr_default.execute(11, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV28LiqPerAno)});
      while ( (pr_default.getStatus(11) != 101) )
      {
         A2112LiqRelNro = P00UO13_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO13_n2112LiqRelNro[0] ;
         A464DTipoConCod = P00UO13_A464DTipoConCod[0] ;
         A31LiqNro = P00UO13_A31LiqNro[0] ;
         A585LiqPerAno = P00UO13_A585LiqPerAno[0] ;
         A6LegNumero = P00UO13_A6LegNumero[0] ;
         A1EmpCod = P00UO13_A1EmpCod[0] ;
         A3CliCod = P00UO13_A3CliCod[0] ;
         A764LiqDImpReCalcu = P00UO13_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P00UO13_A394DConCodigo[0] ;
         A397DLiqPeriodo = P00UO13_A397DLiqPeriodo[0] ;
         A468DSubTipoConCod1 = P00UO13_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P00UO13_n468DSubTipoConCod1[0] ;
         A732DSubTipoConCod2 = P00UO13_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P00UO13_n732DSubTipoConCod2[0] ;
         A1122DAplIIGG = P00UO13_A1122DAplIIGG[0] ;
         n1122DAplIIGG = P00UO13_n1122DAplIIGG[0] ;
         A81LiqDSecuencial = P00UO13_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P00UO13_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO13_n2112LiqRelNro[0] ;
         A585LiqPerAno = P00UO13_A585LiqPerAno[0] ;
         if ( A6LegNumero == ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() )
         {
            AV206remuneracionesNoAlcanzadas = AV206remuneracionesNoAlcanzadas.add(A764LiqDImpReCalcu) ;
            AV228h = (short)(1) ;
            while ( AV228h <= AV229noHabConCodigo.size() )
            {
               if ( GXutil.strcmp(A394DConCodigo, (String)AV229noHabConCodigo.elementAt(-1+AV228h)) == 0 )
               {
                  AV210NoHabituales = AV210NoHabituales.add(A764LiqDImpReCalcu) ;
                  AV230NoHabitualesNoAlcanzada = AV230NoHabitualesNoAlcanzada.add(A764LiqDImpReCalcu) ;
                  if (true) break;
               }
               AV228h = (short)(AV228h+1) ;
            }
            if ( ( GXutil.strcmp(A394DConCodigo, AV246sacConCodigo) == 0 ) || ( GXutil.strcmp(A394DConCodigo, AV245SacProporConCodigo) == 0 ) )
            {
               if ( GXutil.month( A397DLiqPeriodo) <= 6 )
               {
                  AV247sacCuo1NoAlcanzado = AV247sacCuo1NoAlcanzado.add(AV160AuxLiqDImpCalcu) ;
               }
               else
               {
                  AV248sacCuo2NoAlcanzado = AV248sacCuo2NoAlcanzado.add(AV160AuxLiqDImpCalcu) ;
               }
            }
            else
            {
               if ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 )
               {
                  Cond_result = true ;
               }
               else
               {
                  Cond_result = false ;
               }
               if ( Cond_result )
               {
                  AV32HorasExtras = AV32HorasExtras.add(A764LiqDImpReCalcu) ;
                  AV238HorasExtrasNoAlcanzadas = AV238HorasExtrasNoAlcanzadas.add(A764LiqDImpReCalcu) ;
               }
               else
               {
                  if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV222remuEspecial_DSubTipoConCod1) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV223movvia_DSubTipoConCod2) == 0 ) )
                  {
                     AV216movilidadYViaticos = AV216movilidadYViaticos.add(A764LiqDImpReCalcu) ;
                     AV239MovViaNoAlcanzado = AV239MovViaNoAlcanzado.add(A764LiqDImpReCalcu) ;
                  }
                  else
                  {
                     if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV222remuEspecial_DSubTipoConCod1) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV225docentes_DSubTipoConCod2) == 0 ) )
                     {
                        AV224docentes = AV224docentes.add(A764LiqDImpReCalcu) ;
                        AV240docenNoAlcanzados = AV240docenNoAlcanzados.add(A764LiqDImpReCalcu) ;
                     }
                     else
                     {
                        GXv_char10[0] = AV321AplIIGGExenCon ;
                        new web.getapliiggexencon(remoteHandle, context).execute( AV8CliCod, A1122DAplIIGG, GXv_char10) ;
                        f1357.this.AV321AplIIGGExenCon = GXv_char10[0] ;
                        if ( GXutil.strcmp(AV321AplIIGGExenCon, AV46bonosExentosConCodigo) == 0 )
                        {
                           AV41BonosProductividad = AV41BonosProductividad.add(A764LiqDImpReCalcu) ;
                           AV241BonosNoAlcanzados = AV241BonosNoAlcanzados.add(A764LiqDImpReCalcu) ;
                        }
                        else
                        {
                           if ( GXutil.strcmp(AV321AplIIGGExenCon, AV304fallosCajaExentosConCodigo) == 0 )
                           {
                              AV300FallosDeCaja = AV300FallosDeCaja.add(A764LiqDImpReCalcu) ;
                              AV301FallosNoAlzanzados = AV301FallosNoAlzanzados.add(A764LiqDImpReCalcu) ;
                           }
                           else
                           {
                              if ( GXutil.strcmp(AV321AplIIGGExenCon, AV305simNatExentosConCodigo) == 0 )
                              {
                                 AV302SimilarNaturaleza = AV302SimilarNaturaleza.add(A764LiqDImpReCalcu) ;
                                 AV303similarNoAlcanzado = AV303similarNoAlcanzado.add(A764LiqDImpReCalcu) ;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
         pr_default.readNext(11);
      }
      pr_default.close(11);
      AV313liquidoSac1 = false ;
      AV314liquidoSac2 = false ;
      AV309anticiposDeSac1erSemestre = DecimalUtil.ZERO ;
      AV310anticiposDeSac2doSemestre = DecimalUtil.ZERO ;
      AV348GXLvl1096 = (byte)(0) ;
      pr_default.dynParam(12, new Object[]{ new Object[]{
                                           Integer.valueOf(A31LiqNro) ,
                                           AV192LiquidacionesSujetas ,
                                           Integer.valueOf(A6LegNumero) ,
                                           Short.valueOf(AV17i) ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Short.valueOf(A585LiqPerAno) ,
                                           Short.valueOf(AV28LiqPerAno) ,
                                           Integer.valueOf(AV8CliCod) ,
                                           Short.valueOf(AV12EmpCod) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) } ,
                                           new int[]{
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.SHORT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.SHORT
                                           }
      });
      /* Using cursor P00UO14 */
      pr_default.execute(12, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV12EmpCod), Short.valueOf(AV28LiqPerAno)});
      while ( (pr_default.getStatus(12) != 101) )
      {
         brkUO15 = false ;
         A3CliCod = P00UO14_A3CliCod[0] ;
         A1EmpCod = P00UO14_A1EmpCod[0] ;
         A585LiqPerAno = P00UO14_A585LiqPerAno[0] ;
         A764LiqDImpReCalcu = P00UO14_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P00UO14_A394DConCodigo[0] ;
         A464DTipoConCod = P00UO14_A464DTipoConCod[0] ;
         A31LiqNro = P00UO14_A31LiqNro[0] ;
         A1122DAplIIGG = P00UO14_A1122DAplIIGG[0] ;
         n1122DAplIIGG = P00UO14_n1122DAplIIGG[0] ;
         A507LiqDCalculado = P00UO14_A507LiqDCalculado[0] ;
         A393DConDescrip = P00UO14_A393DConDescrip[0] ;
         A468DSubTipoConCod1 = P00UO14_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P00UO14_n468DSubTipoConCod1[0] ;
         A732DSubTipoConCod2 = P00UO14_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P00UO14_n732DSubTipoConCod2[0] ;
         A397DLiqPeriodo = P00UO14_A397DLiqPeriodo[0] ;
         A6LegNumero = P00UO14_A6LegNumero[0] ;
         A2112LiqRelNro = P00UO14_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO14_n2112LiqRelNro[0] ;
         A81LiqDSecuencial = P00UO14_A81LiqDSecuencial[0] ;
         A585LiqPerAno = P00UO14_A585LiqPerAno[0] ;
         A2112LiqRelNro = P00UO14_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P00UO14_n2112LiqRelNro[0] ;
         if ( A6LegNumero == ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() )
         {
            AV348GXLvl1096 = (byte)(1) ;
            AV324mesRemuneracionBrutaAlcanzada = DecimalUtil.doubleToDec(0) ;
            while ( (pr_default.getStatus(12) != 101) && ( P00UO14_A3CliCod[0] == A3CliCod ) && ( P00UO14_A1EmpCod[0] == A1EmpCod ) && ( P00UO14_A6LegNumero[0] == A6LegNumero ) && ( P00UO14_A585LiqPerAno[0] == A585LiqPerAno ) )
            {
               if ( ! ( GXutil.dateCompare(GXutil.resetTime(P00UO14_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
               {
                  if (true) break;
               }
               brkUO15 = false ;
               A764LiqDImpReCalcu = P00UO14_A764LiqDImpReCalcu[0] ;
               A394DConCodigo = P00UO14_A394DConCodigo[0] ;
               A464DTipoConCod = P00UO14_A464DTipoConCod[0] ;
               A31LiqNro = P00UO14_A31LiqNro[0] ;
               A1122DAplIIGG = P00UO14_A1122DAplIIGG[0] ;
               n1122DAplIIGG = P00UO14_n1122DAplIIGG[0] ;
               A507LiqDCalculado = P00UO14_A507LiqDCalculado[0] ;
               A393DConDescrip = P00UO14_A393DConDescrip[0] ;
               A468DSubTipoConCod1 = P00UO14_A468DSubTipoConCod1[0] ;
               n468DSubTipoConCod1 = P00UO14_n468DSubTipoConCod1[0] ;
               A732DSubTipoConCod2 = P00UO14_A732DSubTipoConCod2[0] ;
               n732DSubTipoConCod2 = P00UO14_n732DSubTipoConCod2[0] ;
               A81LiqDSecuencial = P00UO14_A81LiqDSecuencial[0] ;
               if ( A6LegNumero == ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue() )
               {
                  if ( (AV192LiquidacionesSujetas.indexof(A31LiqNro)>0) )
                  {
                     AV160AuxLiqDImpCalcu = A764LiqDImpReCalcu ;
                     new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "remu1 DConCodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &sacGravadoConCodigo ", "")+GXutil.trim( AV29sacGravadoConCodigo)) ;
                     if ( GXutil.strcmp(A464DTipoConCod, "DES_ARG") != 0 )
                     {
                        new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&noHabConCodigo.count ", "")+GXutil.trim( GXutil.str( AV229noHabConCodigo.size(), 9, 0))) ;
                        AV228h = (short)(1) ;
                        while ( AV228h <= AV229noHabConCodigo.size() )
                        {
                           if ( GXutil.strcmp(A394DConCodigo, (String)AV229noHabConCodigo.elementAt(-1+AV228h)) == 0 )
                           {
                              AV210NoHabituales = AV210NoHabituales.add(AV160AuxLiqDImpCalcu) ;
                              new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "exit sospechoso", "")) ;
                              if (true) break;
                           }
                           AV228h = (short)(AV228h+1) ;
                        }
                        if ( GXutil.strcmp(A394DConCodigo, AV311anticiposDeSacConCodigo) == 0 )
                        {
                           if ( GXutil.month( A397DLiqPeriodo) <= 6 )
                           {
                              AV309anticiposDeSac1erSemestre = AV309anticiposDeSac1erSemestre.add(AV160AuxLiqDImpCalcu) ;
                           }
                           else
                           {
                              AV310anticiposDeSac2doSemestre = AV310anticiposDeSac2doSemestre.add(AV160AuxLiqDImpCalcu) ;
                           }
                        }
                        if ( GXutil.strcmp(A394DConCodigo, AV312sacLiquidadoConCodigo) == 0 )
                        {
                           if ( AV160AuxLiqDImpCalcu.doubleValue() > 0 )
                           {
                              if ( GXutil.month( A397DLiqPeriodo) <= 6 )
                              {
                                 AV313liquidoSac1 = true ;
                              }
                              else
                              {
                                 AV314liquidoSac2 = true ;
                              }
                           }
                        }
                        if ( ( GXutil.strcmp(A394DConCodigo, AV320SueldoSinSacConCodigo) == 0 ) && ( A31LiqNro == AV268parm_LiqNro ) )
                        {
                           AV319remuBrutaLiqActualSinSAC = AV319remuBrutaLiqActualSinSAC.add(AV160AuxLiqDImpCalcu) ;
                        }
                        new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "DTipoConCod ", "")+GXutil.trim( A464DTipoConCod)) ;
                        if ( ( ( GXutil.strcmp(A464DTipoConCod, "NRE_ARG") == 0 ) || ( GXutil.strcmp(A464DTipoConCod, "REM_ARG") == 0 ) ) && ! (0==A1122DAplIIGG) )
                        {
                           if ( ! AV267simulacionParaAdelanto )
                           {
                              AV324mesRemuneracionBrutaAlcanzada = AV324mesRemuneracionBrutaAlcanzada.add(AV160AuxLiqDImpCalcu) ;
                           }
                           if ( ( A31LiqNro == AV268parm_LiqNro ) && ( AV267simulacionParaAdelanto ) )
                           {
                              AV280remuBrutaLiqActual = AV280remuBrutaLiqActual.add(AV160AuxLiqDImpCalcu) ;
                              if ( A507LiqDCalculado == 0 )
                              {
                                 AV270LiqDCalculado = (byte)(0) ;
                                 new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "return simulacion", "")) ;
                                 pr_default.close(12);
                                 pr_default.close(12);
                                 returnInSub = true;
                                 if (true) return;
                              }
                           }
                           new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "Dconcodigo ", "")+GXutil.trim( A393DConDescrip)+httpContext.getMessage( "remu3 &mesRemuneracionBrutaAlcanzada ", "")+GXutil.trim( GXutil.str( AV324mesRemuneracionBrutaAlcanzada, 16, 2))+httpContext.getMessage( " &AuxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV160AuxLiqDImpCalcu, 14, 2))+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))) ;
                        }
                        if ( AV267simulacionParaAdelanto )
                        {
                           if ( GXutil.strcmp(A394DConCodigo, AV287remuneracionGravadaConCodigo) == 0 )
                           {
                              AV324mesRemuneracionBrutaAlcanzada = AV324mesRemuneracionBrutaAlcanzada.add(AV160AuxLiqDImpCalcu) ;
                           }
                           else
                           {
                              if ( ( GXutil.strcmp(A394DConCodigo, AV285baseImponible1ConCodigo) == 0 ) && ( A31LiqNro == AV268parm_LiqNro ) )
                              {
                                 AV284baseImponible1 = AV160AuxLiqDImpCalcu ;
                              }
                           }
                        }
                        if ( GXutil.strcmp(A394DConCodigo, AV118dedEspecialIncrementadaConCodigo) == 0 )
                        {
                           AV194DeduccionEspecialIncrementadaAplicada = AV194DeduccionEspecialIncrementadaAplicada.add(AV160AuxLiqDImpCalcu) ;
                        }
                        else
                        {
                           if ( GXutil.strcmp(A394DConCodigo, AV29sacGravadoConCodigo) == 0 )
                           {
                              new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "DLiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( A397DLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                              if ( GXutil.month( A397DLiqPeriodo) <= 6 )
                              {
                                 AV30SacCuo1Gra = AV30SacCuo1Gra.add(AV160AuxLiqDImpCalcu) ;
                              }
                              else
                              {
                                 AV31SacCuo2Gra = AV31SacCuo2Gra.add(AV160AuxLiqDImpCalcu) ;
                              }
                           }
                           else
                           {
                              if ( GXutil.strcmp(A394DConCodigo, AV40sacExentoConCodigo) == 0 )
                              {
                                 if ( GXutil.month( A397DLiqPeriodo) <= 6 )
                                 {
                                    AV38SacCuo1Exen = AV38SacCuo1Exen.add(AV160AuxLiqDImpCalcu) ;
                                 }
                                 else
                                 {
                                    AV39SacCuo2Exen = AV39SacCuo2Exen.add(AV160AuxLiqDImpCalcu) ;
                                 }
                              }
                              else
                              {
                                 if ( GXutil.strcmp(A394DConCodigo, AV219ExenExtConCodigo) == 0 )
                                 {
                                    AV35ExenExt = AV35ExenExt.add(AV160AuxLiqDImpCalcu) ;
                                    GXt_char2 = AV234horExt100PcConCodigo ;
                                    GXt_char1 = AV234horExt100PcConCodigo ;
                                    GXv_char10[0] = GXt_char1 ;
                                    new web.conceptohorasextras100_codigoparam(remoteHandle, context).execute( GXv_char10) ;
                                    f1357.this.GXt_char1 = GXv_char10[0] ;
                                    GXv_char9[0] = GXt_char2 ;
                                    new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char9) ;
                                    f1357.this.GXt_char2 = GXv_char9[0] ;
                                    AV234horExt100PcConCodigo = GXt_char2 ;
                                    new web.esnohabitualseguncoleccion(remoteHandle, context).execute( AV8CliCod, AV234horExt100PcConCodigo, AV229noHabConCodigo, "", "", AV233esNoHabitual) ;
                                    if ( AV233esNoHabitual )
                                    {
                                       AV217NoHabExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV217NoHabExen).add(AV160AuxLiqDImpCalcu))) ;
                                    }
                                 }
                                 else
                                 {
                                    if ( GXutil.strcmp(A394DConCodigo, AV262descuentosSobreGravadoConCodigo) == 0 )
                                    {
                                       AV261descuentosSobreGravadoLiqDImpCalcu = AV261descuentosSobreGravadoLiqDImpCalcu.add(AV160AuxLiqDImpCalcu) ;
                                    }
                                    else
                                    {
                                       if ( ( GXutil.strcmp(A394DConCodigo, AV46bonosExentosConCodigo) == 0 ) || ( GXutil.strcmp(A394DConCodigo, AV304fallosCajaExentosConCodigo) == 0 ) || ( GXutil.strcmp(A394DConCodigo, AV305simNatExentosConCodigo) == 0 ) )
                                       {
                                          if ( GXutil.strcmp(A394DConCodigo, AV46bonosExentosConCodigo) == 0 )
                                          {
                                             AV42BonosExen = AV42BonosExen.add(AV160AuxLiqDImpCalcu) ;
                                             new web.esnohabitualseguncoleccion(remoteHandle, context).execute( AV8CliCod, "", AV229noHabConCodigo, AV44bonosprod_DSubTipoConCod1, AV45bonosprod_DSubTipoConCod2, AV233esNoHabitual) ;
                                             if ( AV233esNoHabitual )
                                             {
                                                AV217NoHabExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV217NoHabExen).add(AV160AuxLiqDImpCalcu))) ;
                                             }
                                          }
                                          else
                                          {
                                             if ( GXutil.strcmp(A394DConCodigo, AV304fallosCajaExentosConCodigo) == 0 )
                                             {
                                                AV297FallosExen = AV297FallosExen.add(AV160AuxLiqDImpCalcu) ;
                                             }
                                             else
                                             {
                                                AV299SimilaresExen = AV299SimilaresExen.add(AV160AuxLiqDImpCalcu) ;
                                             }
                                          }
                                       }
                                       else
                                       {
                                          if ( GXutil.strcmp(A394DConCodigo, AV220movviaExentosConCodigo) == 0 )
                                          {
                                             AV215MovViaExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV215MovViaExen).add(AV160AuxLiqDImpCalcu))) ;
                                             new web.esnohabitualseguncoleccion(remoteHandle, context).execute( AV8CliCod, "", AV229noHabConCodigo, AV222remuEspecial_DSubTipoConCod1, AV223movvia_DSubTipoConCod2, AV233esNoHabitual) ;
                                             if ( AV233esNoHabitual )
                                             {
                                                AV217NoHabExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV217NoHabExen).add(AV160AuxLiqDImpCalcu))) ;
                                             }
                                          }
                                          else
                                          {
                                             if ( GXutil.strcmp(A394DConCodigo, AV221perDocMatExentosConCodigo) == 0 )
                                             {
                                                AV214DocenExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV214DocenExen).add(AV160AuxLiqDImpCalcu))) ;
                                                new web.esnohabitualseguncoleccion(remoteHandle, context).execute( AV8CliCod, "", AV229noHabConCodigo, AV222remuEspecial_DSubTipoConCod1, AV225docentes_DSubTipoConCod2, AV233esNoHabitual) ;
                                                if ( AV233esNoHabitual )
                                                {
                                                   AV217NoHabExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV217NoHabExen).add(AV160AuxLiqDImpCalcu))) ;
                                                }
                                             }
                                             else
                                             {
                                                if ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipoextras(remoteHandle, context).executeUdp( )) == 0 )
                                                {
                                                   Cond_result = true ;
                                                }
                                                else
                                                {
                                                   Cond_result = false ;
                                                }
                                                if ( Cond_result )
                                                {
                                                   AV32HorasExtras = AV32HorasExtras.add(AV160AuxLiqDImpCalcu) ;
                                                }
                                                else
                                                {
                                                   GXv_char10[0] = AV321AplIIGGExenCon ;
                                                   new web.getapliiggexencon(remoteHandle, context).execute( AV8CliCod, A1122DAplIIGG, GXv_char10) ;
                                                   f1357.this.AV321AplIIGGExenCon = GXv_char10[0] ;
                                                   if ( ( GXutil.strcmp(AV321AplIIGGExenCon, AV46bonosExentosConCodigo) == 0 ) || ( GXutil.strcmp(AV321AplIIGGExenCon, AV304fallosCajaExentosConCodigo) == 0 ) || ( GXutil.strcmp(AV321AplIIGGExenCon, AV305simNatExentosConCodigo) == 0 ) )
                                                   {
                                                      if ( GXutil.strcmp(AV321AplIIGGExenCon, AV46bonosExentosConCodigo) == 0 )
                                                      {
                                                         AV41BonosProductividad = AV41BonosProductividad.add(AV160AuxLiqDImpCalcu) ;
                                                      }
                                                      else
                                                      {
                                                         if ( GXutil.strcmp(AV321AplIIGGExenCon, AV304fallosCajaExentosConCodigo) == 0 )
                                                         {
                                                            AV300FallosDeCaja = AV300FallosDeCaja.add(AV160AuxLiqDImpCalcu) ;
                                                         }
                                                         else
                                                         {
                                                            AV302SimilarNaturaleza = AV302SimilarNaturaleza.add(AV160AuxLiqDImpCalcu) ;
                                                         }
                                                      }
                                                   }
                                                   else
                                                   {
                                                      if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV222remuEspecial_DSubTipoConCod1) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV223movvia_DSubTipoConCod2) == 0 ) )
                                                      {
                                                         AV216movilidadYViaticos = AV216movilidadYViaticos.add(AV160AuxLiqDImpCalcu) ;
                                                      }
                                                      else
                                                      {
                                                         if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV222remuEspecial_DSubTipoConCod1) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV225docentes_DSubTipoConCod2) == 0 ) )
                                                         {
                                                            AV224docentes = AV224docentes.add(AV160AuxLiqDImpCalcu) ;
                                                         }
                                                         else
                                                         {
                                                            if ( ( GXutil.strcmp(A468DSubTipoConCod1, AV222remuEspecial_DSubTipoConCod1) == 0 ) && ( GXutil.strcmp(A732DSubTipoConCod2, AV227copmenTeletrab_DSubTipoConCod2) == 0 ) )
                                                            {
                                                               AV226TeletrabajoExen = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV226TeletrabajoExen).add(AV160AuxLiqDImpCalcu))) ;
                                                            }
                                                         }
                                                      }
                                                   }
                                                }
                                             }
                                          }
                                       }
                                    }
                                 }
                              }
                           }
                        }
                     }
                     else
                     {
                        GXv_boolean14[0] = AV56SubTDescuLey ;
                        new web.gettipodescuentoley(remoteHandle, context).execute( A464DTipoConCod, A468DSubTipoConCod1, GXv_boolean14) ;
                        f1357.this.AV56SubTDescuLey = GXv_boolean14[0] ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "DTipoConCod ", "")+GXutil.trim( A464DTipoConCod)+httpContext.getMessage( " DSubTipoConCod1 ", "")+GXutil.trim( A468DSubTipoConCod1)+httpContext.getMessage( " &SubTDescuLey ", "")+GXutil.trim( GXutil.booltostr( AV56SubTDescuLey))) ;
                        if ( AV56SubTDescuLey )
                        {
                           if ( ( AV267simulacionParaAdelanto ) && ( A31LiqNro == AV268parm_LiqNro ) )
                           {
                              AV283descuentoLiqActual = AV283descuentoLiqActual.add(AV160AuxLiqDImpCalcu) ;
                           }
                           new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "jub 1", "")) ;
                           if ( ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipojubilacion(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipopami(remoteHandle, context).executeUdp( )) == 0 ) )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              AV54F1357_DeduccionesGenerales.setgxTv_SdtF1357_DeduccionesGenerales_Jub( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Jub().add(AV160AuxLiqDImpCalcu) );
                              new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "jub 2 &AuxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Jub(), 16, 2))) ;
                           }
                           else
                           {
                              if ( ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipoobrasocial(remoteHandle, context).executeUdp( )) == 0 ) || ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipoobrasocialadherentes(remoteHandle, context).executeUdp( )) == 0 ) )
                              {
                                 Cond_result = true ;
                              }
                              else
                              {
                                 Cond_result = false ;
                              }
                              if ( Cond_result )
                              {
                                 AV54F1357_DeduccionesGenerales.setgxTv_SdtF1357_DeduccionesGenerales_Os( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Os().add(AV160AuxLiqDImpCalcu) );
                              }
                              else
                              {
                                 if ( GXutil.strcmp(A468DSubTipoConCod1, new web.subtipocuotasindical(remoteHandle, context).executeUdp( )) == 0 )
                                 {
                                    Cond_result = true ;
                                 }
                                 else
                                 {
                                    Cond_result = false ;
                                 }
                                 if ( Cond_result )
                                 {
                                    AV54F1357_DeduccionesGenerales.setgxTv_SdtF1357_DeduccionesGenerales_Cuotasin( AV54F1357_DeduccionesGenerales.getgxTv_SdtF1357_DeduccionesGenerales_Cuotasin().add(AV160AuxLiqDImpCalcu) );
                                 }
                              }
                           }
                        }
                        else
                        {
                           if ( GXutil.strcmp(A394DConCodigo, AV137retencionConCodigo) == 0 )
                           {
                              Cond_result = true ;
                           }
                           else
                           {
                              Cond_result = false ;
                           }
                           if ( Cond_result )
                           {
                              AV136F1357LCRetenido = AV136F1357LCRetenido.add(AV160AuxLiqDImpCalcu) ;
                              new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "si suj &F1357LCRetenido ", "")+GXutil.trim( GXutil.str( AV136F1357LCRetenido, 16, 2))+httpContext.getMessage( " &AuxLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV160AuxLiqDImpCalcu, 14, 2))) ;
                           }
                        }
                     }
                  }
               }
               brkUO15 = true ;
               pr_default.readNext(12);
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( " dliqperiod ", "")+GXutil.trim( localUtil.dtoc( A397DLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &mesRemuneracionBrutaAlcanzada ", "")+GXutil.trim( GXutil.str( AV324mesRemuneracionBrutaAlcanzada, 16, 2))) ;
            if ( AV324mesRemuneracionBrutaAlcanzada.doubleValue() > 0 )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV27RemuneracionBrutaAlcanzada = AV27RemuneracionBrutaAlcanzada.add(AV324mesRemuneracionBrutaAlcanzada) ;
               AV77mni = AV77mni.add(AV325mniX1) ;
               AV104F1357LDPConyuge = AV104F1357LDPConyuge.add(AV329F1357LDPConyugeX1) ;
               AV101F1357LDPEspecial = AV101F1357LDPEspecial.add(AV330F1357LDPEspecialX1) ;
               AV108ded_hijo = AV108ded_hijo.add(AV331ded_hijoX1) ;
               AV112ded_hijo_incap = AV112ded_hijo_incap.add(DecimalUtil.doubleToDec(AV333ded_hijo_incapX1)) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( " suma ", "")+GXutil.trim( GXutil.str( AV27RemuneracionBrutaAlcanzada, 16, 2))) ;
            }
         }
         if ( ! brkUO15 )
         {
            brkUO15 = true ;
            pr_default.readNext(12);
         }
      }
      pr_default.close(12);
      if ( AV348GXLvl1096 == 0 )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "remu none", "")) ;
      }
      GXv_decimal20[0] = AV110prc_ded_hijos ;
      new web.porcentajededuccionhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), false, AV20LiqPeriodo, GXv_decimal20) ;
      f1357.this.AV110prc_ded_hijos = GXv_decimal20[0] ;
      AV107F1357LDPHijosImporte = AV108ded_hijo.multiply((AV105F1357LDPCantHijos.add(AV292F1357LDPCantHij100PC))).multiply(AV110prc_ded_hijos) ;
      GXv_decimal20[0] = AV113prc_ded_hijos_incap ;
      new web.porcentajededuccionhijos(remoteHandle, context).execute( AV8CliCod, AV12EmpCod, ((Number) AV16Legnumero.elementAt(-1+AV17i)).intValue(), true, AV20LiqPeriodo, GXv_decimal20) ;
      f1357.this.AV113prc_ded_hijos_incap = GXv_decimal20[0] ;
      AV111F1357LDPHijosIncapImp = AV112ded_hijo_incap.multiply((AV106F1357LDPCantHijIncap.add(AV293F1357ldpcAntHijIncap100pc))).multiply(AV113prc_ded_hijos_incap) ;
      AV207BonosGravados = AV41BonosProductividad.subtract(AV42BonosExen).subtract(AV241BonosNoAlcanzados) ;
      AV296FallosGra = AV300FallosDeCaja.subtract(AV297FallosExen).subtract(AV301FallosNoAlzanzados) ;
      AV298SimilaresGra = AV302SimilarNaturaleza.subtract(AV299SimilaresExen).subtract(AV303similarNoAlcanzado) ;
      AV36RemuneracionExenta = AV42BonosExen.add(AV297FallosExen).add(AV299SimilaresExen).add(DecimalUtil.doubleToDec(AV215MovViaExen)).add(DecimalUtil.doubleToDec(AV214DocenExen)).add(AV35ExenExt).add(AV235TotalmenteExentos) ;
      AV209NoHabGra = AV210NoHabituales.subtract(DecimalUtil.doubleToDec(AV217NoHabExen)).subtract(AV230NoHabitualesNoAlcanzada) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&RemuneracionBrutaAlcanzada ", "")+GXutil.trim( GXutil.str( AV27RemuneracionBrutaAlcanzada, 16, 2))+httpContext.getMessage( " &RemuneracionExenta ", "")+GXutil.trim( GXutil.str( AV36RemuneracionExenta, 16, 2))+httpContext.getMessage( " &SacCuo1Gra ", "")+GXutil.trim( GXutil.str( AV30SacCuo1Gra, 16, 2))) ;
      AV208HorExtGra = AV32HorasExtras.subtract(AV35ExenExt).subtract(AV238HorasExtrasNoAlcanzadas) ;
      AV212MovViaGra = (short)(DecimalUtil.decToDouble(AV216movilidadYViaticos.subtract(DecimalUtil.doubleToDec(AV215MovViaExen)).subtract(AV239MovViaNoAlcanzado))) ;
      AV213DocenGra = (short)(DecimalUtil.decToDouble(AV224docentes.subtract(DecimalUtil.doubleToDec(AV214DocenExen)).add(AV240docenNoAlcanzados))) ;
      AV243ExenSinExt = (short)(DecimalUtil.decToDouble(AV36RemuneracionExenta.subtract(AV35ExenExt))) ;
      AV18F1357_Remuneracion = (web.SdtF1357_Remuneracion)new web.SdtF1357_Remuneracion(remoteHandle, context);
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Brugra( AV27RemuneracionBrutaAlcanzada );
      if ( ! AV267simulacionParaAdelanto )
      {
         Cond_result = true ;
      }
      else
      {
         Cond_result = false ;
      }
      if ( Cond_result )
      {
         AV286RemuneracionBrutaAlcanzadaRestar = AV36RemuneracionExenta.add(AV30SacCuo1Gra).add(AV31SacCuo2Gra).add(AV207BonosGravados).add(AV208HorExtGra).add(AV209NoHabGra).add(DecimalUtil.doubleToDec(AV212MovViaGra)).add(DecimalUtil.doubleToDec(AV213DocenGra)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV337Pgmname, httpContext.getMessage( "&RemuneracionBrutaAlcanzadaRestar ", "")+GXutil.trim( GXutil.str( AV286RemuneracionBrutaAlcanzadaRestar, 16, 2))+httpContext.getMessage( " &RemuneracionExenta ", "")+GXutil.trim( GXutil.str( AV36RemuneracionExenta, 16, 2))) ;
         AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Brugra( AV18F1357_Remuneracion.getgxTv_SdtF1357_Remuneracion_Brugra().subtract(AV286RemuneracionBrutaAlcanzadaRestar) );
      }
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Nohabgra( AV209NoHabGra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Saccuo1gra( AV30SacCuo1Gra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Saccuo2gra( AV31SacCuo2Gra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Horextgra( AV208HorExtGra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Movviagra( DecimalUtil.doubleToDec(AV212MovViaGra) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Docengra( DecimalUtil.doubleToDec(AV213DocenGra) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Exensinext( DecimalUtil.doubleToDec(AV243ExenSinExt) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Exenext( AV35ExenExt );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Movviaexen( DecimalUtil.doubleToDec(AV215MovViaExen) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Docenexen( DecimalUtil.doubleToDec(AV214DocenExen) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Nohabexen( DecimalUtil.doubleToDec(AV217NoHabExen).add(AV230NoHabitualesNoAlcanzada) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Saccuo1exen( AV38SacCuo1Exen.add(AV247sacCuo1NoAlcanzado) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Saccuo2exen( AV39SacCuo2Exen.add(AV248sacCuo2NoAlcanzado) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Ajustesgra( AV51AjustesGra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Ajustesexen( AV52AjustesExen );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Exenley27549( AV53ExenLey27549 );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Teletrabajoexen( DecimalUtil.doubleToDec(AV226TeletrabajoExen) );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Bonosgra( AV207BonosGravados );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Bonosexen( AV42BonosExen );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Fallosgra( AV296FallosGra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Fallosexen( AV297FallosExen );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Similaresgra( AV298SimilaresGra );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Similaresexen( AV299SimilaresExen );
      AV18F1357_Remuneracion.setgxTv_SdtF1357_Remuneracion_Militarexen( DecimalUtil.doubleToDec(0) );
   }

   protected void cleanup( )
   {
      this.aP11[0] = f1357.this.AV147F1357LCDeterminado;
      this.aP12[0] = f1357.this.AV136F1357LCRetenido;
      this.aP13[0] = f1357.this.AV270LiqDCalculado;
      this.aP14[0] = f1357.this.AV280remuBrutaLiqActual;
      this.aP15[0] = f1357.this.AV315LiqDLog;
      Application.commitDataStores(context, remoteHandle, pr_default, "f1357");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV147F1357LCDeterminado = DecimalUtil.ZERO ;
      AV136F1357LCRetenido = DecimalUtil.ZERO ;
      AV280remuBrutaLiqActual = DecimalUtil.ZERO ;
      AV315LiqDLog = "" ;
      AV161parametroPalabra = "" ;
      AV337Pgmname = "" ;
      AV16Legnumero = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      GXv_char4 = new String[1] ;
      GXv_int5 = new long[1] ;
      GXv_char3 = new String[1] ;
      GXv_char6 = new String[1] ;
      GXv_char7 = new String[1] ;
      AV13F1357CCuitAgente = "" ;
      AV10F1357CPer = "" ;
      AV320SueldoSinSacConCodigo = "" ;
      AV311anticiposDeSacConCodigo = "" ;
      AV312sacLiquidadoConCodigo = "" ;
      AV285baseImponible1ConCodigo = "" ;
      AV246sacConCodigo = "" ;
      AV245SacProporConCodigo = "" ;
      AV262descuentosSobreGravadoConCodigo = "" ;
      AV287remuneracionGravadaConCodigo = "" ;
      AV44bonosprod_DSubTipoConCod1 = "" ;
      AV45bonosprod_DSubTipoConCod2 = "" ;
      AV222remuEspecial_DSubTipoConCod1 = "" ;
      AV223movvia_DSubTipoConCod2 = "" ;
      AV225docentes_DSubTipoConCod2 = "" ;
      AV227copmenTeletrab_DSubTipoConCod2 = "" ;
      AV118dedEspecialIncrementadaConCodigo = "" ;
      AV167otroEmplOSConCodigo = "" ;
      AV188otroEmplSegSocConCodigo = "" ;
      AV187otroEmplSindicatoConCodigo = "" ;
      AV198OtrosEmplSACConCodigo = "" ;
      AV200otroEmplNoHabConCodigo = "" ;
      AV191alcanzaGananciasConCodigo = "" ;
      AV140pagosACuentaConCodigo = "" ;
      AV137retencionConCodigo = "" ;
      AV259adelantoRetencionConCodigo = "" ;
      AV29sacGravadoConCodigo = "" ;
      AV40sacExentoConCodigo = "" ;
      AV219ExenExtConCodigo = "" ;
      AV46bonosExentosConCodigo = "" ;
      AV304fallosCajaExentosConCodigo = "" ;
      AV305simNatExentosConCodigo = "" ;
      AV220movviaExentosConCodigo = "" ;
      AV221perDocMatExentosConCodigo = "" ;
      AV58primaSeguroConCodigo = "" ;
      AV164primasMixtosConCodigo = "" ;
      AV61retiroPrivadoConCodigo = "" ;
      AV165cuotapartesConCodigo = "" ;
      AV65sepelioConCodigo = "" ;
      AV68vehiculosConCodigo = "" ;
      AV72hipotecaConCodigo = "" ;
      AV75aportesSGRConCodigo = "" ;
      AV78personalDomesticoConCodigo = "" ;
      AV291educativosConCodigo = "" ;
      AV80alquilerConCodigo = "" ;
      AV82viaticosConCodigo = "" ;
      AV84induConCodigo = "" ;
      AV162otrasDeduccionesConCodigo = "" ;
      AV91donacionesConCodigo = "" ;
      AV90honorariosMedicosConCodigo = "" ;
      AV93prepagaConCodigo = "" ;
      AV87alicuotaDonaciones = DecimalUtil.ZERO ;
      AV89limiteMedicos = DecimalUtil.ZERO ;
      AV94limitePrepaga = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P00UO2_A777F1357CPer = new String[] {""} ;
      P00UO2_A784F1357CTipoPre = new byte[1] ;
      P00UO2_A1EmpCod = new short[1] ;
      P00UO2_A3CliCod = new int[1] ;
      P00UO2_A778F1357CSec = new byte[1] ;
      A777F1357CPer = "" ;
      A780F1357CCuitAgente = "" ;
      A781F1357CCodImp = "" ;
      A782F1357CCodCon = "" ;
      A783F1357CNumForm = "" ;
      A785F1357CVerSis = "" ;
      Gx_emsg = "" ;
      AV197egresoTLiqCod = "" ;
      AV256mensualTliqCod = "" ;
      AV258aguTliqCod = "" ;
      AV257vacTLiqCod = "" ;
      A32TLiqCod = "" ;
      A283LiqPeriodo = GXutil.nullDate() ;
      P00UO4_A2112LiqRelNro = new int[1] ;
      P00UO4_n2112LiqRelNro = new boolean[] {false} ;
      P00UO4_A32TLiqCod = new String[] {""} ;
      P00UO4_n32TLiqCod = new boolean[] {false} ;
      P00UO4_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00UO4_A6LegNumero = new int[1] ;
      P00UO4_A1EmpCod = new short[1] ;
      P00UO4_A3CliCod = new int[1] ;
      P00UO4_A31LiqNro = new int[1] ;
      AV55F1357_DeduccionesGeneralesOtrosEmpleos = new web.SdtF1357_DeduccionesGenerales(remoteHandle, context);
      AV54F1357_DeduccionesGenerales = new web.SdtF1357_DeduccionesGenerales(remoteHandle, context);
      AV250sdt_liquidacion = new GXBaseCollection<web.Sdtsdt_liquidacion_sdt_liquidacionItem>(web.Sdtsdt_liquidacion_sdt_liquidacionItem.class, "sdt_liquidacionItem", "PayDay", remoteHandle);
      AV192LiquidacionesSujetas = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      P00UO5_A31LiqNro = new int[1] ;
      P00UO5_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00UO5_A6LegNumero = new int[1] ;
      P00UO5_A1EmpCod = new short[1] ;
      P00UO5_A3CliCod = new int[1] ;
      P00UO5_A2112LiqRelNro = new int[1] ;
      P00UO5_n2112LiqRelNro = new boolean[] {false} ;
      AV251itemLiquidacion = new web.Sdtsdt_liquidacion_sdt_liquidacionItem(remoteHandle, context);
      AV193LiquidacionesNoSujetas = new GXSimpleCollection<Integer>(Integer.class, "internal", "");
      AV62topeSeguros = DecimalUtil.ZERO ;
      AV66topeSepelios = DecimalUtil.ZERO ;
      AV71topeHipoteca = DecimalUtil.ZERO ;
      AV201mniParaTopes = DecimalUtil.ZERO ;
      AV326mniAnual = DecimalUtil.ZERO ;
      AV334auxerror = "" ;
      AV325mniX1 = DecimalUtil.ZERO ;
      AV204ZonPorcAumenDed = DecimalUtil.ZERO ;
      AV327F1357LDPEspecialAnual = DecimalUtil.ZERO ;
      AV330F1357LDPEspecialX1 = DecimalUtil.ZERO ;
      AV328F1357LDPConyugeAnual = DecimalUtil.ZERO ;
      AV329F1357LDPConyugeX1 = DecimalUtil.ZERO ;
      AV344Ded_hijoanual = DecimalUtil.ZERO ;
      AV331ded_hijoX1 = DecimalUtil.ZERO ;
      AV332ded_hijo_incapAnual = DecimalUtil.ZERO ;
      AV151deduce_conyugeChar = "" ;
      AV105F1357LDPCantHijos = DecimalUtil.ZERO ;
      AV292F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      AV294F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      GXv_int12 = new short[1] ;
      AV163LegFecIngreso = GXutil.nullDate() ;
      GXv_date16 = new java.util.Date[1] ;
      AV21diaInicio = "" ;
      AV47gananciaNeta = DecimalUtil.ZERO ;
      A786F1357LTipoReg = "" ;
      A787F1357LCuil = "" ;
      A788F1357LPerDesd = "" ;
      A789F1357LPerHas = "" ;
      A790F1357LMeses = "" ;
      A792F1357LLargaDist = "" ;
      A793F1357LLey27424 = "" ;
      A795F1357LTeletrabajo = "" ;
      A796F1357LMilitar = "" ;
      A943F1357LLargaDistCT_40_1989 = "" ;
      A794F1357L27549 = "" ;
      AV48remuneracionGravadaTotal = DecimalUtil.ZERO ;
      AV49remuneracionExentaTotal = DecimalUtil.ZERO ;
      AV50F1357_RemuneracionOtrosEmpleos = new web.SdtF1357_Remuneracion(remoteHandle, context);
      AV199sacLiqPeriodo = GXutil.nullDate() ;
      AV186otroEmplGananciaBrutaConCodigo = "" ;
      AV183otroEmplhorasExtrasGravadasCodigo = "" ;
      AV182otroEmplhorasExtrasExentasCodigo = "" ;
      AV18F1357_Remuneracion = new web.SdtF1357_Remuneracion(remoteHandle, context);
      AV249F1357LRExenta = DecimalUtil.ZERO ;
      AV35ExenExt = DecimalUtil.ZERO ;
      AV230NoHabitualesNoAlcanzada = DecimalUtil.ZERO ;
      AV38SacCuo1Exen = DecimalUtil.ZERO ;
      AV247sacCuo1NoAlcanzado = DecimalUtil.ZERO ;
      AV39SacCuo2Exen = DecimalUtil.ZERO ;
      AV248sacCuo2NoAlcanzado = DecimalUtil.ZERO ;
      AV42BonosExen = DecimalUtil.ZERO ;
      AV297FallosExen = DecimalUtil.ZERO ;
      AV299SimilaresExen = DecimalUtil.ZERO ;
      AV289remuBrutaLiqActualConDescuento = DecimalUtil.ZERO ;
      AV283descuentoLiqActual = DecimalUtil.ZERO ;
      AV278remuBrutaTeorica = DecimalUtil.ZERO ;
      AV316remuBrutaTeoricaParaDEI = DecimalUtil.ZERO ;
      AV319remuBrutaLiqActualSinSAC = DecimalUtil.ZERO ;
      AV284baseImponible1 = DecimalUtil.ZERO ;
      A797F1357LRTipReg = "" ;
      A798F1357LRRemuneraciones = "" ;
      A799F1357LRRemuOtr = "" ;
      A800F1357LRGravada = DecimalUtil.ZERO ;
      A801F1357LRExenta = DecimalUtil.ZERO ;
      AV64F1357LDGSepelio = DecimalUtil.ZERO ;
      AV67F1357LDGRodado = DecimalUtil.ZERO ;
      AV69F1357LDGOblig = DecimalUtil.ZERO ;
      AV70F1357LDGHipoteca = DecimalUtil.ZERO ;
      AV74F1357LDGSGR = DecimalUtil.ZERO ;
      AV76F1357LDGDomes = DecimalUtil.ZERO ;
      AV290F1357LDGEducativos = DecimalUtil.ZERO ;
      AV79F1357LDGAlquiler = DecimalUtil.ZERO ;
      AV81F1357LDGViaticos = DecimalUtil.ZERO ;
      AV83F1357LDGIndu = DecimalUtil.ZERO ;
      AV85F1357LDGOtras = DecimalUtil.ZERO ;
      AV57F1357LDGSeguro = DecimalUtil.ZERO ;
      AV59F1357LDGSeguMixto = DecimalUtil.ZERO ;
      AV60F1357LDGRetPriv = DecimalUtil.ZERO ;
      AV63F1357LDGCuotapartes = DecimalUtil.ZERO ;
      AV288deducciones = DecimalUtil.ZERO ;
      AV86F1357LDGDonaciones = DecimalUtil.ZERO ;
      AV88F1357LDGMed = DecimalUtil.ZERO ;
      AV92F1357LDGPrepaga = DecimalUtil.ZERO ;
      AV95F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      AV97F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      AV98F1357LDGOtrasProf = DecimalUtil.ZERO ;
      AV99F1357LDGOtrasActores = DecimalUtil.ZERO ;
      AV100F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      A1213F1357LDGMovEmpl = DecimalUtil.ZERO ;
      A1214F1357LDGViaEmpl = DecimalUtil.ZERO ;
      A1215F1357LDGCompAna = DecimalUtil.ZERO ;
      A863F1357LDGTipReg = "" ;
      A802F1357LDGPrepaga = DecimalUtil.ZERO ;
      A803F1357LDGSeguro = DecimalUtil.ZERO ;
      A804F1357LDGSeguMixto = DecimalUtil.ZERO ;
      A805F1357LDGRetPriv = DecimalUtil.ZERO ;
      A806F1357LDGCuotapartes = DecimalUtil.ZERO ;
      A807F1357LDGSepelio = DecimalUtil.ZERO ;
      A808F1357LDGRodado = DecimalUtil.ZERO ;
      A809F1357LDGDonaciones = DecimalUtil.ZERO ;
      A810F1357LDGOblig = DecimalUtil.ZERO ;
      A811F1357LDGMed = DecimalUtil.ZERO ;
      A812F1357LDGHipoteca = DecimalUtil.ZERO ;
      A813F1357LDGSGR = DecimalUtil.ZERO ;
      A814F1357LDGOtrasCaja = DecimalUtil.ZERO ;
      A815F1357LDGAlquiler = DecimalUtil.ZERO ;
      A816F1357LDGDomes = DecimalUtil.ZERO ;
      A944F1357LDGEducativos = DecimalUtil.ZERO ;
      A817F1357LDGViaticos = DecimalUtil.ZERO ;
      A818F1357LDGIndu = DecimalUtil.ZERO ;
      A819F1357LDGOtras = DecimalUtil.ZERO ;
      AV96F1357LDGTotal = DecimalUtil.ZERO ;
      A820F1357LDGTotal = DecimalUtil.ZERO ;
      A821F1357LDGOtrasAnses = DecimalUtil.ZERO ;
      A822F1357LDGOtrasProf = DecimalUtil.ZERO ;
      A823F1357LDGOtrasActores = DecimalUtil.ZERO ;
      A824F1357LDGOtrasPrev = DecimalUtil.ZERO ;
      A825F1357LDGDescuentosLey = "" ;
      A826F1357LDGOtrDescuLey = "" ;
      AV115F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      AV116F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      A862F1357LDPTipReg = "" ;
      A827F1357LDPGNI = DecimalUtil.ZERO ;
      AV77mni = DecimalUtil.ZERO ;
      A828F1357LDPEspecial = DecimalUtil.ZERO ;
      AV101F1357LDPEspecial = DecimalUtil.ZERO ;
      A829F1357LDPEspecifica = DecimalUtil.ZERO ;
      AV102F1357LDPEspecifica = DecimalUtil.ZERO ;
      A830F1357LDPConyuge = DecimalUtil.ZERO ;
      AV104F1357LDPConyuge = DecimalUtil.ZERO ;
      A831F1357LDPCantHijos = DecimalUtil.ZERO ;
      A832F1357LDPHijosImporte = DecimalUtil.ZERO ;
      AV107F1357LDPHijosImporte = DecimalUtil.ZERO ;
      AV196F1357LDPTotalFami = DecimalUtil.ZERO ;
      AV111F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      A833F1357LDPTotalFami = DecimalUtil.ZERO ;
      AV130F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      A834F1357LDPTotalArt30 = DecimalUtil.ZERO ;
      A835F1357LDPSujAntes = DecimalUtil.ZERO ;
      A836F1357LDPIncA = DecimalUtil.ZERO ;
      A837F1357LDPIncB = DecimalUtil.ZERO ;
      A838F1357LDPRemuSuj = DecimalUtil.ZERO ;
      A839F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      AV106F1357LDPCantHijIncap = DecimalUtil.ZERO ;
      A840F1357LDPHijosIncapImp = DecimalUtil.ZERO ;
      A841F1357LDPEspIncremen1 = DecimalUtil.ZERO ;
      A842F1357LDPEspIncremen2 = DecimalUtil.ZERO ;
      A945F1357LDPCantHij100PC = DecimalUtil.ZERO ;
      A946F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      AV293F1357ldpcAntHijIncap100pc = DecimalUtil.ZERO ;
      A947F1357LDPcantHijMay18 = DecimalUtil.ZERO ;
      A948F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
      AV295F1357LDPcantHijMay18_100pc = DecimalUtil.ZERO ;
      AV139F1357CPagosCredDeb = DecimalUtil.ZERO ;
      AV141F1357LCPagosAduanta = DecimalUtil.ZERO ;
      AV144F1357LCCredDebMOv = DecimalUtil.ZERO ;
      AV145F1357LCPagosIncA = DecimalUtil.ZERO ;
      AV146F1357LCPagosIncB = DecimalUtil.ZERO ;
      AV138F1357LCPagosTotal = DecimalUtil.ZERO ;
      GXt_decimal17 = DecimalUtil.ZERO ;
      AV264modoDeduccionDescuentosLeyPalabra = "" ;
      AV266descuentosDeLeySobreGravadoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV261descuentosSobreGravadoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV260descuentosDeLeyLiqDImpCalcu = DecimalUtil.ZERO ;
      AV149gnsi = DecimalUtil.ZERO ;
      AV194DeduccionEspecialIncrementadaAplicada = DecimalUtil.ZERO ;
      AV265auxArt30Importes = DecimalUtil.ZERO ;
      AV309anticiposDeSac1erSemestre = DecimalUtil.ZERO ;
      AV310anticiposDeSac2doSemestre = DecimalUtil.ZERO ;
      AV308anticiposDeSac = DecimalUtil.ZERO ;
      AV203gnsiSinHorasExtrasGravadas = DecimalUtil.ZERO ;
      AV134alicuota_porUnaje = DecimalUtil.ZERO ;
      AV129cuota_fija = DecimalUtil.ZERO ;
      AV132tope_anterior = DecimalUtil.ZERO ;
      GXv_decimal19 = new java.math.BigDecimal[1] ;
      AV135alicuotaAplicable_porUnaje = DecimalUtil.ZERO ;
      GXv_decimal18 = new java.math.BigDecimal[1] ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_char8 = new String[1] ;
      GXv_int15 = new byte[1] ;
      A861F1357LCTipReg = "" ;
      A866F1357LC_GNSI = DecimalUtil.ZERO ;
      A867F1357LC_GanNeta = DecimalUtil.ZERO ;
      A871F1357LC_Cuota_fija = DecimalUtil.ZERO ;
      A872F1357LC_MesesTributados = DecimalUtil.ZERO ;
      A873F1357LC_Tope_anterior = DecimalUtil.ZERO ;
      A846F1357LCDeterminado = DecimalUtil.ZERO ;
      A847F1357LCRetenido = DecimalUtil.ZERO ;
      A848F1357LCPagosTotal = DecimalUtil.ZERO ;
      A849F1357LCSaldo = DecimalUtil.ZERO ;
      A850F1357CPagosCredDeb = DecimalUtil.ZERO ;
      A851F1357LCPagosAduanta = DecimalUtil.ZERO ;
      A852F1357LCPagosTurismo = DecimalUtil.ZERO ;
      AV142F1357LCPagosTurismo = DecimalUtil.ZERO ;
      A853F1357LCPagosBono = DecimalUtil.ZERO ;
      AV143F1357LCPagosBono = DecimalUtil.ZERO ;
      A854F1357LCPagosIncA = DecimalUtil.ZERO ;
      A855F1357LCPagosIncB = DecimalUtil.ZERO ;
      A856F1357LCPagosIncC = DecimalUtil.ZERO ;
      A857F1357LCPagosIncD = DecimalUtil.ZERO ;
      A858F1357LCPagosIncE = DecimalUtil.ZERO ;
      A859F1357LCCredDebMOv = DecimalUtil.ZERO ;
      A860F1357LCViajeExterior = DecimalUtil.ZERO ;
      A927F1357LC_DescuSobreGrav = DecimalUtil.ZERO ;
      A1082F1357LC_AnticiposDeSac = DecimalUtil.ZERO ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      AV236eneroFecha = GXutil.nullDate() ;
      AV237diciembreFecha = GXutil.nullDate() ;
      AV229noHabConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      GXv_objcol_char21 = new GXSimpleCollection[1] ;
      AV30SacCuo1Gra = DecimalUtil.ZERO ;
      AV31SacCuo2Gra = DecimalUtil.ZERO ;
      AV27RemuneracionBrutaAlcanzada = DecimalUtil.ZERO ;
      AV32HorasExtras = DecimalUtil.ZERO ;
      AV238HorasExtrasNoAlcanzadas = DecimalUtil.ZERO ;
      AV239MovViaNoAlcanzado = DecimalUtil.ZERO ;
      AV241BonosNoAlcanzados = DecimalUtil.ZERO ;
      AV301FallosNoAlzanzados = DecimalUtil.ZERO ;
      AV303similarNoAlcanzado = DecimalUtil.ZERO ;
      AV240docenNoAlcanzados = DecimalUtil.ZERO ;
      AV51AjustesGra = DecimalUtil.ZERO ;
      AV52AjustesExen = DecimalUtil.ZERO ;
      AV36RemuneracionExenta = DecimalUtil.ZERO ;
      AV41BonosProductividad = DecimalUtil.ZERO ;
      AV300FallosDeCaja = DecimalUtil.ZERO ;
      AV302SimilarNaturaleza = DecimalUtil.ZERO ;
      AV210NoHabituales = DecimalUtil.ZERO ;
      AV216movilidadYViaticos = DecimalUtil.ZERO ;
      AV224docentes = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      P00UO11_A2112LiqRelNro = new int[1] ;
      P00UO11_n2112LiqRelNro = new boolean[] {false} ;
      P00UO11_A394DConCodigo = new String[] {""} ;
      P00UO11_A31LiqNro = new int[1] ;
      P00UO11_A585LiqPerAno = new short[1] ;
      P00UO11_A6LegNumero = new int[1] ;
      P00UO11_A1EmpCod = new short[1] ;
      P00UO11_A3CliCod = new int[1] ;
      P00UO11_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00UO11_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV160AuxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV306primeraQuincenaTLiqCod = "" ;
      P00UO12_A31LiqNro = new int[1] ;
      P00UO12_A2112LiqRelNro = new int[1] ;
      P00UO12_n2112LiqRelNro = new boolean[] {false} ;
      P00UO12_A394DConCodigo = new String[] {""} ;
      P00UO12_A585LiqPerAno = new short[1] ;
      P00UO12_A6LegNumero = new int[1] ;
      P00UO12_A1EmpCod = new short[1] ;
      P00UO12_A3CliCod = new int[1] ;
      P00UO12_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00UO12_A81LiqDSecuencial = new int[1] ;
      AV206remuneracionesNoAlcanzadas = DecimalUtil.ZERO ;
      A464DTipoConCod = "" ;
      P00UO13_A2112LiqRelNro = new int[1] ;
      P00UO13_n2112LiqRelNro = new boolean[] {false} ;
      P00UO13_A464DTipoConCod = new String[] {""} ;
      P00UO13_A31LiqNro = new int[1] ;
      P00UO13_A585LiqPerAno = new short[1] ;
      P00UO13_A6LegNumero = new int[1] ;
      P00UO13_A1EmpCod = new short[1] ;
      P00UO13_A3CliCod = new int[1] ;
      P00UO13_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00UO13_A394DConCodigo = new String[] {""} ;
      P00UO13_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00UO13_A468DSubTipoConCod1 = new String[] {""} ;
      P00UO13_n468DSubTipoConCod1 = new boolean[] {false} ;
      P00UO13_A732DSubTipoConCod2 = new String[] {""} ;
      P00UO13_n732DSubTipoConCod2 = new boolean[] {false} ;
      P00UO13_A1122DAplIIGG = new short[1] ;
      P00UO13_n1122DAplIIGG = new boolean[] {false} ;
      P00UO13_A81LiqDSecuencial = new int[1] ;
      A468DSubTipoConCod1 = "" ;
      A732DSubTipoConCod2 = "" ;
      AV321AplIIGGExenCon = "" ;
      P00UO14_A3CliCod = new int[1] ;
      P00UO14_A1EmpCod = new short[1] ;
      P00UO14_A585LiqPerAno = new short[1] ;
      P00UO14_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00UO14_A394DConCodigo = new String[] {""} ;
      P00UO14_A464DTipoConCod = new String[] {""} ;
      P00UO14_A31LiqNro = new int[1] ;
      P00UO14_A1122DAplIIGG = new short[1] ;
      P00UO14_n1122DAplIIGG = new boolean[] {false} ;
      P00UO14_A507LiqDCalculado = new byte[1] ;
      P00UO14_A393DConDescrip = new String[] {""} ;
      P00UO14_A468DSubTipoConCod1 = new String[] {""} ;
      P00UO14_n468DSubTipoConCod1 = new boolean[] {false} ;
      P00UO14_A732DSubTipoConCod2 = new String[] {""} ;
      P00UO14_n732DSubTipoConCod2 = new boolean[] {false} ;
      P00UO14_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P00UO14_A6LegNumero = new int[1] ;
      P00UO14_A2112LiqRelNro = new int[1] ;
      P00UO14_n2112LiqRelNro = new boolean[] {false} ;
      P00UO14_A81LiqDSecuencial = new int[1] ;
      A393DConDescrip = "" ;
      AV324mesRemuneracionBrutaAlcanzada = DecimalUtil.ZERO ;
      AV234horExt100PcConCodigo = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char9 = new String[1] ;
      GXv_char10 = new String[1] ;
      GXv_boolean14 = new boolean[1] ;
      AV108ded_hijo = DecimalUtil.ZERO ;
      AV112ded_hijo_incap = DecimalUtil.ZERO ;
      AV110prc_ded_hijos = DecimalUtil.ZERO ;
      AV113prc_ded_hijos_incap = DecimalUtil.ZERO ;
      GXv_decimal20 = new java.math.BigDecimal[1] ;
      AV207BonosGravados = DecimalUtil.ZERO ;
      AV296FallosGra = DecimalUtil.ZERO ;
      AV298SimilaresGra = DecimalUtil.ZERO ;
      AV235TotalmenteExentos = DecimalUtil.ZERO ;
      AV209NoHabGra = DecimalUtil.ZERO ;
      AV208HorExtGra = DecimalUtil.ZERO ;
      AV286RemuneracionBrutaAlcanzadaRestar = DecimalUtil.ZERO ;
      AV53ExenLey27549 = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.f1357__default(),
         new Object[] {
             new Object[] {
            P00UO2_A777F1357CPer, P00UO2_A784F1357CTipoPre, P00UO2_A1EmpCod, P00UO2_A3CliCod, P00UO2_A778F1357CSec
            }
            , new Object[] {
            }
            , new Object[] {
            P00UO4_A2112LiqRelNro, P00UO4_n2112LiqRelNro, P00UO4_A32TLiqCod, P00UO4_n32TLiqCod, P00UO4_A283LiqPeriodo, P00UO4_A6LegNumero, P00UO4_A1EmpCod, P00UO4_A3CliCod, P00UO4_A31LiqNro
            }
            , new Object[] {
            P00UO5_A31LiqNro, P00UO5_A283LiqPeriodo, P00UO5_A6LegNumero, P00UO5_A1EmpCod, P00UO5_A3CliCod, P00UO5_A2112LiqRelNro, P00UO5_n2112LiqRelNro
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            P00UO11_A2112LiqRelNro, P00UO11_n2112LiqRelNro, P00UO11_A394DConCodigo, P00UO11_A31LiqNro, P00UO11_A585LiqPerAno, P00UO11_A6LegNumero, P00UO11_A1EmpCod, P00UO11_A3CliCod, P00UO11_A764LiqDImpReCalcu, P00UO11_A81LiqDSecuencial
            }
            , new Object[] {
            P00UO12_A31LiqNro, P00UO12_A2112LiqRelNro, P00UO12_n2112LiqRelNro, P00UO12_A394DConCodigo, P00UO12_A585LiqPerAno, P00UO12_A6LegNumero, P00UO12_A1EmpCod, P00UO12_A3CliCod, P00UO12_A764LiqDImpReCalcu, P00UO12_A81LiqDSecuencial
            }
            , new Object[] {
            P00UO13_A2112LiqRelNro, P00UO13_n2112LiqRelNro, P00UO13_A464DTipoConCod, P00UO13_A31LiqNro, P00UO13_A585LiqPerAno, P00UO13_A6LegNumero, P00UO13_A1EmpCod, P00UO13_A3CliCod, P00UO13_A764LiqDImpReCalcu, P00UO13_A394DConCodigo,
            P00UO13_A397DLiqPeriodo, P00UO13_A468DSubTipoConCod1, P00UO13_n468DSubTipoConCod1, P00UO13_A732DSubTipoConCod2, P00UO13_n732DSubTipoConCod2, P00UO13_A1122DAplIIGG, P00UO13_n1122DAplIIGG, P00UO13_A81LiqDSecuencial
            }
            , new Object[] {
            P00UO14_A3CliCod, P00UO14_A1EmpCod, P00UO14_A585LiqPerAno, P00UO14_A764LiqDImpReCalcu, P00UO14_A394DConCodigo, P00UO14_A464DTipoConCod, P00UO14_A31LiqNro, P00UO14_A1122DAplIIGG, P00UO14_n1122DAplIIGG, P00UO14_A507LiqDCalculado,
            P00UO14_A393DConDescrip, P00UO14_A468DSubTipoConCod1, P00UO14_n468DSubTipoConCod1, P00UO14_A732DSubTipoConCod2, P00UO14_n732DSubTipoConCod2, P00UO14_A397DLiqPeriodo, P00UO14_A6LegNumero, P00UO14_A2112LiqRelNro, P00UO14_n2112LiqRelNro, P00UO14_A81LiqDSecuencial
            }
         }
      );
      AV337Pgmname = "F1357" ;
      /* GeneXus formulas. */
      AV337Pgmname = "F1357" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15F1357CTipoPre ;
   private byte AV279AdelantoTipo ;
   private byte AV270LiqDCalculado ;
   private byte A784F1357CTipoPre ;
   private byte A778F1357CSec ;
   private byte AV11F1357CSec ;
   private byte AV205mesesAnio ;
   private byte A791F1357LBeneficio ;
   private byte A1216F1357LDGCompAnaCnt ;
   private byte AV125F1357LCAlicuota ;
   private byte AV128F1357LCAliApli ;
   private byte GXv_int15[] ;
   private byte A844F1357LCAlicuota ;
   private byte A845F1357LCAliApli ;
   private byte AV348GXLvl1096 ;
   private byte A507LiqDCalculado ;
   private short AV12EmpCod ;
   private short AV28LiqPerAno ;
   private short A1EmpCod ;
   private short Gx_err ;
   private short AV17i ;
   private short GXt_int11 ;
   private short AV103cantMesesTributados ;
   private short AV307alcanza_ganancias ;
   private short AV333ded_hijo_incapX1 ;
   private short AV150deduce_conyuge ;
   private short GXv_int12[] ;
   private short AV243ExenSinExt ;
   private short AV215MovViaExen ;
   private short AV214DocenExen ;
   private short AV217NoHabExen ;
   private short AV226TeletrabajoExen ;
   private short A585LiqPerAno ;
   private short A1122DAplIIGG ;
   private short AV228h ;
   private short AV212MovViaGra ;
   private short AV213DocenGra ;
   private int AV8CliCod ;
   private int AV268parm_LiqNro ;
   private int A3CliCod ;
   private int GX_INS92 ;
   private int AV127LiqNro ;
   private int AV323auxLegNumero ;
   private int A2112LiqRelNro ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int AV342GXV1 ;
   private int AV343GXV2 ;
   private int GX_INS95 ;
   private int GX_INS97 ;
   private int GX_INS96 ;
   private int GX_INS94 ;
   private int GX_INS93 ;
   private int A81LiqDSecuencial ;
   private long AV9EmpCUIT ;
   private long GXv_int5[] ;
   private long AV19LegCUIL ;
   private java.math.BigDecimal AV318remuBrutaEstimadaConDescuento ;
   private java.math.BigDecimal AV269remuBrutaEstimada ;
   private java.math.BigDecimal AV147F1357LCDeterminado ;
   private java.math.BigDecimal AV136F1357LCRetenido ;
   private java.math.BigDecimal AV280remuBrutaLiqActual ;
   private java.math.BigDecimal AV87alicuotaDonaciones ;
   private java.math.BigDecimal AV89limiteMedicos ;
   private java.math.BigDecimal AV94limitePrepaga ;
   private java.math.BigDecimal AV62topeSeguros ;
   private java.math.BigDecimal AV66topeSepelios ;
   private java.math.BigDecimal AV71topeHipoteca ;
   private java.math.BigDecimal AV201mniParaTopes ;
   private java.math.BigDecimal AV326mniAnual ;
   private java.math.BigDecimal AV325mniX1 ;
   private java.math.BigDecimal AV204ZonPorcAumenDed ;
   private java.math.BigDecimal AV327F1357LDPEspecialAnual ;
   private java.math.BigDecimal AV330F1357LDPEspecialX1 ;
   private java.math.BigDecimal AV328F1357LDPConyugeAnual ;
   private java.math.BigDecimal AV329F1357LDPConyugeX1 ;
   private java.math.BigDecimal AV344Ded_hijoanual ;
   private java.math.BigDecimal AV331ded_hijoX1 ;
   private java.math.BigDecimal AV332ded_hijo_incapAnual ;
   private java.math.BigDecimal AV105F1357LDPCantHijos ;
   private java.math.BigDecimal AV292F1357LDPCantHij100PC ;
   private java.math.BigDecimal AV294F1357LDPcantHijMay18 ;
   private java.math.BigDecimal AV47gananciaNeta ;
   private java.math.BigDecimal AV48remuneracionGravadaTotal ;
   private java.math.BigDecimal AV49remuneracionExentaTotal ;
   private java.math.BigDecimal AV249F1357LRExenta ;
   private java.math.BigDecimal AV35ExenExt ;
   private java.math.BigDecimal AV230NoHabitualesNoAlcanzada ;
   private java.math.BigDecimal AV38SacCuo1Exen ;
   private java.math.BigDecimal AV247sacCuo1NoAlcanzado ;
   private java.math.BigDecimal AV39SacCuo2Exen ;
   private java.math.BigDecimal AV248sacCuo2NoAlcanzado ;
   private java.math.BigDecimal AV42BonosExen ;
   private java.math.BigDecimal AV297FallosExen ;
   private java.math.BigDecimal AV299SimilaresExen ;
   private java.math.BigDecimal AV289remuBrutaLiqActualConDescuento ;
   private java.math.BigDecimal AV283descuentoLiqActual ;
   private java.math.BigDecimal AV278remuBrutaTeorica ;
   private java.math.BigDecimal AV316remuBrutaTeoricaParaDEI ;
   private java.math.BigDecimal AV319remuBrutaLiqActualSinSAC ;
   private java.math.BigDecimal AV284baseImponible1 ;
   private java.math.BigDecimal A800F1357LRGravada ;
   private java.math.BigDecimal A801F1357LRExenta ;
   private java.math.BigDecimal AV64F1357LDGSepelio ;
   private java.math.BigDecimal AV67F1357LDGRodado ;
   private java.math.BigDecimal AV69F1357LDGOblig ;
   private java.math.BigDecimal AV70F1357LDGHipoteca ;
   private java.math.BigDecimal AV74F1357LDGSGR ;
   private java.math.BigDecimal AV76F1357LDGDomes ;
   private java.math.BigDecimal AV290F1357LDGEducativos ;
   private java.math.BigDecimal AV79F1357LDGAlquiler ;
   private java.math.BigDecimal AV81F1357LDGViaticos ;
   private java.math.BigDecimal AV83F1357LDGIndu ;
   private java.math.BigDecimal AV85F1357LDGOtras ;
   private java.math.BigDecimal AV57F1357LDGSeguro ;
   private java.math.BigDecimal AV59F1357LDGSeguMixto ;
   private java.math.BigDecimal AV60F1357LDGRetPriv ;
   private java.math.BigDecimal AV63F1357LDGCuotapartes ;
   private java.math.BigDecimal AV288deducciones ;
   private java.math.BigDecimal AV86F1357LDGDonaciones ;
   private java.math.BigDecimal AV88F1357LDGMed ;
   private java.math.BigDecimal AV92F1357LDGPrepaga ;
   private java.math.BigDecimal AV95F1357LDGOtrasCaja ;
   private java.math.BigDecimal AV97F1357LDGOtrasAnses ;
   private java.math.BigDecimal AV98F1357LDGOtrasProf ;
   private java.math.BigDecimal AV99F1357LDGOtrasActores ;
   private java.math.BigDecimal AV100F1357LDGOtrasPrev ;
   private java.math.BigDecimal A1213F1357LDGMovEmpl ;
   private java.math.BigDecimal A1214F1357LDGViaEmpl ;
   private java.math.BigDecimal A1215F1357LDGCompAna ;
   private java.math.BigDecimal A802F1357LDGPrepaga ;
   private java.math.BigDecimal A803F1357LDGSeguro ;
   private java.math.BigDecimal A804F1357LDGSeguMixto ;
   private java.math.BigDecimal A805F1357LDGRetPriv ;
   private java.math.BigDecimal A806F1357LDGCuotapartes ;
   private java.math.BigDecimal A807F1357LDGSepelio ;
   private java.math.BigDecimal A808F1357LDGRodado ;
   private java.math.BigDecimal A809F1357LDGDonaciones ;
   private java.math.BigDecimal A810F1357LDGOblig ;
   private java.math.BigDecimal A811F1357LDGMed ;
   private java.math.BigDecimal A812F1357LDGHipoteca ;
   private java.math.BigDecimal A813F1357LDGSGR ;
   private java.math.BigDecimal A814F1357LDGOtrasCaja ;
   private java.math.BigDecimal A815F1357LDGAlquiler ;
   private java.math.BigDecimal A816F1357LDGDomes ;
   private java.math.BigDecimal A944F1357LDGEducativos ;
   private java.math.BigDecimal A817F1357LDGViaticos ;
   private java.math.BigDecimal A818F1357LDGIndu ;
   private java.math.BigDecimal A819F1357LDGOtras ;
   private java.math.BigDecimal AV96F1357LDGTotal ;
   private java.math.BigDecimal A820F1357LDGTotal ;
   private java.math.BigDecimal A821F1357LDGOtrasAnses ;
   private java.math.BigDecimal A822F1357LDGOtrasProf ;
   private java.math.BigDecimal A823F1357LDGOtrasActores ;
   private java.math.BigDecimal A824F1357LDGOtrasPrev ;
   private java.math.BigDecimal AV115F1357LDPEspIncremen1 ;
   private java.math.BigDecimal AV116F1357LDPEspIncremen2 ;
   private java.math.BigDecimal A827F1357LDPGNI ;
   private java.math.BigDecimal AV77mni ;
   private java.math.BigDecimal A828F1357LDPEspecial ;
   private java.math.BigDecimal AV101F1357LDPEspecial ;
   private java.math.BigDecimal A829F1357LDPEspecifica ;
   private java.math.BigDecimal AV102F1357LDPEspecifica ;
   private java.math.BigDecimal A830F1357LDPConyuge ;
   private java.math.BigDecimal AV104F1357LDPConyuge ;
   private java.math.BigDecimal A831F1357LDPCantHijos ;
   private java.math.BigDecimal A832F1357LDPHijosImporte ;
   private java.math.BigDecimal AV107F1357LDPHijosImporte ;
   private java.math.BigDecimal AV196F1357LDPTotalFami ;
   private java.math.BigDecimal AV111F1357LDPHijosIncapImp ;
   private java.math.BigDecimal A833F1357LDPTotalFami ;
   private java.math.BigDecimal AV130F1357LDPTotalArt30 ;
   private java.math.BigDecimal A834F1357LDPTotalArt30 ;
   private java.math.BigDecimal A835F1357LDPSujAntes ;
   private java.math.BigDecimal A836F1357LDPIncA ;
   private java.math.BigDecimal A837F1357LDPIncB ;
   private java.math.BigDecimal A838F1357LDPRemuSuj ;
   private java.math.BigDecimal A839F1357LDPCantHijIncap ;
   private java.math.BigDecimal AV106F1357LDPCantHijIncap ;
   private java.math.BigDecimal A840F1357LDPHijosIncapImp ;
   private java.math.BigDecimal A841F1357LDPEspIncremen1 ;
   private java.math.BigDecimal A842F1357LDPEspIncremen2 ;
   private java.math.BigDecimal A945F1357LDPCantHij100PC ;
   private java.math.BigDecimal A946F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal AV293F1357ldpcAntHijIncap100pc ;
   private java.math.BigDecimal A947F1357LDPcantHijMay18 ;
   private java.math.BigDecimal A948F1357LDPcantHijMay18_100pc ;
   private java.math.BigDecimal AV295F1357LDPcantHijMay18_100pc ;
   private java.math.BigDecimal AV139F1357CPagosCredDeb ;
   private java.math.BigDecimal AV141F1357LCPagosAduanta ;
   private java.math.BigDecimal AV144F1357LCCredDebMOv ;
   private java.math.BigDecimal AV145F1357LCPagosIncA ;
   private java.math.BigDecimal AV146F1357LCPagosIncB ;
   private java.math.BigDecimal AV138F1357LCPagosTotal ;
   private java.math.BigDecimal GXt_decimal17 ;
   private java.math.BigDecimal AV266descuentosDeLeySobreGravadoLiqDImpCalcu ;
   private java.math.BigDecimal AV261descuentosSobreGravadoLiqDImpCalcu ;
   private java.math.BigDecimal AV260descuentosDeLeyLiqDImpCalcu ;
   private java.math.BigDecimal AV149gnsi ;
   private java.math.BigDecimal AV194DeduccionEspecialIncrementadaAplicada ;
   private java.math.BigDecimal AV265auxArt30Importes ;
   private java.math.BigDecimal AV309anticiposDeSac1erSemestre ;
   private java.math.BigDecimal AV310anticiposDeSac2doSemestre ;
   private java.math.BigDecimal AV308anticiposDeSac ;
   private java.math.BigDecimal AV203gnsiSinHorasExtrasGravadas ;
   private java.math.BigDecimal AV134alicuota_porUnaje ;
   private java.math.BigDecimal AV129cuota_fija ;
   private java.math.BigDecimal AV132tope_anterior ;
   private java.math.BigDecimal GXv_decimal19[] ;
   private java.math.BigDecimal AV135alicuotaAplicable_porUnaje ;
   private java.math.BigDecimal GXv_decimal18[] ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private java.math.BigDecimal A866F1357LC_GNSI ;
   private java.math.BigDecimal A867F1357LC_GanNeta ;
   private java.math.BigDecimal A871F1357LC_Cuota_fija ;
   private java.math.BigDecimal A872F1357LC_MesesTributados ;
   private java.math.BigDecimal A873F1357LC_Tope_anterior ;
   private java.math.BigDecimal A846F1357LCDeterminado ;
   private java.math.BigDecimal A847F1357LCRetenido ;
   private java.math.BigDecimal A848F1357LCPagosTotal ;
   private java.math.BigDecimal A849F1357LCSaldo ;
   private java.math.BigDecimal A850F1357CPagosCredDeb ;
   private java.math.BigDecimal A851F1357LCPagosAduanta ;
   private java.math.BigDecimal A852F1357LCPagosTurismo ;
   private java.math.BigDecimal AV142F1357LCPagosTurismo ;
   private java.math.BigDecimal A853F1357LCPagosBono ;
   private java.math.BigDecimal AV143F1357LCPagosBono ;
   private java.math.BigDecimal A854F1357LCPagosIncA ;
   private java.math.BigDecimal A855F1357LCPagosIncB ;
   private java.math.BigDecimal A856F1357LCPagosIncC ;
   private java.math.BigDecimal A857F1357LCPagosIncD ;
   private java.math.BigDecimal A858F1357LCPagosIncE ;
   private java.math.BigDecimal A859F1357LCCredDebMOv ;
   private java.math.BigDecimal A860F1357LCViajeExterior ;
   private java.math.BigDecimal A927F1357LC_DescuSobreGrav ;
   private java.math.BigDecimal A1082F1357LC_AnticiposDeSac ;
   private java.math.BigDecimal AV30SacCuo1Gra ;
   private java.math.BigDecimal AV31SacCuo2Gra ;
   private java.math.BigDecimal AV27RemuneracionBrutaAlcanzada ;
   private java.math.BigDecimal AV32HorasExtras ;
   private java.math.BigDecimal AV238HorasExtrasNoAlcanzadas ;
   private java.math.BigDecimal AV239MovViaNoAlcanzado ;
   private java.math.BigDecimal AV241BonosNoAlcanzados ;
   private java.math.BigDecimal AV301FallosNoAlzanzados ;
   private java.math.BigDecimal AV303similarNoAlcanzado ;
   private java.math.BigDecimal AV240docenNoAlcanzados ;
   private java.math.BigDecimal AV51AjustesGra ;
   private java.math.BigDecimal AV52AjustesExen ;
   private java.math.BigDecimal AV36RemuneracionExenta ;
   private java.math.BigDecimal AV41BonosProductividad ;
   private java.math.BigDecimal AV300FallosDeCaja ;
   private java.math.BigDecimal AV302SimilarNaturaleza ;
   private java.math.BigDecimal AV210NoHabituales ;
   private java.math.BigDecimal AV216movilidadYViaticos ;
   private java.math.BigDecimal AV224docentes ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV160AuxLiqDImpCalcu ;
   private java.math.BigDecimal AV206remuneracionesNoAlcanzadas ;
   private java.math.BigDecimal AV324mesRemuneracionBrutaAlcanzada ;
   private java.math.BigDecimal AV108ded_hijo ;
   private java.math.BigDecimal AV112ded_hijo_incap ;
   private java.math.BigDecimal AV110prc_ded_hijos ;
   private java.math.BigDecimal AV113prc_ded_hijos_incap ;
   private java.math.BigDecimal GXv_decimal20[] ;
   private java.math.BigDecimal AV207BonosGravados ;
   private java.math.BigDecimal AV296FallosGra ;
   private java.math.BigDecimal AV298SimilaresGra ;
   private java.math.BigDecimal AV235TotalmenteExentos ;
   private java.math.BigDecimal AV209NoHabGra ;
   private java.math.BigDecimal AV208HorExtGra ;
   private java.math.BigDecimal AV286RemuneracionBrutaAlcanzadaRestar ;
   private java.math.BigDecimal AV53ExenLey27549 ;
   private String AV322ProcesoLiquidacion ;
   private String AV161parametroPalabra ;
   private String AV337Pgmname ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char6[] ;
   private String GXv_char7[] ;
   private String AV13F1357CCuitAgente ;
   private String AV10F1357CPer ;
   private String AV320SueldoSinSacConCodigo ;
   private String AV311anticiposDeSacConCodigo ;
   private String AV312sacLiquidadoConCodigo ;
   private String AV285baseImponible1ConCodigo ;
   private String AV246sacConCodigo ;
   private String AV245SacProporConCodigo ;
   private String AV262descuentosSobreGravadoConCodigo ;
   private String AV287remuneracionGravadaConCodigo ;
   private String AV44bonosprod_DSubTipoConCod1 ;
   private String AV45bonosprod_DSubTipoConCod2 ;
   private String AV222remuEspecial_DSubTipoConCod1 ;
   private String AV223movvia_DSubTipoConCod2 ;
   private String AV225docentes_DSubTipoConCod2 ;
   private String AV227copmenTeletrab_DSubTipoConCod2 ;
   private String AV118dedEspecialIncrementadaConCodigo ;
   private String AV167otroEmplOSConCodigo ;
   private String AV188otroEmplSegSocConCodigo ;
   private String AV187otroEmplSindicatoConCodigo ;
   private String AV198OtrosEmplSACConCodigo ;
   private String AV200otroEmplNoHabConCodigo ;
   private String AV191alcanzaGananciasConCodigo ;
   private String AV140pagosACuentaConCodigo ;
   private String AV137retencionConCodigo ;
   private String AV259adelantoRetencionConCodigo ;
   private String AV29sacGravadoConCodigo ;
   private String AV40sacExentoConCodigo ;
   private String AV219ExenExtConCodigo ;
   private String AV46bonosExentosConCodigo ;
   private String AV304fallosCajaExentosConCodigo ;
   private String AV305simNatExentosConCodigo ;
   private String AV220movviaExentosConCodigo ;
   private String AV221perDocMatExentosConCodigo ;
   private String AV58primaSeguroConCodigo ;
   private String AV164primasMixtosConCodigo ;
   private String AV61retiroPrivadoConCodigo ;
   private String AV165cuotapartesConCodigo ;
   private String AV65sepelioConCodigo ;
   private String AV68vehiculosConCodigo ;
   private String AV72hipotecaConCodigo ;
   private String AV75aportesSGRConCodigo ;
   private String AV78personalDomesticoConCodigo ;
   private String AV291educativosConCodigo ;
   private String AV80alquilerConCodigo ;
   private String AV82viaticosConCodigo ;
   private String AV84induConCodigo ;
   private String AV162otrasDeduccionesConCodigo ;
   private String AV91donacionesConCodigo ;
   private String AV90honorariosMedicosConCodigo ;
   private String AV93prepagaConCodigo ;
   private String scmdbuf ;
   private String A777F1357CPer ;
   private String A780F1357CCuitAgente ;
   private String A781F1357CCodImp ;
   private String A782F1357CCodCon ;
   private String A783F1357CNumForm ;
   private String A785F1357CVerSis ;
   private String Gx_emsg ;
   private String AV197egresoTLiqCod ;
   private String AV256mensualTliqCod ;
   private String AV258aguTliqCod ;
   private String AV257vacTLiqCod ;
   private String A32TLiqCod ;
   private String AV151deduce_conyugeChar ;
   private String AV21diaInicio ;
   private String A786F1357LTipoReg ;
   private String A787F1357LCuil ;
   private String A788F1357LPerDesd ;
   private String A789F1357LPerHas ;
   private String A790F1357LMeses ;
   private String A792F1357LLargaDist ;
   private String A793F1357LLey27424 ;
   private String A795F1357LTeletrabajo ;
   private String A796F1357LMilitar ;
   private String A943F1357LLargaDistCT_40_1989 ;
   private String A794F1357L27549 ;
   private String AV186otroEmplGananciaBrutaConCodigo ;
   private String AV183otroEmplhorasExtrasGravadasCodigo ;
   private String AV182otroEmplhorasExtrasExentasCodigo ;
   private String A797F1357LRTipReg ;
   private String A863F1357LDGTipReg ;
   private String A862F1357LDPTipReg ;
   private String AV264modoDeduccionDescuentosLeyPalabra ;
   private String GXv_char8[] ;
   private String A861F1357LCTipReg ;
   private String A394DConCodigo ;
   private String AV306primeraQuincenaTLiqCod ;
   private String A464DTipoConCod ;
   private String A468DSubTipoConCod1 ;
   private String A732DSubTipoConCod2 ;
   private String AV321AplIIGGExenCon ;
   private String AV234horExt100PcConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char9[] ;
   private String GXv_char10[] ;
   private java.util.Date AV20LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private java.util.Date AV163LegFecIngreso ;
   private java.util.Date GXv_date16[] ;
   private java.util.Date AV199sacLiqPeriodo ;
   private java.util.Date A397DLiqPeriodo ;
   private java.util.Date AV236eneroFecha ;
   private java.util.Date AV237diciembreFecha ;
   private boolean AV267simulacionParaAdelanto ;
   private boolean AV14hay ;
   private boolean n2112LiqRelNro ;
   private boolean n32TLiqCod ;
   private boolean brkUO5 ;
   private boolean Cond_result ;
   private boolean returnInSub ;
   private boolean AV263restarLeyTotal ;
   private boolean AV313liquidoSac1 ;
   private boolean AV314liquidoSac2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n1122DAplIIGG ;
   private boolean brkUO15 ;
   private boolean AV233esNoHabitual ;
   private boolean AV56SubTDescuLey ;
   private boolean GXv_boolean14[] ;
   private String AV315LiqDLog ;
   private String A798F1357LRRemuneraciones ;
   private String A799F1357LRRemuOtr ;
   private String A825F1357LDGDescuentosLey ;
   private String A826F1357LDGOtrDescuLey ;
   private String AV148LegnumeroJSON ;
   private String AV334auxerror ;
   private String A393DConDescrip ;
   private GXSimpleCollection<Integer> AV16Legnumero ;
   private GXSimpleCollection<Integer> AV192LiquidacionesSujetas ;
   private GXSimpleCollection<Integer> AV193LiquidacionesNoSujetas ;
   private web.SdtF1357_Remuneracion AV18F1357_Remuneracion ;
   private String[] aP15 ;
   private java.math.BigDecimal[] aP11 ;
   private java.math.BigDecimal[] aP12 ;
   private byte[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
   private IDataStoreProvider pr_default ;
   private String[] P00UO2_A777F1357CPer ;
   private byte[] P00UO2_A784F1357CTipoPre ;
   private short[] P00UO2_A1EmpCod ;
   private int[] P00UO2_A3CliCod ;
   private byte[] P00UO2_A778F1357CSec ;
   private int[] P00UO4_A2112LiqRelNro ;
   private boolean[] P00UO4_n2112LiqRelNro ;
   private String[] P00UO4_A32TLiqCod ;
   private boolean[] P00UO4_n32TLiqCod ;
   private java.util.Date[] P00UO4_A283LiqPeriodo ;
   private int[] P00UO4_A6LegNumero ;
   private short[] P00UO4_A1EmpCod ;
   private int[] P00UO4_A3CliCod ;
   private int[] P00UO4_A31LiqNro ;
   private int[] P00UO5_A31LiqNro ;
   private java.util.Date[] P00UO5_A283LiqPeriodo ;
   private int[] P00UO5_A6LegNumero ;
   private short[] P00UO5_A1EmpCod ;
   private int[] P00UO5_A3CliCod ;
   private int[] P00UO5_A2112LiqRelNro ;
   private boolean[] P00UO5_n2112LiqRelNro ;
   private int[] P00UO11_A2112LiqRelNro ;
   private boolean[] P00UO11_n2112LiqRelNro ;
   private String[] P00UO11_A394DConCodigo ;
   private int[] P00UO11_A31LiqNro ;
   private short[] P00UO11_A585LiqPerAno ;
   private int[] P00UO11_A6LegNumero ;
   private short[] P00UO11_A1EmpCod ;
   private int[] P00UO11_A3CliCod ;
   private java.math.BigDecimal[] P00UO11_A764LiqDImpReCalcu ;
   private int[] P00UO11_A81LiqDSecuencial ;
   private int[] P00UO12_A31LiqNro ;
   private int[] P00UO12_A2112LiqRelNro ;
   private boolean[] P00UO12_n2112LiqRelNro ;
   private String[] P00UO12_A394DConCodigo ;
   private short[] P00UO12_A585LiqPerAno ;
   private int[] P00UO12_A6LegNumero ;
   private short[] P00UO12_A1EmpCod ;
   private int[] P00UO12_A3CliCod ;
   private java.math.BigDecimal[] P00UO12_A764LiqDImpReCalcu ;
   private int[] P00UO12_A81LiqDSecuencial ;
   private int[] P00UO13_A2112LiqRelNro ;
   private boolean[] P00UO13_n2112LiqRelNro ;
   private String[] P00UO13_A464DTipoConCod ;
   private int[] P00UO13_A31LiqNro ;
   private short[] P00UO13_A585LiqPerAno ;
   private int[] P00UO13_A6LegNumero ;
   private short[] P00UO13_A1EmpCod ;
   private int[] P00UO13_A3CliCod ;
   private java.math.BigDecimal[] P00UO13_A764LiqDImpReCalcu ;
   private String[] P00UO13_A394DConCodigo ;
   private java.util.Date[] P00UO13_A397DLiqPeriodo ;
   private String[] P00UO13_A468DSubTipoConCod1 ;
   private boolean[] P00UO13_n468DSubTipoConCod1 ;
   private String[] P00UO13_A732DSubTipoConCod2 ;
   private boolean[] P00UO13_n732DSubTipoConCod2 ;
   private short[] P00UO13_A1122DAplIIGG ;
   private boolean[] P00UO13_n1122DAplIIGG ;
   private int[] P00UO13_A81LiqDSecuencial ;
   private int[] P00UO14_A3CliCod ;
   private short[] P00UO14_A1EmpCod ;
   private short[] P00UO14_A585LiqPerAno ;
   private java.math.BigDecimal[] P00UO14_A764LiqDImpReCalcu ;
   private String[] P00UO14_A394DConCodigo ;
   private String[] P00UO14_A464DTipoConCod ;
   private int[] P00UO14_A31LiqNro ;
   private short[] P00UO14_A1122DAplIIGG ;
   private boolean[] P00UO14_n1122DAplIIGG ;
   private byte[] P00UO14_A507LiqDCalculado ;
   private String[] P00UO14_A393DConDescrip ;
   private String[] P00UO14_A468DSubTipoConCod1 ;
   private boolean[] P00UO14_n468DSubTipoConCod1 ;
   private String[] P00UO14_A732DSubTipoConCod2 ;
   private boolean[] P00UO14_n732DSubTipoConCod2 ;
   private java.util.Date[] P00UO14_A397DLiqPeriodo ;
   private int[] P00UO14_A6LegNumero ;
   private int[] P00UO14_A2112LiqRelNro ;
   private boolean[] P00UO14_n2112LiqRelNro ;
   private int[] P00UO14_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV229noHabConCodigo ;
   private GXSimpleCollection<String> GXv_objcol_char21[] ;
   private GXBaseCollection<web.Sdtsdt_liquidacion_sdt_liquidacionItem> AV250sdt_liquidacion ;
   private web.SdtF1357_DeduccionesGenerales AV55F1357_DeduccionesGeneralesOtrosEmpleos ;
   private web.SdtF1357_DeduccionesGenerales AV54F1357_DeduccionesGenerales ;
   private web.SdtF1357_Remuneracion AV50F1357_RemuneracionOtrosEmpleos ;
   private web.Sdtsdt_liquidacion_sdt_liquidacionItem AV251itemLiquidacion ;
}

final  class f1357__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00UO4( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          byte AV15F1357CTipoPre ,
                                          String A32TLiqCod ,
                                          String AV197egresoTLiqCod ,
                                          int A2112LiqRelNro ,
                                          int AV8CliCod ,
                                          short AV12EmpCod ,
                                          int AV323auxLegNumero ,
                                          java.util.Date AV20LiqPeriodo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero ,
                                          java.util.Date A283LiqPeriodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int22 = new byte[6];
      Object[] GXv_Object23 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.TLiqCod, T1.LiqPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqNro FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod =" ;
      scmdbuf += " T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ? and T1.LiqPeriodo = ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL)");
      if ( AV15F1357CTipoPre != 2 )
      {
         addWhere(sWhereString, "(T1.TLiqCod <> ( ?))");
      }
      else
      {
         GXv_int22[4] = (byte)(1) ;
      }
      if ( AV15F1357CTipoPre == 2 )
      {
         addWhere(sWhereString, "(T1.TLiqCod = ( ?))");
      }
      else
      {
         GXv_int22[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqPeriodo" ;
      GXv_Object23[0] = scmdbuf ;
      GXv_Object23[1] = GXv_int22 ;
      return GXv_Object23 ;
   }

   protected Object[] conditional_P00UO11( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int A31LiqNro ,
                                           GXSimpleCollection<Integer> AV193LiquidacionesNoSujetas ,
                                           int A6LegNumero ,
                                           short AV17i ,
                                           int A2112LiqRelNro ,
                                           short A585LiqPerAno ,
                                           short AV28LiqPerAno ,
                                           String A394DConCodigo ,
                                           String AV137retencionConCodigo ,
                                           int AV8CliCod ,
                                           short AV12EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int24 = new byte[4];
      Object[] GXv_Object25 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.DConCodigo, T1.LiqNro, T2.LiqPerAno, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1" ;
      scmdbuf += " INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV193LiquidacionesNoSujetas, "T1.LiqNro IN (", ")")+")");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL)");
      addWhere(sWhereString, "(T2.LiqPerAno = ?)");
      addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object25[0] = scmdbuf ;
      GXv_Object25[1] = GXv_int24 ;
      return GXv_Object25 ;
   }

   protected Object[] conditional_P00UO13( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int A31LiqNro ,
                                           GXSimpleCollection<Integer> AV193LiquidacionesNoSujetas ,
                                           int A6LegNumero ,
                                           short AV17i ,
                                           String A464DTipoConCod ,
                                           int A2112LiqRelNro ,
                                           short A585LiqPerAno ,
                                           short AV28LiqPerAno ,
                                           int AV8CliCod ,
                                           short AV12EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int27 = new byte[3];
      Object[] GXv_Object28 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.DTipoConCod, T1.LiqNro, T2.LiqPerAno, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.DConCodigo, T1.DLiqPeriodo, T1.DSubTipoConCod1," ;
      scmdbuf += " T1.DSubTipoConCod2, T1.DAplIIGG, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND" ;
      scmdbuf += " T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV193LiquidacionesNoSujetas, "T1.LiqNro IN (", ")")+")");
      addWhere(sWhereString, "(T1.DTipoConCod = ( 'REM_ARG') or T1.DTipoConCod = ( 'NRE_ARG'))");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL)");
      addWhere(sWhereString, "(T2.LiqPerAno = ?)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod" ;
      GXv_Object28[0] = scmdbuf ;
      GXv_Object28[1] = GXv_int27 ;
      return GXv_Object28 ;
   }

   protected Object[] conditional_P00UO14( ModelContext context ,
                                           int remoteHandle ,
                                           com.genexus.IHttpContext httpContext ,
                                           int A31LiqNro ,
                                           GXSimpleCollection<Integer> AV192LiquidacionesSujetas ,
                                           int A6LegNumero ,
                                           short AV17i ,
                                           int A2112LiqRelNro ,
                                           short A585LiqPerAno ,
                                           short AV28LiqPerAno ,
                                           int AV8CliCod ,
                                           short AV12EmpCod ,
                                           int A3CliCod ,
                                           short A1EmpCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int30 = new byte[3];
      Object[] GXv_Object31 = new Object[2];
      scmdbuf = "SELECT T1.CliCod, T1.EmpCod, T2.LiqPerAno, T1.LiqDImpReCalcu, T1.DConCodigo, T1.DTipoConCod, T1.LiqNro, T1.DAplIIGG, T1.LiqDCalculado, T1.DConDescrip, T1.DSubTipoConCod1," ;
      scmdbuf += " T1.DSubTipoConCod2, T1.DLiqPeriodo, T1.LegNumero, T2.LiqRelNro, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod" ;
      scmdbuf += " AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ?)");
      addWhere(sWhereString, "("+GXutil.toValueList("postgresql", AV192LiquidacionesSujetas, "T1.LiqNro IN (", ")")+")");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL)");
      addWhere(sWhereString, "(T2.LiqPerAno = ?)");
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T2.LiqPerAno, T1.DLiqPeriodo" ;
      GXv_Object31[0] = scmdbuf ;
      GXv_Object31[1] = GXv_int30 ;
      return GXv_Object31 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 2 :
                  return conditional_P00UO4(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).byteValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , (java.util.Date)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , (java.util.Date)dynConstraints[11] );
            case 9 :
                  return conditional_P00UO11(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , (String)dynConstraints[7] , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() );
            case 11 :
                  return conditional_P00UO13(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() );
            case 12 :
                  return conditional_P00UO14(context, remoteHandle, httpContext, ((Number) dynConstraints[0]).intValue() , (GXSimpleCollection<Integer>)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).shortValue() , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).shortValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UO2", "SELECT F1357CPer, F1357CTipoPre, EmpCod, CliCod, F1357CSec FROM F1357Cab WHERE CliCod = ? and EmpCod = ? and F1357CTipoPre = ? and F1357CPer = ( ?) ORDER BY CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00UO3", "SAVEPOINT gxupdate;INSERT INTO F1357Cab(CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, F1357CCuitAgente, F1357CCodImp, F1357CCodCon, F1357CNumForm, F1357CVerSis) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00UO4", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P00UO5", "SELECT T1.LiqNro, T1.LiqPeriodo, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LiqRelNro FROM (LiquidacionLegajo T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?) AND (T2.LiqRelNro IS NULL) ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.LiqPeriodo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P00UO6", "SAVEPOINT gxupdate;INSERT INTO F1357Leg(CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LTipoReg, F1357LCuil, F1357LPerDesd, F1357LPerHas, F1357LMeses, F1357LBeneficio, F1357LLargaDist, F1357LLey27424, F1357L27549, F1357LTeletrabajo, F1357LMilitar, F1357LLargaDistCT_40_1989) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00UO7", "SAVEPOINT gxupdate;INSERT INTO F1357LegRemun(CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LRTipReg, F1357LRRemuneraciones, F1357LRRemuOtr, F1357LRGravada, F1357LRExenta) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00UO8", "SAVEPOINT gxupdate;INSERT INTO F1357LegDedGen(CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDGTipReg, F1357LDGPrepaga, F1357LDGSeguro, F1357LDGSeguMixto, F1357LDGRetPriv, F1357LDGCuotapartes, F1357LDGSepelio, F1357LDGRodado, F1357LDGDonaciones, F1357LDGOblig, F1357LDGMed, F1357LDGHipoteca, F1357LDGSGR, F1357LDGOtrasCaja, F1357LDGAlquiler, F1357LDGDomes, F1357LDGViaticos, F1357LDGIndu, F1357LDGOtras, F1357LDGTotal, F1357LDGOtrasAnses, F1357LDGOtrasProf, F1357LDGOtrasActores, F1357LDGOtrasPrev, F1357LDGDescuentosLey, F1357LDGOtrDescuLey, F1357LDGEducativos, F1357LDGMovEmpl, F1357LDGViaEmpl, F1357LDGCompAna, F1357LDGCompAnaCnt) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00UO9", "SAVEPOINT gxupdate;INSERT INTO F1357LDedPer(CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LDPTipReg, F1357LDPGNI, F1357LDPEspecial, F1357LDPEspecifica, F1357LDPConyuge, F1357LDPCantHijos, F1357LDPHijosImporte, F1357LDPTotalFami, F1357LDPTotalArt30, F1357LDPSujAntes, F1357LDPIncA, F1357LDPIncB, F1357LDPRemuSuj, F1357LDPCantHijIncap, F1357LDPHijosIncapImp, F1357LDPEspIncremen1, F1357LDPEspIncremen2, F1357LDPCantHij100PC, F1357ldpcAntHijIncap100pc, F1357LDPcantHijMay18, F1357LDPcantHijMay18_100pc) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00UO10", "SAVEPOINT gxupdate;INSERT INTO F1357LCalculo(CliCod, EmpCod, F1357CTipoPre, F1357CPer, F1357CSec, LegNumero, F1357LCTipReg, F1357LCAlicuota, F1357LCAliApli, F1357LCDeterminado, F1357LCRetenido, F1357LCPagosTotal, F1357LCSaldo, F1357CPagosCredDeb, F1357LCPagosAduanta, F1357LCPagosTurismo, F1357LCPagosBono, F1357LCPagosIncA, F1357LCPagosIncB, F1357LCPagosIncC, F1357LCPagosIncD, F1357LCPagosIncE, F1357LCCredDebMOv, F1357LCViajeExterior, F1357LC_GNSI, F1357LC_GanNeta, F1357LC_Cuota_fija, F1357LC_MesesTributados, F1357LC_Tope_anterior, F1357LC_DescuSobreGrav, F1357LC_AnticiposDeSac) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new ForEachCursor("P00UO11", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00UO12", "SELECT T1.LiqNro, T2.LiqRelNro, T1.DConCodigo, T2.LiqPerAno, T1.LegNumero, T1.EmpCod, T1.CliCod, T1.LiqDImpReCalcu, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro) WHERE (T1.CliCod = ? and T1.EmpCod = ?) AND (T2.LiqRelNro IS NULL) AND (T2.LiqPerAno = ?) AND (T1.DConCodigo = ( ?)) ORDER BY T1.CliCod, T1.EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00UO13", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P00UO14", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 6);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
               return;
            case 2 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(3);
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((short[]) buf[6])[0] = rslt.getShort(5);
               ((int[]) buf[7])[0] = rslt.getInt(6);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               return;
            case 3 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
               return;
            case 9 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
            case 10 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               return;
            case 11 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[9])[0] = rslt.getString(9, 10);
               ((java.util.Date[]) buf[10])[0] = rslt.getGXDate(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((short[]) buf[15])[0] = rslt.getShort(13);
               ((boolean[]) buf[16])[0] = rslt.wasNull();
               ((int[]) buf[17])[0] = rslt.getInt(14);
               return;
            case 12 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(4,2);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 20);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((String[]) buf[10])[0] = rslt.getVarchar(10);
               ((String[]) buf[11])[0] = rslt.getString(11, 20);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((boolean[]) buf[14])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[15])[0] = rslt.getGXDate(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
               ((int[]) buf[17])[0] = rslt.getInt(15);
               ((boolean[]) buf[18])[0] = rslt.wasNull();
               ((int[]) buf[19])[0] = rslt.getInt(16);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setString(6, (String)parms[5], 11);
               stmt.setString(7, (String)parms[6], 4);
               stmt.setString(8, (String)parms[7], 3);
               stmt.setString(9, (String)parms[8], 4);
               stmt.setString(10, (String)parms[9], 5);
               return;
            case 2 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 20);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               return;
            case 3 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
            case 4 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               stmt.setString(8, (String)parms[7], 11);
               stmt.setString(9, (String)parms[8], 8);
               stmt.setString(10, (String)parms[9], 8);
               stmt.setString(11, (String)parms[10], 2);
               stmt.setByte(12, ((Number) parms[11]).byteValue());
               stmt.setString(13, (String)parms[12], 1);
               stmt.setString(14, (String)parms[13], 1);
               stmt.setString(15, (String)parms[14], 1);
               stmt.setString(16, (String)parms[15], 1);
               stmt.setString(17, (String)parms[16], 1);
               stmt.setString(18, (String)parms[17], 1);
               return;
            case 5 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               stmt.setNLongVarchar(8, (String)parms[7], false);
               stmt.setNLongVarchar(9, (String)parms[8], false);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               return;
            case 6 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[25], 2);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[27], 2);
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[28], 2);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[29], 2);
               stmt.setNLongVarchar(31, (String)parms[30], false);
               stmt.setNLongVarchar(32, (String)parms[31], false);
               stmt.setBigDecimal(33, (java.math.BigDecimal)parms[32], 2);
               stmt.setBigDecimal(34, (java.math.BigDecimal)parms[33], 2);
               stmt.setBigDecimal(35, (java.math.BigDecimal)parms[34], 2);
               stmt.setBigDecimal(36, (java.math.BigDecimal)parms[35], 2);
               stmt.setByte(37, ((Number) parms[36]).byteValue());
               return;
            case 7 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               stmt.setBigDecimal(8, (java.math.BigDecimal)parms[7], 2);
               stmt.setBigDecimal(9, (java.math.BigDecimal)parms[8], 2);
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[25], 2);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               return;
            case 8 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setByte(3, ((Number) parms[2]).byteValue());
               stmt.setString(4, (String)parms[3], 6);
               stmt.setByte(5, ((Number) parms[4]).byteValue());
               stmt.setInt(6, ((Number) parms[5]).intValue());
               stmt.setString(7, (String)parms[6], 2);
               stmt.setByte(8, ((Number) parms[7]).byteValue());
               stmt.setByte(9, ((Number) parms[8]).byteValue());
               stmt.setBigDecimal(10, (java.math.BigDecimal)parms[9], 2);
               stmt.setBigDecimal(11, (java.math.BigDecimal)parms[10], 2);
               stmt.setBigDecimal(12, (java.math.BigDecimal)parms[11], 2);
               stmt.setBigDecimal(13, (java.math.BigDecimal)parms[12], 2);
               stmt.setBigDecimal(14, (java.math.BigDecimal)parms[13], 2);
               stmt.setBigDecimal(15, (java.math.BigDecimal)parms[14], 2);
               stmt.setBigDecimal(16, (java.math.BigDecimal)parms[15], 2);
               stmt.setBigDecimal(17, (java.math.BigDecimal)parms[16], 2);
               stmt.setBigDecimal(18, (java.math.BigDecimal)parms[17], 2);
               stmt.setBigDecimal(19, (java.math.BigDecimal)parms[18], 2);
               stmt.setBigDecimal(20, (java.math.BigDecimal)parms[19], 2);
               stmt.setBigDecimal(21, (java.math.BigDecimal)parms[20], 2);
               stmt.setBigDecimal(22, (java.math.BigDecimal)parms[21], 2);
               stmt.setBigDecimal(23, (java.math.BigDecimal)parms[22], 2);
               stmt.setBigDecimal(24, (java.math.BigDecimal)parms[23], 2);
               stmt.setBigDecimal(25, (java.math.BigDecimal)parms[24], 2);
               stmt.setBigDecimal(26, (java.math.BigDecimal)parms[25], 2);
               stmt.setBigDecimal(27, (java.math.BigDecimal)parms[26], 2);
               stmt.setBigDecimal(28, (java.math.BigDecimal)parms[27], 2);
               stmt.setBigDecimal(29, (java.math.BigDecimal)parms[28], 2);
               stmt.setBigDecimal(30, (java.math.BigDecimal)parms[29], 2);
               stmt.setBigDecimal(31, (java.math.BigDecimal)parms[30], 2);
               return;
            case 9 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[4]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[7], 10);
               }
               return;
            case 10 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setString(4, (String)parms[3], 10);
               return;
            case 11 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
            case 12 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[3]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[4]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[5]).shortValue());
               }
               return;
      }
   }

}

