package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getempresacondicionafip extends GXProcedure
{
   public getempresacondicionafip( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getempresacondicionafip.class ), "" );
   }

   public getempresacondicionafip( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 )
   {
      getempresacondicionafip.this.aP2 = new short[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        short[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             short[] aP2 )
   {
      getempresacondicionafip.this.AV8CliCod = aP0;
      getempresacondicionafip.this.AV9EmpCod = aP1;
      getempresacondicionafip.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P028V2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P028V2_A1EmpCod[0] ;
         A3CliCod = P028V2_A3CliCod[0] ;
         A2265EmpCondiCod = P028V2_A2265EmpCondiCod[0] ;
         AV11EmpCondiCod = A2265EmpCondiCod ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getempresacondicionafip.this.AV11EmpCondiCod;
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
      P028V2_A1EmpCod = new short[1] ;
      P028V2_A3CliCod = new int[1] ;
      P028V2_A2265EmpCondiCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getempresacondicionafip__default(),
         new Object[] {
             new Object[] {
            P028V2_A1EmpCod, P028V2_A3CliCod, P028V2_A2265EmpCondiCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV11EmpCondiCod ;
   private short A1EmpCod ;
   private short A2265EmpCondiCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P028V2_A1EmpCod ;
   private int[] P028V2_A3CliCod ;
   private short[] P028V2_A2265EmpCondiCod ;
}

final  class getempresacondicionafip__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P028V2", "SELECT EmpCod, CliCod, EmpCondiCod FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
      }
   }

}

