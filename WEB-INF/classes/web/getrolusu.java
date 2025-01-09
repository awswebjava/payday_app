package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getrolusu extends GXProcedure
{
   public getrolusu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getrolusu.class ), "" );
   }

   public getrolusu( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public byte executeUdp( short aP0 )
   {
      getrolusu.this.aP1 = new byte[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( short aP0 ,
                        byte[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( short aP0 ,
                             byte[] aP1 )
   {
      getrolusu.this.AV8SecUserId = aP0;
      getrolusu.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02BK2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8SecUserId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A67SecUserId = P02BK2_A67SecUserId[0] ;
         A1923RolId = P02BK2_A1923RolId[0] ;
         n1923RolId = P02BK2_n1923RolId[0] ;
         AV9RolId = A1923RolId ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getrolusu.this.AV9RolId;
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
      P02BK2_A67SecUserId = new short[1] ;
      P02BK2_A1923RolId = new byte[1] ;
      P02BK2_n1923RolId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getrolusu__default(),
         new Object[] {
             new Object[] {
            P02BK2_A67SecUserId, P02BK2_A1923RolId, P02BK2_n1923RolId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9RolId ;
   private byte A1923RolId ;
   private short AV8SecUserId ;
   private short A67SecUserId ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean n1923RolId ;
   private byte[] aP1 ;
   private IDataStoreProvider pr_default ;
   private short[] P02BK2_A67SecUserId ;
   private byte[] P02BK2_A1923RolId ;
   private boolean[] P02BK2_n1923RolId ;
}

final  class getrolusu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02BK2", "SELECT SecUserId, RolId FROM SecUser WHERE SecUserId = ? ORDER BY SecUserId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[1])[0] = rslt.getByte(2);
               ((boolean[]) buf[2])[0] = rslt.wasNull();
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               return;
      }
   }

}

