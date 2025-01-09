package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class ini_religion_y_origenes extends GXProcedure
{
   public ini_religion_y_origenes( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( ini_religion_y_origenes.class ), "" );
   }

   public ini_religion_y_origenes( int remoteHandle ,
                                   ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( )
   {
      execute_int();
   }

   private void execute_int( )
   {
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV4Pgmname, "2") ;
      /*
         INSERT RECORD ON TABLE Religion

      */
      A1229ReligId = httpContext.getMessage( "cristianismo", "") ;
      A1283ReligNombre = httpContext.getMessage( "Cristianismo", "") ;
      /* Using cursor P01HQ2 */
      pr_default.execute(0, new Object[] {A1229ReligId, A1283ReligNombre});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Religion");
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV4Pgmname, "3") ;
      /*
         INSERT RECORD ON TABLE Religion

      */
      A1229ReligId = httpContext.getMessage( "judaísmo", "") ;
      A1283ReligNombre = httpContext.getMessage( "Judaísmo", "") ;
      /* Using cursor P01HQ3 */
      pr_default.execute(1, new Object[] {A1229ReligId, A1283ReligNombre});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Religion");
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV4Pgmname, "4") ;
      /*
         INSERT RECORD ON TABLE Religion

      */
      A1229ReligId = httpContext.getMessage( "musulman", "") ;
      A1283ReligNombre = httpContext.getMessage( "Musulmán", "") ;
      /* Using cursor P01HQ4 */
      pr_default.execute(2, new Object[] {A1229ReligId, A1283ReligNombre});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Religion");
      if ( (pr_default.getStatus(2) == 1) )
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV4Pgmname, "5") ;
      /*
         INSERT RECORD ON TABLE Origen

      */
      A1231OrigId = httpContext.getMessage( "armenia", "") ;
      A1284OrigNombre = httpContext.getMessage( "Armenia", "") ;
      /* Using cursor P01HQ5 */
      pr_default.execute(3, new Object[] {A1231OrigId, A1284OrigNombre});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Origen");
      if ( (pr_default.getStatus(3) == 1) )
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV4Pgmname, "6") ;
      cleanup();
   }

   protected void cleanup( )
   {
      Application.commitDataStores(context, remoteHandle, pr_default, "ini_religion_y_origenes");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV4Pgmname = "" ;
      A1229ReligId = "" ;
      A1283ReligNombre = "" ;
      Gx_emsg = "" ;
      A1231OrigId = "" ;
      A1284OrigNombre = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.ini_religion_y_origenes__default(),
         new Object[] {
             new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
            , new Object[] {
            }
         }
      );
      AV4Pgmname = "ini_religion_y_origenes" ;
      /* GeneXus formulas. */
      AV4Pgmname = "ini_religion_y_origenes" ;
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int GX_INS149 ;
   private int GX_INS151 ;
   private String AV4Pgmname ;
   private String A1229ReligId ;
   private String Gx_emsg ;
   private String A1231OrigId ;
   private String A1283ReligNombre ;
   private String A1284OrigNombre ;
   private IDataStoreProvider pr_default ;
}

final  class ini_religion_y_origenes__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01HQ2", "SAVEPOINT gxupdate;INSERT INTO Religion(ReligId, ReligNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HQ3", "SAVEPOINT gxupdate;INSERT INTO Religion(ReligId, ReligNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HQ4", "SAVEPOINT gxupdate;INSERT INTO Religion(ReligId, ReligNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
         ,new UpdateCursor("P01HQ5", "SAVEPOINT gxupdate;INSERT INTO Origen(OrigId, OrigNombre) VALUES(?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 1 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 2 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
            case 3 :
               stmt.setString(1, (String)parms[0], 20);
               stmt.setVarchar(2, (String)parms[1], 30, false);
               return;
      }
   }

}

