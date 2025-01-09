package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextemp extends GXProcedure
{
   public getnextemp( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextemp.class ), "" );
   }

   public getnextemp( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 )
   {
      getnextemp.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( int aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( int aP0 ,
                             short[] aP1 )
   {
      getnextemp.this.AV8CliCod = aP0;
      getnextemp.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00142 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P00142_A3CliCod[0] ;
         A1EmpCod = P00142_A1EmpCod[0] ;
         AV9EmpCod = A1EmpCod ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV9EmpCod = (short)(AV9EmpCod+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getnextemp.this.AV9EmpCod;
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
      P00142_A3CliCod = new int[1] ;
      P00142_A1EmpCod = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextemp__default(),
         new Object[] {
             new Object[] {
            P00142_A3CliCod, P00142_A1EmpCod
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short A1EmpCod ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private int[] P00142_A3CliCod ;
   private short[] P00142_A1EmpCod ;
}

final  class getnextemp__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00142", "SELECT CliCod, EmpCod FROM Empresa WHERE CliCod = ? ORDER BY CliCod, EmpCod DESC  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               return;
      }
   }

}

