package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class plus_vacacional extends GXProcedure
{
   public plus_vacacional( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( plus_vacacional.class ), "" );
   }

   public plus_vacacional( int remoteHandle ,
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
                             boolean aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             short[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 )
   {
      plus_vacacional.this.aP13 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
      return aP13[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        boolean aP6 ,
                        String aP7 ,
                        boolean aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        short[] aP10 ,
                        String[] aP11 ,
                        byte[] aP12 ,
                        String[] aP13 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             boolean aP6 ,
                             String aP7 ,
                             boolean aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             short[] aP10 ,
                             String[] aP11 ,
                             byte[] aP12 ,
                             String[] aP13 )
   {
      plus_vacacional.this.AV11CliCod = aP0;
      plus_vacacional.this.AV10EmpCod = aP1;
      plus_vacacional.this.AV9LiqNro = aP2;
      plus_vacacional.this.AV8LegNumero = aP3;
      plus_vacacional.this.AV26LiqPeriodo = aP4;
      plus_vacacional.this.AV17ConCodigo = aP5;
      plus_vacacional.this.AV30vacacionesEs = aP6;
      plus_vacacional.this.AV14ProcesoLiquidacion = aP7;
      plus_vacacional.this.AV19insertandoConceptos = aP8;
      plus_vacacional.this.aP9 = aP9;
      plus_vacacional.this.aP10 = aP10;
      plus_vacacional.this.aP11 = aP11;
      plus_vacacional.this.aP12 = aP12;
      plus_vacacional.this.aP13 = aP13;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXt_char1 = AV29vacacionesDSubTipoConCod1 ;
      GXv_char2[0] = GXt_char1 ;
      new web.subtipovacaciones(remoteHandle, context).execute( GXv_char2) ;
      plus_vacacional.this.GXt_char1 = GXv_char2[0] ;
      AV29vacacionesDSubTipoConCod1 = GXt_char1 ;
      AV13LiqDCalculado = (byte)(1) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV30vacacionesEs) ,
                                           A468DSubTipoConCod1 ,
                                           AV29vacacionesDSubTipoConCod1 ,
                                           A1219LiqDPlus ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV10EmpCod) ,
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(AV8LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.DECIMAL, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P01B32 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV10EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV8LegNumero), AV29vacacionesDSubTipoConCod1, AV29vacacionesDSubTipoConCod1});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1219LiqDPlus = P01B32_A1219LiqDPlus[0] ;
         A468DSubTipoConCod1 = P01B32_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P01B32_n468DSubTipoConCod1[0] ;
         A6LegNumero = P01B32_A6LegNumero[0] ;
         A31LiqNro = P01B32_A31LiqNro[0] ;
         A1EmpCod = P01B32_A1EmpCod[0] ;
         A3CliCod = P01B32_A3CliCod[0] ;
         A269LiqDCanti = P01B32_A269LiqDCanti[0] ;
         n269LiqDCanti = P01B32_n269LiqDCanti[0] ;
         A764LiqDImpReCalcu = P01B32_A764LiqDImpReCalcu[0] ;
         A394DConCodigo = P01B32_A394DConCodigo[0] ;
         A507LiqDCalculado = P01B32_A507LiqDCalculado[0] ;
         A763LiqDRecalculado = P01B32_A763LiqDRecalculado[0] ;
         A393DConDescrip = P01B32_A393DConDescrip[0] ;
         A81LiqDSecuencial = P01B32_A81LiqDSecuencial[0] ;
         AV27cant = (short)(DecimalUtil.decToDouble(DecimalUtil.doubleToDec(AV27cant).add(A269LiqDCanti))) ;
         AV28LiqDImpReCalcu = A764LiqDImpReCalcu ;
         new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
         GXv_int3[0] = AV13LiqDCalculado ;
         new web.dependenciaresuelta2(remoteHandle, context).execute( AV11CliCod, A394DConCodigo, AV14ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
         plus_vacacional.this.AV13LiqDCalculado = GXv_int3[0] ;
         if ( AV13LiqDCalculado == 0 )
         {
            AV22error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A394DConCodigo) ;
            AV21LiqDLog = GXutil.trim( AV22error) ;
            pr_default.close(0);
            returnInSub = true;
            cleanup();
            if (true) return;
         }
         AV21LiqDLog += GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2)) + httpContext.getMessage( " de ", "") + GXutil.trim( A393DConDescrip) + httpContext.getMessage( " por plus ", "") + GXutil.trim( GXutil.str( A1219LiqDPlus, 6, 4)) ;
         AV28LiqDImpReCalcu = AV28LiqDImpReCalcu.multiply(A1219LiqDPlus) ;
         AV21LiqDLog += httpContext.getMessage( " (suma ", "") + GXutil.trim( GXutil.str( AV28LiqDImpReCalcu, 14, 2)) + ")" ;
         AV12Importes = AV12Importes.add(AV28LiqDImpReCalcu) ;
         AV15collection_ConCodigo.add(GXutil.trim( A394DConCodigo), 0);
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = plus_vacacional.this.AV12Importes;
      this.aP10[0] = plus_vacacional.this.AV27cant;
      this.aP11[0] = plus_vacacional.this.AV22error;
      this.aP12[0] = plus_vacacional.this.AV13LiqDCalculado;
      this.aP13[0] = plus_vacacional.this.AV21LiqDLog;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV12Importes = DecimalUtil.ZERO ;
      AV22error = "" ;
      AV21LiqDLog = "" ;
      AV29vacacionesDSubTipoConCod1 = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      scmdbuf = "" ;
      A468DSubTipoConCod1 = "" ;
      A1219LiqDPlus = DecimalUtil.ZERO ;
      P01B32_A1219LiqDPlus = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01B32_A468DSubTipoConCod1 = new String[] {""} ;
      P01B32_n468DSubTipoConCod1 = new boolean[] {false} ;
      P01B32_A6LegNumero = new int[1] ;
      P01B32_A31LiqNro = new int[1] ;
      P01B32_A1EmpCod = new short[1] ;
      P01B32_A3CliCod = new int[1] ;
      P01B32_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01B32_n269LiqDCanti = new boolean[] {false} ;
      P01B32_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P01B32_A394DConCodigo = new String[] {""} ;
      P01B32_A507LiqDCalculado = new byte[1] ;
      P01B32_A763LiqDRecalculado = new short[1] ;
      P01B32_A393DConDescrip = new String[] {""} ;
      P01B32_A81LiqDSecuencial = new int[1] ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A394DConCodigo = "" ;
      A393DConDescrip = "" ;
      AV28LiqDImpReCalcu = DecimalUtil.ZERO ;
      GXv_int3 = new byte[1] ;
      AV15collection_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.plus_vacacional__default(),
         new Object[] {
             new Object[] {
            P01B32_A1219LiqDPlus, P01B32_A468DSubTipoConCod1, P01B32_n468DSubTipoConCod1, P01B32_A6LegNumero, P01B32_A31LiqNro, P01B32_A1EmpCod, P01B32_A3CliCod, P01B32_A269LiqDCanti, P01B32_n269LiqDCanti, P01B32_A764LiqDImpReCalcu,
            P01B32_A394DConCodigo, P01B32_A507LiqDCalculado, P01B32_A763LiqDRecalculado, P01B32_A393DConDescrip, P01B32_A81LiqDSecuencial
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte A507LiqDCalculado ;
   private byte GXv_int3[] ;
   private short AV10EmpCod ;
   private short AV27cant ;
   private short A1EmpCod ;
   private short A763LiqDRecalculado ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV9LiqNro ;
   private int AV8LegNumero ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private int A6LegNumero ;
   private int A81LiqDSecuencial ;
   private java.math.BigDecimal AV12Importes ;
   private java.math.BigDecimal A1219LiqDPlus ;
   private java.math.BigDecimal A269LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal AV28LiqDImpReCalcu ;
   private String AV17ConCodigo ;
   private String AV14ProcesoLiquidacion ;
   private String AV29vacacionesDSubTipoConCod1 ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A468DSubTipoConCod1 ;
   private String A394DConCodigo ;
   private java.util.Date AV26LiqPeriodo ;
   private boolean AV30vacacionesEs ;
   private boolean AV19insertandoConceptos ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n269LiqDCanti ;
   private boolean returnInSub ;
   private String AV21LiqDLog ;
   private String AV22error ;
   private String A393DConDescrip ;
   private String[] aP13 ;
   private java.math.BigDecimal[] aP9 ;
   private short[] aP10 ;
   private String[] aP11 ;
   private byte[] aP12 ;
   private IDataStoreProvider pr_default ;
   private java.math.BigDecimal[] P01B32_A1219LiqDPlus ;
   private String[] P01B32_A468DSubTipoConCod1 ;
   private boolean[] P01B32_n468DSubTipoConCod1 ;
   private int[] P01B32_A6LegNumero ;
   private int[] P01B32_A31LiqNro ;
   private short[] P01B32_A1EmpCod ;
   private int[] P01B32_A3CliCod ;
   private java.math.BigDecimal[] P01B32_A269LiqDCanti ;
   private boolean[] P01B32_n269LiqDCanti ;
   private java.math.BigDecimal[] P01B32_A764LiqDImpReCalcu ;
   private String[] P01B32_A394DConCodigo ;
   private byte[] P01B32_A507LiqDCalculado ;
   private short[] P01B32_A763LiqDRecalculado ;
   private String[] P01B32_A393DConDescrip ;
   private int[] P01B32_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV15collection_ConCodigo ;
}

final  class plus_vacacional__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P01B32( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV30vacacionesEs ,
                                          String A468DSubTipoConCod1 ,
                                          String AV29vacacionesDSubTipoConCod1 ,
                                          java.math.BigDecimal A1219LiqDPlus ,
                                          int AV11CliCod ,
                                          short AV10EmpCod ,
                                          int AV9LiqNro ,
                                          int AV8LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[6];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT LiqDPlus, DSubTipoConCod1, LegNumero, LiqNro, EmpCod, CliCod, LiqDCanti, LiqDImpReCalcu, DConCodigo, LiqDCalculado, LiqDRecalculado, DConDescrip, LiqDSecuencial" ;
      scmdbuf += " FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ?)");
      addWhere(sWhereString, "(LiqDPlus > 0)");
      if ( AV30vacacionesEs )
      {
         addWhere(sWhereString, "(DSubTipoConCod1 = ( ?))");
      }
      else
      {
         GXv_int4[4] = (byte)(1) ;
      }
      if ( ! AV30vacacionesEs )
      {
         addWhere(sWhereString, "(DSubTipoConCod1 <> ( ?))");
      }
      else
      {
         GXv_int4[5] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero" ;
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
                  return conditional_P01B32(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , (String)dynConstraints[1] , (String)dynConstraints[2] , (java.math.BigDecimal)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).shortValue() , ((Number) dynConstraints[10]).intValue() , ((Number) dynConstraints[11]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01B32", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((java.math.BigDecimal[]) buf[0])[0] = rslt.getBigDecimal(1,4);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
               ((int[]) buf[3])[0] = rslt.getInt(3);
               ((int[]) buf[4])[0] = rslt.getInt(4);
               ((short[]) buf[5])[0] = rslt.getShort(5);
               ((int[]) buf[6])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[7])[0] = rslt.getBigDecimal(7,2);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((java.math.BigDecimal[]) buf[9])[0] = rslt.getBigDecimal(8,2);
               ((String[]) buf[10])[0] = rslt.getString(9, 10);
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

