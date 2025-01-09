package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class devolucion_ganancias extends GXProcedure
{
   public devolucion_ganancias( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( devolucion_ganancias.class ), "" );
   }

   public devolucion_ganancias( int remoteHandle ,
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
      devolucion_ganancias.this.aP8 = new String[] {""};
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
      devolucion_ganancias.this.AV10CliCod = aP0;
      devolucion_ganancias.this.AV11EmpCod = aP1;
      devolucion_ganancias.this.AV12LiqNro = aP2;
      devolucion_ganancias.this.AV13LegNumero = aP3;
      devolucion_ganancias.this.AV14ProcesoLiquidacion = aP4;
      devolucion_ganancias.this.aP5 = aP5;
      devolucion_ganancias.this.aP6 = aP6;
      devolucion_ganancias.this.aP7 = aP7;
      devolucion_ganancias.this.aP8 = aP8;
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
      new web.retencionganancias_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      devolucion_ganancias.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV10CliCod, GXt_char2, GXv_char4) ;
      devolucion_ganancias.this.GXt_char1 = GXv_char4[0] ;
      AV9auxConCodigo = GXt_char1 ;
      GXv_decimal5[0] = AV15auxLiqDImpCalcu ;
      GXv_boolean6[0] = AV16existe ;
      GXv_int7[0] = AV17auxLiqDCalculado ;
      new web.getliqdimpcalcu(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV13LegNumero, AV9auxConCodigo, AV14ProcesoLiquidacion, false, GXv_decimal5, GXv_boolean6, GXv_int7) ;
      devolucion_ganancias.this.AV15auxLiqDImpCalcu = GXv_decimal5[0] ;
      devolucion_ganancias.this.AV16existe = GXv_boolean6[0] ;
      devolucion_ganancias.this.AV17auxLiqDCalculado = GXv_int7[0] ;
      if ( AV17auxLiqDCalculado == 0 )
      {
         AV20error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( AV9auxConCodigo) ;
         AV19LiqDLog = GXutil.trim( AV20error) ;
         AV8LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV15auxLiqDImpCalcu.doubleValue() < 0 )
      {
         AV18Importes = AV15auxLiqDImpCalcu ;
         AV19LiqDLog = httpContext.getMessage( "Se inicializa con valor negativo ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) + httpContext.getMessage( " obtenido del concepto de retención ganancias", "") ;
      }
      else
      {
         AV19LiqDLog = httpContext.getMessage( "Se inicializa en cero por tener el concepto de retención ganancias un valor positivo", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = devolucion_ganancias.this.AV18Importes;
      this.aP6[0] = devolucion_ganancias.this.AV19LiqDLog;
      this.aP7[0] = devolucion_ganancias.this.AV8LiqDCalculado;
      this.aP8[0] = devolucion_ganancias.this.AV20error;
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
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      GXv_char3 = new String[1] ;
      GXv_char4 = new String[1] ;
      AV15auxLiqDImpCalcu = DecimalUtil.ZERO ;
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
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String GXv_char3[] ;
   private String GXv_char4[] ;
   private boolean AV16existe ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private String AV19LiqDLog ;
   private String AV20error ;
   private String[] aP8 ;
   private java.math.BigDecimal[] aP5 ;
   private String[] aP6 ;
   private byte[] aP7 ;
}

