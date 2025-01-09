package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularsac extends GXProcedure
{
   public calcularsac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularsac.class ), "" );
   }

   public calcularsac( int remoteHandle ,
                       ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              String aP4 ,
                              java.util.Date aP5 ,
                              String aP6 ,
                              String aP7 )
   {
      calcularsac.this.aP8 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean[] aP8 )
   {
      calcularsac.this.AV13CliCod = aP0;
      calcularsac.this.AV15EmpCod = aP1;
      calcularsac.this.AV19LiqNro = aP2;
      calcularsac.this.AV16LegNumero = aP3;
      calcularsac.this.AV8TLiqCod = aP4;
      calcularsac.this.AV11LiqPeriodo = aP5;
      calcularsac.this.AV25ConCodigo = aP6;
      calcularsac.this.AV29ProcesoLiquidacion = aP7;
      calcularsac.this.aP8 = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_boolean1 = AV14LegAgenReten ;
      GXv_boolean2[0] = GXt_boolean1 ;
      new web.getlegagenreten(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV16LegNumero, GXv_boolean2) ;
      calcularsac.this.GXt_boolean1 = GXv_boolean2[0] ;
      AV14LegAgenReten = GXt_boolean1 ;
      GXv_int3[0] = (byte)(AV24liquidaSAC) ;
      GXv_char4[0] = AV28auxLiqDLog ;
      new web.liquidar_sac(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV19LiqNro, AV8TLiqCod, AV11LiqPeriodo, GXv_int3, GXv_char4) ;
      calcularsac.this.AV24liquidaSAC = GXv_int3[0] ;
      calcularsac.this.AV28auxLiqDLog = GXv_char4[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " tliqcod ", "")+GXutil.trim( AV8TLiqCod)+httpContext.getMessage( " liqperiod ", "")+GXutil.trim( localUtil.dtoc( AV11LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " liquidasac ", "")+GXutil.trim( GXutil.str( AV24liquidaSAC, 4, 0))+httpContext.getMessage( " &auxLiqDLog ", "")+GXutil.trim( AV28auxLiqDLog)) ;
      if ( AV24liquidaSAC == 1 )
      {
         AV12calcularSAC = true ;
      }
      else
      {
         GXt_char5 = AV26SACConCodigo ;
         GXt_char6 = AV26SACConCodigo ;
         GXv_char4[0] = GXt_char6 ;
         new web.concepto_sac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
         calcularsac.this.GXt_char6 = GXv_char4[0] ;
         GXv_char7[0] = GXt_char5 ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char6, GXv_char7) ;
         calcularsac.this.GXt_char5 = GXv_char7[0] ;
         AV26SACConCodigo = GXt_char5 ;
         GXt_char6 = AV27SACProporConCOdigo ;
         GXt_char5 = AV27SACProporConCOdigo ;
         GXv_char7[0] = GXt_char5 ;
         new web.concepto_sacpropor_codigoparam(remoteHandle, context).execute( GXv_char7) ;
         calcularsac.this.GXt_char5 = GXv_char7[0] ;
         GXv_char4[0] = GXt_char6 ;
         new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char5, GXv_char4) ;
         calcularsac.this.GXt_char6 = GXv_char4[0] ;
         AV27SACProporConCOdigo = GXt_char6 ;
         if ( ( AV24liquidaSAC == 0 ) && ( ( GXutil.strcmp(AV25ConCodigo, AV26SACConCodigo) == 0 ) || ( GXutil.strcmp(AV25ConCodigo, AV27SACProporConCOdigo) == 0 ) ) )
         {
            AV12calcularSAC = false ;
         }
         else
         {
            GXt_char6 = AV20alcanzaGananciasConCodigo ;
            GXt_char5 = AV20alcanzaGananciasConCodigo ;
            GXv_char7[0] = GXt_char5 ;
            new web.concepto_alcanzaganancias_codigoparam(remoteHandle, context).execute( GXv_char7) ;
            calcularsac.this.GXt_char5 = GXv_char7[0] ;
            GXv_char4[0] = GXt_char6 ;
            new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char5, GXv_char4) ;
            calcularsac.this.GXt_char6 = GXv_char4[0] ;
            AV20alcanzaGananciasConCodigo = GXt_char6 ;
            GXv_decimal8[0] = DecimalUtil.doubleToDec(AV18alcanzaGanancias) ;
            GXv_boolean2[0] = AV21existe ;
            GXv_int3[0] = AV22LiqDCalculado ;
            new web.getliqdimpcalcu(remoteHandle, context).execute( AV13CliCod, AV15EmpCod, AV19LiqNro, AV16LegNumero, AV20alcanzaGananciasConCodigo, AV29ProcesoLiquidacion, false, GXv_decimal8, GXv_boolean2, GXv_int3) ;
            calcularsac.this.AV18alcanzaGanancias = (short)(DecimalUtil.decToDouble(GXv_decimal8[0])) ;
            calcularsac.this.AV21existe = GXv_boolean2[0] ;
            calcularsac.this.AV22LiqDCalculado = GXv_int3[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV32Pgmname, httpContext.getMessage( "&LiqNro ", "")+GXutil.trim( GXutil.str( AV19LiqNro, 8, 0))+httpContext.getMessage( " legnumero ", "")+GXutil.trim( GXutil.str( AV16LegNumero, 8, 0))+httpContext.getMessage( " &alcanzaGanancias ", "")+GXutil.trim( GXutil.str( AV18alcanzaGanancias, 4, 0))+httpContext.getMessage( " &existe ", "")+GXutil.trim( GXutil.booltostr( AV21existe))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV22LiqDCalculado, 1, 0))) ;
            if ( ( AV18alcanzaGanancias == 1 ) || ( ( AV22LiqDCalculado == 0 ) && ( AV14LegAgenReten ) ) )
            {
               AV12calcularSAC = true ;
            }
            else
            {
               GXt_char6 = AV9tipoLiqEgresoTLiqCod ;
               GXt_char5 = AV9tipoLiqEgresoTLiqCod ;
               GXv_char7[0] = GXt_char5 ;
               new web.tipoliqegreso_codigoparam(remoteHandle, context).execute( GXv_char7) ;
               calcularsac.this.GXt_char5 = GXv_char7[0] ;
               GXv_char4[0] = GXt_char6 ;
               new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char5, GXv_char4) ;
               calcularsac.this.GXt_char6 = GXv_char4[0] ;
               AV9tipoLiqEgresoTLiqCod = GXt_char6 ;
               GXt_char6 = AV10tipoLiqAguinaldoTLiqCod ;
               GXt_char5 = AV10tipoLiqAguinaldoTLiqCod ;
               GXv_char7[0] = GXt_char5 ;
               new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char7) ;
               calcularsac.this.GXt_char5 = GXv_char7[0] ;
               GXv_char4[0] = GXt_char6 ;
               new web.getparametro(remoteHandle, context).execute( AV13CliCod, GXt_char5, GXv_char4) ;
               calcularsac.this.GXt_char6 = GXv_char4[0] ;
               AV10tipoLiqAguinaldoTLiqCod = GXt_char6 ;
               if ( ( GXutil.strcmp(AV8TLiqCod, AV9tipoLiqEgresoTLiqCod) == 0 ) || ( GXutil.strcmp(AV8TLiqCod, AV10tipoLiqAguinaldoTLiqCod) == 0 ) || ( GXutil.month( AV11LiqPeriodo) == 6 ) || ( GXutil.month( AV11LiqPeriodo) == 12 ) )
               {
                  AV12calcularSAC = true ;
               }
               else
               {
                  AV12calcularSAC = false ;
               }
            }
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = calcularsac.this.AV12calcularSAC;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV28auxLiqDLog = "" ;
      AV32Pgmname = "" ;
      AV26SACConCodigo = "" ;
      AV27SACProporConCOdigo = "" ;
      AV20alcanzaGananciasConCodigo = "" ;
      GXv_decimal8 = new java.math.BigDecimal[1] ;
      GXv_boolean2 = new boolean[1] ;
      GXv_int3 = new byte[1] ;
      AV9tipoLiqEgresoTLiqCod = "" ;
      AV10tipoLiqAguinaldoTLiqCod = "" ;
      GXt_char6 = "" ;
      GXt_char5 = "" ;
      GXv_char7 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV32Pgmname = "calcularSAC" ;
      /* GeneXus formulas. */
      AV32Pgmname = "calcularSAC" ;
      Gx_err = (short)(0) ;
   }

   private byte AV22LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV15EmpCod ;
   private short AV24liquidaSAC ;
   private short AV18alcanzaGanancias ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV19LiqNro ;
   private int AV16LegNumero ;
   private java.math.BigDecimal GXv_decimal8[] ;
   private String AV8TLiqCod ;
   private String AV25ConCodigo ;
   private String AV29ProcesoLiquidacion ;
   private String AV32Pgmname ;
   private String AV26SACConCodigo ;
   private String AV27SACProporConCOdigo ;
   private String AV20alcanzaGananciasConCodigo ;
   private String AV9tipoLiqEgresoTLiqCod ;
   private String AV10tipoLiqAguinaldoTLiqCod ;
   private String GXt_char6 ;
   private String GXt_char5 ;
   private String GXv_char7[] ;
   private String GXv_char4[] ;
   private java.util.Date AV11LiqPeriodo ;
   private boolean AV12calcularSAC ;
   private boolean AV14LegAgenReten ;
   private boolean GXt_boolean1 ;
   private boolean AV21existe ;
   private boolean GXv_boolean2[] ;
   private String AV28auxLiqDLog ;
   private boolean[] aP8 ;
}

