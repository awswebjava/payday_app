package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcularexento extends GXProcedure
{
   public calcularexento( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcularexento.class ), "" );
   }

   public calcularexento( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              int aP3 ,
                              int aP4 ,
                              java.util.Date aP5 ,
                              String aP6 ,
                              String aP7 ,
                              java.math.BigDecimal aP8 ,
                              short aP9 ,
                              String aP10 ,
                              byte[] aP11 ,
                              String[] aP12 ,
                              String[] aP13 ,
                              java.math.BigDecimal[] aP14 ,
                              java.math.BigDecimal[] aP15 )
   {
      calcularexento.this.aP16 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        String aP7 ,
                        java.math.BigDecimal aP8 ,
                        short aP9 ,
                        String aP10 ,
                        byte[] aP11 ,
                        String[] aP12 ,
                        String[] aP13 ,
                        java.math.BigDecimal[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        boolean[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             String aP7 ,
                             java.math.BigDecimal aP8 ,
                             short aP9 ,
                             String aP10 ,
                             byte[] aP11 ,
                             String[] aP12 ,
                             String[] aP13 ,
                             java.math.BigDecimal[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             boolean[] aP16 )
   {
      calcularexento.this.AV10CliCod = aP0;
      calcularexento.this.AV11EmpCod = aP1;
      calcularexento.this.AV12LiqNro = aP2;
      calcularexento.this.AV40LiqRelNro = aP3;
      calcularexento.this.AV13LegNumero = aP4;
      calcularexento.this.AV14LiqPeriodo = aP5;
      calcularexento.this.AV15ConCodigo = aP6;
      calcularexento.this.AV25idOperando = aP7;
      calcularexento.this.AV17LiqDImpCalcu = aP8;
      calcularexento.this.AV31principalAplIIGG = aP9;
      calcularexento.this.AV34ProcesoLiquidacion = aP10;
      calcularexento.this.aP11 = aP11;
      calcularexento.this.aP12 = aP12;
      calcularexento.this.aP13 = aP13;
      calcularexento.this.aP14 = aP14;
      calcularexento.this.aP15 = aP15;
      calcularexento.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20LiqDCalculado = (byte)(1) ;
      GXv_decimal1[0] = AV18ExentoImportes ;
      GXv_decimal2[0] = AV38totalActualImportes ;
      GXv_char3[0] = AV19exentoError ;
      GXv_int4[0] = AV20LiqDCalculado ;
      GXv_char5[0] = AV22LiqDLog ;
      GXv_boolean6[0] = AV39existe ;
      new web.concepto_exento_v2(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LiqNro, AV40LiqRelNro, AV13LegNumero, AV14LiqPeriodo, AV15ConCodigo, "", AV31principalAplIIGG, AV34ProcesoLiquidacion, true, AV25idOperando, AV17LiqDImpCalcu, GXv_decimal1, GXv_decimal2, GXv_char3, GXv_int4, GXv_char5, GXv_boolean6) ;
      calcularexento.this.AV18ExentoImportes = GXv_decimal1[0] ;
      calcularexento.this.AV38totalActualImportes = GXv_decimal2[0] ;
      calcularexento.this.AV19exentoError = GXv_char3[0] ;
      calcularexento.this.AV20LiqDCalculado = GXv_int4[0] ;
      calcularexento.this.AV22LiqDLog = GXv_char5[0] ;
      calcularexento.this.AV39existe = GXv_boolean6[0] ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&&&existe ", "")+GXutil.trim( GXutil.booltostr( AV39existe))+httpContext.getMessage( " &ExentoImportes ", "")+GXutil.trim( GXutil.str( AV18ExentoImportes, 14, 2))) ;
      if ( ( AV20LiqDCalculado == 0 ) && ( AV39existe ) )
      {
         AV26error = httpContext.getMessage( "No se pudo calcular exento de ", "") + GXutil.trim( AV15ConCodigo) + " (" + GXutil.trim( AV19exentoError) + ")" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "&&error ", "")+AV26error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      else
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "llama new_liquidacion_exencion", "")) ;
         GXv_boolean6[0] = AV33yaExiste ;
         new web.new_liquidacion_exencion(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, (short)(GXutil.year( AV14LiqPeriodo)), AV12LiqNro, AV13LegNumero, AV31principalAplIIGG, AV15ConCodigo, AV18ExentoImportes, GXv_boolean6) ;
         calcularexento.this.AV33yaExiste = GXv_boolean6[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV43Pgmname, httpContext.getMessage( "log ", "")+GXutil.trim( AV22LiqDLog)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP11[0] = calcularexento.this.AV20LiqDCalculado;
      this.aP12[0] = calcularexento.this.AV26error;
      this.aP13[0] = calcularexento.this.AV22LiqDLog;
      this.aP14[0] = calcularexento.this.AV18ExentoImportes;
      this.aP15[0] = calcularexento.this.AV38totalActualImportes;
      this.aP16[0] = calcularexento.this.AV39existe;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV26error = "" ;
      AV22LiqDLog = "" ;
      AV18ExentoImportes = DecimalUtil.ZERO ;
      AV38totalActualImportes = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV19exentoError = "" ;
      GXv_char3 = new String[1] ;
      GXv_int4 = new byte[1] ;
      GXv_char5 = new String[1] ;
      AV43Pgmname = "" ;
      GXv_boolean6 = new boolean[1] ;
      AV43Pgmname = "calcularExento" ;
      /* GeneXus formulas. */
      AV43Pgmname = "calcularExento" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LiqDCalculado ;
   private byte GXv_int4[] ;
   private short AV11EmpCod ;
   private short AV31principalAplIIGG ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV12LiqNro ;
   private int AV40LiqRelNro ;
   private int AV13LegNumero ;
   private java.math.BigDecimal AV17LiqDImpCalcu ;
   private java.math.BigDecimal AV18ExentoImportes ;
   private java.math.BigDecimal AV38totalActualImportes ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV15ConCodigo ;
   private String AV25idOperando ;
   private String AV34ProcesoLiquidacion ;
   private String GXv_char3[] ;
   private String GXv_char5[] ;
   private String AV43Pgmname ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV39existe ;
   private boolean returnInSub ;
   private boolean AV33yaExiste ;
   private boolean GXv_boolean6[] ;
   private String AV22LiqDLog ;
   private String AV26error ;
   private String AV19exentoError ;
   private boolean[] aP16 ;
   private byte[] aP11 ;
   private String[] aP12 ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
}

