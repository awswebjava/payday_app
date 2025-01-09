package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getimporteycantiporclasysubclas extends GXProcedure
{
   public getimporteycantiporclasysubclas( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getimporteycantiporclasysubclas.class ), "" );
   }

   public getimporteycantiporclasysubclas( int remoteHandle ,
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
                             java.util.Date aP7 ,
                             String aP8 ,
                             boolean aP9 ,
                             java.math.BigDecimal[] aP10 ,
                             java.math.BigDecimal[] aP11 ,
                             boolean[] aP12 ,
                             short[] aP13 ,
                             byte[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 )
   {
      getimporteycantiporclasysubclas.this.aP17 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
      return aP17[0];
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
                        byte[] aP14 ,
                        String[] aP15 ,
                        String[] aP16 ,
                        String[] aP17 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11, aP12, aP13, aP14, aP15, aP16, aP17);
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
                             byte[] aP14 ,
                             String[] aP15 ,
                             String[] aP16 ,
                             String[] aP17 )
   {
      getimporteycantiporclasysubclas.this.AV13CliCod = aP0;
      getimporteycantiporclasysubclas.this.AV8EmpCod = aP1;
      getimporteycantiporclasysubclas.this.AV10LegNumero = aP2;
      getimporteycantiporclasysubclas.this.AV9LiqNro = aP3;
      getimporteycantiporclasysubclas.this.AV11ConCodigo = aP4;
      getimporteycantiporclasysubclas.this.AV23DSubTipoConCod1 = aP5;
      getimporteycantiporclasysubclas.this.AV24DSubTipoConCod2 = aP6;
      getimporteycantiporclasysubclas.this.AV18fecha = aP7;
      getimporteycantiporclasysubclas.this.AV20ProcesoLiquidacion = aP8;
      getimporteycantiporclasysubclas.this.AV28novedadesSolo = aP9;
      getimporteycantiporclasysubclas.this.aP10 = aP10;
      getimporteycantiporclasysubclas.this.aP11 = aP11;
      getimporteycantiporclasysubclas.this.aP12 = aP12;
      getimporteycantiporclasysubclas.this.aP13 = aP13;
      getimporteycantiporclasysubclas.this.aP14 = aP14;
      getimporteycantiporclasysubclas.this.aP15 = aP15;
      getimporteycantiporclasysubclas.this.aP16 = aP16;
      getimporteycantiporclasysubclas.this.aP17 = aP17;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15LiqDCalculado = (byte)(1) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "1") ;
      AV36GXLvl6 = (byte)(0) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV24DSubTipoConCod2 ,
                                           Boolean.valueOf(AV28novedadesSolo) ,
                                           A732DSubTipoConCod2 ,
                                           Boolean.valueOf(A1073LiqDNovedad) ,
                                           A394DConCodigo ,
                                           AV11ConCodigo ,
                                           Integer.valueOf(AV13CliCod) ,
                                           Short.valueOf(AV8EmpCod) ,
                                           Integer.valueOf(AV9LiqNro) ,
                                           Integer.valueOf(AV10LegNumero) ,
                                           AV23DSubTipoConCod1 ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A31LiqNro) ,
                                           Integer.valueOf(A6LegNumero) ,
                                           A468DSubTipoConCod1 } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT,
                                           TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.BOOLEAN
                                           }
      });
      /* Using cursor P014B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV13CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV23DSubTipoConCod1, AV11ConCodigo, AV24DSubTipoConCod2});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P014B2_A3CliCod[0] ;
         A1EmpCod = P014B2_A1EmpCod[0] ;
         A6LegNumero = P014B2_A6LegNumero[0] ;
         A31LiqNro = P014B2_A31LiqNro[0] ;
         A468DSubTipoConCod1 = P014B2_A468DSubTipoConCod1[0] ;
         n468DSubTipoConCod1 = P014B2_n468DSubTipoConCod1[0] ;
         A1073LiqDNovedad = P014B2_A1073LiqDNovedad[0] ;
         A732DSubTipoConCod2 = P014B2_A732DSubTipoConCod2[0] ;
         n732DSubTipoConCod2 = P014B2_n732DSubTipoConCod2[0] ;
         A394DConCodigo = P014B2_A394DConCodigo[0] ;
         A764LiqDImpReCalcu = P014B2_A764LiqDImpReCalcu[0] ;
         A269LiqDCanti = P014B2_A269LiqDCanti[0] ;
         n269LiqDCanti = P014B2_n269LiqDCanti[0] ;
         A763LiqDRecalculado = P014B2_A763LiqDRecalculado[0] ;
         A393DConDescrip = P014B2_A393DConDescrip[0] ;
         A507LiqDCalculado = P014B2_A507LiqDCalculado[0] ;
         A81LiqDSecuencial = P014B2_A81LiqDSecuencial[0] ;
         AV36GXLvl6 = (byte)(1) ;
         AV22cantidadPeriodos = (short)(AV22cantidadPeriodos+1) ;
         AV14existe = true ;
         GXt_boolean1 = AV21ConRecalcular ;
         GXv_boolean2[0] = GXt_boolean1 ;
         new web.conceptorecalcula(remoteHandle, context).execute( AV13CliCod, A394DConCodigo, GXv_boolean2) ;
         getimporteycantiporclasysubclas.this.GXt_boolean1 = GXv_boolean2[0] ;
         AV21ConRecalcular = GXt_boolean1 ;
         AV12LiqDImpCalcu = AV12LiqDImpCalcu.add(A764LiqDImpReCalcu) ;
         if ( ! (DecimalUtil.compareTo(DecimalUtil.ZERO, A764LiqDImpReCalcu)==0) )
         {
            AV26LiqDCanti = AV26LiqDCanti.add(A269LiqDCanti) ;
         }
         GXt_int3 = AV15LiqDCalculado ;
         GXv_int4[0] = GXt_int3 ;
         new web.dependenciaresuelta(remoteHandle, context).execute( AV13CliCod, AV21ConRecalcular, AV20ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, A31LiqNro, 0, AV11ConCodigo, A394DConCodigo, GXv_int4) ;
         getimporteycantiporclasysubclas.this.GXt_int3 = GXv_int4[0] ;
         AV15LiqDCalculado = (byte)(GXt_int3) ;
         if ( (GXutil.strcmp("", AV30subtipo2Encontrado)==0) )
         {
            AV30subtipo2Encontrado = A732DSubTipoConCod2 ;
         }
         if ( (GXutil.strcmp("", AV32encontradoConCodigo)==0) )
         {
            AV32encontradoConCodigo = A394DConCodigo ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "2") ;
         new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
         if ( AV15LiqDCalculado == 0 )
         {
            AV29error = httpContext.getMessage( "Falta calcular ", "") + GXutil.trim( A393DConDescrip) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "3") ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
         }
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV36GXLvl6 == 0 )
      {
         new web.msgdebug_prod(remoteHandle, context).execute( AV35Pgmname, "4") ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP10[0] = getimporteycantiporclasysubclas.this.AV12LiqDImpCalcu;
      this.aP11[0] = getimporteycantiporclasysubclas.this.AV26LiqDCanti;
      this.aP12[0] = getimporteycantiporclasysubclas.this.AV14existe;
      this.aP13[0] = getimporteycantiporclasysubclas.this.AV22cantidadPeriodos;
      this.aP14[0] = getimporteycantiporclasysubclas.this.AV15LiqDCalculado;
      this.aP15[0] = getimporteycantiporclasysubclas.this.AV29error;
      this.aP16[0] = getimporteycantiporclasysubclas.this.AV30subtipo2Encontrado;
      this.aP17[0] = getimporteycantiporclasysubclas.this.AV32encontradoConCodigo;
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
      AV26LiqDCanti = DecimalUtil.ZERO ;
      AV29error = "" ;
      AV30subtipo2Encontrado = "" ;
      AV32encontradoConCodigo = "" ;
      AV35Pgmname = "" ;
      scmdbuf = "" ;
      A732DSubTipoConCod2 = "" ;
      A394DConCodigo = "" ;
      A468DSubTipoConCod1 = "" ;
      P014B2_A3CliCod = new int[1] ;
      P014B2_A1EmpCod = new short[1] ;
      P014B2_A6LegNumero = new int[1] ;
      P014B2_A31LiqNro = new int[1] ;
      P014B2_A468DSubTipoConCod1 = new String[] {""} ;
      P014B2_n468DSubTipoConCod1 = new boolean[] {false} ;
      P014B2_A1073LiqDNovedad = new boolean[] {false} ;
      P014B2_A732DSubTipoConCod2 = new String[] {""} ;
      P014B2_n732DSubTipoConCod2 = new boolean[] {false} ;
      P014B2_A394DConCodigo = new String[] {""} ;
      P014B2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P014B2_A269LiqDCanti = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P014B2_n269LiqDCanti = new boolean[] {false} ;
      P014B2_A763LiqDRecalculado = new short[1] ;
      P014B2_A393DConDescrip = new String[] {""} ;
      P014B2_A507LiqDCalculado = new byte[1] ;
      P014B2_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A269LiqDCanti = DecimalUtil.ZERO ;
      A393DConDescrip = "" ;
      GXv_boolean2 = new boolean[1] ;
      GXv_int4 = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getimporteycantiporclasysubclas__default(),
         new Object[] {
             new Object[] {
            P014B2_A3CliCod, P014B2_A1EmpCod, P014B2_A6LegNumero, P014B2_A31LiqNro, P014B2_A468DSubTipoConCod1, P014B2_n468DSubTipoConCod1, P014B2_A1073LiqDNovedad, P014B2_A732DSubTipoConCod2, P014B2_n732DSubTipoConCod2, P014B2_A394DConCodigo,
            P014B2_A764LiqDImpReCalcu, P014B2_A269LiqDCanti, P014B2_n269LiqDCanti, P014B2_A763LiqDRecalculado, P014B2_A393DConDescrip, P014B2_A507LiqDCalculado, P014B2_A81LiqDSecuencial
            }
         }
      );
      AV35Pgmname = "getImporteYCantiPorClasySubClas" ;
      /* GeneXus formulas. */
      AV35Pgmname = "getImporteYCantiPorClasySubClas" ;
      Gx_err = (short)(0) ;
   }

   private byte AV15LiqDCalculado ;
   private byte AV36GXLvl6 ;
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
   private java.math.BigDecimal AV26LiqDCanti ;
   private java.math.BigDecimal A764LiqDImpReCalcu ;
   private java.math.BigDecimal A269LiqDCanti ;
   private String AV11ConCodigo ;
   private String AV23DSubTipoConCod1 ;
   private String AV24DSubTipoConCod2 ;
   private String AV20ProcesoLiquidacion ;
   private String AV30subtipo2Encontrado ;
   private String AV32encontradoConCodigo ;
   private String AV35Pgmname ;
   private String scmdbuf ;
   private String A732DSubTipoConCod2 ;
   private String A394DConCodigo ;
   private String A468DSubTipoConCod1 ;
   private java.util.Date AV18fecha ;
   private boolean AV28novedadesSolo ;
   private boolean AV14existe ;
   private boolean A1073LiqDNovedad ;
   private boolean n468DSubTipoConCod1 ;
   private boolean n732DSubTipoConCod2 ;
   private boolean n269LiqDCanti ;
   private boolean AV21ConRecalcular ;
   private boolean GXt_boolean1 ;
   private boolean GXv_boolean2[] ;
   private String AV29error ;
   private String A393DConDescrip ;
   private String[] aP17 ;
   private java.math.BigDecimal[] aP10 ;
   private java.math.BigDecimal[] aP11 ;
   private boolean[] aP12 ;
   private short[] aP13 ;
   private byte[] aP14 ;
   private String[] aP15 ;
   private String[] aP16 ;
   private IDataStoreProvider pr_default ;
   private int[] P014B2_A3CliCod ;
   private short[] P014B2_A1EmpCod ;
   private int[] P014B2_A6LegNumero ;
   private int[] P014B2_A31LiqNro ;
   private String[] P014B2_A468DSubTipoConCod1 ;
   private boolean[] P014B2_n468DSubTipoConCod1 ;
   private boolean[] P014B2_A1073LiqDNovedad ;
   private String[] P014B2_A732DSubTipoConCod2 ;
   private boolean[] P014B2_n732DSubTipoConCod2 ;
   private String[] P014B2_A394DConCodigo ;
   private java.math.BigDecimal[] P014B2_A764LiqDImpReCalcu ;
   private java.math.BigDecimal[] P014B2_A269LiqDCanti ;
   private boolean[] P014B2_n269LiqDCanti ;
   private short[] P014B2_A763LiqDRecalculado ;
   private String[] P014B2_A393DConDescrip ;
   private byte[] P014B2_A507LiqDCalculado ;
   private int[] P014B2_A81LiqDSecuencial ;
}

final  class getimporteycantiporclasysubclas__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P014B2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV24DSubTipoConCod2 ,
                                          boolean AV28novedadesSolo ,
                                          String A732DSubTipoConCod2 ,
                                          boolean A1073LiqDNovedad ,
                                          String A394DConCodigo ,
                                          String AV11ConCodigo ,
                                          int AV13CliCod ,
                                          short AV8EmpCod ,
                                          int AV9LiqNro ,
                                          int AV10LegNumero ,
                                          String AV23DSubTipoConCod1 ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero ,
                                          String A468DSubTipoConCod1 )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int5 = new byte[7];
      Object[] GXv_Object6 = new Object[2];
      scmdbuf = "SELECT CliCod, EmpCod, LegNumero, LiqNro, DSubTipoConCod1, LiqDNovedad, DSubTipoConCod2, DConCodigo, LiqDImpReCalcu, LiqDCanti, LiqDRecalculado, DConDescrip, LiqDCalculado," ;
      scmdbuf += " LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DSubTipoConCod1 = ( ?))");
      addWhere(sWhereString, "(DConCodigo <> ( ?))");
      if ( ! (GXutil.strcmp("", AV24DSubTipoConCod2)==0) )
      {
         addWhere(sWhereString, "(DSubTipoConCod2 = ( ?))");
      }
      else
      {
         GXv_int5[6] = (byte)(1) ;
      }
      if ( AV28novedadesSolo )
      {
         addWhere(sWhereString, "(LiqDNovedad = TRUE)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DSubTipoConCod1, LiqDCalculado" ;
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
                  return conditional_P014B2(context, remoteHandle, httpContext, (String)dynConstraints[0] , ((Boolean) dynConstraints[1]).booleanValue() , (String)dynConstraints[2] , ((Boolean) dynConstraints[3]).booleanValue() , (String)dynConstraints[4] , (String)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , (String)dynConstraints[10] , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).shortValue() , ((Number) dynConstraints[13]).intValue() , ((Number) dynConstraints[14]).intValue() , (String)dynConstraints[15] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P014B2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 20);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((boolean[]) buf[6])[0] = rslt.getBoolean(6);
               ((String[]) buf[7])[0] = rslt.getString(7, 20);
               ((boolean[]) buf[8])[0] = rslt.wasNull();
               ((String[]) buf[9])[0] = rslt.getString(8, 10);
               ((java.math.BigDecimal[]) buf[10])[0] = rslt.getBigDecimal(9,2);
               ((java.math.BigDecimal[]) buf[11])[0] = rslt.getBigDecimal(10,2);
               ((boolean[]) buf[12])[0] = rslt.wasNull();
               ((short[]) buf[13])[0] = rslt.getShort(11);
               ((String[]) buf[14])[0] = rslt.getVarchar(12);
               ((byte[]) buf[15])[0] = rslt.getByte(13);
               ((int[]) buf[16])[0] = rslt.getInt(14);
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
                  stmt.setString(sIdx, (String)parms[11], 20);
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

