package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getimpliqportipo extends GXProcedure
{
   public getimpliqportipo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getimpliqportipo.class ), "" );
   }

   public getimpliqportipo( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 ,
                           int aP3 ,
                           java.util.Date aP4 ,
                           String aP5 ,
                           String aP6 ,
                           String aP7 ,
                           GXSimpleCollection<String> aP8 ,
                           java.math.BigDecimal[] aP9 )
   {
      getimpliqportipo.this.aP10 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
      return aP10[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        int aP3 ,
                        java.util.Date aP4 ,
                        String aP5 ,
                        String aP6 ,
                        String aP7 ,
                        GXSimpleCollection<String> aP8 ,
                        java.math.BigDecimal[] aP9 ,
                        byte[] aP10 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             int aP3 ,
                             java.util.Date aP4 ,
                             String aP5 ,
                             String aP6 ,
                             String aP7 ,
                             GXSimpleCollection<String> aP8 ,
                             java.math.BigDecimal[] aP9 ,
                             byte[] aP10 )
   {
      getimpliqportipo.this.AV12CliCod = aP0;
      getimpliqportipo.this.AV8EmpCod = aP1;
      getimpliqportipo.this.AV9LiqNro = aP2;
      getimpliqportipo.this.AV10LegNumero = aP3;
      getimpliqportipo.this.AV17LiqPeriodo = aP4;
      getimpliqportipo.this.AV33TipoConCod = aP5;
      getimpliqportipo.this.AV15ConCodigo = aP6;
      getimpliqportipo.this.AV29ProcesoLiquidacion = aP7;
      getimpliqportipo.this.AV30excluirConCodigo = aP8;
      getimpliqportipo.this.aP9 = aP9;
      getimpliqportipo.this.aP10 = aP10;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV11Importe = DecimalUtil.ZERO ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "&EmpCod ", "")+GXutil.trim( GXutil.str( AV8EmpCod, 4, 0))+httpContext.getMessage( " &LiqNro ", "")+GXutil.trim( GXutil.str( AV9LiqNro, 8, 0))+httpContext.getMessage( " &LegNumero ", "")+GXutil.trim( GXutil.str( AV10LegNumero, 8, 0))+httpContext.getMessage( " clicod ", "")+GXutil.trim( GXutil.str( AV12CliCod, 6, 0))) ;
      AV13LiqDCalculado = (byte)(1) ;
      if ( (0==AV9LiqNro) )
      {
         GXv_decimal1[0] = AV11Importe ;
         GXv_char2[0] = AV28LiqDLog ;
         new web.formula_agenda(remoteHandle, context).execute( AV12CliCod, AV8EmpCod, AV10LegNumero, AV33TipoConCod, AV33TipoConCod, AV17LiqPeriodo, GXutil.eomdate( AV17LiqPeriodo), GXv_decimal1, GXv_char2) ;
         getimpliqportipo.this.AV11Importe = GXv_decimal1[0] ;
         getimpliqportipo.this.AV28LiqDLog = GXv_char2[0] ;
      }
      else
      {
         if ( AV30excluirConCodigo.size() > 0 )
         {
            AV32excluir = true ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, "1") ;
         AV37GXLvl16 = (byte)(0) ;
         pr_default.dynParam(0, new Object[]{ new Object[]{
                                              A394DConCodigo ,
                                              AV30excluirConCodigo ,
                                              Boolean.valueOf(AV32excluir) ,
                                              AV15ConCodigo ,
                                              Integer.valueOf(AV12CliCod) ,
                                              Short.valueOf(AV8EmpCod) ,
                                              Integer.valueOf(AV9LiqNro) ,
                                              Integer.valueOf(AV10LegNumero) ,
                                              AV33TipoConCod ,
                                              Integer.valueOf(A3CliCod) ,
                                              Short.valueOf(A1EmpCod) ,
                                              Integer.valueOf(A31LiqNro) ,
                                              Integer.valueOf(A6LegNumero) ,
                                              A464DTipoConCod } ,
                                              new int[]{
                                              TypeConstants.STRING, TypeConstants.BOOLEAN, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING, TypeConstants.INT, TypeConstants.SHORT,
                                              TypeConstants.INT, TypeConstants.INT, TypeConstants.STRING
                                              }
         });
         /* Using cursor P007X2 */
         pr_default.execute(0, new Object[] {Integer.valueOf(AV12CliCod), Short.valueOf(AV8EmpCod), Integer.valueOf(AV9LiqNro), Integer.valueOf(AV10LegNumero), AV33TipoConCod, AV15ConCodigo});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A394DConCodigo = P007X2_A394DConCodigo[0] ;
            A464DTipoConCod = P007X2_A464DTipoConCod[0] ;
            A6LegNumero = P007X2_A6LegNumero[0] ;
            A31LiqNro = P007X2_A31LiqNro[0] ;
            A1EmpCod = P007X2_A1EmpCod[0] ;
            A3CliCod = P007X2_A3CliCod[0] ;
            A764LiqDImpReCalcu = P007X2_A764LiqDImpReCalcu[0] ;
            A507LiqDCalculado = P007X2_A507LiqDCalculado[0] ;
            A274LiqDFormula = P007X2_A274LiqDFormula[0] ;
            n274LiqDFormula = P007X2_n274LiqDFormula[0] ;
            A763LiqDRecalculado = P007X2_A763LiqDRecalculado[0] ;
            A81LiqDSecuencial = P007X2_A81LiqDSecuencial[0] ;
            AV37GXLvl16 = (byte)(1) ;
            AV11Importe = AV11Importe.add(A764LiqDImpReCalcu) ;
            new web.dependenciasesion(remoteHandle, context).execute( A394DConCodigo) ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "recorre concepto ", "")+GXutil.trim( A394DConCodigo)+httpContext.getMessage( " LiqDImpReCalcu ", "")+GXutil.trim( GXutil.str( A764LiqDImpReCalcu, 14, 2))+httpContext.getMessage( " formula ", "")+GXutil.trim( A274LiqDFormula)+httpContext.getMessage( " LiqDCalculado ", "")+GXutil.trim( GXutil.str( A507LiqDCalculado, 1, 0))+httpContext.getMessage( " &LiqDCalculado ", "")+GXutil.trim( GXutil.str( AV13LiqDCalculado, 1, 0))+httpContext.getMessage( " importe ", "")+GXutil.trim( GXutil.str( AV11Importe, 14, 2))) ;
            GXv_int3[0] = AV13LiqDCalculado ;
            new web.dependenciaresuelta2(remoteHandle, context).execute( AV12CliCod, A394DConCodigo, AV29ProcesoLiquidacion, A507LiqDCalculado, A763LiqDRecalculado, GXv_int3) ;
            getimpliqportipo.this.AV13LiqDCalculado = GXv_int3[0] ;
            if ( AV13LiqDCalculado == 0 )
            {
               new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "retornoa", "")) ;
               pr_default.close(0);
               returnInSub = true;
               cleanup();
               if (true) return;
            }
            AV25collection_ConCodigo.add(GXutil.trim( A394DConCodigo), 0);
            pr_default.readNext(0);
         }
         pr_default.close(0);
         if ( AV37GXLvl16 == 0 )
         {
            new web.msgdebug_prod(remoteHandle, context).execute( AV36Pgmname, httpContext.getMessage( "none", "")) ;
         }
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP9[0] = getimpliqportipo.this.AV11Importe;
      this.aP10[0] = getimpliqportipo.this.AV13LiqDCalculado;
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
      AV36Pgmname = "" ;
      GXv_decimal1 = new java.math.BigDecimal[1] ;
      AV28LiqDLog = "" ;
      GXv_char2 = new String[1] ;
      scmdbuf = "" ;
      A394DConCodigo = "" ;
      A464DTipoConCod = "" ;
      P007X2_A394DConCodigo = new String[] {""} ;
      P007X2_A464DTipoConCod = new String[] {""} ;
      P007X2_A6LegNumero = new int[1] ;
      P007X2_A31LiqNro = new int[1] ;
      P007X2_A1EmpCod = new short[1] ;
      P007X2_A3CliCod = new int[1] ;
      P007X2_A764LiqDImpReCalcu = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P007X2_A507LiqDCalculado = new byte[1] ;
      P007X2_A274LiqDFormula = new String[] {""} ;
      P007X2_n274LiqDFormula = new boolean[] {false} ;
      P007X2_A763LiqDRecalculado = new short[1] ;
      P007X2_A81LiqDSecuencial = new int[1] ;
      A764LiqDImpReCalcu = DecimalUtil.ZERO ;
      A274LiqDFormula = "" ;
      GXv_int3 = new byte[1] ;
      AV25collection_ConCodigo = new GXSimpleCollection<String>(String.class, "internal", "");
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getimpliqportipo__default(),
         new Object[] {
             new Object[] {
            P007X2_A394DConCodigo, P007X2_A464DTipoConCod, P007X2_A6LegNumero, P007X2_A31LiqNro, P007X2_A1EmpCod, P007X2_A3CliCod, P007X2_A764LiqDImpReCalcu, P007X2_A507LiqDCalculado, P007X2_A274LiqDFormula, P007X2_n274LiqDFormula,
            P007X2_A763LiqDRecalculado, P007X2_A81LiqDSecuencial
            }
         }
      );
      AV36Pgmname = "getImpLiqPorTipo" ;
      /* GeneXus formulas. */
      AV36Pgmname = "getImpLiqPorTipo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13LiqDCalculado ;
   private byte AV37GXLvl16 ;
   private byte A507LiqDCalculado ;
   private byte GXv_int3[] ;
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
   private String AV33TipoConCod ;
   private String AV15ConCodigo ;
   private String AV29ProcesoLiquidacion ;
   private String AV36Pgmname ;
   private String GXv_char2[] ;
   private String scmdbuf ;
   private String A394DConCodigo ;
   private String A464DTipoConCod ;
   private java.util.Date AV17LiqPeriodo ;
   private boolean AV32excluir ;
   private boolean n274LiqDFormula ;
   private boolean returnInSub ;
   private String AV28LiqDLog ;
   private String A274LiqDFormula ;
   private byte[] aP10 ;
   private java.math.BigDecimal[] aP9 ;
   private IDataStoreProvider pr_default ;
   private String[] P007X2_A394DConCodigo ;
   private String[] P007X2_A464DTipoConCod ;
   private int[] P007X2_A6LegNumero ;
   private int[] P007X2_A31LiqNro ;
   private short[] P007X2_A1EmpCod ;
   private int[] P007X2_A3CliCod ;
   private java.math.BigDecimal[] P007X2_A764LiqDImpReCalcu ;
   private byte[] P007X2_A507LiqDCalculado ;
   private String[] P007X2_A274LiqDFormula ;
   private boolean[] P007X2_n274LiqDFormula ;
   private short[] P007X2_A763LiqDRecalculado ;
   private int[] P007X2_A81LiqDSecuencial ;
   private GXSimpleCollection<String> AV30excluirConCodigo ;
   private GXSimpleCollection<String> AV25collection_ConCodigo ;
}

final  class getimpliqportipo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P007X2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String A394DConCodigo ,
                                          GXSimpleCollection<String> AV30excluirConCodigo ,
                                          boolean AV32excluir ,
                                          String AV15ConCodigo ,
                                          int AV12CliCod ,
                                          short AV8EmpCod ,
                                          int AV9LiqNro ,
                                          int AV10LegNumero ,
                                          String AV33TipoConCod ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A31LiqNro ,
                                          int A6LegNumero ,
                                          String A464DTipoConCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int4 = new byte[6];
      Object[] GXv_Object5 = new Object[2];
      scmdbuf = "SELECT DConCodigo, DTipoConCod, LegNumero, LiqNro, EmpCod, CliCod, LiqDImpReCalcu, LiqDCalculado, LiqDFormula, LiqDRecalculado, LiqDSecuencial FROM LiquidacionDetalle" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LiqNro = ? and LegNumero = ? and DTipoConCod = ( ?))");
      addWhere(sWhereString, "(DConCodigo <> ( ?))");
      if ( AV32excluir )
      {
         addWhere(sWhereString, "(Not "+GXutil.toValueList("postgresql", AV30excluirConCodigo, "DConCodigo IN (", ")")+")");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LiqNro, LegNumero, DTipoConCod" ;
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
                  return conditional_P007X2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (GXSimpleCollection<String>)dynConstraints[1] , ((Boolean) dynConstraints[2]).booleanValue() , (String)dynConstraints[3] , ((Number) dynConstraints[4]).intValue() , ((Number) dynConstraints[5]).shortValue() , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).intValue() , (String)dynConstraints[8] , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() , ((Number) dynConstraints[12]).intValue() , (String)dynConstraints[13] );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P007X2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 10);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((short[]) buf[4])[0] = rslt.getShort(5);
               ((int[]) buf[5])[0] = rslt.getInt(6);
               ((java.math.BigDecimal[]) buf[6])[0] = rslt.getBigDecimal(7,2);
               ((byte[]) buf[7])[0] = rslt.getByte(8);
               ((String[]) buf[8])[0] = rslt.getLongVarchar(9);
               ((boolean[]) buf[9])[0] = rslt.wasNull();
               ((short[]) buf[10])[0] = rslt.getShort(10);
               ((int[]) buf[11])[0] = rslt.getInt(11);
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
                  stmt.setString(sIdx, (String)parms[11], 10);
               }
               return;
      }
   }

}

