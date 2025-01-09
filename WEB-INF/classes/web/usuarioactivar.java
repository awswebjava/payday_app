package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class usuarioactivar extends GXProcedure
{
   public usuarioactivar( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( usuarioactivar.class ), "" );
   }

   public usuarioactivar( int remoteHandle ,
                          ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public String executeUdp( String aP0 ,
                             boolean aP1 )
   {
      usuarioactivar.this.aP2 = new String[] {""};
      execute_int(aP0, aP1, aP2);
      return aP2[0];
   }

   public void execute( String aP0 ,
                        boolean aP1 ,
                        String[] aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( String aP0 ,
                             boolean aP1 ,
                             String[] aP2 )
   {
      usuarioactivar.this.AV8SecParAct = aP0;
      usuarioactivar.this.AV9SecUsuActivo = aP1;
      usuarioactivar.this.aP2 = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P00F12 */
      pr_default.execute(0, new Object[] {AV8SecParAct});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A365SecParAct = P00F12_A365SecParAct[0] ;
         A364SecUsuActivo = P00F12_A364SecUsuActivo[0] ;
         A68SecUserName = P00F12_A68SecUserName[0] ;
         A67SecUserId = P00F12_A67SecUserId[0] ;
         A364SecUsuActivo = AV9SecUsuActivo ;
         AV10SecUserName = A68SecUserName ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         /* Using cursor P00F13 */
         pr_default.execute(1, new Object[] {Boolean.valueOf(A364SecUsuActivo), Short.valueOf(A67SecUserId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
         if (true) break;
         /* Using cursor P00F14 */
         pr_default.execute(2, new Object[] {Boolean.valueOf(A364SecUsuActivo), Short.valueOf(A67SecUserId)});
         Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
         pr_default.readNext(0);
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP2[0] = usuarioactivar.this.AV10SecUserName;
      Application.commitDataStores(context, remoteHandle, pr_default, "usuarioactivar");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV10SecUserName = "" ;
      scmdbuf = "" ;
      P00F12_A365SecParAct = new String[] {""} ;
      P00F12_A364SecUsuActivo = new boolean[] {false} ;
      P00F12_A68SecUserName = new String[] {""} ;
      P00F12_A67SecUserId = new short[1] ;
      A365SecParAct = "" ;
      A68SecUserName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.usuarioactivar__default(),
         new Object[] {
             new Object[] {
            P00F12_A365SecParAct, P00F12_A364SecUsuActivo, P00F12_A68SecUserName, P00F12_A67SecUserId
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short A67SecUserId ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean AV9SecUsuActivo ;
   private boolean A364SecUsuActivo ;
   private String AV8SecParAct ;
   private String AV10SecUserName ;
   private String A365SecParAct ;
   private String A68SecUserName ;
   private String[] aP2 ;
   private IDataStoreProvider pr_default ;
   private String[] P00F12_A365SecParAct ;
   private boolean[] P00F12_A364SecUsuActivo ;
   private String[] P00F12_A68SecUserName ;
   private short[] P00F12_A67SecUserId ;
}

final  class usuarioactivar__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00F12", "SELECT SecParAct, SecUsuActivo, SecUserName, SecUserId FROM SecUser WHERE SecParAct = ( ?) ORDER BY SecUserId  LIMIT 1 FOR UPDATE OF SecUser",true, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00F13", "SAVEPOINT gxupdate;UPDATE SecUser SET SecUsuActivo=?  WHERE SecUserId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P00F14", "SAVEPOINT gxupdate;UPDATE SecUser SET SecUsuActivo=?  WHERE SecUserId = ?;RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               ((boolean[]) buf[1])[0] = rslt.getBoolean(2);
               ((String[]) buf[2])[0] = rslt.getVarchar(3);
               ((short[]) buf[3])[0] = rslt.getShort(4);
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
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
            case 1 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
            case 2 :
               stmt.setBoolean(1, ((Boolean) parms[0]).booleanValue());
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

