package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class deducciones_art_30 extends GXProcedure
{
   public deducciones_art_30( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( deducciones_art_30.class ), "" );
   }

   public deducciones_art_30( int remoteHandle ,
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
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 )
   {
      deducciones_art_30.this.aP10 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
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
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.math.BigDecimal[] aP7 ,
                             String[] aP8 ,
                             byte[] aP9 ,
                             String[] aP10 )
   {
      deducciones_art_30.this.AV9CliCod = aP0;
      deducciones_art_30.this.AV17EmpCod = aP1;
      deducciones_art_30.this.AV16LiqNro = aP2;
      deducciones_art_30.this.AV12LegNumero = aP3;
      deducciones_art_30.this.AV15LiqPeriodo = aP4;
      deducciones_art_30.this.AV20ConCodigo = aP5;
      deducciones_art_30.this.AV25ProcesoLiquidacion = aP6;
      deducciones_art_30.this.aP7 = aP7;
      deducciones_art_30.this.aP8 = aP8;
      deducciones_art_30.this.aP9 = aP9;
      deducciones_art_30.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV8sacTLiqCod ;
      GXt_char2 = AV8sacTLiqCod ;
      GXv_char3[0] = GXt_char2 ;
      new web.tipoliqaguinaldo_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      deducciones_art_30.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      deducciones_art_30.this.GXt_char1 = GXv_char4[0] ;
      AV8sacTLiqCod = GXt_char1 ;
      if ( GXutil.strcmp(AV23TLiqCod, AV8sacTLiqCod) == 0 )
      {
         AV11LiqDLog = httpContext.getMessage( "No se calcula por ser liquidación de SAC", "") ;
      }
      else
      {
         AV24idOperando = "[mni_zona]" ;
         /* Execute user subroutine: 'SUMAR DEDUCCION' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         GXv_decimal5[0] = AV30porUnaje ;
         new web.deduceconyugeporc(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV12LegNumero, GXv_decimal5) ;
         deducciones_art_30.this.AV30porUnaje = GXv_decimal5[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30porUnaje)==0) )
         {
            AV24idOperando = "[ded_cony_zona]" ;
            /* Execute user subroutine: 'DEDUCCION CON PORCENTAJE' */
            S151 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         GXv_int6[0] = (short)(DecimalUtil.decToDouble(AV34cant)) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV12LegNumero, false, AV15LiqPeriodo, (short)(0), (short)(18), DecimalUtil.doubleToDec(0), GXv_int6) ;
         deducciones_art_30.this.AV34cant = DecimalUtil.doubleToDec(GXv_int6[0]) ;
         if ( AV34cant.doubleValue() > 0 )
         {
            GXv_decimal5[0] = AV30porUnaje ;
            new web.porcentajededuccionhijos(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV12LegNumero, false, AV15LiqPeriodo, GXv_decimal5) ;
            deducciones_art_30.this.AV30porUnaje = GXv_decimal5[0] ;
            AV24idOperando = "[ded_hijo_zona]" ;
            /* Execute user subroutine: 'DEDUCCION CON PORCENTAJE Y CANTIDAD' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         GXv_int6[0] = (short)(DecimalUtil.decToDouble(AV34cant)) ;
         new web.cantidadhijos(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV12LegNumero, true, AV15LiqPeriodo, (short)(0), (short)(18), DecimalUtil.doubleToDec(0), GXv_int6) ;
         deducciones_art_30.this.AV34cant = DecimalUtil.doubleToDec(GXv_int6[0]) ;
         if ( AV34cant.doubleValue() > 0 )
         {
            GXv_decimal5[0] = AV30porUnaje ;
            new web.porcentajededuccionhijos(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV12LegNumero, true, AV15LiqPeriodo, GXv_decimal5) ;
            deducciones_art_30.this.AV30porUnaje = GXv_decimal5[0] ;
            AV24idOperando = "[ded_hijo_incap_zona]" ;
            /* Execute user subroutine: 'DEDUCCION CON PORCENTAJE Y CANTIDAD' */
            S161 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
         AV24idOperando = "[ded_especial_zona]" ;
         /* Execute user subroutine: 'SUMAR DEDUCCION' */
         S121 ();
         if ( returnInSub )
         {
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV38doceavaImportes = AV28deduccionesImportes.divide(DecimalUtil.doubleToDec(12), 18, java.math.RoundingMode.DOWN) ;
         AV18Importes = AV18Importes.add(AV38doceavaImportes) ;
         AV11LiqDLog += httpContext.getMessage( ". Se suma ", "") + GXutil.trim( GXutil.str( AV38doceavaImportes, 14, 2)) + httpContext.getMessage( " correspondiente a la deducción de la doceava parte de la suma de las deducciones aplicadas (", "") + GXutil.trim( GXutil.str( AV28deduccionesImportes, 14, 2)) + " / 12)" ;
         AV35mesesAnterioresPalabra = "deMesesAnteriores" ;
         GXv_date7[0] = AV36desdeFecha ;
         GXv_date8[0] = AV37hastaFecha ;
         GXv_boolean9[0] = false ;
         new web.calcparpergetdesdehasta(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV16LiqNro, AV15LiqPeriodo, 0, AV35mesesAnterioresPalabra, GXv_date7, GXv_date8, GXv_boolean9) ;
         deducciones_art_30.this.AV36desdeFecha = GXv_date7[0] ;
         deducciones_art_30.this.AV37hastaFecha = GXv_date8[0] ;
         GXv_decimal5[0] = AV22auxLiqDImpCalcu ;
         new web.getliqdimpcalcu_mesesantopti(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV16LiqNro, AV12LegNumero, AV36desdeFecha, AV37hastaFecha, AV20ConCodigo, GXv_decimal5) ;
         deducciones_art_30.this.AV22auxLiqDImpCalcu = GXv_decimal5[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22auxLiqDImpCalcu)==0) )
         {
            AV11LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV22auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondiente a lo liquidado del concepto en periodos anteriores", "") ;
            AV18Importes = AV18Importes.subtract(AV22auxLiqDImpCalcu) ;
         }
         GXv_int6[0] = AV40nro_cuota ;
         new web.mesesganancias(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV16LiqNro, AV12LegNumero, AV15LiqPeriodo, GXv_int6) ;
         deducciones_art_30.this.AV40nro_cuota = GXv_int6[0] ;
         AV39cantCuotasRestantes = (short)(13-AV40nro_cuota) ;
         AV18Importes = AV18Importes.divide(DecimalUtil.doubleToDec(AV39cantCuotasRestantes), 18, java.math.RoundingMode.DOWN) ;
         AV11LiqDLog += httpContext.getMessage( ". Se divide entre cantidad de cuotas restantes ", "") + GXutil.trim( GXutil.str( AV39cantCuotasRestantes, 4, 0)) ;
         GXv_int10[0] = (byte)((byte)((AV13primeraQuincenaEs)?1:0)) ;
         new web.esprimeraquincena(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV16LiqNro, AV12LegNumero, AV15LiqPeriodo, AV14LegClase, GXv_int10) ;
         deducciones_art_30.this.AV13primeraQuincenaEs = (boolean)((GXv_int10[0]==0)?false:true) ;
         if ( AV13primeraQuincenaEs )
         {
            AV18Importes = AV18Importes.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
            AV11LiqDLog += httpContext.getMessage( ". Se divide entre 2 por ser primera quincena, queda en ", "") + GXutil.trim( GXutil.str( AV18Importes, 14, 2)) ;
         }
         GXv_decimal5[0] = AV22auxLiqDImpCalcu ;
         new web.getliqdimpcalcu_periodoliqantoptim(remoteHandle, context).execute( AV9CliCod, AV17EmpCod, AV16LiqNro, AV12LegNumero, AV15LiqPeriodo, AV20ConCodigo, GXv_decimal5) ;
         deducciones_art_30.this.AV22auxLiqDImpCalcu = GXv_decimal5[0] ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV22auxLiqDImpCalcu)==0) )
         {
            AV18Importes = AV18Importes.subtract(AV22auxLiqDImpCalcu) ;
            AV11LiqDLog += httpContext.getMessage( ". Se resta el valor ", "") + GXutil.trim( GXutil.str( AV22auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " correspondiente a liquidaciones anteriores del concepto en el mismo periodo", "") ;
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'RESPONDER ERROR' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV26auxError)==0) )
      {
         AV10LiqDCalculado = (byte)(0) ;
         AV27error = GXutil.trim( AV26auxError) ;
         AV11LiqDLog = GXutil.trim( AV27error) ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'SUMAR DEDUCCION' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OBTENER DEDUCCION' */
      S131 ();
      if (returnInSub) return;
      /* Execute user subroutine: 'ACUMULAR DEDUCCION' */
      S141 ();
      if (returnInSub) return;
   }

   public void S131( )
   {
      /* 'OBTENER DEDUCCION' Routine */
      returnInSub = false ;
      GXv_decimal5[0] = AV22auxLiqDImpCalcu ;
      GXv_char4[0] = AV26auxError ;
      GXv_char3[0] = AV29variableDescrip ;
      new web.articulo30(remoteHandle, context).execute( AV9CliCod, AV24idOperando, AV15LiqPeriodo, AV25ProcesoLiquidacion, GXv_decimal5, GXv_char4, GXv_char3) ;
      deducciones_art_30.this.AV22auxLiqDImpCalcu = GXv_decimal5[0] ;
      deducciones_art_30.this.AV26auxError = GXv_char4[0] ;
      deducciones_art_30.this.AV29variableDescrip = GXv_char3[0] ;
      /* Execute user subroutine: 'RESPONDER ERROR' */
      S111 ();
      if (returnInSub) return;
   }

   public void S141( )
   {
      /* 'ACUMULAR DEDUCCION' Routine */
      returnInSub = false ;
      AV28deduccionesImportes = AV28deduccionesImportes.add(AV22auxLiqDImpCalcu) ;
      AV18Importes = AV18Importes.add(AV22auxLiqDImpCalcu) ;
      if ( ! (GXutil.strcmp("", AV11LiqDLog)==0) )
      {
         AV11LiqDLog += ". " ;
      }
      AV11LiqDLog += httpContext.getMessage( "Se suma ", "") + GXutil.trim( GXutil.str( AV22auxLiqDImpCalcu, 14, 2)) + httpContext.getMessage( " de \"", "") + GXutil.trim( AV29variableDescrip) + "\"" ;
   }

   public void S151( )
   {
      /* 'DEDUCCION CON PORCENTAJE' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OBTENER DEDUCCION' */
      S131 ();
      if (returnInSub) return;
      AV32auxLiqDImpCalcu2 = AV22auxLiqDImpCalcu ;
      AV22auxLiqDImpCalcu = AV32auxLiqDImpCalcu2.multiply(AV30porUnaje) ;
      /* Execute user subroutine: 'ACUMULAR DEDUCCION' */
      S141 ();
      if (returnInSub) return;
      if ( AV30porUnaje.doubleValue() < 1 )
      {
         AV33porcentaje = AV30porUnaje.multiply(DecimalUtil.doubleToDec(100)) ;
         AV11LiqDLog += httpContext.getMessage( " (teniendo en cuenta que se deduce un %", "") + GXutil.trim( GXutil.str( AV33porcentaje, 6, 2)) + httpContext.getMessage( " del total ", "") + GXutil.trim( GXutil.str( AV32auxLiqDImpCalcu2, 14, 2)) + ")" ;
      }
   }

   public void S161( )
   {
      /* 'DEDUCCION CON PORCENTAJE Y CANTIDAD' Routine */
      returnInSub = false ;
      /* Execute user subroutine: 'OBTENER DEDUCCION' */
      S131 ();
      if (returnInSub) return;
      AV32auxLiqDImpCalcu2 = AV22auxLiqDImpCalcu ;
      AV22auxLiqDImpCalcu = AV32auxLiqDImpCalcu2.multiply(AV30porUnaje).multiply(AV34cant) ;
      /* Execute user subroutine: 'ACUMULAR DEDUCCION' */
      S141 ();
      if (returnInSub) return;
      if ( AV30porUnaje.doubleValue() < 1 )
      {
         AV33porcentaje = AV30porUnaje.multiply(DecimalUtil.doubleToDec(100)) ;
         if ( AV34cant.doubleValue() > 1 )
         {
            AV11LiqDLog += httpContext.getMessage( " (teniendo en cuenta que se deduce un %", "") + GXutil.trim( GXutil.str( AV33porcentaje, 6, 2)) + httpContext.getMessage( " del valor ", "") + GXutil.trim( GXutil.str( AV32auxLiqDImpCalcu2, 14, 2)) + httpContext.getMessage( " y multiplicado por la cantidad ", "") + GXutil.trim( GXutil.str( AV34cant, 6, 3)) + ")" ;
         }
         else
         {
            AV11LiqDLog += httpContext.getMessage( " (teniendo en cuenta que se deduce un %", "") + GXutil.trim( GXutil.str( AV33porcentaje, 6, 2)) + httpContext.getMessage( " del valor ", "") + GXutil.trim( GXutil.str( AV32auxLiqDImpCalcu2, 14, 2)) + ")" ;
         }
      }
      else
      {
         if ( AV34cant.doubleValue() > 1 )
         {
            AV11LiqDLog += httpContext.getMessage( " (multiplicando el valor ", "") + GXutil.trim( GXutil.str( AV32auxLiqDImpCalcu2, 14, 2)) + httpContext.getMessage( " por la cantidad ", "") + GXutil.trim( GXutil.str( AV34cant, 6, 3)) + ")" ;
         }
      }
   }

   protected void cleanup( )
   {
      this.aP7[0] = deducciones_art_30.this.AV18Importes;
      this.aP8[0] = deducciones_art_30.this.AV11LiqDLog;
      this.aP9[0] = deducciones_art_30.this.AV10LiqDCalculado;
      this.aP10[0] = deducciones_art_30.this.AV27error;
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
      AV11LiqDLog = "" ;
      AV27error = "" ;
      AV8sacTLiqCod = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      AV23TLiqCod = "" ;
      AV24idOperando = "" ;
      AV30porUnaje = DecimalUtil.ZERO ;
      AV34cant = DecimalUtil.ZERO ;
      AV38doceavaImportes = DecimalUtil.ZERO ;
      AV28deduccionesImportes = DecimalUtil.ZERO ;
      AV35mesesAnterioresPalabra = "" ;
      AV36desdeFecha = GXutil.nullDate() ;
      GXv_date7 = new java.util.Date[1] ;
      AV37hastaFecha = GXutil.nullDate() ;
      GXv_date8 = new java.util.Date[1] ;
      GXv_boolean9 = new boolean[1] ;
      AV22auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_int6 = new short[1] ;
      GXv_int10 = new byte[1] ;
      AV26auxError = "" ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_char4 = new String[1] ;
      AV29variableDescrip = "" ;
      GXv_char3 = new String[1] ;
      AV32auxLiqDImpCalcu2 = DecimalUtil.ZERO ;
      AV33porcentaje = DecimalUtil.ZERO ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqDCalculado ;
   private byte AV14LegClase ;
   private byte GXv_int10[] ;
   private short AV17EmpCod ;
   private short AV40nro_cuota ;
   private short GXv_int6[] ;
   private short AV39cantCuotasRestantes ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV16LiqNro ;
   private int AV12LegNumero ;
   private java.math.BigDecimal AV18Importes ;
   private java.math.BigDecimal AV30porUnaje ;
   private java.math.BigDecimal AV34cant ;
   private java.math.BigDecimal AV38doceavaImportes ;
   private java.math.BigDecimal AV28deduccionesImportes ;
   private java.math.BigDecimal AV22auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV32auxLiqDImpCalcu2 ;
   private java.math.BigDecimal AV33porcentaje ;
   private String AV20ConCodigo ;
   private String AV25ProcesoLiquidacion ;
   private String AV8sacTLiqCod ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String AV23TLiqCod ;
   private String AV24idOperando ;
   private String AV35mesesAnterioresPalabra ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV15LiqPeriodo ;
   private java.util.Date AV36desdeFecha ;
   private java.util.Date GXv_date7[] ;
   private java.util.Date AV37hastaFecha ;
   private java.util.Date GXv_date8[] ;
   private boolean returnInSub ;
   private boolean GXv_boolean9[] ;
   private boolean AV13primeraQuincenaEs ;
   private String AV11LiqDLog ;
   private String AV27error ;
   private String AV26auxError ;
   private String AV29variableDescrip ;
   private String[] aP10 ;
   private java.math.BigDecimal[] aP7 ;
   private String[] aP8 ;
   private byte[] aP9 ;
}

