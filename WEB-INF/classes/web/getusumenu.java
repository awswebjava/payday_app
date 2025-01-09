package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getusumenu extends GXProcedure
{
   public getusumenu( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getusumenu.class ), "" );
   }

   public getusumenu( int remoteHandle ,
                      ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public long executeUdp( short aP0 ,
                           byte[] aP1 ,
                           byte[] aP2 )
   {
      getusumenu.this.aP3 = new long[] {0};
      execute_int(aP0, aP1, aP2, aP3);
      return aP3[0];
   }

   public void execute( short aP0 ,
                        byte[] aP1 ,
                        byte[] aP2 ,
                        long[] aP3 )
   {
      execute_int(aP0, aP1, aP2, aP3);
   }

   private void execute_int( short aP0 ,
                             byte[] aP1 ,
                             byte[] aP2 ,
                             long[] aP3 )
   {
      getusumenu.this.AV8SecUserId = aP0;
      getusumenu.this.aP1 = aP1;
      getusumenu.this.aP2 = aP2;
      getusumenu.this.aP3 = aP3;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01UQ2 */
      pr_default.execute(0, new Object[] {Short.valueOf(AV8SecUserId)});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A67SecUserId = P01UQ2_A67SecUserId[0] ;
         A1923RolId = P01UQ2_A1923RolId[0] ;
         n1923RolId = P01UQ2_n1923RolId[0] ;
         A1925PerfilId = P01UQ2_A1925PerfilId[0] ;
         n1925PerfilId = P01UQ2_n1925PerfilId[0] ;
         A1928MenuVerId = P01UQ2_A1928MenuVerId[0] ;
         n1928MenuVerId = P01UQ2_n1928MenuVerId[0] ;
         AV9RolId = A1923RolId ;
         AV11PerfilId = A1925PerfilId ;
         AV10MenuVerId = A1928MenuVerId ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getusumenu.this.AV9RolId;
      this.aP2[0] = getusumenu.this.AV11PerfilId;
      this.aP3[0] = getusumenu.this.AV10MenuVerId;
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
      P01UQ2_A67SecUserId = new short[1] ;
      P01UQ2_A1923RolId = new byte[1] ;
      P01UQ2_n1923RolId = new boolean[] {false} ;
      P01UQ2_A1925PerfilId = new byte[1] ;
      P01UQ2_n1925PerfilId = new boolean[] {false} ;
      P01UQ2_A1928MenuVerId = new long[1] ;
      P01UQ2_n1928MenuVerId = new boolean[] {false} ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getusumenu__default(),
         new Object[] {
             new Object[] {
            P01UQ2_A67SecUserId, P01UQ2_A1923RolId, P01UQ2_n1923RolId, P01UQ2_A1925PerfilId, P01UQ2_n1925PerfilId, P01UQ2_A1928MenuVerId, P01UQ2_n1928MenuVerId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9RolId ;
   private byte AV11PerfilId ;
   private byte A1923RolId ;
   private byte A1925PerfilId ;
   private short AV8SecUserId ;
   private short A67SecUserId ;
   private short Gx_err ;
   private long AV10MenuVerId ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private boolean n1923RolId ;
   private boolean n1925PerfilId ;
   private boolean n1928MenuVerId ;
   private long[] aP3 ;
   private byte[] aP1 ;
   private byte[] aP2 ;
   private IDataStoreProvider pr_default ;
   private short[] P01UQ2_A67SecUserId ;
   private byte[] P01UQ2_A1923RolId ;
   private boolean[] P01UQ2_n1923RolId ;
   private byte[] P01UQ2_A1925PerfilId ;
   private boolean[] P01UQ2_n1925PerfilId ;
   private long[] P01UQ2_A1928MenuVerId ;
   private boolean[] P01UQ2_n1928MenuVerId ;
}

final  class getusumenu__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UQ2", "SELECT SecUserId, RolId, PerfilId, MenuVerId FROM SecUser WHERE SecUserId = ? ORDER BY SecUserId ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               ((byte[]) buf[3])[0] = rslt.getByte(3);
               ((boolean[]) buf[4])[0] = rslt.wasNull();
               ((long[]) buf[5])[0] = rslt.getLong(4);
               ((boolean[]) buf[6])[0] = rslt.wasNull();
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

