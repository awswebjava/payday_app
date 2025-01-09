package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class importe_a_retener extends GXProcedure
{
   public importe_a_retener( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( importe_a_retener.class ), "" );
   }

   public importe_a_retener( int remoteHandle ,
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
      importe_a_retener.this.aP9 = new String[] {""};
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
      importe_a_retener.this.AV8CliCod = aP0;
      importe_a_retener.this.AV9EmpCod = aP1;
      importe_a_retener.this.AV10LiqNro = aP2;
      importe_a_retener.this.AV11LegNumero = aP3;
      importe_a_retener.this.AV12LiqPeriodo = aP4;
      importe_a_retener.this.AV13ProcesoLiquidacion = aP5;
      importe_a_retener.this.aP6 = aP6;
      importe_a_retener.this.aP7 = aP7;
      importe_a_retener.this.aP8 = aP8;
      importe_a_retener.this.aP9 = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV16LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV18auxConCodigo ;
      GXt_char2 = AV18auxConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.retencionbruta_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      importe_a_retener.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char2, GXv_char4) ;
      importe_a_retener.this.GXt_char1 = GXv_char4[0] ;
      AV18auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV19auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV20existe ;
      GXv_int7[0] = AV21auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV18auxConCodigo, AV13ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      importe_a_retener.this.AV19auxLiqDImpCalcu = GXv_decimal5[0] ;
      importe_a_retener.this.AV20existe = GXv_boolean6[0] ;
      importe_a_retener.this.AV21auxLiqDCalculado = GXv_int7[0] ;
      if ( AV21auxLiqDCalculado == 0 )
      {
         AV17error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV18auxConCodigo) ;
         AV15LiqDLog = GXutil.trim( AV17error) ;
         AV16LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV14Importes = AV19auxLiqDImpCalcu ;
      AV15LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") + GXutil.trim( GXutil.str( AV14Importes, 14, 2)) + httpContext.getMessage( " de concepto \"Cálculo retención ganancias\"", "") ;
      GXt_char2 = AV18auxConCodigo ;
      GXt_char1 = AV18auxConCodigo ;
      GXv_char4[0] = GXt_char1 ;
      new web.pagosacuenta_codigoparam(remoteHandle, context).execute( GXv_char4) ;
      importe_a_retener.this.GXt_char1 = GXv_char4[0] ;
      GXv_char3[0] = GXt_char2 ;
      new web.getparametro(remoteHandle, context).execute( AV8CliCod, GXt_char1, GXv_char3) ;
      importe_a_retener.this.GXt_char2 = GXv_char3[0] ;
      AV18auxConCodigo = GXt_char2 ;
      GXv_decimal5[0] = AV19auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV20existe ;
      GXv_int7[0] = AV21auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV18auxConCodigo, AV13ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      importe_a_retener.this.AV19auxLiqDImpCalcu = GXv_decimal5[0] ;
      importe_a_retener.this.AV20existe = GXv_boolean6[0] ;
      importe_a_retener.this.AV21auxLiqDCalculado = GXv_int7[0] ;
      if ( AV21auxLiqDCalculado == 0 )
      {
         AV17error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV18auxConCodigo) ;
         AV15LiqDLog = GXutil.trim( AV17error) ;
         AV16LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV19auxLiqDImpCalcu)==0) )
      {
         AV14Importes = AV14Importes.subtract(AV19auxLiqDImpCalcu) ;
         AV15LiqDLog += httpContext.getMessage( ". Resta ", "") + GXutil.trim( GXutil.str( AV19auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de concepto \"Pagos a cuenta\"", "") ;
      }
      else
      {
         AV15LiqDLog += httpContext.getMessage( ". No existe concepto \"Pagos a cuenta\" en liquidación actual para restar.", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = importe_a_retener.this.AV14Importes;
      this.aP7[0] = importe_a_retener.this.AV15LiqDLog;
      this.aP8[0] = importe_a_retener.this.AV16LiqDCalculado;
      this.aP9[0] = importe_a_retener.this.AV17error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Importes = DecimalUtil.ZERO ;
      AV15LiqDLog = "" ;
      AV17error = "" ;
      AV18auxConCodigo = "" ;
      AV19auxLiqDImpCalcu = DecimalUtil.ZERO ;
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

   private byte AV16LiqDCalculado ;
   private byte AV21auxLiqDCalculado ;
   private byte GXv_int7[] ;
   private short AV9EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV11LegNumero ;
   private java.math.BigDecimal AV14Importes ;
   private java.math.BigDecimal AV19auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private String AV13ProcesoLiquidacion ;
   private String AV18auxConCodigo ;
   private String GXt_char2 ;
   private String GXt_char1 ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV20existe ;
   private boolean returnInSub ;
   private boolean GXv_boolean6[] ;
   private String AV15LiqDLog ;
   private String AV17error ;
   private String[] aP9 ;
   private java.math.BigDecimal[] aP6 ;
   private String[] aP7 ;
   private byte[] aP8 ;
}

