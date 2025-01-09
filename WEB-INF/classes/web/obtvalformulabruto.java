package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class obtvalformulabruto extends GXProcedure
{
   public obtvalformulabruto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( obtvalformulabruto.class ), "" );
   }

   public obtvalformulabruto( int remoteHandle ,
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
                             String aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 )
   {
      obtvalformulabruto.this.aP12 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
      return aP12[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        String aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        byte[] aP11 ,
                        String[] aP12 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             String aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             byte[] aP11 ,
                             String[] aP12 )
   {
      obtvalformulabruto.this.AV12CliCod = aP0;
      obtvalformulabruto.this.AV8EmpCod = aP1;
      obtvalformulabruto.this.AV9LiqNro = aP2;
      obtvalformulabruto.this.AV10LegNumero = aP3;
      obtvalformulabruto.this.AV25LiqPeriodo = aP4;
      obtvalformulabruto.this.AV19ConCodigo = aP5;
      obtvalformulabruto.this.AV27DSubTipoConCod1 = aP6;
      obtvalformulabruto.this.AV28ProcesoLiquidacion = aP7;
      obtvalformulabruto.this.AV17insertandoConceptos = aP8;
      obtvalformulabruto.this.AV18idOperando = aP9;
      obtvalformulabruto.this.aP10 = aP10;
      obtvalformulabruto.this.aP11 = aP11;
      obtvalformulabruto.this.aP12 = aP12;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11Importe = DecimalUtil.ZERO ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      AV13LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "&concodigo ", "")+GXutil.trim( AV19ConCodigo)) ;
      if ( (0==AV9LiqNro) )
      {
         GXv_decimal1[0] = AV11Importe ;
         GXv_char2[0] = AV26LiqDLog ;
         new web.formula_agenda(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV10LegNumero, "NRE_ARG", "REM_ARG", AV25LiqPeriodo, GXutil.eomdate( AV25LiqPeriodo), GXv_decimal1, GXv_char2) ;
         obtvalformulabruto.this.AV11Importe = GXv_decimal1[0] ;
         obtvalformulabruto.this.AV26LiqDLog = GXv_char2[0] ;
      }
      else
      {
         GXt_char3 = AV31redondeoConCodigo ;
         GXt_char4 = AV31redondeoConCodigo ;
         GXv_char2[0] = GXt_char4 ;
         new web.concepto_redondeo_codigoparam(remoteHandle, context).execute( GXv_char2) ;
         obtvalformulabruto.this.GXt_char4 = GXv_char2[0] ;
         GXv_char5[0] = GXt_char3 ;
         new web.getparametro(remoteHandle, context).execute( AV12CliCod, GXt_char4, GXv_char5) ;
         obtvalformulabruto.this.GXt_char3 = GXv_char5[0] ;
         AV31redondeoConCodigo = GXt_char3 ;
         AV35GXLvl13 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              AV27DSubTipoConCod1 ,
                                              A468DSubTipoConCod1 ,
                                              A464DTipoConCod ,
                                              A394DConCodigo ,
                                              AV19ConCodigo ,
                                              AV31redondeoConCodigo ,
                                              Integer.valueOf(AV12CliCod) ,
                                              Short.valueOf(AV8EmpCod) ,
                                              Integer.valueOf(AV9LiqNro) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                              }
         });
         /* Using cursor P00UM2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV19ConCodigo, AV31redondeoConCodigo, AV27DSubTipoConCod1});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A468DSubTipoConCod1 = P00UM2_A468DSubTipoConCod1[0] ;
            n468DSubTipoConCod1 = P00UM2_n468DSubTipoConCod1[0] ;
            A394DConCodigo = P00UM2_A394DConCodigo[0] ;
            A464DTipoConCod = P00UM2_A464DTipoConCod[0] ;
            A6LegNumero = P00UM2_A6LegNumero[0] ;
            A31LiqNro = P00UM2_A31LiqNro[0] ;
            A1EmpCod = P00UM2_A1EmpCod[0] ;
            A3CliCod = P00UM2_A3CliCod[0] ;
            A764LiqDImpReCalcu = P00UM2_A764LiqDImpReCalcu[0] ;
            A507LiqDCalculado = P00UM2_A507LiqDCalculado[0] ;
            A763LiqDRecalculado = P00UM2_A763LiqDRecalculado[0] ;
            A393DConDescrip = P00UM2_A393DConDescrip[0] ;
            A274LiqDFormula = P00UM2_A274LiqDFormula[0] ;
            n274LiqDFormula = P00UM2_n274LiqDFormula[0] ;
            A81LiqDSecuencial = P00UM2_A81LiqDSecuencial[0] ;
            AV35GXLvl13 = (byte)(1) ;
            AV11Importe = AV11Importe.add(A764LiqDImpReCalcu) ;
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "&recorre  ", "")+GXutil.trim( A394DConCodigo)) ;
            GXv_int6[0] = AV30auxLiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV12CliCod, A394DConCodigo, AV28ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int6) ;
            obtvalformulabruto.this.AV30auxLiqDCalculado = GXv_int6[0] ;
            if ( AV30auxLiqDCalculado == 0 )
            {
               AV13LiqDCalculado = (byte)(0) ;
               AV22error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
               new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "return dconcodigo ", "")+A394DConCodigo) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV20collection_ConCodigo.add(GXutil.trim( A394DConCodigo), 0);
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "recorre concepto ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " formula ", "")+GXutil.trim( A274LiqDFormula)+httpContext.getMessage( " LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV13LiqDCalculado, 1, 0))+httpContext.getMessage( " importe ", "")+GXutil.trim( GXutil.str( AV11Importe, 14, 2))) ;
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV35GXLvl13 == 0 )
         {
            new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      new web.msgdebug_prod2(remoteHandle, context).execute( AV12CliCod, AV34Pgmname, httpContext.getMessage( "calculado ", "")+GXutil.trim( GXutil.str( AV13LiqDCalculado, 1, 0))) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = obtvalformulabruto.this.AV11Importe;
      this.aP11[0] = obtvalformulabruto.this.AV13LiqDCalculado;
      this.aP12[0] = obtvalformulabruto.this.AV22error;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11Importe = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV34Pgmname = "" ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV26LiqDLog = "" ;
      AV31redondeoConCodigo = "" ;
      GXt_char3 = "" ;
      GXt_char4 = "" ;
      GXv_char2 = new String[1] ;
      GXv_char5 = new String[1] ;
      scmdbuf = "" ;
      A468DSubTipoConCod1 = "" ;
      A464DTipoConCod = "" ;
      A394DConCodigo = "" ;
      P00UM2_A468DSubTipoConCod1 = new String[] {""} ;
      P00UM2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P00UM2_A394DConCodigo = new String[] {""} ;
      P00UM2_A464DTipoConCod = new String[] {""} ;
      P00UM2_A6LegNumero = new int[1] ;
      P00UM2_A31LiqNro = new int[1] ;
      P00UM2_A1EmpCod = new short[1] ;
      P00UM2_A3CliCod = new int[1] ;
      P00UM2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P00UM2_A507LiqDCalculado = new byte[1] ;
      P00UM2_A763LiqDRecalculado = new short[1] ;
      P00UM2_A393DConDescrip = new String[] {""} ;
      P00UM2_A274LiqDFormula = new String[] {""} ;
      P00UM2_n274LiqDFormula = new boolean[] {false} ;
      P00UM2_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A393DConDescrip = "" ;
      A274LiqDFormula = "" ;
      GXv_int6 = new byte[1] ;
      AV20collection_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.obtvalformulabruto__default(),
         new Object[] {
             new Object[] {
            P00UM2_A468DSubTipoConCod1, P00UM2_n468DSubTipoConCod1, P00UM2_A394DConCodigo, P00UM2_A464DTipoConCod, P00UM2_A6LegNumero, P00UM2_A31LiqNro, P00UM2_A1EmpCod, P00UM2_A3CliCod, P00UM2_A764LiqDImpReCalcu, P00UM2_A507LiqDCalculado,
            P00UM2_A763LiqDRecalculado, P00UM2_A393DConDescrip, P00UM2_A274LiqDFormula, P00UM2_n274LiqDFormula, P00UM2_A81LiqDSecuencial
            }
         }
      );
      AV34Pgmname = "ObtValFormulaBruto" ;
      /* GeneXus formulas. */
      AV34Pgmname = "ObtValFormulaBruto" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte AV35GXLvl13 ;
   private byte A507LiqDCalculado ;
   private byte AV30auxLiqDCalculado ;
   private byte GXv_int6[] ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV12CliCod ;
   private int AV9LiqNro ;
   private int AV10LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV11Importe ;
   private java.math.BigDecimal GXv_decimal1[] ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private String AV19ConCodigo ;
   private String AV27DSubTipoConCod1 ;
   private String AV28ProcesoLiquidacion ;
   private String AV18idOperando ;
   private String AV34Pgmname ;
   private String AV31redondeoConCodigo ;
   private String GXt_char3 ;
   private String GXt_char4 ;
   private String GXv_char2[] ;
   private String GXv_char5[] ;
   private String scmdbuf ;
   private String A468DSubTipoConCod1 ;
   private String A464DTipoConCod ;
   private String A394DConCodigo ;
   private java.util.Date AV25LiqPeriodo ;
   private boolean AV17insertandoConceptos ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n274LiqDFormula ;
   private boolean returnInSub ;
   private String AV26LiqDLog ;
   private String A274LiqDFormula ;
   private String AV22error ;
   private String A393DConDescrip ;
   private String[] aP12 ;
   private java.math.BigDecimal[] aP10 ;
   private byte[] aP11 ;
   private IDataStoreProvider pr_default ;
   private String[] P00UM2_A468DSubTipoConCod1 ;
   private boolean[] P00UM2_n468DSubTipoConCod1 ;
   private String[] P00UM2_A394DConCodigo ;
   private String[] P00UM2_A464DTipoConCod ;
   private int[] P00UM2_A6LegNumero ;
   private int[] P00UM2_A31LiqNro ;
   private short[] P00UM2_A1EmpCod ;
   private int[] P00UM2_A3CliCod ;
   private java.math.BigDecimal[] P00UM2_A764LiqDImpReCalcu ;
   private byte[] P00UM2_A507LiqDCalculado ;
   private short[] P00UM2_A763LiqDRecalculado ;
   private String[] P00UM2_A393DConDescrip ;
   private String[] P00UM2_A274LiqDFormula ;
   private boolean[] P00UM2_n274LiqDFormula ;
   private int[] P00UM2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV20collection_ConCodigo ;
}

final  class obtvalformulabruto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P00UM2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV27DSubTipoConCod1 ,
                                          String A468DSubTipoConCod1 ,
                                          String A464DTipoConCod ,
                                          String A394DConCodigo ,
                                          String AV19ConCodigo ,
                                          String AV31redondeoConCodigo ,
                                          int AV12CliCod ,
                                          short AV8EmpCod ,
                                          int AV9LiqNro ,
                                          int AV10LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int7 = new byte[7];
      Object[] GXv_Object8 = new Object[2];
      scmdbuf = "SELECT DSubTipoConCod1, DConCodigo, DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDFormula, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(DTipoConCod >= ( 'NRE_ARG'))");
      addWhere(sWhereString, "(DTipoConCod <= ( 'REM_ARG'))");
      addWhere(sWhereString, "(DConCodigo <> ( ?))");
      addWhere(sWhereString, "(DConCodigo <> ( ?))");
      if ( ! (GXutil.strcmp("", AV27DSubTipoConCod1)==0) )
      {
         addWhere(sWhereString, "(DSubTipoConCod1 <> ( ?))");
      }
      else
      {
         GXv_int7[6] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
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
                  return conditional_P00UM2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , (String)dynConstraints[2] , (String)dynConstraints[3] , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00UM2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((boolean[]) buf[1])[0] = rslt.wasNull();
               ((String[]) buf[2])[0] = rslt.getString(2, 10);
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((int[]) buf[5])[0] = rslt.getInt(5);
               ((short[]) buf[6])[0] = rslt.getShort(6);
               ((int[]) buf[7])[0] = rslt.getInt(7);
               ((java.math.BigDecimal[]) buf[8])[0] = rslt.getBigDecimal(8,2);
               ((byte[]) buf[9])[0] = rslt.getByte(9);
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((String[]) buf[11])[0] = rslt.getVarchar(11);
               ((String[]) buf[12])[0] = rslt.getLongVarchar(12);
               ((boolean[]) buf[13])[0] = rslt.wasNull();
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
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[8]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[9]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[10]).intValue());
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[11], 10);
               }
               if ( ((Number) parms[5]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[12], 10);
               }
               if ( ((Number) parms[6]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[13], 20);
               }
               return;
      }
   }

}

