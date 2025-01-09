package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class inipropiedadesadicionales extends GXProcedure
{
   public inipropiedadesadicionales( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( inipropiedadesadicionales.class ), "" );
   }

   public inipropiedadesadicionales( int remoteHandle ,
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
      /*
         INSERT RECORD ON TABLE propiedades_adicionales

      */
      A2227propCod = httpContext.getMessage( "ES_DE_POZO", "") ;
      A2228propDesc = httpContext.getMessage( "Es personal de pozo", "") ;
      A2229propTipoDato = "BOOL" ;
      /* Using cursor P024Y2 */
      pr_default.execute(0, new Object[] {A2227propCod, A2228propDesc, A2229propTipoDato});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("propiedades_adicionales");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "inipropiedadesadicionales");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A2227propCod = "" ;
      A2228propDesc = "" ;
      A2229propTipoDato = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.inipropiedadesadicionales__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short Gx_err ;
   private int GX_INS281 ;
   private String A2227propCod ;
   private String A2229propTipoDato ;
   private String Gx_emsg ;
   private String A2228propDesc ;
   private IDataStoreProvider pr_default ;
}

final  class inipropiedadesadicionales__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P024Y2", "SAVEPOINT gxupdate;INSERT INTO propiedades_adicionales(propCod, propDesc, propTipoDato) VALUES(?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(2, (String)parms[1], 400, false);
               stmt.setString(3, (String)parms[2], 20);
               return;
      }
   }

}

