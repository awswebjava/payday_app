package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class procesarformulaconretro extends GXProcedure
{
   public procesarformulaconretro( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( procesarformulaconretro.class ), "" );
   }

   public procesarformulaconretro( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem>[] aP10 )
   {
      procesarformulaconretro.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        boolean aP9 ,
                        GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem>[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             boolean aP9 ,
                             GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem>[] aP10 ,
                             String[] aP11 )
   {
      procesarformulaconretro.this.AV10CliCod = aP0;
      procesarformulaconretro.this.AV18PaiCod = aP1;
      procesarformulaconretro.this.AV30parmTLiqCod = aP2;
      procesarformulaconretro.this.AV29parmLiqPeriodo = aP3;
      procesarformulaconretro.this.AV15idOperando = aP4;
      procesarformulaconretro.this.AV12DConCodigo = aP5;
      procesarformulaconretro.this.AV16LiqDForOrig = aP6;
      procesarformulaconretro.this.AV20retroPalabra = aP7;
      procesarformulaconretro.this.AV31validarAutoReferencia = aP8;
      procesarformulaconretro.this.AV13devolver_SDT_liq = aP9;
      procesarformulaconretro.this.AV26sdt_liq_retroactivas = aP10[0];
      this.aP10 = aP10;
      procesarformulaconretro.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_objcol_SdtSDTOperandosFormula1 = AV21SDTOperandos ;
      GXv_objcol_SdtSDTOperandosFormula2[0] = GXt_objcol_SdtSDTOperandosFormula1 ;
      new web.obtoperandosformula(remoteHandle, context).execute( AV10CliCod, AV12DConCodigo, AV16LiqDForOrig, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), GXv_objcol_SdtSDTOperandosFormula2) ;
      GXt_objcol_SdtSDTOperandosFormula1 = GXv_objcol_SdtSDTOperandosFormula2[0] ;
      AV21SDTOperandos = GXt_objcol_SdtSDTOperandosFormula1 ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "1 &SDTOperandos ", "")+GXutil.trim( GXutil.str( AV21SDTOperandos.size(), 9, 0))) ;
      AV39GXV1 = 1 ;
      while ( AV39GXV1 <= AV21SDTOperandos.size() )
      {
         AV22SDTOperandosItem = (web.SdtSDTOperandosFormula)((web.SdtSDTOperandosFormula)AV21SDTOperandos.elementAt(-1+AV39GXV1));
         GXv_char3[0] = AV17Operando ;
         GXv_char4[0] = "" ;
         new web.opeformulaapalabramayuscula(remoteHandle, context).execute( AV22SDTOperandosItem.getgxTv_SdtSDTOperandosFormula_Operandooriginal(), GXv_char3, GXv_char4) ;
         procesarformulaconretro.this.AV17Operando = GXv_char3[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&operando ", "")+GXutil.trim( AV17Operando)) ;
         if ( GXutil.strSearch( AV17Operando, GXutil.upper( AV20retroPalabra), 1) != 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "es palabra retroact", "")) ;
            AV35ConOpeId = AV15idOperando ;
            GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem5[0] = AV8cal_par_valores ;
            GXv_char4[0] = AV14error ;
            new web.devuelveparametrosgrabados(remoteHandle, context).execute( AV10CliCod, AV12DConCodigo, AV35ConOpeId, AV17Operando, GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem5, GXv_char4) ;
            AV8cal_par_valores = GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem5[0] ;
            procesarformulaconretro.this.AV14error = GXv_char4[0] ;
            if ( ! (GXutil.strcmp("", AV14error)==0) )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, "2") ;
            GXv_int6[0] = AV19PeriodoNum6 ;
            GXv_char4[0] = "" ;
            GXv_char3[0] = "" ;
            GXv_char7[0] = "" ;
            GXv_char8[0] = AV24TLiqCod ;
            GXv_boolean9[0] = false ;
            GXv_char10[0] = "" ;
            GXv_char11[0] = AV11ConceptoTipo ;
            GXv_char12[0] = AV9CatCodigo ;
            GXv_decimal13[0] = AV23SueldoBasico ;
            new web.recuperaparametrosdeconcepto(remoteHandle, context).execute( AV10CliCod, AV18PaiCod, AV15idOperando, AV8cal_par_valores, GXv_int6, GXv_char4, GXv_char3, GXv_char7, GXv_char8, GXv_boolean9, GXv_char10, GXv_char11, GXv_char12, GXv_decimal13) ;
            procesarformulaconretro.this.AV19PeriodoNum6 = GXv_int6[0] ;
            procesarformulaconretro.this.AV24TLiqCod = GXv_char8[0] ;
            procesarformulaconretro.this.AV11ConceptoTipo = GXv_char11[0] ;
            procesarformulaconretro.this.AV9CatCodigo = GXv_char12[0] ;
            procesarformulaconretro.this.AV23SueldoBasico = GXv_decimal13[0] ;
            GXv_int14[0] = AV33LiqPerAno ;
            GXv_int15[0] = AV34LiqPerMes ;
            GXv_int16[0] = (byte)(0) ;
            GXv_date17[0] = AV28LiqPeriodo ;
            new web.convertirnum6afecha(remoteHandle, context).execute( AV19PeriodoNum6, GXv_int14, GXv_int15, GXv_int16, GXv_date17) ;
            procesarformulaconretro.this.AV33LiqPerAno = GXv_int14[0] ;
            procesarformulaconretro.this.AV34LiqPerMes = GXv_int15[0] ;
            procesarformulaconretro.this.AV28LiqPeriodo = GXv_date17[0] ;
            if ( (0==AV19PeriodoNum6) || (GXutil.strcmp("", AV24TLiqCod)==0) )
            {
               if ( (0==AV19PeriodoNum6) && (GXutil.strcmp("", AV24TLiqCod)==0) )
               {
                  AV14error = httpContext.getMessage( "No se pudo recuperar periodo ni tipo de liquidación.", "") ;
               }
               else
               {
                  if ( (0==AV19PeriodoNum6) )
                  {
                     AV14error = httpContext.getMessage( "No se pudo recuperar periodo", "") ;
                  }
                  else
                  {
                     AV14error = httpContext.getMessage( "No se pudo recuperar tipo de liquidación", "") ;
                  }
               }
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            else
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&validarAutoReferencia ", "")+GXutil.trim( GXutil.booltostr( AV31validarAutoReferencia))) ;
               if ( AV31validarAutoReferencia )
               {
                  new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&parmTLiqCod \"", "")+AV30parmTLiqCod+httpContext.getMessage( "\" &TLiqCod \"", "")+AV24TLiqCod+httpContext.getMessage( "\" &PeriodoNum6 ", "")+GXutil.trim( GXutil.str( AV19PeriodoNum6, 6, 0))) ;
                  if ( GXutil.strcmp(GXutil.trim( AV30parmTLiqCod), GXutil.trim( AV24TLiqCod)) == 0 )
                  {
                     new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&parmLiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV29parmLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liqperiodo ", "")+GXutil.trim( localUtil.dtoc( AV28LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
                     if ( GXutil.dateCompare(GXutil.resetTime(AV29parmLiqPeriodo), GXutil.resetTime(AV28LiqPeriodo)) )
                     {
                        AV14error = httpContext.getMessage( "Error de autoreferencia. El concepto ", "") + GXutil.trim( AV12DConCodigo) + httpContext.getMessage( " usa cálculo retroactivo de mismo periodo y tipo de liquidación.", "") ;
                        new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, AV14error) ;
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                  }
               }
               if ( AV13devolver_SDT_liq )
               {
                  AV27yaEsta = false ;
                  AV40GXV2 = 1 ;
                  while ( AV40GXV2 <= AV26sdt_liq_retroactivas.size() )
                  {
                     AV25item = (web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem)((web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem)AV26sdt_liq_retroactivas.elementAt(-1+AV40GXV2));
                     if ( ( GXutil.strcmp(AV25item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo(), AV9CatCodigo) == 0 ) && ( AV25item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo() == AV19PeriodoNum6 ) && ( DecimalUtil.compareTo(AV25item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico(), AV23SueldoBasico) == 0 ) && ( GXutil.strcmp(AV25item.getgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod(), AV24TLiqCod) == 0 ) )
                     {
                        AV27yaEsta = true ;
                        if (true) break;
                     }
                     AV40GXV2 = (int)(AV40GXV2+1) ;
                  }
                  new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "&yaEsta ", "")+GXutil.trim( GXutil.booltostr( AV27yaEsta))+httpContext.getMessage( " &PeriodoNum6 ", "")+GXutil.trim( GXutil.str( AV19PeriodoNum6, 6, 0))+httpContext.getMessage( " &TLiqCod", "")+GXutil.trim( AV24TLiqCod)) ;
                  if ( ! AV27yaEsta )
                  {
                     AV25item = (web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem)new web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem(remoteHandle, context);
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Catcodigo( AV9CatCodigo );
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperiodo( AV28LiqPeriodo );
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Periodo( AV19PeriodoNum6 );
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Sueldobasico( AV23SueldoBasico );
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Tliqcod( AV24TLiqCod );
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqperano( AV33LiqPerAno );
                     AV25item.setgxTv_Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem_Liqpermes( AV34LiqPerMes );
                     AV26sdt_liq_retroactivas.add(AV25item, 0);
                     new web.msgdebug_prod(remoteHandle, context).execute( AV38Pgmname, httpContext.getMessage( "add", "")) ;
                  }
               }
            }
         }
         AV39GXV1 = (int)(AV39GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = procesarformulaconretro.this.AV26sdt_liq_retroactivas;
      this.aP11[0] = procesarformulaconretro.this.AV14error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14error = "" ;
      AV21SDTOperandos = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXt_objcol_SdtSDTOperandosFormula1 = new GXBaseCollection<web.SdtSDTOperandosFormula>(web.SdtSDTOperandosFormula.class, "SDTOperandosFormula", "PayDay", remoteHandle);
      GXv_objcol_SdtSDTOperandosFormula2 = new GXBaseCollection[1] ;
      AV38Pgmname = "" ;
      AV22SDTOperandosItem = new web.SdtSDTOperandosFormula(remoteHandle, context);
      AV17Operando = "" ;
      AV35ConOpeId = "" ;
      AV8cal_par_valores = new GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem>(web.Sdtcal_par_valores_cal_par_valoresItem.class, "cal_par_valoresItem", "PayDay", remoteHandle);
      GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem5 = new GXBaseCollection[1] ;
      GXv_int6 = new int[1] ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_char7 = new String[1] ;
      AV24TLiqCod = "" ;
      GXv_char8 = new String[1] ;
      GXv_boolean9 = new boolean[1] ;
      GXv_char10 = new String[1] ;
      AV11ConceptoTipo = "" ;
      GXv_char11 = new String[1] ;
      AV9CatCodigo = "" ;
      GXv_char12 = new String[1] ;
      AV23SueldoBasico = DecimalUtil.ZERO ;
      GXv_decimal13 = new java.math.BigDecimal[1] ;
      GXv_int14 = new short[1] ;
      GXv_int15 = new byte[1] ;
      GXv_int16 = new byte[1] ;
      AV28LiqPeriodo = GXutil.nullDate() ;
      GXv_date17 = new java.util.Date[1] ;
      AV25item = new web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem(remoteHandle, context);
      AV38Pgmname = "procesarFormulaConRetro" ;
      /* GeneXus formulas. */
      AV38Pgmname = "procesarFormulaConRetro" ;
      Gx_err = (short)(0) ;
   }

   private byte AV34LiqPerMes ;
   private byte GXv_int15[] ;
   private byte GXv_int16[] ;
   private short AV18PaiCod ;
   private short AV33LiqPerAno ;
   private short GXv_int14[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV39GXV1 ;
   private int AV19PeriodoNum6 ;
   private int GXv_int6[] ;
   private int AV40GXV2 ;
   private java.math.BigDecimal AV23SueldoBasico ;
   private java.math.BigDecimal GXv_decimal13[] ;
   private String AV30parmTLiqCod ;
   private String AV15idOperando ;
   private String AV12DConCodigo ;
   private String AV20retroPalabra ;
   private String AV38Pgmname ;
   private String AV35ConOpeId ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private String GXv_char7[] ;
   private String AV24TLiqCod ;
   private String GXv_char8[] ;
   private String GXv_char10[] ;
   private String AV11ConceptoTipo ;
   private String GXv_char11[] ;
   private String AV9CatCodigo ;
   private String GXv_char12[] ;
   private java.util.Date AV29parmLiqPeriodo ;
   private java.util.Date AV28LiqPeriodo ;
   private java.util.Date GXv_date17[] ;
   private boolean AV31validarAutoReferencia ;
   private boolean AV13devolver_SDT_liq ;
   private boolean returnInSub ;
   private boolean GXv_boolean9[] ;
   private boolean AV27yaEsta ;
   private String AV16LiqDForOrig ;
   private String AV14error ;
   private String AV17Operando ;
   private String[] aP11 ;
   private GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem>[] aP10 ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> AV8cal_par_valores ;
   private GXBaseCollection<web.Sdtcal_par_valores_cal_par_valoresItem> GXv_objcol_Sdtcal_par_valores_cal_par_valoresItem5[] ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> AV21SDTOperandos ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXt_objcol_SdtSDTOperandosFormula1 ;
   private GXBaseCollection<web.SdtSDTOperandosFormula> GXv_objcol_SdtSDTOperandosFormula2[] ;
   private GXBaseCollection<web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem> AV26sdt_liq_retroactivas ;
   private web.SdtSDTOperandosFormula AV22SDTOperandosItem ;
   private web.Sdtsdt_liq_retroactivas_sdt_liq_retroactivasItem AV25item ;
}

