package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class grabaliqleglsd extends GXProcedure
{
   public grabaliqleglsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( grabaliqleglsd.class ), "" );
   }

   public grabaliqleglsd( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        long aP3 ,
                        String aP4 ,
                        String aP5 ,
                        short aP6 ,
                        java.util.Date aP7 ,
                        boolean aP8 ,
                        byte aP9 ,
                        String aP10 ,
                        String aP11 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9, aP10, aP11);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             long aP3 ,
                             String aP4 ,
                             String aP5 ,
                             short aP6 ,
                             java.util.Date aP7 ,
                             boolean aP8 ,
                             byte aP9 ,
                             String aP10 ,
                             String aP11 )
   {
      grabaliqleglsd.this.AV8CliCod = aP0;
      grabaliqleglsd.this.AV9EmpCod = aP1;
      grabaliqleglsd.this.AV15ImpLiqSec = aP2;
      grabaliqleglsd.this.AV10ImpLiqLSDCuil = aP3;
      grabaliqleglsd.this.AV14ImpLiqLSDLegId = aP4;
      grabaliqleglsd.this.AV11ImpLiqLSDLegCBU = aP5;
      grabaliqleglsd.this.AV16ImpLiqLSDLegDiasLiq = aP6;
      grabaliqleglsd.this.AV17ImpLiqLSDLegFecPag = aP7;
      grabaliqleglsd.this.AV12ImpLiqLSDLegCony = aP8;
      grabaliqleglsd.this.AV13ImpLiqLSDLegHijos = aP9;
      grabaliqleglsd.this.AV18ImpLiqLSDDepRev = aP10;
      grabaliqleglsd.this.AV19ImpLiqLSDForPag = aP11;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "&ImpLiqLSDLegFecPag ", "")+GXutil.trim( localUtil.dtoc( AV17ImpLiqLSDLegFecPag, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
      AV23GXLvl4 = (byte)(0) ;
      /* Using cursor P027G2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV15ImpLiqSec), Long.valueOf(AV10ImpLiqLSDCuil)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1770ImpLiqLSDCuil = P027G2_A1770ImpLiqLSDCuil[0] ;
         A88ImpLiqSec = P027G2_A88ImpLiqSec[0] ;
         A1EmpCod = P027G2_A1EmpCod[0] ;
         A3CliCod = P027G2_A3CliCod[0] ;
         A1771ImpLiqLSDLegId = P027G2_A1771ImpLiqLSDLegId[0] ;
         A1772ImpLiqLSDLegCBU = P027G2_A1772ImpLiqLSDLegCBU[0] ;
         A1773ImpLiqLSDLegDiasLiq = P027G2_A1773ImpLiqLSDLegDiasLiq[0] ;
         A1774ImpLiqLSDLegFecPag = P027G2_A1774ImpLiqLSDLegFecPag[0] ;
         A1775ImpLiqLSDLegCony = P027G2_A1775ImpLiqLSDLegCony[0] ;
         A1776ImpLiqLSDLegHijos = P027G2_A1776ImpLiqLSDLegHijos[0] ;
         A2193ImpLiqLSDDepRev = P027G2_A2193ImpLiqLSDDepRev[0] ;
         A2194ImpLiqLSDForPag = P027G2_A2194ImpLiqLSDForPag[0] ;
         AV23GXLvl4 = (byte)(1) ;
         if ( (GXutil.strcmp("", A1771ImpLiqLSDLegId)==0) )
         {
            A1771ImpLiqLSDLegId = AV14ImpLiqLSDLegId ;
         }
         if ( (GXutil.strcmp("", A1772ImpLiqLSDLegCBU)==0) )
         {
            A1772ImpLiqLSDLegCBU = AV11ImpLiqLSDLegCBU ;
         }
         if ( (0==A1773ImpLiqLSDLegDiasLiq) )
         {
            A1773ImpLiqLSDLegDiasLiq = AV16ImpLiqLSDLegDiasLiq ;
         }
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "update att ", "")+GXutil.trim( localUtil.dtoc( A1774ImpLiqLSDLegFecPag, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         if ( GXutil.dateCompare(GXutil.resetTime(GXutil.nullDate()), GXutil.resetTime(A1774ImpLiqLSDLegFecPag)) )
         {
            A1774ImpLiqLSDLegFecPag = AV17ImpLiqLSDLegFecPag ;
            new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "graba", "")) ;
         }
         if ( (false==A1775ImpLiqLSDLegCony) )
         {
            A1775ImpLiqLSDLegCony = AV12ImpLiqLSDLegCony ;
         }
         if ( (0==A1776ImpLiqLSDLegHijos) )
         {
            A1776ImpLiqLSDLegHijos = AV13ImpLiqLSDLegHijos ;
         }
         if ( (GXutil.strcmp("", A2193ImpLiqLSDDepRev)==0) )
         {
            A2193ImpLiqLSDDepRev = AV18ImpLiqLSDDepRev ;
         }
         if ( (GXutil.strcmp("", A2194ImpLiqLSDForPag)==0) )
         {
            A2194ImpLiqLSDForPag = AV19ImpLiqLSDForPag ;
         }
         /* Using cursor P027G3 */
         pr_default.execute(1, new Object[] {A1771ImpLiqLSDLegId, A1772ImpLiqLSDLegCBU, Short.valueOf(A1773ImpLiqLSDLegDiasLiq), A1774ImpLiqLSDLegFecPag, Boolean.valueOf(A1775ImpLiqLSDLegCony), Byte.valueOf(A1776ImpLiqLSDLegHijos), A2193ImpLiqLSDDepRev, A2194ImpLiqLSDForPag, Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Long.valueOf(A1770ImpLiqLSDCuil)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd_legajos");
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV23GXLvl4 == 0 )
      {
         /*
            INSERT RECORD ON TABLE importacion_liquidacion_lsd_legajos

         */
         A3CliCod = AV8CliCod ;
         A1EmpCod = AV9EmpCod ;
         A88ImpLiqSec = AV15ImpLiqSec ;
         A1770ImpLiqLSDCuil = AV10ImpLiqLSDCuil ;
         A1771ImpLiqLSDLegId = AV14ImpLiqLSDLegId ;
         A1772ImpLiqLSDLegCBU = AV11ImpLiqLSDLegCBU ;
         A1773ImpLiqLSDLegDiasLiq = AV16ImpLiqLSDLegDiasLiq ;
         new web.msgdebug_prod(remoteHandle, context).execute( AV22Pgmname, httpContext.getMessage( "insert att ", "")+GXutil.trim( localUtil.dtoc( AV17ImpLiqLSDLegFecPag, localUtil.mapDateFormat( httpContext.getLanguageProperty( "date_fmt")), "/"))) ;
         A1774ImpLiqLSDLegFecPag = AV17ImpLiqLSDLegFecPag ;
         A1775ImpLiqLSDLegCony = AV12ImpLiqLSDLegCony ;
         A1776ImpLiqLSDLegHijos = AV13ImpLiqLSDLegHijos ;
         A2193ImpLiqLSDDepRev = AV18ImpLiqLSDDepRev ;
         A2194ImpLiqLSDForPag = AV19ImpLiqLSDForPag ;
         /* Using cursor P027G4 */
         pr_default.execute(2, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1EmpCod), Short.valueOf(A88ImpLiqSec), Long.valueOf(A1770ImpLiqLSDCuil), A1771ImpLiqLSDLegId, A1772ImpLiqLSDLegCBU, Short.valueOf(A1773ImpLiqLSDLegDiasLiq), A1774ImpLiqLSDLegFecPag, Boolean.valueOf(A1775ImpLiqLSDLegCony), Byte.valueOf(A1776ImpLiqLSDLegHijos), A2193ImpLiqLSDDepRev, A2194ImpLiqLSDForPag});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("importacion_liquidacion_lsd_legajos");
         if ( (pr_default.getStatus(2) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "grabaliqleglsd");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV22Pgmname = "" ;
      scmdbuf = "" ;
      P027G2_A1770ImpLiqLSDCuil = new long[1] ;
      P027G2_A88ImpLiqSec = new short[1] ;
      P027G2_A1EmpCod = new short[1] ;
      P027G2_A3CliCod = new int[1] ;
      P027G2_A1771ImpLiqLSDLegId = new String[] {""} ;
      P027G2_A1772ImpLiqLSDLegCBU = new String[] {""} ;
      P027G2_A1773ImpLiqLSDLegDiasLiq = new short[1] ;
      P027G2_A1774ImpLiqLSDLegFecPag = new java.util.Date[] {GXutil.nullDate()} ;
      P027G2_A1775ImpLiqLSDLegCony = new boolean[] {false} ;
      P027G2_A1776ImpLiqLSDLegHijos = new byte[1] ;
      P027G2_A2193ImpLiqLSDDepRev = new String[] {""} ;
      P027G2_A2194ImpLiqLSDForPag = new String[] {""} ;
      A1771ImpLiqLSDLegId = "" ;
      A1772ImpLiqLSDLegCBU = "" ;
      A1774ImpLiqLSDLegFecPag = GXutil.nullDate() ;
      A2193ImpLiqLSDDepRev = "" ;
      A2194ImpLiqLSDForPag = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.grabaliqleglsd__default(),
         new Object[] {
             new Object[] {
            P027G2_A1770ImpLiqLSDCuil, P027G2_A88ImpLiqSec, P027G2_A1EmpCod, P027G2_A3CliCod, P027G2_A1771ImpLiqLSDLegId, P027G2_A1772ImpLiqLSDLegCBU, P027G2_A1773ImpLiqLSDLegDiasLiq, P027G2_A1774ImpLiqLSDLegFecPag, P027G2_A1775ImpLiqLSDLegCony, P027G2_A1776ImpLiqLSDLegHijos,
            P027G2_A2193ImpLiqLSDDepRev, P027G2_A2194ImpLiqLSDForPag
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV22Pgmname = "grabaLiqLegLSD" ;
      /* GeneXus formulas. */
      AV22Pgmname = "grabaLiqLegLSD" ;
      Gx_err = (short)(0) ;
   }

   private byte AV13ImpLiqLSDLegHijos ;
   private byte AV23GXLvl4 ;
   private byte A1776ImpLiqLSDLegHijos ;
   private short AV9EmpCod ;
   private short AV15ImpLiqSec ;
   private short AV16ImpLiqLSDLegDiasLiq ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A1773ImpLiqLSDLegDiasLiq ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int GX_INS277 ;
   private long AV10ImpLiqLSDCuil ;
   private long A1770ImpLiqLSDCuil ;
   private String AV14ImpLiqLSDLegId ;
   private String AV11ImpLiqLSDLegCBU ;
   private String AV18ImpLiqLSDDepRev ;
   private String AV19ImpLiqLSDForPag ;
   private String AV22Pgmname ;
   private String scmdbuf ;
   private String A1771ImpLiqLSDLegId ;
   private String A1772ImpLiqLSDLegCBU ;
   private String A2193ImpLiqLSDDepRev ;
   private String A2194ImpLiqLSDForPag ;
   private String Gx_emsg ;
   private java.util.Date AV17ImpLiqLSDLegFecPag ;
   private java.util.Date A1774ImpLiqLSDLegFecPag ;
   private boolean AV12ImpLiqLSDLegCony ;
   private boolean A1775ImpLiqLSDLegCony ;
   private IDataStoreProvider pr_default ;
   private long[] P027G2_A1770ImpLiqLSDCuil ;
   private short[] P027G2_A88ImpLiqSec ;
   private short[] P027G2_A1EmpCod ;
   private int[] P027G2_A3CliCod ;
   private String[] P027G2_A1771ImpLiqLSDLegId ;
   private String[] P027G2_A1772ImpLiqLSDLegCBU ;
   private short[] P027G2_A1773ImpLiqLSDLegDiasLiq ;
   private java.util.Date[] P027G2_A1774ImpLiqLSDLegFecPag ;
   private boolean[] P027G2_A1775ImpLiqLSDLegCony ;
   private byte[] P027G2_A1776ImpLiqLSDLegHijos ;
   private String[] P027G2_A2193ImpLiqLSDDepRev ;
   private String[] P027G2_A2194ImpLiqLSDForPag ;
}

final  class grabaliqleglsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027G2", "SELECT ImpLiqLSDCuil, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDLegId, ImpLiqLSDLegCBU, ImpLiqLSDLegDiasLiq, ImpLiqLSDLegFecPag, ImpLiqLSDLegCony, ImpLiqLSDLegHijos, ImpLiqLSDDepRev, ImpLiqLSDForPag FROM importacion_liquidacion_lsd_legajos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDCuil = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDCuil  FOR UPDATE OF importacion_liquidacion_lsd_legajos",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P027G3", "SAVEPOINT gxupdate;UPDATE importacion_liquidacion_lsd_legajos SET ImpLiqLSDLegId=?, ImpLiqLSDLegCBU=?, ImpLiqLSDLegDiasLiq=?, ImpLiqLSDLegFecPag=?, ImpLiqLSDLegCony=?, ImpLiqLSDLegHijos=?, ImpLiqLSDDepRev=?, ImpLiqLSDForPag=?  WHERE CliCod = ? AND EmpCod = ? AND ImpLiqSec = ? AND ImpLiqLSDCuil = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P027G4", "SAVEPOINT gxupdate;INSERT INTO importacion_liquidacion_lsd_legajos(CliCod, EmpCod, ImpLiqSec, ImpLiqLSDCuil, ImpLiqLSDLegId, ImpLiqLSDLegCBU, ImpLiqLSDLegDiasLiq, ImpLiqLSDLegFecPag, ImpLiqLSDLegCony, ImpLiqLSDLegHijos, ImpLiqLSDDepRev, ImpLiqLSDForPag) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((long[]) buf[0])[0] = rslt.getLong(1);
               ((short[]) buf[1])[0] = rslt.getShort(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               ((int[]) buf[3])[0] = rslt.getInt(4);
               ((String[]) buf[4])[0] = rslt.getString(5, 10);
               ((String[]) buf[5])[0] = rslt.getString(6, 22);
               ((short[]) buf[6])[0] = rslt.getShort(7);
               ((java.util.Date[]) buf[7])[0] = rslt.getGXDate(8);
               ((boolean[]) buf[8])[0] = rslt.getBoolean(9);
               ((byte[]) buf[9])[0] = rslt.getByte(10);
               ((String[]) buf[10])[0] = rslt.getString(11, 50);
               ((String[]) buf[11])[0] = rslt.getString(12, 1);
               return;
      }
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 10);
               stmt.setString(2, (String)parms[1], 22);
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setDate(4, (java.util.Date)parms[3]);
               stmt.setBoolean(5, ((Boolean) parms[4]).booleanValue());
               stmt.setByte(6, ((Number) parms[5]).byteValue());
               stmt.setString(7, (String)parms[6], 50);
               stmt.setString(8, (String)parms[7], 1);
               stmt.setInt(9, ((Number) parms[8]).intValue());
               stmt.setShort(10, ((Number) parms[9]).shortValue());
               stmt.setShort(11, ((Number) parms[10]).shortValue());
               stmt.setLong(12, ((Number) parms[11]).longValue());
               return;
            case 2 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setShort(3, ((Number) parms[2]).shortValue());
               stmt.setLong(4, ((Number) parms[3]).longValue());
               stmt.setString(5, (String)parms[4], 10);
               stmt.setString(6, (String)parms[5], 22);
               stmt.setShort(7, ((Number) parms[6]).shortValue());
               stmt.setDate(8, (java.util.Date)parms[7]);
               stmt.setBoolean(9, ((Boolean) parms[8]).booleanValue());
               stmt.setByte(10, ((Number) parms[9]).byteValue());
               stmt.setString(11, (String)parms[10], 50);
               stmt.setString(12, (String)parms[11], 1);
               return;
      }
   }

}

