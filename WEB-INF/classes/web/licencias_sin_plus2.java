package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class licencias_sin_plus2 extends GXProcedure
{
   public licencias_sin_plus2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( licencias_sin_plus2.class ), "" );
   }

   public licencias_sin_plus2( int remoteHandle ,
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
                            String aP5 ,
                            java.util.Date aP6 ,
                            String aP7 ,
                            String aP8 ,
                            String aP9 ,
                            boolean aP10 ,
                            boolean aP11 ,
                            java.math.BigDecimal[] aP12 ,
                            String[] aP13 ,
                            String[] aP14 ,
                            byte[] aP15 )
   {
      licencias_sin_plus2.this.aP16 = new short[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
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
                        String aP9 ,
                        boolean aP10 ,
                        boolean aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        String[] aP13 ,
                        String[] aP14 ,
                        byte[] aP15 ,
                        short[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
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
                             String aP9 ,
                             boolean aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             String[] aP13 ,
                             String[] aP14 ,
                             byte[] aP15 ,
                             short[] aP16 )
   {
      licencias_sin_plus2.this.AV9CliCod = aP0;
      licencias_sin_plus2.this.AV8EmpCod = aP1;
      licencias_sin_plus2.this.AV10LiqNro = aP2;
      licencias_sin_plus2.this.AV36LiqRelNro = aP3;
      licencias_sin_plus2.this.AV11LegNumero = aP4;
      licencias_sin_plus2.this.AV26ConCodigo = aP5;
      licencias_sin_plus2.this.AV27LiqPeriodo = aP6;
      licencias_sin_plus2.this.AV12DConCondicion = aP7;
      licencias_sin_plus2.this.AV16ProcesoLiquidacion = aP8;
      licencias_sin_plus2.this.AV35llamador = aP9;
      licencias_sin_plus2.this.AV14vacacionesEs = aP10;
      licencias_sin_plus2.this.AV25distintoEs = aP11;
      licencias_sin_plus2.this.aP12 = aP12;
      licencias_sin_plus2.this.aP13 = aP13;
      licencias_sin_plus2.this.aP14 = aP14;
      licencias_sin_plus2.this.aP15 = aP15;
      licencias_sin_plus2.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV18LiqDCalculado = (byte)(1) ;
      GXt_char1 = AV13vacConCodigo ;
      GXt_char2 = AV13vacConCodigo ;
      GXv_char3[0] = GXt_char2 ;
      new web.concepto_vacacioneslibres_codigoparam(remoteHandle, context).execute( GXv_char3) ;
      licencias_sin_plus2.this.GXt_char2 = GXv_char3[0] ;
      GXv_char4[0] = GXt_char1 ;
      new web.getparametro(remoteHandle, context).execute( AV9CliCod, GXt_char2, GXv_char4) ;
      licencias_sin_plus2.this.GXt_char1 = GXv_char4[0] ;
      AV13vacConCodigo = GXt_char1 ;
      if ( AV14vacacionesEs )
      {
         /* Using cursor P01NF2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV11LegNumero), AV13vacConCodigo, AV12DConCondicion});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A1487DConCondicion = P01NF2_A1487DConCondicion[0] ;
            A394DConCodigo = P01NF2_A394DConCodigo[0] ;
            A6LegNumero = P01NF2_A6LegNumero[0] ;
            A31LiqNro = P01NF2_A31LiqNro[0] ;
            A1EmpCod = P01NF2_A1EmpCod[0] ;
            A3CliCod = P01NF2_A3CliCod[0] ;
            A507LiqDCalculado = P01NF2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P01NF2_A763LiqDRecalculado[0] ;
            A393DConDescrip = P01NF2_A393DConDescrip[0] ;
            A269LiqDCanti = P01NF2_A269LiqDCanti[0] ;
            n269LiqDCanti = P01NF2_n269LiqDCanti[0] ;
            A81LiqDSecuencial = P01NF2_A81LiqDSecuencial[0] ;
            GXv_int5[0] = AV17auxLiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV9CliCod, A394DConCodigo, AV16ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
            licencias_sin_plus2.this.AV17auxLiqDCalculado = GXv_int5[0] ;
            if ( AV17auxLiqDCalculado == 0 )
            {
               AV18LiqDCalculado = (byte)(0) ;
               AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A393DConDescrip) ;
               AV15LiqDLog = AV19error ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV24cantidadCalculada = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV24cantidadCalculada).add(A269LiqDCanti))) ;
            if ( ! (GXutil.strcmp("", AV37cantidadLiqDLog)==0) )
            {
               AV37cantidadLiqDLog += ", " ;
            }
            AV37cantidadLiqDLog += GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      else
      {
         if ( AV25distintoEs )
         {
            AV41GXLvl31 = (byte)(0) ;
            /* Using cursor P01NF3 */
            pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV11LegNumero), AV13vacConCodigo, AV12DConCondicion});
            while ( (pr_default.getStatus(1) != 101) )
            {
               A1487DConCondicion = P01NF3_A1487DConCondicion[0] ;
               A394DConCodigo = P01NF3_A394DConCodigo[0] ;
               A6LegNumero = P01NF3_A6LegNumero[0] ;
               A31LiqNro = P01NF3_A31LiqNro[0] ;
               A1EmpCod = P01NF3_A1EmpCod[0] ;
               A3CliCod = P01NF3_A3CliCod[0] ;
               A507LiqDCalculado = P01NF3_A507LiqDCalculado[0] ;
               A763LiqDRecalculado = P01NF3_A763LiqDRecalculado[0] ;
               A393DConDescrip = P01NF3_A393DConDescrip[0] ;
               A269LiqDCanti = P01NF3_A269LiqDCanti[0] ;
               n269LiqDCanti = P01NF3_n269LiqDCanti[0] ;
               A81LiqDSecuencial = P01NF3_A81LiqDSecuencial[0] ;
               AV41GXLvl31 = (byte)(1) ;
               GXv_int5[0] = AV17auxLiqDCalculado ;
               new web.dependenciaresuelta2(remoteHandle, context).execute( AV9CliCod, A394DConCodigo, AV16ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
               licencias_sin_plus2.this.AV17auxLiqDCalculado = GXv_int5[0] ;
               if ( AV17auxLiqDCalculado == 0 )
               {
                  AV18LiqDCalculado = (byte)(0) ;
                  AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A393DConDescrip) ;
                  AV15LiqDLog = AV19error ;
                  pr_default.close(1);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV24cantidadCalculada = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV24cantidadCalculada).add(A269LiqDCanti))) ;
               if ( ! (GXutil.strcmp("", AV37cantidadLiqDLog)==0) )
               {
                  AV37cantidadLiqDLog += ", " ;
               }
               AV37cantidadLiqDLog += GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
               pr_default.readNext(1);
            }
            pr_default.close(1);
            if ( AV41GXLvl31 == 0 )
            {
               AV37cantidadLiqDLog = httpContext.getMessage( "No hay registros de condición \"", "") + web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV12DConCondicion) + httpContext.getMessage( " y distintos a \"Vacaciones\"", "") ;
            }
         }
         else
         {
            AV42GXLvl56 = (byte)(0) ;
            /* Using cursor P01NF4 */
            pr_default.execute(2, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LiqNro), Integer.valueOf(AV11LegNumero), AV12DConCondicion});
            while ( (pr_default.getStatus(2) != 101) )
            {
               A1487DConCondicion = P01NF4_A1487DConCondicion[0] ;
               A6LegNumero = P01NF4_A6LegNumero[0] ;
               A31LiqNro = P01NF4_A31LiqNro[0] ;
               A1EmpCod = P01NF4_A1EmpCod[0] ;
               A3CliCod = P01NF4_A3CliCod[0] ;
               A394DConCodigo = P01NF4_A394DConCodigo[0] ;
               A507LiqDCalculado = P01NF4_A507LiqDCalculado[0] ;
               A763LiqDRecalculado = P01NF4_A763LiqDRecalculado[0] ;
               A393DConDescrip = P01NF4_A393DConDescrip[0] ;
               A269LiqDCanti = P01NF4_A269LiqDCanti[0] ;
               n269LiqDCanti = P01NF4_n269LiqDCanti[0] ;
               A81LiqDSecuencial = P01NF4_A81LiqDSecuencial[0] ;
               AV42GXLvl56 = (byte)(1) ;
               GXv_int5[0] = AV17auxLiqDCalculado ;
               new web.dependenciaresuelta2(remoteHandle, context).execute( AV9CliCod, A394DConCodigo, AV16ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int5) ;
               licencias_sin_plus2.this.AV17auxLiqDCalculado = GXv_int5[0] ;
               if ( AV17auxLiqDCalculado == 0 )
               {
                  AV18LiqDCalculado = (byte)(0) ;
                  AV19error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A393DConDescrip) ;
                  AV15LiqDLog = AV19error ;
                  pr_default.close(2);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV24cantidadCalculada = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV24cantidadCalculada).add(A269LiqDCanti))) ;
               if ( ! (GXutil.strcmp("", AV37cantidadLiqDLog)==0) )
               {
                  AV37cantidadLiqDLog += ", " ;
               }
               AV37cantidadLiqDLog += GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) ;
               pr_default.readNext(2);
            }
            pr_default.close(2);
            if ( AV42GXLvl56 == 0 )
            {
               AV37cantidadLiqDLog = httpContext.getMessage( "No hay registros de condición \"", "") + web.gxdomaincondicionliquidacion.getDescription(httpContext,(String)AV12DConCondicion) ;
            }
         }
      }
      if ( AV24cantidadCalculada == 0 )
      {
         AV18LiqDCalculado = (byte)(0) ;
         AV19error = httpContext.getMessage( "Error al calcular cantidad (", "") + GXutil.trim( AV37cantidadLiqDLog) + ")" ;
      }
      else
      {
         if ( GXutil.strcmp(AV12DConCondicion, "B1") == 0 )
         {
            AV33operandos = "[remuneracion_licencia]" ;
         }
         else if ( GXutil.strcmp(AV12DConCondicion, "B5") == 0 )
         {
            AV33operandos = "[feriados_no_trabajados]" ;
         }
         else
         {
            AV33operandos = "[no_laborables]" ;
         }
         GXv_decimal6[0] = AV20Importes ;
         GXv_decimal7[0] = DecimalUtil.doubleToDec(0) ;
         GXv_char4[0] = AV31auxError ;
         GXv_int5[0] = AV17auxLiqDCalculado ;
         GXv_char3[0] = AV32auxLiqDLog ;
         new web.remuneracion_sin_goce(remoteHandle, context).execute( AV9CliCod, AV8EmpCod, AV10LiqNro, AV36LiqRelNro, AV11LegNumero, AV26ConCodigo, AV12DConCondicion, AV33operandos, DecimalUtil.doubleToDec(AV24cantidadCalculada), AV27LiqPeriodo, GXutil.dadd( AV27LiqPeriodo, (1)), "", AV29LegClase, AV16ProcesoLiquidacion, AV35llamador, false, AV14vacacionesEs, GXv_decimal6, GXv_decimal7, GXv_char4, GXv_int5, GXv_char3) ;
         licencias_sin_plus2.this.AV20Importes = GXv_decimal6[0] ;
         licencias_sin_plus2.this.AV31auxError = GXv_char4[0] ;
         licencias_sin_plus2.this.AV17auxLiqDCalculado = GXv_int5[0] ;
         licencias_sin_plus2.this.AV32auxLiqDLog = GXv_char3[0] ;
         if ( AV17auxLiqDCalculado == 0 )
         {
            AV18LiqDCalculado = (byte)(0) ;
            AV19error = AV31auxError ;
            AV15LiqDLog = AV19error ;
         }
         AV15LiqDLog = AV32auxLiqDLog ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = licencias_sin_plus2.this.AV20Importes;
      this.aP13[0] = licencias_sin_plus2.this.AV19error;
      this.aP14[0] = licencias_sin_plus2.this.AV15LiqDLog;
      this.aP15[0] = licencias_sin_plus2.this.AV18LiqDCalculado;
      this.aP16[0] = licencias_sin_plus2.this.AV24cantidadCalculada;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV20Importes = DecimalUtil.ZERO ;
      AV19error = "" ;
      AV15LiqDLog = "" ;
      AV13vacConCodigo = "" ;
      GXt_char1 = "" ;
      GXt_char2 = "" ;
      scmdbuf = "" ;
      P01NF2_A1487DConCondicion = new String[] {""} ;
      P01NF2_A394DConCodigo = new String[] {""} ;
      P01NF2_A6LegNumero = new int[1] ;
      P01NF2_A31LiqNro = new int[1] ;
      P01NF2_A1EmpCod = new short[1] ;
      P01NF2_A3CliCod = new int[1] ;
      P01NF2_A507LiqDCalculado = new byte[1] ;
      P01NF2_A763LiqDRecalculado = new short[1] ;
      P01NF2_A393DConDescrip = new String[] {""} ;
      P01NF2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NF2_n269LiqDCanti = new boolean[] {false} ;
      P01NF2_A81LiqDSecuencial = new int[1] ;
      A1487DConCondicion = "" ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      AV37cantidadLiqDLog = "" ;
      P01NF3_A1487DConCondicion = new String[] {""} ;
      P01NF3_A394DConCodigo = new String[] {""} ;
      P01NF3_A6LegNumero = new int[1] ;
      P01NF3_A31LiqNro = new int[1] ;
      P01NF3_A1EmpCod = new short[1] ;
      P01NF3_A3CliCod = new int[1] ;
      P01NF3_A507LiqDCalculado = new byte[1] ;
      P01NF3_A763LiqDRecalculado = new short[1] ;
      P01NF3_A393DConDescrip = new String[] {""} ;
      P01NF3_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NF3_n269LiqDCanti = new boolean[] {false} ;
      P01NF3_A81LiqDSecuencial = new int[1] ;
      P01NF4_A1487DConCondicion = new String[] {""} ;
      P01NF4_A6LegNumero = new int[1] ;
      P01NF4_A31LiqNro = new int[1] ;
      P01NF4_A1EmpCod = new short[1] ;
      P01NF4_A3CliCod = new int[1] ;
      P01NF4_A394DConCodigo = new String[] {""} ;
      P01NF4_A507LiqDCalculado = new byte[1] ;
      P01NF4_A763LiqDRecalculado = new short[1] ;
      P01NF4_A393DConDescrip = new String[] {""} ;
      P01NF4_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01NF4_n269LiqDCanti = new boolean[] {false} ;
      P01NF4_A81LiqDSecuencial = new int[1] ;
      AV33operandos = "" ;
      GXv_decimal6 = new java.math.BigDecimal[1] ;
      GXv_decimal7 = new java.math.BigDecimal[1] ;
      AV31auxError = "" ;
      GXv_char4 = new String[1] ;
      GXv_int5 = new byte[1] ;
      AV32auxLiqDLog = "" ;
      GXv_char3 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.licencias_sin_plus2__default(),
         new Object[] {
             new Object[] {
            P01NF2_A1487DConCondicion, P01NF2_A394DConCodigo, P01NF2_A6LegNumero, P01NF2_A31LiqNro, P01NF2_A1EmpCod, P01NF2_A3CliCod, P01NF2_A507LiqDCalculado, P01NF2_A763LiqDRecalculado, P01NF2_A393DConDescrip, P01NF2_A269LiqDCanti,
            P01NF2_n269LiqDCanti, P01NF2_A81LiqDSecuencial
            }
            , new Object[] {
            P01NF3_A1487DConCondicion, P01NF3_A394DConCodigo, P01NF3_A6LegNumero, P01NF3_A31LiqNro, P01NF3_A1EmpCod, P01NF3_A3CliCod, P01NF3_A507LiqDCalculado, P01NF3_A763LiqDRecalculado, P01NF3_A393DConDescrip, P01NF3_A269LiqDCanti,
            P01NF3_n269LiqDCanti, P01NF3_A81LiqDSecuencial
            }
            , new Object[] {
            P01NF4_A1487DConCondicion, P01NF4_A6LegNumero, P01NF4_A31LiqNro, P01NF4_A1EmpCod, P01NF4_A3CliCod, P01NF4_A394DConCodigo, P01NF4_A507LiqDCalculado, P01NF4_A763LiqDRecalculado, P01NF4_A393DConDescrip, P01NF4_A269LiqDCanti,
            P01NF4_n269LiqDCanti, P01NF4_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV18LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte AV17auxLiqDCalculado ;
   private byte AV41GXLvl31 ;
   private byte AV42GXLvl56 ;
   private byte AV29LegClase ;
   private byte GXv_int5[] ;
   private short AV8EmpCod ;
   private short AV24cantidadCalculada ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV10LiqNro ;
   private int AV36LiqRelNro ;
   private int AV11LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV20Importes ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal GXv_decimal6[] ;
   private java.math.BigDecimal GXv_decimal7[] ;
   private String AV26ConCodigo ;
   private String AV12DConCondicion ;
   private String AV16ProcesoLiquidacion ;
   private String AV35llamador ;
   private String AV13vacConCodigo ;
   private String GXt_char1 ;
   private String GXt_char2 ;
   private String scmdbuf ;
   private String A1487DConCondicion ;
   private String A394DConCodigo ;
   private String AV33operandos ;
   private String GXv_char4[] ;
   private String GXv_char3[] ;
   private java.util.Date AV27LiqPeriodo ;
   private boolean AV14vacacionesEs ;
   private boolean AV25distintoEs ;
   private boolean n269LiqDCanti ;
   private boolean returnInSub ;
   private String AV15LiqDLog ;
   private String AV37cantidadLiqDLog ;
   private String AV32auxLiqDLog ;
   private String AV19error ;
   private String A393DConDescrip ;
   private String AV31auxError ;
   private short[] aP16 ;
   private java.math.BigDecimal[] aP12 ;
   private String[] aP13 ;
   private String[] aP14 ;
   private byte[] aP15 ;
   private IDataStoreProvider pr_default ;
   private String[] P01NF2_A1487DConCondicion ;
   private String[] P01NF2_A394DConCodigo ;
   private int[] P01NF2_A6LegNumero ;
   private int[] P01NF2_A31LiqNro ;
   private short[] P01NF2_A1EmpCod ;
   private int[] P01NF2_A3CliCod ;
   private byte[] P01NF2_A507LiqDCalculado ;
   private short[] P01NF2_A763LiqDRecalculado ;
   private String[] P01NF2_A393DConDescrip ;
   private java.math.BigDecimal[] P01NF2_A269LiqDCanti ;
   private boolean[] P01NF2_n269LiqDCanti ;
   private int[] P01NF2_A81LiqDSecuencial ;
   private String[] P01NF3_A1487DConCondicion ;
   private String[] P01NF3_A394DConCodigo ;
   private int[] P01NF3_A6LegNumero ;
   private int[] P01NF3_A31LiqNro ;
   private short[] P01NF3_A1EmpCod ;
   private int[] P01NF3_A3CliCod ;
   private byte[] P01NF3_A507LiqDCalculado ;
   private short[] P01NF3_A763LiqDRecalculado ;
   private String[] P01NF3_A393DConDescrip ;
   private java.math.BigDecimal[] P01NF3_A269LiqDCanti ;
   private boolean[] P01NF3_n269LiqDCanti ;
   private int[] P01NF3_A81LiqDSecuencial ;
   private String[] P01NF4_A1487DConCondicion ;
   private int[] P01NF4_A6LegNumero ;
   private int[] P01NF4_A31LiqNro ;
   private short[] P01NF4_A1EmpCod ;
   private int[] P01NF4_A3CliCod ;
   private String[] P01NF4_A394DConCodigo ;
   private byte[] P01NF4_A507LiqDCalculado ;
   private short[] P01NF4_A763LiqDRecalculado ;
   private String[] P01NF4_A393DConDescrip ;
   private java.math.BigDecimal[] P01NF4_A269LiqDCanti ;
   private boolean[] P01NF4_n269LiqDCanti ;
   private int[] P01NF4_A81LiqDSecuencial ;
}

final  class licencias_sin_plus2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01NF2", "SELECT DConCondicion, DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDCanti, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?)) AND (DConCondicion = ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01NF3", "SELECT DConCondicion, DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDCanti, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DConCodigo <> ( ?)) AND (DConCondicion = ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01NF4", "SELECT DConCondicion, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDCanti, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DConCondicion = ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
            case 1 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getString(2, 10);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
            case 2 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((String[]) buf[5])[0] = rslt.getString(6, 10);
               ((byte[]) buf[6])[0] = rslt.getByte(7);
               ((short[]) buf[7])[0] = rslt.getShort(8);
               ((String[]) buf[8])[0] = rslt.getVarchar(9);
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[10])[0] = rslt.wasNull();
               ((int[]) buf[11])[0] = rslt.getInt(11);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 1 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

