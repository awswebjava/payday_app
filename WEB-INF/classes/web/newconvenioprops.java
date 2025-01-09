package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newconvenioprops extends GXProcedure
{
   public newconvenioprops( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newconvenioprops.class ), "" );
   }

   public newconvenioprops( int remoteHandle ,
                            ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( short aP0 ,
                        String aP1 ,
                        String aP2 )
   {
      execute_int(aP0, aP1, aP2);
   }

   private void execute_int( short aP0 ,
                             String aP1 ,
                             String aP2 )
   {
      newconvenioprops.this.AV8PaiCod = aP0;
      newconvenioprops.this.AV9ConveCodigo = aP1;
      newconvenioprops.this.AV10propCod = aP2;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      /*
         INSERT RECORD ON TABLE ConvenioPropiedadesAdicionales

      */
      A46PaiCod = AV8PaiCod ;
      A9ConveCodigo = AV9ConveCodigo ;
      A2227propCod = AV10propCod ;
      if ( GXutil.strcmp(A2227propCod, httpContext.getMessage( "ES_DE_POZO", "")) == 0 )
      {
         A2262ConvePropPredet = httpContext.getMessage( "true", "") ;
      }
      /* Using cursor P02522 */
      pr_default.execute(0, new Object[] {Short.valueOf(A46PaiCod), A9ConveCodigo, A2227propCod, A2262ConvePropPredet});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("ConvenioPropiedadesAdicionales");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newconvenioprops");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      A9ConveCodigo = "" ;
      A2227propCod = "" ;
      A2262ConvePropPredet = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newconvenioprops__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      /* GeneXus formulas. */
      Gx_err = (short)(0) ;
   }

   private short AV8PaiCod ;
   private short A46PaiCod ;
   private short Gx_err ;
   private int GX_INS275 ;
   private String AV9ConveCodigo ;
   private String AV10propCod ;
   private String A9ConveCodigo ;
   private String A2227propCod ;
   private String A2262ConvePropPredet ;
   private String Gx_emsg ;
   private IDataStoreProvider pr_default ;
}

final  class newconvenioprops__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02522", "SAVEPOINT gxupdate;INSERT INTO ConvenioPropiedadesAdicionales(PaiCod, ConveCodigo, propCod, ConvePropPredet) VALUES(?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(1, ((Number) parms[0]).shortValue());
               stmt.setString(2, (String)parms[1], 20);
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 20);
               return;
      }
   }

}

