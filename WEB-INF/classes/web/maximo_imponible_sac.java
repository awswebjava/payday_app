package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class maximo_imponible_sac extends GXProcedure
{
   public maximo_imponible_sac( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( maximo_imponible_sac.class ), "" );
   }

   public maximo_imponible_sac( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 ,
                            int aP2 ,
                            int aP3 ,
                            int aP4 ,
                            java.util.Date aP5 ,
                            short aP6 ,
                            java.math.BigDecimal aP7 ,
                            java.math.BigDecimal aP8 ,
                            boolean aP9 ,
                            String aP10 ,
                            boolean aP11 ,
                            byte[] aP12 ,
                            String[] aP13 ,
                            String[] aP14 ,
                            java.math.BigDecimal[] aP15 ,
                            java.math.BigDecimal[] aP16 )
   {
      maximo_imponible_sac.this.aP17 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        java.util.Date aP5 ,
                        short aP6 ,
                        java.math.BigDecimal aP7 ,
                        java.math.BigDecimal aP8 ,
                        boolean aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        byte[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        short[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             java.util.Date aP5 ,
                             short aP6 ,
                             java.math.BigDecimal aP7 ,
                             java.math.BigDecimal aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             byte[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             short[] aP17 )
   {
      maximo_imponible_sac.this.AV8CliCod = aP0;
      maximo_imponible_sac.this.AV9EmpCod = aP1;
      maximo_imponible_sac.this.AV10LiqNro = aP2;
      maximo_imponible_sac.this.AV42LiqRelNro = aP3;
      maximo_imponible_sac.this.AV11LegNumero = aP4;
      maximo_imponible_sac.this.AV12LiqPeriodo = aP5;
      maximo_imponible_sac.this.AV13dias_mes = aP6;
      maximo_imponible_sac.this.AV26sacImportes = aP7;
      maximo_imponible_sac.this.AV38sacProporcionalImportes = aP8;
      maximo_imponible_sac.this.AV28esAporte = aP9;
      maximo_imponible_sac.this.AV14ProcesoLiquidacion = aP10;
      maximo_imponible_sac.this.AV15insertandoConceptos = aP11;
      maximo_imponible_sac.this.aP12 = aP12;
      maximo_imponible_sac.this.aP13 = aP13;
      maximo_imponible_sac.this.aP14 = aP14;
      maximo_imponible_sac.this.aP15 = aP15;
      maximo_imponible_sac.this.aP16 = aP16;
      maximo_imponible_sac.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV34LiqDCalculado = (byte)(1) ;
      AV23OpeCliId = "[base_imp_max]" ;
      GXv_char1[0] = AV24OpeCliValor ;
      GXv_char2[0] = AV36auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV8CliCod, AV23OpeCliId, AV12LiqPeriodo, AV14ProcesoLiquidacion, GXv_char1, GXv_char2) ;
      maximo_imponible_sac.this.AV24OpeCliValor = GXv_char1[0] ;
      maximo_imponible_sac.this.AV36auxError = GXv_char2[0] ;
      if ( ! (GXutil.strcmp("", AV36auxError)==0) )
      {
         AV34LiqDCalculado = (byte)(0) ;
         AV37error = AV36auxError ;
         AV20LiqDLog = AV37error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV22base_imp_max = CommonUtil.decimalVal( AV24OpeCliValor, ".") ;
      GXv_int3[0] = AV16dias_trabajados_mes ;
      GXv_char2[0] = AV17diasTrabMesError ;
      GXv_int4[0] = AV18diasTrabMesLiqDCalculado ;
      GXv_char1[0] = AV19diasTrabMesLiqDLog ;
      new web.diastrabmesparabaseimp(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV12LiqPeriodo, AV13dias_mes, AV14ProcesoLiquidacion, AV15insertandoConceptos, GXv_int3, GXv_char2, GXv_int4, GXv_char1) ;
      maximo_imponible_sac.this.AV16dias_trabajados_mes = GXv_int3[0] ;
      maximo_imponible_sac.this.AV17diasTrabMesError = GXv_char2[0] ;
      maximo_imponible_sac.this.AV18diasTrabMesLiqDCalculado = GXv_int4[0] ;
      maximo_imponible_sac.this.AV19diasTrabMesLiqDLog = GXv_char1[0] ;
      if ( AV18diasTrabMesLiqDCalculado == 0 )
      {
         AV34LiqDCalculado = (byte)(0) ;
         AV37error = AV17diasTrabMesError ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV20LiqDLog += AV19diasTrabMesLiqDLog ;
      AV21maxProporATrab = (AV22base_imp_max.divide(DecimalUtil.doubleToDec(AV13dias_mes), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV16dias_trabajados_mes)) ;
      AV23OpeCliId = "[base_imp_min]" ;
      GXv_char2[0] = AV24OpeCliValor ;
      GXv_char1[0] = AV36auxError ;
      new web.getopeclivalor(remoteHandle, context).execute( AV8CliCod, AV23OpeCliId, AV12LiqPeriodo, AV14ProcesoLiquidacion, GXv_char2, GXv_char1) ;
      maximo_imponible_sac.this.AV24OpeCliValor = GXv_char2[0] ;
      maximo_imponible_sac.this.AV36auxError = GXv_char1[0] ;
      if ( ! (GXutil.strcmp("", AV36auxError)==0) )
      {
         AV34LiqDCalculado = (byte)(0) ;
         AV37error = AV36auxError ;
         AV20LiqDLog = AV37error ;
         returnInSub = true;
         cleanup();
         if (true) return;
      }
      AV25base_imp_min = CommonUtil.decimalVal( AV24OpeCliValor, ".") ;
      if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26sacImportes)==0) )
      {
         AV27mitad_base_imp_max = (AV21maxProporATrab.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN)) ;
         if ( ( DecimalUtil.compareTo(AV26sacImportes, AV27mitad_base_imp_max) <= 0 ) || ! AV28esAporte )
         {
            AV29Importe = AV29Importe.add(AV26sacImportes) ;
            AV40baseImportes = AV40baseImportes.add(AV26sacImportes) ;
            if ( AV28esAporte )
            {
               if ( AV26sacImportes.doubleValue() > 0 )
               {
                  AV20LiqDLog += httpContext.getMessage( ". Agrega el ", "") ;
               }
               else
               {
                  /* Execute user subroutine: 'SEPARAR LOG' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  AV20LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
               }
               AV20LiqDLog += httpContext.getMessage( "SAC ", "") + GXutil.trim( GXutil.str( AV26sacImportes, 14, 2)) + httpContext.getMessage( " al ser menor o igual a la mitad del máximo imponible proporcional a los días trabajados ", "") + GXutil.trim( GXutil.str( AV27mitad_base_imp_max, 14, 2)) ;
               if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV26sacImportes)==0) && ( AV13dias_mes != AV16dias_trabajados_mes ) )
               {
                  AV20LiqDLog += httpContext.getMessage( ", importe que se calcula de la siguiente manera: (", "") + GXutil.trim( GXutil.str( AV22base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV13dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV16dias_trabajados_mes, 4, 0)) + httpContext.getMessage( ", dividido 2", "") ;
               }
            }
            else
            {
               if ( AV26sacImportes.doubleValue() > 0 )
               {
                  AV20LiqDLog += httpContext.getMessage( ". Agrega el ", "") ;
               }
               else
               {
                  /* Execute user subroutine: 'SEPARAR LOG' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  AV20LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
               }
               AV20LiqDLog += httpContext.getMessage( "SAC ", "") + GXutil.trim( GXutil.str( AV26sacImportes, 14, 2)) ;
            }
         }
         else
         {
            AV30valor = (AV21maxProporATrab.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN)) ;
            AV29Importe = AV29Importe.add(AV30valor) ;
            if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40baseImportes)==0) )
            {
               AV40baseImportes = AV40baseImportes.add(AV30valor) ;
            }
            if ( AV30valor.doubleValue() > 0 )
            {
               AV20LiqDLog += httpContext.getMessage( ". Agrega el ", "") ;
            }
            else
            {
               /* Execute user subroutine: 'SEPARAR LOG' */
               S121 ();
               if ( returnInSub )
               {
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV20LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
            }
            AV20LiqDLog += httpContext.getMessage( "SAC por el valor de la mitad del máximo imponible proporcional a los días trabajados  ", "") + GXutil.trim( GXutil.str( AV30valor, 14, 2)) ;
            if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV30valor)==0) && ( AV13dias_mes != AV16dias_trabajados_mes ) )
            {
               AV20LiqDLog += httpContext.getMessage( ", importe que se calcula de la siguiente manera: (", "") + GXutil.trim( GXutil.str( AV22base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV13dias_mes, 4, 0)) + ") * " + GXutil.trim( GXutil.str( AV16dias_trabajados_mes, 4, 0)) + httpContext.getMessage( ", dividido 2", "") ;
            }
            else
            {
               AV20LiqDLog += httpContext.getMessage( " (máximo imponible es ", "") + GXutil.trim( GXutil.str( AV21maxProporATrab, 14, 2)) + ")" ;
            }
            AV20LiqDLog += httpContext.getMessage( " al ser el valor del SAC ", "") + GXutil.trim( GXutil.str( AV26sacImportes, 14, 2)) + httpContext.getMessage( " mayor a este tope", "") ;
         }
         AV41cantidadCalculada = (short)(AV41cantidadCalculada+AV31dias_semestre) ;
      }
      else
      {
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38sacProporcionalImportes)==0) )
         {
            /* Execute user subroutine: 'CALCULAR DIAS SEMESTRE' */
            S111 ();
            if ( returnInSub )
            {
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            if ( AV28esAporte )
            {
               AV27mitad_base_imp_max = AV22base_imp_max.divide(DecimalUtil.doubleToDec(2), 18, java.math.RoundingMode.DOWN) ;
               if ( AV31dias_semestre == 0 )
               {
                  AV37error = httpContext.getMessage( "Días del semestre en cero al calcular sac proporcional", "") ;
                  AV34LiqDCalculado = (byte)(0) ;
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV39maxProporASemestre = (AV27mitad_base_imp_max.divide(DecimalUtil.doubleToDec(AV31dias_semestre), 18, java.math.RoundingMode.DOWN)).multiply(DecimalUtil.doubleToDec(AV33dias_remunerados_semestre)) ;
               if ( DecimalUtil.compareTo(AV38sacProporcionalImportes, AV39maxProporASemestre) <= 0 )
               {
                  AV29Importe = AV29Importe.add(AV38sacProporcionalImportes) ;
                  AV40baseImportes = AV40baseImportes.add(AV38sacProporcionalImportes) ;
                  if ( AV38sacProporcionalImportes.doubleValue() > 0 )
                  {
                     AV20LiqDLog += httpContext.getMessage( ". Agrega el ", "") ;
                  }
                  else
                  {
                     /* Execute user subroutine: 'SEPARAR LOG' */
                     S121 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV20LiqDLog = httpContext.getMessage( "Inicializa valor con ", "") ;
                  }
                  AV20LiqDLog += httpContext.getMessage( "SAC Proporcional ", "") + GXutil.trim( GXutil.str( AV38sacProporcionalImportes, 14, 2)) + httpContext.getMessage( " al ser menor o igual a la mitad del máximo imponible proporcional a los días trabajados en el semestre ", "") + GXutil.trim( GXutil.str( AV39maxProporASemestre, 14, 2)) ;
                  if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, AV38sacProporcionalImportes)==0) && ( AV31dias_semestre != AV33dias_remunerados_semestre ) )
                  {
                     AV20LiqDLog += httpContext.getMessage( ", importe que se arma de la siguiente manera: ( ", "") + GXutil.trim( GXutil.str( AV27mitad_base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV31dias_semestre, 4, 0)) + " ) * " + GXutil.trim( GXutil.str( AV33dias_remunerados_semestre, 4, 0)) ;
                  }
               }
               else
               {
                  AV29Importe = AV29Importe.add(AV39maxProporASemestre) ;
                  if ( (DecimalUtil.compareTo(DecimalUtil.ZERO, AV40baseImportes)==0) )
                  {
                     AV40baseImportes = AV40baseImportes.add(AV39maxProporASemestre) ;
                  }
                  if ( AV38sacProporcionalImportes.doubleValue() > 0 )
                  {
                     AV20LiqDLog += httpContext.getMessage( ". Agrega el ", "") ;
                  }
                  else
                  {
                     /* Execute user subroutine: 'SEPARAR LOG' */
                     S121 ();
                     if ( returnInSub )
                     {
                        returnInSub = true;
                        cleanup();
                        if (true) return;
                     }
                     AV20LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
                  }
                  AV20LiqDLog += httpContext.getMessage( "SAC Proporcional por el valor de la mitad del máximo proporcional a los días trabajados en el semestre ", "") + GXutil.trim( GXutil.str( AV39maxProporASemestre, 14, 2)) + httpContext.getMessage( ", importe que se arma de la siguiente manera: ( ", "") + GXutil.trim( GXutil.str( AV27mitad_base_imp_max, 14, 2)) + " / " + GXutil.trim( GXutil.str( AV31dias_semestre, 4, 0)) + " ) * " + GXutil.trim( GXutil.str( AV33dias_remunerados_semestre, 4, 0)) + httpContext.getMessage( ". al ser el SAC proporcional a los días trabajados en el semestre ", "") + GXutil.trim( GXutil.str( AV38sacProporcionalImportes, 14, 2)) + httpContext.getMessage( " mayor a este tope", "") ;
               }
               AV41cantidadCalculada = (short)(AV41cantidadCalculada+AV33dias_remunerados_semestre) ;
            }
            else
            {
               AV29Importe = AV29Importe.add(AV38sacProporcionalImportes) ;
               AV40baseImportes = AV40baseImportes.add(AV38sacProporcionalImportes) ;
               if ( AV38sacProporcionalImportes.doubleValue() > 0 )
               {
                  AV20LiqDLog += httpContext.getMessage( " Agrega el ", "") ;
               }
               else
               {
                  /* Execute user subroutine: 'SEPARAR LOG' */
                  S121 ();
                  if ( returnInSub )
                  {
                     returnInSub = true;
                     cleanup();
                     if (true) return;
                  }
                  AV20LiqDLog += httpContext.getMessage( "Inicializa valor con ", "") ;
               }
               AV20LiqDLog += httpContext.getMessage( "SAC Proporcional a los días trabajados en el semestre", "") + GXutil.trim( GXutil.str( AV38sacProporcionalImportes, 14, 2)) ;
            }
         }
      }
      cleanup();
   }

   public void S111( )
   {
      /* 'CALCULAR DIAS SEMESTRE' Routine */
      returnInSub = false ;
      AV32palabra = "[dias_semestre]" ;
      GXv_int5[0] = AV31dias_semestre ;
      new web.obtvalformulacdmycds(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV11LegNumero, AV12LiqPeriodo, AV32palabra, AV12LiqPeriodo, false, GXv_int5) ;
      maximo_imponible_sac.this.AV31dias_semestre = (short)((short)(GXv_int5[0])) ;
      AV32palabra = "[dias_remunerados_semestre]" ;
      GXv_int5[0] = AV33dias_remunerados_semestre ;
      GXv_int4[0] = AV35auxLiqDCalculado ;
      GXv_char2[0] = AV36auxError ;
      GXv_char1[0] = "" ;
      new web.obtvalformuladtmydts(remoteHandle, context).execute( AV8CliCod, AV9EmpCod, AV10LiqNro, AV42LiqRelNro, AV11LegNumero, AV32palabra, AV12LiqPeriodo, false, false, true, AV14ProcesoLiquidacion, AV15insertandoConceptos, GXv_int5, GXv_int4, GXv_char2, GXv_char1) ;
      maximo_imponible_sac.this.AV33dias_remunerados_semestre = (short)((short)(GXv_int5[0])) ;
      maximo_imponible_sac.this.AV35auxLiqDCalculado = GXv_int4[0] ;
      maximo_imponible_sac.this.AV36auxError = GXv_char2[0] ;
      if ( AV35auxLiqDCalculado == 0 )
      {
         AV34LiqDCalculado = (byte)(0) ;
         AV37error = httpContext.getMessage( "Falta calcular días remunerados en el semestre", "") ;
         returnInSub = true;
         if (true) return;
      }
   }

   public void S121( )
   {
      /* 'SEPARAR LOG' Routine */
      returnInSub = false ;
      if ( ! (GXutil.strcmp("", AV20LiqDLog)==0) )
      {
         AV20LiqDLog += ". " ;
      }
   }

   protected void cleanup( )
   {
      this.aP12[0] = maximo_imponible_sac.this.AV34LiqDCalculado;
      this.aP13[0] = maximo_imponible_sac.this.AV20LiqDLog;
      this.aP14[0] = maximo_imponible_sac.this.AV37error;
      this.aP15[0] = maximo_imponible_sac.this.AV40baseImportes;
      this.aP16[0] = maximo_imponible_sac.this.AV29Importe;
      this.aP17[0] = maximo_imponible_sac.this.AV41cantidadCalculada;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20LiqDLog = "" ;
      AV37error = "" ;
      AV40baseImportes = DecimalUtil.ZERO ;
      AV29Importe = DecimalUtil.ZERO ;
      AV23OpeCliId = "" ;
      AV24OpeCliValor = "" ;
      AV36auxError = "" ;
      AV22base_imp_max = DecimalUtil.ZERO ;
      GXv_int3 = new short[1] ;
      AV17diasTrabMesError = "" ;
      AV19diasTrabMesLiqDLog = "" ;
      AV21maxProporATrab = DecimalUtil.ZERO ;
      AV25base_imp_min = DecimalUtil.ZERO ;
      AV27mitad_base_imp_max = DecimalUtil.ZERO ;
      AV30valor = DecimalUtil.ZERO ;
      AV39maxProporASemestre = DecimalUtil.ZERO ;
      AV32palabra = "" ;
      GXv_int5 = new int[1] ;
      GXv_int4 = new byte[1] ;
      GXv_char2 = new String[1] ;
      GXv_char1 = new String[1] ;
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV34LiqDCalculado ;
   private byte AV18diasTrabMesLiqDCalculado ;
   private byte AV35auxLiqDCalculado ;
   private byte GXv_int4[] ;
   private short AV9EmpCod ;
   private short AV13dias_mes ;
   private short AV41cantidadCalculada ;
   private short AV16dias_trabajados_mes ;
   private short GXv_int3[] ;
   private short AV31dias_semestre ;
   private short AV33dias_remunerados_semestre ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV10LiqNro ;
   private int AV42LiqRelNro ;
   private int AV11LegNumero ;
   private int GXv_int5[] ;
   private java.math.BigDecimal AV26sacImportes ;
   private java.math.BigDecimal AV38sacProporcionalImportes ;
   private java.math.BigDecimal AV40baseImportes ;
   private java.math.BigDecimal AV29Importe ;
   private java.math.BigDecimal AV22base_imp_max ;
   private java.math.BigDecimal AV21maxProporATrab ;
   private java.math.BigDecimal AV25base_imp_min ;
   private java.math.BigDecimal AV27mitad_base_imp_max ;
   private java.math.BigDecimal AV30valor ;
   private java.math.BigDecimal AV39maxProporASemestre ;
   private String AV14ProcesoLiquidacion ;
   private String AV23OpeCliId ;
   private String AV32palabra ;
   private String GXv_char2[] ;
   private String GXv_char1[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV28esAporte ;
   private boolean AV15insertandoConceptos ;
   private boolean returnInSub ;
   private String AV20LiqDLog ;
   private String AV24OpeCliValor ;
   private String AV19diasTrabMesLiqDLog ;
   private String AV37error ;
   private String AV36auxError ;
   private String AV17diasTrabMesError ;
   private short[] aP17 ;
   private byte[] aP12 ;
   private String[] aP13 ;
   private String[] aP14 ;
   private java.math.BigDecimal[] aP15 ;
   private java.math.BigDecimal[] aP16 ;
}

