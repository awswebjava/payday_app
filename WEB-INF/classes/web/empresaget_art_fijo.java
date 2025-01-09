package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class empresaget_art_fijo extends GXProcedure
{
   public empresaget_art_fijo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( empresaget_art_fijo.class ), "" );
   }

   public empresaget_art_fijo( int remoteHandle ,
                               ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public java.math.BigDecimal executeUdp( int aP0 ,
                                           short aP1 ,
                                           java.util.Date aP2 )
   {
      empresaget_art_fijo.this.aP3 = new java.math.BigDecimal[] {DecimalUtil.ZERO};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        java.math.BigDecimal[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             java.math.BigDecimal[] aP3 )
   {
      empresaget_art_fijo.this.AV9CliCod = aP0;
      empresaget_art_fijo.this.AV10EmpCod = aP1;
      empresaget_art_fijo.this.AV12LiqPeriodo = aP2;
      empresaget_art_fijo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P019B2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV9CliCod), Short.valueOf(AV10EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P019B2_A1EmpCod[0] ;
         A3CliCod = P019B2_A3CliCod[0] ;
         A1151ARTSec = P019B2_A1151ARTSec[0] ;
         AV11ARTSec = A1151ARTSec ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      /* Using cursor P019B3 */
      pr_default.execute(1, new Object[] {Short.valueOf(AV11ARTSec), AV12LiqPeriodo});
      while ( (pr_default.getStatus(1) != 101) )
      {
         A1151ARTSec = P019B3_A1151ARTSec[0] ;
         A1156ARTImpFijFecha = P019B3_A1156ARTImpFijFecha[0] ;
         A1154ARTFijo = P019B3_A1154ARTFijo[0] ;
         A1155ARTImpFijSec = P019B3_A1155ARTImpFijSec[0] ;
         AV13ARTFijo = A1154ARTFijo ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(1);
      }
      pr_default.close(1);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = empresaget_art_fijo.this.AV13ARTFijo;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13ARTFijo = DecimalUtil.ZERO ;
      scmdbuf = "" ;
      P019B2_A1EmpCod = new short[1] ;
      P019B2_A3CliCod = new int[1] ;
      P019B2_A1151ARTSec = new short[1] ;
      P019B3_A1151ARTSec = new short[1] ;
      P019B3_A1156ARTImpFijFecha = new java.util.Date[] {GXutil.nullDate()} ;
      P019B3_A1154ARTFijo = new java.math.BigDecimal[] {DecimalUtil.ZERO} ;
      P019B3_A1155ARTImpFijSec = new short[1] ;
      A1156ARTImpFijFecha = GXutil.nullDate() ;
      A1154ARTFijo = DecimalUtil.ZERO ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.empresaget_art_fijo__default(),
         new Object[] {
             new Object[] {
            P019B2_A1EmpCod, P019B2_A3CliCod, P019B2_A1151ARTSec
            }
            , new Object[] {
            P019B3_A1151ARTSec, P019B3_A1156ARTImpFijFecha, P019B3_A1154ARTFijo, P019B3_A1155ARTImpFijSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV10EmpCod ;
   private short A1EmpCod ;
   private short A1151ARTSec ;
   private short AV11ARTSec ;
   private short A1155ARTImpFijSec ;
   private short Gx_err ;
   private int AV9CliCod ;
   private int A3CliCod ;
   private java.math.BigDecimal AV13ARTFijo ;
   private java.math.BigDecimal A1154ARTFijo ;
   private String scmdbuf ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A1156ARTImpFijFecha ;
   private java.math.BigDecimal[] aP3 ;
   private IDataStoreProvider pr_default ;
   private short[] P019B2_A1EmpCod ;
   private int[] P019B2_A3CliCod ;
   private short[] P019B2_A1151ARTSec ;
   private short[] P019B3_A1151ARTSec ;
   private java.util.Date[] P019B3_A1156ARTImpFijFecha ;
   private java.math.BigDecimal[] P019B3_A1154ARTFijo ;
   private short[] P019B3_A1155ARTImpFijSec ;
}

final  class empresaget_art_fijo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P019B2", "SELECT EmpCod, CliCod, ARTSec FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new ForEachCursor("P019B3", "SELECT ARTSec, ARTImpFijFecha, ARTFijo, ARTImpFijSec FROM ARTImportesFijos WHERE ARTSec = ? and ARTImpFijFecha <= ? ORDER BY ARTSec, ARTImpFijFecha DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((int[]) buf[1])[0] = rslt.getInt(2);
               ((short[]) buf[2])[0] = rslt.getShort(3);
               return;
            case 1 :
               ((short[]) buf[0])[0] = rslt.getShort(1);
               ((java.util.Date[]) buf[1])[0] = rslt.getGXDate(2);
               ((java.math.BigDecimal[]) buf[2])[0] = rslt.getBigDecimal(3,2);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               return;
            case 1 :
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setDate(2, (java.util.Date)parms[1]);
               return;
      }
   }

}

