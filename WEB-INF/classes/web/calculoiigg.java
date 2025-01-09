package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calculoiigg extends GXProcedure
{
   public calculoiigg( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calculoiigg.class ), "" );
   }

   public calculoiigg( int remoteHandle ,
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
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      calculoiigg.this.aP11 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
      return aP11[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        java.math.BigDecimal[] aP8 ,
                        byte[] aP9 ,
                        String[] aP10 ,
                        String[] aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             java.math.BigDecimal[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 ,
                             String[] aP11 )
   {
      calculoiigg.this.AV11CliCod = aP0;
      calculoiigg.this.AV12EmpCod = aP1;
      calculoiigg.this.AV13LiqNro = aP2;
      calculoiigg.this.AV42LiqRelNro = aP3;
      calculoiigg.this.AV14LegNumero = aP4;
      calculoiigg.this.AV16LiqPeriodo = aP5;
      calculoiigg.this.AV17ProcesoLiquidacion = aP6;
      calculoiigg.this.AV19insertandoConceptos = aP7;
      calculoiigg.this.aP8 = aP8;
      calculoiigg.this.aP9 = aP9;
      calculoiigg.this.aP10 = aP10;
      calculoiigg.this.aP11 = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LiqDCalculado = (byte)(1) ;
      GXv_int1[0] = AV20cuotaFijaLiqDCalculado ;
      GXv_char2[0] = AV21cuotaFijaError ;
      GXv_decimal3[0] = AV9cuota_fija ;
      GXv_decimal4[0] = AV37topeAnteriorImportes ;
      GXv_decimal5[0] = AV33alicuotaPorUnaje ;
      GXv_decimal6[0] = AV34gnsiImportes ;
      GXv_char7[0] = AV44auxError ;
      GXv_char8[0] = AV43auxLiqDLog ;
      new web.getgantasa(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV42LiqRelNro, AV14LegNumero, AV15ConCodigo, AV16LiqPeriodo, AV17ProcesoLiquidacion, "", true, DecimalUtil.doubleToDec(0), DecimalUtil.doubleToDec(0), AV48Pgmname, AV19insertandoConceptos, GXv_int1, GXv_char2, GXv_decimal3, GXv_decimal4, GXv_decimal5, GXv_decimal6, GXv_char7, GXv_char8) ;
      calculoiigg.this.AV20cuotaFijaLiqDCalculado = GXv_int1[0] ;
      calculoiigg.this.AV21cuotaFijaError = GXv_char2[0] ;
      calculoiigg.this.AV9cuota_fija = GXv_decimal3[0] ;
      calculoiigg.this.AV37topeAnteriorImportes = GXv_decimal4[0] ;
      calculoiigg.this.AV33alicuotaPorUnaje = GXv_decimal5[0] ;
      calculoiigg.this.AV34gnsiImportes = GXv_decimal6[0] ;
      calculoiigg.this.AV44auxError = GXv_char7[0] ;
      calculoiigg.this.AV43auxLiqDLog = GXv_char8[0] ;
      if ( AV20cuotaFijaLiqDCalculado == 0 )
      {
         AV10LiqDCalculado = (byte)(0) ;
         AV22error = httpContext.getMessage( "No se pudo calcular escala IIGG (", "") + GXutil.trim( AV44auxError) + ")" ;
         if ( ! (GXutil.strcmp("", AV21cuotaFijaError)==0) )
         {
            AV22error += " (" + GXutil.trim( AV21cuotaFijaError) + ")" ;
         }
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8Importes = AV9cuota_fija ;
      GXv_char8[0] = AV45ToolTip ;
      new web.armatooltip(remoteHandle, context).execute( AV11CliCod, AV8Importes, AV43auxLiqDLog, false, GXv_char8) ;
      calculoiigg.this.AV45ToolTip = GXv_char8[0] ;
      AV23LiqDLog += httpContext.getMessage( "Se inicializa valor con ", "") + GXutil.trim( AV45ToolTip) + httpContext.getMessage( " correspondiente a la cuota fija según la escala", "") ;
      GXv_int9[0] = AV24cant_cuotas ;
      new web.mesesanio(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, AV16LiqPeriodo, GXv_int9) ;
      calculoiigg.this.AV24cant_cuotas = GXv_int9[0] ;
      if ( AV24cant_cuotas == 0 )
      {
         AV22error = httpContext.getMessage( "Cantidad de cuotas en cero", "") ;
         AV10LiqDCalculado = (byte)(0) ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV8Importes = AV8Importes.divide(DecimalUtil.doubleToDec(AV24cant_cuotas), 18, java.math.RoundingMode.DOWN) ;
      AV23LiqDLog += httpContext.getMessage( ". Se divide entre ", "") + GXutil.trim( GXutil.str( AV24cant_cuotas, 4, 0)) + httpContext.getMessage( " meses quedando en ", "") + GXutil.trim( GXutil.str( AV8Importes, 14, 2)) ;
      GXv_int9[0] = (short)(DecimalUtil.decToDouble(AV25nro_cuota)) ;
      new web.mesesganancias(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV14LegNumero, AV16LiqPeriodo, GXv_int9) ;
      calculoiigg.this.AV25nro_cuota = DecimalUtil.doubleToDec(GXv_int9[0]) ;
      GXv_int1[0] = AV40LegClase ;
      new web.getlegajoclase(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV14LegNumero, GXv_int1) ;
      calculoiigg.this.AV40LegClase = GXv_int1[0] ;
      GXv_int1[0] = (byte)(AV26primeraEs) ;
      new web.esprimeraquincena(remoteHandle, context).execute( AV11CliCod, AV12EmpCod, AV13LiqNro, AV14LegNumero, AV16LiqPeriodo, AV40LegClase, GXv_int1) ;
      calculoiigg.this.AV26primeraEs = GXv_int1[0] ;
      if ( AV26primeraEs == 1 )
      {
         AV25nro_cuota = AV25nro_cuota.multiply(DecimalUtil.doubleToDec(2)) ;
         AV25nro_cuota = AV25nro_cuota.subtract(DecimalUtil.doubleToDec(1)) ;
         AV25nro_cuota = AV25nro_cuota.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
      }
      AV8Importes = AV8Importes.multiply(AV25nro_cuota) ;
      if ( AV25nro_cuota.doubleValue() > 1 )
      {
         AV23LiqDLog += httpContext.getMessage( ". Se multiplica por ", "") + GXutil.trim( GXutil.str( AV25nro_cuota, 4, 1)) + httpContext.getMessage( " cuotas quedando en ", "") + GXutil.trim( GXutil.str( AV8Importes, 14, 2)) ;
      }
      AV32alicuotaNum = (short)(DecimalUtil.decToDouble(AV33alicuotaPorUnaje.multiply(DecimalUtil.doubleToDec(100)))) ;
      AV31alicuotaPalabra = GXutil.trim( GXutil.str( AV32alicuotaNum, 4, 0)) + "%" ;
      if ( AV34gnsiImportes.doubleValue() < 0 )
      {
         AV34gnsiImportes = DecimalUtil.doubleToDec(0) ;
      }
      AV36topeAnteriorEnProporcionImportes = AV37topeAnteriorImportes.divide(DecimalUtil.doubleToDec(AV24cant_cuotas), 18, java.math.RoundingMode.DOWN) ;
      AV36topeAnteriorEnProporcionImportes = AV36topeAnteriorEnProporcionImportes.multiply(AV25nro_cuota) ;
      AV39segundaParteImportes = AV34gnsiImportes.subtract(AV36topeAnteriorEnProporcionImportes) ;
      AV30cuota_variable = AV39segundaParteImportes.multiply(AV33alicuotaPorUnaje) ;
      AV8Importes = AV8Importes.add(AV30cuota_variable) ;
      GXt_char10 = AV41gnsiConCodigo ;
      GXt_char11 = AV41gnsiConCodigo ;
      GXv_char8[0] = GXt_char11 ;
      new web.gannetsujimpmenosdedinc_codigoparam(remoteHandle, context).execute( GXv_char8) ;
      calculoiigg.this.GXt_char11 = GXv_char8[0] ;
      GXv_char7[0] = GXt_char10 ;
      new web.getparametro(remoteHandle, context).execute( AV11CliCod, GXt_char11, GXv_char7) ;
      calculoiigg.this.GXt_char10 = GXv_char7[0] ;
      AV41gnsiConCodigo = GXt_char10 ;
      AV23LiqDLog += httpContext.getMessage( ". Se suma el valor ", "") + GXutil.trim( GXutil.str( AV30cuota_variable, 14, 2)) + httpContext.getMessage( " correspondientes al ", "") + GXutil.trim( AV31alicuotaPalabra) + httpContext.getMessage( " de ", "") + GXutil.trim( GXutil.str( AV39segundaParteImportes, 14, 2)) + httpContext.getMessage( " de la diferencia entre el acumulado de la ganancia neta sujeta a impuestos ", "") + GXutil.trim( GXutil.str( AV34gnsiImportes, 14, 2)) + httpContext.getMessage( " (concepto ", "") + GXutil.trim( AV41gnsiConCodigo) + httpContext.getMessage( ") y ", "") + GXutil.trim( GXutil.str( AV36topeAnteriorEnProporcionImportes, 14, 2)) + httpContext.getMessage( " del tope de la escala anterior ", "") + GXutil.trim( GXutil.str( AV37topeAnteriorImportes, 14, 2)) + httpContext.getMessage( " dividido entre ", "") + GXutil.trim( GXutil.str( AV24cant_cuotas, 4, 0)) + httpContext.getMessage( " meses", "") ;
      if ( AV25nro_cuota.doubleValue() > 1 )
      {
         AV23LiqDLog += httpContext.getMessage( " y multiplicado por ", "") + GXutil.trim( GXutil.str( AV25nro_cuota, 4, 1)) + httpContext.getMessage( " cuotas", "") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP8[0] = calculoiigg.this.AV8Importes;
      this.aP9[0] = calculoiigg.this.AV10LiqDCalculado;
      this.aP10[0] = calculoiigg.this.AV22error;
      this.aP11[0] = calculoiigg.this.AV23LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8Importes = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV23LiqDLog = "" ;
      AV15ConCodigo = "" ;
      AV48Pgmname = "" ;
      AV21cuotaFijaError = "" ;
      GXv_char2 = new String[1] ;
      AV9cuota_fija = DecimalUtil.ZERO ;
      GXv_decimal3 = new java.math.BigDecimal[1] ;
      AV37topeAnteriorImportes = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV33alicuotaPorUnaje = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      AV34gnsiImportes = DecimalUtil.ZERO ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      AV44auxError = "" ;
      AV43auxLiqDLog = "" ;
      AV45ToolTip = "" ;
      AV25nro_cuota = DecimalUtil.ZERO ;
      GXv_int9 = new short[1] ;
      GXv_int1 = new byte[1] ;
      AV31alicuotaPalabra = "" ;
      AV36topeAnteriorEnProporcionImportes = DecimalUtil.ZERO ;
      AV39segundaParteImportes = DecimalUtil.ZERO ;
      AV30cuota_variable = DecimalUtil.ZERO ;
      AV41gnsiConCodigo = "" ;
      GXt_char10 = "" ;
      GXt_char11 = "" ;
      GXv_char8 = new String[1] ;
      GXv_char7 = new String[1] ;
      AV48Pgmname = "calculoIIGG" ;
      /* GeneXus formulas. */
      AV48Pgmname = "calculoIIGG" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqDCalculado ;
   private byte AV20cuotaFijaLiqDCalculado ;
   private byte AV40LegClase ;
   private byte GXv_int1[] ;
   private short AV12EmpCod ;
   private short AV24cant_cuotas ;
   private short GXv_int9[] ;
   private short AV26primeraEs ;
   private short AV32alicuotaNum ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LiqNro ;
   private int AV42LiqRelNro ;
   private int AV14LegNumero ;
   private java.math.BigDecimal AV8Importes ;
   private java.math.BigDecimal AV9cuota_fija ;
   private java.math.BigDecimal GXv_decimal3[] ;
   private java.math.BigDecimal AV37topeAnteriorImportes ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal AV33alicuotaPorUnaje ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV34gnsiImportes ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal AV25nro_cuota ;
   private java.math.BigDecimal AV36topeAnteriorEnProporcionImportes ;
   private java.math.BigDecimal AV39segundaParteImportes ;
   private java.math.BigDecimal AV30cuota_variable ;
   private String AV17ProcesoLiquidacion ;
   private String AV15ConCodigo ;
   private String AV48Pgmname ;
   private String GXv_char2[] ;
   private String AV31alicuotaPalabra ;
   private String AV41gnsiConCodigo ;
   private String GXt_char10 ;
   private String GXt_char11 ;
   private String GXv_char8[] ;
   private String GXv_char7[] ;
   private java.util.Date AV16LiqPeriodo ;
   private boolean AV19insertandoConceptos ;
   private boolean returnInSub ;
   private String AV23LiqDLog ;
   private String AV43auxLiqDLog ;
   private String AV22error ;
   private String AV21cuotaFijaError ;
   private String AV44auxError ;
   private String AV45ToolTip ;
   private String[] aP11 ;
   private java.math.BigDecimal[] aP8 ;
   private byte[] aP9 ;
   private String[] aP10 ;
}

