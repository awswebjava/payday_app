package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqdimpcalcumejor2 extends GXProcedure
{
   public getliqdimpcalcumejor2( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqdimpcalcumejor2.class ), "" );
   }

   public getliqdimpcalcumejor2( int remoteHandle ,
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
                             String aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             boolean[] aP13 ,
                             java.util.Date[] aP14 ,
                             byte[] aP15 )
   {
      getliqdimpcalcumejor2.this.aP16 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
      return aP16[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        String aP10 ,
                        boolean aP11 ,
                        java.math.BigDecimal[] aP12 ,
                        boolean[] aP13 ,
                        java.util.Date[] aP14 ,
                        byte[] aP15 ,
                        String[] aP16 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             String aP10 ,
                             boolean aP11 ,
                             java.math.BigDecimal[] aP12 ,
                             boolean[] aP13 ,
                             java.util.Date[] aP14 ,
                             byte[] aP15 ,
                             String[] aP16 )
   {
      getliqdimpcalcumejor2.this.AV13CliCod = aP0;
      getliqdimpcalcumejor2.this.AV8EmpCod = aP1;
      getliqdimpcalcumejor2.this.AV9LiqNro = aP2;
      getliqdimpcalcumejor2.this.AV37LiqRelNro = aP3;
      getliqdimpcalcumejor2.this.AV10LegNumero = aP4;
      getliqdimpcalcumejor2.this.AV11ConCodigo = aP5;
      getliqdimpcalcumejor2.this.AV36TipoConCod = aP6;
      getliqdimpcalcumejor2.this.AV26LiqPeriodo = aP7;
      getliqdimpcalcumejor2.this.AV20ProcesoLiquidacion = aP8;
      getliqdimpcalcumejor2.this.AV25semestre = aP9;
      getliqdimpcalcumejor2.this.AV38busquedaTLiqCod = aP10;
      getliqdimpcalcumejor2.this.AV34calcularCantidad = aP11;
      getliqdimpcalcumejor2.this.aP12 = aP12;
      getliqdimpcalcumejor2.this.aP13 = aP13;
      getliqdimpcalcumejor2.this.aP14 = aP14;
      getliqdimpcalcumejor2.this.aP15 = aP15;
      getliqdimpcalcumejor2.this.aP16 = aP16;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      if ( ! AV25semestre )
      {
         AV19comienzoFecha = localUtil.ymdtod( GXutil.year( AV26LiqPeriodo), 1, 1) ;
      }
      else
      {
         GXv_date1[0] = AV19comienzoFecha ;
         GXv_date2[0] = AV27date ;
         new web.rangofechassac(remoteHandle, context).execute( AV26LiqPeriodo, GXv_date1, GXv_date2) ;
         getliqdimpcalcumejor2.this.AV19comienzoFecha = GXv_date1[0] ;
         getliqdimpcalcumejor2.this.AV27date = GXv_date2[0] ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, "1") ;
      AV24agregoPeriodoPropio = false ;
      AV15LiqDCalculado = (byte)(1) ;
      new web.dependenciasesion(remoteHandle, context).execute( AV11ConCodigo) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &ConCodigo ", "")+GXutil.trim( AV11ConCodigo)+httpContext.getMessage( " &LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( AV26LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &comienzoFecha ", "")+GXutil.trim( localUtil.dtoc( AV19comienzoFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " calcular cantidad ", "")+GXutil.trim( GXutil.booltostr( AV34calcularCantidad))) ;
      AV42GXLvl17 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV11ConCodigo ,
                                           AV38busquedaTLiqCod ,
                                           A394DConCodigo ,
                                           A464DTipoConCod ,
                                           AV36TipoConCod ,
                                           A400DTLiqCod ,
                                           A397DLiqPeriodo ,
                                           AV26LiqPeriodo ,
                                           AV19comienzoFecha ,
                                           Integer.valueOf(A2112LiqRelNro) ,
                                           Integer.valueOf(AV37LiqRelNro) ,
                                           Integer.valueOf(AV13CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01ZA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV10LegNumero), AV26LiqPeriodo, AV19comienzoFecha, Integer.valueOf(AV37LiqRelNro), AV11ConCodigo, AV36TipoConCod, AV38busquedaTLiqCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         brk1ZA2 = false ;
         A269LiqDCanti = P01ZA2_A269LiqDCanti[0] ;
         n269LiqDCanti = P01ZA2_n269LiqDCanti[0] ;
         A764LiqDImpReCalcu = P01ZA2_A764LiqDImpReCalcu[0] ;
         A507LiqDCalculado = P01ZA2_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01ZA2_A763LiqDRecalculado[0] ;
         A31LiqNro = P01ZA2_A31LiqNro[0] ;
         A397DLiqPeriodo = P01ZA2_A397DLiqPeriodo[0] ;
         A394DConCodigo = P01ZA2_A394DConCodigo[0] ;
         A6LegNumero = P01ZA2_A6LegNumero[0] ;
         A1EmpCod = P01ZA2_A1EmpCod[0] ;
         A3CliCod = P01ZA2_A3CliCod[0] ;
         A2112LiqRelNro = P01ZA2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01ZA2_n2112LiqRelNro[0] ;
         A400DTLiqCod = P01ZA2_A400DTLiqCod[0] ;
         A464DTipoConCod = P01ZA2_A464DTipoConCod[0] ;
         A81LiqDSecuencial = P01ZA2_A81LiqDSecuencial[0] ;
         A2112LiqRelNro = P01ZA2_A2112LiqRelNro[0] ;
         n2112LiqRelNro = P01ZA2_n2112LiqRelNro[0] ;
         AV42GXLvl17 = (byte)(1) ;
         AV14existe = true ;
         AV31LiqDImpReCalcu = DecimalUtil.ZERO ;
         while ( (pr_default.getStatus(0) != 101) && ( P01ZA2_A3CliCod[0] == A3CliCod ) && ( P01ZA2_A1EmpCod[0] == A1EmpCod ) && ( P01ZA2_A6LegNumero[0] == A6LegNumero ) && ( GXutil.strcmp(P01ZA2_A394DConCodigo[0], A394DConCodigo) == 0 ) )
         {
            if ( ! ( GXutil.dateCompare(GXutil.resetTime(P01ZA2_A397DLiqPeriodo[0]), GXutil.resetTime(A397DLiqPeriodo)) ) )
            {
               if (true) break;
            }
            brk1ZA2 = false ;
            A269LiqDCanti = P01ZA2_A269LiqDCanti[0] ;
            n269LiqDCanti = P01ZA2_n269LiqDCanti[0] ;
            A764LiqDImpReCalcu = P01ZA2_A764LiqDImpReCalcu[0] ;
            A507LiqDCalculado = P01ZA2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P01ZA2_A763LiqDRecalculado[0] ;
            A31LiqNro = P01ZA2_A31LiqNro[0] ;
            A81LiqDSecuencial = P01ZA2_A81LiqDSecuencial[0] ;
            if ( AV34calcularCantidad )
            {
               AV31LiqDImpReCalcu = AV31LiqDImpReCalcu.add(A269LiqDCanti) ;
            }
            else
            {
               AV31LiqDImpReCalcu = AV31LiqDImpReCalcu.add(A764LiqDImpReCalcu) ;
            }
            GXv_int3[0] = AV15LiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, AV20ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
            getliqdimpcalcumejor2.this.AV15LiqDCalculado = GXv_int3[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " liqnro ", "")+GXutil.trim( GXutil.str( A31LiqNro, 8, 0))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV12LiqDImpCalcu, 14, 2))+httpContext.getMessage( " liqdcalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " liqdrecalculado ", "")+GXutil.trim( GXutil.str( A763LiqDRecalculado, 4, 0))+httpContext.getMessage( " &liqdcalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))) ;
            if ( AV15LiqDCalculado == 0 )
            {
               AV28error = httpContext.getMessage( "No calculado en liquidación nro ", "") + GXutil.trim( GXutil.str( A31LiqNro, 8, 0)) ;
               new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&error ", "")+AV28error) ;
               pr_default.close(0);
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV35auxLiqDImpReCalcu = AV31LiqDImpReCalcu ;
            if ( ! AV34calcularCantidad )
            {
               GXv_decimal4[0] = AV35auxLiqDImpReCalcu ;
               GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
               GXv_char6[0] = "" ;
               new web.ajustar(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, A394DConCodigo, GXv_decimal4, GXv_decimal5, GXv_char6) ;
               getliqdimpcalcumejor2.this.AV35auxLiqDImpReCalcu = GXv_decimal4[0] ;
            }
            else
            {
               GXv_decimal5[0] = DecimalUtil.doubleToDec(0) ;
               GXv_decimal4[0] = AV35auxLiqDImpReCalcu ;
               GXv_char6[0] = "" ;
               new web.ajustar(remoteHandle, context).execute( A3CliCod, A1EmpCod, A31LiqNro, A6LegNumero, A394DConCodigo, GXv_decimal5, GXv_decimal4, GXv_char6) ;
               getliqdimpcalcumejor2.this.AV35auxLiqDImpReCalcu = GXv_decimal4[0] ;
            }
            AV31LiqDImpReCalcu = AV35auxLiqDImpReCalcu ;
            if ( A31LiqNro == AV9LiqNro )
            {
               AV24agregoPeriodoPropio = true ;
            }
            brk1ZA2 = true ;
            pr_default.readNext(0);
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV12LiqDImpCalcu, 14, 2))+httpContext.getMessage( " LiqPeriodo ", "")+GXutil.trim( localUtil.dtoc( A397DLiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         if ( DecimalUtil.compareTo(AV31LiqDImpReCalcu, AV30mejorLiqDImpCalcu) > 0 )
         {
            AV30mejorLiqDImpCalcu = AV31LiqDImpReCalcu ;
            AV29mejorLiqPeriodo = A397DLiqPeriodo ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "mejor", "")) ;
         }
         if ( ! brk1ZA2 )
         {
            brk1ZA2 = true ;
            pr_default.readNext(0);
         }
      }
      pr_default.close(0);
      if ( AV42GXLvl17 == 0 )
      {
         AV28error = httpContext.getMessage( "Sin registro desde el ", "") + GXutil.trim( localUtil.dtoc( AV19comienzoFecha, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " hasta el ", "") + GXutil.trim( localUtil.dtoc( AV26LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/")) + httpContext.getMessage( " para el concepto ", "") + GXutil.trim( AV11ConCodigo) + httpContext.getMessage( " legajo ", "") + GXutil.trim( GXutil.str( AV13CliCod, 6, 0)) + "/" + GXutil.trim( GXutil.str( AV8EmpCod, 4, 0)) + "/" + GXutil.trim( GXutil.str( AV10LegNumero, 8, 0)) + httpContext.getMessage( ". Concepto \"", "") + AV11ConCodigo + "\"" ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, AV28error) ;
         AV15LiqDCalculado = (byte)(0) ;
      }
      if ( ( AV15LiqDCalculado == 1 ) && ! AV24agregoPeriodoPropio && ( GXutil.strcmp(AV20ProcesoLiquidacion, "Calculo") == 0 ) )
      {
         AV15LiqDCalculado = (byte)(0) ;
         AV28error = httpContext.getMessage( "No se pudo calcular en liquidación actual", "") ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV41Pgmname, httpContext.getMessage( "&LiqDCalculad ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " &agregoPeriodoPropio ", "")+GXutil.trim( GXutil.booltostr( AV24agregoPeriodoPropio))+httpContext.getMessage( " fecha ", "")+GXutil.trim( localUtil.dtoc( AV26LiqPeriodo, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &ProcesoLiquidacion ", "")+GXutil.trim( AV20ProcesoLiquidacion)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP12[0] = getliqdimpcalcumejor2.this.AV30mejorLiqDImpCalcu;
      this.aP13[0] = getliqdimpcalcumejor2.this.AV14existe;
      this.aP14[0] = getliqdimpcalcumejor2.this.AV29mejorLiqPeriodo;
      this.aP15[0] = getliqdimpcalcumejor2.this.AV15LiqDCalculado;
      this.aP16[0] = getliqdimpcalcumejor2.this.AV28error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV30mejorLiqDImpCalcu = DecimalUtil.ZERO ;
      AV29mejorLiqPeriodo = GXutil.nullDate() ;
      AV28error = "" ;
      AV19comienzoFecha = GXutil.nullDate() ;
      GXv_date1 = new java.util.Date[1] ;
      AV27date = GXutil.nullDate() ;
      GXv_date2 = new java.util.Date[1] ;
      AV41Pgmname = "" ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      P01ZA2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZA2_n269LiqDCanti = new boolean[] {false} ;
      P01ZA2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZA2_A507LiqDCalculado = new byte[1] ;
      P01ZA2_A763LiqDRecalculado = new short[1] ;
      P01ZA2_A31LiqNro = new int[1] ;
      P01ZA2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01ZA2_A394DConCodigo = new String[] {""} ;
      P01ZA2_A6LegNumero = new int[1] ;
      P01ZA2_A1EmpCod = new short[1] ;
      P01ZA2_A3CliCod = new int[1] ;
      P01ZA2_A2112LiqRelNro = new int[1] ;
      P01ZA2_n2112LiqRelNro = new boolean[] {false} ;
      P01ZA2_A400DTLiqCod = new String[] {""} ;
      P01ZA2_A464DTipoConCod = new String[] {""} ;
      P01ZA2_A81LiqDSecuencial = new int[1] ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV31LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV12LiqDImpCalcu = DecimalUtil.ZERO ;
      AV35auxLiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_decimal5 = new java.math.BigDecimal[1] ;
      GXv_decimal4 = new java.math.BigDecimal[1] ;
      GXv_char6 = new String[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqdimpcalcumejor2__default(),
         new Object[] {
             new Object[] {
            P01ZA2_A269LiqDCanti, P01ZA2_n269LiqDCanti, P01ZA2_A764LiqDImpReCalcu, P01ZA2_A507LiqDCalculado, P01ZA2_A763LiqDRecalculado, P01ZA2_A31LiqNro, P01ZA2_A397DLiqPeriodo, P01ZA2_A394DConCodigo, P01ZA2_A6LegNumero, P01ZA2_A1EmpCod,
            P01ZA2_A3CliCod, P01ZA2_A2112LiqRelNro, P01ZA2_n2112LiqRelNro, P01ZA2_A400DTLiqCod, P01ZA2_A464DTipoConCod, P01ZA2_A81LiqDSecuencial
            }
         }
      );
      AV41Pgmname = "getLiqDImpCalcuMejor2" ;
      /* GeneXus formulas. */
      AV41Pgmname = "getLiqDImpCalcuMejor2" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV42GXLvl17 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV9LiqNro ;
   private int AV37LiqRelNro ;
   private int AV10LegNumero ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A31LiqNro ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV30mejorLiqDImpCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV31LiqDImpReCalcu ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV35auxLiqDImpReCalcu ;
   private java.math.BigDecimal GXv_decimal5[] ;
   private java.math.BigDecimal GXv_decimal4[] ;
   private String AV11ConCodigo ;
   private String AV36TipoConCod ;
   private String AV20ProcesoLiquidacion ;
   private String AV38busquedaTLiqCod ;
   private String AV41Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A400DTLiqCod ;
   private String GXv_char6[] ;
   private java.util.Date AV26LiqPeriodo ;
   private java.util.Date AV29mejorLiqPeriodo ;
   private java.util.Date AV19comienzoFecha ;
   private java.util.Date GXv_date1[] ;
   private java.util.Date AV27date ;
   private java.util.Date GXv_date2[] ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV25semestre ;
   private boolean AV34calcularCantidad ;
   private boolean AV14existe ;
   private boolean AV24agregoPeriodoPropio ;
   private boolean brk1ZA2 ;
   private boolean n269LiqDCanti ;
   private boolean n2112LiqRelNro ;
   private boolean returnInSub ;
   private String AV28error ;
   private String[] aP16 ;
   private java.math.BigDecimal[] aP12 ;
   private boolean[] aP13 ;
   private java.util.Date[] aP14 ;
   private byte[] aP15 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01ZA2_A269LiqDCanti ;
   private boolean[] P01ZA2_n269LiqDCanti ;
   private java.math.BigDecimal[] P01ZA2_A764LiqDImpReCalcu ;
   private byte[] P01ZA2_A507LiqDCalculado ;
   private short[] P01ZA2_A763LiqDRecalculado ;
   private int[] P01ZA2_A31LiqNro ;
   private java.util.Date[] P01ZA2_A397DLiqPeriodo ;
   private String[] P01ZA2_A394DConCodigo ;
   private int[] P01ZA2_A6LegNumero ;
   private short[] P01ZA2_A1EmpCod ;
   private int[] P01ZA2_A3CliCod ;
   private int[] P01ZA2_A2112LiqRelNro ;
   private boolean[] P01ZA2_n2112LiqRelNro ;
   private String[] P01ZA2_A400DTLiqCod ;
   private String[] P01ZA2_A464DTipoConCod ;
   private int[] P01ZA2_A81LiqDSecuencial ;
}

final  class getliqdimpcalcumejor2__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ZA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV11ConCodigo ,
                                          String AV38busquedaTLiqCod ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV36TipoConCod ,
                                          String A400DTLiqCod ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV26LiqPeriodo ,
                                          java.util.Date AV19comienzoFecha ,
                                          int A2112LiqRelNro ,
                                          int AV37LiqRelNro ,
                                          int AV13CliCod ,
                                          short AV8EmpCod ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[9];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT T1.LiqDCanti, T1.LiqDImpReCalcu, T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqNro, T1.DLiqPeriodo, T1.DConCodigo, T1.LegNumero, T1.EmpCod, T1.CliCod, T2.LiqRelNro," ;
      scmdbuf += " T1.DTLiqCod, T1.DTipoConCod, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro" ;
      scmdbuf += " = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo <= ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo >= ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      if ( ! (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV11ConCodigo)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int7[7] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV38busquedaTLiqCod)==0) )
      {
         addWhere(sWhereString, "(T1.DTLiqCod = ( ?))");
      }
      else
      {
         GXv_int7[8] = (byte)(1) ;
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
                  return conditional_P01ZA2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , (java.util.Date)dynConstraints[6] , (java.util.Date)dynConstraints[7] , (java.util.Date)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(2,2);
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
               ((int[]) buf[15])[0] = rslt.getInt(14);
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
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[10]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[11]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[12]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[14]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               return;
      }
   }

}

