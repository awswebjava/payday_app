package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getliqestdeplsd extends GXProcedure
{
   public getliqestdeplsd( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getliqestdeplsd.class ), "" );
   }

   public getliqestdeplsd( int remoteHandle ,
                           ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 ,
                           int aP2 )
   {
      getliqestdeplsd.this.aP3 = new byte[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        int aP2 ,
                        byte[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             int aP2 ,
                             byte[] aP3 )
   {
      getliqestdeplsd.this.AV8CliCod = aP0;
      getliqestdeplsd.this.AV9EmpCod = aP1;
      getliqestdeplsd.this.AV11LiqNro = aP2;
      getliqestdeplsd.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV14GXLvl2 = (byte)(0) ;
      /* Using cursor P02IR2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod), Integer.valueOf(AV11LiqNro)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A31LiqNro = P02IR2_A31LiqNro[0] ;
         A1EmpCod = P02IR2_A1EmpCod[0] ;
         A3CliCod = P02IR2_A3CliCod[0] ;
         A2292LiqLSDDepEst = P02IR2_A2292LiqLSDDepEst[0] ;
         AV14GXLvl2 = (byte)(1) ;
         AV10LiqLSDDepEst = A2292LiqLSDDepEst ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV14GXLvl2 == 0 )
      {
         new web.msgdebug_prod2(remoteHandle, context).execute( AV8CliCod, AV15Pgmname, httpContext.getMessage( "none", "")) ;
      }
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP3[0] = getliqestdeplsd.this.AV10LiqLSDDepEst;
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
      P02IR2_A31LiqNro = new int[1] ;
      P02IR2_A1EmpCod = new short[1] ;
      P02IR2_A3CliCod = new int[1] ;
      P02IR2_A2292LiqLSDDepEst = new byte[1] ;
      AV15Pgmname = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getliqestdeplsd__default(),
         new Object[] {
             new Object[] {
            P02IR2_A31LiqNro, P02IR2_A1EmpCod, P02IR2_A3CliCod, P02IR2_A2292LiqLSDDepEst
            }
         }
      );
      AV15Pgmname = "getLiqEstDepLSD" ;
      /* GeneXus formulas. */
      AV15Pgmname = "getLiqEstDepLSD" ;
      Gx_err = (short)(0) ;
   }

   private byte AV10LiqLSDDepEst ;
   private byte AV14GXLvl2 ;
   private byte A2292LiqLSDDepEst ;
   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int AV11LiqNro ;
   private int A31LiqNro ;
   private int A3CliCod ;
   private String scmdbuf ;
   private String AV15Pgmname ;
   private byte[] aP3 ;
   private IDataStoreProvider pr_default ;
   private int[] P02IR2_A31LiqNro ;
   private short[] P02IR2_A1EmpCod ;
   private int[] P02IR2_A3CliCod ;
   private byte[] P02IR2_A2292LiqLSDDepEst ;
}

final  class getliqestdeplsd__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02IR2", "SELECT LiqNro, EmpCod, CliCod, LiqLSDDepEst FROM Liquidacion WHERE CliCod = ? and EmpCod = ? and LiqNro = ? ORDER BY CliCod, EmpCod, LiqNro ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[3])[0] = rslt.getByte(4);
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
               stmt.setInt(3, ((Number) parms[2]).intValue());
               return;
      }
   }

}

