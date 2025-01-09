package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getmenuitemporopc extends GXProcedure
{
   public getmenuitemporopc( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getmenuitemporopc.class ), "" );
   }

   public getmenuitemporopc( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 )
   {
      getmenuitemporopc.this.aP4 = new String[] {""};
      execute_int(aP0, aP1, aP2, aP3, aP4);
      return aP4[0];
   }

   public void execute( byte aP0 ,
                        byte aP1 ,
                        long aP2 ,
                        String aP3 ,
                        String[] aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 ,
                             String[] aP4 )
   {
      getmenuitemporopc.this.AV9RolId = aP0;
      getmenuitemporopc.this.AV11PerfilId = aP1;
      getmenuitemporopc.this.AV10MenuVerId = aP2;
      getmenuitemporopc.this.AV12MenuOpcCod = aP3;
      getmenuitemporopc.this.aP4 = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P01UR2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV9RolId), Byte.valueOf(AV11PerfilId), Long.valueOf(AV10MenuVerId), AV12MenuOpcCod});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A1929MenuOpcCod = P01UR2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P01UR2_A1928MenuVerId[0] ;
         A1925PerfilId = P01UR2_A1925PerfilId[0] ;
         A1923RolId = P01UR2_A1923RolId[0] ;
         A1937MenuItemId = P01UR2_A1937MenuItemId[0] ;
         AV8MenuItemId = A1937MenuItemId ;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP4[0] = getmenuitemporopc.this.AV8MenuItemId;
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8MenuItemId = "" ;
      scmdbuf = "" ;
      P01UR2_A1929MenuOpcCod = new String[] {""} ;
      P01UR2_A1928MenuVerId = new long[1] ;
      P01UR2_A1925PerfilId = new byte[1] ;
      P01UR2_A1923RolId = new byte[1] ;
      P01UR2_A1937MenuItemId = new String[] {""} ;
      A1929MenuOpcCod = "" ;
      A1937MenuItemId = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getmenuitemporopc__default(),
         new Object[] {
             new Object[] {
            P01UR2_A1929MenuOpcCod, P01UR2_A1928MenuVerId, P01UR2_A1925PerfilId, P01UR2_A1923RolId, P01UR2_A1937MenuItemId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV9RolId ;
   private byte AV11PerfilId ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short Gx_err ;
   private long AV10MenuVerId ;
   private long A1928MenuVerId ;
   private String scmdbuf ;
   private String AV12MenuOpcCod ;
   private String AV8MenuItemId ;
   private String A1929MenuOpcCod ;
   private String A1937MenuItemId ;
   private String[] aP4 ;
   private IDataStoreProvider pr_default ;
   private String[] P01UR2_A1929MenuOpcCod ;
   private long[] P01UR2_A1928MenuVerId ;
   private byte[] P01UR2_A1925PerfilId ;
   private byte[] P01UR2_A1923RolId ;
   private String[] P01UR2_A1937MenuItemId ;
}

final  class getmenuitemporopc__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P01UR2", "SELECT MenuOpcCod, MenuVerId, PerfilId, RolId, MenuItemId FROM MenuVersionesOpciones WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod ",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getVarchar(1);
               ((long[]) buf[1])[0] = rslt.getLong(2);
               ((byte[]) buf[2])[0] = rslt.getByte(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((String[]) buf[4])[0] = rslt.getVarchar(5);
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
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100);
               return;
      }
   }

}

