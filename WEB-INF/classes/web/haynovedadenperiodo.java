package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class haynovedadenperiodo extends GXProcedure
{
   public haynovedadenperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( haynovedadenperiodo.class ), "" );
   }

   public haynovedadenperiodo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public boolean executeUdp( int aP0 ,
                              short aP1 ,
                              int aP2 ,
                              java.util.Date aP3 ,
                              java.util.Date aP4 ,
                              boolean aP5 )
   {
      haynovedadenperiodo.this.aP6 = new boolean[] {false};
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
      return aP6[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        java.util.Date aP3 ,
                        java.util.Date aP4 ,
                        boolean aP5 ,
                        boolean[] aP6 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             java.util.Date aP3 ,
                             java.util.Date aP4 ,
                             boolean aP5 ,
                             boolean[] aP6 )
   {
      haynovedadenperiodo.this.AV11CliCod = aP0;
      haynovedadenperiodo.this.AV12EmpCod = aP1;
      haynovedadenperiodo.this.AV13LegNumero = aP2;
      haynovedadenperiodo.this.AV8FechaDesde = aP3;
      haynovedadenperiodo.this.AV9FechaHasta = aP4;
      haynovedadenperiodo.this.AV14verSoloNoLiq = aP5;
      haynovedadenperiodo.this.aP6 = aP6;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           Boolean.valueOf(AV14verSoloNoLiq) ,
                                           Integer.valueOf(A1254AgeLiqNro) ,
                                           A111AgeFecDes ,
                                           AV9FechaHasta ,
                                           A112AgeFecHas ,
                                           AV8FechaDesde ,
                                           Integer.valueOf(AV11CliCod) ,
                                           Short.valueOf(AV12EmpCod) ,
                                           Integer.valueOf(AV13LegNumero) ,
                                           Integer.valueOf(A3CliCod) ,
                                           Short.valueOf(A1EmpCod) ,
                                           Integer.valueOf(A6LegNumero) } ,
                                           new int[]{
                                           TypeConstants.BOOLEAN, TypeConstants.INT, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.DATE, TypeConstants.BOOLEAN, TypeConstants.DATE, TypeConstants.INT,
                                           TypeConstants.SHORT, TypeConstants.INT, TypeConstants.INT, TypeConstants.SHORT, TypeConstants.INT
                                           }
      });
      /* Using cursor P02DA2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV11CliCod), Short.valueOf(AV12EmpCod), Integer.valueOf(AV13LegNumero), AV9FechaHasta, AV8FechaDesde});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1254AgeLiqNro = P02DA2_A1254AgeLiqNro[0] ;
         n1254AgeLiqNro = P02DA2_n1254AgeLiqNro[0] ;
         A112AgeFecHas = P02DA2_A112AgeFecHas[0] ;
         n112AgeFecHas = P02DA2_n112AgeFecHas[0] ;
         A111AgeFecDes = P02DA2_A111AgeFecDes[0] ;
         n111AgeFecDes = P02DA2_n111AgeFecDes[0] ;
         A6LegNumero = P02DA2_A6LegNumero[0] ;
         A1EmpCod = P02DA2_A1EmpCod[0] ;
         A3CliCod = P02DA2_A3CliCod[0] ;
         A26ConCodigo = P02DA2_A26ConCodigo[0] ;
         A25AgeOrden = P02DA2_A25AgeOrden[0] ;
         new web.msgdebug_prod2(remoteHandle, context).execute( AV11CliCod, AV18Pgmname, httpContext.getMessage( "encuentra ", "")+A26ConCodigo+httpContext.getMessage( " agefecdes ", "")+GXutil.trim( localUtil.dtoc( A111AgeFecDes, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         AV10hay = true ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP6[0] = haynovedadenperiodo.this.AV10hay;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      scmdbuf = "" ;
      A111AgeFecDes = GXutil.nullDate() ;
      A112AgeFecHas = GXutil.nullDate() ;
      P02DA2_A1254AgeLiqNro = new int[1] ;
      P02DA2_n1254AgeLiqNro = new boolean[] {false} ;
      P02DA2_A112AgeFecHas = new java.util.Date[] {GXutil.nullDate()} ;
      P02DA2_n112AgeFecHas = new boolean[] {false} ;
      P02DA2_A111AgeFecDes = new java.util.Date[] {GXutil.nullDate()} ;
      P02DA2_n111AgeFecDes = new boolean[] {false} ;
      P02DA2_A6LegNumero = new int[1] ;
      P02DA2_A1EmpCod = new short[1] ;
      P02DA2_A3CliCod = new int[1] ;
      P02DA2_A26ConCodigo = new String[] {""} ;
      P02DA2_A25AgeOrden = new short[1] ;
      A26ConCodigo = "" ;
      AV18Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.haynovedadenperiodo__default(),
         new Object[] {
             new Object[] {
            P02DA2_A1254AgeLiqNro, P02DA2_n1254AgeLiqNro, P02DA2_A112AgeFecHas, P02DA2_n112AgeFecHas, P02DA2_A111AgeFecDes, P02DA2_n111AgeFecDes, P02DA2_A6LegNumero, P02DA2_A1EmpCod, P02DA2_A3CliCod, P02DA2_A26ConCodigo,
            P02DA2_A25AgeOrden
            }
         }
      );
      AV18Pgmname = "hayNovedadEnPeriodo" ;
      /* GeneXus formulas. */
      AV18Pgmname = "hayNovedadEnPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private short AV12EmpCod ;
   private short A1EmpCod ;
   private short A25AgeOrden ;
   private short Gx_err ;
   private int AV11CliCod ;
   private int AV13LegNumero ;
   private int A1254AgeLiqNro ;
   private int A3CliCod ;
   private int A6LegNumero ;
   private String scmdbuf ;
   private String A26ConCodigo ;
   private String AV18Pgmname ;
   private java.util.Date AV8FechaDesde ;
   private java.util.Date AV9FechaHasta ;
   private java.util.Date A111AgeFecDes ;
   private java.util.Date A112AgeFecHas ;
   private boolean AV14verSoloNoLiq ;
   private boolean AV10hay ;
   private boolean n1254AgeLiqNro ;
   private boolean n112AgeFecHas ;
   private boolean n111AgeFecDes ;
   private boolean[] aP6 ;
   private IDataStoreProvider pr_default ;
   private int[] P02DA2_A1254AgeLiqNro ;
   private boolean[] P02DA2_n1254AgeLiqNro ;
   private java.util.Date[] P02DA2_A112AgeFecHas ;
   private boolean[] P02DA2_n112AgeFecHas ;
   private java.util.Date[] P02DA2_A111AgeFecDes ;
   private boolean[] P02DA2_n111AgeFecDes ;
   private int[] P02DA2_A6LegNumero ;
   private short[] P02DA2_A1EmpCod ;
   private int[] P02DA2_A3CliCod ;
   private String[] P02DA2_A26ConCodigo ;
   private short[] P02DA2_A25AgeOrden ;
}

final  class haynovedadenperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P02DA2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          boolean AV14verSoloNoLiq ,
                                          int A1254AgeLiqNro ,
                                          java.util.Date A111AgeFecDes ,
                                          java.util.Date AV9FechaHasta ,
                                          java.util.Date A112AgeFecHas ,
                                          java.util.Date AV8FechaDesde ,
                                          int AV11CliCod ,
                                          short AV12EmpCod ,
                                          int AV13LegNumero ,
                                          int A3CliCod ,
                                          short A1EmpCod ,
                                          int A6LegNumero )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[5];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT AgeLiqNro, AgeFecHas, AgeFecDes, LegNumero, EmpCod, CliCod, ConCodigo, AgeOrden FROM AgendaNovedades" ;
      addWhere(sWhereString, "(CliCod = ? and EmpCod = ? and LegNumero = ?)");
      addWhere(sWhereString, "(AgeFecDes <= ?)");
      addWhere(sWhereString, "(AgeFecHas >= ?)");
      if ( AV14verSoloNoLiq )
      {
         addWhere(sWhereString, "(AgeLiqNro IS NULL)");
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, EmpCod, LegNumero" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
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
                  return conditional_P02DA2(context, remoteHandle, httpContext, ((Boolean) dynConstraints[0]).booleanValue() , ((Number) dynConstraints[1]).intValue() , (java.util.Date)dynConstraints[2] , (java.util.Date)dynConstraints[3] , (java.util.Date)dynConstraints[4] , (java.util.Date)dynConstraints[5] , ((Number) dynConstraints[6]).intValue() , ((Number) dynConstraints[7]).shortValue() , ((Number) dynConstraints[8]).intValue() , ((Number) dynConstraints[9]).intValue() , ((Number) dynConstraints[10]).shortValue() , ((Number) dynConstraints[11]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02DA2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(2);
               ((boolean[]) buf[3])[0] = rslt.wasNull();
               ((java.util.Date[]) buf[4])[0] = rslt.getGXDate(3);
               ((boolean[]) buf[5])[0] = rslt.wasNull();
               ((int[]) buf[6])[0] = rslt.getInt(4);
               ((short[]) buf[7])[0] = rslt.getShort(5);
               ((int[]) buf[8])[0] = rslt.getInt(6);
               ((String[]) buf[9])[0] = rslt.getString(7, 10);
               ((short[]) buf[10])[0] = rslt.getShort(8);
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
                  stmt.setInt(sIdx, ((Number) parms[5]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setShort(sIdx, ((Number) parms[6]).shortValue());
               }
               if ( ((Number) parms[2]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[7]).intValue());
               }
               if ( ((Number) parms[3]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[8]);
               }
               if ( ((Number) parms[4]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setDate(sIdx, (java.util.Date)parms[9]);
               }
               return;
      }
   }

}

