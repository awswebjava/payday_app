package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getgantasa extends GXProcedure
{
   public getgantasa( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getgantasa.class ), "" );
   }

   public getgantasa( int remoteHandle ,
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
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.math.BigDecimal aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             byte[] aP14 ,
                             String[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             java.math.BigDecimal[] aP19 ,
                             String[] aP20 )
   {
      getgantasa.this.aP21 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
      return aP21[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        java.util.Date aP6 ,
                        String aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal aP10 ,
                        java.math.BigDecimal aP11 ,
                        String aP12 ,
                        boolean aP13 ,
                        byte[] aP14 ,
                        String[] aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        java.math.BigDecimal[] aP19 ,
                        String[] aP20 ,
                        String[] aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             java.util.Date aP6 ,
                             String aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal aP10 ,
                             java.math.BigDecimal aP11 ,
                             String aP12 ,
                             boolean aP13 ,
                             byte[] aP14 ,
                             String[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             java.math.BigDecimal[] aP19 ,
                             String[] aP20 ,
                             String[] aP21 )
   {
      getgantasa.this.AV16CliCod = aP0;
      getgantasa.this.AV10EmpCod = aP1;
      getgantasa.this.AV17LiqNro = aP2;
      getgantasa.this.AV64LiqRelNro = aP3;
      getgantasa.this.AV11LegNumero = aP4;
      getgantasa.this.AV35ConCodigo = aP5;
      getgantasa.this.AV27fecha = aP6;
      getgantasa.this.AV30ProcesoLiquidacion = aP7;
      getgantasa.this.AV19buscaPalabra = aP8;
      getgantasa.this.AV39sinHorasExtras = aP9;
      getgantasa.this.AV43gnsiF1357 = aP10;
      getgantasa.this.AV44gnsiSinHorasExtrasGravadasF1357 = aP11;
      getgantasa.this.AV45llamador = aP12;
      getgantasa.this.AV47insertandoConceptos = aP13;
      getgantasa.this.aP14 = aP14;
      getgantasa.this.aP15 = aP15;
      getgantasa.this.aP16 = aP16;
      getgantasa.this.aP17 = aP17;
      getgantasa.this.aP18 = aP18;
      getgantasa.this.aP19 = aP19;
      getgantasa.this.aP20 = aP20;
      getgantasa.this.aP21 = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      if ( GXutil.strcmp(AV45llamador, httpContext.getMessage( "F1357", "")) == 0 )
      {
         AV46gnsi = AV43gnsiF1357 ;
      }
      else
      {
         GXv_decimal1[0] = AV13LiqDImpCalcu ;
         GXv_int2[0] = AV53gnsiLiqDCalculado ;
         new web.getgnsiactualizada(remoteHandle, context).execute( AV16CliCod, AV10EmpCod, AV17LiqNro, AV64LiqRelNro, AV11LegNumero, AV27fecha, AV30ProcesoLiquidacion, GXv_decimal1, GXv_int2) ;
         getgantasa.this.AV13LiqDImpCalcu = GXv_decimal1[0] ;
         getgantasa.this.AV53gnsiLiqDCalculado = GXv_int2[0] ;
         if ( AV53gnsiLiqDCalculado == 0 )
         {
            AV15LiqDCalculado = (byte)(0) ;
            GXt_char3 = AV50dependenciasNoResueltasTxt ;
            GXv_char4[0] = GXt_char3 ;
            new web.txtdependencianoresuelta(remoteHandle, context).execute( GXv_char4) ;
            getgantasa.this.GXt_char3 = GXv_char4[0] ;
            AV50dependenciasNoResueltasTxt = GXt_char3 + httpContext.getMessage( "GNSI", "") ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV67Pgmname, AV50dependenciasNoResueltasTxt) ;
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV46gnsi = AV13LiqDImpCalcu ;
      }
      AV24OpeCliId = "[gan_escala]" ;
      GXv_char4[0] = AV23JSON ;
      GXv_char5[0] = AV59auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV16CliCod, AV24OpeCliId, AV27fecha, AV30ProcesoLiquidacion, GXv_char4, GXv_char5) ;
      getgantasa.this.AV23JSON = GXv_char4[0] ;
      getgantasa.this.AV59auxError = GXv_char5[0] ;
      if ( ! (GXutil.strcmp("", AV59auxError)==0) )
      {
         AV15LiqDCalculado = (byte)(0) ;
         AV60error = AV59auxError ;
         AV61LiqDLog = AV60error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8tasas_y_tramos_de_escala.fromJSonString(AV23JSON, null);
      AV8tasas_y_tramos_de_escala.sort(httpContext.getMessage( "hasta", ""));
      GXt_char3 = AV20tasaImportePalabra ;
      GXv_char5[0] = GXt_char3 ;
      new web.palabragantasaimporte(remoteHandle, context).execute( AV16CliCod, GXv_char5) ;
      getgantasa.this.GXt_char3 = GXv_char5[0] ;
      AV20tasaImportePalabra = GXt_char3 ;
      GXt_char3 = AV21tasaMasElPalabra ;
      GXv_char5[0] = GXt_char3 ;
      new web.palabragantasaalicuota(remoteHandle, context).execute( AV16CliCod, GXv_char5) ;
      getgantasa.this.GXt_char3 = GXv_char5[0] ;
      AV21tasaMasElPalabra = GXt_char3 ;
      GXt_char3 = AV22tasaRestoPalabra ;
      GXv_char5[0] = GXt_char3 ;
      new web.palabragantasatopeanterior(remoteHandle, context).execute( AV16CliCod, GXv_char5) ;
      getgantasa.this.GXt_char3 = GXv_char5[0] ;
      AV22tasaRestoPalabra = GXt_char3 ;
      GXv_int6[0] = AV29cantMesesTributados ;
      new web.mesesganancias(remoteHandle, context).execute( AV16CliCod, AV10EmpCod, AV17LiqNro, AV11LegNumero, AV27fecha, GXv_int6) ;
      getgantasa.this.AV29cantMesesTributados = GXv_int6[0] ;
      AV68GXV1 = 1 ;
      while ( AV68GXV1 <= AV8tasas_y_tramos_de_escala.size() )
      {
         AV9tramo = (web.Sdttasas_y_tramos_de_escala_tramo)((web.Sdttasas_y_tramos_de_escala_tramo)AV8tasas_y_tramos_de_escala.elementAt(-1+AV68GXV1));
         AV25tramoHasta = (AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta().divide(DecimalUtil.doubleToDec(12), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV29cantMesesTributados)) ;
         if ( DecimalUtil.compareTo(AV46gnsi, AV25tramoHasta) <= 0 )
         {
            if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV19buscaPalabra)), GXutil.upper( GXutil.trim( AV20tasaImportePalabra))) == 0 )
            {
               AV18importe = AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe() ;
               AV61LiqDLog = httpContext.getMessage( "Escala importe ", "") + GXutil.trim( GXutil.str( AV18importe, 14, 4)) + httpContext.getMessage( " ( Hasta: ", "") + GXutil.trim( GXutil.str( AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Hasta(), 14, 2)) + ")" ;
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV19buscaPalabra)), GXutil.upper( GXutil.trim( AV21tasaMasElPalabra))) == 0 )
            {
               AV18importe = AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel() ;
               AV61LiqDLog = httpContext.getMessage( "Escala Más el: ", "") + GXutil.trim( GXutil.str( AV18importe, 14, 4)) ;
            }
            else if ( GXutil.strcmp(GXutil.upper( GXutil.trim( AV19buscaPalabra)), GXutil.upper( GXutil.trim( AV22tasaRestoPalabra))) == 0 )
            {
               AV18importe = AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto() ;
               AV61LiqDLog = httpContext.getMessage( "Escala Resto: ", "") + GXutil.trim( GXutil.str( AV18importe, 14, 4)) ;
            }
            else
            {
               AV18importe = AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe() ;
               AV52importe2 = AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto() ;
               AV51importe3 = AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel() ;
               AV61LiqDLog = httpContext.getMessage( "Escala Importe: ", "") + GXutil.trim( GXutil.str( AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Importe(), 14, 2)) + httpContext.getMessage( ". Más el: ", "") + GXutil.trim( GXutil.str( AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Masel(), 6, 4)) + httpContext.getMessage( ". Resto: ", "") + GXutil.trim( GXutil.str( AV9tramo.getgxTv_Sdttasas_y_tramos_de_escala_tramo_Resto(), 14, 2)) ;
            }
            AV61LiqDLog += httpContext.getMessage( ". Tramo hasta ", "") + GXutil.trim( GXutil.str( AV25tramoHasta, 14, 2)) ;
            AV61LiqDLog += httpContext.getMessage( ". GNSI: ", "") + GXutil.trim( GXutil.str( AV46gnsi, 14, 2)) ;
            if (true) break;
         }
         AV68GXV1 = (int)(AV68GXV1+1) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP14[0] = getgantasa.this.AV15LiqDCalculado;
      this.aP15[0] = getgantasa.this.AV50dependenciasNoResueltasTxt;
      this.aP16[0] = getgantasa.this.AV18importe;
      this.aP17[0] = getgantasa.this.AV52importe2;
      this.aP18[0] = getgantasa.this.AV51importe3;
      this.aP19[0] = getgantasa.this.AV46gnsi;
      this.aP20[0] = getgantasa.this.AV60error;
      this.aP21[0] = getgantasa.this.AV61LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV50dependenciasNoResueltasTxt = "" ;
      AV18importe = DecimalUtil.ZERO ;
      AV52importe2 = DecimalUtil.ZERO ;
      AV51importe3 = DecimalUtil.ZERO ;
      AV46gnsi = DecimalUtil.ZERO ;
      AV60error = "" ;
      AV61LiqDLog = "" ;
      AV13LiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      GXv_int2 = new byte[1] ;
      AV67Pgmname = "" ;
      AV24OpeCliId = "" ;
      AV23JSON = "" ;
      GXv_char4 = new String[1] ;
      AV59auxError = "" ;
      AV8tasas_y_tramos_de_escala = new GXBaseCollection<web.Sdttasas_y_tramos_de_escala_tramo>(web.Sdttasas_y_tramos_de_escala_tramo.class, "tramo", "PayDay", remoteHandle);
      AV20tasaImportePalabra = "" ;
      AV21tasaMasElPalabra = "" ;
      AV22tasaRestoPalabra = "" ;
      GXt_char3 = "" ;
      GXv_char5 = new String[1] ;
      GXv_int6 = new short[1] ;
      AV9tramo = new web.Sdttasas_y_tramos_de_escala_tramo(remoteHandle, context);
      AV25tramoHasta = DecimalUtil.ZERO ;
      AV67Pgmname = "getGanTasa" ;
      /* GeneXus formulas. */
      AV67Pgmname = "getGanTasa" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV53gnsiLiqDCalculado ;
   private byte GXv_int2[] ;
   private short AV10EmpCod ;
   private short AV29cantMesesTributados ;
   private short GXv_int6[] ;
   private short Gx_err ;
   private int AV16CliCod ;
   private int AV17LiqNro ;
   private int AV64LiqRelNro ;
   private int AV11LegNumero ;
   private int AV68GXV1 ;
   private java.math.BigDecimal AV43gnsiF1357 ;
   private java.math.BigDecimal AV44gnsiSinHorasExtrasGravadasF1357 ;
   private java.math.BigDecimal AV18importe ;
   private java.math.BigDecimal AV52importe2 ;
   private java.math.BigDecimal AV51importe3 ;
   private java.math.BigDecimal AV46gnsi ;
   private java.math.BigDecimal AV13LiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal AV25tramoHasta ;
   private String AV35ConCodigo ;
   private String AV30ProcesoLiquidacion ;
   private String AV19buscaPalabra ;
   private String AV45llamador ;
   private String AV67Pgmname ;
   private String AV24OpeCliId ;
   private String GXv_char4[] ;
   private String AV20tasaImportePalabra ;
   private String AV21tasaMasElPalabra ;
   private String AV22tasaRestoPalabra ;
   private String GXt_char3 ;
   private String GXv_char5[] ;
   private java.util.Date AV27fecha ;
   private boolean AV39sinHorasExtras ;
   private boolean AV47insertandoConceptos ;
   private boolean returnInSub ;
   private String AV61LiqDLog ;
   private String AV50dependenciasNoResueltasTxt ;
   private String AV60error ;
   private String AV23JSON ;
   private String AV59auxError ;
   private String[] aP21 ;
   private byte[] aP14 ;
   private String[] aP15 ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private java.math.BigDecimal[] aP18 ;
   private java.math.BigDecimal[] aP19 ;
   private String[] aP20 ;
   private GXBaseCollection<web.Sdttasas_y_tramos_de_escala_tramo> AV8tasas_y_tramos_de_escala ;
   private web.Sdttasas_y_tramos_de_escala_tramo AV9tramo ;
}

