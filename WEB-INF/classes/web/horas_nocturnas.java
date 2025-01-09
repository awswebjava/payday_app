package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horas_nocturnas extends GXProcedure
{
   public horas_nocturnas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horas_nocturnas.class ), "" );
   }

   public horas_nocturnas( int remoteHandle ,
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
                             java.math.BigDecimal[] aP5 )
   {
      horas_nocturnas.this.aP6 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        java.math.BigDecimal[] aP5 ,
                        String[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             java.math.BigDecimal[] aP5 ,
                             String[] aP6 )
   {
      horas_nocturnas.this.AV10CliCod = aP0;
      horas_nocturnas.this.AV11EmpCod = aP1;
      horas_nocturnas.this.AV19LiqNro = aP2;
      horas_nocturnas.this.AV12LegNumero = aP3;
      horas_nocturnas.this.AV13LiqPeriodo = aP4;
      horas_nocturnas.this.aP5 = aP5;
      horas_nocturnas.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_char1[0] = "" ;
      GXv_decimal2[0] = AV9Importes ;
      new web.obtbasicovalorhora(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV19LiqNro, AV12LegNumero, AV13LiqPeriodo, httpContext.getMessage( "TOTAL", ""), GXv_char1, GXv_decimal2) ;
      horas_nocturnas.this.AV9Importes = GXv_decimal2[0] ;
      AV14LiqDLog = httpContext.getMessage( "Se inicializa con valor hora ", "") + GXutil.trim( GXutil.str( AV9Importes, 14, 2)) ;
      GXt_int3 = AV15PaiCod ;
      GXv_int4[0] = GXt_int3 ;
      new web.clientegetpais(remoteHandle, context).execute( AV10CliCod, GXv_int4) ;
      horas_nocturnas.this.GXt_int3 = GXv_int4[0] ;
      AV15PaiCod = GXt_int3 ;
      AV16palabra = "nocturno" ;
      GXv_decimal2[0] = AV17porUnaje ;
      GXv_char1[0] = AV18recargoLiqDLog ;
      GXv_char5[0] = "" ;
      GXv_char6[0] = AV20extraError ;
      new web.extra(remoteHandle, context).execute( AV10CliCod, AV11EmpCod, AV12LegNumero, AV15PaiCod, AV16palabra, httpContext.getMessage( "habil", ""), "", httpContext.getMessage( "recargo", ""), GXv_decimal2, GXv_char1, GXv_char5, GXv_char6) ;
      horas_nocturnas.this.AV17porUnaje = GXv_decimal2[0] ;
      horas_nocturnas.this.AV18recargoLiqDLog = GXv_char1[0] ;
      horas_nocturnas.this.AV20extraError = GXv_char6[0] ;
      if ( ! (GXutil.strcmp("", AV20extraError)==0) )
      {
         AV21error = AV20extraError ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV17porUnaje = AV17porUnaje.subtract(DecimalUtil.doubleToDec(1)) ;
      AV9Importes = AV9Importes.multiply(AV17porUnaje) ;
      AV14LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV17porUnaje, 6, 4)) ;
      AV14LiqDLog += GXutil.trim( AV18recargoLiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP5[0] = horas_nocturnas.this.AV9Importes;
      this.aP6[0] = horas_nocturnas.this.AV14LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV9Importes = DecimalUtil.ZERO ;
      AV14LiqDLog = "" ;
      GXv_int4 = new short[1] ;
      AV16palabra = "" ;
      AV17porUnaje = DecimalUtil.ZERO ;
      GXv_decimal2 = new java.math.BigDecimal[1] ;
      AV18recargoLiqDLog = "" ;
      GXv_char1 = new String[1] ;
      GXv_char5 = new String[1] ;
      AV20extraError = "" ;
      GXv_char6 = new String[1] ;
      AV21error = "" ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV11EmpCod ;
   private short AV15PaiCod ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int AV19LiqNro ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV9Importes ;
   private java.math.BigDecimal AV17porUnaje ;
   private java.math.BigDecimal GXv_decimal2[] ;
   private String AV16palabra ;
   private String GXv_char1[] ;
   private String GXv_char5[] ;
   private String GXv_char6[] ;
   private java.util.Date AV13LiqPeriodo ;
   private boolean returnInSub ;
   private String AV14LiqDLog ;
   private String AV18recargoLiqDLog ;
   private String AV20extraError ;
   private String AV21error ;
   private String[] aP6 ;
   private java.math.BigDecimal[] aP5 ;
}

