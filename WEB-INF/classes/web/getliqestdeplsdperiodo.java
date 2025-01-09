package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqestdeplsdperiodo extends GXProcedure
{
   public getliqestdeplsdperiodo( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqestdeplsdperiodo.class ), "" );
   }

   public getliqestdeplsdperiodo( int remoteHandle ,
                                  ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           java.util.Date aP2 )
   {
      getliqestdeplsdperiodo.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        java.util.Date aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             java.util.Date aP2 ,
                             byte[] aP3 )
   {
      getliqestdeplsdperiodo.this.AV8CliCod = aP0;
      getliqestdeplsdperiodo.this.AV9EmpCod = aP1;
      getliqestdeplsdperiodo.this.AV12LiqPeriodo = aP2;
      getliqestdeplsdperiodo.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl2 = (byte)(0) ;
      /* Using cursor P02J22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), AV12LiqPeriodo});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P02J22_A3CliCod[0] ;
         A1EmpCod = P02J22_A1EmpCod[0] ;
         A283LiqPeriodo = P02J22_A283LiqPeriodo[0] ;
         A2292LiqLSDDepEst = P02J22_A2292LiqLSDDepEst[0] ;
         A31LiqNro = P02J22_A31LiqNro[0] ;
         AV15GXLvl2 = (byte)(1) ;
         AV10LiqLSDDepEst = A2292LiqLSDDepEst ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      if ( AV15GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV16Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqestdeplsdperiodo.this.AV10LiqLSDDepEst;
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
      P02J22_A3CliCod = new int[1] ;
      P02J22_A1EmpCod = new short[1] ;
      P02J22_A283LiqPeriodo = new java.util.Date[] {GXutil.nullDate()} ;
      P02J22_A2292LiqLSDDepEst = new byte[1] ;
      P02J22_A31LiqNro = new int[1] ;
      A283LiqPeriodo = GXutil.nullDate() ;
      AV16Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqestdeplsdperiodo__default(),
         new Object[] {
             new Object[] {
            P02J22_A3CliCod, P02J22_A1EmpCod, P02J22_A283LiqPeriodo, P02J22_A2292LiqLSDDepEst, P02J22_A31LiqNro
            }
         }
      );
      AV16Pgmname = "getLiqEstDepLSDPeriodo" ;
      /* GeneXus formulas. */
      AV16Pgmname = "getLiqEstDepLSDPeriodo" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqLSDDepEst ;
   private byte AV15GXLvl2 ;
   private byte A2292LiqLSDDepEst ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private int A31LiqNro ;
   private String scmdbuf ;
   private String AV16Pgmname ;
   private java.util.Date AV12LiqPeriodo ;
   private java.util.Date A283LiqPeriodo ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02J22_A3CliCod ;
   private short[] P02J22_A1EmpCod ;
   private java.util.Date[] P02J22_A283LiqPeriodo ;
   private byte[] P02J22_A2292LiqLSDDepEst ;
   private int[] P02J22_A31LiqNro ;
}

final  class getliqestdeplsdperiodo__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02J22", "SELECT CliCod, EmpCod, LiqPeriodo, LiqLSDDepEst, LiqNro FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqPeriodo = ? ORDER BY CliCod, EmpCod, LiqPeriodo, LiqLSDDepEst  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((java.util.Date[]) buf[2])[0] = rslt.getGXDate(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((int[]) buf[4])[0] = rslt.getInt(5);
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
               stmt.setDate(3, (java.util.Date)parms[2]);
               return;
      }
   }

}

