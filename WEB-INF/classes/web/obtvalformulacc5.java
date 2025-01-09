package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformulacc5 extends GXProcedure
{
   public obtvalformulacc5( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformulacc5.class ), "" );
   }

   public obtvalformulacc5( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             int aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             java.util.Date aP12 ,
                             java.util.Date aP13 ,
                             String aP14 ,
                             String aP15 ,
                             boolean aP16 ,
                             short[] aP17 ,
                             boolean[] aP18 ,
                             java.math.BigDecimal[] aP19 ,
                             short[] aP20 )
   {
      obtvalformulacc5.this.aP21 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
      return aP21[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        String aP4 ,
                        int aP5 ,
                        int aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        java.util.Date aP12 ,
                        java.util.Date aP13 ,
                        String aP14 ,
                        String aP15 ,
                        boolean aP16 ,
                        short[] aP17 ,
                        boolean[] aP18 ,
                        java.math.BigDecimal[] aP19 ,
                        short[] aP20 ,
                        String[] aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             String aP4 ,
                             int aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             java.util.Date aP12 ,
                             java.util.Date aP13 ,
                             String aP14 ,
                             String aP15 ,
                             boolean aP16 ,
                             short[] aP17 ,
                             boolean[] aP18 ,
                             java.math.BigDecimal[] aP19 ,
                             short[] aP20 ,
                             String[] aP21 )
   {
      obtvalformulacc5.this.AV9CliCod = aP0;
      obtvalformulacc5.this.AV10EmpCod = aP1;
      obtvalformulacc5.this.AV44LiqNro = aP2;
      obtvalformulacc5.this.AV45LiqPeriodo = aP3;
      obtvalformulacc5.this.AV62TLiqCod = aP4;
      obtvalformulacc5.this.AV46LiqRelNro = aP5;
      obtvalformulacc5.this.AV11LegNumero = aP6;
      obtvalformulacc5.this.AV25ConCodigo = aP7;
      obtvalformulacc5.this.AV24ConceptoPar = aP8;
      obtvalformulacc5.this.AV57TipoConCod = aP9;
      obtvalformulacc5.this.AV63busquedaTLiqCod = aP10;
      obtvalformulacc5.this.AV32Devolver = aP11;
      obtvalformulacc5.this.AV34FecDesde = aP12;
      obtvalformulacc5.this.AV35FecHasta = aP13;
      obtvalformulacc5.this.AV51ProcesoLiquidacion = aP14;
      obtvalformulacc5.this.AV8cantidadPalabra = aP15;
      obtvalformulacc5.this.AV33excluirLiquidacionPropia = aP16;
      obtvalformulacc5.this.aP17 = aP17;
      obtvalformulacc5.this.aP18 = aP18;
      obtvalformulacc5.this.aP19 = aP19;
      obtvalformulacc5.this.aP20 = aP20;
      obtvalformulacc5.this.aP21 = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV31dependenciasResueltas = true ;
      AV36ImporteAux = DecimalUtil.ZERO ;
      AV20CantidadAux = (short)(0) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "&ConceptoPar ", "")+GXutil.trim( AV24ConceptoPar)+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV11LegNumero, 8, 0))+httpContext.getMessage( " concodigo ", "")+AV25ConCodigo+httpContext.getMessage( " &TipoConCod ", "")+AV57TipoConCod+httpContext.getMessage( " &FecDesde ", "")+GXutil.trim( localUtil.dtoc( AV34FecDesde, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &FecHasta ", "")+GXutil.trim( localUtil.dtoc( AV35FecHasta, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV44LiqNro, 8, 0))+httpContext.getMessage( " &busquedaTLiqCod ", "")+GXutil.trim( AV63busquedaTLiqCod)+httpContext.getMessage( " &excluirLiquidacionPropia ", "")+GXutil.trim( GXutil.booltostr( AV33excluirLiquidacionPropia))) ;
      if ( GXutil.strcmp(AV51ProcesoLiquidacion, "Calculo") == 0 )
      {
         AV69GXLvl10 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV24ConceptoPar ,
                                              Boolean.valueOf(AV33excluirLiquidacionPropia) ,
                                              AV63busquedaTLiqCod ,
                                              A394DConCodigo ,
                                              A464DTipoConCod ,
                                              AV57TipoConCod ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(AV44LiqNro) ,
                                              A400DTLiqCod ,
                                              A397DLiqPeriodo ,
                                              AV34FecDesde ,
                                              AV35FecHasta ,
                                              Integer.valueOf(A2112LiqRelNro) ,
                                              Integer.valueOf(AV46LiqRelNro) ,
                                              Integer.valueOf(AV9CliCod) ,
                                              Short.valueOf(AV10EmpCod) ,
                                              Integer.valueOf(AV11LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT
                                              }
         });
         /* Using cursor P01ZC2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV34FecDesde, AV35FecHasta, Integer.valueOf(AV46LiqRelNro), AV24ConceptoPar, AV57TipoConCod, Integer.valueOf(AV44LiqNro), AV63busquedaTLiqCod});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A2112LiqRelNro = P01ZC2_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01ZC2_n2112LiqRelNro[0] ;
            A400DTLiqCod = P01ZC2_A400DTLiqCod[0] ;
            A31LiqNro = P01ZC2_A31LiqNro[0] ;
            A464DTipoConCod = P01ZC2_A464DTipoConCod[0] ;
            A394DConCodigo = P01ZC2_A394DConCodigo[0] ;
            A6LegNumero = P01ZC2_A6LegNumero[0] ;
            A397DLiqPeriodo = P01ZC2_A397DLiqPeriodo[0] ;
            A1EmpCod = P01ZC2_A1EmpCod[0] ;
            A3CliCod = P01ZC2_A3CliCod[0] ;
            A269LiqDCanti = P01ZC2_A269LiqDCanti[0] ;
            n269LiqDCanti = P01ZC2_n269LiqDCanti[0] ;
            A764LiqDImpReCalcu = P01ZC2_A764LiqDImpReCalcu[0] ;
            A507LiqDCalculado = P01ZC2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P01ZC2_A763LiqDRecalculado[0] ;
            A81LiqDSecuencial = P01ZC2_A81LiqDSecuencial[0] ;
            A2112LiqRelNro = P01ZC2_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01ZC2_n2112LiqRelNro[0] ;
            AV69GXLvl10 = (byte)(1) ;
            AV21auxLiqDCanti = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV21auxLiqDCanti).add(A269LiqDCanti))) ;
            AV20CantidadAux = (short)(AV20CantidadAux+1) ;
            AV15auxLiqDImpReCalcu = AV15auxLiqDImpReCalcu.add(A764LiqDImpReCalcu) ;
            AV14auxLiqDCalculado = (byte)(AV14auxLiqDCalculado+A507LiqDCalculado) ;
            AV16auxLiqDRecalculado = (short)(AV16auxLiqDRecalculado+A763LiqDRecalculado) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV69GXLvl10 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "NONE", "")) ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "&auxLiqDCanti ", "")+GXutil.trim( GXutil.str( AV21auxLiqDCanti, 4, 0))+httpContext.getMessage( " &CantidadAux ", "")+GXutil.trim( GXutil.str( AV20CantidadAux, 4, 0))) ;
         if ( ! AV33excluirLiquidacionPropia && ( AV14auxLiqDCalculado < AV20CantidadAux ) )
         {
            GXv_char1[0] = AV43liqdlog ;
            new web.verificardependenciasresueltas(remoteHandle, context).execute( AV9CliCod, AV10EmpCod, AV44LiqNro, AV11LegNumero, AV25ConCodigo, AV24ConceptoPar, AV57TipoConCod, AV51ProcesoLiquidacion, GXv_char1) ;
            obtvalformulacc5.this.AV43liqdlog = GXv_char1[0] ;
            if ( ! (GXutil.strcmp("", AV43liqdlog)==0) )
            {
               AV31dependenciasResueltas = false ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              AV24ConceptoPar ,
                                              Boolean.valueOf(AV33excluirLiquidacionPropia) ,
                                              AV63busquedaTLiqCod ,
                                              A394DConCodigo ,
                                              A464DTipoConCod ,
                                              AV57TipoConCod ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(AV44LiqNro) ,
                                              A400DTLiqCod ,
                                              A397DLiqPeriodo ,
                                              AV34FecDesde ,
                                              AV35FecHasta ,
                                              Integer.valueOf(A2112LiqRelNro) ,
                                              Integer.valueOf(AV46LiqRelNro) ,
                                              Integer.valueOf(AV9CliCod) ,
                                              Short.valueOf(AV10EmpCod) ,
                                              Integer.valueOf(AV11LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.DATE,
                                              TypeConstants.DATE, TypeConstants.DATE, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT
                                              }
         });
         /* Using cursor P01ZC3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV11LegNumero), AV34FecDesde, AV35FecHasta, Integer.valueOf(AV46LiqRelNro), AV24ConceptoPar, AV57TipoConCod, Integer.valueOf(AV44LiqNro), AV63busquedaTLiqCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2112LiqRelNro = P01ZC3_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01ZC3_n2112LiqRelNro[0] ;
            A400DTLiqCod = P01ZC3_A400DTLiqCod[0] ;
            A31LiqNro = P01ZC3_A31LiqNro[0] ;
            A464DTipoConCod = P01ZC3_A464DTipoConCod[0] ;
            A394DConCodigo = P01ZC3_A394DConCodigo[0] ;
            A6LegNumero = P01ZC3_A6LegNumero[0] ;
            A397DLiqPeriodo = P01ZC3_A397DLiqPeriodo[0] ;
            A1EmpCod = P01ZC3_A1EmpCod[0] ;
            A3CliCod = P01ZC3_A3CliCod[0] ;
            A269LiqDCanti = P01ZC3_A269LiqDCanti[0] ;
            n269LiqDCanti = P01ZC3_n269LiqDCanti[0] ;
            A81LiqDSecuencial = P01ZC3_A81LiqDSecuencial[0] ;
            A764LiqDImpReCalcu = P01ZC3_A764LiqDImpReCalcu[0] ;
            A507LiqDCalculado = P01ZC3_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P01ZC3_A763LiqDRecalculado[0] ;
            A393DConDescrip = P01ZC3_A393DConDescrip[0] ;
            A2112LiqRelNro = P01ZC3_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01ZC3_n2112LiqRelNro[0] ;
            AV21auxLiqDCanti = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV21auxLiqDCanti).add(A269LiqDCanti))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV68Pgmname, httpContext.getMessage( "LiqDSecuencial ", "")+GXutil.trim( GXutil.str( A81LiqDSecuencial, 5, 0))+httpContext.getMessage( " LiqDCanti ", "")+GXutil.trim( GXutil.str( A269LiqDCanti, 14, 2))+httpContext.getMessage( " cantidad calculada ", "")+GXutil.trim( GXutil.str( AV21auxLiqDCanti, 4, 0))) ;
            AV20CantidadAux = (short)(AV20CantidadAux+1) ;
            AV15auxLiqDImpReCalcu = AV15auxLiqDImpReCalcu.add(A764LiqDImpReCalcu) ;
            AV14auxLiqDCalculado = (byte)(AV14auxLiqDCalculado+A507LiqDCalculado) ;
            AV16auxLiqDRecalculado = (short)(AV16auxLiqDRecalculado+A763LiqDRecalculado) ;
            if ( ( A31LiqNro == AV44LiqNro ) && ( GXutil.strcmp(AV25ConCodigo, A394DConCodigo) != 0 ) && ( new web.dependenciaresuelta2(remoteHandle, context).executeUdp( AV9CliCod, A394DConCodigo, AV51ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado) == 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV42LiqDCalculado = (byte)(0) ;
               AV65error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A393DConDescrip) ;
               pr_default.close(1);
               pr_default.close(1);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            pr_default.readNext(1);
         }
         pr_default.close(1);
      }
      AV64cantidadCalculada = (short)(1) ;
      if ( GXutil.strcmp(AV32Devolver, AV8cantidadPalabra) == 0 )
      {
         AV39Importes = DecimalUtil.doubleToDec(AV21auxLiqDCanti) ;
      }
      else
      {
         AV39Importes = AV15auxLiqDImpReCalcu ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP17[0] = obtvalformulacc5.this.AV64cantidadCalculada;
      this.aP18[0] = obtvalformulacc5.this.AV31dependenciasResueltas;
      this.aP19[0] = obtvalformulacc5.this.AV39Importes;
      this.aP20[0] = obtvalformulacc5.this.AV20CantidadAux;
      this.aP21[0] = obtvalformulacc5.this.AV43liqdlog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV39Importes = DecimalUtil.ZERO ;
      AV43liqdlog = "" ;
      AV36ImporteAux = DecimalUtil.ZERO ;
      AV68Pgmname = "" ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      A400DTLiqCod = "" ;
      A397DLiqPeriodo = GXutil.nullDate() ;
      P01ZC2_A2112LiqRelNro = new int[1] ;
      P01ZC2_n2112LiqRelNro = new boolean[] {false} ;
      P01ZC2_A400DTLiqCod = new String[] {""} ;
      P01ZC2_A31LiqNro = new int[1] ;
      P01ZC2_A464DTipoConCod = new String[] {""} ;
      P01ZC2_A394DConCodigo = new String[] {""} ;
      P01ZC2_A6LegNumero = new int[1] ;
      P01ZC2_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01ZC2_A1EmpCod = new short[1] ;
      P01ZC2_A3CliCod = new int[1] ;
      P01ZC2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZC2_n269LiqDCanti = new boolean[] {false} ;
      P01ZC2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZC2_A507LiqDCalculado = new byte[1] ;
      P01ZC2_A763LiqDRecalculado = new short[1] ;
      P01ZC2_A81LiqDSecuencial = new int[1] ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      AV15auxLiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_char1 = new String[1] ;
      P01ZC3_A2112LiqRelNro = new int[1] ;
      P01ZC3_n2112LiqRelNro = new boolean[] {false} ;
      P01ZC3_A400DTLiqCod = new String[] {""} ;
      P01ZC3_A31LiqNro = new int[1] ;
      P01ZC3_A464DTipoConCod = new String[] {""} ;
      P01ZC3_A394DConCodigo = new String[] {""} ;
      P01ZC3_A6LegNumero = new int[1] ;
      P01ZC3_A397DLiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P01ZC3_A1EmpCod = new short[1] ;
      P01ZC3_A3CliCod = new int[1] ;
      P01ZC3_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZC3_n269LiqDCanti = new boolean[] {false} ;
      P01ZC3_A81LiqDSecuencial = new int[1] ;
      P01ZC3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZC3_A507LiqDCalculado = new byte[1] ;
      P01ZC3_A763LiqDRecalculado = new short[1] ;
      P01ZC3_A393DConDescrip = new String[] {""} ;
      A393DConDescrip = "" ;
      AV65error = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtvalformulacc5__default(),
         new Object[] {
             new Object[] {
            P01ZC2_A2112LiqRelNro, P01ZC2_n2112LiqRelNro, P01ZC2_A400DTLiqCod, P01ZC2_A31LiqNro, P01ZC2_A464DTipoConCod, P01ZC2_A394DConCodigo, P01ZC2_A6LegNumero, P01ZC2_A397DLiqPeriodo, P01ZC2_A1EmpCod, P01ZC2_A3CliCod,
            P01ZC2_A269LiqDCanti, P01ZC2_n269LiqDCanti, P01ZC2_A764LiqDImpReCalcu, P01ZC2_A507LiqDCalculado, P01ZC2_A763LiqDRecalculado, P01ZC2_A81LiqDSecuencial
            }
            , new Object[] {
            P01ZC3_A2112LiqRelNro, P01ZC3_n2112LiqRelNro, P01ZC3_A400DTLiqCod, P01ZC3_A31LiqNro, P01ZC3_A464DTipoConCod, P01ZC3_A394DConCodigo, P01ZC3_A6LegNumero, P01ZC3_A397DLiqPeriodo, P01ZC3_A1EmpCod, P01ZC3_A3CliCod,
            P01ZC3_A269LiqDCanti, P01ZC3_n269LiqDCanti, P01ZC3_A81LiqDSecuencial, P01ZC3_A764LiqDImpReCalcu, P01ZC3_A507LiqDCalculado, P01ZC3_A763LiqDRecalculado, P01ZC3_A393DConDescrip
            }
         }
      );
      AV68Pgmname = "ObtValFormulaCC5" ;
      /* GeneXus formulas. */
      AV68Pgmname = "ObtValFormulaCC5" ;
      Gx_err = (short)(0) ;
   }

   private byte AV69GXLvl10 ;
   private byte A507LiqDCalculado ;
   private byte AV14auxLiqDCalculado ;
   private byte AV42LiqDCalculado ;
   private short AV10EmpCod ;
   private short AV64cantidadCalculada ;
   private short AV20CantidadAux ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short AV21auxLiqDCanti ;
   private short AV16auxLiqDRecalculado ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int AV44LiqNro ;
   private int AV46LiqRelNro ;
   private int AV11LegNumero ;
   private int A31LiqNro ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV39Importes ;
   private java.math.BigDecimal AV36ImporteAux ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV15auxLiqDImpReCalcu ;
   private String AV62TLiqCod ;
   private String AV25ConCodigo ;
   private String AV24ConceptoPar ;
   private String AV57TipoConCod ;
   private String AV63busquedaTLiqCod ;
   private String AV32Devolver ;
   private String AV51ProcesoLiquidacion ;
   private String AV8cantidadPalabra ;
   private String AV68Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String A400DTLiqCod ;
   private String GXv_char1[] ;
   private java.util.Date AV45LiqPeriodo ;
   private java.util.Date AV34FecDesde ;
   private java.util.Date AV35FecHasta ;
   private java.util.Date A397DLiqPeriodo ;
   private boolean AV33excluirLiquidacionPropia ;
   private boolean AV31dependenciasResueltas ;
   private boolean n2112LiqRelNro ;
   private boolean n269LiqDCanti ;
   private boolean returnInSub ;
   private boolean Cond_result ;
   private String AV43liqdlog ;
   private String A393DConDescrip ;
   private String AV65error ;
   private String[] aP21 ;
   private short[] aP17 ;
   private boolean[] aP18 ;
   private java.math.BigDecimal[] aP19 ;
   private short[] aP20 ;
   private IDataStoreProvider pr_default ;
   private int[] P01ZC2_A2112LiqRelNro ;
   private boolean[] P01ZC2_n2112LiqRelNro ;
   private String[] P01ZC2_A400DTLiqCod ;
   private int[] P01ZC2_A31LiqNro ;
   private String[] P01ZC2_A464DTipoConCod ;
   private String[] P01ZC2_A394DConCodigo ;
   private int[] P01ZC2_A6LegNumero ;
   private java.util.Date[] P01ZC2_A397DLiqPeriodo ;
   private short[] P01ZC2_A1EmpCod ;
   private int[] P01ZC2_A3CliCod ;
   private java.math.BigDecimal[] P01ZC2_A269LiqDCanti ;
   private boolean[] P01ZC2_n269LiqDCanti ;
   private java.math.BigDecimal[] P01ZC2_A764LiqDImpReCalcu ;
   private byte[] P01ZC2_A507LiqDCalculado ;
   private short[] P01ZC2_A763LiqDRecalculado ;
   private int[] P01ZC2_A81LiqDSecuencial ;
   private int[] P01ZC3_A2112LiqRelNro ;
   private boolean[] P01ZC3_n2112LiqRelNro ;
   private String[] P01ZC3_A400DTLiqCod ;
   private int[] P01ZC3_A31LiqNro ;
   private String[] P01ZC3_A464DTipoConCod ;
   private String[] P01ZC3_A394DConCodigo ;
   private int[] P01ZC3_A6LegNumero ;
   private java.util.Date[] P01ZC3_A397DLiqPeriodo ;
   private short[] P01ZC3_A1EmpCod ;
   private int[] P01ZC3_A3CliCod ;
   private java.math.BigDecimal[] P01ZC3_A269LiqDCanti ;
   private boolean[] P01ZC3_n269LiqDCanti ;
   private int[] P01ZC3_A81LiqDSecuencial ;
   private java.math.BigDecimal[] P01ZC3_A764LiqDImpReCalcu ;
   private byte[] P01ZC3_A507LiqDCalculado ;
   private short[] P01ZC3_A763LiqDRecalculado ;
   private String[] P01ZC3_A393DConDescrip ;
}

final  class obtvalformulacc5__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ZC2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV24ConceptoPar ,
                                          boolean AV33excluirLiquidacionPropia ,
                                          String AV63busquedaTLiqCod ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV57TipoConCod ,
                                          int A31LiqNro ,
                                          int AV44LiqNro ,
                                          String A400DTLiqCod ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV34FecDesde ,
                                          java.util.Date AV35FecHasta ,
                                          int A2112LiqRelNro ,
                                          int AV46LiqRelNro ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int AV11LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[10];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.DTLiqCod, T1.LiqNro, T1.DTipoConCod, T1.DConCodigo, T1.LegNumero, T1.DLiqPeriodo, T1.EmpCod, T1.CliCod, T1.LiqDCanti, T1.LiqDImpReCalcu," ;
      scmdbuf += " T1.LiqDCalculado, T1.LiqDRecalculado, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod" ;
      scmdbuf += " AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo >= ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo <= ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      if ( ! (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int2[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int2[7] = (byte)(1) ;
      }
      if ( AV33excluirLiquidacionPropia )
      {
         addWhere(sWhereString, "(T1.LiqNro <> ?)");
      }
      else
      {
         GXv_int2[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63busquedaTLiqCod)==0) )
      {
         addWhere(sWhereString, "(T1.DTLiqCod = ( ?))");
      }
      else
      {
         GXv_int2[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ! (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo" ;
      }
      else if ( (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DTipoConCod, T1.DLiqPeriodo" ;
      }
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P01ZC3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV24ConceptoPar ,
                                          boolean AV33excluirLiquidacionPropia ,
                                          String AV63busquedaTLiqCod ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV57TipoConCod ,
                                          int A31LiqNro ,
                                          int AV44LiqNro ,
                                          String A400DTLiqCod ,
                                          java.util.Date A397DLiqPeriodo ,
                                          java.util.Date AV34FecDesde ,
                                          java.util.Date AV35FecHasta ,
                                          int A2112LiqRelNro ,
                                          int AV46LiqRelNro ,
                                          int AV9CliCod ,
                                          short AV10EmpCod ,
                                          int AV11LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[10];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.DTLiqCod, T1.LiqNro, T1.DTipoConCod, T1.DConCodigo, T1.LegNumero, T1.DLiqPeriodo, T1.EmpCod, T1.CliCod, T1.LiqDCanti, T1.LiqDSecuencial," ;
      scmdbuf += " T1.LiqDImpReCalcu, T1.LiqDCalculado, T1.LiqDRecalculado, T1.DConDescrip FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod" ;
      scmdbuf += " = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo >= ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo <= ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL or T2.LiqRelNro = ?)");
      if ( ! (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int4[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int4[7] = (byte)(1) ;
      }
      if ( AV33excluirLiquidacionPropia )
      {
         addWhere(sWhereString, "(T1.LiqNro <> ?)");
      }
      else
      {
         GXv_int4[8] = (byte)(1) ;
      }
      if ( ! (GXutil.strcmp("", AV63busquedaTLiqCod)==0) )
      {
         addWhere(sWhereString, "(T1.DTLiqCod = ( ?))");
      }
      else
      {
         GXv_int4[9] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ! (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DConCodigo, T1.DLiqPeriodo" ;
      }
      else if ( (GXutil.strcmp("", AV24ConceptoPar)==0) )
      {
         scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LegNumero, T1.DTipoConCod, T1.DLiqPeriodo" ;
      }
      GXv_Object5[0] = scmdbuf ;
      GXv_Object5[1] = GXv_int4 ;
      return GXv_Object5 ;
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
                  return conditional_P01ZC2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).intValue() );
            case 1 :
                  return conditional_P01ZC3(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , (java.util.Date)dynConstraints[9] , (java.util.Date)dynConstraints[10] , (java.util.Date)dynConstraints[11] , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , ((Number) dynConstraints[15]).shortValue() , ((Number) dynConstraints[16]).intValue() , ((Number) dynConstraints[17]).intValue() , ((Number) dynConstraints[18]).shortValue() , ((Number) dynConstraints[19]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZC2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01ZC3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[12])[0] = rslt.getBigDecimal(11,2);
               ((byte[]) buf[13])[0] = rslt.getByte(12);
               ((short[]) buf[14])[0] = rslt.getShort(13);
               ((int[]) buf[15])[0] = rslt.getInt(14);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((String[]) buf[4])[0] = rslt.getString(4, 20);
               ((String[]) buf[5])[0] = rslt.getString(5, 10);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(7);
               ((short[]) buf[8])[0] = rslt.getShort(8);
               ((int[]) buf[9])[0] = rslt.getInt(9);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[11])[0] = rslt.wasNull();
               ((int[]) buf[12])[0] = rslt.getInt(11);
               ((java.math.BigDecimal[]) buf[13])[0] = rslt.getBigDecimal(12,2);
               ((byte[]) buf[14])[0] = rslt.getByte(13);
               ((short[]) buf[15])[0] = rslt.getShort(14);
               ((String[]) buf[16])[0] = rslt.getVarchar(15);
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
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[11]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[14]);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[15]).intValue());
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[16], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[17], 20);
               }
               if ( ((Number) parms[8]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[18]).intValue());
               }
               if ( ((Number) parms[9]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[19], 20);
               }
               return;
      }
   }

}

