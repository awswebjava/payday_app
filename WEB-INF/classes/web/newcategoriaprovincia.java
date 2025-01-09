package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcategoriaprovincia extends GXProcedure
{
   public newcategoriaprovincia( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcategoriaprovincia.class ), "" );
   }

   public newcategoriaprovincia( int remoteHandle ,
                                 ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        short aP4 ,
                        short aP5 ,
                        int aP6 ,
                        String aP7 ,
                        String aP8 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             short aP4 ,
                             short aP5 ,
                             int aP6 ,
                             String aP7 ,
                             String aP8 )
   {
      newcategoriaprovincia.this.AV13CliCod = aP0;
      newcategoriaprovincia.this.AV12CliPaiConve = aP1;
      newcategoriaprovincia.this.AV11CliConvenio = aP2;
      newcategoriaprovincia.this.AV10CatCodigo = aP3;
      newcategoriaprovincia.this.AV9CatPaiCod = aP4;
      newcategoriaprovincia.this.AV8CatProvCod = aP5;
      newcategoriaprovincia.this.AV14CatProvRelSec = aP6;
      newcategoriaprovincia.this.AV15CatProvRelRef = aP7;
      newcategoriaprovincia.this.AV16CatProvOld = aP8;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CliCod: ", "")+GXutil.trim( GXutil.str( AV13CliCod, 6, 0))) ;
      /*
         INSERT RECORD ON TABLE CategoriaProvincias

      */
      A3CliCod = AV13CliCod ;
      A1564CliPaiConve = AV12CliPaiConve ;
      A1565CliConvenio = AV11CliConvenio ;
      A8CatCodigo = AV10CatCodigo ;
      A2200CatPaiCod = AV9CatPaiCod ;
      A2201CatProvCod = AV8CatProvCod ;
      A2202CatProvRelSec = AV14CatProvRelSec ;
      n2202CatProvRelSec = false ;
      A2203CatProvRelRef = AV15CatProvRelRef ;
      n2203CatProvRelRef = false ;
      A2204CatProvOld = AV16CatProvOld ;
      n2204CatProvOld = false ;
      /* Using cursor P02852 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, Short.valueOf(A2200CatPaiCod), Short.valueOf(A2201CatProvCod), Boolean.valueOf(n2202CatProvRelSec), Integer.valueOf(A2202CatProvRelSec), Boolean.valueOf(n2203CatProvRelRef), A2203CatProvRelRef, Boolean.valueOf(n2204CatProvOld), A2204CatProvOld});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("CategoriaProvincias");
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
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CliPaiConve: ", "")+GXutil.trim( GXutil.str( AV12CliPaiConve, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CliConvenio: ", "")+GXutil.trim( AV11CliConvenio)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CatCodigo: ", "")+GXutil.trim( AV10CatCodigo)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CatPaiCod: ", "")+GXutil.trim( GXutil.str( AV9CatPaiCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CatProvCod: ", "")+GXutil.trim( GXutil.str( AV8CatProvCod, 4, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CatProvRelSec: ", "")+GXutil.trim( GXutil.str( AV14CatProvRelSec, 6, 0))) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CatProvRelRef: ", "")+GXutil.trim( AV15CatProvRelRef)) ;
      new web.msgdebug_prod(remoteHandle, context).execute( AV19Pgmname, httpContext.getMessage( "&CatProvOld: ", "")+GXutil.trim( AV16CatProvOld)) ;
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
      AV19Pgmname = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A2203CatProvRelRef = "" ;
      A2204CatProvOld = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcategoriaprovincia__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV19Pgmname = "newCategoriaProvincia" ;
      /* GeneXus formulas. */
      AV19Pgmname = "newCategoriaProvincia" ;
      Gx_err = (short)(0) ;
   }

   private short AV12CliPaiConve ;
   private short AV9CatPaiCod ;
   private short AV8CatProvCod ;
   private short A1564CliPaiConve ;
   private short A2200CatPaiCod ;
   private short A2201CatProvCod ;
   private short Gx_err ;
   private int AV13CliCod ;
   private int AV14CatProvRelSec ;
   private int GX_INS274 ;
   private int A3CliCod ;
   private int A2202CatProvRelSec ;
   private String AV11CliConvenio ;
   private String AV10CatCodigo ;
   private String AV19Pgmname ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String Gx_emsg ;
   private boolean n2202CatProvRelSec ;
   private boolean n2203CatProvRelRef ;
   private boolean n2204CatProvOld ;
   private String AV16CatProvOld ;
   private String A2204CatProvOld ;
   private String AV15CatProvRelRef ;
   private String A2203CatProvRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newcategoriaprovincia__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P02852", "SAVEPOINT gxupdate;INSERT INTO CategoriaProvincias(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatPaiCod, CatProvCod, CatProvRelSec, CatProvRelRef, CatProvOld) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setShort(2, ((Number) parms[1]).shortValue());
               stmt.setString(3, (String)parms[2], 20);
               stmt.setString(4, (String)parms[3], 40);
               stmt.setShort(5, ((Number) parms[4]).shortValue());
               stmt.setShort(6, ((Number) parms[5]).shortValue());
               if ( ((Boolean) parms[6]).booleanValue() )
               {
                  stmt.setNull( 7 , Types.NUMERIC );
               }
               else
               {
                  stmt.setInt(7, ((Number) parms[7]).intValue());
               }
               if ( ((Boolean) parms[8]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.VARCHAR );
               }
               else
               {
                  stmt.setVarchar(8, (String)parms[9], 40);
               }
               if ( ((Boolean) parms[10]).booleanValue() )
               {
                  stmt.setNull( 9 , Types.LONGVARCHAR );
               }
               else
               {
                  stmt.setNLongVarchar(9, (String)parms[11]);
               }
               return;
      }
   }

}

