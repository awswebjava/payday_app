package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class altacuentaliqlegpornovedadbis extends GXProcedure
{
   public altacuentaliqlegpornovedadbis( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( altacuentaliqlegpornovedadbis.class ), "" );
   }

   public altacuentaliqlegpornovedadbis( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal aP3 ,
                             int aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String aP11 ,
                             byte[] aP12 )
   {
      altacuentaliqlegpornovedadbis.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.math.BigDecimal aP2 ,
                        java.math.BigDecimal aP3 ,
                        int aP4 ,
                        int aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        short aP9 ,
                        String aP10 ,
                        String aP11 ,
                        byte[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.math.BigDecimal aP2 ,
                             java.math.BigDecimal aP3 ,
                             int aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             short aP9 ,
                             String aP10 ,
                             String aP11 ,
                             byte[] aP12 ,
                             String[] aP13 )
   {
      altacuentaliqlegpornovedadbis.this.AV9CliCod = aP0;
      altacuentaliqlegpornovedadbis.this.AV22EmpCod = aP1;
      altacuentaliqlegpornovedadbis.this.AV23parm_totalLiqDImpCalcu = aP2;
      altacuentaliqlegpornovedadbis.this.AV16permitidoLiqDImpCalcu = aP3;
      altacuentaliqlegpornovedadbis.this.AV18LiqNro = aP4;
      altacuentaliqlegpornovedadbis.this.AV19LegNumero = aP5;
      altacuentaliqlegpornovedadbis.this.AV10LiqPeriodo = aP6;
      altacuentaliqlegpornovedadbis.this.AV28ConCodigo = aP7;
      altacuentaliqlegpornovedadbis.this.AV30insertandoConceptos = aP8;
      altacuentaliqlegpornovedadbis.this.AV33DAplIIGG = aP9;
      altacuentaliqlegpornovedadbis.this.AV38AplIIGGPrrtear = aP10;
      altacuentaliqlegpornovedadbis.this.AV34ProcesoLiquidacion = aP11;
      altacuentaliqlegpornovedadbis.this.aP12 = aP12;
      altacuentaliqlegpornovedadbis.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV36LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, httpContext.getMessage( "&parm_totalLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV23parm_totalLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &concodigo ", "")+GXutil.trim( AV28ConCodigo)+httpContext.getMessage( " &AplIIGGPrrtear ", "")+GXutil.trim( AV38AplIIGGPrrtear)) ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV23parm_totalLiqDImpCalcu)==0) )
      {
         AV15totalLiqDImpCalcu = AV23parm_totalLiqDImpCalcu ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, httpContext.getMessage( "asdasdfdsaff", "")) ;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, httpContext.getMessage( "antes de llamar al bonosprod &ConCodigo ", "")+AV28ConCodigo) ;
         GXv_decimal1[0] = AV15totalLiqDImpCalcu ;
         GXv_boolean2[0] = AV21existe ;
         GXv_int3[0] = AV35bonoLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV9CliCod, AV22EmpCod, AV18LiqNro, AV19LegNumero, AV28ConCodigo, AV34ProcesoLiquidacion, AV30insertandoConceptos, GXv_decimal1, GXv_boolean2, GXv_int3) ;
         altacuentaliqlegpornovedadbis.this.AV15totalLiqDImpCalcu = GXv_decimal1[0] ;
         altacuentaliqlegpornovedadbis.this.AV21existe = GXv_boolean2[0] ;
         altacuentaliqlegpornovedadbis.this.AV35bonoLiqDCalculado = GXv_int3[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, httpContext.getMessage( "&totalLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV15totalLiqDImpCalcu, 14, 2))) ;
         if ( ( AV35bonoLiqDCalculado == 0 ) && ( AV21existe ) )
         {
            AV36LiqDCalculado = (byte)(0) ;
            AV37error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( AV28ConCodigo) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      if ( GXutil.strcmp(AV38AplIIGGPrrtear, "VAR") == 0 )
      {
         AV13enCuotasLiqDImpCalcu = AV15totalLiqDImpCalcu ;
         AV41LiqLegEsPrrGan = false ;
      }
      else
      {
         AV13enCuotasLiqDImpCalcu = AV15totalLiqDImpCalcu.subtract(AV16permitidoLiqDImpCalcu) ;
         AV41LiqLegEsPrrGan = true ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, httpContext.getMessage( "&minimoParaProrrateoGanancias ", "")+GXutil.trim( GXutil.str( AV12minimoParaProrrateoGanancias, 14, 2))+httpContext.getMessage( " calculo ", "")+GXutil.trim( GXutil.str( AV14LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &&enCuotasLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV13enCuotasLiqDImpCalcu, 14, 2))+httpContext.getMessage( " &permitidoLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV16permitidoLiqDImpCalcu, 14, 2))+httpContext.getMessage( " existe ", "")+GXutil.trim( GXutil.booltostr( AV21existe))+httpContext.getMessage( " &totalLiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV15totalLiqDImpCalcu, 14, 2))) ;
      GXv_decimal1[0] = AV17LiqLegConSaldo ;
      GXv_char4[0] = "" ;
      GXv_decimal5[0] = AV32LiqLegCuota ;
      new web.calcularprorrateo(remoteHandle, context).execute( AV9CliCod, AV22EmpCod, AV18LiqNro, AV19LegNumero, AV10LiqPeriodo, AV13enCuotasLiqDImpCalcu, AV28ConCodigo, AV38AplIIGGPrrtear, AV16permitidoLiqDImpCalcu, GXv_decimal1, GXv_char4, GXv_decimal5) ;
      altacuentaliqlegpornovedadbis.this.AV17LiqLegConSaldo = GXv_decimal1[0] ;
      altacuentaliqlegpornovedadbis.this.AV32LiqLegCuota = GXv_decimal5[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, "1") ;
      if ( ! (GXutil.strcmp("", AV28ConCodigo)==0) )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, "2") ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV44Pgmname, httpContext.getMessage( "calculo ", "")+GXutil.trim( GXutil.str( AV17LiqLegConSaldo, 14, 2))) ;
         GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
         new web.newcuentaliqleg(remoteHandle, context).execute( AV9CliCod, AV22EmpCod, (short)(GXutil.year( AV10LiqPeriodo)), AV18LiqNro, AV18LiqNro, AV19LegNumero, AV28ConCodigo, AV33DAplIIGG, AV17LiqLegConSaldo, AV32LiqLegCuota, AV10LiqPeriodo, true, AV41LiqLegEsPrrGan, AV34ProcesoLiquidacion, GXv_decimal5) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = altacuentaliqlegpornovedadbis.this.AV36LiqDCalculado;
      this.aP13[0] = altacuentaliqlegpornovedadbis.this.AV37error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV37error = "" ;
      AV44Pgmname = "" ;
      AV15totalLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_boolean2 = new boolean[1] ;
      GXv_int3 = new byte[1] ;
      AV13enCuotasLiqDImpCalcu = DecimalUtil.ZERO ;
      AV12minimoParaProrrateoGanancias = DecimalUtil.ZERO ;
      AV14LiqDImpCalcu = DecimalUtil.ZERO ;
      AV17LiqLegConSaldo = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      AV32LiqLegCuota = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV44Pgmname = "AltaCuentaLiqLegPorNovedadBis" ;
      /* GeneXus formulas. */
      AV44Pgmname = "AltaCuentaLiqLegPorNovedadBis" ;
      Gx_err = (short)(0) ;
   }

   private byte AV36LiqDCalculado ;
   private byte AV35bonoLiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV22EmpCod ;
   private short AV33DAplIIGG ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV18LiqNro ;
   private int AV19LegNumero ;
   private java.math.BigDecimal AV23parm_totalLiqDImpCalcu ;
   private java.math.BigDecimal AV16permitidoLiqDImpCalcu ;
   private java.math.BigDecimal AV15totalLiqDImpCalcu ;
   private java.math.BigDecimal AV13enCuotasLiqDImpCalcu ;
   private java.math.BigDecimal AV12minimoParaProrrateoGanancias ;
   private java.math.BigDecimal AV14LiqDImpCalcu ;
   private java.math.BigDecimal AV17LiqLegConSaldo ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV32LiqLegCuota ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV28ConCodigo ;
   private String AV38AplIIGGPrrtear ;
   private String AV34ProcesoLiquidacion ;
   private String AV44Pgmname ;
   private String GXv_char4[] ;
   private java.util.Date AV10LiqPeriodo ;
   private boolean AV30insertandoConceptos ;
   private boolean AV21existe ;
   private boolean GXv_boolean2[] ;
   private boolean returnInSub ;
   private boolean AV41LiqLegEsPrrGan ;
   private String AV37error ;
   private String[] aP13 ;
   private byte[] aP12 ;
}

