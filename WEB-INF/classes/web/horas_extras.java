package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class horas_extras extends GXProcedure
{
   public horas_extras( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( horas_extras.class ), "" );
   }

   public horas_extras( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           short aP4 ,
                                           int aP5 ,
                                           java.util.Date aP6 ,
                                           java.math.BigDecimal aP7 ,
                                           String aP8 ,
                                           String aP9 ,
                                           boolean aP10 ,
                                           boolean aP11 ,
                                           java.math.BigDecimal[] aP12 ,
                                           String[] aP13 ,
                                           String[] aP14 ,
                                           byte[] aP15 )
   {
      horas_extras.this.aP16 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        short aP4 ,
                        int aP5 ,
                        java.util.Date aP6 ,
                        java.math.BigDecimal aP7 ,
                        String aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 ,
                        byte[] aP15 ,
                        java.math.BigDecimal[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             short aP4 ,
                             int aP5 ,
                             java.util.Date aP6 ,
                             java.math.BigDecimal aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             byte[] aP15 ,
                             java.math.BigDecimal[] aP16 )
   {
      horas_extras.this.AV8CliCod = aP0;
      horas_extras.this.AV9EmpCod = aP1;
      horas_extras.this.AV12LiqNro = aP2;
      horas_extras.this.AV35LiqRelNro = aP3;
      horas_extras.this.AV13PaiCod = aP4;
      horas_extras.this.AV10LegNumero = aP5;
      horas_extras.this.AV14LiqPeriodo = aP6;
      horas_extras.this.AV15LiqDCanti = aP7;
      horas_extras.this.AV16ProcesoLiquidacion = aP8;
      horas_extras.this.AV17TLiqCod = aP9;
      horas_extras.this.AV27recargoNocturno = aP10;
      horas_extras.this.AV30extraordinaria = aP11;
      horas_extras.this.aP12 = aP12;
      horas_extras.this.aP13 = aP13;
      horas_extras.this.aP14 = aP14;
      horas_extras.this.aP15 = aP15;
      horas_extras.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV20LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV11LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, GXv_int1) ;
      horas_extras.this.AV11LegClase = GXv_int1[0] ;
      GXv_char2[0] = AV37tipo_tarifa ;
      new web.gettipodetarifa(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV12LiqNro, AV10LegNumero, (short)(0), "", "", GXv_char2) ;
      horas_extras.this.AV37tipo_tarifa = GXv_char2[0] ;
      GXv_decimal3[0] = AV18Importes ;
      GXv_int1[0] = AV19auxLiqDCalculado ;
      GXv_char2[0] = AV21auxError ;
      GXv_char4[0] = AV22auxLiqDLog ;
      new web.hora_normal4(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV12LiqNro, AV35LiqRelNro, AV13PaiCod, AV10LegNumero, AV14LiqPeriodo, AV11LegClase, AV37tipo_tarifa, AV15LiqDCanti, AV16ProcesoLiquidacion, AV48Pgmname, AV17TLiqCod, GXv_decimal3, GXv_int1, GXv_char2, GXv_char4) ;
      horas_extras.this.AV18Importes = GXv_decimal3[0] ;
      horas_extras.this.AV19auxLiqDCalculado = GXv_int1[0] ;
      horas_extras.this.AV21auxError = GXv_char2[0] ;
      horas_extras.this.AV22auxLiqDLog = GXv_char4[0] ;
      if ( AV19auxLiqDCalculado == 0 )
      {
         AV20LiqDCalculado = (byte)(0) ;
         AV23error = GXutil.trim( AV21auxError) ;
         AV24LiqDLog = GXutil.trim( AV23error) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV40horaNormalImportes = AV18Importes ;
      GXv_char4[0] = AV34ImportesTooltip ;
      new web.armatooltip(remoteHandle, context).execute( AV8CliCod, AV18Importes, AV22auxLiqDLog, false, GXv_char4) ;
      horas_extras.this.AV34ImportesTooltip = GXv_char4[0] ;
      AV24LiqDLog = httpContext.getMessage( "Se inicializa con valor de hora normal ", "") + GXutil.trim( AV34ImportesTooltip) ;
      AV25palabra = "diurno" ;
      if ( AV30extraordinaria )
      {
         AV29palabra2 = httpContext.getMessage( "domingo", "") ;
      }
      else
      {
         AV29palabra2 = httpContext.getMessage( "habil", "") ;
      }
      AV32que = httpContext.getMessage( "extra", "") ;
      AV33deQue = httpContext.getMessage( " de hora extra diurna ", "") ;
      /* Execute user subroutine: 'GET EXTRA' */
      S111 ();
      if ( returnInSub )
      {
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      if ( AV27recargoNocturno )
      {
         AV25palabra = "nocturno" ;
         AV32que = httpContext.getMessage( "recargo", "") ;
         AV33deQue = httpContext.getMessage( " de recargo nocturno ", "") ;
         /* Execute user subroutine: 'GET EXTRA' */
         S111 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
      }
      AV18Importes = AV18Importes.multiply(AV15LiqDCanti) ;
      AV24LiqDLog += httpContext.getMessage( ". Se multiplica por cantidad ingresada ", "") + GXutil.trim( GXutil.str( AV15LiqDCanti, 14, 2)) ;
      cleanup();
   }

   public void S111( )
   {
      /* 'GET EXTRA' Routine */
      returnInSub = false ;
      GXv_decimal3[0] = AV26porUnaje ;
      GXv_char4[0] = "" ;
      GXv_char2[0] = AV31definidoPalabra ;
      GXv_char5[0] = AV45extraError ;
      new web.extra(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LegNumero, AV13PaiCod, AV25palabra, AV29palabra2, "", AV32que, GXv_decimal3, GXv_char4, GXv_char2, GXv_char5) ;
      horas_extras.this.AV26porUnaje = GXv_decimal3[0] ;
      horas_extras.this.AV31definidoPalabra = GXv_char2[0] ;
      horas_extras.this.AV45extraError = GXv_char5[0] ;
      if ( ! (GXutil.strcmp("", AV45extraError)==0) )
      {
         AV23error = AV45extraError ;
         AV20LiqDCalculado = (byte)(0) ;
         AV24LiqDLog = GXutil.trim( AV23error) ;
         returnInSub = true;
         if (true) return;
      }
      AV41auxPorUnaje = AV26porUnaje.subtract(DecimalUtil.doubleToDec(1)) ;
      AV39recargoImportes = AV40horaNormalImportes.multiply(AV41auxPorUnaje) ;
      AV18Importes = AV18Importes.add(AV39recargoImportes) ;
      AV42porcentaje = AV41auxPorUnaje.multiply(DecimalUtil.doubleToDec(100)) ;
      AV24LiqDLog += httpContext.getMessage( ". Se suma el ", "") + GXutil.str( AV42porcentaje, 6, 2) + "% (" + GXutil.trim( GXutil.str( AV39recargoImportes, 14, 2)) + AV33deQue ;
      if ( AV30extraordinaria )
      {
         AV24LiqDLog += httpContext.getMessage( "para los días especiales ", "") ;
      }
      AV24LiqDLog += httpContext.getMessage( "definido por ", "") + GXutil.trim( AV31definidoPalabra) ;
   }

   protected void cleanup( )
   {
      this.aP12[0] = horas_extras.this.AV18Importes;
      this.aP13[0] = horas_extras.this.AV23error;
      this.aP14[0] = horas_extras.this.AV24LiqDLog;
      this.aP15[0] = horas_extras.this.AV20LiqDCalculado;
      this.aP16[0] = horas_extras.this.AV26porUnaje;
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
      AV23error = "" ;
      AV24LiqDLog = "" ;
      AV26porUnaje = DecimalUtil.ZERO ;
      AV37tipo_tarifa = "" ;
      AV48Pgmname = "" ;
      GXv_int1 = new byte[1] ;
      AV21auxError = "" ;
      AV22auxLiqDLog = "" ;
      AV40horaNormalImportes = DecimalUtil.ZERO ;
      AV34ImportesTooltip = "" ;
      AV25palabra = "" ;
      AV29palabra2 = "" ;
      AV32que = "" ;
      AV33deQue = "" ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      AV31definidoPalabra = "" ;
      GXv_char2 = new String[1] ;
      AV45extraError = "" ;
      GXv_char5 = new String[1] ;
      AV41auxPorUnaje = DecimalUtil.ZERO ;
      AV39recargoImportes = DecimalUtil.ZERO ;
      AV42porcentaje = DecimalUtil.ZERO ;
      AV48Pgmname = "horas_extras" ;
      /* GeneXus formulas. */
      AV48Pgmname = "horas_extras" ;
      Gx_err = (short)(0) ;
   }

   private byte AV20LiqDCalculado ;
   private byte AV11LegClase ;
   private byte AV19auxLiqDCalculado ;
   private byte GXv_int1[] ;
   private short AV9EmpCod ;
   private short AV13PaiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV12LiqNro ;
   private int AV35LiqRelNro ;
   private int AV10LegNumero ;
   private java.math.BigDecimal AV15LiqDCanti ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV26porUnaje ;
   private java.math.BigDecimal AV40horaNormalImportes ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal AV41auxPorUnaje ;
   private java.math.BigDecimal AV39recargoImportes ;
   private java.math.BigDecimal AV42porcentaje ;
   private String AV16ProcesoLiquidacion ;
   private String AV17TLiqCod ;
   private String AV37tipo_tarifa ;
   private String AV48Pgmname ;
   private String AV25palabra ;
   private String AV29palabra2 ;
   private String AV32que ;
   private String AV33deQue ;
   private String GXv_char4[] ;
   private String AV31definidoPalabra ;
   private String GXv_char2[] ;
   private String GXv_char5[] ;
   private java.util.Date AV14LiqPeriodo ;
   private boolean AV27recargoNocturno ;
   private boolean AV30extraordinaria ;
   private boolean returnInSub ;
   private String AV24LiqDLog ;
   private String AV22auxLiqDLog ;
   private String AV23error ;
   private String AV21auxError ;
   private String AV34ImportesTooltip ;
   private String AV45extraError ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP12 ;
   private String[] aP13 ;
   private String[] aP14 ;
   private byte[] aP15 ;
}

