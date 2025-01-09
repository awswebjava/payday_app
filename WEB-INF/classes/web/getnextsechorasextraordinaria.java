package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getnextsechorasextraordinaria extends GXProcedure
{
   public getnextsechorasextraordinaria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getnextsechorasextraordinaria.class ), "" );
   }

   public getnextsechorasextraordinaria( int remoteHandle ,
                                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( int aP0 ,
                            short aP1 )
   {
      getnextsechorasextraordinaria.this.aP2 = new short[] {0};
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
      getnextsechorasextraordinaria.this.AV8CliCod = aP0;
      getnextsechorasextraordinaria.this.AV9EmpCod = aP1;
      getnextsechorasextraordinaria.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01R82 */
      pr_default.execute(0, new Object[] {Integer.valueOf(AV8CliCod), Short.valueOf(AV9EmpCod)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A3CliCod = P01R82_A3CliCod[0] ;
         A1EmpCod = P01R82_A1EmpCod[0] ;
         A1340EmpHsExSec = P01R82_A1340EmpHsExSec[0] ;
         AV10EmpHsExSec = A1340EmpHsExSec ;
         pr_default.readNext(0);
      }
      pr_default.close(0);
      AV10EmpHsExSec = (short)(AV10EmpHsExSec+1) ;
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = getnextsechorasextraordinaria.this.AV10EmpHsExSec;
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
      P01R82_A3CliCod = new int[1] ;
      P01R82_A1EmpCod = new short[1] ;
      P01R82_A1340EmpHsExSec = new short[1] ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getnextsechorasextraordinaria__default(),
         new Object[] {
             new Object[] {
            P01R82_A3CliCod, P01R82_A1EmpCod, P01R82_A1340EmpHsExSec
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9EmpCod ;
   private short AV10EmpHsExSec ;
   private short A1EmpCod ;
   private short A1340EmpHsExSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int A3CliCod ;
   private String scmdbuf ;
   private short[] aP2 ;
   private IDataStoreProvider pr_default ;
   private int[] P01R82_A3CliCod ;
   private short[] P01R82_A1EmpCod ;
   private short[] P01R82_A1340EmpHsExSec ;
}

final  class getnextsechorasextraordinaria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01R82", "SELECT CliCod, EmpCod, EmpHsExSec FROM Empresahorasextras_pordia WHERE CliCod = ? and EmpCod = ? ORDER BY CliCod, EmpCod, EmpHsExSec DESC ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,100, GxCacheFrequency.OFF,false )
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

