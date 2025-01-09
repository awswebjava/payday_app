package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformulaccoptimizado extends GXProcedure
{
   public obtvalformulaccoptimizado( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformulaccoptimizado.class ), "" );
   }

   public obtvalformulaccoptimizado( int remoteHandle ,
                                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             byte[] aP16 ,
                             short[] aP17 )
   {
      obtvalformulaccoptimizado.this.aP18 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
      return aP18[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        boolean aP7 ,
                        String aP8 ,
                        String aP9 ,
                        String aP10 ,
                        String aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        java.math.BigDecimal[] aP15 ,
                        byte[] aP16 ,
                        short[] aP17 ,
                        String[] aP18 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             boolean aP7 ,
                             String aP8 ,
                             String aP9 ,
                             String aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             java.math.BigDecimal[] aP15 ,
                             byte[] aP16 ,
                             short[] aP17 ,
                             String[] aP18 )
   {
      obtvalformulaccoptimizado.this.AV14CliCod = aP0;
      obtvalformulaccoptimizado.this.AV24EmpCod = aP1;
      obtvalformulaccoptimizado.this.AV32LiqNro = aP2;
      obtvalformulaccoptimizado.this.AV29LegNumero = aP3;
      obtvalformulaccoptimizado.this.AV17ConCodigo = aP4;
      obtvalformulaccoptimizado.this.AV15ConceptoPar = aP5;
      obtvalformulaccoptimizado.this.AV52TipoConCod = aP6;
      obtvalformulaccoptimizado.this.AV27insertandoConceptos = aP7;
      obtvalformulaccoptimizado.this.AV12cantidadPalabra = aP8;
      obtvalformulaccoptimizado.this.AV26importePalabra = aP9;
      obtvalformulaccoptimizado.this.AV46valorUniPalabra = aP10;
      obtvalformulaccoptimizado.this.AV45valorGenPalabra = aP11;
      obtvalformulaccoptimizado.this.AV43totalPalabra = aP12;
      obtvalformulaccoptimizado.this.AV23Devolver = aP13;
      obtvalformulaccoptimizado.this.AV37ProcesoLiquidacion = aP14;
      obtvalformulaccoptimizado.this.aP15 = aP15;
      obtvalformulaccoptimizado.this.aP16 = aP16;
      obtvalformulaccoptimizado.this.aP17 = aP17;
      obtvalformulaccoptimizado.this.aP18 = aP18;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV49comienzo = GXutil.serverNowMs( context, remoteHandle, pr_default) ;
      AV30LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&concodigo ", "")+GXutil.trim( AV17ConCodigo)+httpContext.getMessage( " &conceptopar ", "")+AV15ConceptoPar) ;
      AV25Importe = DecimalUtil.ZERO ;
      if ( GXutil.strcmp(AV37ProcesoLiquidacion, "Calculo") == 0 )
      {
         /* Optimized group. */
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV15ConceptoPar ,
                                              A394DConCodigo ,
                                              A464DTipoConCod ,
                                              AV52TipoConCod } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING
                                              }
         });
         /* Using cursor P01ZM2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV24EmpCod), Integer.valueOf(AV32LiqNro), Integer.valueOf(AV29LegNumero), AV15ConceptoPar, AV52TipoConCod});
         cV56cant = P01ZM2_AV56cant[0] ;
         c269LiqDCanti = (short)(DecimalUtil.decToDouble(P01ZM2_A269LiqDCanti[0])) ;
         n269LiqDCanti = P01ZM2_n269LiqDCanti[0] ;
         c764LiqDImpReCalcu = P01ZM2_A764LiqDImpReCalcu[0] ;
         c507LiqDCalculado = P01ZM2_A507LiqDCalculado[0] ;
         c763LiqDRecalculado = P01ZM2_A763LiqDRecalculado[0] ;
         pr_default.close(0);
         AV56cant = (short)(AV56cant+cV56cant*1) ;
         AV11cantidadCalculada = (short)(AV11cantidadCalculada+c269LiqDCanti) ;
         AV53auxLiqDImpReCalcu = AV53auxLiqDImpReCalcu.add(c764LiqDImpReCalcu) ;
         AV54auxLiqDCalculado = (short)(AV54auxLiqDCalculado+c507LiqDCalculado) ;
         AV55auxLiqDRecalculado = (short)(AV55auxLiqDRecalculado+c763LiqDRecalculado) ;
         /* End optimized group. */
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV24EmpCod, 4, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&LiqNro: ", "")+GXutil.trim( GXutil.str( AV32LiqNro, 8, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV29LegNumero, 8, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&ConceptoPar: ", "")+GXutil.trim( AV15ConceptoPar)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&TipoConCod: ", "")+GXutil.trim( AV52TipoConCod)) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&cant: ", "")+GXutil.trim( GXutil.str( AV56cant, 4, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&cantidadCalculada: ", "")+GXutil.trim( GXutil.str( AV11cantidadCalculada, 4, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&auxLiqDImpReCalcu: ", "")+GXutil.trim( GXutil.str( AV53auxLiqDImpReCalcu, 14, 2))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&auxLiqDCalculado: ", "")+GXutil.trim( GXutil.str( AV54auxLiqDCalculado, 4, 0))) ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&auxLiqDRecalculado: ", "")+GXutil.trim( GXutil.str( AV55auxLiqDRecalculado, 4, 0))) ;
         if ( AV54auxLiqDCalculado < AV56cant )
         {
            GXv_char1[0] = AV31LiqDLog ;
            new web.verificardependenciasresueltas(remoteHandle, context).execute( AV14CliCod, AV24EmpCod, AV32LiqNro, AV29LegNumero, AV17ConCodigo, AV15ConceptoPar, AV52TipoConCod, AV37ProcesoLiquidacion, GXv_char1) ;
            obtvalformulaccoptimizado.this.AV31LiqDLog = GXv_char1[0] ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV29LegNumero, 8, 0))) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&ConCodigo: ", "")+GXutil.trim( AV17ConCodigo)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&TipoConCod: ", "")+GXutil.trim( AV52TipoConCod)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&ProcesoLiquidacion: ", "")+GXutil.trim( AV37ProcesoLiquidacion)) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&liqdlog: ", "")+GXutil.trim( AV31LiqDLog)) ;
            if ( ! (GXutil.strcmp("", AV31LiqDLog)==0) )
            {
               AV30LiqDCalculado = (byte)(0) ;
               returnInSub = true;
               cleanup();
               if (true) return;
            }
         }
      }
      else
      {
         pr_default.dynParam(1, new Object[]{ new Object[]{
                                              AV15ConceptoPar ,
                                              A394DConCodigo ,
                                              A464DTipoConCod ,
                                              AV52TipoConCod ,
                                              Integer.valueOf(A2112LiqRelNro) ,
                                              Integer.valueOf(AV14CliCod) ,
                                              Short.valueOf(AV24EmpCod) ,
                                              Integer.valueOf(AV32LiqNro) ,
                                              Integer.valueOf(AV29LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P01ZM3 */
         pr_default.execute(1, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV24EmpCod), Integer.valueOf(AV32LiqNro), Integer.valueOf(AV29LegNumero), AV15ConceptoPar, AV52TipoConCod});
         while ( (pr_default.getStatus(1) != 101) )
         {
            A2112LiqRelNro = P01ZM3_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01ZM3_n2112LiqRelNro[0] ;
            A464DTipoConCod = P01ZM3_A464DTipoConCod[0] ;
            A394DConCodigo = P01ZM3_A394DConCodigo[0] ;
            A6LegNumero = P01ZM3_A6LegNumero[0] ;
            A31LiqNro = P01ZM3_A31LiqNro[0] ;
            A1EmpCod = P01ZM3_A1EmpCod[0] ;
            A3CliCod = P01ZM3_A3CliCod[0] ;
            A269LiqDCanti = P01ZM3_A269LiqDCanti[0] ;
            n269LiqDCanti = P01ZM3_n269LiqDCanti[0] ;
            A764LiqDImpReCalcu = P01ZM3_A764LiqDImpReCalcu[0] ;
            A507LiqDCalculado = P01ZM3_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P01ZM3_A763LiqDRecalculado[0] ;
            A393DConDescrip = P01ZM3_A393DConDescrip[0] ;
            A81LiqDSecuencial = P01ZM3_A81LiqDSecuencial[0] ;
            A2112LiqRelNro = P01ZM3_A2112LiqRelNro[0] ;
            n2112LiqRelNro = P01ZM3_n2112LiqRelNro[0] ;
            AV56cant = (short)(AV56cant+1) ;
            AV11cantidadCalculada = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV11cantidadCalculada).add(A269LiqDCanti))) ;
            AV53auxLiqDImpReCalcu = AV53auxLiqDImpReCalcu.add(A764LiqDImpReCalcu) ;
            AV54auxLiqDCalculado = (short)(AV54auxLiqDCalculado+A507LiqDCalculado) ;
            AV55auxLiqDRecalculado = (short)(AV55auxLiqDRecalculado+A763LiqDRecalculado) ;
            if ( ( GXutil.strcmp(AV17ConCodigo, A394DConCodigo) != 0 ) && ( new web.dependenciaresuelta2(remoteHandle, context).executeUdp( AV14CliCod, A394DConCodigo, AV37ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado) == 0 ) )
            {
               Cond_result = true ;
            }
            else
            {
               Cond_result = false ;
            }
            if ( Cond_result )
            {
               AV30LiqDCalculado = (byte)(0) ;
               AV57error = httpContext.getMessage( "Falta calcular concepto ", "") + GXutil.trim( A393DConDescrip) ;
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
      if ( GXutil.strcmp(AV23Devolver, AV12cantidadPalabra) == 0 )
      {
         AV25Importe = DecimalUtil.doubleToDec(AV11cantidadCalculada) ;
      }
      else
      {
         AV25Importe = AV53auxLiqDImpReCalcu ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&Devolver: ", "")+GXutil.trim( AV23Devolver)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&cantidadPalabra: ", "")+GXutil.trim( AV12cantidadPalabra)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&Importe: ", "")+GXutil.trim( GXutil.str( AV25Importe, 14, 4))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&cantidadCalculada: ", "")+GXutil.trim( GXutil.str( AV11cantidadCalculada, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV60Pgmname, httpContext.getMessage( "&auxLiqDImpReCalcu: ", "")+GXutil.trim( GXutil.str( AV53auxLiqDImpReCalcu, 14, 2))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP15[0] = obtvalformulaccoptimizado.this.AV25Importe;
      this.aP16[0] = obtvalformulaccoptimizado.this.AV30LiqDCalculado;
      this.aP17[0] = obtvalformulaccoptimizado.this.AV11cantidadCalculada;
      this.aP18[0] = obtvalformulaccoptimizado.this.AV31LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV25Importe = DecimalUtil.ZERO ;
      AV31LiqDLog = "" ;
      AV49comienzo = GXutil.resetTime( GXutil.nullDate() );
      AV60Pgmname = "" ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      P01ZM2_AV56cant = new short[1] ;
      P01ZM2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZM2_n269LiqDCanti = new boolean[] {false} ;
      P01ZM2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZM2_A507LiqDCalculado = new short[1] ;
      P01ZM2_A763LiqDRecalculado = new short[1] ;
      AV53auxLiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_char1 = new String[1] ;
      P01ZM3_A2112LiqRelNro = new int[1] ;
      P01ZM3_n2112LiqRelNro = new boolean[] {false} ;
      P01ZM3_A464DTipoConCod = new String[] {""} ;
      P01ZM3_A394DConCodigo = new String[] {""} ;
      P01ZM3_A6LegNumero = new int[1] ;
      P01ZM3_A31LiqNro = new int[1] ;
      P01ZM3_A1EmpCod = new short[1] ;
      P01ZM3_A3CliCod = new int[1] ;
      P01ZM3_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZM3_n269LiqDCanti = new boolean[] {false} ;
      P01ZM3_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZM3_A507LiqDCalculado = new byte[1] ;
      P01ZM3_A763LiqDRecalculado = new short[1] ;
      P01ZM3_A393DConDescrip = new String[] {""} ;
      P01ZM3_A81LiqDSecuencial = new int[1] ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A393DConDescrip = "" ;
      AV57error = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtvalformulaccoptimizado__default(),
         new Object[] {
             new Object[] {
            P01ZM2_AV56cant, P01ZM2_A269LiqDCanti, P01ZM2_n269LiqDCanti, P01ZM2_A764LiqDImpReCalcu, P01ZM2_A507LiqDCalculado, P01ZM2_A763LiqDRecalculado
            }
            , new Object[] {
            P01ZM3_A2112LiqRelNro, P01ZM3_n2112LiqRelNro, P01ZM3_A464DTipoConCod, P01ZM3_A394DConCodigo, P01ZM3_A6LegNumero, P01ZM3_A31LiqNro, P01ZM3_A1EmpCod, P01ZM3_A3CliCod, P01ZM3_A269LiqDCanti, P01ZM3_n269LiqDCanti,
            P01ZM3_A764LiqDImpReCalcu, P01ZM3_A507LiqDCalculado, P01ZM3_A763LiqDRecalculado, P01ZM3_A393DConDescrip, P01ZM3_A81LiqDSecuencial
            }
         }
      );
      AV60Pgmname = "ObtValFormulaCCOptimizado" ;
      /* GeneXus formulas. */
      AV60Pgmname = "ObtValFormulaCCOptimizado" ;
      Gx_err = (short)(0) ;
   }

   private byte AV30LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private short AV24EmpCod ;
   private short AV11cantidadCalculada ;
   private short c269LiqDCanti ;
   private short c507LiqDCalculado ;
   private short c763LiqDRecalculado ;
   private short cV56cant ;
   private short AV56cant ;
   private short AV54auxLiqDCalculado ;
   private short AV55auxLiqDRecalculado ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV32LiqNro ;
   private int AV29LegNumero ;
   private int A2112LiqRelNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV25Importe ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private java.math.BigDecimal AV53auxLiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV17ConCodigo ;
   private String AV15ConceptoPar ;
   private String AV52TipoConCod ;
   private String AV12cantidadPalabra ;
   private String AV26importePalabra ;
   private String AV46valorUniPalabra ;
   private String AV45valorGenPalabra ;
   private String AV43totalPalabra ;
   private String AV23Devolver ;
   private String AV37ProcesoLiquidacion ;
   private String AV60Pgmname ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String GXv_char1[] ;
   private java.util.Date AV49comienzo ;
   private boolean AV27insertandoConceptos ;
   private boolean n269LiqDCanti ;
   private boolean returnInSub ;
   private boolean n2112LiqRelNro ;
   private boolean Cond_result ;
   private String AV31LiqDLog ;
   private String A393DConDescrip ;
   private String AV57error ;
   private String[] aP18 ;
   private java.math.BigDecimal[] aP15 ;
   private byte[] aP16 ;
   private short[] aP17 ;
   private IDataStoreProvider pr_default ;
   private short[] P01ZM2_AV56cant ;
   private java.math.BigDecimal[] P01ZM2_A269LiqDCanti ;
   private boolean[] P01ZM2_n269LiqDCanti ;
   private java.math.BigDecimal[] P01ZM2_A764LiqDImpReCalcu ;
   private short[] P01ZM2_A507LiqDCalculado ;
   private short[] P01ZM2_A763LiqDRecalculado ;
   private int[] P01ZM3_A2112LiqRelNro ;
   private boolean[] P01ZM3_n2112LiqRelNro ;
   private String[] P01ZM3_A464DTipoConCod ;
   private String[] P01ZM3_A394DConCodigo ;
   private int[] P01ZM3_A6LegNumero ;
   private int[] P01ZM3_A31LiqNro ;
   private short[] P01ZM3_A1EmpCod ;
   private int[] P01ZM3_A3CliCod ;
   private java.math.BigDecimal[] P01ZM3_A269LiqDCanti ;
   private boolean[] P01ZM3_n269LiqDCanti ;
   private java.math.BigDecimal[] P01ZM3_A764LiqDImpReCalcu ;
   private byte[] P01ZM3_A507LiqDCalculado ;
   private short[] P01ZM3_A763LiqDRecalculado ;
   private String[] P01ZM3_A393DConDescrip ;
   private int[] P01ZM3_A81LiqDSecuencial ;
}

final  class obtvalformulaccoptimizado__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ZM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV15ConceptoPar ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV52TipoConCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int2 = new byte[6];
      Object[] GXv_Object3 = new Object[2];
      scmdbuf = "SELECT COUNT(*), SUM(T1.LiqDCanti), SUM(T1.LiqDImpReCalcu), SUM(T1.LiqDCalculado), SUM(T1.LiqDRecalculado) FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2" ;
      scmdbuf += " ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL)");
      if ( ! (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int2[4] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int2[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      GXv_Object3[0] = scmdbuf ;
      GXv_Object3[1] = GXv_int2 ;
      return GXv_Object3 ;
   }

   protected Object[] conditional_P01ZM3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV15ConceptoPar ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV52TipoConCod ,
                                          int A2112LiqRelNro ,
                                          int AV14CliCod ,
                                          short AV24EmpCod ,
                                          int AV32LiqNro ,
                                          int AV29LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[6];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT T2.LiqRelNro, T1.DTipoConCod, T1.DConCodigo, T1.LegNumero, T1.LiqNro, T1.EmpCod, T1.CliCod, T1.LiqDCanti, T1.LiqDImpReCalcu, T1.LiqDCalculado, T1.LiqDRecalculado," ;
      scmdbuf += " T1.DConDescrip, T1.LiqDSecuencial FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2 ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LiqNro = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T2.LiqRelNro IS NULL)");
      if ( ! (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY T1.CliCod, T1.EmpCod, T1.LiqNro, T1.LegNumero, T1.DConCodigo" ;
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
                  return conditional_P01ZM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] );
            case 1 :
                  return conditional_P01ZM3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).intValue() , ((Number) dynConstraints[6]).shortValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
         ,new ForEachCursor("P01ZM3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.math.BigDecimal[]) buf[1])[0] = rslt.getBigDecimal(2,2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[3])[0] = rslt.getBigDecimal(3,2);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 20);
               ((String[]) buf[3])[0] = rslt.getString(3, 10);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((byte[]) buf[11])[0] = rslt.getByte(10);
               ((short[]) buf[12])[0] = rslt.getShort(11);
               ((String[]) buf[13])[0] = rslt.getVarchar(12);
               ((int[]) buf[14])[0] = rslt.getInt(13);
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
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[6]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[7]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[10], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               return;
      }
   }

}

