package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newopcpermiso extends GXProcedure
{
   public newopcpermiso( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newopcpermiso.class ), "" );
   }

   public newopcpermiso( int remoteHandle ,
                         ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( byte aP0 ,
                        byte aP1 ,
                        long aP2 ,
                        String aP3 ,
                        String aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( byte aP0 ,
                             byte aP1 ,
                             long aP2 ,
                             String aP3 ,
                             String aP4 )
   {
      newopcpermiso.this.AV11RolId = aP0;
      newopcpermiso.this.AV10PerfilId = aP1;
      newopcpermiso.this.AV9MenuVerId = aP2;
      newopcpermiso.this.AV12MenuOpcCod = aP3;
      newopcpermiso.this.AV8MenuOpcAcc = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV15GXLvl1 = (byte)(0) ;
      /* Using cursor P02GA2 */
      pr_default.execute(0, new Object[] {Byte.valueOf(AV11RolId), Byte.valueOf(AV10PerfilId), Long.valueOf(AV9MenuVerId), AV12MenuOpcCod, AV8MenuOpcAcc});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A2365MenuOpcAcc = P02GA2_A2365MenuOpcAcc[0] ;
         A1929MenuOpcCod = P02GA2_A1929MenuOpcCod[0] ;
         A1928MenuVerId = P02GA2_A1928MenuVerId[0] ;
         A1925PerfilId = P02GA2_A1925PerfilId[0] ;
         A1923RolId = P02GA2_A1923RolId[0] ;
         AV15GXLvl1 = (byte)(1) ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      if ( AV15GXLvl1 == 0 )
      {
         /*
            INSERT RECORD ON TABLE MenuVerOpcPermisos

         */
         A1923RolId = AV11RolId ;
         A1925PerfilId = AV10PerfilId ;
         A1928MenuVerId = AV9MenuVerId ;
         A1929MenuOpcCod = AV12MenuOpcCod ;
         A2365MenuOpcAcc = AV8MenuOpcAcc ;
         /* Using cursor P02GA3 */
         pr_default.execute(1, new Object[] {Byte.valueOf(A1923RolId), Byte.valueOf(A1925PerfilId), Long.valueOf(A1928MenuVerId), A1929MenuOpcCod, A2365MenuOpcAcc});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("MenuVerOpcPermisos");
         if ( (pr_default.getStatus(1) == 1) )
         {
            Gx_err = (short)(1) ;
            Gx_emsg = localUtil.getMessages().getMessage("GXM_noupdate") ;
         }
         else
         {
            Gx_err = (short)(0) ;
            Gx_emsg = "" ;
         }
         /* End Insert */
      }
      cleanup();
   }

   protected void cleanup( )
   {
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
      P02GA2_A2365MenuOpcAcc = new String[] {""} ;
      P02GA2_A1929MenuOpcCod = new String[] {""} ;
      P02GA2_A1928MenuVerId = new long[1] ;
      P02GA2_A1925PerfilId = new byte[1] ;
      P02GA2_A1923RolId = new byte[1] ;
      A2365MenuOpcAcc = "" ;
      A1929MenuOpcCod = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newopcpermiso__default(),
         new Object[] {
             new Object[] {
            P02GA2_A2365MenuOpcAcc, P02GA2_A1929MenuOpcCod, P02GA2_A1928MenuVerId, P02GA2_A1925PerfilId, P02GA2_A1923RolId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private byte AV11RolId ;
   private byte AV10PerfilId ;
   private byte AV15GXLvl1 ;
   private byte A1925PerfilId ;
   private byte A1923RolId ;
   private short Gx_err ;
   private int GX_INS294 ;
   private long AV9MenuVerId ;
   private long A1928MenuVerId ;
   private String AV8MenuOpcAcc ;
   private String scmdbuf ;
   private String A2365MenuOpcAcc ;
   private String Gx_emsg ;
   private String AV12MenuOpcCod ;
   private String A1929MenuOpcCod ;
   private IDataStoreProvider pr_default ;
   private String[] P02GA2_A2365MenuOpcAcc ;
   private String[] P02GA2_A1929MenuOpcCod ;
   private long[] P02GA2_A1928MenuVerId ;
   private byte[] P02GA2_A1925PerfilId ;
   private byte[] P02GA2_A1923RolId ;
}

final  class newopcpermiso__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02GA2", "SELECT MenuOpcAcc, MenuOpcCod, MenuVerId, PerfilId, RolId FROM MenuVerOpcPermisos WHERE RolId = ? and PerfilId = ? and MenuVerId = ? and MenuOpcCod = ( ?) and MenuOpcAcc = ( ?) ORDER BY RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcAcc  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P02GA3", "SAVEPOINT gxupdate;INSERT INTO MenuVerOpcPermisos(RolId, PerfilId, MenuVerId, MenuOpcCod, MenuOpcAcc) VALUES(?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               ((String[]) buf[0])[0] = rslt.getString(1, 20);
               ((String[]) buf[1])[0] = rslt.getVarchar(2);
               ((long[]) buf[2])[0] = rslt.getLong(3);
               ((byte[]) buf[3])[0] = rslt.getByte(4);
               ((byte[]) buf[4])[0] = rslt.getByte(5);
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
               stmt.setString(5, (String)parms[4], 20);
               return;
            case 1 :
               stmt.setByte(1, ((Number) parms[0]).byteValue());
               stmt.setByte(2, ((Number) parms[1]).byteValue());
               stmt.setLong(3, ((Number) parms[2]).longValue());
               stmt.setVarchar(4, (String)parms[3], 100, false);
               stmt.setString(5, (String)parms[4], 20);
               return;
      }
   }

}

