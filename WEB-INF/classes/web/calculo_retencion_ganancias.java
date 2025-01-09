package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculo_retencion_ganancias extends GXProcedure
{
   public calculo_retencion_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculo_retencion_ganancias.class ), "" );
   }

   public calculo_retencion_ganancias( int remoteHandle ,
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
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 )
   {
      calculo_retencion_ganancias.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        java.math.BigDecimal[] aP7 ,
                        String[] aP8 ,
                        byte[] aP9 ,
                        String[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      calculo_retencion_ganancias.this.AV10CliCod = aP0;
      calculo_retencion_ganancias.this.AV11EmpCod = aP1;
      calculo_retencion_ganancias.this.AV12LiqNro = aP2;
      calculo_retencion_ganancias.this.AV28LiqRelNro = aP3;
      calculo_retencion_ganancias.this.AV13LegNumero = aP4;
      calculo_retencion_ganancias.this.AV21LiqPeriodo = aP5;
      calculo_retencion_ganancias.this.AV14ProcesoLiquidacion = aP6;
      calculo_retencion_ganancias.this.aP7 = aP7;
      calculo_retencion_ganancias.this.aP8 = aP8;
      calculo_retencion_ganancias.this.aP9 = aP9;
      calculo_retencion_ganancias.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV9auxConCodigo ;
      GXt_char2 = AV9auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.gananciasformulaafip_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      calculo_retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      calculo_retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      AV9auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      calculo_retencion_ganancias.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      calculo_retencion_ganancias.this.AV16existe = GXv_boolean6[0] ;
      calculo_retencion_ganancias.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      /* Execute user subroutine: 'EVALUAR RESPUESTA' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV18Importes = AV15auxLiqDImpCalcu ;
      AV19LiqDLog = httpContext.getMessage( "Se inicializa con valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de concepto \"Ganancias fórmula AFIP\"", "") ;
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculo_retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculo_retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      AV26Palabra = "liquidacionesAnteriores" ;
      GXv_date8[0] = AV24desdeFecha ;
      GXv_date9[0] = AV25hastaFecha ;
      GXv_boolean6[0] = false ;
      new web.calcparpergetdesdehasta(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV21LiqPeriodo, 0, AV26Palabra, GXv_date8, GXv_date9, GXv_boolean6) ;
      calculo_retencion_ganancias.this.AV24desdeFecha = GXv_date8[0] ;
      calculo_retencion_ganancias.this.AV25hastaFecha = GXv_date9[0] ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      new web.getliqdimpcalcu_liqantopti(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV24desdeFecha, AV25hastaFecha, AV9auxConCodigo, GXv_decimal5) ;
      calculo_retencion_ganancias.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      /* Execute user subroutine: 'EVALUAR RESPUESTA' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15auxLiqDImpCalcu)==0) )
      {
         AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
         AV19LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de concepto \"Retención ganancias\" de liquidaciones anteriores del año", "") ;
         AV29restaImportes = AV29restaImportes.add(AV15auxLiqDImpCalcu) ;
      }
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.adelantoretencionganancias_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculo_retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculo_retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      new web.getliqdimpcalcu_liqantopti(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV24desdeFecha, AV25hastaFecha, AV9auxConCodigo, GXv_decimal5) ;
      calculo_retencion_ganancias.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      /* Execute user subroutine: 'EVALUAR RESPUESTA' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15auxLiqDImpCalcu)==0) )
      {
         AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
         AV29restaImportes = AV29restaImportes.add(AV15auxLiqDImpCalcu) ;
         AV19LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de concepto \"Adelanto de retención ganancias\" de liquidaciones anteriores del año", "") ;
      }
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.otroempretgan_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      calculo_retencion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      calculo_retencion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      new web.getliqdimpcalcu_liqantopti(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV24desdeFecha, AV25hastaFecha, AV9auxConCodigo, GXv_decimal5) ;
      calculo_retencion_ganancias.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      /* Execute user subroutine: 'EVALUAR RESPUESTA' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15auxLiqDImpCalcu)==0) )
      {
         AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
         AV29restaImportes = AV29restaImportes.add(AV15auxLiqDImpCalcu) ;
         AV19LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de concepto \"retención de ganancias de otros empleos\" de liquidaciones anteriores del año", "") ;
      }
      GXv_char4[0] = AV27pagoACuentaPalabra ;
      new web.codigoopeformula(remoteHandle, context).execute( AV10CliCod, "[pagos_a_cuenta_anteriores]", false, false, GXv_char4) ;
      calculo_retencion_ganancias.this.AV27pagoACuentaPalabra = GXv_char4[0] ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getpagosacuentaactualizado(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV28LiqRelNro, AV13LegNumero, AV21LiqPeriodo, GXv_decimal5, GXv_int7) ;
      calculo_retencion_ganancias.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      calculo_retencion_ganancias.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Error al calcular ", "") + GXutil.trim( AV27pagoACuentaPalabra) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15auxLiqDImpCalcu)==0) )
      {
         AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
         AV29restaImportes = AV29restaImportes.add(AV15auxLiqDImpCalcu) ;
         AV19LiqDLog += httpContext.getMessage( "Se resta el valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de cálculo \"", "") + GXutil.trim( AV27pagoACuentaPalabra) + "\"" ;
      }
      if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV29restaImportes)==0) )
      {
         AV19LiqDLog += httpContext.getMessage( ". No hay valores de liquidaciones anteriores para restar", "") ;
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'EVALUAR RESPUESTA' Routine */
      returnInSub = false ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         if (true) return;
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = calculo_retencion_ganancias.this.AV18Importes;
      this.aP8[0] = calculo_retencion_ganancias.this.AV19LiqDLog;
      this.aP9[0] = calculo_retencion_ganancias.this.AV8LiqDCalculado;
      this.aP10[0] = calculo_retencion_ganancias.this.AV20error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18Importes = DecimalUtil.ZERO ;
      AV19LiqDLog = "" ;
      AV20error = "" ;
      AV9auxConCodigo = "" ;
      AV15auxLiqDImpCalcu = DecimalUtil.ZERO ;
      AV26Palabra = "" ;
      AV24desdeFecha = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      AV25hastaFecha = GXutil.nullDate() ;
      GXv_date9 = new java.util.Date[1] ;
      GXv_boolean6 = new boolean[1] ;
      AV29restaImportes = DecimalUtil.ZERO ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char3 = new String[1] ;
      AV27pagoACuentaPalabra = "" ;
      GXv_char4 = new String[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_int7 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV17auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV11EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV28LiqRelNro ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV15auxLiqDImpCalcu ;
   private java.math.BigDecimal AV29restaImportes ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV14ProcesoLiquidacion ;
   private String AV9auxConCodigo ;
   private String AV26Palabra ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char3[] ;
   private String AV27pagoACuentaPalabra ;
   private String GXv_char4[] ;
   private java.util.Date AV21LiqPeriodo ;
   private java.util.Date AV24desdeFecha ;
   private java.util.Date GXv_date8[] ;
   private java.util.Date AV25hastaFecha ;
   private java.util.Date GXv_date9[] ;
   private boolean AV16existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV19LiqDLog ;
   private String AV20error ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private byte[] aP9 ;
}

