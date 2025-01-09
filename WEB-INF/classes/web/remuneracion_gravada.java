package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class remuneracion_gravada extends GXProcedure
{
   public remuneracion_gravada( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( remuneracion_gravada.class ), "" );
   }

   public remuneracion_gravada( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             byte[] aP7 )
   {
      remuneracion_gravada.this.aP8 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
      return aP8[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 ,
                        byte[] aP7 ,
                        String[] aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 ,
                             byte[] aP7 ,
                             String[] aP8 )
   {
      remuneracion_gravada.this.AV10CliCod = aP0;
      remuneracion_gravada.this.AV11EmpCod = aP1;
      remuneracion_gravada.this.AV12LiqNro = aP2;
      remuneracion_gravada.this.AV13LegNumero = aP3;
      remuneracion_gravada.this.AV14ProcesoLiquidacion = aP4;
      remuneracion_gravada.this.aP5 = aP5;
      remuneracion_gravada.this.aP6 = aP6;
      remuneracion_gravada.this.aP7 = aP7;
      remuneracion_gravada.this.aP8 = aP8;
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
      new web.concepto_sueldobrutosinsac_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      remuneracion_gravada.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      remuneracion_gravada.this.GXt_char1 = GXv_char4[0] ;
      AV9auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      remuneracion_gravada.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      remuneracion_gravada.this.AV16existe = GXv_boolean6[0] ;
      remuneracion_gravada.this.AV17auxLiqDCalculado = GXv_int7[0] ;
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
      AV19LiqDLog = httpContext.getMessage( "Se inicializa con valor ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " de concepto \"Sueldo bruto ganancias\"", "") ;
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_anticipodesac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      remuneracion_gravada.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      remuneracion_gravada.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      remuneracion_gravada.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      remuneracion_gravada.this.AV16existe = GXv_boolean6[0] ;
      remuneracion_gravada.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV18Importes = AV18Importes.add(AV15auxLiqDImpCalcu) ;
      AV19LiqDLog += httpContext.getMessage( "Se suma el valor ", "") + GXutil.trim( GXutil.str( AV15auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto \"Anticipo de sac\"", "") ;
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_descuentosleymasdescsobreanticiposac_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      remuneracion_gravada.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      remuneracion_gravada.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      remuneracion_gravada.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      remuneracion_gravada.this.AV16existe = GXv_boolean6[0] ;
      remuneracion_gravada.this.AV17auxLiqDCalculado = GXv_int7[0] ;
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
      AV19LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV15auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto \"Descuentos de ley sobre impuesto gravado contemplando anticipo de sac\"", "") ;
      GXt_char2 = AV9auxConCodigo ;
      GXt_char1 = AV9auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.concepto_sacexento_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      remuneracion_gravada.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char1, GXv_char3) ;
      remuneracion_gravada.this.GXt_char2 = GXv_char3[0] ;
      AV9auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      remuneracion_gravada.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      remuneracion_gravada.this.AV16existe = GXv_boolean6[0] ;
      remuneracion_gravada.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV15auxLiqDImpCalcu)==0) )
      {
         AV18Importes = AV18Importes.subtract(AV15auxLiqDImpCalcu) ;
         AV19LiqDLog += httpContext.getMessage( ". Se resta ", "") + GXutil.trim( GXutil.str( AV15auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto \"SAC Exento\"", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = remuneracion_gravada.this.AV18Importes;
      this.aP6[0] = remuneracion_gravada.this.AV19LiqDLog;
      this.aP7[0] = remuneracion_gravada.this.AV8LiqDCalculado;
      this.aP8[0] = remuneracion_gravada.this.AV20error;
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
   private boolean AV16existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV19LiqDLog ;
   private String AV20error ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private byte[] aP7 ;
}

