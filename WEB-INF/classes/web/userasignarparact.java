package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class userasignarparact extends GXProcedure
{
   public userasignarparact( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( userasignarparact.class ), "" );
   }

   public userasignarparact( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 )
   {
      execute_int(aP0);
   }

   private void execute_int( short aP0 )
   {
      userasignarparact.this.AV9SecUserId = aP0;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      AV10yaexiste = true ;
      while ( AV10yaexiste )
      {
         AV8SecParAct = com.genexus.util.Encryption.getNewKey( ) ;
         AV10yaexiste = false ;
         /* Using cursor P00F22 */
         pr_default.execute(0, new Object[] {AV8SecParAct});
         while ( (pr_default.getStatus(0) != 101) )
         {
            A365SecParAct = P00F22_A365SecParAct[0] ;
            A67SecUserId = P00F22_A67SecUserId[0] ;
            AV10yaexiste = true ;
            /* Exit For each command. Update data (if necessary), close cursors & exit. */
            if (true) break;
            pr_default.readNext(0);
         }
         pr_default.close(0);
      }
      /* Optimized UPDATE. */
      /* Using cursor P00F23 */
      pr_default.execute(1, new Object[] {AV8SecParAct, Short.valueOf(AV9SecUserId)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("SecUser");
      /* End optimized UPDATE. */
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "userasignarparact");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV8SecParAct = "" ;
      scmdbuf = "" ;
      P00F22_A365SecParAct = new String[] {""} ;
      P00F22_A67SecUserId = new short[1] ;
      A365SecParAct = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.userasignarparact__default(),
         new Object[] {
             new Object[] {
            P00F22_A365SecParAct, P00F22_A67SecUserId
            }
            , new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV9SecUserId ;
   private short A67SecUserId ;
   private short Gx_err ;
   private String scmdbuf ;
   private boolean AV10yaexiste ;
   private String AV8SecParAct ;
   private String A365SecParAct ;
   private IDataStoreProvider pr_default ;
   private String[] P00F22_A365SecParAct ;
   private short[] P00F22_A67SecUserId ;
}

final  class userasignarparact__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P00F22", "SELECT SecParAct, SecUserId FROM SecUser WHERE SecParAct = ( ?) ORDER BY SecUserId  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
         ,new UpdateCursor("P00F23", "UPDATE SecUser SET SecParAct=?  WHERE SecUserId = ?", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(1, (String)parms[0], 40);
               return;
            case 1 :
               stmt.setVarchar(1, (String)parms[0], 40, false);
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               return;
      }
   }

}

