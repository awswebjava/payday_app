package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getemptipoexp extends GXProcedure
{
   public getemptipoexp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getemptipoexp.class ), "" );
   }

   public getemptipoexp( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( int aP0 ,
                           short aP1 )
   {
      getemptipoexp.this.aP2 = new byte[] {0};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        byte[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             byte[] aP2 )
   {
      getemptipoexp.this.AV10CliCod = aP0;
      getemptipoexp.this.AV8EmpCod = aP1;
      getemptipoexp.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01N22 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV10CliCod), Short.valueOf(AV8EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1EmpCod = P01N22_A1EmpCod[0] ;
         A3CliCod = P01N22_A3CliCod[0] ;
         A1792EmpTipoExp = P01N22_A1792EmpTipoExp[0] ;
         AV9EmpTipoExp = A1792EmpTipoExp ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getemptipoexp.this.AV9EmpTipoExp;
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
      P01N22_A1EmpCod = new short[1] ;
      P01N22_A3CliCod = new int[1] ;
      P01N22_A1792EmpTipoExp = new byte[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getemptipoexp__default(),
         new Object[] {
             new Object[] {
            P01N22_A1EmpCod, P01N22_A3CliCod, P01N22_A1792EmpTipoExp
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9EmpTipoExp ;
   private byte A1792EmpTipoExp ;
   private short AV8EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV10CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01N22_A1EmpCod ;
   private int[] P01N22_A3CliCod ;
   private byte[] P01N22_A1792EmpTipoExp ;
}

final  class getemptipoexp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01N22", "SELECT EmpCod, CliCod, EmpTipoExp FROM Empresa WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[2])[0] = rslt.getByte(3);
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

