package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculo_sac extends GXProcedure
{
   public calculo_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_sac.class ), "" );
   }

   public calculo_sac( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             byte[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 )
   {
      calculo_sac.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        byte[] aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             byte[] aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      calculo_sac.this.AV10CliCod = aP0;
      calculo_sac.this.AV28EmpCod = aP1;
      calculo_sac.this.AV29LiqNro = aP2;
      calculo_sac.this.AV54LiqRelNro = aP3;
      calculo_sac.this.AV22LegNumero = aP4;
      calculo_sac.this.AV16LiqPeriodo = aP5;
      calculo_sac.this.AV17ProcesoLiquidacion = aP6;
      calculo_sac.this.AV31insertandoConceptos = aP7;
      calculo_sac.this.aP8 = aP8;
      calculo_sac.this.aP9 = aP9;
      calculo_sac.this.aP10 = aP10;
      calculo_sac.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, "1") ;
      AV48LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV21haberesSACConCodigo ;
      GXt_char2 = AV21haberesSACConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_haberessac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      calculo_sac.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      calculo_sac.this.GXt_char1 = GXv_char4[0] ;
      AV21haberesSACConCodigo = GXt_char1 ;
      GXv_date5[0] = AV50FecDesde ;
      GXv_date6[0] = AV51FecHasta ;
      new web.rangofechassac(remoteHandle, context).execute( AV16LiqPeriodo, GXv_date5, GXv_date6) ;
      calculo_sac.this.AV50FecDesde = GXv_date5[0] ;
      calculo_sac.this.AV51FecHasta = GXv_date6[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, "2") ;
      GXv_decimal7[0] = AV27mejorSacLiqDImpCalcu ;
      GXv_char4[0] = AV49error ;
      GXv_int8[0] = AV48LiqDCalculado ;
      GXv_char3[0] = AV33LiqDLog ;
      new web.mejorsac(remoteHandle, context).execute( AV10CliCod, AV28EmpCod, AV29LiqNro, AV54LiqRelNro, AV22LegNumero, AV21haberesSACConCodigo, AV16LiqPeriodo, AV17ProcesoLiquidacion, GXv_decimal7, GXv_char4, GXv_int8, GXv_char3) ;
      calculo_sac.this.AV27mejorSacLiqDImpCalcu = GXv_decimal7[0] ;
      calculo_sac.this.AV49error = GXv_char4[0] ;
      calculo_sac.this.AV48LiqDCalculado = GXv_int8[0] ;
      calculo_sac.this.AV33LiqDLog = GXv_char3[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( "mejor sac &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV48LiqDCalculado, 1, 0))) ;
      if ( AV48LiqDCalculado == 0 )
      {
         AV49error += httpContext.getMessage( ". Error al calcular el mejor sueldo", "") ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      GXt_char2 = AV9egresoTLiqCod ;
      GXt_char1 = AV9egresoTLiqCod ;
      GXv_char4[0] = GXt_char1 ;
      new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculo_sac.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculo_sac.this.GXt_char2 = GXv_char3[0] ;
      AV9egresoTLiqCod = GXt_char2 ;
      AV39diasSemestrePalabra = "[dias_semestre]" ;
      GXv_int9[0] = AV42dias_semestre ;
      new web.obtvalformulacdmycds(remoteHandle, context).execute( AV10CliCod, AV28EmpCod, AV29LiqNro, AV22LegNumero, AV16LiqPeriodo, AV39diasSemestrePalabra, AV16LiqPeriodo, false, GXv_int9) ;
      calculo_sac.this.AV42dias_semestre = (short)((short)(GXv_int9[0])) ;
      AV41palabra = "[dias_remunerados_semestre]" ;
      GXv_int9[0] = AV43dias_remunerados_semestre ;
      GXv_int8[0] = AV45diasRemSemestreLiqDCalculado ;
      GXv_char4[0] = AV46diasRemSemError ;
      GXv_char3[0] = AV47diasRemSemLiqDLog ;
      new web.obtvalformuladtmydts(remoteHandle, context).execute( AV10CliCod, AV28EmpCod, AV29LiqNro, AV54LiqRelNro, AV22LegNumero, AV41palabra, AV16LiqPeriodo, true, true, true, AV17ProcesoLiquidacion, AV31insertandoConceptos, GXv_int9, GXv_int8, GXv_char4, GXv_char3) ;
      calculo_sac.this.AV43dias_remunerados_semestre = (short)((short)(GXv_int9[0])) ;
      calculo_sac.this.AV45diasRemSemestreLiqDCalculado = GXv_int8[0] ;
      calculo_sac.this.AV46diasRemSemError = GXv_char4[0] ;
      calculo_sac.this.AV47diasRemSemLiqDLog = GXv_char3[0] ;
      if ( AV45diasRemSemestreLiqDCalculado == 0 )
      {
         AV48LiqDCalculado = (byte)(0) ;
         AV49error = httpContext.getMessage( "No se pudo calcular días trabajados del semestre", "") ;
         if ( ! (GXutil.strcmp("", AV46diasRemSemError)==0) )
         {
            AV49error += " (" + GXutil.trim( AV46diasRemSemError) + ")" ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( "return2 ", "")+AV49error) ;
         AV33LiqDLog += GXutil.trim( AV49error) ;
         if ( ! (GXutil.strcmp("", AV47diasRemSemLiqDLog)==0) )
         {
            AV33LiqDLog += " (" + GXutil.trim( AV47diasRemSemLiqDLog) + ")" ;
         }
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV42dias_semestre == 0 )
      {
         AV48LiqDCalculado = (byte)(0) ;
         AV49error = httpContext.getMessage( "No se pudo calcular días del semestre", "") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( "return3 ", "")+AV49error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV38Importes = AV27mejorSacLiqDImpCalcu ;
      AV38Importes = AV38Importes.divide(DecimalUtil.doubleToDec(AV42dias_semestre), 18, java.math.RoundingMode.DOWN) ;
      AV33LiqDLog += httpContext.getMessage( ". Se divide entre los ", "") + GXutil.trim( GXutil.str( AV42dias_semestre, 4, 0)) + httpContext.getMessage( " días del semestre", "") ;
      AV33LiqDLog += httpContext.getMessage( ", quedando en ", "") + GXutil.trim( GXutil.str( AV38Importes, 14, 2)) ;
      AV38Importes = AV38Importes.multiply(DecimalUtil.doubleToDec(AV43dias_remunerados_semestre)) ;
      GXv_char4[0] = AV53dias_rem_sem_tooltip ;
      new web.armatooltip(remoteHandle, context).execute( AV10CliCod, DecimalUtil.doubleToDec(AV43dias_remunerados_semestre), AV47diasRemSemLiqDLog, false, GXv_char4) ;
      calculo_sac.this.AV53dias_rem_sem_tooltip = GXv_char4[0] ;
      AV33LiqDLog += httpContext.getMessage( ". Se multiplica por los ", "") + GXutil.trim( AV53dias_rem_sem_tooltip) + httpContext.getMessage( " días remunerados del semestre", "") ;
      AV38Importes = AV38Importes.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
      AV33LiqDLog += httpContext.getMessage( ". Se divide el valor entre 2.", "") ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV57Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV33LiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = calculo_sac.this.AV48LiqDCalculado;
      this.aP9[0] = calculo_sac.this.AV38Importes;
      this.aP10[0] = calculo_sac.this.AV49error;
      this.aP11[0] = calculo_sac.this.AV33LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV38Importes = DecimalUtil.ZERO ;
      AV49error = "" ;
      AV33LiqDLog = "" ;
      AV57Pgmname = "" ;
      AV21haberesSACConCodigo = "" ;
      AV50FecDesde = GXutil.nullDate() ;
      GXv_date5 = new java.util.Date[1] ;
      AV51FecHasta = GXutil.nullDate() ;
      GXv_date6 = new java.util.Date[1] ;
      AV27mejorSacLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV9egresoTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      AV39diasSemestrePalabra = "" ;
      AV41palabra = "" ;
      GXv_int9 = new int[1] ;
      GXv_int8 = new byte[1] ;
      AV46diasRemSemError = "" ;
      AV47diasRemSemLiqDLog = "" ;
      GXv_char3 = new String[1] ;
      AV53dias_rem_sem_tooltip = "" ;
      GXv_char4 = new String[1] ;
      AV57Pgmname = "calculo_sac" ;
      /* GeneXus formulas. */
      AV57Pgmname = "calculo_sac" ;
      Gx_err = (short)(0) ;
   }

   private byte AV48LiqDCalculado ;
   private byte AV45diasRemSemestreLiqDCalculado ;
   private byte GXv_int8[] ;
   private short AV28EmpCod ;
   private short AV42dias_semestre ;
   private short AV43dias_remunerados_semestre ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV29LiqNro ;
   private int AV54LiqRelNro ;
   private int AV22LegNumero ;
   private int GXv_int9[] ;
   private java.math.BigDecimal AV38Importes ;
   private java.math.BigDecimal AV27mejorSacLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV17ProcesoLiquidacion ;
   private String AV57Pgmname ;
   private String AV21haberesSACConCodigo ;
   private String AV9egresoTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String AV39diasSemestrePalabra ;
   private String AV41palabra ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private java.util.Date AV16LiqPeriodo ;
   private java.util.Date AV50FecDesde ;
   private java.util.Date GXv_date5[] ;
   private java.util.Date AV51FecHasta ;
   private java.util.Date GXv_date6[] ;
   private boolean AV31insertandoConceptos ;
   private boolean returnInSub ;
   private String AV33LiqDLog ;
   private String AV47diasRemSemLiqDLog ;
   private String AV49error ;
   private String AV46diasRemSemError ;
   private String AV53dias_rem_sem_tooltip ;
   private String[] aP11 ;
   private byte[] aP8 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
}

