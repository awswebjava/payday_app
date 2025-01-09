package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class getuserid extends GXProcedure
{
   public getuserid( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( getuserid.class ), "" );
   }

   public getuserid( int remoteHandle ,
                     ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   @SuppressWarnings("unchecked")
   public short executeUdp( String aP0 )
   {
      getuserid.this.aP1 = new short[] {0};
      execute_int(aP0, aP1);
      return aP1[0];
   }

   public void execute( String aP0 ,
                        short[] aP1 )
   {
      execute_int(aP0, aP1);
   }

   private void execute_int( String aP0 ,
                             short[] aP1 )
   {
      getuserid.this.AV9SecUserName = aP0;
      getuserid.this.aP1 = aP1;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /* Using cursor P02GD2 */
      pr_default.execute(0, new Object[] {AV9SecUserName});
      while ( (pr_default.getStatus(0) != 101) )
      {
         A68SecUserName = P02GD2_A68SecUserName[0] ;
         A67SecUserId = P02GD2_A67SecUserId[0] ;
         AV8SecUserId = A67SecUserId ;
         /* Exit For each command. Update data (if necessary), close cursors & exit. */
         if (true) break;
         /* Exiting from a For First loop. */
         if (true) break;
      }
      pr_default.close(0);
      cleanup();
   }

   protected void cleanup( )
   {
      this.aP1[0] = getuserid.this.AV8SecUserId;
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
      P02GD2_A68SecUserName = new String[] {""} ;
      P02GD2_A67SecUserId = new short[1] ;
      A68SecUserName = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.getuserid__default(),
         new Object[] {
             new Object[] {
            P02GD2_A68SecUserName, P02GD2_A67SecUserId
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8SecUserId ;
   private short A67SecUserId ;
   private short Gx_err ;
   private String scmdbuf ;
   private String AV9SecUserName ;
   private String A68SecUserName ;
   private short[] aP1 ;
   private IDataStoreProvider pr_default ;
   private String[] P02GD2_A68SecUserName ;
   private short[] P02GD2_A67SecUserId ;
}

final  class getuserid__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new ForEachCursor("P02GD2", "SELECT SecUserName, SecUserId FROM SecUser WHERE SecUserName = ( ?) ORDER BY SecUserName  LIMIT 1",false, GX_NOMASK + GX_MASKLOOPLOCK, false, this,1, GxCacheFrequency.OFF,true )
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
               stmt.setVarchar(1, (String)parms[0], 100);
               return;
      }
   }

}

