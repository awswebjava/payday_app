package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularprorrateo extends GXProcedure
{
   public calcularprorrateo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularprorrateo.class ), "" );
   }

   public calcularprorrateo( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           java.util.Date aP4 ,
                                           java.math.BigDecimal aP5 ,
                                           String aP6 ,
                                           String aP7 ,
                                           java.math.BigDecimal aP8 ,
                                           java.math.BigDecimal[] aP9 ,
                                           String[] aP10 )
   {
      calcularprorrateo.this.aP11 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        String[] aP10 ,
                        java.math.BigDecimal[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             String[] aP10 ,
                             java.math.BigDecimal[] aP11 )
   {
      calcularprorrateo.this.AV16CliCod = aP0;
      calcularprorrateo.this.AV17EmpCod = aP1;
      calcularprorrateo.this.AV20LiqNro = aP2;
      calcularprorrateo.this.AV18LegNumero = aP3;
      calcularprorrateo.this.AV10LiqPeriodo = aP4;
      calcularprorrateo.this.AV11LiqDImpCalcu = aP5;
      calcularprorrateo.this.AV23ConCodigo = aP6;
      calcularprorrateo.this.AV27AplIIGGPrrtear = aP7;
      calcularprorrateo.this.AV26permitidoLiqDImpCalcu = aP8;
      calcularprorrateo.this.aP9 = aP9;
      calcularprorrateo.this.aP10 = aP10;
      calcularprorrateo.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&AplIIGGPrrtear ", "")+GXutil.trim( AV27AplIIGGPrrtear)) ;
      if ( GXutil.strcmp(AV27AplIIGGPrrtear, "VAR") == 0 )
      {
         AV8prrorateo1Mes = AV26permitidoLiqDImpCalcu ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&permitidoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV26permitidoLiqDImpCalcu, 14, 2))) ;
      }
      else
      {
         AV9mesesQueFaltan = (short)(13-GXutil.month( AV10LiqPeriodo)) ;
         AV25LiqDLog = httpContext.getMessage( "Calcula cuotas restantes en ", "") + GXutil.trim( GXutil.str( AV9mesesQueFaltan, 4, 0)) ;
         GXv_int1[0] = AV13LegClase ;
         new web.getlegajoclase(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV18LegNumero, GXv_int1) ;
         calcularprorrateo.this.AV13LegClase = GXv_int1[0] ;
         if ( AV13LegClase == 2 )
         {
            AV9mesesQueFaltan = (short)(AV9mesesQueFaltan*2) ;
            GXt_char2 = AV14primeraQuincenaTLiqCod ;
            GXt_char3 = AV14primeraQuincenaTLiqCod ;
            GXv_char4[0] = GXt_char3 ;
            new web.tipoliqquincena_codigoparam(remoteHandle, context).execute( GXv_char4) ;
            calcularprorrateo.this.GXt_char3 = GXv_char4[0] ;
            GXv_char5[0] = GXt_char2 ;
            new web.getparametro(remoteHandle, context).execute( AV16CliCod, GXt_char3, GXv_char5) ;
            calcularprorrateo.this.GXt_char2 = GXv_char5[0] ;
            AV14primeraQuincenaTLiqCod = GXt_char2 ;
            GXv_int1[0] = AV21esPrimera ;
            new web.esprimeraquincena(remoteHandle, context).execute( AV16CliCod, AV17EmpCod, AV20LiqNro, AV18LegNumero, AV10LiqPeriodo, AV13LegClase, GXv_int1) ;
            calcularprorrateo.this.AV21esPrimera = GXv_int1[0] ;
            AV25LiqDLog += httpContext.getMessage( ". Lo multiplica por 2 por ser Jornal. &esPrimera ", "") + GXutil.trim( GXutil.str( AV21esPrimera, 1, 0)) + httpContext.getMessage( " &saldoAnteriorHay ", "") + GXutil.trim( GXutil.booltostr( AV22saldoAnteriorHay)) + httpContext.getMessage( " &LiqNro ", "") + GXutil.trim( GXutil.str( AV20LiqNro, 8, 0)) + httpContext.getMessage( " liqperiod ", "") + GXutil.trim( localUtil.dtoc( AV10LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) ;
            if ( AV21esPrimera == 0 )
            {
               AV9mesesQueFaltan = (short)(AV9mesesQueFaltan-1) ;
               AV25LiqDLog += httpContext.getMessage( "Le resta 1 por ser segunda quincena", "") ;
            }
         }
         AV8prrorateo1Mes = AV11LiqDImpCalcu.divide(DecimalUtil.doubleToDec(AV9mesesQueFaltan), 18, java.math.RoundingMode.DOWN) ;
      }
      AV12LiqLegConSaldo = AV11LiqDImpCalcu.subtract(AV8prrorateo1Mes) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "LiqLegConSaldo ", "")+GXutil.trim( GXutil.str( AV12LiqLegConSaldo, 14, 2))+httpContext.getMessage( " &prrorateo1Mes ", "")+GXutil.trim( GXutil.str( AV8prrorateo1Mes, 14, 2))+httpContext.getMessage( " &mesesQueFaltan ", "")+GXutil.trim( GXutil.str( AV9mesesQueFaltan, 4, 0))+httpContext.getMessage( " perio ", "")+GXutil.trim( localUtil.dtoc( AV10LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV11LiqDImpCalcu, 14, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = calcularprorrateo.this.AV12LiqLegConSaldo;
      this.aP10[0] = calcularprorrateo.this.AV25LiqDLog;
      this.aP11[0] = calcularprorrateo.this.AV8prrorateo1Mes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqLegConSaldo = DecimalUtil.ZERO ;
      AV25LiqDLog = "" ;
      AV8prrorateo1Mes = DecimalUtil.ZERO ;
      AV32Pgmname = "" ;
      AV14primeraQuincenaTLiqCod = "" ;
      GXt_char2 = "" ;
      GXt_char3 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char5 = new String[1] ;
      GXv_int1 = new byte[1] ;
      AV32Pgmname = "CalcularProrrateo" ;
      /* GeneXus formulas. */
      AV32Pgmname = "CalcularProrrateo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13LegClase ;
   private byte AV21esPrimera ;
   private byte GXv_int1[] ;
   private short AV17EmpCod ;
   private short AV9mesesQueFaltan ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV20LiqNro ;
   private int AV18LegNumero ;
   private java.math.BigDecimal AV11LiqDImpCalcu ;
   private java.math.BigDecimal AV26permitidoLiqDImpCalcu ;
   private java.math.BigDecimal AV12LiqLegConSaldo ;
   private java.math.BigDecimal AV8prrorateo1Mes ;
   private String AV23ConCodigo ;
   private String AV27AplIIGGPrrtear ;
   private String AV32Pgmname ;
   private String AV14primeraQuincenaTLiqCod ;
   private String GXt_char2 ;
   private String GXt_char3 ;
   private String GXv_char4[] ;
   private String GXv_char5[] ;
   private java.util.Date AV10LiqPeriodo ;
   private boolean AV22saldoAnteriorHay ;
   private String AV25LiqDLog ;
   private java.math.BigDecimal[] aP11 ;
   private java.math.BigDecimal[] aP9 ;
   private String[] aP10 ;
}

