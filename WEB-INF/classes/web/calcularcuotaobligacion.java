package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularcuotaobligacion extends GXProcedure
{
   public calcularcuotaobligacion( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularcuotaobligacion.class ), "" );
   }

   public calcularcuotaobligacion( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             short aP6 ,
                             short aP7 ,
                             short aP8 ,
                             java.math.BigDecimal aP9 ,
                             short aP10 ,
                             java.math.BigDecimal aP11 ,
                             java.math.BigDecimal aP12 ,
                             short aP13 ,
                             String aP14 ,
                             boolean aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             String[] aP18 ,
                             byte[] aP19 )
   {
      calcularcuotaobligacion.this.aP20 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
      return aP20[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        short aP6 ,
                        short aP7 ,
                        short aP8 ,
                        java.math.BigDecimal aP9 ,
                        short aP10 ,
                        java.math.BigDecimal aP11 ,
                        java.math.BigDecimal aP12 ,
                        short aP13 ,
                        String aP14 ,
                        boolean aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        String[] aP18 ,
                        byte[] aP19 ,
                        String[] aP20 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             short aP6 ,
                             short aP7 ,
                             short aP8 ,
                             java.math.BigDecimal aP9 ,
                             short aP10 ,
                             java.math.BigDecimal aP11 ,
                             java.math.BigDecimal aP12 ,
                             short aP13 ,
                             String aP14 ,
                             boolean aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             String[] aP18 ,
                             byte[] aP19 ,
                             String[] aP20 )
   {
      calcularcuotaobligacion.this.AV10CliCod = aP0;
      calcularcuotaobligacion.this.AV11EmpCod = aP1;
      calcularcuotaobligacion.this.AV20LiqNro = aP2;
      calcularcuotaobligacion.this.AV12LegNumero = aP3;
      calcularcuotaobligacion.this.AV21LiqPeriodo = aP4;
      calcularcuotaobligacion.this.AV23ConCodigo = aP5;
      calcularcuotaobligacion.this.AV26PaiCod = aP6;
      calcularcuotaobligacion.this.AV22OblSecuencial = aP7;
      calcularcuotaobligacion.this.AV36EmbargaSec = aP8;
      calcularcuotaobligacion.this.AV8saldo = aP9;
      calcularcuotaobligacion.this.AV16OblCanCuo = aP10;
      calcularcuotaobligacion.this.AV18OblImpFij = aP11;
      calcularcuotaobligacion.this.AV19OblPorc = aP12;
      calcularcuotaobligacion.this.AV33mesesQueFaltan = aP13;
      calcularcuotaobligacion.this.AV24ProcesoLiquidacion = aP14;
      calcularcuotaobligacion.this.AV25insertandoConceptos = aP15;
      calcularcuotaobligacion.this.aP16 = aP16;
      calcularcuotaobligacion.this.aP17 = aP17;
      calcularcuotaobligacion.this.aP18 = aP18;
      calcularcuotaobligacion.this.aP19 = aP19;
      calcularcuotaobligacion.this.aP20 = aP20;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV31LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "1 &OblCanCuo ", "")+GXutil.trim( GXutil.str( AV16OblCanCuo, 4, 0))+httpContext.getMessage( " &saldo ", "")+GXutil.trim( GXutil.str( AV8saldo, 14, 2))) ;
      if ( ( AV16OblCanCuo > 0 ) && ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV8saldo)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "1b &mesesQueFaltan ", "")+GXutil.trim( GXutil.str( AV33mesesQueFaltan, 4, 0))) ;
         AV15cuotaLiqDImpCalcu = AV8saldo.divide(DecimalUtil.doubleToDec(AV33mesesQueFaltan), 18, java.math.RoundingMode.DOWN) ;
         AV9LiqDLog = httpContext.getMessage( "Calcula cuota en ", "") + GXutil.trim( GXutil.str( AV15cuotaLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " dividiendo el saldo ", "") + GXutil.trim( GXutil.str( AV8saldo, 14, 2)) + httpContext.getMessage( " entre las ", "") + GXutil.trim( GXutil.str( AV33mesesQueFaltan, 4, 0)) + httpContext.getMessage( " cuotas restantes", "") ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "2") ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV18OblImpFij)==0) )
         {
            AV15cuotaLiqDImpCalcu = AV18OblImpFij ;
            AV9LiqDLog = httpContext.getMessage( "Inicializa valor con importe fijo", "") ;
         }
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV19OblPorc)==0) )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "3") ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV18OblImpFij)==0) )
            {
               AV9LiqDLog += " " + GXutil.trim( GXutil.str( AV18OblImpFij, 14, 2)) ;
            }
            GXv_decimal1[0] = AV35baseCalculoLiqDImpCalcu ;
            GXv_char2[0] = AV28porcError ;
            GXv_char3[0] = AV29porcLiqDLog ;
            GXv_int4[0] = AV30porcLiqDCalculado ;
            new web.basecalculo_obligacion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV20LiqNro, AV12LegNumero, AV21LiqPeriodo, AV22OblSecuencial, AV23ConCodigo, AV24ProcesoLiquidacion, AV25insertandoConceptos, AV26PaiCod, GXv_decimal1, GXv_char2, GXv_char3, GXv_int4) ;
            calcularcuotaobligacion.this.AV35baseCalculoLiqDImpCalcu = GXv_decimal1[0] ;
            calcularcuotaobligacion.this.AV28porcError = GXv_char2[0] ;
            calcularcuotaobligacion.this.AV29porcLiqDLog = GXv_char3[0] ;
            calcularcuotaobligacion.this.AV30porcLiqDCalculado = GXv_int4[0] ;
            if ( AV30porcLiqDCalculado == 0 )
            {
               AV31LiqDCalculado = (byte)(0) ;
               AV32error = AV28porcError ;
               AV9LiqDLog += AV28porcError ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV9LiqDLog += ". " + GXutil.trim( AV29porcLiqDLog) ;
            AV27porcentajeLiqDImpCalcu = AV35baseCalculoLiqDImpCalcu.multiply(AV19OblPorc) ;
            AV15cuotaLiqDImpCalcu = AV15cuotaLiqDImpCalcu.add(AV27porcentajeLiqDImpCalcu) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV18OblImpFij)==0) )
            {
               AV9LiqDLog += httpContext.getMessage( ". Suma ", "") ;
            }
            else
            {
               AV9LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
            }
            AV9LiqDLog += GXutil.trim( GXutil.str( AV27porcentajeLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondiente a la base de cálculo multiplicado por el porcentaje ", "") + GXutil.trim( GXutil.str( AV19OblPorc, 6, 4)) ;
         }
         else
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "4 &EmbargaSec ", "")+GXutil.trim( GXutil.str( AV36EmbargaSec, 4, 0))) ;
            if ( ! (0==AV36EmbargaSec) )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "5") ;
               GXv_decimal1[0] = AV35baseCalculoLiqDImpCalcu ;
               GXv_decimal5[0] = AV37porUnaje ;
               GXv_char3[0] = AV38embarError ;
               GXv_int4[0] = AV39embarLiqDCalculado ;
               GXv_char2[0] = AV40embarLiqDLog ;
               new web.getporcentajesegunembar(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV26PaiCod, AV20LiqNro, AV12LegNumero, AV21LiqPeriodo, AV36EmbargaSec, AV24ProcesoLiquidacion, AV25insertandoConceptos, GXv_decimal1, GXv_decimal5, GXv_char3, GXv_int4, GXv_char2) ;
               calcularcuotaobligacion.this.AV35baseCalculoLiqDImpCalcu = GXv_decimal1[0] ;
               calcularcuotaobligacion.this.AV37porUnaje = GXv_decimal5[0] ;
               calcularcuotaobligacion.this.AV38embarError = GXv_char3[0] ;
               calcularcuotaobligacion.this.AV39embarLiqDCalculado = GXv_int4[0] ;
               calcularcuotaobligacion.this.AV40embarLiqDLog = GXv_char2[0] ;
               if ( AV39embarLiqDCalculado == 0 )
               {
                  AV31LiqDCalculado = (byte)(0) ;
                  AV32error = AV38embarError ;
                  AV9LiqDLog = AV32error ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "6") ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, "7") ;
               AV9LiqDLog += ". " + AV40embarLiqDLog ;
               AV15cuotaLiqDImpCalcu = AV35baseCalculoLiqDImpCalcu.multiply(AV37porUnaje) ;
            }
         }
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV8saldo)==0) && ( DecimalUtil.compareTo(AV15cuotaLiqDImpCalcu, AV8saldo) > 0 ) )
      {
         AV15cuotaLiqDImpCalcu = AV8saldo ;
         AV9LiqDLog += httpContext.getMessage( ". Se asigna cuota igual al saldo por ser el saldo mayor que la cuota calculada. Se saldó totalmente la deuda.", "") ;
         AV34LiqLegConSaldo = DecimalUtil.doubleToDec(0) ;
      }
      else
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV8saldo)==0) )
         {
            AV34LiqLegConSaldo = AV8saldo.subtract(AV15cuotaLiqDImpCalcu) ;
            AV9LiqDLog += httpContext.getMessage( ". Nuevo saldo se calcula en ", "") + GXutil.trim( GXutil.str( AV34LiqLegConSaldo, 14, 2)) + httpContext.getMessage( " resultante de la diferencia entre el saldo anterior ", "") + GXutil.trim( GXutil.str( AV8saldo, 14, 2)) + httpContext.getMessage( " y la cuota", "") ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&LiqLegConSaldo ", "")+GXutil.trim( GXutil.str( AV34LiqLegConSaldo, 14, 2))+httpContext.getMessage( " &prrorateo1Mes ", "")+GXutil.trim( GXutil.str( AV14prrorateo1Mes, 2, 0))+httpContext.getMessage( " &OblCanCuo ", "")+GXutil.trim( GXutil.str( AV16OblCanCuo, 4, 0))+httpContext.getMessage( " perio ", "")+GXutil.trim( localUtil.dtoc( AV21LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &saldo ", "")+GXutil.trim( GXutil.str( AV8saldo, 14, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP16[0] = calcularcuotaobligacion.this.AV15cuotaLiqDImpCalcu;
      this.aP17[0] = calcularcuotaobligacion.this.AV34LiqLegConSaldo;
      this.aP18[0] = calcularcuotaobligacion.this.AV32error;
      this.aP19[0] = calcularcuotaobligacion.this.AV31LiqDCalculado;
      this.aP20[0] = calcularcuotaobligacion.this.AV9LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV15cuotaLiqDImpCalcu = DecimalUtil.ZERO ;
      AV34LiqLegConSaldo = DecimalUtil.ZERO ;
      AV32error = "" ;
      AV9LiqDLog = "" ;
      AV43Pgmname = "" ;
      AV35baseCalculoLiqDImpCalcu = DecimalUtil.ZERO ;
      AV28porcError = "" ;
      AV29porcLiqDLog = "" ;
      AV27porcentajeLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV37porUnaje = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV38embarError = "" ;
      GXv_char3 = new String[1] ;
      GXv_int4 = new byte[1] ;
      AV40embarLiqDLog = "" ;
      GXv_char2 = new String[1] ;
      AV43Pgmname = "CalcularCuotaObligacion" ;
      /* GeneXus formulas. */
      AV43Pgmname = "CalcularCuotaObligacion" ;
      Gx_err = (short)(0) ;
   }

   private byte AV31LiqDCalculado ;
   private byte AV30porcLiqDCalculado ;
   private byte AV39embarLiqDCalculado ;
   private byte GXv_int4[] ;
   private byte AV14prrorateo1Mes ;
   private short AV11EmpCod ;
   private short AV26PaiCod ;
   private short AV22OblSecuencial ;
   private short AV36EmbargaSec ;
   private short AV16OblCanCuo ;
   private short AV33mesesQueFaltan ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV20LiqNro ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV8saldo ;
   private java.math.BigDecimal AV18OblImpFij ;
   private java.math.BigDecimal AV19OblPorc ;
   private java.math.BigDecimal AV15cuotaLiqDImpCalcu ;
   private java.math.BigDecimal AV34LiqLegConSaldo ;
   private java.math.BigDecimal AV35baseCalculoLiqDImpCalcu ;
   private java.math.BigDecimal AV27porcentajeLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV37porUnaje ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV23ConCodigo ;
   private String AV24ProcesoLiquidacion ;
   private String AV43Pgmname ;
   private String GXv_char3[] ;
   private String GXv_char2[] ;
   private java.util.Date AV21LiqPeriodo ;
   private boolean AV25insertandoConceptos ;
   private boolean returnInSub ;
   private String AV9LiqDLog ;
   private String AV29porcLiqDLog ;
   private String AV40embarLiqDLog ;
   private String AV32error ;
   private String AV28porcError ;
   private String AV38embarError ;
   private String[] aP20 ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private String[] aP18 ;
   private byte[] aP19 ;
}

