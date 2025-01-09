package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class calcular_exentos extends GXProcedure
{
   public calcular_exentos( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( calcular_exentos.class ), "" );
   }

   public calcular_exentos( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           int aP2 ,
                                           int aP3 ,
                                           int aP4 ,
                                           java.util.Date aP5 ,
                                           short aP6 ,
                                           String aP7 ,
                                           String aP8 ,
                                           String aP9 ,
                                           String aP10 ,
                                           boolean aP11 ,
                                           String[] aP12 ,
                                           byte[] aP13 ,
                                           String[] aP14 ,
                                           boolean[] aP15 ,
                                           boolean[] aP16 )
   {
      calcular_exentos.this.aP17 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
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
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        String[] aP12 ,
                        byte[] aP13 ,
                        String[] aP14 ,
                        boolean[] aP15 ,
                        boolean[] aP16 ,
                        java.math.BigDecimal[] aP17 )
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
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             String[] aP12 ,
                             byte[] aP13 ,
                             String[] aP14 ,
                             boolean[] aP15 ,
                             boolean[] aP16 ,
                             java.math.BigDecimal[] aP17 )
   {
      calcular_exentos.this.AV15CliCod = aP0;
      calcular_exentos.this.AV14EmpCod = aP1;
      calcular_exentos.this.AV16LiqNro = aP2;
      calcular_exentos.this.AV46LiqRelNro = aP3;
      calcular_exentos.this.AV17LegNumero = aP4;
      calcular_exentos.this.AV12LiqPeriodo = aP5;
      calcular_exentos.this.AV29DAplIIGG = aP6;
      calcular_exentos.this.AV36LiqDProrr = aP7;
      calcular_exentos.this.AV37DConCodigo = aP8;
      calcular_exentos.this.AV38altaCuotaIdOperando = aP9;
      calcular_exentos.this.AV22ProcesoLiquidacion = aP10;
      calcular_exentos.this.AV35insertandoConceptos = aP11;
      calcular_exentos.this.aP12 = aP12;
      calcular_exentos.this.aP13 = aP13;
      calcular_exentos.this.aP14 = aP14;
      calcular_exentos.this.aP15 = aP15;
      calcular_exentos.this.aP16 = aP16;
      calcular_exentos.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV8LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&DAplIIGG ", "")+GXutil.trim( GXutil.str( AV29DAplIIGG, 4, 0))+httpContext.getMessage( " &LiqDProrr ", "")+GXutil.trim( AV36LiqDProrr)) ;
      /* Using cursor P01942 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV16LiqNro), Integer.valueOf(AV17LegNumero), Short.valueOf(AV29DAplIIGG), AV36LiqDProrr});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1125LiqDProrr = P01942_A1125LiqDProrr[0] ;
         A1122DAplIIGG = P01942_A1122DAplIIGG[0] ;
         n1122DAplIIGG = P01942_n1122DAplIIGG[0] ;
         A6LegNumero = P01942_A6LegNumero[0] ;
         A31LiqNro = P01942_A31LiqNro[0] ;
         A1EmpCod = P01942_A1EmpCod[0] ;
         A3CliCod = P01942_A3CliCod[0] ;
         A394DConCodigo = P01942_A394DConCodigo[0] ;
         A81LiqDSecuencial = P01942_A81LiqDSecuencial[0] ;
         AV42hay = true ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, GXutil.trim( A394DConCodigo)+httpContext.getMessage( " llama a calcularExento &altaCuotaIdOperando ", "")+GXutil.trim( AV38altaCuotaIdOperando)) ;
         GXv_int1[0] = AV23exentoLiqDCalculado ;
         GXv_char2[0] = AV25exentoError ;
         GXv_char3[0] = AV24exentoLiqDLog ;
         GXv_decimal4[0] = AV30ExentoImportes ;
         GXv_decimal5[0] = AV40totalActualImportes ;
         GXv_boolean6[0] = AV41existe ;
         new web.calcularexento(remoteHandle, context).execute( AV15CliCod, AV14EmpCod, AV16LiqNro, AV46LiqRelNro, AV17LegNumero, AV12LiqPeriodo, A394DConCodigo, AV38altaCuotaIdOperando, DecimalUtil.doubleToDec(0), A1122DAplIIGG, AV22ProcesoLiquidacion, GXv_int1, GXv_char2, GXv_char3, GXv_decimal4, GXv_decimal5, GXv_boolean6) ;
         calcular_exentos.this.AV23exentoLiqDCalculado = GXv_int1[0] ;
         calcular_exentos.this.AV25exentoError = GXv_char2[0] ;
         calcular_exentos.this.AV24exentoLiqDLog = GXv_char3[0] ;
         calcular_exentos.this.AV30ExentoImportes = GXv_decimal4[0] ;
         calcular_exentos.this.AV40totalActualImportes = GXv_decimal5[0] ;
         calcular_exentos.this.AV41existe = GXv_boolean6[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, GXutil.trim( A394DConCodigo)+httpContext.getMessage( " &existe ", "")+GXutil.trim( GXutil.booltostr( AV41existe))+httpContext.getMessage( " &ExentoImportes ", "")+GXutil.trim( GXutil.str( AV30ExentoImportes, 14, 2))) ;
         if ( AV41existe )
         {
            if ( GXutil.strcmp(AV36LiqDProrr, "FIJA") == 0 )
            {
               AV44crearRegistroInicial = true ;
            }
            else
            {
               GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
               GXv_boolean6[0] = AV45cuentaExiste ;
               new web.cuentasaldoanterior(remoteHandle, context).execute( AV15CliCod, AV14EmpCod, (short)(GXutil.year( AV12LiqPeriodo)), AV17LegNumero, A394DConCodigo, AV16LiqNro, true, GXv_decimal5, GXv_boolean6) ;
               calcular_exentos.this.AV45cuentaExiste = GXv_boolean6[0] ;
               if ( ! AV45cuentaExiste )
               {
                  AV44crearRegistroInicial = true ;
               }
               else
               {
                  AV44crearRegistroInicial = false ;
               }
            }
            if ( AV44crearRegistroInicial )
            {
               if ( GXutil.strcmp(AV38altaCuotaIdOperando, "{tratamiento_exencion}") == 0 )
               {
                  AV39Importe = DecimalUtil.doubleToDec(0) ;
               }
               else
               {
                  AV39Importe = AV40totalActualImportes ;
               }
               if ( AV23exentoLiqDCalculado == 0 )
               {
                  AV8LiqDCalculado = (byte)(0) ;
                  AV18error = httpContext.getMessage( "Error al calcular exento: ", "") + GXutil.trim( AV25exentoError) ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, AV18error) ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
               AV19LiqDLog += AV24exentoLiqDLog ;
               GXv_decimal5[0] = AV32LiqExenImp ;
               new web.getliqexencion(remoteHandle, context).execute( AV15CliCod, AV14EmpCod, (short)(GXutil.year( AV12LiqPeriodo)), AV16LiqNro, AV17LegNumero, AV29DAplIIGG, A394DConCodigo, GXv_decimal5) ;
               calcular_exentos.this.AV32LiqExenImp = GXv_decimal5[0] ;
               GXv_int1[0] = AV33liqLegLiqDCalculado ;
               GXv_char3[0] = AV34liqLegError ;
               new web.altacuentaliqlegpornovedadbis(remoteHandle, context).execute( AV15CliCod, AV14EmpCod, AV39Importe, AV32LiqExenImp, AV16LiqNro, AV17LegNumero, AV12LiqPeriodo, A394DConCodigo, true, AV29DAplIIGG, A1125LiqDProrr, AV22ProcesoLiquidacion, GXv_int1, GXv_char3) ;
               calcular_exentos.this.AV33liqLegLiqDCalculado = GXv_int1[0] ;
               calcular_exentos.this.AV34liqLegError = GXv_char3[0] ;
               if ( AV33liqLegLiqDCalculado == 0 )
               {
                  AV8LiqDCalculado = (byte)(0) ;
                  AV18error = AV34liqLegError ;
                  new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "error bis ", "")+AV18error) ;
                  pr_default.close(0);
                  returnInSub = true;
                  cleanup();
                  if (true) return;
               }
            }
         }
         AV28totalExentoImportes = AV28totalExentoImportes.add(AV30ExentoImportes) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&totalExentoImportes ", "")+GXutil.trim( GXutil.str( AV28totalExentoImportes, 14, 2))) ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      GXv_char3[0] = AV27exentoConCodigo ;
      new web.getapliiggexencon(remoteHandle, context).execute( AV15CliCod, AV29DAplIIGG, GXv_char3) ;
      calcular_exentos.this.AV27exentoConCodigo = GXv_char3[0] ;
      new web.dependenciasesion(remoteHandle, context).execute( AV27exentoConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&exentoConCodigo ", "")+AV27exentoConCodigo) ;
      if ( ! (GXutil.strcmp("", AV27exentoConCodigo)==0) )
      {
         AV19LiqDLog += httpContext.getMessage( ". Insertando: ", "") + GXutil.trim( GXutil.booltostr( AV35insertandoConceptos)) + httpContext.getMessage( " &totalExentoImportes ", "") + GXutil.trim( GXutil.str( AV28totalExentoImportes, 14, 2)) + httpContext.getMessage( " &ProcesoLiquidacion ", "") + GXutil.trim( AV22ProcesoLiquidacion) ;
         AV51GXLvl76 = (byte)(0) ;
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              AV22ProcesoLiquidacion ,
                                              Byte.valueOf(A507LiqDCalculado) ,
                                              Short.valueOf(A763LiqDRecalculado) ,
                                              Integer.valueOf(AV15CliCod) ,
                                              Short.valueOf(AV14EmpCod) ,
                                              Integer.valueOf(AV16LiqNro) ,
                                              Integer.valueOf(AV17LegNumero) ,
                                              AV27exentoConCodigo ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              A394DConCodigo } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BYTE, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING
                                              }
         });
         /* Using cursor P01943 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV15CliCod), Short.valueOf(AV14EmpCod), Integer.valueOf(AV16LiqNro), Integer.valueOf(AV17LegNumero), AV27exentoConCodigo});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A763LiqDRecalculado = P01943_A763LiqDRecalculado[0] ;
            A507LiqDCalculado = P01943_A507LiqDCalculado[0] ;
            A394DConCodigo = P01943_A394DConCodigo[0] ;
            A6LegNumero = P01943_A6LegNumero[0] ;
            A31LiqNro = P01943_A31LiqNro[0] ;
            A1EmpCod = P01943_A1EmpCod[0] ;
            A3CliCod = P01943_A3CliCod[0] ;
            A275LiqDImpCalcu = P01943_A275LiqDImpCalcu[0] ;
            n275LiqDImpCalcu = P01943_n275LiqDImpCalcu[0] ;
            A764LiqDImpReCalcu = P01943_A764LiqDImpReCalcu[0] ;
            A81LiqDSecuencial = P01943_A81LiqDSecuencial[0] ;
            AV51GXLvl76 = (byte)(1) ;
            if ( GXutil.strcmp(AV22ProcesoLiquidacion, "Calculo") == 0 )
            {
               A507LiqDCalculado = (byte)(1) ;
               A275LiqDImpCalcu = AV28totalExentoImportes ;
               n275LiqDImpCalcu = false ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "clava 1 en ", "")+A394DConCodigo) ;
            }
            else
            {
               A763LiqDRecalculado = (short)(1) ;
            }
            A764LiqDImpReCalcu = AV28totalExentoImportes ;
            AV19LiqDLog += httpContext.getMessage( ". Actualiza ", "") + GXutil.trim( AV27exentoConCodigo) + httpContext.getMessage( " con ", "") + GXutil.trim( GXutil.str( AV28totalExentoImportes, 14, 2)) ;
            /* Using cursor P01944 */
            pr_default.execute(2, new Object[] {Short.valueOf(A763LiqDRecalculado), Byte.valueOf(A507LiqDCalculado), Boolean.valueOf(n275LiqDImpCalcu), A275LiqDImpCalcu, A764LiqDImpReCalcu, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Integer.valueOf(A31LiqNro), Integer.valueOf(A6LegNumero), Integer.valueOf(A81LiqDSecuencial)});
            Application.getSmartCacheProvider(remoteHandle).setUpdated("LiquidacionDetalle");
            pr_default.readNext(1);
         }
         pr_default.close(1);
         if ( AV51GXLvl76 == 0 )
         {
            AV19LiqDLog += httpContext.getMessage( ". No encuentra ", "") + GXutil.trim( AV27exentoConCodigo) + httpContext.getMessage( " en liquidación &LiqNro ", "") + GXutil.str( AV16LiqNro, 8, 0) + httpContext.getMessage( " &CliCod ", "") + GXutil.trim( GXutil.str( AV15CliCod, 6, 0)) + httpContext.getMessage( " &EmpCod ", "") + GXutil.trim( GXutil.str( AV14EmpCod, 4, 0)) + httpContext.getMessage( " &LegNumero ", "") + GXutil.trim( GXutil.str( AV17LegNumero, 8, 0)) + httpContext.getMessage( "&ProcesoLiquidacion ", "") + GXutil.trim( AV22ProcesoLiquidacion) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "none ", "")+GXutil.trim( AV27exentoConCodigo)) ;
         }
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV49Pgmname, httpContext.getMessage( "&LiqDLog ", "")+AV19LiqDLog) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = calcular_exentos.this.AV18error;
      this.aP13[0] = calcular_exentos.this.AV8LiqDCalculado;
      this.aP14[0] = calcular_exentos.this.AV19LiqDLog;
      this.aP15[0] = calcular_exentos.this.AV42hay;
      this.aP16[0] = calcular_exentos.this.AV41existe;
      this.aP17[0] = calcular_exentos.this.AV28totalExentoImportes;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV18error = "" ;
      AV19LiqDLog = "" ;
      AV28totalExentoImportes = DecimalUtil.ZERO ;
      AV49Pgmname = "" ;
      scmdbuf = "" ;
      P01942_A1125LiqDProrr = new String[] {""} ;
      P01942_A1122DAplIIGG = new short[1] ;
      P01942_n1122DAplIIGG = new boolean[] {false} ;
      P01942_A6LegNumero = new int[1] ;
      P01942_A31LiqNro = new int[1] ;
      P01942_A1EmpCod = new short[1] ;
      P01942_A3CliCod = new int[1] ;
      P01942_A394DConCodigo = new String[] {""} ;
      P01942_A81LiqDSecuencial = new int[1] ;
      A1125LiqDProrr = "" ;
      A394DConCodigo = "" ;
      AV25exentoError = "" ;
      GXv_char2 = new String[1] ;
      AV24exentoLiqDLog = "" ;
      AV30ExentoImportes = DecimalUtil.ZERO ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      AV40totalActualImportes = DecimalUtil.ZERO ;
      GXv_boolean6 = new boolean[1] ;
      AV39Importe = DecimalUtil.ZERO ;
      AV32LiqExenImp = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_int1 = new byte[1] ;
      AV34liqLegError = "" ;
      AV27exentoConCodigo = "" ;
      GXv_char3 = new String[1] ;
      P01943_A763LiqDRecalculado = new short[1] ;
      P01943_A507LiqDCalculado = new byte[1] ;
      P01943_A394DConCodigo = new String[] {""} ;
      P01943_A6LegNumero = new int[1] ;
      P01943_A31LiqNro = new int[1] ;
      P01943_A1EmpCod = new short[1] ;
      P01943_A3CliCod = new int[1] ;
      P01943_A275LiqDImpCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01943_n275LiqDImpCalcu = new boolean[] {false} ;
      P01943_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01943_A81LiqDSecuencial = new int[1] ;
      A275LiqDImpCalcu = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.calcular_exentos__default(),
         new Object[] {
             new Object[] {
            P01942_A1125LiqDProrr, P01942_A1122DAplIIGG, P01942_n1122DAplIIGG, P01942_A6LegNumero, P01942_A31LiqNro, P01942_A1EmpCod, P01942_A3CliCod, P01942_A394DConCodigo, P01942_A81LiqDSecuencial
            }
            , new Object[] {
            P01943_A763LiqDRecalculado, P01943_A507LiqDCalculado, P01943_A394DConCodigo, P01943_A6LegNumero, P01943_A31LiqNro, P01943_A1EmpCod, P01943_A3CliCod, P01943_A275LiqDImpCalcu, P01943_n275LiqDImpCalcu, P01943_A764LiqDImpReCalcu,
            P01943_A81LiqDSecuencial
            }
            , new Object[] {
            }
         }
      );
      AV49Pgmname = "calcular_exentos" ;
      /* GeneXus formulas. */
      AV49Pgmname = "calcular_exentos" ;
      Gx_err = (short)(0) ;
   }

   private byte AV8LiqDCalculado ;
   private byte AV23exentoLiqDCalculado ;
   private byte AV33liqLegLiqDCalculado ;
   private byte GXv_int1[] ;
   private byte AV51GXLvl76 ;
   private byte A507LiqDCalculado ;
   private short AV14EmpCod ;
   private short AV29DAplIIGG ;
   private short A1122DAplIIGG ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV15CliCod ;
   private int AV16LiqNro ;
   private int AV46LiqRelNro ;
   private int AV17LegNumero ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV28totalExentoImportes ;
   private java.math.BigDecimal AV30ExentoImportes ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal AV40totalActualImportes ;
   private java.math.BigDecimal AV39Importe ;
   private java.math.BigDecimal AV32LiqExenImp ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal A275LiqDImpCalcu ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV36LiqDProrr ;
   private String AV37DConCodigo ;
   private String AV38altaCuotaIdOperando ;
   private String AV22ProcesoLiquidacion ;
   private String AV49Pgmname ;
   private String scmdbuf ;
   private String A1125LiqDProrr ;
   private String A394DConCodigo ;
   private String GXv_char2[] ;
   private String AV27exentoConCodigo ;
   private String GXv_char3[] ;
   private java.util.Date AV12LiqPeriodo ;
   private boolean AV35insertandoConceptos ;
   private boolean AV42hay ;
   private boolean AV41existe ;
   private boolean n1122DAplIIGG ;
   private boolean AV44crearRegistroInicial ;
   private boolean AV45cuentaExiste ;
   private boolean GXv_boolean6[] ;
   private boolean returnInSub ;
   private boolean n275LiqDImpCalcu ;
   private String AV19LiqDLog ;
   private String AV24exentoLiqDLog ;
   private String AV18error ;
   private String AV25exentoError ;
   private String AV34liqLegError ;
   private java.math.BigDecimal[] aP17 ;
   private String[] aP12 ;
   private byte[] aP13 ;
   private String[] aP14 ;
   private boolean[] aP15 ;
   private boolean[] aP16 ;
   private IDataStoreProvider pr_default ;
   private String[] P01942_A1125LiqDProrr ;
   private short[] P01942_A1122DAplIIGG ;
   private boolean[] P01942_n1122DAplIIGG ;
   private int[] P01942_A6LegNumero ;
   private int[] P01942_A31LiqNro ;
   private short[] P01942_A1EmpCod ;
   private int[] P01942_A3CliCod ;
   private String[] P01942_A394DConCodigo ;
   private int[] P01942_A81LiqDSecuencial ;
   private short[] P01943_A763LiqDRecalculado ;
   private byte[] P01943_A507LiqDCalculado ;
   private String[] P01943_A394DConCodigo ;
   private int[] P01943_A6LegNumero ;
   private int[] P01943_A31LiqNro ;
   private short[] P01943_A1EmpCod ;
   private int[] P01943_A3CliCod ;
   private java.math.BigDecimal[] P01943_A275LiqDImpCalcu ;
   private boolean[] P01943_n275LiqDImpCalcu ;
   private java.math.BigDecimal[] P01943_A764LiqDImpReCalcu ;
   private int[] P01943_A81LiqDSecuencial ;
}

final  class calcular_exentos__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01943( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV22ProcesoLiquidacion ,
                                          byte A507LiqDCalculado ,
                                          short A763LiqDRecalculado ,
                                          int AV15CliCod ,
                                          short AV14EmpCod ,
                                          int AV16LiqNro ,
                                          int AV17LegNumero ,
                                          String AV27exentoConCodigo ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero ,
                                          String A394DConCodigo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[5];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT LiqDRecalculado, LiqDCalculado, DConCodigo, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpCalcu, LiqDImpReCalcu, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DConCodigo = ( ?))");
      if ( GXutil.strcmp(AV22ProcesoLiquidacion, "Calculo") == 0 )
      {
         addWhere(sWhereString, "(LiqDCalculado = 0 or LiqDCalculado = 4)");
      }
      if ( GXutil.strcmp(AV22ProcesoLiquidacion, "Recalculo") == 0 )
      {
         addWhere(sWhereString, "(LiqDRecalculado = 0)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DConCodigo" ;
      scmdbuf += " FOR UPDATE OF LiquidacionDetalle" ;
      GXv_Object8[0] = scmdbuf ;
      GXv_Object8[1] = GXv_int7 ;
      return GXv_Object8 ;
   }

   public Object [] getDynamicStatement( int cursor ,
                                         ModelContext context ,
                                         int remoteHandle ,
                                         com.genexus.IHttpContext httpContext ,
                                         Object [] dynConstraints )
   {
      switch ( cursor )
      {
            case 1 :
                  return conditional_P01943(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Number) dynConstraints[1]).byteValue() , ((Number) dynConstraints[2]).shortValue() , ((Number) dynConstraints[3]).intValue() , ((Number) dynConstraints[4]).shortValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).intValue() , (String)dynConstraints[7] , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , (String)dynConstraints[12] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01942", "SELECT LiqDProrr, DAplIIGG, LegNumero, LiqNro, EmpCod, CliCod, DConCodigo, LiqDSecuencial FROM LiquidacionDetalle WHERE (CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?) AND (DAplIIGG = ?) AND (LiqDProrr = ( ?)) ORDER BY CliCod, EmpCod, LiqNro, LegNumero ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01943", "scmdbuf",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new UpdateCursor("P01944", "SAVEPOINT gxupdate;UPDATE LiquidacionDetalle SET LiqDRecalculado=?, LiqDCalculado=?, LiqDImpCalcu=?, LiqDImpReCalcu=?  WHERE CliCod = ? AND EmpCod = ? AND LiqNro = ? AND LegNumero = ? AND LiqDSecuencial = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((String[]) buf[2])[0] = rslt.getString(3, 10);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
               ((short[]) buf[5])[0] = rslt.getShort(6);
               ((int[]) buf[6])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(9,2);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      short sIdx;
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setInt(4, ((Number) parms[3]).intValue());
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setString(6, (String)parms[5], 20);
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[9], 10);
               }
               return;
            case 2 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               if ( ((Boolean) parms[2]).booleanValue() )
               {
                  stmt.setNull( 3 , Types.DECIMAL );
               }
               else
               {
                  stmt.setBigDecimal(3, (java.math.BigDecimal)parms[3], 2);
               }
               stmt.setBigDecimal(4, (java.math.BigDecimal)parms[4], 2);
               stmt.setInt(5, ((Number) parms[5]).intValue());
               stmt.setShort(6, ((Number) parms[6]).shortValue());
               stmt.setInt(7, ((Number) parms[7]).intValue());
               stmt.setInt(8, ((Number) parms[8]).intValue());
               stmt.setInt(9, ((Number) parms[9]).intValue());
               return;
      }
   }

}

