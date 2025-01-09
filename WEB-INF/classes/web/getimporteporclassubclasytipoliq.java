package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getimporteporclassubclasytipoliq extends GXProcedure
{
   public getimporteporclassubclasytipoliq( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getimporteporclassubclasytipoliq.class ), "" );
   }

   public getimporteporclassubclasytipoliq( int remoteHandle ,
                                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           String aP4 ,
                           String aP5 ,
                           String aP6 ,
                           java.util.Date aP7 ,
                           String aP8 ,
                           boolean aP9 ,
                           java.math.BigDecimal[] aP10 ,
                           java.math.BigDecimal[] aP11 ,
                           boolean[] aP12 ,
                           short[] aP13 )
   {
      getimporteporclassubclasytipoliq.this.aP14 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
      return aP14[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        String aP4 ,
                        String aP5 ,
                        String aP6 ,
                        java.util.Date aP7 ,
                        String aP8 ,
                        boolean aP9 ,
                        java.math.BigDecimal[] aP10 ,
                        java.math.BigDecimal[] aP11 ,
                        boolean[] aP12 ,
                        short[] aP13 ,
                        byte[] aP14 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             String aP4 ,
                             String aP5 ,
                             String aP6 ,
                             java.util.Date aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             boolean[] aP12 ,
                             short[] aP13 ,
                             byte[] aP14 )
   {
      getimporteporclassubclasytipoliq.this.AV13CliCod = aP0;
      getimporteporclassubclasytipoliq.this.AV8EmpCod = aP1;
      getimporteporclassubclasytipoliq.this.AV10LegNumero = aP2;
      getimporteporclassubclasytipoliq.this.AV9LiqNro = aP3;
      getimporteporclassubclasytipoliq.this.AV23DSubTipoConCod1 = aP4;
      getimporteporclassubclasytipoliq.this.AV24DSubTipoConCod2 = aP5;
      getimporteporclassubclasytipoliq.this.AV30TLiqCod = aP6;
      getimporteporclassubclasytipoliq.this.AV31LiqPeriodo = aP7;
      getimporteporclassubclasytipoliq.this.AV20ProcesoLiquidacion = aP8;
      getimporteporclassubclasytipoliq.this.AV26soloNovedades = aP9;
      getimporteporclassubclasytipoliq.this.aP10 = aP10;
      getimporteporclassubclasytipoliq.this.aP11 = aP11;
      getimporteporclassubclasytipoliq.this.aP12 = aP12;
      getimporteporclassubclasytipoliq.this.aP13 = aP13;
      getimporteporclassubclasytipoliq.this.aP14 = aP14;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&DSubTipoConCod1 ", "")+GXutil.trim( AV23DSubTipoConCod1)+httpContext.getMessage( " subtipo 2", "")+GXutil.trim( AV24DSubTipoConCod2)+httpContext.getMessage( " &CliCod ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))+httpContext.getMessage( " &EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))+httpContext.getMessage( " &DSubTipoConCod2 ", "")+GXutil.trim( AV24DSubTipoConCod2)+httpContext.getMessage( " &soloNovedades ", "")+GXutil.trim( GXutil.booltostr( AV26soloNovedades))) ;
      AV37GXLvl7 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV24DSubTipoConCod2 ,
                                           Boolean.valueOf(AV26soloNovedades) ,
                                           A732DSubTipoConCod2 ,
                                           Boolean.valueOf(A1073LiqDNovedad) ,
                                           A468DSubTipoConCod1 ,
                                           AV23DSubTipoConCod1 ,
                                           Integer.valueOf(AV13CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                           TypeConstants.INT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01902 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV23DSubTipoConCod1, AV24DSubTipoConCod2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1073LiqDNovedad = P01902_A1073LiqDNovedad[0] ;
         A732DSubTipoConCod2 = P01902_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P01902_n732DSubTipoConCod2[0] ;
         A468DSubTipoConCod1 = P01902_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01902_n468DSubTipoConCod1[0] ;
         A31LiqNro = P01902_A31LiqNro[0] ;
         A6LegNumero = P01902_A6LegNumero[0] ;
         A1EmpCod = P01902_A1EmpCod[0] ;
         A3CliCod = P01902_A3CliCod[0] ;
         A394DConCodigo = P01902_A394DConCodigo[0] ;
         A764LiqDImpReCalcu = P01902_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P01902_A269LiqDCanti[0] ;
         n269LiqDCanti = P01902_n269LiqDCanti[0] ;
         A507LiqDCalculado = P01902_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01902_A763LiqDRecalculado[0] ;
         A81LiqDSecuencial = P01902_A81LiqDSecuencial[0] ;
         AV37GXLvl7 = (byte)(1) ;
         GXv_boolean1[0] = AV29aplica ;
         new web.conceptoaplicatipoliq(remoteHandle, context).execute( AV13CliCod, AV8EmpCod, AV9LiqNro, AV10LegNumero, A394DConCodigo, AV30TLiqCod, GXv_boolean1) ;
         getimporteporclassubclasytipoliq.this.AV29aplica = GXv_boolean1[0] ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "dconcodigo ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " aplica ", "")+GXutil.trim( GXutil.booltostr( AV29aplica))) ;
         if ( AV29aplica )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, "1") ;
            AV22cantidadPeriodos = (short)(AV22cantidadPeriodos+1) ;
            AV14existe = true ;
            GXt_boolean2 = AV21ConRecalcular ;
            GXv_boolean1[0] = GXt_boolean2 ;
            new web.conceptorecalcula(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, GXv_boolean1) ;
            getimporteporclassubclasytipoliq.this.GXt_boolean2 = GXv_boolean1[0] ;
            AV21ConRecalcular = GXt_boolean2 ;
            AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
            if ( A764LiqDImpReCalcu.doubleValue() > 0 )
            {
               AV32LiqDCanti = AV32LiqDCanti.add(A269LiqDCanti) ;
            }
            GXt_int3 = AV15LiqDCalculado ;
            GXv_int4[0] = GXt_int3 ;
            new web.dependenciaresuelta(remoteHandle, context).execute( AV13CliCod, AV21ConRecalcular, AV20ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, A31LiqNro, 0, AV11ConCodigo, A394DConCodigo, GXv_int4) ;
            getimporteporclassubclasytipoliq.this.GXt_int3 = GXv_int4[0] ;
            AV15LiqDCalculado = (byte)(GXt_int3) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "2 &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV15LiqDCalculado, 1, 0))+httpContext.getMessage( " &LiqDImpCalcu ", "")+GXutil.trim( GXutil.str( AV12LiqDImpCalcu, 14, 2))+httpContext.getMessage( " &LiqDCanti ", "")+GXutil.trim( GXutil.str( AV32LiqDCanti, 14, 2))) ;
            if ( AV15LiqDCalculado == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "exit", "")) ;
               /* Exit For each command. Update data (if necessary), close cursors & exit. */
               if (true) break;
            }
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV37GXLvl7 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "none", "")) ;
      }
      if ( false )
      {
         new web.pendientesdeoptimizarcasesensitive(remoteHandle, context).execute( ) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = getimporteporclassubclasytipoliq.this.AV12LiqDImpCalcu;
      this.aP11[0] = getimporteporclassubclasytipoliq.this.AV32LiqDCanti;
      this.aP12[0] = getimporteporclassubclasytipoliq.this.AV14existe;
      this.aP13[0] = getimporteporclassubclasytipoliq.this.AV22cantidadPeriodos;
      this.aP14[0] = getimporteporclassubclasytipoliq.this.AV15LiqDCalculado;
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
      AV32LiqDCanti = DecimalUtil.ZERO ;
      AV36Pgmname = "" ;
      scmdbuf = "" ;
      A732DSubTipoConCod2 = "" ;
      A468DSubTipoConCod1 = "" ;
      P01902_A1073LiqDNovedad = new boolean[] {false} ;
      P01902_A732DSubTipoConCod2 = new String[] {""} ;
      P01902_n732DSubTipoConCod2 = new boolean[] {false} ;
      P01902_A468DSubTipoConCod1 = new String[] {""} ;
      P01902_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01902_A31LiqNro = new int[1] ;
      P01902_A6LegNumero = new int[1] ;
      P01902_A1EmpCod = new short[1] ;
      P01902_A3CliCod = new int[1] ;
      P01902_A394DConCodigo = new String[] {""} ;
      P01902_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01902_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01902_n269LiqDCanti = new boolean[] {false} ;
      P01902_A507LiqDCalculado = new byte[1] ;
      P01902_A763LiqDRecalculado = new short[1] ;
      P01902_A81LiqDSecuencial = new int[1] ;
      A394DConCodigo = "" ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      GXv_boolean1 = new boolean[1] ;
      AV11ConCodigo = "" ;
      GXv_int4 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getimporteporclassubclasytipoliq__default(),
         new Object[] {
             new Object[] {
            P01902_A1073LiqDNovedad, P01902_A732DSubTipoConCod2, P01902_n732DSubTipoConCod2, P01902_A468DSubTipoConCod1, P01902_n468DSubTipoConCod1, P01902_A31LiqNro, P01902_A6LegNumero, P01902_A1EmpCod, P01902_A3CliCod, P01902_A394DConCodigo,
            P01902_A764LiqDImpReCalcu, P01902_A269LiqDCanti, P01902_n269LiqDCanti, P01902_A507LiqDCalculado, P01902_A763LiqDRecalculado, P01902_A81LiqDSecuencial
            }
         }
      );
      AV36Pgmname = "getImportePorClasSubClasYTipoLiq" ;
      /* GeneXus formulas. */
      AV36Pgmname = "getImportePorClasSubClasYTipoLiq" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV37GXLvl7 ;
   private byte A507LiqDCalculado ;
   private short AV8EmpCod ;
   private short AV22cantidadPeriodos ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short GXt_int3 ;
   private short GXv_int4[] ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV10LegNumero ;
   private int AV9LiqNro ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12LiqDImpCalcu ;
   private java.math.BigDecimal AV32LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV23DSubTipoConCod1 ;
   private String AV24DSubTipoConCod2 ;
   private String AV30TLiqCod ;
   private String AV20ProcesoLiquidacion ;
   private String AV36Pgmname ;
   private String scmdbuf ;
   private String A732DSubTipoConCod2 ;
   private String A468DSubTipoConCod1 ;
   private String A394DConCodigo ;
   private String AV11ConCodigo ;
   private java.util.Date AV31LiqPeriodo ;
   private boolean AV26soloNovedades ;
   private boolean AV14existe ;
   private boolean A1073LiqDNovedad ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean AV29aplica ;
   private boolean AV21ConRecalcular ;
   private boolean GXt_boolean2 ;
   private boolean GXv_boolean1[] ;
   private byte[] aP14 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private boolean[] aP12 ;
   private short[] aP13 ;
   private IDataStoreProvider pr_default ;
   private boolean[] P01902_A1073LiqDNovedad ;
   private String[] P01902_A732DSubTipoConCod2 ;
   private boolean[] P01902_n732DSubTipoConCod2 ;
   private String[] P01902_A468DSubTipoConCod1 ;
   private boolean[] P01902_n468DSubTipoConCod1 ;
   private int[] P01902_A31LiqNro ;
   private int[] P01902_A6LegNumero ;
   private short[] P01902_A1EmpCod ;
   private int[] P01902_A3CliCod ;
   private String[] P01902_A394DConCodigo ;
   private java.math.BigDecimal[] P01902_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P01902_A269LiqDCanti ;
   private boolean[] P01902_n269LiqDCanti ;
   private byte[] P01902_A507LiqDCalculado ;
   private short[] P01902_A763LiqDRecalculado ;
   private int[] P01902_A81LiqDSecuencial ;
}

final  class getimporteporclassubclasytipoliq__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01902( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV24DSubTipoConCod2 ,
                                          boolean AV26soloNovedades ,
                                          String A732DSubTipoConCod2 ,
                                          boolean A1073LiqDNovedad ,
                                          String A468DSubTipoConCod1 ,
                                          String AV23DSubTipoConCod1 ,
                                          int AV13CliCod ,
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
      byte[] GXv_int5 = new byte[6];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT LiqDNovedad, DSubTipoConCod2, DSubTipoConCod1, LiqNro, LegNumero, EmpCod, CliCod, DConCodigo, LiqDImpReCalcu, LiqDCanti, LiqDCalculado, LiqDRecalculado, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(RTRIM(LTRIM(DSubTipoConCod1)) = ( RTRIM(LTRIM(?))))");
      if ( ! (GXutil.strcmp("", AV24DSubTipoConCod2)==0) )
      {
         addWhere(sWhereString, "(RTRIM(LTRIM(DSubTipoConCod2)) = ( RTRIM(LTRIM(?))))");
      }
      else
      {
         GXv_int5[5] = (byte)(1) ;
      }
      if ( AV26soloNovedades )
      {
         addWhere(sWhereString, "(LiqDNovedad = TRUE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DSubTipoConCod1" ;
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
                  return conditional_P01902(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Boolean) dynConstraints[3]).booleanValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).shortValue() , ((Number) dynConstraints[12]).intValue() , ((Number) dynConstraints[13]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01902", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((boolean[]) buf[0])[0] = rslt.getBoolean(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((String[]) buf[3])[0] = rslt.getString(3, 20);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((int[]) buf[5])[0] = rslt.getInt(4);
               ((int[]) buf[6])[0] = rslt.getInt(5);
               ((short[]) buf[7])[0] = rslt.getShort(6);
               ((int[]) buf[8])[0] = rslt.getInt(7);
               ((String[]) buf[9])[0] = rslt.getString(8, 10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((byte[]) buf[13])[0] = rslt.getByte(11);
               ((short[]) buf[14])[0] = rslt.getShort(12);
               ((int[]) buf[15])[0] = rslt.getInt(13);
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
                  stmt.setString(sIdx, (String)parms[10], 20);
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

