package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcuacumulado3 extends GXProcedure
{
   public getliqdimpcalcuacumulado3( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcuacumulado3.class ), "" );
   }

   public getliqdimpcalcuacumulado3( int remoteHandle ,
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
                             String aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             boolean aP12 ,
                             String aP13 ,
                             boolean aP14 ,
                             String aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             boolean[] aP18 ,
                             short[] aP19 ,
                             byte[] aP20 ,
                             boolean[] aP21 )
   {
      getliqdimpcalcuacumulado3.this.aP22 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
      return aP22[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        java.util.Date aP8 ,
                        String aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        boolean aP12 ,
                        String aP13 ,
                        boolean aP14 ,
                        String aP15 ,
                        java.math.BigDecimal[] aP16 ,
                        java.math.BigDecimal[] aP17 ,
                        boolean[] aP18 ,
                        short[] aP19 ,
                        byte[] aP20 ,
                        boolean[] aP21 ,
                        String[] aP22 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21, aP22);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             java.util.Date aP8 ,
                             String aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             boolean aP12 ,
                             String aP13 ,
                             boolean aP14 ,
                             String aP15 ,
                             java.math.BigDecimal[] aP16 ,
                             java.math.BigDecimal[] aP17 ,
                             boolean[] aP18 ,
                             short[] aP19 ,
                             byte[] aP20 ,
                             boolean[] aP21 ,
                             String[] aP22 )
   {
      getliqdimpcalcuacumulado3.this.AV13CliCod = aP0;
      getliqdimpcalcuacumulado3.this.AV8EmpCod = aP1;
      getliqdimpcalcuacumulado3.this.AV9LiqNro = aP2;
      getliqdimpcalcuacumulado3.this.AV40LiqRelNro = aP3;
      getliqdimpcalcuacumulado3.this.AV10LegNumero = aP4;
      getliqdimpcalcuacumulado3.this.AV11ConCodigo = aP5;
      getliqdimpcalcuacumulado3.this.AV39TipoConCod = aP6;
      getliqdimpcalcuacumulado3.this.AV32desdeFecha = aP7;
      getliqdimpcalcuacumulado3.this.AV26LiqPeriodo = aP8;
      getliqdimpcalcuacumulado3.this.AV37principal_ConCodigo = aP9;
      getliqdimpcalcuacumulado3.this.AV20ProcesoLiquidacion = aP10;
      getliqdimpcalcuacumulado3.this.AV25semestre = aP11;
      getliqdimpcalcuacumulado3.this.AV31existenciaObligada = aP12;
      getliqdimpcalcuacumulado3.this.AV33excluirTLiqCod = aP13;
      getliqdimpcalcuacumulado3.this.AV35incluirLiquidacionActual = aP14;
      getliqdimpcalcuacumulado3.this.AV41busquedaTLiqCod = aP15;
      getliqdimpcalcuacumulado3.this.aP16 = aP16;
      getliqdimpcalcuacumulado3.this.aP17 = aP17;
      getliqdimpcalcuacumulado3.this.aP18 = aP18;
      getliqdimpcalcuacumulado3.this.aP19 = aP19;
      getliqdimpcalcuacumulado3.this.aP20 = aP20;
      getliqdimpcalcuacumulado3.this.aP21 = aP21;
      getliqdimpcalcuacumulado3.this.aP22 = aP22;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! AV25semestre )
      {
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(AV32desdeFecha)) )
         {
            AV19comienzoFecha = localUtil.ymdtod( GXutil.year( AV26LiqPeriodo), 1, 1) ;
         }
         else
         {
            AV19comienzoFecha = AV32desdeFecha ;
         }
      }
      else
      {
         GXv_date1[0] = AV19comienzoFecha ;
         GXv_date2[0] = AV27date ;
         new web.rangofechassac(remoteHandle, context).execute( AV26LiqPeriodo, GXv_date1, GXv_date2) ;
         getliqdimpcalcuacumulado3.this.AV19comienzoFecha = GXv_date1[0] ;
         getliqdimpcalcuacumulado3.this.AV27date = GXv_date2[0] ;
      }
      AV34hasta = AV26LiqPeriodo ;
      AV24agregoPeriodoPropio = false ;
      AV44GXLvl18 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11ConCodigo ,
                                           Boolean.valueOf(AV35incluirLiquidacionActual) ,
                                           Integer.valueOf(AV9LiqNro) ,
                                           AV41busquedaTLiqCod ,
                                           A394DConCodigo ,
                                           A464DTipoConCod ,
                                           AV39TipoConCod ,
                                           Integer.valueOf(A31LiqNro) ,
                                           A400DTLiqCod ,
                                           A397DLiqPeriodo ,
                                           AV34hasta ,
                                           AV19comienzoFecha ,
                                           A32TLiqCod ,
                                           AV33excluirTLiqCod ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(AV40LiqRelNro) ,
                                           Integer.valueOf(AV13CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                           TypeConstants.DATE, TypeConstants.DATE, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01ZB2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV34hasta, AV19comienzoFecha, AV33excluirTLiqCod, Integer.valueOf(AV40LiqRelNro), AV11ConCodigo, AV39TipoConCod, Integer.valueOf(AV9LiqNro), Integer.valueOf(AV9LiqNro), AV41busquedaTLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1ZB2 = false ;
         A764LiqDImpReCalcu = P01ZB2_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P01ZB2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01ZB2_n269LiqDCanti[0] ;
         A507LiqDCalculado = P01ZB2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01ZB2_A763LiqDRecalculado[0] ;
         A31LiqNro = P01ZB2_A31LiqNro[0] ;
         A397DLiqPeriodo = P01ZB2_A397DLiqPeriodo[0] ;
         A394DConCodigo = P01ZB2_A394DConCodigo[0] ;
         A6LegNumero = P01ZB2_A6LegNumero[0] ;
         A1EmpCod = P01ZB2_A1EmpCod[0] ;
         A3CliCod = P01ZB2_A3CliCod[0] ;
         A2112LiqRelNro = P01ZB2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01ZB2_n2112LiqRelNro[0] ;
         A400DTLiqCod = P01ZB2_A400DTLiqCod[0] ;
         A32TLiqCod = P01ZB2_A32TLiqCod[0] ;
         n32TLiqCod = P01ZB2_n32TLiqCod[0] ;
         A464DTipoConCod = P01ZB2_A464DTipoConCod[0] ;
         A81LiqDSecuencial = P01ZB2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01ZB2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01ZB2_n2112LiqRelNro[0] ;
         A32TLiqCod = P01ZB2_A32TLiqCod[0] ;
         n32TLiqCod = P01ZB2_n32TLiqCod[0] ;
         AV44GXLvl18 = (byte)(1) ;
         AV22cantidadPeriodos = (short)(AV22cantidadPeriodos+1) ;
         while ( (pr_default.getStatus(0) != 101) && ( P01ZB2_A3CliCod[0] == A3CliCod ) && ( P01ZB2_A1EmpCod[0] == A1EmpCod ) && ( P01ZB2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01ZB2_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            if ( ! ( GXutil.dateCompare(GXutil.resetTime(P01ZB2_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
            {
               if (true) break;
            }
            brk1ZB2 = false ;
            A764LiqDImpReCalcu = P01ZB2_A764LiqDImpReCalcu[0] ;
            A269LiqDCanti = P01ZB2_A269LiqDCanti[0] ;
            n269LiqDCanti = P01ZB2_n269LiqDCanti[0] ;
            A507LiqDCalculado = P01ZB2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P01ZB2_A763LiqDRecalculado[0] ;
            A31LiqNro = P01ZB2_A31LiqNro[0] ;
            A81LiqDSecuencial = P01ZB2_A81LiqDSecuencial[0] ;
            AV14existe = true ;
            AV29auxLiqDImpCalcu = DecimalUtil.ZERO ;
            AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
            AV36LiqDCanti = AV36LiqDCanti.add(A269LiqDCanti) ;
            GXv_int3[0] = AV15LiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV13CliCod, AV11ConCodigo, AV20ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
            getliqdimpcalcuacumulado3.this.AV15LiqDCalculado = GXv_int3[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV12LiqDImpCalcu, 14, 2))) ;
            if ( AV15LiqDCalculado == 0 )
            {
               AV28error = httpContext.getMessage( "No calculado en liquidación nro ", "") + GXutil.trim( GXutil.str( A31LiqNro, 8, 0)) ;
               pr_default.close(0);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            GXv_decimal4[0] = AV12LiqDImpCalcu ;
            GXv_decimal5[0] = AV36LiqDCanti ;
            GXv_char6[0] = "" ;
            new web.ajustar(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, A394DConCodigo, GXv_decimal4, GXv_decimal5, GXv_char6) ;
            getliqdimpcalcuacumulado3.this.AV12LiqDImpCalcu = GXv_decimal4[0] ;
            getliqdimpcalcuacumulado3.this.AV36LiqDCanti = GXv_decimal5[0] ;
            if ( A31LiqNro == AV9LiqNro )
            {
               AV24agregoPeriodoPropio = true ;
            }
            brk1ZB2 = true ;
            pr_default.readNext(0);
         }
         if ( ! brk1ZB2 )
         {
            brk1ZB2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      if ( AV44GXLvl18 == 0 )
      {
         if ( AV31existenciaObligada )
         {
            AV28error = httpContext.getMessage( "Sin registro desde el ", "") + GXutil.trim( localUtil.dtoc( AV19comienzoFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta el ", "") + GXutil.trim( localUtil.dtoc( AV34hasta, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para el concepto ", "") + GXutil.trim( AV11ConCodigo) + httpContext.getMessage( " legajo ", "") + GXutil.trim( GXutil.str( AV13CliCod, 6, 0)) + "/" + GXutil.trim( GXutil.str( AV8EmpCod, 4, 0)) + "/" + GXutil.trim( GXutil.str( AV10LegNumero, 8, 0)) ;
         }
         else
         {
            AV15LiqDCalculado = (byte)(1) ;
            AV24agregoPeriodoPropio = true ;
         }
      }
      if ( ( AV47Incluirperiodoactual.doubleValue() == ( 1 )) && ( AV15LiqDCalculado == 1 ) && ( GXutil.month( AV26LiqPeriodo) > 1 ) && ! AV24agregoPeriodoPropio && ( GXutil.strcmp(AV20ProcesoLiquidacion, "Calculo") == 0 ) && ( AV31existenciaObligada ) )
      {
         AV15LiqDCalculado = (byte)(0) ;
         AV28error = httpContext.getMessage( "No se pudo calcular en liquidación actual", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV46Pgmname, httpContext.getMessage( "&LiqDCalculad ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " &agregoPeriodoPropio ", "")+GXutil.trim( GXutil.booltostr( AV24agregoPeriodoPropio))+httpContext.getMessage( " fecha ", "")+GXutil.trim( localUtil.dtoc( AV26LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ProcesoLiquidacion ", "")+GXutil.trim( AV20ProcesoLiquidacion)+httpContext.getMessage( " &hasta ", "")+GXutil.trim( localUtil.dtoc( AV34hasta, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP16[0] = getliqdimpcalcuacumulado3.this.AV12LiqDImpCalcu;
      this.aP17[0] = getliqdimpcalcuacumulado3.this.AV36LiqDCanti;
      this.aP18[0] = getliqdimpcalcuacumulado3.this.AV14existe;
      this.aP19[0] = getliqdimpcalcuacumulado3.this.AV22cantidadPeriodos;
      this.aP20[0] = getliqdimpcalcuacumulado3.this.AV15LiqDCalculado;
      this.aP21[0] = getliqdimpcalcuacumulado3.this.AV30actualEsCero;
      this.aP22[0] = getliqdimpcalcuacumulado3.this.AV28error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12LiqDImpCalcu = DecimalUtil.ZERO ;
      AV36LiqDCanti = DecimalUtil.ZERO ;
      AV28error = "" ;
      AV19comienzoFecha = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV27date = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      AV34hasta = GXutil.nullDate() ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      A32TLiqCod = "" ;
      P01ZB2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZB2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZB2_n269LiqDCanti = new boolean[] {false} ;
      P01ZB2_A507LiqDCalculado = new byte[1] ;
      P01ZB2_A763LiqDRecalculado = new short[1] ;
      P01ZB2_A31LiqNro = new int[1] ;
      P01ZB2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01ZB2_A394DConCodigo = new String[] {""} ;
      P01ZB2_A6LegNumero = new int[1] ;
      P01ZB2_A1EmpCod = new short[1] ;
      P01ZB2_A3CliCod = new int[1] ;
      P01ZB2_A2112LiqRelNro = new int[1] ;
      P01ZB2_n2112LiqRelNro = new boolean[] {false} ;
      P01ZB2_A400DTLiqCod = new String[] {""} ;
      P01ZB2_A32TLiqCod = new String[] {""} ;
      P01ZB2_n32TLiqCod = new boolean[] {false} ;
      P01ZB2_A464DTipoConCod = new String[] {""} ;
      P01ZB2_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      AV29auxLiqDImpCalcu = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV46Pgmname = "" ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_char6 = new String[1] ;
      AV47Incluirperiodoactual = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcuacumulado3__default(),
         new Object[] {
             new Object[] {
            P01ZB2_A764LiqDImpReCalcu, P01ZB2_A269LiqDCanti, P01ZB2_n269LiqDCanti, P01ZB2_A507LiqDCalculado, P01ZB2_A763LiqDRecalculado, P01ZB2_A31LiqNro, P01ZB2_A397DLiqPeriodo, P01ZB2_A394DConCodigo, P01ZB2_A6LegNumero, P01ZB2_A1EmpCod,
            P01ZB2_A3CliCod, P01ZB2_A2112LiqRelNro, P01ZB2_n2112LiqRelNro, P01ZB2_A400DTLiqCod, P01ZB2_A32TLiqCod, P01ZB2_n32TLiqCod, P01ZB2_A464DTipoConCod, P01ZB2_A81LiqDSecuencial
            }
         }
      );
      AV46Pgmname = "getLiqDImpCalcuAcumulado3" ;
      /* GeneXus formulas. */
      AV46Pgmname = "getLiqDImpCalcuAcumulado3" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV44GXLvl18 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV8EmpCod ;
   private short AV22cantidadPeriodos ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV40LiqRelNro ;
   private int AV10LegNumero ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV36LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal AV29auxLiqDImpCalcu ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal AV47Incluirperiodoactual ;
   private String AV11ConCodigo ;
   private String AV39TipoConCod ;
   private String AV37principal_ConCodigo ;
   private String AV20ProcesoLiquidacion ;
   private String AV33excluirTLiqCod ;
   private String AV41busquedaTLiqCod ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A400DTLiqCod ;
   private String A32TLiqCod ;
   private String AV46Pgmname ;
   private String GXv_char6[] ;
   private java.util.Date AV32desdeFecha ;
   private java.util.Date AV26LiqPeriodo ;
   private java.util.Date AV19comienzoFecha ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV27date ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date AV34hasta ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV25semestre ;
   private boolean AV31existenciaObligada ;
   private boolean AV35incluirLiquidacionActual ;
   private boolean AV14existe ;
   private boolean AV30actualEsCero ;
   private boolean AV24agregoPeriodoPropio ;
   private boolean brk1ZB2 ;
   private boolean n269LiqDCanti ;
   private boolean n2112LiqRelNro ;
   private boolean n32TLiqCod ;
   private boolean returnInSub ;
   private String AV28error ;
   private String[] aP22 ;
   private java.math.BigDecimal[] aP16 ;
   private java.math.BigDecimal[] aP17 ;
   private boolean[] aP18 ;
   private short[] aP19 ;
   private byte[] aP20 ;
   private boolean[] aP21 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01ZB2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01ZB2_A269LiqDCanti ;
   private boolean[] P01ZB2_n269LiqDCanti ;
   private byte[] P01ZB2_A507LiqDCalculado ;
   private short[] P01ZB2_A763LiqDRecalculado ;
   private int[] P01ZB2_A31LiqNro ;
   private java.util.Date[] P01ZB2_A397DLiqPeriodo ;
   private String[] P01ZB2_A394DConCodigo ;
   private int[] P01ZB2_A6LegNumero ;
   private short[] P01ZB2_A1EmpCod ;
   private int[] P01ZB2_A3CliCod ;
   private int[] P01ZB2_A2112LiqRelNro ;
   private boolean[] P01ZB2_n2112LiqRelNro ;
   private String[] P01ZB2_A400DTLiqCod ;
   private String[] P01ZB2_A32TLiqCod ;
   private boolean[] P01ZB2_n32TLiqCod ;
   private String[] P01ZB2_A464DTipoConCod ;
   private int[] P01ZB2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcuacumulado3__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ZB2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV11ConCodigo ,
                                          boolean AV35incluirLiquidacionActual ,
                                          int AV9LiqNro ,
                                          String AV41busquedaTLiqCod ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV39TipoConCod ,
                                          int A31LiqNro ,
                                          String A400DTLiqCod ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV34hasta ,
                                          java.util.Date AV19comienzoFecha ,
                                          String A32TLiqCod ,
                                          String AV33excluirTLiqCod ,
                                          int A2112LiqRelNro ,
                                          int AV40LiqRelNro ,
                                          int AV13CliCod ,
                                          short AV8EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[12];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.LiqDImpReCalcu, T1.LiqDCanti, T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqNro, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LiqRelNro," ;
      scmdbuf += " T1.DTLiqCod, T2.TLiqCod, T1.DTipoConCod, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod" ;
      scmdbuf += " AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo <= ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo >= ?)");
      addWhere(sWhereString, "(T2.TLiqCod <> ( ?))");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
      }
      if ( ! AV35incluirLiquidacionActual )
      {
         addWhere(sWhereString, "(T1.LiqNro < ?)");
      }
      else
      {
         GXv_int7[9] = (byte)(1) ;
      }
      if ( ! (0==AV9LiqNro) )
      {
         addWhere(sWhereString, "(T1.LiqNro <= ?)");
      }
      else
      {
         GXv_int7[10] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV41busquedaTLiqCod)==0) )
      {
         addWhere(sWhereString, "(T1.DTLiqCod = ( ?))");
      }
      else
      {
         GXv_int7[11] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo" ;
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
            case 0 :
                  return conditional_P01ZB2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , ((Number) dynConstraints[2]).intValue() , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (String)dynConstraints[6] , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , (String)dynConstraints[12] , (String)dynConstraints[13] , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).intValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).shortValue() , ((Number) dynConstraints[18]).intValue() , ((Number) dynConstraints[19]).intValue() , ((Number) dynConstraints[20]).shortValue() , ((Number) dynConstraints[21]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZB2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,2);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((java.util.Date[]) buf[6])[0] = rslt.getGXDate(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 10);
               ((int[]) buf[8])[0] = rslt.getInt(8);
               ((short[]) buf[9])[0] = rslt.getShort(9);
               ((int[]) buf[10])[0] = rslt.getInt(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((String[]) buf[13])[0] = rslt.getString(12, 20);
               ((String[]) buf[14])[0] = rslt.getString(13, 20);
               ((boolean[]) buf[15])[0] = rslt.wasNull();
               ((String[]) buf[16])[0] = rslt.getString(14, 20);
               ((int[]) buf[17])[0] = rslt.getInt(15);
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
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[13]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[15]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[16]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 10);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[20], 20);
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[21]).intValue());
               }
               if ( ((Number) parms[10]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[22]).intValue());
               }
               if ( ((Number) parms[11]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[23], 20);
               }
               return;
      }
   }

}

