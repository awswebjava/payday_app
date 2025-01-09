package web ;
import web.*;
import java.sql.*;
import com.genexus.db.*;
import com.genexus.*;
import com.genexus.search.*;

public final  class newcategoria extends GXProcedure
{
   public newcategoria( int remoteHandle )
   {
      super( remoteHandle , new ModelContext( newcategoria.class ), "" );
   }

   public newcategoria( int remoteHandle ,
                        ModelContext context )
   {
      super( remoteHandle , context, "" );
   }

   public void execute( int aP0 ,
                        short aP1 ,
                        String aP2 ,
                        String aP3 ,
                        String aP4 ,
                        byte aP5 ,
                        short aP6 ,
                        byte aP7 ,
                        String aP8 ,
                        String aP9 )
   {
      execute_int(aP0, aP1, aP2, aP3, aP4, aP5, aP6, aP7, aP8, aP9);
   }

   private void execute_int( int aP0 ,
                             short aP1 ,
                             String aP2 ,
                             String aP3 ,
                             String aP4 ,
                             byte aP5 ,
                             short aP6 ,
                             byte aP7 ,
                             String aP8 ,
                             String aP9 )
   {
      newcategoria.this.AV8CliCod = aP0;
      newcategoria.this.AV9CliPaiConve = aP1;
      newcategoria.this.AV10CliConvenio = aP2;
      newcategoria.this.AV11CatCodigo = aP3;
      newcategoria.this.AV12CatDescrip = aP4;
      newcategoria.this.AV14CatClase = aP5;
      newcategoria.this.AV15CatRelSec = aP6;
      newcategoria.this.AV16CatFrecAct = aP7;
      newcategoria.this.AV17CatAfipCod = aP8;
      newcategoria.this.AV18CatTipoTarifa = aP9;
      initialize();
      /* GeneXus formulas */
      /* Output device settings */
      privateExecute();
   }

   private void privateExecute( )
   {
      new web.msgdebug_prod(remoteHandle, context).execute( AV21Pgmname, httpContext.getMessage( "&CatAfipCod ", "")+AV17CatAfipCod) ;
      /*
         INSERT RECORD ON TABLE Categoria1

      */
      A3CliCod = AV8CliCod ;
      A1564CliPaiConve = AV9CliPaiConve ;
      A1565CliConvenio = AV10CliConvenio ;
      A8CatCodigo = AV11CatCodigo ;
      A123CatDescrip = AV12CatDescrip ;
      GXt_char1 = AV13CatDescripSinAc ;
      GXv_char2[0] = GXt_char1 ;
      new web.sacaracentos2(remoteHandle, context).execute( AV12CatDescrip, GXv_char2) ;
      newcategoria.this.GXt_char1 = GXv_char2[0] ;
      AV13CatDescripSinAc = GXt_char1 ;
      A676CatDescripSinAc = GXutil.upper( AV13CatDescripSinAc) ;
      A1838CatClase = AV14CatClase ;
      A1894CatRelSec = AV15CatRelSec ;
      n1894CatRelSec = false ;
      A1914CatFrecAct = AV16CatFrecAct ;
      A2040CatRelRef = "" ;
      A2041CatOld = "" ;
      A2198CatAfipCod = AV17CatAfipCod ;
      n2198CatAfipCod = false ;
      A2416CatTipoTarifa = AV18CatTipoTarifa ;
      /* Using cursor P01T72 */
      pr_default.execute(0, new Object[] {Integer.valueOf(A3CliCod), Short.valueOf(A1564CliPaiConve), A1565CliConvenio, A8CatCodigo, A123CatDescrip, A676CatDescripSinAc, Byte.valueOf(A1838CatClase), Boolean.valueOf(n1894CatRelSec), Short.valueOf(A1894CatRelSec), Byte.valueOf(A1914CatFrecAct), A2040CatRelRef, A2041CatOld, Boolean.valueOf(n2198CatAfipCod), A2198CatAfipCod, A2416CatTipoTarifa});
      Application.getSmartCacheProvider(remoteHandle).setUpdated("Categoria1");
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
      Application.commitDataStores(context, remoteHandle, pr_default, "newcategoria");
      CloseOpenCursors();
      exitApp();
   }

   protected void CloseOpenCursors( )
   {
   }

   /* Aggregate/select formulas */
   public void initialize( )
   {
      AV21Pgmname = "" ;
      A1565CliConvenio = "" ;
      A8CatCodigo = "" ;
      A123CatDescrip = "" ;
      AV13CatDescripSinAc = "" ;
      GXt_char1 = "" ;
      GXv_char2 = new String[1] ;
      A676CatDescripSinAc = "" ;
      A2040CatRelRef = "" ;
      A2041CatOld = "" ;
      A2198CatAfipCod = "" ;
      A2416CatTipoTarifa = "" ;
      Gx_emsg = "" ;
      pr_default = new DataStoreProvider(context, remoteHandle, new web.newcategoria__default(),
         new Object[] {
             new Object[] {
            }
         }
      );
      AV21Pgmname = "newCategoria" ;
      /* GeneXus formulas. */
      AV21Pgmname = "newCategoria" ;
      Gx_err = (short)(0) ;
   }

   private byte AV14CatClase ;
   private byte AV16CatFrecAct ;
   private byte A1838CatClase ;
   private byte A1914CatFrecAct ;
   private short AV9CliPaiConve ;
   private short AV15CatRelSec ;
   private short A1564CliPaiConve ;
   private short A1894CatRelSec ;
   private short Gx_err ;
   private int AV8CliCod ;
   private int GX_INS205 ;
   private int A3CliCod ;
   private String AV10CliConvenio ;
   private String AV11CatCodigo ;
   private String AV17CatAfipCod ;
   private String AV18CatTipoTarifa ;
   private String AV21Pgmname ;
   private String A1565CliConvenio ;
   private String A8CatCodigo ;
   private String GXt_char1 ;
   private String GXv_char2[] ;
   private String A2198CatAfipCod ;
   private String A2416CatTipoTarifa ;
   private String Gx_emsg ;
   private boolean n1894CatRelSec ;
   private boolean n2198CatAfipCod ;
   private String A2041CatOld ;
   private String AV12CatDescrip ;
   private String A123CatDescrip ;
   private String AV13CatDescripSinAc ;
   private String A676CatDescripSinAc ;
   private String A2040CatRelRef ;
   private IDataStoreProvider pr_default ;
}

final  class newcategoria__default extends DataStoreHelperBase implements ILocalDataStoreHelper
{
   public Cursor[] getCursors( )
   {
      return new Cursor[] {
          new UpdateCursor("P01T72", "SAVEPOINT gxupdate;INSERT INTO Categoria1(CliCod, CliPaiConve, CliConvenio, CatCodigo, CatDescrip, CatDescripSinAc, CatClase, CatRelSec, CatFrecAct, CatRelRef, CatOld, CatAfipCod, CatTipoTarifa) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);RELEASE SAVEPOINT gxupdate", GX_ROLLBACKSAVEPOINT + GX_NOMASK + GX_MASKLOOPLOCK)
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
               stmt.setVarchar(5, (String)parms[4], 400, false);
               stmt.setVarchar(6, (String)parms[5], 400, false);
               stmt.setByte(7, ((Number) parms[6]).byteValue());
               if ( ((Boolean) parms[7]).booleanValue() )
               {
                  stmt.setNull( 8 , Types.NUMERIC );
               }
               else
               {
                  stmt.setShort(8, ((Number) parms[8]).shortValue());
               }
               stmt.setByte(9, ((Number) parms[9]).byteValue());
               stmt.setVarchar(10, (String)parms[10], 40, false);
               stmt.setNLongVarchar(11, (String)parms[11], false);
               if ( ((Boolean) parms[12]).booleanValue() )
               {
                  stmt.setNull( 12 , Types.VARCHAR );
               }
               else
               {
                  stmt.setString(12, (String)parms[13], 6);
               }
               stmt.setString(13, (String)parms[14], 1);
               return;
      }
   }

}

