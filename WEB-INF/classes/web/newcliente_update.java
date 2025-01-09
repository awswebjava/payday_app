package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcliente_update extends GXProcedure
{
   public newcliente_update( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcliente_update.class ), "" );
   }

   public newcliente_update( int remoteHandle ,
                             ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        int aP1 ,
                        int aP2 ,
                        String aP3 ,
                        java.util.Date aP4 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4);
   }

   private void execute_int( int aP0 ,
                             int aP1 ,
                             int aP2 ,
                             String aP3 ,
                             java.util.Date aP4 )
   {
      newcliente_update.this.AV11hijo_CliCod = aP0;
      newcliente_update.this.AV10CliUpdRelSec = aP1;
      newcliente_update.this.AV8CliCod = aP2;
      newcliente_update.this.AV9CliUpdRelDesc = aP3;
      newcliente_update.this.AV12CliUpdDTApl = aP4;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      GXv_dtime1[0] = AV13CliUpdFecRel ;
      new web.getreleasedatetime(remoteHandle, context).execute( AV8CliCod, AV10CliUpdRelSec, GXv_dtime1) ;
      newcliente_update.this.AV13CliUpdFecRel = GXv_dtime1[0] ;
      /*
         INSERT RECORD ON TABLE Cliente_Update

      */
      A3CliCod = AV11hijo_CliCod ;
      A1887CliUpdRelSec = AV10CliUpdRelSec ;
      A1883CliUpdDTApl = AV12CliUpdDTApl ;
      A1881CliUpdCliCod = AV8CliCod ;
      A1884CliUpdRelDesc = AV9CliUpdRelDesc ;
      A1962CliUpdFecRel = AV13CliUpdFecRel ;
      A1963CliUpdNotificado = false ;
      /* Using cursor P01WU2 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Integer.valueOf(A1881CliUpdCliCod), Integer.valueOf(A1887CliUpdRelSec), A1883CliUpdDTApl, A1884CliUpdRelDesc, A1962CliUpdFecRel, Boolean.valueOf(A1963CliUpdNotificado)});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Cliente_Update");
      if ( (pr_default.getStatus(0) == 1) )
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
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "newcliente_update");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV13CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      GXv_dtime1 = new java.util.Date[1] ;
      A1883CliUpdDTApl = GXutil.resetTime( GXutil.nullDate() );
      A1884CliUpdRelDesc = "" ;
      A1962CliUpdFecRel = GXutil.resetTime( GXutil.nullDate() );
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcliente_update__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int AV11hijo_CliCod ;
   private int AV10CliUpdRelSec ;
   private int AV8CliCod ;
   private int GX_INS252 ;
   private int A3CliCod ;
   private int A1887CliUpdRelSec ;
   private int A1881CliUpdCliCod ;
   private String Gx_emsg ;
   private java.util.Date AV12CliUpdDTApl ;
   private java.util.Date AV13CliUpdFecRel ;
   private java.util.Date GXv_dtime1[] ;
   private java.util.Date A1883CliUpdDTApl ;
   private java.util.Date A1962CliUpdFecRel ;
   private boolean A1963CliUpdNotificado ;
   private String AV9CliUpdRelDesc ;
   private String A1884CliUpdRelDesc ;
   private IDataStoreProvider pr_default ;
}

final  class newcliente_update__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01WU2", "SAVEPOINT gxupdate;INSERT INTO Cliente_Update(CliCod, CliUpdCliCod, CliUpdRelSec, CliUpdDTApl, CliUpdRelDesc, CliUpdFecRel, CliUpdNotificado) VALUES(?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
      };
   }

   public void getResults( int cursor ,
                           IFieldGetter rslt ,
                           Object[] buf ) throws SQLException
   {
   }

   public void setParameters( int cursor ,
                              IFieldSetter stmt ,
                              Object[] parms ) throws SQLException
   {
      switch ( cursor )
      {
            case 0 :
               stmt.setInt(1, ((Number) parms[0]).intValue());
               stmt.setInt(2, ((Number) parms[1]).intValue());
               stmt.setInt(3, ((Number) parms[2]).intValue());
               stmt.setDateTime(4, (java.util.Date)parms[3], false);
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setDateTime(6, (java.util.Date)parms[5], false);
               stmt.setBoolean(7, ((Boolean) parms[6]).booleanValue());
               return;
      }
   }

}

