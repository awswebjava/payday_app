package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class gnsi extends GXProcedure
{
   public gnsi( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( gnsi.class ), "" );
   }

   public gnsi( int remoteHandle ,
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
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             byte[] aP8 )
   {
      gnsi.this.aP9 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
      return aP9[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        java.math.BigDecimal[] aP6 ,
                        String[] aP7 ,
                        byte[] aP8 ,
                        String[] aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             java.math.BigDecimal[] aP6 ,
                             String[] aP7 ,
                             byte[] aP8 ,
                             String[] aP9 )
   {
      gnsi.this.AV10CliCod = aP0;
      gnsi.this.AV11EmpCod = aP1;
      gnsi.this.AV12LiqNro = aP2;
      gnsi.this.AV13LegNumero = aP3;
      gnsi.this.AV21LiqPeriodo = aP4;
      gnsi.this.AV14ProcesoLiquidacion = aP5;
      gnsi.this.aP6 = aP6;
      gnsi.this.aP7 = aP7;
      gnsi.this.aP8 = aP8;
      gnsi.this.aP9 = aP9;
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
      new web.ganancianeta_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      gnsi.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      gnsi.this.GXt_char1 = GXv_char4[0] ;
      AV9auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      gnsi.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      gnsi.this.AV16existe = GXv_boolean6[0] ;
      gnsi.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV18Importes = AV15auxLiqDImpCalcu ;
      AV19LiqDLog = httpContext.getMessage( "Se inicializa con valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de concepto \"Ganancia neta\"", "") ;
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.dedart30_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      gnsi.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      gnsi.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      gnsi.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      gnsi.this.AV16existe = GXv_boolean6[0] ;
      gnsi.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
      AV19LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV15auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto \"Deducciones art. 30\"", "") ;
      GXv_int8[0] = AV22nro_cuota ;
      new web.mesesganancias(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV21LiqPeriodo, GXv_int8) ;
      gnsi.this.AV22nro_cuota = GXv_int8[0] ;
      GXv_int8[0] = AV23cant_cuotas ;
      new web.mesesanio(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV13LegNumero, AV21LiqPeriodo, GXv_int8) ;
      gnsi.this.AV23cant_cuotas = GXv_int8[0] ;
      if ( AV22nro_cuota == AV23cant_cuotas )
      {
         GXt_char2 = AV9auxConCodigo ;
         GXt_char1 = AV9auxConCodigo ;
         GXv_char4[0] = GXt_char1 ;
         new web.concepto_dedgeneralesanualesparam(remoteHandle, context).execute( GXv_char4) ;
         gnsi.this.GXt_char1 = GXv_char4[0] ;
         GXv_char3[0] = GXt_char2 ;
         new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
         gnsi.this.GXt_char2 = GXv_char3[0] ;
         AV9auxConCodigo = GXt_char2 ;
         GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
         GXv_boolean6[0] = AV16existe ;
         GXv_int7[0] = AV17auxLiqDCalculado ;
         new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
         gnsi.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
         gnsi.this.AV16existe = GXv_boolean6[0] ;
         gnsi.this.AV17auxLiqDCalculado = GXv_int7[0] ;
         if ( AV17auxLiqDCalculado == 0 )
         {
            AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
            AV19LiqDLog = GXutil.trim( AV20error) ;
            AV8LiqDCalculado = (byte)(0) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
         AV19LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV15auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto \"Deducciones generales anuales\"", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = gnsi.this.AV18Importes;
      this.aP7[0] = gnsi.this.AV19LiqDLog;
      this.aP8[0] = gnsi.this.AV8LiqDCalculado;
      this.aP9[0] = gnsi.this.AV20error;
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
      GXv_int8 = new short[1] ;
      GXt_char2 = "" ;
      GXt_char1 = "" ;
      GXv_char4 = new String[1] ;
      GXv_char3 = new String[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_boolean6 = new boolean[1] ;
      GXv_int7 = new byte[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV17auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV11EmpCod ;
   private short AV22nro_cuota ;
   private short AV23cant_cuotas ;
   private short GXv_int8[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV15auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV14ProcesoLiquidacion ;
   private String AV9auxConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV21LiqPeriodo ;
   private boolean AV16existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV19LiqDLog ;
   private String AV20error ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP7 ;
   private byte[] aP8 ;
}

