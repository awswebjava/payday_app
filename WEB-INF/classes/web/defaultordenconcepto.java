package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class defaultordenconcepto extends GXProcedure
{
   public defaultordenconcepto( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( defaultordenconcepto.class ), "" );
   }

   public defaultordenconcepto( int remoteHandle ,
                                ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( int aP0 ,
                           String aP1 ,
                           int[] aP2 )
   {
      defaultordenconcepto.this.aP3 = new long[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        String aP1 ,
                        int[] aP2 ,
                        long[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             String aP1 ,
                             int[] aP2 ,
                             long[] aP3 )
   {
      defaultordenconcepto.this.AV9clicod = aP0;
      defaultordenconcepto.this.AV10TipoConCod = aP1;
      defaultordenconcepto.this.aP2 = aP2;
      defaultordenconcepto.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "&clicod ", "")+GXutil.trim( GXutil.str( AV9clicod, 6, 0))) ;
      pr_default.dynParam(0, new Object[]{ new Object[]{
                                           AV10TipoConCod ,
                                           A37TipoConCod ,
                                           Integer.valueOf(AV9clicod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P000T2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9clicod), AV10TipoConCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P000T2_A3CliCod[0] ;
         A37TipoConCod = P000T2_A37TipoConCod[0] ;
         A40ConOrden = P000T2_A40ConOrden[0] ;
         A26ConCodigo = P000T2_A26ConCodigo[0] ;
         AV8ConOrden = A40ConOrden ;
         new web.msgdebug(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "FFF&ConOrden ", "")+GXutil.trim( GXutil.str( A40ConOrden, 8, 0))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      pr_default.dynParam(1, new Object[]{ new Object[]{
                                           AV10TipoConCod ,
                                           A37TipoConCod ,
                                           Integer.valueOf(AV9clicod) ,
                                           Integer.valueOf(A3CliCod) } ,
                                           new int[]{
                                           TypeConstants.STRING, TypeConstants.STRING, TypeConstants.INT, TypeConstants.INT
                                           }
      });
      /* Using cursor P000T3 */
      pr_default.execute(1, new Object[] {Integer.valueOf(AV9clicod), AV10TipoConCod});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A3CliCod = P000T3_A3CliCod[0] ;
         A37TipoConCod = P000T3_A37TipoConCod[0] ;
         A40ConOrden = P000T3_A40ConOrden[0] ;
         A510ConOrdEjec = P000T3_A510ConOrdEjec[0] ;
         A26ConCodigo = P000T3_A26ConCodigo[0] ;
         AV11ConOrdEjec = A510ConOrdEjec ;
         new web.msgdebug(remoteHandle, context).execute( AV14Pgmname, httpContext.getMessage( "FFF&ConOrden ", "")+GXutil.trim( GXutil.str( A40ConOrden, 8, 0))) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = defaultordenconcepto.this.AV8ConOrden;
      this.aP3[0] = defaultordenconcepto.this.AV11ConOrdEjec;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV14Pgmname = "" ;
      scmdbuf = "" ;
      A37TipoConCod = "" ;
      P000T2_A3CliCod = new int[1] ;
      P000T2_A37TipoConCod = new String[] {""} ;
      P000T2_A40ConOrden = new int[1] ;
      P000T2_A26ConCodigo = new String[] {""} ;
      A26ConCodigo = "" ;
      P000T3_A3CliCod = new int[1] ;
      P000T3_A37TipoConCod = new String[] {""} ;
      P000T3_A40ConOrden = new int[1] ;
      P000T3_A510ConOrdEjec = new long[1] ;
      P000T3_A26ConCodigo = new String[] {""} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.defaultordenconcepto__default(),
         new Object[] {
             new Object[] {
            P000T2_A3CliCod, P000T2_A37TipoConCod, P000T2_A40ConOrden, P000T2_A26ConCodigo
            }
            , new Object[] {
            P000T3_A3CliCod, P000T3_A37TipoConCod, P000T3_A40ConOrden, P000T3_A510ConOrdEjec, P000T3_A26ConCodigo
            }
         }
      );
      AV14Pgmname = "defaultOrdenConcepto" ;
      /* GeneXus formulas. */
      AV14Pgmname = "defaultOrdenConcepto" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV9clicod ;
   private int AV8ConOrden ;
   private int A3CliCod ;
   private int A40ConOrden ;
   private long AV11ConOrdEjec ;
   private long A510ConOrdEjec ;
   private String AV10TipoConCod ;
   private String AV14Pgmname ;
   private String scmdbuf ;
   private String A37TipoConCod ;
   private String A26ConCodigo ;
   private long[] aP3 ;
   private int[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P000T2_A3CliCod ;
   private String[] P000T2_A37TipoConCod ;
   private int[] P000T2_A40ConOrden ;
   private String[] P000T2_A26ConCodigo ;
   private int[] P000T3_A3CliCod ;
   private String[] P000T3_A37TipoConCod ;
   private int[] P000T3_A40ConOrden ;
   private long[] P000T3_A510ConOrdEjec ;
   private String[] P000T3_A26ConCodigo ;
}

final  class defaultordenconcepto__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   protected Object[] conditional_P000T2( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV10TipoConCod ,
                                          String A37TipoConCod ,
                                          int AV9clicod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int1 = new byte[2];
      Object[] GXv_Object2 = new Object[2];
      scmdbuf = "SELECT CliCod, TipoConCod, ConOrden, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV10TipoConCod)==0) )
      {
         addWhere(sWhereString, "(TipoConCod = ( ?))");
      }
      else
      {
         GXv_int1[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConOrden DESC" ;
      GXv_Object2[0] = scmdbuf ;
      GXv_Object2[1] = GXv_int1 ;
      return GXv_Object2 ;
   }

   protected Object[] conditional_P000T3( ModelContext context ,
                                          int remoteHandle ,
                                          com.genexus.IHttpContext httpContext ,
                                          String AV10TipoConCod ,
                                          String A37TipoConCod ,
                                          int AV9clicod ,
                                          int A3CliCod )
   {
      java.lang.StringBuffer sWhereString = new java.lang.StringBuffer();
      String scmdbuf;
      byte[] GXv_int3 = new byte[2];
      Object[] GXv_Object4 = new Object[2];
      scmdbuf = "SELECT CliCod, TipoConCod, ConOrden, ConOrdEjec, ConCodigo FROM Concepto" ;
      addWhere(sWhereString, "(CliCod = ?)");
      if ( ! (GXutil.strcmp("", AV10TipoConCod)==0) )
      {
         addWhere(sWhereString, "(TipoConCod = ( ?))");
      }
      else
      {
         GXv_int3[1] = (byte)(1) ;
      }
      scmdbuf += sWhereString ;
      scmdbuf += " ORDER BY CliCod, ConOrdEjec DESC" ;
      GXv_Object4[0] = scmdbuf ;
      GXv_Object4[1] = GXv_int3 ;
      return GXv_Object4 ;
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
                  return conditional_P000T2(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
            case 1 :
                  return conditional_P000T3(context, remoteHandle, httpContext, (String)dynConstraints[0] , (String)dynConstraints[1] , ((Number) dynConstraints[2]).intValue() , ((Number) dynConstraints[3]).intValue() );
      }
      return super.getDynamicStatement(cursor, context, remoteHandle, httpContext, dynConstraints);
   }

   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P000T2", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P000T3", "scmdbuf",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((String[]) buf[3])[0] = rslt.getString(4, 10);
               return;
            case 1 :
               ((int[]) buf[0])[0] = rslt.getInt(1);
               ((String[]) buf[1])[0] = rslt.getString(2, 20);
               ((int[]) buf[2])[0] = rslt.getInt(3);
               ((long[]) buf[3])[0] = rslt.getLong(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
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
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 20);
               }
               return;
            case 1 :
               sIdx = (short)(0) ;
               if ( ((Number) parms[0]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setInt(sIdx, ((Number) parms[2]).intValue());
               }
               if ( ((Number) parms[1]).byteValue() == 0 )
               {
                  sIdx = (short)(sIdx+1) ;
                  stmt.setString(sIdx, (String)parms[3], 20);
               }
               return;
      }
   }

}

