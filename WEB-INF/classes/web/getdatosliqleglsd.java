package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getdatosliqleglsd extends GXProcedure
{
   public getdatosliqleglsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getdatosliqleglsd.class ), "" );
   }

   public getdatosliqleglsd( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public web.Sdtsdt_LiqLegLSD executeUdp( int aP0 ,
                                           short aP1 ,
                                           short aP2 ,
                                           long aP3 )
   {
      getdatosliqleglsd.this.aP4 = new web.Sdtsdt_LiqLegLSD[] {new web.Sdtsdt_LiqLegLSD()};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short aP2 ,
                        long aP3 ,
                        web.Sdtsdt_LiqLegLSD[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short aP2 ,
                             long aP3 ,
                             web.Sdtsdt_LiqLegLSD[] aP4 )
   {
      getdatosliqleglsd.this.AV8CliCod = aP0;
      getdatosliqleglsd.this.AV9EmpCod = aP1;
      getdatosliqleglsd.this.AV12ImpLiqSec = aP2;
      getdatosliqleglsd.this.AV10ImpLiqLSDCuil = aP3;
      getdatosliqleglsd.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P027Y2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Short.valueOf(AV12ImpLiqSec), Long.valueOf(AV10ImpLiqLSDCuil)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1770ImpLiqLSDCuil = P027Y2_A1770ImpLiqLSDCuil[0] ;
         A88ImpLiqSec = P027Y2_A88ImpLiqSec[0] ;
         A1EmpCod = P027Y2_A1EmpCod[0] ;
         A3CliCod = P027Y2_A3CliCod[0] ;
         A1771ImpLiqLSDLegId = P027Y2_A1771ImpLiqLSDLegId[0] ;
         A1772ImpLiqLSDLegCBU = P027Y2_A1772ImpLiqLSDLegCBU[0] ;
         A1773ImpLiqLSDLegDiasLiq = P027Y2_A1773ImpLiqLSDLegDiasLiq[0] ;
         A1774ImpLiqLSDLegFecPag = P027Y2_A1774ImpLiqLSDLegFecPag[0] ;
         A1775ImpLiqLSDLegCony = P027Y2_A1775ImpLiqLSDLegCony[0] ;
         A1776ImpLiqLSDLegHijos = P027Y2_A1776ImpLiqLSDLegHijos[0] ;
         A2193ImpLiqLSDDepRev = P027Y2_A2193ImpLiqLSDDepRev[0] ;
         A2194ImpLiqLSDForPag = P027Y2_A2194ImpLiqLSDForPag[0] ;
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegid( A1771ImpLiqLSDLegId );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcbu( A1772ImpLiqLSDLegCBU );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegdiasliq( A1773ImpLiqLSDLegDiasLiq );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegfecpag( A1774ImpLiqLSDLegFecPag );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdlegcony( A1775ImpLiqLSDLegCony );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdleghijos( A1776ImpLiqLSDLegHijos );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsddeprev( A2193ImpLiqLSDDepRev );
         AV11sdt_LiqLegLSD.setgxTv_Sdtsdt_LiqLegLSD_Impliqlsdforpag( A2194ImpLiqLSDForPag );
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getdatosliqleglsd.this.AV11sdt_LiqLegLSD;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV11sdt_LiqLegLSD = new web.Sdtsdt_LiqLegLSD(remoteHandle, context);
      scmdbuf = "" ;
      P027Y2_A1770ImpLiqLSDCuil = new long[1] ;
      P027Y2_A88ImpLiqSec = new short[1] ;
      P027Y2_A1EmpCod = new short[1] ;
      P027Y2_A3CliCod = new int[1] ;
      P027Y2_A1771ImpLiqLSDLegId = new String[] {""} ;
      P027Y2_A1772ImpLiqLSDLegCBU = new String[] {""} ;
      P027Y2_A1773ImpLiqLSDLegDiasLiq = new short[1] ;
      P027Y2_A1774ImpLiqLSDLegFecPag = new java.util.Date[] {GXutil.nullDate()} ;
      P027Y2_A1775ImpLiqLSDLegCony = new boolean[] {false} ;
      P027Y2_A1776ImpLiqLSDLegHijos = new byte[1] ;
      P027Y2_A2193ImpLiqLSDDepRev = new String[] {""} ;
      P027Y2_A2194ImpLiqLSDForPag = new String[] {""} ;
      A1771ImpLiqLSDLegId = "" ;
      A1772ImpLiqLSDLegCBU = "" ;
      A1774ImpLiqLSDLegFecPag = GXutil.nullDate() ;
      A2193ImpLiqLSDDepRev = "" ;
      A2194ImpLiqLSDForPag = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getdatosliqleglsd__default(),
         new Object[] {
             new Object[] {
            P027Y2_A1770ImpLiqLSDCuil, P027Y2_A88ImpLiqSec, P027Y2_A1EmpCod, P027Y2_A3CliCod, P027Y2_A1771ImpLiqLSDLegId, P027Y2_A1772ImpLiqLSDLegCBU, P027Y2_A1773ImpLiqLSDLegDiasLiq, P027Y2_A1774ImpLiqLSDLegFecPag, P027Y2_A1775ImpLiqLSDLegCony, P027Y2_A1776ImpLiqLSDLegHijos,
            P027Y2_A2193ImpLiqLSDDepRev, P027Y2_A2194ImpLiqLSDForPag
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte A1776ImpLiqLSDLegHijos ;
   private short AV9EmpCod ;
   private short AV12ImpLiqSec ;
   private short A88ImpLiqSec ;
   private short A1EmpCod ;
   private short A1773ImpLiqLSDLegDiasLiq ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private long AV10ImpLiqLSDCuil ;
   private long A1770ImpLiqLSDCuil ;
   private String scmdbuf ;
   private String A1771ImpLiqLSDLegId ;
   private String A1772ImpLiqLSDLegCBU ;
   private String A2193ImpLiqLSDDepRev ;
   private String A2194ImpLiqLSDForPag ;
   private java.util.Date A1774ImpLiqLSDLegFecPag ;
   private boolean A1775ImpLiqLSDLegCony ;
   private web.Sdtsdt_LiqLegLSD[] aP4 ;
   private IDataStoreProvider pr_default ;
   private long[] P027Y2_A1770ImpLiqLSDCuil ;
   private short[] P027Y2_A88ImpLiqSec ;
   private short[] P027Y2_A1EmpCod ;
   private int[] P027Y2_A3CliCod ;
   private String[] P027Y2_A1771ImpLiqLSDLegId ;
   private String[] P027Y2_A1772ImpLiqLSDLegCBU ;
   private short[] P027Y2_A1773ImpLiqLSDLegDiasLiq ;
   private java.util.Date[] P027Y2_A1774ImpLiqLSDLegFecPag ;
   private boolean[] P027Y2_A1775ImpLiqLSDLegCony ;
   private byte[] P027Y2_A1776ImpLiqLSDLegHijos ;
   private String[] P027Y2_A2193ImpLiqLSDDepRev ;
   private String[] P027Y2_A2194ImpLiqLSDForPag ;
   private web.Sdtsdt_LiqLegLSD AV11sdt_LiqLegLSD ;
}

final  class getdatosliqleglsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P027Y2", "SELECT ImpLiqLSDCuil, ImpLiqSec, EmpCod, CliCod, ImpLiqLSDLegId, ImpLiqLSDLegCBU, ImpLiqLSDLegDiasLiq, ImpLiqLSDLegFecPag, ImpLiqLSDLegCony, ImpLiqLSDLegHijos, ImpLiqLSDDepRev, ImpLiqLSDForPag FROM importacion_liquidacion_lsd_legajos WHERE CliCod = ? and EmpCod = ? and ImpLiqSec = ? and ImpLiqLSDCuil = ? ORDER BY CliCod, EmpCod, ImpLiqSec, ImpLiqLSDCuil ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

