package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformulaccoretroactivo extends GXProcedure
{
   public obtvalformulaccoretroactivo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformulaccoretroactivo.class ), "" );
   }

   public obtvalformulaccoretroactivo( int remoteHandle ,
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
                             int aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             byte[] aP19 ,
                             short[] aP20 )
   {
      obtvalformulaccoretroactivo.this.aP21 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
      return aP21[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        int aP4 ,
                        int aP5 ,
                        String aP6 ,
                        String aP7 ,
                        String aP8 ,
                        String aP9 ,
                        boolean aP10 ,
                        String aP11 ,
                        String aP12 ,
                        String aP13 ,
                        String aP14 ,
                        String aP15 ,
                        String aP16 ,
                        String aP17 ,
                        java.math.BigDecimal[] aP18 ,
                        byte[] aP19 ,
                        short[] aP20 ,
                        String[] aP21 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17, aP18, aP19, aP20, aP21);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             int aP4 ,
                             int aP5 ,
                             String aP6 ,
                             String aP7 ,
                             String aP8 ,
                             String aP9 ,
                             boolean aP10 ,
                             String aP11 ,
                             String aP12 ,
                             String aP13 ,
                             String aP14 ,
                             String aP15 ,
                             String aP16 ,
                             String aP17 ,
                             java.math.BigDecimal[] aP18 ,
                             byte[] aP19 ,
                             short[] aP20 ,
                             String[] aP21 )
   {
      obtvalformulaccoretroactivo.this.AV14CliCod = aP0;
      obtvalformulaccoretroactivo.this.AV24EmpCod = aP1;
      obtvalformulaccoretroactivo.this.AV32LiqNro = aP2;
      obtvalformulaccoretroactivo.this.AV59PeriodoNum6 = aP3;
      obtvalformulaccoretroactivo.this.AV56LiqRelNro = aP4;
      obtvalformulaccoretroactivo.this.AV29LegNumero = aP5;
      obtvalformulaccoretroactivo.this.AV17ConCodigo = aP6;
      obtvalformulaccoretroactivo.this.AV15ConceptoPar = aP7;
      obtvalformulaccoretroactivo.this.AV52TipoConCod = aP8;
      obtvalformulaccoretroactivo.this.AV57busquedaTLiqCod = aP9;
      obtvalformulaccoretroactivo.this.AV27insertandoConceptos = aP10;
      obtvalformulaccoretroactivo.this.AV12cantidadPalabra = aP11;
      obtvalformulaccoretroactivo.this.AV26importePalabra = aP12;
      obtvalformulaccoretroactivo.this.AV46valorUniPalabra = aP13;
      obtvalformulaccoretroactivo.this.AV45valorGenPalabra = aP14;
      obtvalformulaccoretroactivo.this.AV43totalPalabra = aP15;
      obtvalformulaccoretroactivo.this.AV23Devolver = aP16;
      obtvalformulaccoretroactivo.this.AV37ProcesoLiquidacion = aP17;
      obtvalformulaccoretroactivo.this.aP18 = aP18;
      obtvalformulaccoretroactivo.this.aP19 = aP19;
      obtvalformulaccoretroactivo.this.aP20 = aP20;
      obtvalformulaccoretroactivo.this.aP21 = aP21;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV30LiqDCalculado = (byte)(1) ;
      AV25Importe = DecimalUtil.ZERO ;
      GXv_int1[0] = (short)(0) ;
      GXv_int2[0] = AV60mes ;
      GXv_int3[0] = (byte)(0) ;
      GXv_date4[0] = AV33LiqPeriodo ;
      new web.convertirnum6afecha(remoteHandle, context).execute( AV59PeriodoNum6, GXv_int1, GXv_int2, GXv_int3, GXv_date4) ;
      obtvalformulaccoretroactivo.this.AV60mes = GXv_int2[0] ;
      obtvalformulaccoretroactivo.this.AV33LiqPeriodo = GXv_date4[0] ;
      /* Optimized group. */
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV15ConceptoPar ,
                                           A394DConCodigo ,
                                           A464DTipoConCod ,
                                           AV52TipoConCod ,
                                           AV57busquedaTLiqCod ,
                                           Integer.valueOf(AV56LiqRelNro) ,
                                           AV33LiqPeriodo } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.DATE
                                           }
      });
      /* Using cursor P01ZL2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV14CliCod), Short.valueOf(AV24EmpCod), Integer.valueOf(AV29LegNumero), AV57busquedaTLiqCod, Integer.valueOf(AV56LiqRelNro), AV33LiqPeriodo, AV15ConceptoPar, AV52TipoConCod});
      c269LiqDCanti = (short)(DecimalUtil.decToDouble(P01ZL2_A269LiqDCanti[0])) ;
      n269LiqDCanti = P01ZL2_n269LiqDCanti[0] ;
      c764LiqDImpReCalcu = P01ZL2_A764LiqDImpReCalcu[0] ;
      c507LiqDCalculado = P01ZL2_A507LiqDCalculado[0] ;
      c763LiqDRecalculado = P01ZL2_A763LiqDRecalculado[0] ;
      cV58cant = P01ZL2_AV58cant[0] ;
      pr_default.close(0);
      AV11cantidadCalculada = (short)(AV11cantidadCalculada+c269LiqDCanti) ;
      AV53auxLiqDImpReCalcu = AV53auxLiqDImpReCalcu.add(c764LiqDImpReCalcu) ;
      AV54auxLiqDCalculado = (short)(AV54auxLiqDCalculado+c507LiqDCalculado) ;
      AV55auxLiqDRecalculado = (short)(AV55auxLiqDRecalculado+c763LiqDRecalculado) ;
      AV58cant = (short)(AV58cant+cV58cant*1) ;
      /* End optimized group. */
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&auxLiqDCalculado: ", "")+GXutil.trim( GXutil.str( AV54auxLiqDCalculado, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&auxLiqDRecalculado: ", "")+GXutil.trim( GXutil.str( AV55auxLiqDRecalculado, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&&cant: ", "")+GXutil.trim( GXutil.str( AV58cant, 4, 0))) ;
      if ( GXutil.strcmp(AV23Devolver, AV12cantidadPalabra) == 0 )
      {
         AV25Importe = DecimalUtil.doubleToDec(AV11cantidadCalculada) ;
      }
      else
      {
         AV25Importe = AV53auxLiqDImpReCalcu ;
      }
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&&busquedaTLiqCod: ", "")+GXutil.trim( AV57busquedaTLiqCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&LiqDCalculado: ", "")+GXutil.trim( GXutil.str( AV30LiqDCalculado, 1, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&Importe: ", "")+GXutil.trim( GXutil.str( AV25Importe, 14, 4))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&ConceptoPar: ", "")+GXutil.trim( AV15ConceptoPar)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV14CliCod, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&EmpCod: ", "")+GXutil.trim( GXutil.str( AV24EmpCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&LegNumero: ", "")+GXutil.trim( GXutil.str( AV29LegNumero, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&TipoConCod: ", "")+GXutil.trim( AV52TipoConCod)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&cantidadCalculada: ", "")+GXutil.trim( GXutil.str( AV11cantidadCalculada, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&auxLiqDImpReCalcu: ", "")+GXutil.trim( GXutil.str( AV53auxLiqDImpReCalcu, 14, 2))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&LiqRelNro: ", "")+GXutil.trim( GXutil.str( AV56LiqRelNro, 8, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&ConCodigo: ", "")+GXutil.trim( AV17ConCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&ProcesoLiquidacion: ", "")+GXutil.trim( AV37ProcesoLiquidacion)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&Devolver: ", "")+GXutil.trim( AV23Devolver)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&cantidadPalabra: ", "")+GXutil.trim( AV12cantidadPalabra)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV64Pgmname, httpContext.getMessage( "&liqdlog: ", "")+GXutil.trim( AV31LiqDLog)) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP18[0] = obtvalformulaccoretroactivo.this.AV25Importe;
      this.aP19[0] = obtvalformulaccoretroactivo.this.AV30LiqDCalculado;
      this.aP20[0] = obtvalformulaccoretroactivo.this.AV11cantidadCalculada;
      this.aP21[0] = obtvalformulaccoretroactivo.this.AV31LiqDLog;
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
      GXv_int1 = new short[1] ;
      GXv_int2 = new byte[1] ;
      GXv_int3 = new byte[1] ;
      AV33LiqPeriodo = GXutil.nullDate() ;
      GXv_date4 = new java.util.Date[1] ;
      c764LiqDImpReCalcu = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      P01ZL2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZL2_n269LiqDCanti = new boolean[] {false} ;
      P01ZL2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01ZL2_A507LiqDCalculado = new short[1] ;
      P01ZL2_A763LiqDRecalculado = new short[1] ;
      P01ZL2_AV58cant = new short[1] ;
      AV53auxLiqDImpReCalcu = DecimalUtil.ZERO ;
      AV64Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtvalformulaccoretroactivo__default(),
         new Object[] {
             new Object[] {
            P01ZL2_A269LiqDCanti, P01ZL2_n269LiqDCanti, P01ZL2_A764LiqDImpReCalcu, P01ZL2_A507LiqDCalculado, P01ZL2_A763LiqDRecalculado, P01ZL2_AV58cant
            }
         }
      );
      AV64Pgmname = "ObtValFormulaCCORetroactivo" ;
      /* GeneXus formulas. */
      AV64Pgmname = "ObtValFormulaCCORetroactivo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV30LiqDCalculado ;
   private byte AV60mes ;
   private byte GXv_int2[] ;
   private byte GXv_int3[] ;
   private short AV24EmpCod ;
   private short AV11cantidadCalculada ;
   private short GXv_int1[] ;
   private short c269LiqDCanti ;
   private short c507LiqDCalculado ;
   private short c763LiqDRecalculado ;
   private short cV58cant ;
   private short AV54auxLiqDCalculado ;
   private short AV55auxLiqDRecalculado ;
   private short AV58cant ;
   private short Gx_err ;
   private int AV14CliCod ;
   private int AV32LiqNro ;
   private int AV59PeriodoNum6 ;
   private int AV56LiqRelNro ;
   private int AV29LegNumero ;
   private java.math.BigDecimal AV25Importe ;
   private java.math.BigDecimal c764LiqDImpReCalcu ;
   private java.math.BigDecimal AV53auxLiqDImpReCalcu ;
   private String AV17ConCodigo ;
   private String AV15ConceptoPar ;
   private String AV52TipoConCod ;
   private String AV57busquedaTLiqCod ;
   private String AV12cantidadPalabra ;
   private String AV26importePalabra ;
   private String AV46valorUniPalabra ;
   private String AV45valorGenPalabra ;
   private String AV43totalPalabra ;
   private String AV23Devolver ;
   private String AV37ProcesoLiquidacion ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private String AV64Pgmname ;
   private java.util.Date AV33LiqPeriodo ;
   private java.util.Date GXv_date4[] ;
   private boolean AV27insertandoConceptos ;
   private boolean n269LiqDCanti ;
   private String AV31LiqDLog ;
   private String[] aP21 ;
   private java.math.BigDecimal[] aP18 ;
   private byte[] aP19 ;
   private short[] aP20 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01ZL2_A269LiqDCanti ;
   private boolean[] P01ZL2_n269LiqDCanti ;
   private java.math.BigDecimal[] P01ZL2_A764LiqDImpReCalcu ;
   private short[] P01ZL2_A507LiqDCalculado ;
   private short[] P01ZL2_A763LiqDRecalculado ;
   private short[] P01ZL2_AV58cant ;
}

final  class obtvalformulaccoretroactivo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01ZL2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV15ConceptoPar ,
                                          String A394DConCodigo ,
                                          String A464DTipoConCod ,
                                          String AV52TipoConCod ,
                                          String AV57busquedaTLiqCod ,
                                          int AV56LiqRelNro ,
                                          java.util.Date AV33LiqPeriodo )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[8];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT SUM(T1.LiqDCanti), SUM(T1.LiqDImpReCalcu), SUM(T1.LiqDCalculado), SUM(T1.LiqDRecalculado), COUNT(*) FROM (LiquidacionDetalle T1 INNER JOIN Liquidacion T2" ;
      scmdbuf += " ON T2.CliCod = T1.CliCod AND T2.EmpCod = T1.EmpCod AND T2.LiqNro = T1.LiqNro)" ;
      addWhere(sWhereString, "(T1.CliCod = ? and T1.EmpCod = ? and T1.LegNumero = ?)");
      addWhere(sWhereString, "(T1.DTLiqCod = ( ?))");
      addWhere(sWhereString, "(T2.LiqRelNro = ?)");
      addWhere(sWhereString, "(T1.DLiqPeriodo = ?)");
      if ( ! (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DConCodigo = ( ?))");
      }
      else
      {
         GXv_int5[6] = (byte)(1) ;
      }
      if ( (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         addWhere(sWhereString, "(T1.DTipoConCod = ( ?))");
      }
      else
      {
         GXv_int5[7] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      if ( ! (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         scmdbuf += "" ;
      }
      else if ( (GXutil.strcmp("", AV15ConceptoPar)==0) )
      {
         scmdbuf += "" ;
      }
      GXv_Object6[0] = scmdbuf ;
      GXv_Object6[1] = GXv_int5 ;
      return GXv_Object6 ;
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
                  return conditional_P01ZL2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , ((Number) dynConstraints[5]).intValue() , (java.util.Date)dynConstraints[6] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01ZL2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[3])[0] = rslt.getShort(3);
               ((short[]) buf[4])[0] = rslt.getShort(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
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
                  stmt.setInt(sIdx, ((Number) parms[8]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[9]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 20);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[12]).intValue());
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[13]);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[14], 10);
               }
               if ( ((Number) parms[7]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[15], 20);
               }
               return;
      }
   }

}

